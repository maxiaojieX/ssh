package com.ma.dao;

import com.ma.pojo.Node;
import com.ma.util.Page;
import com.ma.util.RequestHandler;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/11/30 0030.
 */
public abstract class BaseDao<T,K extends Serializable> {

    @Autowired
    private SessionFactory sessionFactory;

    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public Class<T> clazz;

    /**
     * 通过反射拿到T的实体类class
     */
    public BaseDao() {
        ParameterizedType parameterizedType = (ParameterizedType) getClass().getGenericSuperclass();
        clazz = (Class<T>) parameterizedType.getActualTypeArguments()[0];
    }

    /**
     * 保存或更改
     * @param t
     */
    public void save(T t) {
        getSession().saveOrUpdate(t);
    }

    /**
     * 根据id查找
     * @param id
     * @return
     */
    public T findById(K id) {
        return (T) getSession().get(clazz,id);
    }

    /**
     * 根据id删除
     * @param id
     */
    public void deletById(K id) {
        T t = (T) getSession().get(clazz,id);
        getSession().delete(t);
    }

    /**
     * 查找全部
     * @return
     */
    public List<T> findAll() {
        Criteria criteria = getSession().createCriteria(clazz);
        return criteria.list();
    }

    /**
     * 根据搜索条件查找
     * @return
     */
    public List<T> findByCondition(List<RequestHandler> requestHandlerList) {

        Criteria criteria = getSession().createCriteria(clazz);
        forCriterHandler(requestHandlerList, criteria);
        return criteria.list();
    }


    public Page<T> findByConditionAndLimit(List<RequestHandler> requestHandlerList,Integer pageNum) {
        Criteria criteria = getSession().createCriteria(clazz);

        forCriterHandler(requestHandlerList, criteria);
        Page<T> page = new Page<>(countData(requestHandlerList),pageNum);
        criteria.setFirstResult((int) page.getStartNum());
        criteria.setMaxResults(15);

        List<T> list = criteria.list();
        page.setItem((ArrayList<T>) list);
        return page;
    }

    private void forCriterHandler(List<RequestHandler> requestHandlerList, Criteria criteria) {
        for(RequestHandler requestHandler : requestHandlerList) {

            String param = requestHandler.getNodeName();
            String type = requestHandler.getType();
            Object value = requestHandler.getValue();

            Criterion criterion = criteriaHandler(param,type,value);
            criteria.add(criterion);
        }
    }

    public long countData(List<RequestHandler> requestHandlerList) {
        Criteria criteria = getSession().createCriteria(clazz);
        forCriterHandler(requestHandlerList, criteria);
        criteria.setProjection(Projections.rowCount());
        return (long) criteria.uniqueResult();
    }


    /**
     * 筛选条件处理
     * @param param
     * @param type
     * @param value
     * @return
     */
    public Criterion criteriaHandler(String param,String type,Object value) {

        if("like".equalsIgnoreCase(type)) {
            return Restrictions.like(param,value.toString(), MatchMode.ANYWHERE);
        }else if ("eq".equalsIgnoreCase(type)) {
            return Restrictions.eq(param,value);
        } else if ("gt".equalsIgnoreCase(type)) {
            return Restrictions.gt(param,value);
        }else if ("ge".equalsIgnoreCase(type)) {
            return Restrictions.ge(param,value);
        }else if ("lt".equalsIgnoreCase(type)) {
            return Restrictions.lt(param,value);
        }else if ("le".equalsIgnoreCase(type)) {
            return Restrictions.le(param,value);
        }

        return null;
    }

}
