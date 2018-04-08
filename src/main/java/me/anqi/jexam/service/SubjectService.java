package me.anqi.jexam.service;

import me.anqi.jexam.entity.Subject;

import java.util.List;

/**
 * @author flyleft
 * @date 2018/4/9
 */
public interface SubjectService {

    List<Subject> getAllSubjects();

    void addSubject(String name);
}
