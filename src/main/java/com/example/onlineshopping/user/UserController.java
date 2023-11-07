package com.example.onlineshopping.user;

import com.example.onlineshopping.user.dto.UserCrateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @GetMapping("sign-in")
    public String signIn(){
        return "user/sign-in";
    }

    @GetMapping("sign-up")
    public String signUp(){
        return "user/sign-up";
    }
    @PostMapping("sign-up")
    public String signUp(@ModelAttribute UserCrateDto userCreatedDto){
        userService.create(userCreatedDto);
        return "redirect:user/sign-in";
    }

}
