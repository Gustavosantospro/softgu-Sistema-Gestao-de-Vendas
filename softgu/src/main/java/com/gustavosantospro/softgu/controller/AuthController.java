package com.gustavosantospro.softgu.controller;

import com.gustavosantospro.softgu.model.user.AuthenticationDto;
import com.gustavosantospro.softgu.service.UserService;
import com.gustavosantospro.softgu.service.impl.user.UsuarioServiceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Controller
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UsuarioServiceimpl userService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Validated AuthenticationDto auth) {

        return ResponseEntity.ok(userService.loadUserByUsername(auth.login()));

    }
}
