package me.anqi.jexam.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author flyleft
 * @date 2018/4/15
 */
@Getter
@Setter
@Entity
@Table(name = "user_paper_score")
public class UserPaperScore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "user_id", nullable = false)
    private long userId;

    @Column(name = "paper_id", nullable = false)
    private long paperId;

    @Column(nullable = false)
    private int score;

}
