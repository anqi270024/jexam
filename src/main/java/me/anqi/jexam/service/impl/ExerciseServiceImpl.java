package me.anqi.jexam.service.impl;

import me.anqi.jexam.entity.Exercise;
import me.anqi.jexam.repository.ExerciseRepository;
import me.anqi.jexam.service.ExerciseService;
import me.anqi.jexam.utils.JexamBeanUtils;
import me.anqi.jexam.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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

    private ExerciseRepository exerciseRepository;

    @Autowired
    public ExerciseServiceImpl(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
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
}
