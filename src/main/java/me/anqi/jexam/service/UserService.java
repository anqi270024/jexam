package me.anqi.jexam.service;

import me.anqi.jexam.entity.Exercise;
import me.anqi.jexam.entity.Paper;
import me.anqi.jexam.entity.User;
import me.anqi.jexam.entity.auxiliary.PaperFront;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Set;

public interface UserService {

    boolean login(User user, HttpServletRequest request);

    void register(User user);

    void addCollectionExercises(long userId, long exerciseId);

    Set<Exercise> getCollectionExercises(long userId);

    List<PaperFront> getPapersByStudentId(long studentId);

}
