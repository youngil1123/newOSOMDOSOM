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
    
- 시스템 구성도
- 
![구상도](https://user-images.githubusercontent.com/117333012/218820668-ee74eb94-d8c8-480b-9927-a7820131f2ea.jpg)



- ERD

![6%EC%A1%B0_%EC%B5%9C%EC%A2%85_ERD](https://user-images.githubusercontent.com/49473766/218673453-bf8b2e99-c0c3-413a-aa46-2e5aa3d612fa.png)
- FlowChart
![6조flowchart](https://user-images.githubusercontent.com/49473766/218763204-4176c423-7831-45f7-a775-044250e7e68e.png)

- WBS


![wbs(1)](https://user-images.githubusercontent.com/117333012/218775426-3740b4a6-ca7d-4157-8279-1acc97e486c7.png)
![wbs(2)](https://user-images.githubusercontent.com/117333012/218775456-adb97129-6b73-49a6-8c24-e457655ece94.png)


3. **구현기능**



  - 미디어
 미디어별 평점순으로 인기순위를 만들었습니다.
 미디어 상관없이 가장 최근에 쓴 리뷰가 최신글 리뷰상단에 올라옵니다
 미디어 중 영화를 선택해 들어가면 리뷰를 쓴 작품들이 나열 되어있고, 작품을 선택하면
 그 작품에 대한 리뷰들이 나열되어 있는 것이 보여집니다.

 ![media](https://user-images.githubusercontent.com/117333012/218804538-87caa4b1-7e4c-4d5f-87cd-9d041af5d3f4.gif)
 

    - 찜기능
   마이페이지에 찜목록에서 나의 찜목록 리스트를 확인 할 수 있습니다
   작품 페잊에 들어가면 상세설명과 리뷰들이 있으면 하트표시의 찜 추가 및 취소 기능있습니다.
   추가 시 찜목록에 추가되면 취소 시 찜목록에서 사라지게 됩니다.


  ![likelist](https://user-images.githubusercontent.com/117333012/218804029-ad512168-b4f4-4d0c-b232-0b52915944e2.gif)

   - 페이징
  

![paging](https://user-images.githubusercontent.com/117333012/218803816-0be4f7e5-f577-43b1-939d-e9e4b2eeda87.gif)


리뷰상세페이지에서 리뷰가 5개가 넘어가면 다음 게시글 페이지로 넘어갈수 있게 페이징이 발생합니다


![followerlistpaging](https://user-images.githubusercontent.com/117333012/218803740-77fba405-128f-4a64-a013-3c2d75c9256a.gif)


 팔로워 리뷰페이지에서는 리뷰가 10개가 넘어가면 다음 게시글 페이지로 넘어가는 페이징 발생됩니다.
 
 
  - 팔로워
    
    
![followerinfo](https://user-images.githubusercontent.com/117333012/218793605-1fe7e9c0-6b8a-4abd-a42b-a759b888d523.gif)


팔로워 리스트에서 팔로워 한 사람들의 리뷰리스트와 소개란 등을 볼 수 있습니다.

![bestreviewnerfollower](https://user-images.githubusercontent.com/117333012/218793475-501c1fcd-7c65-4535-9e7e-0031ddfdddec.gif)


메인페이지에서 리뷰를 가장 많이 쓴 사람 순위대로 베스트 리뷰너를 보여줍니다. 베스트 리뷰너들의 옆에 하트를 누르게되면
리뷰너를 팔로우할 수 있으면 그 사람의 리뷰리스트 볼 수 있게 됩니다.

![addfollower](https://user-images.githubusercontent.com/117333012/218793521-68fc6091-d3a9-46e1-ab8b-9cc905b79dfa.gif)


팔로워페이제에서  addfollower버튼 누르면 아이디를 통해 팔로워를 할 아이디를 찾아 팔로워가능하면 리스트에 이미지와 함께
보여줍니다. 리스트에서 팔로워 취소도 가능한 모습입니다.





    - MBTI별 인기목록
    
   ![mbti](https://user-images.githubusercontent.com/117333012/218803571-f6e90439-5efe-4894-9d64-5966101319e0.gif)
   
   
   16개의 MBTI를 나열하고 E와 I로 구분하여 쉽게 볼 수 있게 했습니다.
   하나의 MBTI선택하여 들어가면 그 MBTI의 많이 쓴 리뷰 순위대로 나열 된 모습입니다.
    
  
   - (관리자)사용자 밴
    
   ![admin](https://user-images.githubusercontent.com/117333012/218801528-e0c6bceb-1634-4087-a56b-42e3a5da4d9f.gif)
   
   
   관리자페이지에서 로그인하여 가입된 회원관리와 회원들이 쓴 리뷰들을 볼 수 있으면 수정 삭제가 가능합니다.

    
    - 회원정보수정
    
   ![updatemember](https://user-images.githubusercontent.com/117333012/218804657-48b6b902-5739-4bdd-92e5-21c4d8c95b94.gif)
     
     
     마이페이지에서 비밀번호,이미지 닉네임,mbti 수정이 가능한 모습입니다.
    

