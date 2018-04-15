package me.anqi.jexam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author flyleft
 * @date 2018/4/15
 */
@Controller
@RequestMapping("/papers")
public class PaperController {

    @GetMapping
    public String paperPage(Model model){
        return "";
    }

}
