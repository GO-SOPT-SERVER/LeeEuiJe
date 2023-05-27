package org.sopt.SixthSeminar.domain;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId", nullable = false, foreignKey = @ForeignKey(ConstraintMode.CONSTRAINT))
    private User user;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private boolean isPublic;

    private Board(User user, String title, String content, boolean isPublic) {
        this.user = user;
        this.title = title;
        this.content = content;
        this.isPublic = isPublic;
    }

    public static Board newInstance(User user, String title, String content, boolean isPublic) {
        return new Board(user, title, content, isPublic);
    }
}
