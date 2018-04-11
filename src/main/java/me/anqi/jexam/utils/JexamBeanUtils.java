package me.anqi.jexam.utils;

import me.anqi.jexam.entity.Exercise;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static me.anqi.jexam.entity.Exercise.TYPE_MULTI_CHOOSE;
import static me.anqi.jexam.entity.Exercise.TYPE_SINGLE_CHOOSE;

public class JexamBeanUtils {


    public static Collection<Exercise> setExeChooseList(Collection<Exercise> exercises){
        for (Exercise exe: exercises){
            if (TYPE_SINGLE_CHOOSE.equals(exe.getType()) || TYPE_MULTI_CHOOSE.equals(exe.getType())) {
                Map<Character, String> characterStringMap = JsonUtils.instance.readJsonToExeMap(exe.getChooses());
                exe.setChooseList(characterStringMap);
            }
        }
        return exercises;
    }

    public static void setOneExeChooseList(Exercise exe){
        Map<Character,String> chos=JsonUtils.instance.readJsonToExeMap(exe.getChooses());
        exe.setChooseList(chos);
    }

    public static String getDataFromJsonMap(String result){
        HashMap<String,String> jsonMap=JsonUtils.instance.readJsonToStrMap(result);
        if (jsonMap.isEmpty()){
            return "";
        }else {
            return jsonMap.get("1");
        }
    }
}
