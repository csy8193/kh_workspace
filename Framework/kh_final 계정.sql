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

