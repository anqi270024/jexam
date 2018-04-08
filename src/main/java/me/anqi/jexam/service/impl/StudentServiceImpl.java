package me.anqi.jexam.service.impl;

import me.anqi.jexam.entity.TeacherStudent;
import me.anqi.jexam.entity.User;
import me.anqi.jexam.repository.TeacherStudentRepository;
import me.anqi.jexam.repository.UserRepository;
import me.anqi.jexam.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author flyleft
 * @date 2018/4/9
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private TeacherStudentRepository teacherStudentRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAllStudentsByTeacherId(long teacherId) {
         return teacherStudentRepository.findAllByTeacherId(teacherId)
                                 .stream()
                                 .map(t -> userRepository.findOne(t.getStudentId()))
                                 .collect(Collectors.toList());
    }

    @Override
    public List<User> findAllStudents() {
        return userRepository.findAllByRole(1);
    }

    @Override
    public void addStudent(long teacherId, long studentId) {
        int count = teacherStudentRepository.countByTeacherIdAndStudentId(teacherId, studentId);
        if (count > 0) {
            return;
        }
        teacherStudentRepository.save(new TeacherStudent(teacherId, studentId));
    }
}
