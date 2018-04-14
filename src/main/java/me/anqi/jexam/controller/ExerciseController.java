package me.anqi.jexam.controller;

import lombok.extern.slf4j.Slf4j;
import me.anqi.jexam.entity.Exercise;
import me.anqi.jexam.entity.auxiliary.ExerciseFront;
import me.anqi.jexam.service.ExerciseService;
import me.anqi.jexam.service.SubjectService;
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

    @Autowired
    private ExerciseService exerciseService;

    @Autowired
    private SubjectService subjectService;

    @GetMapping("/list")
    public String exercise(@RequestParam(value = "type", required = false) String type,
                           @PageableDefault(sort = {"id"}, direction = Sort.Direction.ASC) Pageable pageable,
                           HttpServletRequest request,
                           Model model) {
        RequestUtils.setFrontUserInfo(model, request);

        model.addAttribute("subjects", subjectService.getAllSubjects());

        ExerciseFront exerciseFront = exerciseService.getAllByFrontType(type, pageable);

        long count = exerciseFront.count / pageable.getPageSize() + 1;
        model.addAttribute("exercises", exerciseFront.exercisePage.getContent());
        model.addAttribute("count", count);
        model.addAttribute("exerciseType", type);
        model.addAttribute("currentPage", pageable.getPageNumber() + 1);
        return "exercise";
    }

    /**
     * 习题详情界面
     */
    @GetMapping("/{id}")
    public String courseExe(@PathVariable("id") long id, Model model, HttpServletRequest request) {
        RequestUtils.setFrontUserInfo(model, request);

        model.addAttribute("subjects", subjectService.getAllSubjects());

        Exercise exercise = exerciseService.getExercise(id);

        if (exercise == null) {

        }

        model.addAttribute("exe", exercise);
        return "exe_detail";
    }
}
