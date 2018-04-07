package me.anqi.jexam.repository;

import me.anqi.jexam.entity.Exam;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author flyleft
 * @date 2018/4/7
 */
@Transactional
public interface ExamRepository extends CrudRepository<Exam,Long> {
}
