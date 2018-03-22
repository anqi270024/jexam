package me.anqi.jexam.service.inter;

import me.anqi.jexam.entity.User;

import javax.servlet.http.HttpServletRequest;

public interface UserSer {

    boolean login(User user, HttpServletRequest request);

}
