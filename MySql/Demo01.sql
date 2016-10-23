/*显示所有数据库*/
SHOW DATABASES;
/*创建数据库*/
CREATE DATABASE Demo01;
/*删除数据库*/
DROP DATABASE Demo01;
/*查看数据表*/
USE USER;
/*使用user数据库*/
SHOW TABLES;
/*创建表*/
CREATE DATABASE Demo01;
/*创建数据库*/
USE Demo01;
CREATE TABLE student(
	sid INT,
	sname VARCHAR(20),
	sage INT
);
/*查看表结构*/
DESC student;
/*删除表*/
DROP TABLE student;
/*修改表*/
/*添加字段*/
ALTER TABLE student ADD COLUMN sgender VARCHAR(2);
DESC student;
/*修改字段类型*/
ALTER TABLE student MODIFY COLUMN sgender VARCHAR(4);
/*修改字段名称*/
ALTER TABLE student CHANGE COLUMN sgender gender VARCHAR(2);
/*删除字段*/
ALTER TABLE student DROP COLUMN gender;
/*修改表名称*/
ALTER TABLE student RENAME TO teachar;
DESC teachar;
/*增删改数据*/
/*增加数据*/
INSERT INTO teachar VALUES (1, "张三", 23);
SELECT * FROM teachar;
INSERT INTO teachar(sid, sname) VALUES (4,"李四");
/*修改数据*/
UPDATE teachar SET sage=23 WHERE sid=2;
/*删除数据*/
DELETE FROM teachar WHERE sid=2;
/*
另一种方式
delete from: 可以全表删除      1)可以带条件删除  2）只能删除表的数据，不能删除表的约束     3)使用delete from删除的数据可以回滚（事务）
truncate table: 可以全表删除   1）不能带条件删除 2）即可以删除表的数据，也可以删除表的约束 3）使用truncate table删除的数据不能回滚
TRUNCATE TABLE student;
*/

/*查询*/
/*查询所有列*/
INSERT INTO teachar VALUES (3, "王五", 25);
SELECT * FROM teachar;
/*查询指定列*/
SELECT sid,sname FROM teachar;
/*查询时去除重复记录*/
SELECT DISTINCT sage FROM teachar;
/*查询时合并列*/
SELECT sid, sname, (sid+sage) AS "合并" FROM teachar;
/*条件查询*/
SELECT *FROM teachar WHERE sid=2 AND sname="李四";
SELECT *FROM teachar WHERE sid=2 OR sname="张三";
SELECT *FROM teachar WHERE sage > 24;
SELECT * FROM teachar WHERE sage BETWEEN 23 AND 25; -- (包前包后)
/*判断（null和空字符串）*/
/*
-- null vs  空字符串
-- null：表示没有值
-- 空字符串：有值的！
*/
SELECT * FROM teachar WHERE sage IS NULL;
SELECT * FROM teachar WHERE sage="";
/*模糊条件 like*/
/*
-- 通常使用以下替换标记：
-- % : 表示任意个字符
-- _ : 表示一个字符
*/

SELECT * FROM teachar WHERE sname LIKE '张%';

/*
聚合查询
 聚合查询（使用聚合函数的查询）
 -- 常用的聚合函数： sum()  avg()  max()  min()  count()
-- 需求：查询学生的servlet的总成绩 (sum() :求和函数)
SELECT SUM(servlet) AS 'servlet的总成绩' FROM student;

-- 需求： 查询学生的servlet的平均分
SELECT AVG(servlet) AS 'servlet的平均分' FROM student;

-- 需求: 查询当前servlet最高分
SELECT MAX(servlet) AS '最高分' FROM student;

-- 需求： 查询最低分
SELECT MIN(servlet) AS '最低分' FROM student;

-- 需求： 统计当前有多少学生(count(字段))
SELECT COUNT(*) FROM student;

SELECT COUNT(id) FROM student;

-- 注意：count（）函数统计的数量不包含null的数据
-- 使用count统计表的记录数，要使用不包含null值的字段
SELECT COUNT(age) FROM student;
*/
/*
分页查询
--分页查询（limit 起始行,查询几行）
-- 起始行从0开始
-- 分页：当前页  每页显示多少条
-- 分页查询当前页的数据的sql: SELECT * FROM student LIMIT (当前页-1)*每页显示多少条,每页显示多少条;

-- 需求： 查询第1,2条记录（第1页的数据）
SELECT * FROM student LIMIT 0,2;
-- 查询第3,4条记录（第2页的数据）
SELECT * FROM student LIMIT 2,2;
-- 查询第5,6条记录（第3页的数据）
SELECT * FROM student LIMIT 4,2;
-- 查询第7,8条记录 (没有记录不显示)
SELECT * FROM student LIMIT 6,2;
*/

/*
查询排序
--  查询排序（order by ）
-- 语法 ：order by 字段 asc/desc
-- asc: 顺序，正序。数值：递增，字母：自然顺序（a-z）
-- desc: 倒序，反序。数值：递减，字母：自然反序(z-a)

-- 默认情况下，按照插入记录顺序排序
SELECT * FROM student;

-- 需求： 按照id顺序排序
SELECT * FROM student ORDER BY id ASC;
SELECT * FROM student ORDER BY id; -- 默认正序

SELECT * FROM student ORDER BY id DESC;-- 反序

-- 注意：多个排序条件
-- 需求： 按照servlet正序，按照jsp的倒序
SELECT * FROM student ORDER BY servlet ASC,jsp DESC;
*/

/*
分组查询
-- 分组查询(group by)
-- 需求： 查询男女的人数
-- 预期结果：
  --  男   3
  --- 女   2
  -- 1) 把学生按照性别分组(GROUP BY gender)
  -- 2) 统计每组的人数(COUNT(*))
SELECT gender,COUNT(*) FROM student GROUP BY gender;

*/

/*
分组查询后筛选
-- 分组查询后筛选
-- 需求： 查询总人数大于2的性别
-- 1) 查询男女的人数
-- 2）筛选出人数大于2的记录(having)
--- 注意： 分组之前条件使用where关键字，分组之前条件使用having关键字
SELECT gender,COUNT(*) FROM student WHERE GROUP BY gender HAVING COUNT(*)>2;

*/