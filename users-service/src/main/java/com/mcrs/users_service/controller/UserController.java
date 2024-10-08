package com.mcrs.users_service.controller;

import com.mcrs.users_service.VO.ResponseTemplateVO;
import com.mcrs.users_service.entity.Users;
import com.mcrs.users_service.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/save")
    public Users saveUser(@RequestBody Users users) {
        return userService.saveUser(users);
    }

    @GetMapping("/{id}")
    public ResponseTemplateVO getUser(@PathVariable Long id) {
        return userService.getUserById(id);
    }
}
