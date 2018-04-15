package me.anqi.jexam.service;

import me.anqi.jexam.entity.Exercise;
import me.anqi.jexam.entity.User;
import me.anqi.jexam.entity.auxiliary.PaperFront;

import java.util.List;
import java.util.Set;

/**
 * @author flyleft
 * @date 2018/4/9
 */
public interface StudentService {

     void addCollectionExercises(long userId, long exerciseId);

     Set<Exercise> getCollectionExercises(long userId);

     List<PaperFront> getPapersByStudentId(long studentId);

     void answerPaper(long studentId, long paperId, String answer);

}
