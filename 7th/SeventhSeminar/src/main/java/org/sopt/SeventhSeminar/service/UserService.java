package org.sopt.SeventhSeminar.service;

import lombok.RequiredArgsConstructor;
import org.sopt.SeventhSeminar.exception.model.SoptException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.sopt.SeventhSeminar.controller.dto.request.UserLoginRequestDto;
import org.sopt.SeventhSeminar.domain.User;
import org.sopt.SeventhSeminar.exception.Error;
import org.sopt.SeventhSeminar.exception.model.NotFoundException;
import org.sopt.SeventhSeminar.infrastructure.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public Long login(UserLoginRequestDto request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new NotFoundException(Error.NOT_FOUND_USER_EXCEPTION, Error.NOT_FOUND_USER_EXCEPTION.getMessage()));

        if (!user.getPassword().equals(request.getPassword())) {
            throw new SoptException(Error.INVALID_PASSWORD_EXCEPTION, Error.INVALID_PASSWORD_EXCEPTION.getMessage());
        }

        return user.getId();
    }
}