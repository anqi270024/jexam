package me.anqi.jexam.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

/**
 * 习题
 *
 * @author flyleft
 * @date 2018/4/7
 */
@Getter
@Setter
@Entity
@Table(name = "exercise")
public class Exercise implements Serializable {

    private static final long serialVersionUID = -5175465537985355910L;

    public static final String TYPE_SINGLE_CHOOSE = "single_choose";

    public static final String TYPE_MULTI_CHOOSE = "multi_choose";

    public static final String TYPE_COMPLETION = "completion";

    public static final String TYPE_SHORT_ANSWER = "short_answer";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, name = "subject_id")
    private long subjectId;

    /**
     * 习题标题
     */
    @Column(nullable = false, columnDefinition = "text")
    private String title;

    /**
     * 习题内容
     */
    @Column(nullable = false, columnDefinition = "text")
    private String content;

    /**
     * 习题备注信息，比如参考答案等
     */
    @Column(nullable = false, columnDefinition = "text")
    private String remark;

    /**
     * 习题分值
     */
    @Column(nullable = false, columnDefinition = "tinyint default 1")
    private int score;

    /**
     * 习题类型
     * 单择题： single_choose
     * 多选题： multi_choose
     * 填空题： completion
     * 简答题： short_answer
     */
    @Column(nullable = false, length = 32)
    private String type;

    /**
     * 选择题选项列表
     */
    @Column(columnDefinition = "text")
    private String chooses;

    /**
     * 题目所有者的id
     */
    @Column(nullable = false, columnDefinition = "bigint default 0")
    private long paperId;

    /**
     * 习题在试卷中的位置
     */
    @Column(nullable = false)
    private int position;


    @Transient
    @JsonIgnore
    private Map<Character, String> chooseList;

    @Transient
    private String studentAnswer;

    public Exercise() {
    }


    @Override
    public boolean equals(Object o) {
        if (o instanceof Exercise) {
            Exercise exercise = (Exercise) o;
            if (this.id == exercise.id) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, subjectId, title, content, remark, score, type, chooses, paperId, position, chooseList);
    }
}
