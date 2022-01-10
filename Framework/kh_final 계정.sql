-- 관리자 계정
CREATE USER kh_final identified by kh_final1234;

GRANT CONNECT, RESOURCE, CREATE VIEW TO kh_final;


-- kh_final 계정
DROP TABLE "STATUS";

CREATE TABLE "STATUS" (
   "STATUS_CD"   NUMBER    PRIMARY KEY,
   "STATUS_NM"   VARCHAR2(50)      NOT NULL
);
COMMENT ON COLUMN "STATUS"."STATUS_CD" IS '상태 코드';
COMMENT ON COLUMN "STATUS"."STATUS_NM" IS '상태 이름';


-- 회원 등급 테이블
DROP TABLE "MEMBER_GRADE";

CREATE TABLE "MEMBER_GRADE" (
   "GRADE_CD"   NUMBER      PRIMARY KEY,
   "GRADE_NM"   VARCHAR2(20)      NOT NULL
);

COMMENT ON COLUMN "MEMBER_GRADE"."GRADE_CD" IS '회원 등급 코드';
COMMENT ON COLUMN "MEMBER_GRADE"."GRADE_NM" IS '회원 등급 이름';


-- 회원 테이블
DROP TABLE "MEMBER";

CREATE TABLE "MEMBER" (
   "MEMBER_NO"   NUMBER      PRIMARY KEY,
   "MEMBER_ID"   VARCHAR2(20)      NOT NULL,
   "MEMBER_PW"   VARCHAR2(100)      NOT NULL,
   "MEMBER_NM"   VARCHAR2(15)      NOT NULL,
   "MEMBER_PHONE"   VARCHAR2(13)      NOT NULL,
   "MEMBER_EMAIL"   VARCHAR2(50)      NOT NULL,
   "MEMBER_ADDR"   VARCHAR2(200)      NULL,
   "ENROLL_DT"   DATE   DEFAULT SYSDATE   NOT NULL,
   "STATUS_CD"   NUMBER   REFERENCES STATUS,
   "GRADE_CD"   NUMBER   REFERENCES MEMBER_GRADE
);

COMMENT ON COLUMN "MEMBER"."MEMBER_NO" IS '회원 번호';
COMMENT ON COLUMN "MEMBER"."MEMBER_ID" IS '회원 아이디';
COMMENT ON COLUMN "MEMBER"."MEMBER_PW" IS '회원 비밀번호';
COMMENT ON COLUMN "MEMBER"."MEMBER_NM" IS '회원 이름';
COMMENT ON COLUMN "MEMBER"."MEMBER_PHONE" IS '회원 휴대폰 번호';
COMMENT ON COLUMN "MEMBER"."MEMBER_EMAIL" IS '회원 이메일';
COMMENT ON COLUMN "MEMBER"."MEMBER_ADDR" IS '회원 주소';
COMMENT ON COLUMN "MEMBER"."ENROLL_DT" IS '회원 가입일';
COMMENT ON COLUMN "MEMBER"."STATUS_CD" IS '상태 코드';
COMMENT ON COLUMN "MEMBER"."GRADE_CD" IS '회원 등급 코드';

-- 회원 번호 시퀀스
CREATE SEQUENCE SEQ_MEMBER_NO; 

-- 샘플 데이터 --

-- 상태 테이블
INSERT INTO STATUS VALUES(1, '정상');
INSERT INTO STATUS VALUES(2, '탈퇴');
INSERT INTO STATUS VALUES(3, '정지');
INSERT INTO STATUS VALUES(4, '삭제');
INSERT INTO STATUS VALUES(5, '블라인드');

SELECT * FROM STATUS;
COMMIT;

-- 회원 등급 테이블
INSERT INTO MEMBER_GRADE VALUES(1, '일반회원');
INSERT INTO MEMBER_GRADE VALUES(2, '관리자');

SELECT * FROM MEMBER_GRADE;
COMMIT;


-- 회원 테이블

INSERT INTO MEMBER
VALUES(SEQ_MEMBER_NO.NEXTVAL, 'user01', 'pass01!', '유저일',
       '010-1234-1234', 'user01@kh.or.kr', 
       '서울시 중구 남대문로 120 대일빌딩 2층 KH정보교육원',
       DEFAULT, 1, 1);

COMMIT;




UPDATE MEMBER SET
MEMBER_PW = '$2a$10$p8apDk6HHntnQnG//j6t6eXKH.SpjEHzykkb3XUzF7e8iK2Z5KYOu'
WHERE MEMBER_NO = 1;

COMMIT;


-- 아이디 중복 검사
-- COUNT(*)를 이용해서 일치하는 아이디의 개수를 파악
-- (추가조건) 탈퇴 안한 회원
-- -> 0개 : 중복X, 1개 : 중복O
SELECT COUNT(*) FROM MEMBER WHERE MEMBER_ID = 'user01' AND STATUS_CD != 2;


ALTER TABLE MEMBER MODIFY STATUS_CD DEFAULT 1;
ALTER TABLE MEMBER MODIFY GRADE_CD DEFAULT 1;




-- 카테고리 테이블
DROP TABLE "CATEGORY";

CREATE TABLE "CATEGORY" (
   "CATEGORY_CD"   NUMBER      PRIMARY KEY,
   "CATEGORY_NM"   VARCHAR2(50)      NOT NULL
);

COMMENT ON COLUMN "CATEGORY"."CATEGORY_CD" IS '카테고리 코드';
COMMENT ON COLUMN "CATEGORY"."CATEGORY_NM" IS '카테고리 이름';


-- 게시판 테이블
DROP TABLE "BOARD";

CREATE TABLE "BOARD" (
   "BOARD_NO"   NUMBER      PRIMARY KEY,
   "BOARD_TITLE"   VARCHAR2(200)      NOT NULL,
   "BOARD_CONTENT"   CLOB      NOT NULL,
   "CREATE_DT"   DATE   DEFAULT SYSDATE   NOT NULL,
   "MODIFY_DT"   DATE      NULL,
   "READ_COUNT"   NUMBER   DEFAULT 0   NOT NULL,
   "MEMBER_NO"   NUMBER      REFERENCES MEMBER NOT NULL,
   "STATUS_CD"   NUMBER   DEFAULT 1 REFERENCES STATUS,
   "CATEGORY_CD"   NUMBER      REFERENCES CATEGORY
);

COMMENT ON COLUMN "BOARD"."BOARD_NO" IS '게시글 번호';
COMMENT ON COLUMN "BOARD"."BOARD_TITLE" IS '게시글 제목';
COMMENT ON COLUMN "BOARD"."BOARD_CONTENT" IS '게시글 내용';
COMMENT ON COLUMN "BOARD"."CREATE_DT" IS '작성일';
COMMENT ON COLUMN "BOARD"."MODIFY_DT" IS '마지막 수정일';
COMMENT ON COLUMN "BOARD"."READ_COUNT" IS '조회수';
COMMENT ON COLUMN "BOARD"."MEMBER_NO" IS '회원 번호';
COMMENT ON COLUMN "BOARD"."STATUS_CD" IS '게시글 상태 코드';
COMMENT ON COLUMN "BOARD"."CATEGORY_CD" IS '카테고리 코드';


DROP SEQUENCE SEQ_BOARD_NO;
CREATE SEQUENCE SEQ_BOARD_NO; -- 게시글 번호 시퀀스


-- CATEGORY 테이블 데이터 추가
INSERT INTO CATEGORY VALUES(1, '잡담');
INSERT INTO CATEGORY VALUES(2, '질문');
INSERT INTO CATEGORY VALUES(3, '뉴스');
SELECT * FROM CATEGORY;

COMMIT;

-- PL/SQL을 이용한 게시판 샘플 데이터 500개 생성

BEGIN
    FOR N IN 1..500 LOOP
        INSERT INTO BOARD
        VALUES(SEQ_BOARD_NO.NEXTVAL,
                    SEQ_BOARD_NO.CURRVAL || '번째 게시글',
                    SEQ_BOARD_NO.CURRVAL || '번째 게시글 입니다.',
                    DEFAULT, DEFAULT, DEFAULT, 
                    1/*회원번호*/, FLOOR(DBMS_RANDOM.VALUE(1,6)),
                    FLOOR(DBMS_RANDOM.VALUE(1,4)));
    END LOOP;
    
    UPDATE BOARD SET STATUS_CD = 1
    WHERE STATUS_CD IN(2,3);

END;
/


-- 게시판 이미지 테이블
CREATE TABLE "BOARD_IMG" (
   "IMG_NO"   NUMBER      PRIMARY KEY,
   "IMG_PATH"   VARCHAR2(200)      NOT NULL,
   "IMG_NM"   VARCHAR2(30)      NOT NULL,
   "IMG_ORIGINAL"   VARCHAR2(100)      NOT NULL,
   "IMG_LEVEL"   NUMBER      NOT NULL,
   "BOARD_NO"   NUMBER  REFERENCES BOARD   NOT NULL
);

COMMENT ON COLUMN "BOARD_IMG"."IMG_NO" IS '이미지 번호';
COMMENT ON COLUMN "BOARD_IMG"."IMG_PATH" IS '이미지 경로';
COMMENT ON COLUMN "BOARD_IMG"."IMG_NM" IS '이미지명';
COMMENT ON COLUMN "BOARD_IMG"."IMG_ORIGINAL" IS '원본 이미지명';
COMMENT ON COLUMN "BOARD_IMG"."IMG_LEVEL" IS '이미지 위치 지정값 저장';
COMMENT ON COLUMN "BOARD_IMG"."BOARD_NO" IS '게시글 번호';



CREATE SEQUENCE SEQ_IMG_NO;


-- 게시판 이미지 샘플데이터 추가
INSERT INTO BOARD_IMG VALUES(
    SEQ_IMG_NO.NEXTVAL, '/resources/images/board/', 'sample1.jpg', 'sample1.jpg', 0,
    (SELECT * FROM (SELECT BOARD_NO FROM BOARD WHERE STATUS_CD NOT IN(4,5) ORDER BY 1 DESC) WHERE ROWNUM = 1)
    );
    
    
INSERT INTO BOARD_IMG VALUES(
    SEQ_IMG_NO.NEXTVAL, '/resources/images/board/', 'sample2.gif', 'sample2.gif', 1,
    (SELECT * FROM (SELECT BOARD_NO FROM BOARD WHERE STATUS_CD NOT IN(4,5) ORDER BY 1 DESC) WHERE ROWNUM = 1)
    );
    
INSERT INTO BOARD_IMG VALUES(
    SEQ_IMG_NO.NEXTVAL, '/resources/images/board/', 'sample3.jpg', 'sample3.jpg', 2,
    (SELECT * FROM (SELECT BOARD_NO FROM BOARD WHERE STATUS_CD NOT IN(4,5) ORDER BY 1 DESC) WHERE ROWNUM = 1)
    );
    
INSERT INTO BOARD_IMG VALUES(
    SEQ_IMG_NO.NEXTVAL, '/resources/images/board/', 'sample4.gif', 'sample4.gif', 3,
    (SELECT * FROM (SELECT BOARD_NO FROM BOARD WHERE STATUS_CD NOT IN(4,5) ORDER BY 1 DESC) WHERE ROWNUM = 1)
    );
    
commit; 
    
    
    
-- 게시글 목록 조회
-- 작성일 24시 미만 -> HH:MI
-- 작성일 24시간 이상 -> YYYY-MM-DD
SELECT BOARD_NO, BOARD_TITLE, READ_COUNT,
    CASE WHEN SYSDATE - CREATE_DT < 1
        THEN TO_CHAR(CREATE_DT, 'HH:MI')
        ELSE TO_CHAR(CREATE_DT, 'YYYY-MM-DD')
    END "CREATE_DT",
    MEMBER_NO, MEMBER_NM, STATUS_CD, STATUS_NM, CATEGORY_CD, CATEGORY_NM
FROM BOARD B
JOIN MEMBER USING(MEMBER_NO)
JOIN STATUS S ON(S.STATUS_CD = B.STATUS_CD)
JOIN CATEGORY USING(CATEGORY_CD)
WHERE STATUS_CD != 4
ORDER BY BOARD_NO DESC;
    
    
SELECT * FROM BOARD_IMG
WHERE BOARD_NO = 500
ORDER BY IMG_LEVEL;




CREATE TABLE PRACTICE(
    P_NO NUMBER PRIMARY KEY,
    P_NAME VARCHAR2(50) NOT NULL,
    P_LEVEL NUMBER NOT NULL
);


CREATE SEQUENCE SEQ_P_NO;

/*반복 삽입 방법
1. service에서 insert DAO를 for문으로 반복 호출
    -> 구현이 간단하지만 속도, 부하 측면에서 좋지 않음
    
2. INSERT ALL 사용
    -> PK를 나타내는 시퀀스 증가가 이루어지지 않음
    
3. 서브 쿼리를 이용한 INSERT
*/

INSERT INTO PRACTICE 
SELECT SEQ_P_NO.NEXTVAL, A.* FROM
(SELECT '테스트1' P_NAME, 1 P_LEVEL FROM DUAL
UNION ALL
SELECT '테스트2' P_NAME, 2 P_LEVEL FROM DUAL
UNION ALL
SELECT '테스트3' P_NAME, 3 P_LEVEL FROM DUAL) A;

