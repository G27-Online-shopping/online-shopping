package com.example.onlineshopping.user;

import com.example.onlineshopping.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final ModelMapper mapper=new ModelMapper();
    private final UserRepository userRepository;
    public void crateUser(UserCrateDto userCrateDto) {
        User user = mapper.map(userCrateDto, User.class);
        userRepository.save(user);
    }
}
