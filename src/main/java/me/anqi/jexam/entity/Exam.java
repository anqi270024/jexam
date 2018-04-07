package me.anqi.jexam.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * 试卷
 * @author flyleft
 * @date 2018/4/7
 */
@Getter
@Setter
@Entity
@Table(name = "exam")
public class Exam implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false,length = 40)
    private String name;

    @Column(nullable = false, name = "subject_id")
    private long subjectId;

    @Column(name = "exercises")
    @OrderBy("pos ASC")
    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, mappedBy = "exam")
    private Set<Exercise> exercises = new HashSet<>();

    /**
     * 参与本次考试答题的人
     */
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_join_exam", joinColumns = {
            @JoinColumn(name = "exam_id", referencedColumnName = "id")}, inverseJoinColumns = {
            @JoinColumn(name = "user_id", referencedColumnName = "id")})
    private Set<User> participants = new HashSet<>();
}
