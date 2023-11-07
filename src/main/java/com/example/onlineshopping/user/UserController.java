package com.example.onlineshopping.user;

import com.example.onlineshopping.user.dto.UserCrateDto;
import com.example.onlineshopping.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;


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
