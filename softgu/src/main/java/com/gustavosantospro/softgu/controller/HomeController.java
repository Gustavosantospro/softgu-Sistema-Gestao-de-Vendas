package com.gustavosantospro.softgu.controller;


import com.gustavosantospro.softgu.model.user.Usuario;
import com.gustavosantospro.softgu.service.UserService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Controller
@RequestMapping("/home")
@Data
public class HomeController {

    @Autowired
    private UserService userService;

    @GetMapping("listarUsuarios")
    public ResponseEntity<List<Usuario>> getAllUsers(){
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @PostMapping("/criarUsuario")
    public void createUser(@RequestBody Usuario usuario) {
         userService.createUser(usuario);
    }
}
