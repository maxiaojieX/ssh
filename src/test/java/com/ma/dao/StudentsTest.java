package com.ma.dao;

import com.ma.pojo.Node;
import com.ma.pojo.Product;
import com.ma.pojo.Students;
import com.ma.service.NodeService;
import com.ma.service.ProductService;
import com.ma.service.StudentsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by Administrator on 2017/11/29 0029.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-hibernate.xml")
public class StudentsTest {

    @Autowired
    private StudentsService studentsService;
    @Autowired
    private NodeService nodeService;
    @Autowired
    private ProductService productService;

    @Test
    public void test1() {
        Students students = studentsService.findById(2);
        System.out.println(students.getName());
    }

    @Test
    public void test2() {
        Students students = new Students();
        students.setName("宇腾");
//        students.setName("1");
        students.setEmail("661@qq.com");

        studentsService.save(students);
    }

    @Test
    public void test3() {
        Node node = nodeService.findById(1);
        System.out.println(node.getNodeName());

    }

    @Test
    public void add() {
        Node node = new Node();
        node.setNodeName("文学");

        nodeService.saveOrUpdateNode(node);
    }

    @Test
    public void delete() {
        nodeService.deleteById(6);
    }

    @Test
    public void update() {
        Node node = nodeService.findById(5);
        node.setNodeName("浮生");

        nodeService.saveOrUpdateNode(node);

    }

    @Test
    public void a() {
        List<Node> nodeList = nodeService.findAll();
        for(Node node : nodeList) {
            System.out.println(node.getNodeName());
        }
    }

    @Test
    public void test9() {
        Product product = productService.findById(2177);
        System.out.println(product.getProductName());
    }
}
