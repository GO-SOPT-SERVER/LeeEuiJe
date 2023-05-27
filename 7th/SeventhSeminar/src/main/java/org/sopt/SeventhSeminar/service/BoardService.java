package org.sopt.SeventhSeminar.service;

import lombok.RequiredArgsConstructor;
import org.sopt.SeventhSeminar.controller.dto.request.BoardRequestDto;
import org.sopt.SeventhSeminar.domain.Board;
import org.sopt.SeventhSeminar.domain.Image;
import org.sopt.SeventhSeminar.domain.User;
import org.sopt.SeventhSeminar.exception.model.SoptException;
import org.sopt.SeventhSeminar.infrastructure.BoardRepository;
import org.sopt.SeventhSeminar.infrastructure.ImageRepository;
import org.sopt.SeventhSeminar.infrastructure.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.sopt.SeventhSeminar.exception.Error;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final UserRepository userRepository;
    private final BoardRepository boardRepository;
    private final ImageRepository imageRepository;

    @Transactional
    public void create(Long userId, List<String> boardThumbnailImageUrl, BoardRequestDto request) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new SoptException(Error.NOT_FOUND_USER_EXCEPTION, Error.NOT_FOUND_USER_EXCEPTION.getMessage()));

        Board newBoard = Board.newInstance(
                user,
                request.getTitle(),
                request.getContent(),
                request.getIsPublic()
        );

        boardRepository.save(newBoard);

        for(String url : boardThumbnailImageUrl) {
            imageRepository.save(Image.newInstance(newBoard, url));
        }
    }
}