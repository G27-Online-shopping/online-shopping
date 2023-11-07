package com.example.onlineshopping.user.sms;

import com.example.onlineshopping.user.sms.dto.LoginDto;
import com.example.onlineshopping.user.sms.dto.SendSmsDto;
import com.example.onlineshopping.user.sms.dto.SmsFeignClientLoginResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "eskiz-sms-fiegn",url ="notify.eskiz.uz/api")

public interface SmsFeignClient {
    @PostMapping("/auth/login")
    SmsFeignClientLoginResponseDto login(@RequestBody LoginDto loginDto);

    @PostMapping("message/sms/send")
    String sendSms(@RequestBody SendSmsDto sendSmsDto , @RequestHeader(name = "AUTHORIZATION") String token);
}
