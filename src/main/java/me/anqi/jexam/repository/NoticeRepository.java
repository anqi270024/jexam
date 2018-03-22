package me.anqi.jexam.repository;

import me.anqi.jexam.entity.Notice;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface NoticeRepository extends CrudRepository<Notice,Long> {

    List<Notice> findByTypeAndFromInfoId(int type,long fromInfoId);
}
