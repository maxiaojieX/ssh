package com.ma.dao;

import com.ma.pojo.Students;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2017/11/29 0029.
 */
@Repository
public class StudentsDao {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public Students findById(Integer id) {
        return (Students) getSession().get(Students.class,id);
    }

    public void save(Students students){
        getSession().save(students);
    }

}
