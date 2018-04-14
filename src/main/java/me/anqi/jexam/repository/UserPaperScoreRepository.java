package me.anqi.jexam.repository;

import me.anqi.jexam.entity.UserPaperScore;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 * @author flyleft
 * @date 2018/4/15
 */
public interface UserPaperScoreRepository extends CrudRepository<UserPaperScore, Long> {

    UserPaperScore findByUserIdAndPaperId(@Param("userId") long userId,
                                          @Param("paperId") long paperId);

}
