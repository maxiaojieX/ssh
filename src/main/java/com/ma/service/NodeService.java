package com.ma.service;

import com.ma.dao.NodeDao;
import com.ma.pojo.Node;
import com.ma.util.RequestHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2017/11/29 0029.
 */
@Service
@Transactional(rollbackFor = RuntimeException.class)
public class NodeService {

    @Autowired
    private NodeDao nodeDao;

    public void saveOrUpdateNode(Node node) {
        nodeDao.save(node);
    }

    public Node findById(Integer id) {
        return nodeDao.findById(id);
    }

    public void deleteById(Integer id) {
        nodeDao.deletById(id);
    }

    public List<Node> findAll(){
        return nodeDao.findAll();
    }

    public List<Node> findByCondition(List<RequestHandler> requestHandlerList){
        return nodeDao.findByCondition(requestHandlerList);
    }

}
