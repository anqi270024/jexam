package me.anqi.jexam.service;

import me.anqi.jexam.entity.User;

import javax.servlet.http.HttpServletRequest;

public interface UserService {

    boolean login(User user, HttpServletRequest request);

}
