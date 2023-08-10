package com.gustavosantospro.softgu.service;

import com.gustavosantospro.softgu.data.AuthenticationDto;
import com.gustavosantospro.softgu.data.CreateUserDto;
import com.gustavosantospro.softgu.model.user.Usuario;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    ResponseEntity register(CreateUserDto user);
    List<Usuario> getAllUsers();
    ResponseEntity validUser(AuthenticationDto data);
}
