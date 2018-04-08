package me.anqi.jexam.service.impl;

import me.anqi.jexam.entity.Exercise;
import me.anqi.jexam.entity.Subject;
import me.anqi.jexam.repository.ExerciseRepository;
import me.anqi.jexam.repository.SubjectRepository;
import me.anqi.jexam.service.ExerciseService;
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
public class ExerciseServiceImpl implements ExerciseService {

    private ExerciseRepository exerciseRepository;

    @Autowired
    public ExerciseServiceImpl(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
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

}
