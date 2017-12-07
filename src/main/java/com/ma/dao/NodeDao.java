package com.ma.dao;

import com.ma.pojo.Node;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/11/29 0029.
 */
@Repository
public class NodeDao extends BaseDao<Node,Integer> {

}
