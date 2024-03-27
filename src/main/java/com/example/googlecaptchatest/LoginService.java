package com.example.googlecaptchatest;

import lombok.RequiredArgsConstructor;

import java.util.NoSuchElementException;

@org.springframework.stereotype.Service
@RequiredArgsConstructor
public class LoginService {

    private final LoginRepository loginRepository;
    public LoginEntity findMember(String name, String email) {
        return loginRepository.findByEmailAndPassword(name, email).orElseThrow(NoSuchElementException::new);

    }
}
