package com.example.jpapractice.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity // 해당 클래스에서는 절대 setter를 만들지 않음
@Table(name = "posts")
public class Posts {

    @Id //pk
    @GeneratedValue(strategy = GenerationType.IDENTITY) //pk 생성 규칙 -> AUTO_INCREMENT
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;
    @Column(columnDefinition = "Text", nullable = false)
    private String content;
    private String author;

    @Builder
    public Posts (String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }
}
