package org.sopt.SeventhSeminar.controller.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Schema(description = "유저 생성 DTO")
public class UserLoginRequestDto {

    @Email(message = "이메일 형식에 맞지 않습니다")
    @NotBlank
    private String email;

    @NotNull
    private String password;
}