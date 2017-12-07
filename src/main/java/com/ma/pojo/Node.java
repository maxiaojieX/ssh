package com.ma.pojo;

import javax.persistence.*;

/**
 * Created by Administrator on 2017/11/29 0029.
 */
@Entity
@Table(name = "t_node")
public class Node {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "nid")
    private Integer id;
    @Column(name = "nodename")
    private String nodeName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }
}
