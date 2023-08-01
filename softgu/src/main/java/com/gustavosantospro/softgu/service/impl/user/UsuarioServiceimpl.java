package com.gustavosantospro.softgu.service.impl.user;

import com.gustavosantospro.softgu.model.user.Usuario;
import com.gustavosantospro.softgu.repository.UserRepository;
import com.gustavosantospro.softgu.service.UserService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Data
public class UsuarioServiceimpl implements UserDetailsService, UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        return userRepository.findByUsername(username);
    }

    @Override
    public Usuario createUser(Usuario user) {
        return userRepository.save(user);
    }

    @Override
    public List<Usuario> getAllUsers() {
        return userRepository.findAll();
    }
}
