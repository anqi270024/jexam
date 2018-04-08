package me.anqi.jexam.service.impl;

import me.anqi.jexam.repository.UserRepository;
import me.anqi.jexam.service.UserService;
import me.anqi.jexam.entity.User;
import me.anqi.jexam.entity.auxiliary.UserAuxiliary;
import me.anqi.jexam.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Service
public class UserSerServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserSerServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean login(User user, HttpServletRequest request) {

        if (CommonUtils.isEmpty(user.getName(),user.getPassword())){
           return false;
        }

        User getUser=userRepository.findUserByNameAndPasswordAndRole(user.getName(),user.getPassword(),user.getRole());


      if (getUser!=null){
          user.setPassword(null);
          HttpSession session = request.getSession(true);
          UserAuxiliary userAuxiliary=CommonUtils.User2Auxiliary(getUser);
          session.setAttribute("cur_user",userAuxiliary);
          session.setMaxInactiveInterval(600);
          return true;
      }

        return false;
    }

}
