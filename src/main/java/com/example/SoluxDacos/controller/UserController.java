package com.example.SoluxDacos.controller;

import com.example.SoluxDacos.domain.User;
import com.example.SoluxDacos.service.UserService;
import com.example.SoluxDacos.security.jwt.util.JwtUtil;
import com.example.SoluxDacos.controller.UserInfoDTO;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;
    private final JwtUtil jwtUtil;

    public UserController(UserService userService, JwtUtil jwtUtil) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
    }

    // 로그인 API (액세스 토큰으로 사용자 정보 조회)
    @GetMapping("/login")
    public UserInfoDTO login() {
        // 현재 인증된 사용자 정보 가져오기 (SecurityContext에서)
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // 인증 정보에서 사용자 ID 추출 (JWT 토큰에서 유저 ID가 'userId'라는 클레임으로 저장된 경우)
        String userId = (String) authentication.getPrincipal();

        // 사용자 정보 조회
        UUID uuid = UUID.fromString(userId);
        UserInfoDTO userInfo = userService.getUserInfo(uuid);

        // 사용자 정보와 성공 메시지 반환
        return new UserInfoDTO(userInfo.getUserId(), "로그인 성공: " + userInfo.getUserName());
    }
}