package com.chip.controllers;

import com.chip.domain.Services.UserService;
import com.chip.domain.Entities.User;
import com.chip.domain.Repositories.UserRepository;
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
    private UserService userService;

    @Autowired
    public UserController(UserRepository inUserRepo, UserService inUserService){
        userRepo = inUserRepo; userService = inUserService;
    }

    @RequestMapping(value="/users", method = RequestMethod.GET)
    public ModelAndView userList(Model model){
        List<User> userList = userRepo.findAll();
        model.addAttribute(userList);
        return new ModelAndView("userList",(Map<String,?>)model.asMap());
    }

    @RequestMapping(value="/", method = RequestMethod.GET)
    public ModelAndView index(Model model){
        return new ModelAndView("index",(Map<String,?>)model.asMap());
    }

    @RequestMapping(value="/register", method = RequestMethod.GET)
    public ModelAndView registerUser(Model model){
        model.addAttribute("User", new User());
        return new ModelAndView("registerUser",(Map<String,?>)model.asMap());
    }


    @RequestMapping(value="/register", method = RequestMethod.POST)
    public String registerUserPost(User user){
        System.out.println(user.toString());
        userRepo.save(user);
        return "redirect:/users";
    }
}
