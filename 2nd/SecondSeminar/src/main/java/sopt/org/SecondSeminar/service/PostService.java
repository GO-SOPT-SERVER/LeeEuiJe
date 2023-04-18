package sopt.org.SecondSeminar.service;

import org.springframework.stereotype.Service;
import sopt.org.SecondSeminar.controller.post.dto.request.RegisterRequestDto;
import sopt.org.SecondSeminar.domain.Post;

import static sopt.org.SecondSeminar.SecondSeminarApplication.postList;

@Service
public class PostService {
    public Long upload(RegisterRequestDto request) {
        Post newPost = new Post(
                request.getId(),
                request.getAuthor_id(),
                request.getTitle(),
                request.getContent()
        );

        postList.add(newPost);
        newPost.setId((long) postList.size());

        // 저장한 유저 아이디 값 반환
        return newPost.getId();
    }
}
