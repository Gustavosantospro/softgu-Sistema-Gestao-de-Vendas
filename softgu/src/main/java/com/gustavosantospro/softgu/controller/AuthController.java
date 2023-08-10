package com.gustavosantospro.softgu.controller;

import com.gustavosantospro.softgu.data.CreateUserDto;
import com.gustavosantospro.softgu.data.AuthenticationDto;
import com.gustavosantospro.softgu.service.impl.user.UsuarioServiceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Controller
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UsuarioServiceimpl userService;


    @GetMapping
    public ResponseEntity getAllUsers(){
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @PostMapping("/register")
    public ResponseEntity registerUser(@RequestBody @Validated CreateUserDto data) {
        return ResponseEntity.ok(userService.register(data));
    }
    @PostMapping("/login")
    public ResponseEntity validateLogin(@RequestBody @Validated AuthenticationDto auth) {
        return ResponseEntity.ok(userService.validUser(auth));
    }

}
