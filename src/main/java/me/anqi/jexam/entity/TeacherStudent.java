package me.anqi.jexam.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author flyleft
 * @date 2018/4/9
 */
@Getter
@Setter
@Entity
@Table(name = "teacher_student")
public class TeacherStudent implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, name = "teacher_id")
    private long teacherId;

    @Column(nullable = false, name = "student_id")
    private long studentId;

    public TeacherStudent() {
    }

    public TeacherStudent(long teacherId, long studentId) {
        this.teacherId = teacherId;
        this.studentId = studentId;
    }
}
