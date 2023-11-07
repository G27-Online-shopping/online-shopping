package com.example.onlineshopping.card;

import com.example.onlineshopping.card.dto.CarCreateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/card")
@RequiredArgsConstructor
public class CardController {
    private final CardService cardService;
    @GetMapping("card")
    public String card(){
        return "card/card";
    }

    @PostMapping("/card")
    public String createCar(@ModelAttribute CarCreateDto carCreateDto, Principal principal){
        cardService.createCard(carCreateDto, principal);
        return  "redirect:/";

    }
}
