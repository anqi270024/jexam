package me.anqi.jexam.repository;

import me.anqi.jexam.entity.Solution;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface SolutionRepository extends CrudRepository<Solution,Long>{
}
