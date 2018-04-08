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
@RequestMapping("/user/stu")
@Slf4j
public class StudentController {

    @GetMapping("/exams")
    public String exams() {
        return "stu/stu_exam";
    }

    @GetMapping("/exercises")
    public String exercises() {
        return "stu/stu_exercise";
    }

}
