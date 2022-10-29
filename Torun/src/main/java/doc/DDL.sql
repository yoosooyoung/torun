CREATE TABLE board 
( 
    board_seq       NUMBER(4)	NOT NULL,
    board_title       VARCHAR2(200),
    board_content  VARCHAR2(4000),
    board_views          VARCHAR2(200),
    board_init_date    VARCHAR2(20),
    board_update_date        VARCHAR2(20),
    writer        VARCHAR2(200)
);

ALTER TABLE board ADD CONSTRAINT board_pk PRIMARY KEY (board_seq);


CREATE SEQUENCE board_seq
       INCREMENT BY 1
       START WITH 1
       MINVALUE 1
       MAXVALUE 9999
       NOCYCLE
       NOCACHE
       NOORDER;

/* 게시판 댓글 정보 생성 */
CREATE TABLE BOARD_COMMENT
(
 BOARD_SEQ NUMBER                                  -- FK 게시판ID
 ,COMMENT_SEQ NUMBER PRIMARY KEY                 -- 댓글 ID
 ,PARENT_COMMENT_SEQ NUMBER DEFAULT 0 NOT NULL   -- 상위 댓글 ID
 ,CONTENT VARCHAR2(4000)  NOT NULL              -- 댓글
 ,WRITER VARCHAR2(50) NOT NULL                  -- 작성자
 ,INIT_DATE VARCHAR2(20)     -- 생성일시 
 ,UPDATE_DATE VARCHAR2(20)                             -- 수정일시
 ,DELETE_DATE VARCHAR2(20)                              -- 삭제일시
);



CREATE SEQUENCE comment_seq
       INCREMENT BY 1
       START WITH 1
       MINVALUE 1
       MAXVALUE 9999
       NOCYCLE
       NOCACHE
       NOORDER;
       
/* 멤버 */
CREATE TABLE BOARD_MEMBER
(
 USER_ID VARCHAR2(100)  NOT NULL                             --
 ,USER_PW VARCHAR2(100)  NOT NULL                -- 
 ,USER_JOIN VARCHAR(100)   
 ,USER_NAME VARCHAR(50)
 ,USER_EMAIL VARCHAR(100)
);       

-- 게시글 좋아요 버튼 컬럼 수정
-- 총 좋아요 수
ALTER TABLE board ADD board_like NUMBER(4);

/* 좋아요-사용자 맵핑테이블 */
CREATE TABLE BOARD_LIKE
(
 USER_ID VARCHAR2(100)  NOT NULL                             --
 ,BOARD_SEQ VARCHAR2(100)  NOT NULL                --  
 ,INIT_USER VARCHAR2(20)
 ,INIT_DATE VARCHAR2(20)
 ,UPDATE_USER VARCHAR2(20)
 ,UPDATE_DATE VARCHAR2(20)
);     


       
       
       