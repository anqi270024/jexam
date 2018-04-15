package me.anqi.jexam.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @author flyleft
 * @date 2018/4/15
 */
@Data
@Entity
@Table(name = "user_paper_answer")
public class UserPaperAnswer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "user_id", nullable = false)
    private long userId;


    @Column(name = "paper_id", nullable = false)
    private long paperId;


    @Column(name = "exercise_id", nullable = false)
    private long exerciseId;


    @Column(columnDefinition = "text")
    private String answer;

    @Column(columnDefinition = "int default 0")
    private Integer score;

}
