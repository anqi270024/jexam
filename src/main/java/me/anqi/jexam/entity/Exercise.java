package me.anqi.jexam.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Map;

/**
 * 习题
 * @author flyleft
 * @date 2018/4/7
 */
@Getter
@Setter
@Entity
@Table(name = "exercise")
public class Exercise implements Serializable {

    private static final long serialVersionUID = -5175465537985355910L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false,length = 40)
    private String subject;

    /**
     * 习题内容
     */
    @Column(nullable = false,columnDefinition="text")
    private String content;

    /**
     * 习题分值
     */
    @Column(nullable = false,columnDefinition="tinyint default 1")
    private int score;

    /**
     * 习题类型
     * 选择题： choose
     * 填空题： completion
     * 简答题： short_answer
     */
    @Column(nullable = false, length = 10)
    private String type;

    /**
     * 选择题选项列表
     */
    @Column(columnDefinition="text")
    private String chooses;

    /**
     * 题目所有者的id
     */
    @Column(nullable = false, columnDefinition = "bigint default 0")
    private long ownerId;


    /**
     * 习题参考答案
     */
    @Column(columnDefinition="text")
    private String answer;

    @ManyToOne(cascade = CascadeType.REMOVE, fetch=FetchType.EAGER, targetEntity = Exam.class)
    @JoinColumn(name = "exam_id")
    private Exam exam;

    @Transient
    @JsonIgnore
    private Map<Character,String> chooseList;

    public Exercise() {
    }

}
