package me.anqi.jexam.repository;

import me.anqi.jexam.entity.UserPaperAnswer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 * @author flyleft
 * @date 2018/4/15
 */
public interface UserPaperAnswerRepository extends CrudRepository<UserPaperAnswer, Long> {

    boolean existsByUserIdAndPaperId(@Param("userId") long userId,
                                     @Param("paperId") long paperId);

    UserPaperAnswer findByUserIdAndExerciseId(@Param("userId") long userId,
                                              @Param("exerciseId") long exerciseId);

}
