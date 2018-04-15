package me.anqi.jexam.service;

import me.anqi.jexam.entity.Exercise;
import me.anqi.jexam.entity.auxiliary.ExerciseForm;
import me.anqi.jexam.entity.auxiliary.ExerciseFront;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author flyleft
 * @date 2018/4/8
 */
public interface ExerciseService {

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

    List<Exercise> getAllExercisesByPaperId(long paperId);

    void addExercise(ExerciseForm exerciseForm);

    ExerciseFront getAllByFrontType(String type, Pageable pageable);

    List<Exercise> getExercisesByPaperIdAndStudentId(long paperId, long studentId);

}
