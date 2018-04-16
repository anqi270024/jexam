package me.anqi.jexam.service.impl;

import me.anqi.jexam.entity.Subject;
import me.anqi.jexam.repository.SubjectRepository;
import me.anqi.jexam.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author flyleft
 * @date 2018/4/9
 */
@Service
public class SubjectServiceImpl implements SubjectService {

    private SubjectRepository subjectRepository;

    @Autowired
    public SubjectServiceImpl(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    @Cacheable(value = "subjects", key = "1")
    @Override
    public List<Subject> getAllSubjects() {
        Iterable<Subject> subjectIterable = subjectRepository.findAll();
        List<Subject> list = new ArrayList<>();
        subjectIterable.forEach(t -> list.add(t));
        return list;
    }

    @Caching(evict = @CacheEvict(value = "subjects", key = "1"))
    @Override
    public void addSubject(String name) {
        int num = subjectRepository.countByName(name);
        if (num > 0) {
            throw new RuntimeException("error.subject.exist");
        }
        subjectRepository.save(new Subject(name));
    }
}
