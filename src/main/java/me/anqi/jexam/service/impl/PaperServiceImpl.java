package me.anqi.jexam.service.impl;

import me.anqi.jexam.entity.Paper;
import me.anqi.jexam.exception.CommonException;
import me.anqi.jexam.repository.PaperRepository;
import me.anqi.jexam.repository.SubjectRepository;
import me.anqi.jexam.service.PaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author flyleft
 * @date 2018/4/10
 */
@Service
public class PaperServiceImpl implements PaperService {

    @Autowired
    private PaperRepository paperRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    @Override
    public void addPaper(String title, long subjectId, int answerTime, long teacherId) {
        Paper paper = new Paper();
        paper.setName(title);
        paper.setSubjectId(subjectId);
        paper.setOwnerId(teacherId);
        paper.setAnswerTime(answerTime);
        paperRepository.save(paper);
    }

    @Override
    public void deletePaper(long paperId, long teacherId) {
        Paper paper = paperRepository.findOne(paperId);
        if (paper == null) {
            return;
        }
        if (paper.getOwnerId() != teacherId) {
            throw new CommonException("error.paper.delete.noPermission");
        }
        paperRepository.delete(paper);
    }

    @Override
    public List<Paper> findPapersByTeacherId(long teacherId) {
        List<Paper> papers = paperRepository.findAllByOwnerId(teacherId);
        for (Paper paper : papers) {
            String name = subjectRepository.findOne(paper.getSubjectId()).getName();
            paper.setSubject(name);
        }
        return papers;
    }

    @Override
    public Paper findPageById(long id) {
        Paper paper = paperRepository.findOne(id);
        if (paper == null) {
            throw new CommonException("error.paper.find");
        }
        return paper;
    }
}
