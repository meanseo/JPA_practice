package com.example.jpapractice.service.posts;

import com.example.jpapractice.domain.posts.Posts;
import com.example.jpapractice.domain.posts.PostsRepository;
import com.example.jpapractice.web.dto.PostsResponseDto;
import com.example.jpapractice.web.dto.PostsSaveRequestDto;
import com.example.jpapractice.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {
    private PostsRepository postsRepository;

    @Transactional //선언적 트랜잭션 처리를 지원, 스프링에서는 config 파일에 설정, 부트는 해당 어노테이션으로 처리
    public Long save(PostsSaveRequestDto requestDto){
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    public Long update(Long id, PostsUpdateRequestDto requestDto){
        Posts posts = postsRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("해당하는 게시글이 없습니다. id="+ id));
        posts.update(requestDto.getTitle(), requestDto.getContent());
        return id;
    }

    public PostsResponseDto findById (Long id){
        Posts entity = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id="+ id));
        return new PostsResponseDto(entity);
    }
}
