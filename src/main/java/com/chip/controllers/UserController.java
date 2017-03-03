package com.chip.controllers;

import com.chip.domain.entities.User;
import com.chip.domain.repositories.UserRepository;
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
public class UserController {


    private UserRepository userRepo;

    @Autowired
    public UserController(UserRepository inUserRepo){
        userRepo = inUserRepo;
    }

    @RequestMapping(value="/users", method = RequestMethod.GET)
    public ModelAndView userList(Model model){
        List<User> userList = userRepo.findAll();
        model.addAttribute(userList);
        return new ModelAndView("userList",(Map<String,?>)model.asMap());
    }
}
