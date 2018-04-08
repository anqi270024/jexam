package me.anqi.jexam.ctrl;

import lombok.extern.slf4j.Slf4j;
import me.anqi.jexam.entity.Subject;
import me.anqi.jexam.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author flyleft
 * @date 2018/4/8
 */
@Controller
@RequestMapping("/user/tea")
@Slf4j
public class TeacherController {

    @Autowired
    private SubjectService subjectService;

    @GetMapping("/subjects")
    public String subjects(Model model) {
        StringBuilder builder = new StringBuilder();
        subjectService.getAllSubjects().forEach(t -> builder.append(t.getName()).append(" "));
        model.addAttribute("subjects", builder.toString());
        return "tea/tea_subject";
    }

    @GetMapping("/students")
    public String students() {
        return "tea/tea_student";
    }

    @GetMapping("/exams")
    public String exams() {
        return "tea/tea_exam";
    }

    @GetMapping("/papers")
    public String papers() {
        return "tea/tea_paper";
    }

    @PostMapping("/subjects")
    public String addSubject(@RequestParam("name") String name) {
       if (StringUtils.isEmpty(name)) {
           throw new RuntimeException("error.subjects.add");
       }
       subjectService.addSubject(name);
       return "redirect:/user/tea/subjects";
    }
}
