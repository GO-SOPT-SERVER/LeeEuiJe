package sopt.org.FourthSeminar.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sopt.org.FourthSeminar.common.dto.ApiResponse;
import sopt.org.FourthSeminar.controller.dto.BoardRequestDto;
import sopt.org.FourthSeminar.exception.Success;
import sopt.org.FourthSeminar.service.BoardService;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse create(@RequestBody @Valid final BoardRequestDto request) {
        boardService.create(request);
        return ApiResponse.success(Success.CREATE_BOARD_SUCCESS);
    }
}