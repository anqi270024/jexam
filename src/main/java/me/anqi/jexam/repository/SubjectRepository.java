package me.anqi.jexam.repository;

import me.anqi.jexam.entity.Subject;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author flyleft
 * @date 2018/4/7
 */
public interface SubjectRepository extends CrudRepository<Subject,Long> {

    int countByName(String name);



}
