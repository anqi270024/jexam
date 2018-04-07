package me.anqi.jexam.ctrl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author flyleft
 * @date 2018/4/8
 */
@Controller
@RequestMapping("/user/tea")
@Slf4j
public class TeacherController {

    @GetMapping("/subjects")
    public String subjects() {
        return "tea_subject";
    }

    @GetMapping("/students")
    public String students() {
        return "tea_student";
    }

    @GetMapping("/exams")
    public String exams() {
        return "tea_exam";
    }

    @GetMapping("/papers")
    public String papers() {
        return "tea_paper";
    }

}
