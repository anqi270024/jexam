package me.anqi.jexam.ctrl;

import lombok.extern.slf4j.Slf4j;
import me.anqi.jexam.entity.Exercise;
import me.anqi.jexam.service.FrontSerImpl;
import me.anqi.jexam.service.inter.FrontSer;
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
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@Slf4j
public class FrontController {

    private FrontSer frontSer;
    @Autowired
    public FrontController(FrontSer frontSer) {
        this.frontSer = frontSer;
    }

    @GetMapping("/")
    public String index(Model model, HttpServletRequest request) {
        RequestUtils.setFrontUserInfo(model, request);
        return "index";
    }


    @GetMapping("/exercise/list")
    public String exercise(@RequestParam(value = "c", required = false) String param,
                           @PageableDefault(sort = {"id"}, direction = Sort.Direction.DESC) Pageable pageable,
                           HttpServletRequest request,
                           Model model) {
        long start = System.currentTimeMillis();
        RequestUtils.setFrontUserInfo(model, request);
        FrontSerImpl.ExeFront exe = frontSer.getExeFront(param, pageable);

        long count = exe.count / pageable.getPageSize() + 1;
        model.addAttribute("exe", JexamBeanUtils.setExeChooseList(exe.exercises));
        model.addAttribute("count", count);
        model.addAttribute("c", param);
        model.addAttribute("cur", pageable.getPageNumber() + 1);
        long end = System.currentTimeMillis();
        log.info("习题列表响应时间为：" + (end - start));
        return "exe";
    }

    /**
     * 习题详情界面
     */
    @GetMapping("/exercise/{id}")
    public String courseExe(@PathVariable("id") long id, Model model, HttpServletRequest request) {
        RequestUtils.setFrontUserInfo(model, request);
        Exercise exercise = frontSer.getExercise(id);

        if (exercise == null) return "redirect:/exercise/list";

        model.addAttribute("exe", exercise);
        return "exe_detail";
    }

}
