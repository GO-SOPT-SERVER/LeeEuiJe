package org.sopt.SixthSeminar.service;

import lombok.RequiredArgsConstructor;
import org.sopt.SixthSeminar.controller.dto.request.BoardRequestDto;
import org.sopt.SixthSeminar.domain.Board;
import org.sopt.SixthSeminar.domain.User;
import org.sopt.SixthSeminar.exception.model.SoptException;
import org.sopt.SixthSeminar.infrastructure.BoardRepository;
import org.sopt.SixthSeminar.infrastructure.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.sopt.SixthSeminar.exception.Error;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final UserRepository userRepository;
    private final BoardRepository boardRepository;

    @Transactional
    public void create(Long userId, BoardRequestDto request) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new SoptException(Error.NOT_FOUND_USER_EXCEPTION, Error.NOT_FOUND_USER_EXCEPTION.getMessage()));

        Board newBoard = Board.newInstance(
                user,
                request.getTitle(),
                request.getContent(),
                request.getIsPublic()
        );

        boardRepository.save(newBoard);
    }
}