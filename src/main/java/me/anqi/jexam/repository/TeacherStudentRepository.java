package me.anqi.jexam.repository;

import me.anqi.jexam.entity.TeacherStudent;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author flyleft
 * @date 2018/4/9
 */
public interface TeacherStudentRepository extends CrudRepository<TeacherStudent, Long> {

    List<TeacherStudent> findAllByTeacherId(long teacherId);

    int countByTeacherIdAndStudentId(@Param("teacherId") long teacherId,
                                     @Param("studentId")long studentId);

}
