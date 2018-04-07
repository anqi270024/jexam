package me.anqi.jexam.ctrl;

import lombok.extern.slf4j.Slf4j;
import me.anqi.jexam.entity.Exercise;
import me.anqi.jexam.service.inter.ExerciseSer;
import me.anqi.jexam.utils.JexamBeanUtils;
import me.anqi.jexam.utils.RequestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * @author flyleft
 * @date 2018/4/8
 */
@Controller
@RequestMapping("/exercises")
@Slf4j
public class ExerciseController {

    private ExerciseSer exerciseSer;

    @Autowired
    public ExerciseController(ExerciseSer exerciseSer) {
        this.exerciseSer = exerciseSer;
    }

    @GetMapping("/list")
    public String exercise(@RequestParam(value = "type", required = false) String type,
                           @RequestParam(value = "subject_id", required = false) Long subjectId ,
                           @PageableDefault(sort = {"id"}, direction = Sort.Direction.DESC) Pageable pageable,
                           HttpServletRequest request,
                           Model model) {
        RequestUtils.setFrontUserInfo(model, request);

        model.addAttribute("subjects", exerciseSer.getAllSubjects());

        ExerciseSer.ExeFront exe = exerciseSer.getExeFront(type, subjectId, pageable);

        long count = exe.count / pageable.getPageSize() + 1;
        model.addAttribute("exe", JexamBeanUtils.setExeChooseList(exe.exercises));
        model.addAttribute("count", count);
        model.addAttribute("c", type);
        model.addAttribute("cur", pageable.getPageNumber() + 1);
        return "exe";
    }

    /**
     * 习题详情界面
     */
    @GetMapping("/{id}")
    public String courseExe(@PathVariable("id") long id, Model model, HttpServletRequest request) {
        RequestUtils.setFrontUserInfo(model, request);

        model.addAttribute("subjects", exerciseSer.getAllSubjects());

        Exercise exercise = exerciseSer.getExercise(id);

        if (exercise == null) {

        }

        model.addAttribute("exe", exercise);
        return "exe_detail";
    }
}
