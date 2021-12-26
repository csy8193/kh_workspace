SELECT COUNT(*) FROM BOARD WHERE STATUS_CD != 2 AND BOARD_CD = 110;


CREATE OR REPLACE VIEW BOARD_LIST AS 
SELECT B.BOARD_NO, B.BOARD_TITLE, B.MEMBER_NO, M.MEMBER_NM, BP.BOARD_PIC_PATH, BP.BOARD_PIC_NM, BOARD_CONTENT, BOARD_PIC_LEVEL, ANIMAL_PROFILE_IMG,
        READ_COUNT,
        -- CREATE_DT,
        -- 게시글 작성 시간으로 부터 1일이 지나지 않은 경우 -> 16:12 시간 작성
        -- 게시글 작성 시간으로 부터 1일이 지난 경우 -> 2021-12-12 날짜 작성
        CASE WHEN TO_DATE(TO_CHAR(SYSDATE, 'YYYY-MM-DD')) - TO_DATE(TO_CHAR(CREATE_DT, 'YYYY-MM-DD')) = 0
            THEN TO_CHAR( CREATE_DT, 'HH24:MI' )
        
        ELSE TO_CHAR( CREATE_DT, 'YYYY-MM-DD' )
        END AS "CREATE_DT",
        
        B.BOARD_CD, BC.BOARD_NAME,
        B.STATUS_CD, S.STATUS_NM
FROM BOARD B
JOIN MEMBER M ON(M.MEMBER_NO = B.MEMBER_NO)
JOIN BOARD_CODE BC ON(BC.BOARD_CD = B.BOARD_CD)
JOIN STATUS S ON(B.STATUS_CD = S.STATUS_CD)
JOIN BOARD_PIC BP ON(B.BOARD_NO = BP.BOARD_NO);



SELECT BOARD_NO, BOARD_TITLE, MEMBER_NO, MEMBER_NM,
        READ_COUNT,
        -- CREATE_DT,
        -- 게시글 작성 시간으로 부터 1일이 지나지 않은 경우 -> 16:12 시간 작성
        -- 게시글 작성 시간으로 부터 1일이 지난 경우 -> 2021-12-12 날짜 작성
        CASE WHEN TO_DATE(TO_CHAR(SYSDATE, 'YYYY-MM-DD')) - TO_DATE(TO_CHAR(CREATE_DT, 'YYYY-MM-DD')) = 0
            THEN TO_CHAR( CREATE_DT, 'HH24:MI' )
        
        ELSE TO_CHAR( CREATE_DT, 'YYYY-MM-DD' )
        END AS "CREATE_DT",
        
        BOARD_CD, BOARD_NAME,
        STATUS_CD, STATUS_NM
FROM BOARD B
JOIN MEMBER USING(MEMBER_NO)
JOIN BOARD_CODE USING(BOARD_CD)
JOIN STATUS S ON(B.STATUS_CD = S.STATUS_CD);


		SELECT * FROM
		(SELECT ROWNUM RNUM, A.*
		        FROM (SELECT * FROM BOARD_LIST
		        WHERE STATUS_CD != 2 AND BOARD_CD = 10
		        ORDER BY BOARD_NO DESC) A)
		WHERE RNUM BETWEEN 1 AND 10;
        
        
        		SELECT * FROM
		(SELECT ROWNUM RNUM, A.*
		        FROM (SELECT * FROM BOARD_LIST
		        WHERE STATUS_CD != 2 AND (BOARD_CONTENT LIKE '%a%' OR BOARD_TITLE LIKE '%a%') AND (BOARD_PIC_LEVEL = 0 OR BOARD_PIC_LEVEL IS NULL)
		        ORDER BY BOARD_NO DESC) A)
		WHERE RNUM BETWEEN 1 AND 100;


SELECT count(*) FROM BOARD WHERE STATUS_CD != 2 AND (BOARD_CONTENT LIKE 'a' OR BOARD_TITLE LIKE 'a');

SELECT count(*) FROM BOARD 
JOIN BOARD_PIC USING(BOARD_NO)
WHERE STATUS_CD != 2 AND (BOARD_CONTENT LIKE '%a%' OR BOARD_TITLE LIKE '%a%') AND (BOARD_PIC_LEVEL = 0 OR BOARD_PIC_LEVEL IS NULL);


