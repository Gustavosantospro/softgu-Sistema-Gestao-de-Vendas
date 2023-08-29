package com.gustavosantospro.softgu.service.impl.user;

import com.gustavosantospro.softgu.data.AuthenticationDto;
import com.gustavosantospro.softgu.data.CreateUserDto;
import com.gustavosantospro.softgu.model.user.Usuario;
import com.gustavosantospro.softgu.repository.UserRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Data
public class UsuarioServiceimpl  {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private PasswordEncoder encoder;
    @Autowired
    private TokenService authService;

    public ResponseEntity register(CreateUserDto data) {

        if(this.userRepository.findBylogin(data.login()) != null){
            return ResponseEntity.badRequest().build();
        }
        String encrpt = new BCryptPasswordEncoder().encode(data.password());

        Usuario user = new Usuario(data.login(), encrpt, data.role());
        this.userRepository.save(user);

        return ResponseEntity.ok().build();
    }


    public ResponseEntity validUser(AuthenticationDto data) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password()); // transforma login e senha em um UsernamePassToken
        var auth = this.authenticationManager.authenticate(usernamePassword);

        var token = authService.generateToken((Usuario) auth.getPrincipal());

        return ResponseEntity.ok().body(token);
    }

}
