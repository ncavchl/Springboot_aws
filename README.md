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
 - Mustache (화면 구성, JSP 대용, 자바에선 서버 템플릿엔진 - 자바스크립트에선 클라이언트 템플릿엔진으로 사용 가능)
  
  
  
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


---
1) 등록/수정/조회 API 만들기
- Request 데이터 받을 Dto
- API 요청을 받을 Controller
- 트랜잭션, 도메인 기능 간의 순서를 보장하는 Service

- 비즈니스 로직 처리하는 곳 : Domain <br>
![다운로드](https://user-images.githubusercontent.com/48319693/105595433-c5ed9b80-5dd6-11eb-8bb3-eff7c480ab71.png)
    
- 도메인 모델 사용- 서비스 메소드는 트랜잭션과 도메인 간의 순서만 보장.

-<b>Java8 부터 LocalDate와 LocalDateTime 제공</b>


2) JPA Auditing으로 생성시간/수정시간 자동화
- BaseTimeEntity 클래스는 모든 Entity의 상위 클래스가 되어 Entity들의 생성시간, 수정시간을 자동으로 관리함.
- @EnableJpaAuditing - application클래스에 추가하는 어노테이션 


3) Mustache로 화면구성하기 
- {{>layout/footer}} /templates/layout 폴더 내의 파일을 불러옴 


4) 스프링 시큐리티와 OAuth2.0 으로 로그인 기능 구현 
- build.gradle : 
~~~
compile('org.springframework.boot:spring-boot-starter-oauth2-client');
~~~
- application.properties :
~~~
spring.profiles.include=oauth
~~~

- 오류📌) p.190 구글 로그인 테스트 
  - application.properties 파일 수정 : application-oauth.properties 파일을 include 하기위해 올바르게 적어야함
  - application-oauth.properties : 해당 파일에 오타 있었음 ;

  ~~~
  spring.profiles.include=oauth
  ~~~
   

- 오류📌) 구글 로그인 이름, username 불일치
  - index.mustache의 {{#username}} 이름 변경 ex)user 
  - IndexController username 도 변경 
  ~~~
  model.addAttribute("username", user.getName());
  ~~~

![login_name_mismatch](https://user-images.githubusercontent.com/48319693/106185415-279e7300-61e6-11eb-9292-ad54bcda906c.jpg)
