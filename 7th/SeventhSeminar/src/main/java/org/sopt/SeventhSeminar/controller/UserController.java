package org.sopt.SeventhSeminar.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.sopt.SeventhSeminar.common.dto.ApiResponse;
import org.sopt.SeventhSeminar.config.jwt.JwtService;
import org.sopt.SeventhSeminar.controller.dto.request.UserLoginRequestDto;
import org.sopt.SeventhSeminar.controller.dto.response.UserLoginResponseDto;
import org.sopt.SeventhSeminar.exception.Success;
import org.sopt.SeventhSeminar.service.UserService;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
@Tag(name = "User", description = "유저 API Document")
public class UserController {

    private final UserService userService;
    private final JwtService jwtService;


    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "유저 로그인 API", description = "유저가 서버에 로그인을 요청합니다.")
    public ApiResponse<UserLoginResponseDto> login(@RequestBody @Valid final UserLoginRequestDto request) {
        final Long userId = userService.login(request);
        final String token = jwtService.issuedToken(String.valueOf(userId));
        return ApiResponse.success(Success.LOGIN_SUCCESS, UserLoginResponseDto.of(userId, token));
    }
}