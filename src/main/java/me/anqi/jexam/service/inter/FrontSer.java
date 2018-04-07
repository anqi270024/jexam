package me.anqi.jexam.service.inter;

import me.anqi.jexam.entity.Exercise;
import me.anqi.jexam.service.FrontSerImpl;
import org.springframework.data.domain.Pageable;

import java.util.Set;

public interface FrontSer {

    FrontSerImpl.ExeFront getExeFront(String param, Pageable pageable);//分页获取习题列表

    Set<Exercise> getLesExe(long lesId);//获取某个课程的习题列表

    Exercise getExercise(long exeId);//获取习题全部信息

}
