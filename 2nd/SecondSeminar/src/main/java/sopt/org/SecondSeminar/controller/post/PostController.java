package sopt.org.SecondSeminar.controller.post;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sopt.org.SecondSeminar.controller.post.dto.request.RegisterRequestDto;
import sopt.org.SecondSeminar.domain.Post;
import sopt.org.SecondSeminar.service.PostService;

import static sopt.org.SecondSeminar.SecondSeminarApplication.postList;

@RestController
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @PostMapping("/post")
    public String upload(@RequestBody final RegisterRequestDto request) {
        Long id = postService.upload(request);

        System.out.println(postList.get((int) (id - 1)).toString());

        return id + "번 게시글 등록이 완료됐습니다.";
    }

    @GetMapping("/post/{postId}")
    public String find(@PathVariable final Long postId) {
        for (Post post : postList) {
            if(post.getId().equals(postId))
                return post.getId() + "번 유저가 작성한 \n"
                + post.getTitle() + " 제목의 글 내용은 \n"
                + post.getContent();
        }
        return "해당 id의 게시글이 없습니다.";
    }

    @GetMapping("/post/search")
    public String findWithTitle(@RequestParam final String title) {
        for (Post post : postList) {
            if(post.getTitle().equals(title))
                return post.getTitle() + " 제목의 글은 \n"
                        + post.getId() + "번 유저가 작성하였고, \n"
                        + post.getContent() + "내용의 글입니다";
        }
        return "해당 제목의 게시글이 없습니다.";
    }
}
