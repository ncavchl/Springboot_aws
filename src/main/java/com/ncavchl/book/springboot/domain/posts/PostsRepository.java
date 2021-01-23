package com.ncavchl.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

//Posts클래스로 DB 접근을 위해 생성함. DB Layer 접근자
// <엔티티 클래스, PK 타입> 상속하면 기본 CRUD 메소드 자동생성 대박

public interface PostsRepository extends JpaRepository<Posts, Long> {
}
