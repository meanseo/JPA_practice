package com.example.jpapractice.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

//Posts 클래스로 데이터베이스를 접근하게 해주는 역할
public interface PostsRepository extends JpaRepository<Posts, Long> {
    // JpaRepository<Entity 클래스, pk 타입> -> 기본 crud 사용 가능
    // extends JpaRepository를 했기 때문에 @Repository 필요 없음
}
