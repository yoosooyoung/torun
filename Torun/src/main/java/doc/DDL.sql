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

SELECT * FROM BOARD_COMMENT;


CREATE SEQUENCE comment_seq
       INCREMENT BY 1
       START WITH 1
       MINVALUE 1
       MAXVALUE 9999
       NOCYCLE
       NOCACHE
       NOORDER;
       
       SELECT * FROM BOARD_COMMENT;
       SELECT COMMENT_SEQ.NEXTVAL FROM DUAL;
       
    	INSERT BOARD_COMMENT (
			   BOARD_SEQ,
			   COMMENT_SEQ,
               PARENT_COMMENT_SEQ,
			   CONTENT,
			   WRITER,
			   INIT_DATE
			   )
	    VALUES(
	    	   '8',
	    	   COMMENT_SEQ.NEXTVAL, 
               '0',
		       '6666', 
		       '888', 
		       TO_CHAR(SYSDATE,'yyyy.mm.dd hh24:mi')
		       )
               
               
               