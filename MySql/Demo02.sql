
-- *************һ������Լ��********************----
-- 1.1 Ĭ��ֵ
CREATE TABLE student(
	id INT,
	NAME VARCHAR(20),
	address VARCHAR(20) DEFAULT '�������'  -- Ĭ��ֵ
)

DROP TABLE student;
-- ���ֶ�û�в���ֵ��ʱ��mysql�Զ������ֶη���Ĭ��ֵ
INSERT INTO student(id,NAME) VALUES(1,'����');

-- ע�⣺Ĭ��ֵ���ֶ�����Ϊnull
INSERT INTO student(id,NAME,address) VALUE(2,'����',NULL);
INSERT INTO student(id,NAME,address) VALUE(3,'����','���ݷ�خ');

SELECT * FROM student;

-- 1.2 �ǿ�
-- ���� gender�ֶα�����ֵ����Ϊnull��
CREATE TABLE student(
	id INT,
	NAME VARCHAR(20),
	gender VARCHAR(2) NOT NULL -- �ǿ�
)

-- �ǿ��ֶα��븳ֵ
INSERT INTO student(id,NAME) VALUES(1,'����');
-- �ǿ��ַ����ܲ���null
INSERT INTO student(id,NAME,gender) VALUES(1,'����',NULL);

SELECT * FROM student;

-- 1.3 Ψһ
CREATE TABLE student(
	id INT UNIQUE, -- Ψһ
	NAME VARCHAR(20)
)

INSERT INTO student(id,NAME) VALUES(1,'zs');
INSERT INTO student(id,NAME) VALUES(1,'lisi'); -- ERROR 1062 (23000): Duplicate entry '1' for key 'id'

INSERT INTO student(id,NAME) VALUES(2,'lisi');

SELECT * FROM student;

-- 1.4 �������ǿ�+Ψһ��
DROP TABLE student;

CREATE TABLE student(
	id INT PRIMARY KEY, -- ����
	NAME VARCHAR(20)
)

INSERT INTO student(id,NAME) VALUES(1,'����');
INSERT INTO student(id,NAME) VALUES(2,'����');
-- INSERT INTO student(id,NAME) VALUES(1,'����'); -- Υ��ΨһԼ���� Duplicate entry '1' for key 'PRIMARY'

-- insert into student(name) value('����'); -- Υ���ǿ�Լ���� ERROR 1048 (23000): Column 'id' cannot be null

-- 1.5 ������
CREATE TABLE student(
	id INT(4) ZEROFILL PRIMARY KEY AUTO_INCREMENT, -- ����������0��ʼ  ZEROFILL �����
	NAME VARCHAR(20)
)

-- �������ֶο��Բ���ֵ���Զ�����
INSERT INTO student(NAME) VALUES('����');
INSERT INTO student(NAME) VALUES('����');
INSERT INTO student(NAME) VALUES('����');

SELECT * FROM student;
-- ����Ӱ��������Լ��
DELETE FROM student;
-- ����Ӱ��������Լ��
TRUNCATE TABLE student;

-- 1.6 ���Լ��
-- Ա����
CREATE TABLE employee(
	id INT PRIMARY KEY,
	empName VARCHAR(20),
	deptName VARCHAR(20) -- ��������
)

INSERT INTO employee VALUES(1,'����','���������');
INSERT INTO employee VALUES(2,'����','���������');
INSERT INTO employee VALUES(3,'����','Ӧ��ά����');

SELECT * FROM employee;

-- ���Ա�����������Ƶ����������
INSERT INTO employee VALUES(4,'����','���������');

-- �����������ߵ����⣺��������ֶηŵ�һ�Ŷ�������
-- �������һ�Ų��ű�
CREATE TABLE dept(
	id INT PRIMARY KEY,
	deptName VARCHAR(20)
)

DROP TABLE employee;

-- �޸�Ա����
CREATE TABLE employee(
	id INT PRIMARY KEY,
	empName VARCHAR(20),
	deptId INT,-- �Ѳ������Ƹ�Ϊ����ID
	-- ����һ�����Լ��
	CONSTRAINT emlyee_dept_fk FOREIGN KEY(deptId) REFERENCES dept(id) ON UPDATE CASCADE ON DELETE CASCADE  -- ON CASCADE UPDATE �������޸�
	--           �������                  ���               �ο���(�ο��ֶ�)
)

INSERT INTO dept(id,deptName) VALUES(1,'���������');
INSERT INTO dept(id,deptName) VALUES(2,'Ӧ��ά����');
INSERT INTO dept(id,deptName) VALUES(3,'���鲿');

INSERT INTO employee VALUES(1,'����',1);
INSERT INTO employee VALUES(2,'����',1);
INSERT INTO employee VALUES(3,'����',2);
INSERT INTO employee VALUES(4,'����',3);

-- ����: �ü�¼ҵ���ϲ��Ϸ���Ա��������һ�������ڵĲ�������
INSERT INTO employee VALUES(5,'����',4); -- Υ�����Լ���� Cannot add or update a child row: a foreign key constraint fails (`day16`.`employee`, CONSTRAINT `emlyee_dept_fk` FOREIGN KEY (`deptId`) REFERENCES `dept` (`id`))

-- 1�����������Լ����������ݵ�˳�� �������������Ӹ�������
-- 2�����������Լ�����޸����ݵ�˳�� ���޸ĸ������޸���������
-- 3�����������Լ����ɾ�����ݵ�˳�� ��ɾ��������ɾ����������
-- �޸Ĳ���(����ֱ���޸�����)
UPDATE dept SET id=4 WHERE id=3;
-- ���޸�Ա����
UPDATE employee SET deptId=2 WHERE id=4;
 
-- ɾ������
DELETE FROM dept WHERE id=2;

-- ��ɾ��Ա����
DELETE FROM employee WHERE deptId=2;

SELECT * FROM dept;
SELECT * FROM employee;

-- �����޸ģ��޸ģ�
-- ֱ���޸Ĳ���
UPDATE dept SET id=5 WHERE id=4;

-- ����ɾ��
-- ֱ��ɾ������ 
DELETE FROM dept WHERE id=1;



--  **************����������ѯ������ѯ��****************----
-- ���󣺲�ѯԱ���������ڲ���(��ʾԱ����������������)
-- 2.1 �������Ӳ�ѯ�����Ƽ��������ѿ����˻�����4 * 4=16����Щ���ظ���¼��
SELECT empName,deptName FROM employee,dept;

-- ���󣺲�ѯԱ���������ڲ���(��ʾԱ����������������)
-- ����ѯ����1��ȷ����ѯ��Щ��   2��ȷ����Щ��Щ�ֶ�   3�������֮���������� (���ɣ��������������Ǳ�����-1)
-- 2.2 �����Ӳ�ѯ��ֻ�����������Ľ���Ż���ʾ(ʹ����Ƶ��)
SELECT empName,deptName       -- 2��ȷ����Щ��Щ�ֶ�
	FROM employee,dept    -- 1��ȷ����ѯ��Щ��
	WHERE employee.deptId=dept.id  -- 3�������֮����������
	
-- �����ӵ���һ���﷨
SELECT empName,deptName
	FROM employee
	INNER JOIN dept
	ON employee.deptId=dept.id;
	
-- ʹ�ñ���
SELECT e.empName,d.deptName
	FROM employee e
	INNER JOIN dept d
	ON e.deptId=d.id;

-- ���� ��ѯÿ�����ŵ�Ա��
-- Ԥ�ڽ����
 --  ���������  ����
 --  ���������  ����
 --  Ӧ��ά����  ����
 --  ���鲿      ����
 --  �ܾ���      null 
-- 2.2 ��[��]���Ӳ�ѯ�� ʹ����߱������ȥƥ���ұ߱�����ݣ�����������������Ľ������ʾ�����������������������ʾnull
 -- ��ע�⣺ �������ӣ���������һ���������ʾ����
SELECT d.deptName,e.empName
	FROM dept d
	LEFT OUTER JOIN employee e
	ON d.id=e.deptId;

-- 2.3 ��[��]���Ӳ�ѯ: ʹ���ұ߱������ȥƥ����߱�����ݣ�����������������Ľ������ʾ�����������������������ʾnull
 -- ��ע�⣺ �������ӣ��ұ������һ���������ʾ����
SELECT d.deptName,e.empName
	FROM employee e
	RIGHT OUTER JOIN dept d
	ON d.id=e.deptId;

-- 2.4 �����Ӳ�ѯ
-- ���󣺲�ѯԱ��������˾
-- Ԥ�ڽ����       
	-- ����    null
	-- ����    ����
	-- ����    ����
	-- ����    ����
SELECT e.empName,b.empName
	FROM employee e 
	LEFT OUTER JOIN employee b
	ON e.bossId=b.id;


SELECT * FROM employee;
SELECT * FROM dept;
-- �����˾ID
ALTER TABLE employee ADD bossId INT;
UPDATE employee SET bossId=1 WHERE id=2;
UPDATE employee SET bossId=2 WHERE id=3;
UPDATE employee SET bossId=3 WHERE id=4;


-- **************�����洢����*******************-
-- ����������
-- �����洢����
DELIMITER $
CREATE PROCEDURE pro_test()
BEGIN
	-- ����д���sql���;
	SELECT * FROM employee;
END $

-- ִ�д洢����
CALL pro_test();

-- 3.1 ������������Ĵ洢����
-- ���󣺴���һ��Ա����id����ѯԱ����Ϣ
DELIMITER $
CREATE PROCEDURE pro_findById(IN eid INT)  -- IN: �������
BEGIN
	SELECT * FROM employee WHERE id=eid;
END $ 

-- ����
CALL pro_findById(4);

-- 3.2 ������������Ĵ洢����
DELIMITER $
CREATE PROCEDURE pro_testOut(OUT str VARCHAR(20))  -- OUT���������
BEGIN
        -- ��������ֵ
	SET str='helljava';
END $

-- ɾ���洢����
DROP PROCEDURE pro_testOut;
-- ����
-- ��ν��ܷ��ز�����ֵ����
-- ***mysql�ı���******
--  ȫ�ֱ��������ñ�������mysql���ݿ����õı��� ���������Ӷ������ã�
        -- �鿴����ȫ�ֱ����� show variables
        -- �鿴ĳ��ȫ�ֱ����� select @@������
        -- �޸�ȫ�ֱ����� set ������=��ֵ
        -- character_set_client: mysql�������Ľ������ݵı���
        -- character_set_results��mysql������������ݵı���
        
--  �Ự������ ֻ�����ڵ�ǰ�ͻ��������ݿ�������˵�һ�����ӵ��С�������ӶϿ�����ô�Ự����ȫ����ʧ��
        -- ����Ự����: set @����=ֵ
        -- �鿴�Ự������ select @����
        
-- �ֲ������� �ڴ洢������ʹ�õı����ͽоֲ�������ֻҪ�洢����ִ����ϣ��ֲ������Ͷ�ʧ����

-- 1)����һ���Ự����name, 2)ʹ��name�Ự�������մ洢���̵ķ���ֵ
CALL pro_testOut(@NAME);
-- �鿴����ֵ
SELECT @NAME;

-- 3.3 ����������������Ĵ洢����
DELIMITER $
CREATE PROCEDURE pro_testInOut(INOUT n INT)  -- INOUT�� �����������
BEGIN
   -- �鿴����
   SELECT n;
   SET n =500;
END $

-- ����
SET @n=10;

CALL pro_testInOut(@n);

SELECT @n;

-- 3.4 ���������жϵĴ洢����
-- ��������һ�����������1���򷵻ء�����һ��,���2�����ء����ڶ���,���3�����ء������������������֣����ء��������롱;
DELIMITER $
CREATE PROCEDURE pro_testIf(IN num INT,OUT str VARCHAR(20))
BEGIN
	IF num=1 THEN
		SET str='����һ';
	ELSEIF num=2 THEN
		SET str='���ڶ�';
	ELSEIF num=3 THEN
		SET str='������';
	ELSE
		SET str='�������';
	END IF;
END $

CALL pro_testIf(4,@str);
 
SELECT @str;

-- 3.5 ����ѭ�����ܵĴ洢����
-- ���� ����һ����������͡����磬����100��ͳ��1-100�ĺ�
DELIMITER $
CREATE PROCEDURE pro_testWhile(IN num INT,OUT result INT)
BEGIN
	-- ����һ���ֲ�����
	DECLARE i INT DEFAULT 1;
	DECLARE vsum INT DEFAULT 0;
	WHILE i<=num DO
	      SET vsum = vsum+i;
	      SET i=i+1;
	END WHILE;
	SET result=vsum;
END $

DROP PROCEDURE pro_testWhile;


CALL pro_testWhile(100,@result);

SELECT @result;

USE day16;

-- 3.6 ʹ�ò�ѯ�Ľ����ֵ��������INTO��
DELIMITER $
CREATE PROCEDURE pro_findById2(IN eid INT,OUT vname VARCHAR(20) )
BEGIN
	SELECT empName INTO vname FROM employee WHERE id=eid;
END $

CALL pro_findById2(1,@NAME);

SELECT @NAME;


USE day15;

SELECT * FROM student2;

-- ��ϰ�� ��дһ���洢���� 
	���ѧ����Ӣ��ƽ����С�ڵ���70�֣������'һ��'
	���ѧ����Ӣ��ƽ���ִ���70�֣���С�ڵ���90�֣�����������á�
	���ѧ����Ӣ��ƽ���ִ���90�֣�����������㡯
	
DELIMITER $
CREATE PROCEDURE pro_testAvg(OUT str VARCHAR(20))
BEGIN 
      -- ����ֲ�����������ƽ����
      DECLARE savg DOUBLE;
      -- ����Ӣ��ƽ����
      SELECT AVG(english) INTO savg FROM student2;
      IF savg<=70 THEN
           SET str='һ��';
      ELSEIF savg>70 AND savg<=90 THEN
           SET str='����';
      ELSE
	   SET str='����';
      END IF;
END $

CALL pro_testAvg(@str);

SELECT @str;


-- ************�ġ�������*****************
SELECT * FROM employee;

-- ��־��
CREATE TABLE test_log(
	id INT PRIMARY KEY AUTO_INCREMENT,
	content VARCHAR(100)
)

-- ���� ����Ա�������һ����¼ʱ��ϣ��mysql�Զ�ͬʱ����־���������
-- ����������(���)
CREATE TRIGGER tri_empAdd AFTER INSERT ON employee FOR EACH ROW    -- ����Ա�������һ����¼ʱ
     INSERT INTO test_log(content) VALUES('Ա���������һ����¼');
     
-- ��������
INSERT INTO employee(id,empName,deptId) VALUES(7,'����˹',1);
INSERT INTO employee(id,empName,deptId) VALUES(8,'����˹2',1);

-- ����������(�޸�)
CREATE TRIGGER tri_empUpd AFTER UPDATE ON employee FOR EACH ROW    -- ����Ա�����޸�һ����¼ʱ
     INSERT INTO test_log(content) VALUES('Ա�����޸���һ����¼');
     
 -- �޸�
 UPDATE employee SET empName='eric' WHERE id=7;
 
-- ����������(ɾ��)
CREATE TRIGGER tri_empDel AFTER DELETE ON employee FOR EACH ROW    -- ����Ա����ɾ��һ����¼ʱ
     INSERT INTO test_log(content) VALUES('Ա����ɾ����һ����¼');
  
 -- ɾ��
 DELETE FROM employee WHERE id=7;
 
 SELECT * FROM employee;
 SELECT * FROM test_log;
 
 -- ***********�塢mysqlȨ������****************
 -- mysql���ݿ�Ȩ�����⣺root ��ӵ������Ȩ�ޣ����Ը��κ����飩
 -- Ȩ���˻���ֻӵ�в���Ȩ�ޣ�CURD�����磬ֻ�ܲ���ĳ�����ݿ��ĳ�ű�
 -- ����޸�mysql���û����룿
 -- password: md5���ܺ���(�������)
 SELECT PASSWORD('root'); -- *81F5E21E35407D884A6CD4A731AEBFB6AF209E1B
 
--  mysql���ݿ⣬�û����� : user��
USE mysql;

SELECT * FROM USER;

-- �޸�����
UPDATE USER SET PASSWORD=PASSWORD('123456') WHERE USER='root';

-- ����Ȩ���˻�
GRANT SELECT ON day16.employee TO 'eric'@'localhost' IDENTIFIED BY '123456';
GRANT DELETE ON day16.employee TO 'eric'@'localhost' IDENTIFIED BY '123456';





 
 
 
