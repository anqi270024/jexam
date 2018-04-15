package me.anqi.jexam.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import me.anqi.jexam.entity.*;
import me.anqi.jexam.entity.auxiliary.AnswerForm;
import me.anqi.jexam.entity.auxiliary.PaperFront;
import me.anqi.jexam.repository.*;
import me.anqi.jexam.service.StudentService;
import me.anqi.jexam.utils.JsonUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static me.anqi.jexam.entity.Exercise.TYPE_MULTI_CHOOSE;
import static me.anqi.jexam.entity.Exercise.TYPE_SINGLE_CHOOSE;

/**
 * @author flyleft
 * @date 2018/4/9
 */
@Service
public class StudentServiceImpl implements StudentService {

    private ExerciseRepository exerciseRepository;

    private TeacherStudentRepository teacherStudentRepository;

    private PaperRepository paperRepository;

    private SubjectRepository subjectRepository;

    private UserPaperAnswerRepository userPaperAnswerRepository;

    private UserPaperScoreRepository userPaperScoreRepository;

    private UserRepository userRepository;

    private ObjectMapper mapper = new ObjectMapper();

    public StudentServiceImpl(ExerciseRepository exerciseRepository,
                              TeacherStudentRepository teacherStudentRepository,
                              PaperRepository paperRepository,
                              SubjectRepository subjectRepository,
                              UserPaperAnswerRepository userPaperAnswerRepository,
                              UserPaperScoreRepository userPaperScoreRepository,
                              UserRepository userRepository) {
        this.exerciseRepository = exerciseRepository;
        this.teacherStudentRepository = teacherStudentRepository;
        this.paperRepository = paperRepository;
        this.subjectRepository = subjectRepository;
        this.userPaperAnswerRepository = userPaperAnswerRepository;
        this.userPaperScoreRepository = userPaperScoreRepository;
        this.userRepository = userRepository;
    }


    @Override
    public void answerPaper(long studentId, long paperId, String answer) {
        try {
            List<AnswerForm> answerFormList = mapper.readValue(answer, new TypeReference<List<AnswerForm>>(){});
            List<UserPaperAnswer> userPaperAnswers = new ArrayList<>(answerFormList.size());
            for (AnswerForm  answerForm : answerFormList) {
                UserPaperAnswer paperAnswer = new UserPaperAnswer();
                paperAnswer.setPaperId(paperId);
                paperAnswer.setUserId(studentId);
                paperAnswer.setExerciseId(Long.parseLong(answerForm.getId()));
                paperAnswer.setAnswer(answerForm.getValue());
                userPaperAnswers.add(paperAnswer);
            }
            userPaperAnswerRepository.save(userPaperAnswers);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Set<Exercise> getCollectionExercises(long userId) {
        Set<Exercise> exerciseSet = userRepository.findOne(userId).getExerciseCollection();
        for (Exercise exercise : exerciseSet) {
            if (TYPE_SINGLE_CHOOSE.equals(exercise.getType()) || TYPE_MULTI_CHOOSE.equals(exercise.getType())) {
                Map<Character, String> characterStringMap = JsonUtils.instance.readJsonToExeMap(exercise.getChooses());
                exercise.setChooseList(characterStringMap);
            }
        }
        return exerciseSet;
    }

    @Override
    public List<PaperFront> getPapersByStudentId(long studentId) {
        List<Paper> paperList = new ArrayList<>();
        List<TeacherStudent> teacherStudentList = teacherStudentRepository.findAllByStudentId(studentId);
        for (TeacherStudent teacherStudent : teacherStudentList) {
            paperList.addAll(paperRepository.findAllByOwnerId(teacherStudent.getTeacherId()));
        }
        List<PaperFront> paperFronts = new ArrayList<>();
        for (Paper paper : paperList) {
            PaperFront paperFront = new PaperFront();
            paperFront.setId(paper.getId());
            paperFront.setName(paper.getName());
            paperFront.setTeacher(userRepository.findOne(paper.getOwnerId()).getName());
            paperFront.setSubject(subjectRepository.findOne(paper.getSubjectId()).getName());
            UserPaperScore userPaperScore = userPaperScoreRepository.findByUserIdAndPaperId(studentId, paper.getId());
            if (userPaperScore != null) {
                paperFront.setType(3);
                paperFront.setScore(userPaperScore.getScore());
            } else if (userPaperAnswerRepository.existsByUserIdAndPaperId(studentId, paper.getId())) {
                paperFront.setType(2);
            } else {
                paperFront.setType(1);
            }
            paperFronts.add(paperFront);
        }
        return paperFronts;
    }

    @Override
    public void addCollectionExercises(long userId, long exerciseId) {
        User user = userRepository.findOne(userId);
        Exercise exercise = exerciseRepository.findOne(exerciseId);
        user.getExerciseCollection().add(exercise);
        userRepository.save(user);
    }

}
