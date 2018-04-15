package me.anqi.jexam.entity.auxiliary;

import lombok.Data;

/**
 * @author flyleft
 * @date 2018/4/15
 */
@Data
public class PaperFront {

    private long id;
    private String name;
    private String teacher;
    private String student;
    private long studentId;
    private String subject;
    private int type;
    private double score;
    
}
