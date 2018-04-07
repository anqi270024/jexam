package me.anqi.jexam.service;

import me.anqi.jexam.entity.Exercise;
import me.anqi.jexam.entity.Subject;
import me.anqi.jexam.repository.ExerciseRepository;
import me.anqi.jexam.repository.SubjectRepository;
import me.anqi.jexam.service.inter.ExerciseSer;
import me.anqi.jexam.utils.JexamBeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author flyleft
 * @date 2018/4/8
 */
@Service
public class ExerciseSerImpl implements ExerciseSer {

    private ExerciseRepository exerciseRepository;

    private SubjectRepository subjectRepository;

    @Autowired
    public ExerciseSerImpl(ExerciseRepository exerciseRepository, SubjectRepository subjectRepository) {
        this.exerciseRepository = exerciseRepository;
        this.subjectRepository = subjectRepository;
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
    public List<Subject> getAllSubjects() {
        Iterable<Subject> subjectIterable = subjectRepository.findAll();
        List<Subject> list = new ArrayList<>();
        subjectIterable.forEach(t -> list.add(t));
        return list;
    }
}
