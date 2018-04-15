package me.anqi.jexam.controller;

import me.anqi.jexam.entity.Exercise;
import me.anqi.jexam.entity.Paper;
import me.anqi.jexam.service.ExerciseService;
import me.anqi.jexam.service.PaperService;
import me.anqi.jexam.utils.RequestUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author flyleft
 * @date 2018/4/15
 */
@Controller
@RequestMapping("/papers")
public class PaperController {

    private PaperService paperService;

    private ExerciseService exerciseService;

    public PaperController(PaperService paperService, ExerciseService exerciseService) {
        this.paperService = paperService;
        this.exerciseService = exerciseService;
    }

    @GetMapping
    public String paperPage(Model model, HttpServletRequest request) {
        RequestUtils.setFrontUserInfo(model, request);
        List<Paper> paperList = paperService.getAllPapers();
        model.addAttribute("papers", paperList);
        return "paper";
    }

    @GetMapping("/{id}")
    public String paperDetailPage(@PathVariable("id") long id, Model model, HttpServletRequest request) {
        RequestUtils.setFrontUserInfo(model, request);
        List<Exercise> exerciseList = exerciseService.getAllExercisesByPaperId(id);
        model.addAttribute("exercises", exerciseList);
        return "paper_detail";
    }

}
