SELECT NAME, USERID, PWD, EMAIL, PHONE, ADMIN, JOINDATE
  FROM MEMBER;

INSERT INTO MEMBER(NAME, USERID, PWD, EMAIL, PHONE, ADMIN) VALUES('박규영', 'parkgy', '1234', 'pgy@gmail.com', '010-1111-2222', 0);

SELECT NAME, USERID, PWD, EMAIL, PHONE, ADMIN, JOINDATE FROM MEMBER WHERE USERID = 'parkgy';

UPDATE MEMBER SET NAME = '문채원', PWD = '5678', EMAIL = 'mcw@gmail.com', PHONE = '010-3333-5555', ADMIN = 1, JOINDATE = '2020-08-20' WHERE USERID = 'parkgy';

-- userCheck
SELECT PWD FROM MEMBER WHERE USERID = 'somi';

DELETE FROM MEMBER WHERE USERID = 'parkgy';

SELECT * FROM MEMBER;

SELECT NAME, USERID, EMAIL, PHONE, ADMIN, JOINDATE FROM MEMBER WHERE USERID = 'somi' AND PWD = '1234';

SELECT USER FROM DUAL;

SELECT * FROM USER_TABLES;

-- Title 
SELECT TITLE_NO, TITLE_NAME FROM TITLE;

SELECT MAX(TITLE_NO)+1 FROM TITLE;

INSERT INTO TITLE VALUES(?,?);

UPDATE TITLE SET 

-- Department
SELECT DEPT_NO, DEPT_NAME, DEPT_FLOOR FROM DEPARTMENT;

SELECT MAX(DEPT_NO)+1 FROM DEPARTMENT;

INSERT INTO DEPARTMENT VALUES(?, ?, ?);

-- EMPLOYEE
CREATE OR REPLACE VIEW VW_EMPLOYEE_JOIN AS
SELECT E.EMP_NO, E.EMP_NAME, E.TNO, E.MANAGER, E.SALARY, E.DNO, E.REGDATE, E.EMAIL, E.TEL, E.PASSWD, E.PIC_URL, T.TITLE_NAME, D.DEPT_NAME, M.EMP_NAME AS MANAGER_NAME 
  FROM EMPLOYEE E JOIN TITLE T ON E.TNO = T.TITLE_NO LEFT JOIN EMPLOYEE M ON E.MANAGER = M.EMP_NO JOIN DEPARTMENT D ON E.DNO = D.DEPT_NO;
 
DROP VIEW VW_EMPLOYEE_JOIN;
 
SELECT EMP_NO, EMP_NAME, TNO, MANAGER, SALARY, DNO, REGDATE, EMAIL, TEL, TITLE_NAME, DEPT_NAME, MANAGER_NAME FROM VW_EMPLOYEE_JOIN;

UPDATE VW_EMPLOYEE_JOIN SET TEL = ' ', PIC_URL = ' ';

SELECT TITLE_NAME FROM TITLE;



