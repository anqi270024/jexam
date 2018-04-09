package me.anqi.jexam.repository;

import me.anqi.jexam.entity.Paper;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author flyleft
 * @date 2018/4/7
 */
public interface PaperRepository extends CrudRepository<Paper, Long> {

    List<Paper> findAllByOwnerId(long ownerId);

}
