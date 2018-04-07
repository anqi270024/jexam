package me.anqi.jexam.service.inter;

import me.anqi.jexam.entity.Exercise;
import me.anqi.jexam.entity.Subject;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author flyleft
 * @date 2018/4/8
 */
public interface ExerciseSer {

    class ExeFront{
        public final List<Exercise> exercises;
        public final long count;

        public ExeFront(List<Exercise> exercises, long count) {
            this.exercises = exercises;
            this.count = count;
        }
    }

    /**
     * 分页获取习题列表
     */

    ExeFront getExeFront(String type, Long subjectId, Pageable pageable);

    /**
     * 获取习题全部信息
     */
    Exercise getExercise(long exeId);

    List<Subject> getAllSubjects();
}
