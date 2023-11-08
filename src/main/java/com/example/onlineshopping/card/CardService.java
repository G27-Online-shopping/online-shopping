package com.example.onlineshopping.card;

import com.example.onlineshopping.card.dto.CarCreateDto;
import com.example.onlineshopping.card.entity.Card;
import com.example.onlineshopping.user.UserRepository;
import com.example.onlineshopping.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
@RequiredArgsConstructor
public class CardService {
    private final CardRepository cardRepository;
    private final ModelMapper modelMapper = new ModelMapper();
    private final UserRepository userRepository;
    public void createCard(CarCreateDto carCreateDto, Principal principal) {
        Card map = modelMapper.map(carCreateDto, Card.class);
        User user = userRepository.findUserByEmail(principal.getName()).get();
        map.setUser(user);
        cardRepository.save(map);
    }


}
