package org.sopt.SixthSeminar.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.sopt.SixthSeminar.common.dto.ApiResponse;
import org.sopt.SixthSeminar.config.jwt.JwtService;
import org.sopt.SixthSeminar.controller.dto.request.UserLoginRequestDto;
import org.sopt.SixthSeminar.controller.dto.response.UserLoginResponseDto;
import org.sopt.SixthSeminar.exception.Success;
import org.sopt.SixthSeminar.service.UserService;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final JwtService jwtService;


    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse<UserLoginResponseDto> login(@RequestBody @Valid final UserLoginRequestDto request) {
        final Long userId = userService.login(request);
        final String token = jwtService.issuedToken(String.valueOf(userId));
        return ApiResponse.success(Success.LOGIN_SUCCESS, UserLoginResponseDto.of(userId, token));
    }
}