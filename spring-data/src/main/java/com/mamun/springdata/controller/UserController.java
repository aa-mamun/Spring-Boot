package com.mamun.springdata.controller;


import com.mamun.springdata.domain.User;
import com.mamun.springdata.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserRepository userRepository;


    @RequestMapping(value = "/test")
    public void test() {
        /**
         * Test JPQL method
         */
        User user = userRepository.findUserByNameUsingJPQL("Snow");

        /**
         * Test Procedure
         */
        List<User> users = userRepository.findAllByUsersAddress("Green road");
    }

    @RequestMapping(value = "/")
    public ModelAndView index(Model model) {
        model.addAttribute("user", new User());
        List<User> userList = userRepository.findAll();
        model.addAttribute("userList", userList);
        return new ModelAndView("user");
    }


    @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    public String saveUser(User user, BindingResult bindingResult,
                           ModelMap model, HttpServletRequest request) {

        String type = request.getParameter("update") != null ? request.getParameter("update") : "";
        String delete = request.getParameter("delete") != null ? request.getParameter("delete") : "";
        if (type.equalsIgnoreCase("update") || delete.equalsIgnoreCase("delete")) {
            User userDb = userRepository.findByUserId(user.getUserId());
            user.setUserId(userDb.getUserId());
        }
        if (bindingResult.hasErrors()) {
            return "user";
        }
        if (delete.equalsIgnoreCase("delete")) {
            userRepository.deleteById(user.getUserId());
        } else {
            userRepository.save(user);
        }
        model.clear();
        return "redirect:/user";
    }

    @RequestMapping(value = "/viewUser")
    public ModelAndView userModify(@ModelAttribute("userId") User user, Model model) {
        User userDb = userRepository.findByUserId(user.getUserId());
        model.addAttribute("user", userDb);
        List<User> userList = userRepository.findAll();
        model.addAttribute("userList", userList);
        return new ModelAndView("user");
    }
}
