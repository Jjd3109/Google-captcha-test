package com.example.googlecaptchatest;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LoginRepository extends JpaRepository<LoginEntity, Long> {


    Optional<LoginEntity> findByEmailAndPassword(String email, String password);
}
