package me.anqi.jexam.utils;

import me.anqi.jexam.entity.User;
import me.anqi.jexam.entity.auxiliary.UserAuxiliary;

import java.util.regex.Pattern;

public class CommonUtils {

    private static final String NUMBER = "[0-9]*";

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
                user.getAvatarUrl()
        );

    }

    public static boolean isNumeric(String str){
        Pattern pattern = Pattern.compile(NUMBER);
        return pattern.matcher(str).matches();
    }
}
