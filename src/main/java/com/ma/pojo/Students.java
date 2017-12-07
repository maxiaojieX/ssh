package com.ma.pojo;

import javax.persistence.*;

/**
 * Created by Administrator on 2017/11/29 0029.
 */
@Entity
@Table(name = "students")
public class Students {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "stud_id")
    private Integer id;
    private String name;
    private String email;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
