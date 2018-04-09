package me.anqi.jexam.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * 用户
 * @author flyleft
 * @date 2018/4/7
 */
@Getter
@Setter
@Entity
@Table(name = "user")
public class User implements Serializable {

    private static final String DEFAULT_AVATAR="/img/default.png";

    private static final long serialVersionUID = 8665628721543300843L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false,length = 40)
    private String name;

    @Column(nullable = false,length = 32)
    private String password;

    /**
     * 类型。1：学生，2：老师
     */
    @Column(nullable = false,columnDefinition="tinyint default 1")
    private int role;

    @Column(nullable = false,name = "avatar_url",columnDefinition="varchar(40) default '/img/default.png'")
    private String avatarUrl;

    @Column(name = "exercise_collection")
    @ManyToMany(cascade = CascadeType.REMOVE,fetch=FetchType.LAZY)
    private Set<Exercise> exerciseCollection=new HashSet<>();

    public User() {
    }

    public User(long id) {
        this.id=id;
    }

    public User(long id,String name) {
        this.id=id;
        this.name = name;
    }

    public User(String name, String password, int role) {
        this.name = name;
        this.password = password;
        this.role = role;
        this.avatarUrl=DEFAULT_AVATAR;
    }

}
