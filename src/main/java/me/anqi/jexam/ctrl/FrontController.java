package me.anqi.jexam.ctrl;

import lombok.extern.slf4j.Slf4j;
import me.anqi.jexam.utils.RequestUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@Slf4j
public class FrontController {

    @GetMapping("/")
    public String index(Model model, HttpServletRequest request) {
        RequestUtils.setFrontUserInfo(model, request);
        return "index";
    }

}
