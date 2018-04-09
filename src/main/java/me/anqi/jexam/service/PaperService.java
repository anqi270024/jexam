package me.anqi.jexam.service;

import me.anqi.jexam.entity.Paper;

import java.util.List;

/**
 * @author flyleft
 * @date 2018/4/10
 */
public interface PaperService {

    void addPaper(String title, long subjectId, long teacherId);

    void deletePaper(long paperId, long teacherId);

    List<Paper> findPapersByTeacherId(long teacherId);
}
