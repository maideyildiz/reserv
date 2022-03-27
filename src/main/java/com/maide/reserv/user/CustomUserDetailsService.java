package com.maide.reserv.user;

import com.maide.reserv.registration.token.ConfirmationToken;
import com.maide.reserv.registration.token.ConfirmationTokenService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final static String USER_NOT_FOUND_MSG=
            "User with email %s not found";
    private final static String USER_WITH_TOKEN_NOT_FOUND_MSG=
            "User with token %s not found";
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final ConfirmationTokenService confirmationTokenService;
    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {
        return userRepository.findByEmail(email)
                .orElseThrow(()->new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG,email)));
    }
    public User userWithId(Long id){
        boolean userExist= userRepository.findById(id).isPresent();
        if(userExist==false){
            throw new IllegalStateException("user with id doesn't exist!!");
        }
        return userRepository.findById(id).get();
    }
    public ConfirmationToken loadUserByToken(String token)
            throws UsernameNotFoundException {
        return confirmationTokenService.getToken(token)
                .orElseThrow(()->new UsernameNotFoundException(String.format(USER_WITH_TOKEN_NOT_FOUND_MSG,token)));
    }
    public String signUpUser(User user){
        boolean userExist=userRepository.findByEmail(user.getEmail()).isPresent();
        if(userExist){
            throw new IllegalStateException("email already taken");
        }
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);

        String token=UUID.randomUUID().toString();
        ConfirmationToken confirmationToken=new ConfirmationToken(
                token,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(15),
                user
        );
        confirmationTokenService.saveConfirmationToken(confirmationToken);

        return token;
    }

    public int enableUser(String email) {
        return userRepository.enableUser(email);
    }
}
