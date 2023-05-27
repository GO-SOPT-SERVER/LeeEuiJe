package org.sopt.SeventhSeminar.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.sopt.SeventhSeminar.common.dto.ApiResponse;
import org.sopt.SeventhSeminar.config.jwt.JwtService;
import org.sopt.SeventhSeminar.config.resolver.UserId;
import org.sopt.SeventhSeminar.controller.dto.request.BoardRequestDto;
import org.sopt.SeventhSeminar.exception.Success;
import org.sopt.SeventhSeminar.external.client.aws.S3Service;
import org.sopt.SeventhSeminar.service.BoardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
@SecurityRequirement(name = "JWT Auth")
public class BoardController {

    private final S3Service s3Service;
    private final BoardService boardService;
    private final JwtService jwtService;

    @PostMapping(value = "/create", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse create(
            @UserId Long userId,
            @ModelAttribute @Valid final BoardRequestDto request) {
        List<String> boardThumbnailImageUrl = s3Service.uploadImages(request.getThumbnail(), "server");
        boardService.create(userId, boardThumbnailImageUrl, request);
        return ApiResponse.success(Success.CREATE_BOARD_SUCCESS);
    }
}