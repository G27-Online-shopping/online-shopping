package com.example.onlineshopping.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @GetMapping("sign-in")
    public String signIn(){
        System.out.println("userService");
        return "user/sign-in";

    }

}
