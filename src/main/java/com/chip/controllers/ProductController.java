package com.chip.controllers;

import com.chip.domain.entities.Product;
import com.chip.domain.entities.User;
import com.chip.domain.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

/**
 * Created by Chloe on 03/03/2017.
 */
@Controller
public class ProductController {
    private ProductRepository productRepo;

    @Autowired
    public ProductController(ProductRepository inProductRepo){
        productRepo = inProductRepo;
    }

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public ModelAndView productList(Model model){
        List<Product> productList = productRepo.findAll();
        model.addAttribute(productList);
        return new ModelAndView("productList",(Map<String,?>)model.asMap());
    }
}
