CREATE USER semi IDENTIFIED BY "semi1234!";
-- 값에 해당하는 문자열 양쪽에 ""를 붙이면 특수문자 관계없이 모두 문자열로 인식

-- 권한부여
GRANT CONNECT, RESOURCE, CREATE VIEW TO semi;

