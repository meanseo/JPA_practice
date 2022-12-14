package com.example.jpapractice;

import com.example.jpapractice.domain.posts.Posts;
import com.example.jpapractice.domain.posts.PostsRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @After
    public void cleanup(){
        postsRepository.deleteAll();
    }

    @Test
    public void save_and_get(){
        String title = "테스트 게시글";
        String content = "테스트 본문";

        postsRepository.save(Posts.builder() // save = insert/update -> id 값이 있으면 업데이트 없으면 인서트
                        .title(title)
                        .content(content)
                        .author("abc@gmail.com").build());

        List<Posts> postsList = postsRepository.findAll(); // select *

        Posts posts = postsList.get(0);
        assertThat(posts.getContent()).isEqualTo(content);
    }
}
