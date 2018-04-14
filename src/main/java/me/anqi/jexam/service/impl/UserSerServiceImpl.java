package me.anqi.jexam.service.impl;

import me.anqi.jexam.entity.Exercise;
import me.anqi.jexam.entity.User;
import me.anqi.jexam.entity.auxiliary.UserAuxiliary;
import me.anqi.jexam.repository.ExerciseRepository;
import me.anqi.jexam.repository.UserRepository;
import me.anqi.jexam.service.UserService;
import me.anqi.jexam.utils.CommonUtils;
import me.anqi.jexam.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;
import java.util.Set;

import static me.anqi.jexam.entity.Exercise.TYPE_MULTI_CHOOSE;
import static me.anqi.jexam.entity.Exercise.TYPE_SINGLE_CHOOSE;

@Service
public class UserSerServiceImpl implements UserService {

    private UserRepository userRepository;

    private ExerciseRepository exerciseRepository;


    @Autowired
    public UserSerServiceImpl(UserRepository userRepository,
                              ExerciseRepository exerciseRepository) {
        this.userRepository = userRepository;
        this.exerciseRepository = exerciseRepository;
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
}
