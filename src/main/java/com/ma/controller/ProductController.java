package com.ma.controller;

import com.ma.pojo.Product;
import com.ma.service.ProductService;
import com.ma.util.Page;
import com.ma.util.RequestHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Administrator on 2017/12/1 0001.
 */
@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    private String home(Model model,
                        HttpServletRequest request,
                        @RequestParam(required = false,defaultValue = "1",name = "p") Integer pageNum) {

        List<RequestHandler> requestHeaderList = RequestHandler.URIHandler(request);

        Page<Product> productPage = productService.findLimit(requestHeaderList,pageNum);
        model.addAttribute("page",productPage);

        return "node";
    }


}
