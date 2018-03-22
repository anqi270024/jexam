package me.anqi.jexam.repository;

import me.anqi.jexam.entity.Chapter;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;


@Transactional
public interface ChapterRepository extends CrudRepository<Chapter,Long>{

}
