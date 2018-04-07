package me.anqi.jexam.service;

import lombok.extern.slf4j.Slf4j;
import me.anqi.jexam.entity.Exercise;
import me.anqi.jexam.repository.ExerciseRepository;
import me.anqi.jexam.service.inter.FrontSer;
import me.anqi.jexam.utils.JexamBeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Slf4j
@Service
public class FrontSerImpl implements FrontSer {

    private ExerciseRepository exerciseRepository;


    @Autowired
    public FrontSerImpl(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }

    public static class ExeFront{
        public final List<Exercise> exercises;
        public final long count;

        public ExeFront(List<Exercise> exercises, long count) {
            this.exercises = exercises;
            this.count = count;
        }
    }


    @Override
    public ExeFront getExeFront(String param,Pageable pageable) {
      return null;

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
    public Set<Exercise> getLesExe(long lesId) {
        return null;
    }
}
