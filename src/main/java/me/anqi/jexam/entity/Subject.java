package me.anqi.jexam.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 科目
 * @author flyleft
 * @date 2018/4/7
 */
@Getter
@Setter
@Entity
@Table(name = "subject")
public class Subject implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 40, unique = true)
    private String name;

    public Subject() {
    }

    public Subject(String name) {
        this.name = name;
    }
}
