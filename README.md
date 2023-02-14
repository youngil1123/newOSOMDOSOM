# 문화생활 기록 커뮤니티 Doit Book

1. **개요**
- **프로젝트명** : DoitBook
- **프로젝트 기간** : 2023년 1월 6일 ~ 2월 16일
- **개발 목적** : 영화/도서/연극/뮤지컬 다양한 문화생활의 리뷰를 기록하고 다른사람과 공유하는 커뮤니티
![Untitled](https://user-images.githubusercontent.com/49473766/218673483-aa3d54ea-5127-48e4-ab45-7e65db928d5a.png)

- **개발환경**
    - **O/S** : `Windows 10/11` ,`Linux`
    - **Language** : `Java (JDK 11.0.17)` ,`HTML5` , `CSS 3.0` ,`JavaScript`, `SQL`
    - **Database** : `MySQL Workbench(v 8.0.30)`
    - **IDE** : `Eclipse(v 2020-12)`
    - **Framework** : `Spring Boot`, `MyBatis`
    - **Server** : `NCP(Naver Cloud Platform)`, `Apache Tomcat`
    - **Front** : `HTML5`,`CSS3.0`, `Javascript`, `JQuery`, `Ajax`,
    - **API** : `KOPIS Open API` , `KOBIS Open API` ,  `도서관정보나루Open API`
    - **협업도구** : `Zoom` , `Git`, `ERD Cloud`, `Google Docs` , `Discord`, **`Gather`**
2. **내용**
- 팀원별 역할
    - 공동 작업 : CRUD, ERD 설계
    - 김준용(팀장): 게시판, 내 글, MBTI 페이지, 메인페이지, 전체적인 UI 작업
    - 김영일: 게시판, 게시글, 내 글, 리뷰 포인트, SQL이미지 삽입
    - 김종진: 팔로워 페이지, 회원 및 게시글 검색, 전체적인 UI 작업, 페이징, 마이페이지, 이미지 파일 업로드 등
    - 심정은: 관리자, API연동, 비밀번호 암호화, 미디어검색, 서버 배포, 페이징, 컨텐츠 찜
    - 황다솜: 로그인, 회원가입, E-MAIL 인증기능 설계, 포인트적립 기능, 전체적인 UI 작업
- ERD

![6%EC%A1%B0_%EC%B5%9C%EC%A2%85_ERD](https://user-images.githubusercontent.com/49473766/218673453-bf8b2e99-c0c3-413a-aa46-2e5aa3d612fa.png)

3. **구현기능**
    1. 미디어
    2. 찜기능
    3. 페이징
    4. 팔로우
    5. MBTI별 인기목록
    6. 리뷰포인트/로그인포인트
    7. (관리자)사용자 밴
