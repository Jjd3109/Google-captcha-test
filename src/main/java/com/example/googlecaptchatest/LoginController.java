package com.example.googlecaptchatest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.stereotype.Controller
@Slf4j
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;
    public static final String SECRET_KEY = "6LdOIKYpAAAAAK7DEQgg1BXxBotop_kLkQ-Qm8Ah";
    public static final String SITE_VERIFY_URL = "https://www.google.com/recaptcha/api/siteverify";



    @GetMapping("/login")
    public String loginPage(){

        return "/login";
    }


    @PostMapping("/login")
    public String loginMember(@RequestParam("name") String name, @RequestParam("password") String password, @RequestParam("token") String token){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>();
        map.add("secret", SECRET_KEY);
        map.add("response", token);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);

        ResponseEntity<String> response = builder.build().postForEntity( SITE_VERIFY_URL, request , String.class );



        loginService.findMember(name, password);

        return "/login";
    }



}
