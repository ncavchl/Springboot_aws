# Springboot_aws
[도서]스프링부트와 AWS로 혼자 구현하는 웹 서비스

- 20210118 다시 시작 
- Spring boot
- Gradle
- lombok
- JPA 사용 (자바 표준 ORM _ object relational mapping) - Spring Data JPA
  - 객체지향 프로그래밍 언어와 관계형 데이터베이스를 중간에서 패러다임 일치 해주기 위한 기술 
  - 개발자(객체지향적으로 프로그래밍), JPA가 이를 관계형 데이터베이스에 맞게 SQL을 대신 생성해서 실행.
  - 개발자는 SQL에 종속적인 개발을 하지 않아도 됨. 
  - 객체 중심으로 개발가능, 생산성 향상! 유지보수!
  
  
  
 > 웹 애플리케이션(rptlvks) + AWS 무중단 배포 
 - 게시판 기능 
   - 게시글 조회
   - 게시글 등록
   - 게시글 수정
   - 게시글 삭제
   
 - 회원 기능 
   - 구글 / 네이버 로그인
   - 로그인한 사용자 글 작성 권한
   - 본인 작성 글에 대한 권한 관리



1) 등록/수정/조회 API 만들기
- Request 데이터 받을 Dto
- API 요청을 받을 Controller
- 트랜잭션, 도메인 기능 간의 순서를 보장하는 Service

- 비즈니스 로직 처리하는 곳 : Domain <br>
![다운로드](https://user-images.githubusercontent.com/48319693/105595433-c5ed9b80-5dd6-11eb-8bb3-eff7c480ab71.png)
    
- 도메인 모델 사용- 서비스 메소드는 트랜잭션과 도메인 간의 순서만 보장.

<Java8 부터 LocalDate와 LocalDateTime 제공>
