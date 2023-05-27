package org.sopt.SeventhSeminar.controller.dto.request;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

/*
    AllArgsContructor
    or
    Setter 통해 DTO의 데이터를 바인딩해야한다.
 */
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class BoardRequestDto {
    @NotNull
    private List<MultipartFile> thumbnail;

    @NotBlank
    private String title;

    @NotBlank
    private String content;

    @NotNull
    private Boolean isPublic;

    @Override
    public String toString() {
        return "BoardRequestDto{" +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", isPublic=" + isPublic +
                '}';
    }

    public void setThumbnail(List<MultipartFile> thumbnails) {
        this.thumbnail = thumbnails;
    }
}