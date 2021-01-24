package com.ncavchl.book.springboot.domain.posts;

import com.ncavchl.book.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Posts extends BaseTimeEntity {
    // @Entity -테이블과 링크될 클래스를 나타냄, 기본값으로 클래스 대문자 이름을 _로 테이블 이름 매칭해줌.
    // @id - 테이블 pk(primary key) 나타냄
    // @GeneratedValue - PK 생성규칙, Identity 옵션 - auto_increment
    // @Column - 테이블 칼럼 나타내고, 구딩 선언 안해도 됨. 기본값 외에 옵션때문에 사용, 사이즈 늘리거나 타입 변경하거나

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;

    }
}
//Entity클래스에선 setter 메소드 안만듬!!!!!