package me.anqi.jexam.service;

import lombok.extern.slf4j.Slf4j;
import me.anqi.jexam.repository.CourserRepository;
import me.anqi.jexam.repository.ExerciseRepository;
import me.anqi.jexam.repository.LessonRepository;
import me.anqi.jexam.service.inter.FrontSer;
import me.anqi.jexam.entity.Course;
import me.anqi.jexam.entity.Exercise;
import me.anqi.jexam.entity.Lesson;
import me.anqi.jexam.utils.JmoocBeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Slf4j
@Service
public class FrontSerImpl implements FrontSer {

    private ExerciseRepository exerciseRepository;

    private CourserRepository courserRepository;

    private LessonRepository lessonRepository;

    @Autowired
    public FrontSerImpl(ExerciseRepository exerciseRepository, CourserRepository courserRepository,
                        LessonRepository lessonRepository) {
        this.exerciseRepository = exerciseRepository;
        this.courserRepository = courserRepository;
        this.lessonRepository = lessonRepository;
    }

    public static class ExeFront{
        public final List<Exercise> exercises;
        public final long count;

        public ExeFront(List<Exercise> exercises, long count) {
            this.exercises = exercises;
            this.count = count;
        }
    }

    public static class CrsFront{
        public final List<Course> courses;
        public final long count;

        public CrsFront(List<Course> courses, long count) {
            this.courses = courses;
            this.count = count;
        }
    }

    @Override
    public ExeFront getExeFront(String param,Pageable pageable) {
      if (param==null || "all".equals(param))  return new ExeFront(exerciseRepository.findAll(pageable).getContent(),exerciseRepository.count());

        param=param.trim();
        if ("c".equals(param) || "cp".equals(param) || "java".equals(param)){
            return new ExeFront(exerciseRepository.findByType(param,pageable),exerciseRepository.countExerciseByType(param));
        }
        try {
            int diff=Integer.parseInt(param);
            return new ExeFront(exerciseRepository.findByDifficulty(diff,pageable),exerciseRepository.countExerciseByDifficulty(diff));
        } catch (NumberFormatException e) {
            e.printStackTrace();
            log.info("获取习题列表参数错误，param: "+param);
           return new ExeFront(exerciseRepository.findAll(pageable).getContent(),exerciseRepository.count());
        }

    }

    @Override
    public CrsFront getCrsFront(String param,Pageable pageable) {
        if (param==null || "all".equals(param)) return new CrsFront(courserRepository.findAll(pageable).getContent(),courserRepository.count());
        param=param.trim();
        if ("c".equals(param) || "cp".equals(param) || "java".equals(param)){
            return new CrsFront(courserRepository.findByType(param,pageable),courserRepository.countByType(param));
        }
        return new CrsFront(courserRepository.findByDir(param,pageable),courserRepository.countByDir(param));
    }

    @Override
    public Course getCourse(long crsId) {
        return courserRepository.findOne(crsId);
    }

    @Override
    public Exercise getExercise(long exeId) {
        Exercise exercise = exerciseRepository.findOne(exeId);
        if (exercise!=null){
            JmoocBeanUtils.setOneExeChooseList(exercise);
        }
        return exercise;
    }

    @Override
    public Set<Exercise> getLesExe(long lesId) {
        Lesson lesson=lessonRepository.findOne(lesId);
        if (lesson==null) return new HashSet<>();
        return lesson.getExerciseList();
    }
}
