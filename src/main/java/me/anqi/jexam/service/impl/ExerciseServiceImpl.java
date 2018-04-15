package me.anqi.jexam.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import me.anqi.jexam.entity.Exercise;
import me.anqi.jexam.entity.Paper;
import me.anqi.jexam.entity.UserPaperAnswer;
import me.anqi.jexam.entity.auxiliary.ExerciseForm;
import me.anqi.jexam.entity.auxiliary.ExerciseFront;
import me.anqi.jexam.exception.CommonException;
import me.anqi.jexam.repository.ExerciseRepository;
import me.anqi.jexam.repository.PaperRepository;
import me.anqi.jexam.repository.UserPaperAnswerRepository;
import me.anqi.jexam.service.ExerciseService;
import me.anqi.jexam.utils.CommonUtils;
import me.anqi.jexam.utils.JexamBeanUtils;
import me.anqi.jexam.utils.JsonUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static me.anqi.jexam.entity.Exercise.TYPE_MULTI_CHOOSE;
import static me.anqi.jexam.entity.Exercise.TYPE_SINGLE_CHOOSE;

/**
 * @author flyleft
 * @date 2018/4/8
 */
@Service
public class ExerciseServiceImpl implements ExerciseService {

    private ObjectMapper mapper = new ObjectMapper();

    private ExerciseRepository exerciseRepository;

    private UserPaperAnswerRepository userPaperAnswerRepository;

    public ExerciseServiceImpl(ExerciseRepository exerciseRepository, UserPaperAnswerRepository userPaperAnswerRepository) {
        this.exerciseRepository = exerciseRepository;
        this.userPaperAnswerRepository = userPaperAnswerRepository;
    }

    @Override
    public ExeFront getExeFront(String type, Long subjectId, Pageable pageable) {
        if (type != null) {
            return new ExeFront(exerciseRepository.findByType(type, pageable),
                    exerciseRepository.countExerciseByType(type));
        }
        if (subjectId != null) {
            return new ExeFront(exerciseRepository.findBySubjectId(subjectId, pageable),
                    exerciseRepository.countExerciseBySubjectId(subjectId));
        }
        return new ExeFront(exerciseRepository.findAll(pageable).getContent(),exerciseRepository.count());

    }


    @Override
    public Exercise getExercise(long exeId) {
        Exercise exercise = exerciseRepository.findOne(exeId);
        if (exercise!=null){
            JexamBeanUtils.setOneExeChooseList(exercise);
        }
        return exercise;
    }

    @Override
    public List<Exercise> getAllExercisesByPaperId(long paperId) {
        List<Exercise> exercises = exerciseRepository.findAllByPaperIdOrderByPosition(paperId);
        for (Exercise exercise: exercises) {
            if (TYPE_SINGLE_CHOOSE.equals(exercise.getType()) || TYPE_MULTI_CHOOSE.equals(exercise.getType())) {
                Map<Character, String> characterStringMap = JsonUtils.instance.readJsonToExeMap(exercise.getChooses());
                exercise.setChooseList(characterStringMap);
            }
        }
        return exercises;
    }

    @Override
    public void addExercise(ExerciseForm exerciseForm) {
        String type = exerciseForm.getType();
        int position = getPosition(exerciseForm.getPaperId());
        Exercise exercise = new Exercise();
        BeanUtils.copyProperties(exerciseForm, exercise);
        exercise.setPosition(position);
       if (TYPE_SINGLE_CHOOSE.equals(type) || TYPE_MULTI_CHOOSE.equals(type)) {
           if (StringUtils.isEmpty(exerciseForm.getA()) || StringUtils.isEmpty(exerciseForm.getB())){
               throw new CommonException("error.exercise.create.chooseList");
           }
           Map<Character, String> chooseMap = new HashMap<>(4);
           if (!StringUtils.isEmpty(exerciseForm.getA())) {
               chooseMap.put('A', exerciseForm.getA());
           }
           if (!StringUtils.isEmpty(exerciseForm.getB())) {
               chooseMap.put('B', exerciseForm.getB());
           }
           if (!StringUtils.isEmpty(exerciseForm.getC())) {
               chooseMap.put('C', exerciseForm.getC());
           }
           if (!StringUtils.isEmpty(exerciseForm.getD())) {
               chooseMap.put('D', exerciseForm.getD());
           }
           try {
               String chooseJson = mapper.writeValueAsString(chooseMap);
               exercise.setChooses(chooseJson);
           } catch (JsonProcessingException e) {
               throw new CommonException("error.exercise.create.json.serialize");
           }
       }
        exerciseRepository.save(exercise);
    }

    private int getPosition(long paperId) {
       List<Exercise> exercises = exerciseRepository.findAllByPaperIdOrderByPosition(paperId);
       if (exercises.isEmpty()) {
           return 1;
       }
       return exercises.get(exercises.size() - 1).getPosition() + 1;
    }


    @Override
    public ExerciseFront getAllByFrontType(String type, Pageable pageable) {
        Page<Exercise> exercisePage;
        long count;
        if (type.equals("all")) {
            exercisePage = exerciseRepository.findAll(pageable);
            count = exerciseRepository.count();
        }else if (CommonUtils.isNumeric(type)) {
            long subjectId = Long.parseLong(type);
            exercisePage = exerciseRepository.findAllBySubjectId(subjectId, pageable);
            count = exerciseRepository.countExerciseBySubjectId(subjectId);
        }else {
            exercisePage =  exerciseRepository.findAllByType(type, pageable);
            count = exerciseRepository.countByType(type);
        }
        for (Exercise exercise : exercisePage.getContent()) {
            if (TYPE_SINGLE_CHOOSE.equals(exercise.getType()) || TYPE_MULTI_CHOOSE.equals(exercise.getType())) {
                Map<Character, String> characterStringMap = JsonUtils.instance.readJsonToExeMap(exercise.getChooses());
                exercise.setChooseList(characterStringMap);
            }
        }
        return new ExerciseFront(exercisePage, count);
    }

    @Override
    public List<Exercise> getExercisesByPaperIdAndStudentId(long paperId, long studentId) {
        List<Exercise> exerciseList = exerciseRepository.findAllByPaperIdOrderByPosition(paperId);
        for (Exercise exercise : exerciseList) {
            exercise.setScore(exercise.getScore());
            UserPaperAnswer userPaperAnswer = userPaperAnswerRepository.findByUserIdAndExerciseId(studentId, exercise.getId());
            exercise.setStudentAnswer(userPaperAnswer.getAnswer());
            if (TYPE_SINGLE_CHOOSE.equals(exercise.getType()) || TYPE_MULTI_CHOOSE.equals(exercise.getType())) {
                Map<Character, String> characterStringMap = JsonUtils.instance.readJsonToExeMap(exercise.getChooses());
                exercise.setChooseList(characterStringMap);
            }
        }
        return exerciseList;
    }
}
