CREATE DATABASE mybatis_plus;

CREATE TABLE mptest(
`id` INT(9) NOT NULL PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(50) NOT NULL,
`age` INT(9) NOT NULL,
`gender` INT(1) NOT NULL,
create_time DATE NOT NULL
)ENGINE = INNODB CHARACTER SET = utf8 COLLATE = utf8_general_ci;

INSERT INTO mptest(`name`,age,gender)
VALUES('东方',19,1),('西方',29,2),('南方',39,2),('北方',49,1),('qwe',59,1),('asd',55,2);


CREATE TABLE mptests(
`id` INT(9) NOT NULL PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(50) NOT NULL,
`age` INT(9) NOT NULL,
`gender` INT(1) NOT NULL,
deleted INT(1) NOT NULL DEFAULT '0',
`version` INT (1) NOT NULL DEFAULT '1',
create_time DATETIME DEFAULT '2020-12-01 12:12:12',
update_time DATETIME
)ENGINE = INNODB CHARACTER SET = utf8 COLLATE = utf8_general_ci;


INSERT INTO mptests(`name`,age,gender)
VALUES('东方',19,1),('西方',29,2),('南方',39,2),('北方',49,1),('qwe',59,1),('asd',55,2);
