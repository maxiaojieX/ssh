package com.ma.service;

import com.ma.dao.StudentsDao;
import com.ma.pojo.Students;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2017/11/29 0029.
 */
@Service
@Transactional(rollbackFor = RuntimeException.class)
public class StudentsService {

    @Autowired
    private StudentsDao studentsDao;

    public Students findById(Integer id) {
        return studentsDao.findById(id);
    }

    public void save(Students students) {
        studentsDao.save(students);
    }


}
