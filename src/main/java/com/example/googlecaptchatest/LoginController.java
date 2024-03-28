package com.example.googlecaptchatest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;


@org.springframework.stereotype.Controller
@Slf4j
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @Value("${custom.google.secretKey}")
    private String secretKey;

    @GetMapping("/login")
    public String loginPage(){
        return "/login";
    }


    @PostMapping("/login")
    @ResponseBody
    public String loginMember(@RequestParam("email") String email,
                              @RequestParam("password") String password,
                              @RequestParam("recaptcha") String recaptcha) throws IOException {

        CapchaConfig capchaConfig = new CapchaConfig();


        log.info("recaptcha 값 = {}", recaptcha);
        log.info("secretKey 값 = {}", secretKey);
        log.info("결과값 = {}", capchaConfig.Verfiy(recaptcha, secretKey));


        // success 일 때와 false 일 때 로그인 로직 진행 !!!

       return "/login";
    }






}
