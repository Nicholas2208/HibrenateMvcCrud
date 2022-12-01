package com.nwhite.controller;

import com.nwhite.dao.UserDao;
import com.nwhite.model.User;
import com.nwhite.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String viewHomePage(Model model) {
        List<User> allUsers = userService.getAllUsers();
        model.addAttribute("allUsers", allUsers);
        return "index";
    }

    @GetMapping("/new")
    public String showNewProductForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);

        return "new_user";
    }

    @PostMapping("/save")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.addUser(user);

        return "redirect:/";
    }

    @PostMapping("/update")
    public String updateUser(@ModelAttribute("user") User user) {
        userService.updateUser(user);

        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditUserPage(@PathVariable(name = "id") long id) {
        ModelAndView mav = new ModelAndView("edit_user");
        User user = userService.getUser(id);
        mav.addObject("user", user);

        return mav;
    }

    @RequestMapping("/delete/{id}")
    public String deleteUser(@PathVariable(name = "id") Long id) {
        userService.deleteUser(id);

        return "redirect:/";
    }
}
