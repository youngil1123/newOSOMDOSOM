# 문화생활 기록 커뮤니티 Doit Book

1. **개요**
- **프로젝트명** : DoitBook
- **프로젝트 기간** : 2023년 1월 6일 ~ 2월 16일
- **개발 목적** : 많은 매체들을 통해 여러 문화 생활을 쉽게 접할 수 있습니다. 
내가 보고싶은 여러 종류의 미디어에 대한 리뷰들을 확인할 수 있고, 자신이 해당 미디어를 접했을 때의 추억과 그 때의 감정 또한 기록에 남길 수 있다는 것을 구현하고 싶었습니다. 
또한, 다양한 사람들과의 리뷰을 통해 내가 알지 못했던 미디어들에 대한 새로운 눈을 뜨일 수 도 있고 많은 리뷰도 공유할 수 있다는 점에서 문화소통 발전에 기여할 수 있는 웹 사이트라고 생각하여 기획하게 되었습니다. 


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
- FlowChart
![6조flowchart](https://user-images.githubusercontent.com/49473766/218763204-4176c423-7831-45f7-a775-044250e7e68e.png)

- WBS


![wbs(1)](https://user-images.githubusercontent.com/117333012/218775426-3740b4a6-ca7d-4157-8279-1acc97e486c7.png)
![wbs(2)](https://user-images.githubusercontent.com/117333012/218775456-adb97129-6b73-49a6-8c24-e457655ece94.png)


3. **구현기능**
    1. 미디어
    2. 찜기능
    3. 페이징
    4. 팔로워


![bestreviewnerfollower](https://user-images.githubusercontent.com/117333012/218793475-501c1fcd-7c65-4535-9e7e-0031ddfdddec.gif)
![addfollower](https://user-images.githubusercontent.com/117333012/218793521-68fc6091-d3a9-46e1-ab8b-9cc905b79dfa.gif)
![followerinfo](https://user-images.githubusercontent.com/117333012/218793605-1fe7e9c0-6b8a-4abd-a42b-a759b888d523.gif)

    5. MBTI별 인기목록
    6. 리뷰포인트/로그인포인트
    7. (관리자)사용자 밴
    8. 회원정보수정
