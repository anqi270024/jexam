package me.anqi.jexam.utils;

import me.anqi.jexam.entity.User;
import me.anqi.jexam.entity.auxiliary.UserAuxiliary;

public class CommonUtils {

    public static boolean isEmpty(String...strings){
        for (String string:strings){
            if (string==null || string.trim().isEmpty()){
                return true;
            }
        }
        return false;
    }

    public static boolean notEmpty(String...strings){
        for (String string:strings){
            if (string==null || string.trim().isEmpty()){
                return false;
            }
        }
        return true;
    }

    public static UserAuxiliary User2Auxiliary(User user){

        return new UserAuxiliary(
                user.getId(),
                user.getName(),
                user.getRole(),
                user.getAvatarUrl(),
                user.getNoticeNum()
        );

    }
}
