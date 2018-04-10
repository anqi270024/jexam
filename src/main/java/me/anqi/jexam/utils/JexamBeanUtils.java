package me.anqi.jexam.utils;

import me.anqi.jexam.entity.Exercise;
import me.anqi.jexam.entity.auxiliary.ExerciseForm;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class JexamBeanUtils {


    public static Exercise exeFormToBean(ExerciseForm form, long lesId){

        return null;
    }

    public static Collection<Exercise> setExeChooseList(Collection<Exercise> exercises){
        for (Exercise exe:exercises){
             Map<Character,String> chos=JsonUtils.instance.readJsonToExeMap(exe.getChooses());
             exe.setChooseList(chos);
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
