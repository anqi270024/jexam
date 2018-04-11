package me.anqi.jexam.entity.auxiliary;

import me.anqi.jexam.entity.Exercise;
import org.springframework.data.domain.Page;

/**
 * @author flyleft
 * @date 2018/4/11
 */
public class ExerciseFront {

    public final Page<Exercise> exercisePage;

    public final long count;

    public ExerciseFront(Page<Exercise> exercisePage, long count) {
        this.exercisePage = exercisePage;
        this.count = count;
    }
}
