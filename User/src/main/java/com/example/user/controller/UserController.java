package com.example.user.controller;

import com.example.user.entity.UserApp;
import com.example.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/user")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
public class UserController {
    @Autowired
    private UserService _userService;
    @GetMapping("{id}")
    public ResponseEntity<UserApp> get(@PathVariable int id) {
        UserApp userApp = _userService.getUserById(id);
        return ResponseEntity.ok(userApp);
    }

}
