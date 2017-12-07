package com.ma.controller;

import com.ma.pojo.Node;
import com.ma.service.NodeService;
import com.ma.util.RequestHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Administrator on 2017/11/29 0029.
 */
@Controller
@RequestMapping("/node")
public class NodeController {

    @Autowired
    private NodeService nodeService;

    @GetMapping
    public String home(Model model,
                       HttpServletRequest request) {

        List<RequestHandler> requestHandlerList = RequestHandler.URIHandler(request);

        if(requestHandlerList.size() != 0) {
            //有搜索条件
            List<Node> nodeList = nodeService.findByCondition(requestHandlerList);
            model.addAttribute("nodeList",nodeList);

        }else{
            //没有搜索条件
            List<Node> nodeList = nodeService.findAll();
            model.addAttribute("nodeList",nodeList);
        }


        return "node";
    }

    @PostMapping("/add")
    public String add(Node node) {
        nodeService.saveOrUpdateNode(node);
        return "redirect:/node";
    }

    @GetMapping("/del")
    public String del(Integer id) {
        nodeService.deleteById(id);
        return "redirect:/node";
    }

}
