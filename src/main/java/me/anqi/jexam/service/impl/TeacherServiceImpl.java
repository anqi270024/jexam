package me.anqi.jexam.service.impl;

import me.anqi.jexam.entity.Paper;
import me.anqi.jexam.entity.TeacherStudent;
import me.anqi.jexam.entity.User;
import me.anqi.jexam.entity.UserPaperScore;
import me.anqi.jexam.entity.auxiliary.PaperFront;
import me.anqi.jexam.repository.*;
import me.anqi.jexam.service.TeacherService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author flyleft
 * @date 2018/4/15
 */
@Service
public class TeacherServiceImpl implements TeacherService {

    private TeacherStudentRepository teacherStudentRepository;

    private UserRepository userRepository;

    private PaperRepository paperRepository;

    private UserPaperAnswerRepository userPaperAnswerRepository;

    private UserPaperScoreRepository userPaperScoreRepository;

    private SubjectRepository subjectRepository;

    public TeacherServiceImpl(TeacherStudentRepository teacherStudentRepository, UserRepository userRepository,
                              PaperRepository paperRepository, UserPaperAnswerRepository userPaperAnswerRepository,
                              UserPaperScoreRepository userPaperScoreRepository, SubjectRepository subjectRepository) {
        this.teacherStudentRepository = teacherStudentRepository;
        this.userRepository = userRepository;
        this.paperRepository = paperRepository;
        this.userPaperAnswerRepository = userPaperAnswerRepository;
        this.userPaperScoreRepository = userPaperScoreRepository;
        this.subjectRepository = subjectRepository;
    }

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

    @Override
    public List<PaperFront> getPapersByTeacherId(long teacherId) {
        List<PaperFront> paperFrontList = new ArrayList<>();
        List<Paper> paperList = paperRepository.findAllByOwnerId(teacherId);
        List<TeacherStudent> teacherStudentList = teacherStudentRepository.findAllByTeacherId(teacherId);
        for (Paper paper : paperList) {
            for (TeacherStudent teacherStudent : teacherStudentList) {
                boolean exist = userPaperAnswerRepository.existsByUserIdAndPaperId(teacherStudent.getStudentId(), paper.getId());
                if (exist) {
                    PaperFront paperFront = new PaperFront();
                    paperFront.setStudentId(teacherStudent.getStudentId());
                    paperFront.setId(paper.getId());
                    paperFront.setName(paper.getName());
                    paperFront.setSubject(subjectRepository.findOne(paper.getSubjectId()).getName());
                    paperFront.setStudent(userRepository.findOne(teacherStudent.getStudentId()).getName());
                    UserPaperScore userPaperScore = userPaperScoreRepository.findByUserIdAndPaperId(teacherStudent.getStudentId(), paper.getId());
                    if (userPaperScore == null) {
                        paperFront.setType(2);
                    } else {
                        paperFront.setType(1);
                        paperFront.setScore(userPaperScore.getScore());
                    }
                    paperFrontList.add(paperFront);
                }
            }
        }
        return paperFrontList;
    }
}
