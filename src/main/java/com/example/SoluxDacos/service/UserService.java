package com.example.SoluxDacos.service;

import com.example.SoluxDacos.controller.UserInfoDTO;
import com.example.SoluxDacos.domain.User;
import com.example.SoluxDacos.repository.UserRepository;
import com.nimbusds.openid.connect.sdk.UserInfoResponse;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // 사용자 정보를 반환하는 메서드
    public UserInfoDTO getUserInfo(UUID userId) {
        User user = userRepository.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("User not found")); // 사용자 없으면 예외 발생
        return new UserInfoDTO(user.getUserId().toString(), user.getUsername());
    }
}