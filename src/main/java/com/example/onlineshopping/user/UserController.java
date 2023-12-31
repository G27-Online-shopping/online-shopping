package com.example.onlineshopping.user;

import com.example.onlineshopping.user.dto.UserCrateDto;
import com.example.onlineshopping.user.dto.UserUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @GetMapping("sign-in")
    public String signIn(){
        return "user/sign-in";
    }

    @GetMapping("profile")
    public String getProfile(){
        return "user/profile";
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
    @PostMapping("update")
    public String update(@ModelAttribute UserUpdateDto userUpdateDto){
        userService.update(userUpdateDto);
        return "redirect:/sign-out";
    }
}
