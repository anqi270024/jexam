package me.anqi.jexam.service.impl;

import me.anqi.jexam.entity.*;
import me.anqi.jexam.entity.auxiliary.PaperFront;
import me.anqi.jexam.entity.auxiliary.UserAuxiliary;
import me.anqi.jexam.repository.*;
import me.anqi.jexam.service.UserService;
import me.anqi.jexam.utils.CommonUtils;
import me.anqi.jexam.utils.JsonUtils;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static me.anqi.jexam.entity.Exercise.TYPE_MULTI_CHOOSE;
import static me.anqi.jexam.entity.Exercise.TYPE_SINGLE_CHOOSE;

@Service
public class UserSerServiceImpl implements UserService {

    private UserRepository userRepository;

    private ExerciseRepository exerciseRepository;

    private TeacherStudentRepository teacherStudentRepository;

    private PaperRepository paperRepository;

    private SubjectRepository subjectRepository;

    private UserPaperAnswerRepository userPaperAnswerRepository;

    private UserPaperScoreRepository userPaperScoreRepository;

    public UserSerServiceImpl(UserRepository userRepository,
                              ExerciseRepository exerciseRepository,
                              TeacherStudentRepository teacherStudentRepository,
                              PaperRepository paperRepository,
                              SubjectRepository subjectRepository,
                              UserPaperAnswerRepository userPaperAnswerRepository,
                              UserPaperScoreRepository userPaperScoreRepository) {
        this.userRepository = userRepository;
        this.exerciseRepository = exerciseRepository;
        this.teacherStudentRepository = teacherStudentRepository;
        this.paperRepository = paperRepository;
        this.subjectRepository = subjectRepository;
        this.userPaperAnswerRepository = userPaperAnswerRepository;
        this.userPaperScoreRepository = userPaperScoreRepository;
    }

    @Override
    public boolean login(User user, HttpServletRequest request) {
        if (CommonUtils.isEmpty(user.getName(), user.getPassword())) {
            return false;
        }
        User getUser = userRepository.findUserByNameAndPasswordAndRole(user.getName(), user.getPassword(), user.getRole());
        if (getUser != null) {
            user.setPassword(null);
            HttpSession session = request.getSession(true);
            UserAuxiliary userAuxiliary = CommonUtils.User2Auxiliary(getUser);
            session.setAttribute("cur_user", userAuxiliary);
            session.setMaxInactiveInterval(600);
            return true;
        }
        return false;
    }

    @Override
    public void addCollectionExercises(long userId, long exerciseId) {
        User user = userRepository.findOne(userId);
        Exercise exercise = exerciseRepository.findOne(exerciseId);
        user.getExerciseCollection().add(exercise);
        userRepository.save(user);
    }

    @Override
    public void register(User user) {
        user.setAvatarUrl("/img/default.png");
        userRepository.save(user);
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
}
