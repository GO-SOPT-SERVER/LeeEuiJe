package sopt.org.SecondSeminar.domain;

import lombok.Getter;

@Getter
public class Post {
    private Long id;
    private Long author_id;
    private String title;
    private String content;

    public Post(Long id, Long author_id, String title, String content) {
        this.id = id;
        this.author_id = author_id;
        this.title = title;
        this.content = content;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "id: " + this.id + "\n" +
                "author_id: " + this.author_id + "\n" +
                "title: " + this.title + "\n" +
                "content: " + this.content;
    }
}
