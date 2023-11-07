package com.example.onlineshopping.user;

import com.example.onlineshopping.user.dto.UserCrateDto;
import com.example.onlineshopping.user.dto.UserUpdateDto;
import com.example.onlineshopping.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    private final ModelMapper mapper=new ModelMapper();
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findUserByEmail(username).get();
    }

    public void create(UserCrateDto userCreateDto) {
        User user = mapper.map(userCreateDto, User.class);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);

    }

    public void update(UserUpdateDto userUpdateDto) {
        User user = mapper.map(userUpdateDto, User.class);
        User userByEmail = userRepository.findUserByEmail(userUpdateDto.getOldEmail()).get();
        userByEmail.setName(user.getName());
        userByEmail.setSurname(user.getSurname());
        userByEmail.setEmail(user.getEmail());
        userByEmail.setPhoneNumber(user.getPhoneNumber());
        userByEmail.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.delete(userByEmail);
        userRepository.save(userByEmail);
    }
}
