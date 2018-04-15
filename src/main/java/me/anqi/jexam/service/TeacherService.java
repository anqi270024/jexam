package me.anqi.jexam.service;

import me.anqi.jexam.entity.User;
import me.anqi.jexam.entity.auxiliary.PaperFront;

import java.util.List;

/**
 * @author flyleft
 * @date 2018/4/15
 */
public interface TeacherService {

    List<User> findAllStudents();

    List<User> findAllStudentsByTeacherId(long teacherId);

    void addStudent(long teacherId, long studentId);

    List<PaperFront> getPapersByTeacherId(long teacherId);

    void scorePaper(long paperId, long studentId, String scores);

}
