package com.chip.controllers;

import com.chip.domain.Entities.Order;
import com.chip.domain.Repositories.OrderRepository;
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
public class OrderController {
    private OrderRepository orderRepo;

    @Autowired
    public OrderController(OrderRepository inOrderRepo){
        orderRepo = inOrderRepo;
    }

    @RequestMapping(value = "/orders", method = RequestMethod.GET)
    public ModelAndView productList(Model model){
        List<Order> orderList = orderRepo.findAll();
        model.addAttribute(orderList);
        return new ModelAndView("orderList",(Map<String,?>)model.asMap());
    }
}
