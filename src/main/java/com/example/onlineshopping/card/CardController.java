package com.example.onlineshopping.card;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class CardController {
    @GetMapping("card")
    public String card(){
        return "card/card";
    }
}
