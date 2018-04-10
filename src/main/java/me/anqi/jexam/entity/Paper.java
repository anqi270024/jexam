package me.anqi.jexam.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 试卷
 * @author flyleft
 * @date 2018/4/7
 */
@Getter
@Setter
@Entity
@Table(name = "paper")
public class Paper implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false,length = 40)
    private String name;

    @Column(nullable = false, name = "subject_id")
    private long subjectId;

    @Column(nullable = false, name = "owner_id")
    private long ownerId;

    @Transient
    private String subject;


}
