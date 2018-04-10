package me.anqi.jexam.repository;

import me.anqi.jexam.entity.Exercise;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ExerciseRepository  extends CrudRepository<Exercise, Long> {

    List<Exercise> findByType(@Param("type") String type, Pageable pageable);

    List<Exercise> findBySubjectId(@Param("subject_id") long subjectId, Pageable pageable);

    Page<Exercise> findAll(Pageable pageable);

    int countExerciseByType(@Param("type") String type);

    int countExerciseBySubjectId(@Param("subject_id") long subjectId);

    List<Exercise> findAllByPaperIdOrderByPosition(long paperId);


}