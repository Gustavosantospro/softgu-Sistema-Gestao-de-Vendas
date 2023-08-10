package com.gustavosantospro.softgu.service.impl.user;

import com.gustavosantospro.softgu.data.AuthenticationDto;
import com.gustavosantospro.softgu.data.CreateUserDto;
import com.gustavosantospro.softgu.model.user.Usuario;
import com.gustavosantospro.softgu.repository.UserRepository;
import com.gustavosantospro.softgu.service.UserService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Data
public class UsuarioServiceimpl implements  UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private PasswordEncoder encoder;

    @Override
    public List<Usuario> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public ResponseEntity register(CreateUserDto data) {
        Usuario user = new Usuario(data.username(), encoder.encode(data.password()), data.role());
        if(userRepository.findByUsername(data.username()) == null){
            userRepository.save(user);
            return ResponseEntity.ok().body("User create succesfully!");
        }
        return ResponseEntity.badRequest().body("User already exist");
    }


    public ResponseEntity validUser(AuthenticationDto data) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password()); // transforma login e senha em um UsernamePassToken
        var auth = this.authenticationManager.authenticate(usernamePassword);
        Boolean authResult = encoder.matches(data.password(), userRepository.findByUsername(data.login()).getPassword());
        if(authResult == true) return ResponseEntity.ok().build();
        return ResponseEntity.badRequest().body("User not found");
    }

}
