package me.anqi.jexam.controller;

import me.anqi.jexam.entity.User;
import me.anqi.jexam.service.UserService;
import me.anqi.jexam.utils.RequestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    private static final Logger logger= LoggerFactory.getLogger(UserController.class);

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String index(Model model, HttpServletRequest request) {
        RequestUtils.setFrontUserInfo(model, request);
        return "index";
    }

    @GetMapping("/login")
    public String loginPage(){
        return "login";
    }

    @PostMapping("/login.do")
    public String DoLogin(User user, HttpServletRequest request){
        boolean result= false;
        try {
            result = userService.login(user,request);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (result){
            return "redirect:/";
        }
        return "redirect:/login";
    }

    @GetMapping("/user/logout")
    public String doLogOut(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        session.removeAttribute("cur_user");
        return "redirect:/";
    }

}

