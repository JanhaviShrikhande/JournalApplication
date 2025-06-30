package net.fullStack.journalApp.controller;

import net.fullStack.journalApp.entity.User;
import net.fullStack.journalApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/public")
public class PublicController {

    @Autowired
    private UserService userService;

    @PostMapping("/createUser")
    public void createUser(@RequestBody User user){
        userService.saveNewUser(user);
    }



}
