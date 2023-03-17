package com.office.officeservice.controller;

import com.office.officeservice.model.User;
import com.office.officeservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class UserController {
    private final UserService userService;

    @PostMapping("/save")
    public ResponseEntity<User> save(@RequestBody User user) {
        return ResponseEntity.ok(userService.save(user));
    }

    @GetMapping("/findById/{user_id}")
    public ResponseEntity<User> findById(@PathVariable(name = "user_id") Long userId) {
        return ResponseEntity.ok(userService.findById(userId));
    }

    @DeleteMapping("/deleteById/{user_id}")
    public void deleteById(@PathVariable(name = "user_id") Long userId) {
        userService.deleteById(userId);
    }
}
