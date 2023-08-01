package com.gustavosantospro.softgu.service;

import com.gustavosantospro.softgu.model.user.Usuario;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    Usuario createUser(Usuario user);
    List<Usuario> getAllUsers();
}
