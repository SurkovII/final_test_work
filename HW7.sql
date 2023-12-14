DROP TABLE IF EXISTS Task7;
CREATE DATABASE Task7;
use Task7;

#Создать таблицы, соответствующие иерархии из вашей диаграммы классов.

DROP TABLE IF exists animals;
CREATE TABLE animals (
	id INT PRIMARY KEY AUTO_INCREMENT,
	types_animals varchar(50)
);

INSERT INTO animals (types_animals) VALUES 
	('pet'),
	('pack_animal');

DROP TABLE IF EXISTS Pet;
CREATE TABLE pet (
	id INT PRIMARY KEY AUTO_INCREMENT,
    type_animal CHAR(30),
	types_animals CHAR(30)
);

INSERT INTO Pet (type_animal, types_animals) VALUES 
	('cat', 'animal'),
	('dog', 'animal'),
	('hamster', 'animal');

DROP TABLE IF EXISTS Pack_animal;
CREATE TABLE Pack_animal (
	id INT PRIMARY KEY AUTO_INCREMENT,
    type_animal CHAR(30),
	types_animals CHAR(30)
);

INSERT INTO Pack_animal (type_animal, types_animals) VALUES 
	('camel', 'animal'),
	('horse', 'animal'),
	('donkey', 'animal');

DROP TABLE IF EXISTS cat;
CREATE TABLE cat (
	id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY, 
	name VARCHAR(50),
    type_animal CHAR(30),
    birthday Date,
    commands varchar(50)
);

DROP TABLE IF EXISTS dog;
CREATE TABLE dog (
	id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY, 
	name VARCHAR(50),
    type_animal CHAR(30),
    birthday Date,
    commands varchar(50)
);

DROP TABLE IF EXISTS Hamster;
CREATE TABLE Hamster (
	id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY, 
	name VARCHAR(50),
    type_animal CHAR(30),
    birthday Date,
    commands varchar(50)
);

DROP TABLE IF EXISTS camel;
CREATE TABLE camel (
	id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY, 
	name VARCHAR(50),
    type_animal CHAR(30),
    birthday Date,
    commands varchar(50)
);

DROP TABLE IF EXISTS donkey;
CREATE TABLE donkey (
	id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY, 
	name VARCHAR(50),
    type_animal CHAR(30),
    birthday Date,
    commands varchar(50)
);

DROP TABLE IF EXISTS horse;
CREATE TABLE horse (
	id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY, 
	name VARCHAR(50),
    type_animal CHAR(30),
    birthday Date,
    commands varchar(50)
);


# Заполнить таблицы данными о животных, их командах и датами рождения.

insert into dog (name, type_animal, birthday, commands) values
('Fido', 'dog', '2020-01-01', 'Sit, Stay, fetch'),
('Buddy',	'dog',	'2018-12-10',	'Sit, Paw, Bark'),
('Bella', 'dog', '2019-11-11', 'Sit, Stay, Roll');


insert into cat (name, type_animal, birthday, commands) values
('Whiskers', 'cat',	'2019-05-15', 'Sit, Pounce'),
('Smudge',	'cat',	'2020-02-20', 'Sit, Pounce, Scratch'),
('Oliver', 'cat', '2020-06-30', 'Meow, Scratch, Jump');

insert into Hamster (name, type_animal, birthday, commands) values
('Peanut',	'Hamster',	'2021-08-01',	'Roll, Spin'),
('Hammy', 'Hamster', '2021-03-10', 'Roll, Hide');

insert into horse (name, type_animal, birthday, commands) values
('Thunder', 'horse', '2015-07-21', 'Trot, Canter, Gallop'),
('Storm',	'horse',	'2014-05-05',	'Trot, Canter'),
('Blaze', 'horse', '2016-02-29', 'Trot, Jump, Gallop');


insert into camel (name, type_animal, birthday, commands) values
('Sandy', 'camel',	'2016-11-03', 'Walk, Carry Load'),
('Dune',	'camel',	'2018-12-12', 'Walk, Sit'),
('Sahara', 'camel', '2015-08-14', 'Walk, Run');

insert into donkey  (name, type_animal, birthday, commands) values
('Eeyore', 'donkey', '2017-09-18', 'Walk, Carry Load, Bray'),
('Burro',	'donkey',	'2019-01-23',	'Walk, Bray, Kick');

# Удалить записи о верблюдах 
start transaction;
	delete from Pack_animal 
	where type_animal = 'Camel';
	drop table camel;
commit;


# Объединить таблицы лошадей и ослов
INSERT INTO horse (name, type_animal, birthday, commands)
SELECT name, type_animal, birthday, commands
FROM donkey;

rename table horse to horse_and_donkey;

drop table donkey;


# Создать новую таблицу для животных в возрасте от 1 до 3 лет и вычислить их возраст с точностью до месяца
DROP TABLE IF EXISTS litle_animal;
CREATE TABLE litle_animal (
	id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY, 
	name VARCHAR(50),
    type_animal CHAR(30),
    birthday Date,
    commands varchar(50),
    age varchar(50)
);


INSERT INTO litle_animal (name , type_animal,  commands , birthday, age)
SELECT name, type_animal, commands, birthday,  CONCAT(TIMESTAMPDIFF(year , birthday, NOW()), ' years ',TIMESTAMPDIFF(MONTH, birthday, CURDATE()) % 12,' month')
FROM dog
WHERE (TIMESTAMPDIFF(YEAR, birthday, now()) BETWEEN 1 AND 2) or (TIMESTAMPDIFF(month, birthday, now()) = 36)
UNION ALL
SELECT name, type_animal, commands, birthday,  CONCAT(TIMESTAMPDIFF(year , birthday, NOW()), ' years ',TIMESTAMPDIFF(MONTH, birthday, CURDATE()) % 12,' month')
FROM cat
WHERE (TIMESTAMPDIFF(YEAR, birthday, now()) BETWEEN 1 AND 2) or (TIMESTAMPDIFF(month, birthday, now()) = 36)
UNION ALL
SELECT name, type_animal, commands, birthday,  CONCAT(TIMESTAMPDIFF(year , birthday, NOW()), ' years ',TIMESTAMPDIFF(MONTH, birthday, CURDATE()) % 12,' month')
FROM hamster
WHERE (TIMESTAMPDIFF(YEAR, birthday, now()) BETWEEN 1 AND 2) or (TIMESTAMPDIFF(month, birthday, now()) = 36)
UNION ALL
SELECT name, type_animal, commands, birthday,  CONCAT(TIMESTAMPDIFF(year , birthday, NOW()), ' years ',TIMESTAMPDIFF(MONTH, birthday, CURDATE()) % 12,' month')
FROM horse_and_donkey
WHERE (TIMESTAMPDIFF(YEAR, birthday, now()) BETWEEN 1 AND 2) or (TIMESTAMPDIFF(month, birthday, now()) = 36)
;


select * from litle_animal;


# Объединить все созданные таблицы в одну, сохраняя информацию о принадлежности к исходным таблицам.

DROP TABLE IF EXISTS all_table;
CREATE TABLE all_table (
	id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY, 
	name VARCHAR(50),
    type_animal CHAR(30),
    birthday Date,
    commands varchar(50),
    age varchar(50),
    use_table varchar(50) NOT NULL

);

insert into all_table (name, type_animal,  commands, birthday, age, use_table) 
SELECT name, type_animal,   commands, birthday,  CONCAT(TIMESTAMPDIFF(year , birthday, NOW()), ' years ',TIMESTAMPDIFF(MONTH, birthday, CURDATE()) % 12,' month'), 'cat'
FROM cat
union all
SELECT name, type_animal,   commands, birthday,  CONCAT(TIMESTAMPDIFF(year , birthday, NOW()), ' years ',TIMESTAMPDIFF(MONTH, birthday, CURDATE()) % 12,' month'), 'dog'
FROM dog
union all
SELECT name, type_animal,   commands, birthday,  CONCAT(TIMESTAMPDIFF(year , birthday, NOW()), ' years ',TIMESTAMPDIFF(MONTH, birthday, CURDATE()) % 12,' month'), 'hamster'
FROM hamster
union all
SELECT name, type_animal,   commands, birthday,  CONCAT(TIMESTAMPDIFF(year , birthday, NOW()), ' years ',TIMESTAMPDIFF(MONTH, birthday, CURDATE()) % 12,' month'), 'horse_and_donkey'
FROM horse_and_donkey
union all
SELECT name, type_animal,   commands, birthday,  CONCAT(TIMESTAMPDIFF(year , birthday, NOW()), ' years ',TIMESTAMPDIFF(MONTH, birthday, CURDATE()) % 12,' month'), 'litle_animal'
FROM litle_animal;



select * from all_table;





