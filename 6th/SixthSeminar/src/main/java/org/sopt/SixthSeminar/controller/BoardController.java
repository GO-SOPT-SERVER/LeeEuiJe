package org.sopt.SixthSeminar.controller;

import lombok.RequiredArgsConstructor;
import org.sopt.SixthSeminar.common.dto.ApiResponse;
import org.sopt.SixthSeminar.config.jwt.JwtService;
import org.sopt.SixthSeminar.config.resolver.UserId;
import org.sopt.SixthSeminar.controller.dto.request.BoardRequestDto;
import org.sopt.SixthSeminar.exception.Success;
import org.sopt.SixthSeminar.service.BoardService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;
    private final JwtService jwtService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse create(
            @UserId Long userId,
            @RequestBody @Valid final BoardRequestDto request) {
        boardService.create(userId, request);
        return ApiResponse.success(Success.CREATE_BOARD_SUCCESS);
    }
}