package com.example.onlineshopping.user;

import com.example.onlineshopping.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    private final ModelMapper mapper=new ModelMapper();
    private final UserRepository userRepository;
    public void crateUser(UserCrateDto userCrateDto) {
        User user = mapper.map(userCrateDto, User.class);
        userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findUserByEmail(username).get();
    }
}
