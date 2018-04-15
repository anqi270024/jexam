package me.anqi.jexam.service;

import me.anqi.jexam.entity.User;

import java.util.List;

/**
 * @author flyleft
 * @date 2018/4/15
 */
public interface TeacherService {

    List<User> findAllStudents();

    List<User> findAllStudentsByTeacherId(long teacherId);

    void addStudent(long teacherId, long studentId);

}
