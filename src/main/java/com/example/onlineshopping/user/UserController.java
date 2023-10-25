package com.example.onlineshopping.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @PostMapping
    public String crateUser(@PathVariable UserCrateDto userCrateDto){
        userService.crateUser(userCrateDto);
        return "redirect:/";
    }
}
