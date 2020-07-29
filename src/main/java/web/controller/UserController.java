package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import web.model.User;
import web.service.UserServiceEntity;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserServiceEntity userService;

    @GetMapping("/")
    public ModelAndView allUsers(){
        List<User> users = userService.listAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("users");
        modelAndView.addObject("users",users);
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView editPage(@PathVariable("id") int id){
        User user = userService.get(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editPage");
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @PostMapping("/edit")
    public ModelAndView editUser(@ModelAttribute("user") User user){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        userService.save(user);
        return modelAndView;
    }

    @GetMapping("/add")
    public ModelAndView addPage(){
        ModelAndView  modelAndView = new ModelAndView();
        modelAndView.setViewName("addPage");
        modelAndView.addObject("user",new User());
        return modelAndView;
    }

    @PostMapping("/add")
    public  ModelAndView addCar(@ModelAttribute("user") User user){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        userService.save(user);
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView deleteCar(@PathVariable("id") int id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        userService.delete(id);
        return modelAndView;
    }

}
