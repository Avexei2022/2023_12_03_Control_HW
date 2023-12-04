-- Создаю базу данных "Human Friends" 

CREATE DATABASE Human_Friends;



-- Использую базу данных "Human Friends" 

USE Human_Friends;




-- Создаю таблицу групп животных и заполняю её

CREATE TABLE animals_groups(
	id SERIAL PRIMARY KEY, 
	name_group VARCHAR(20) UNIQUE NOT NULL
	);

INSERT INTO animals_groups (name_group)
VALUES ('Pets'), ('Pack Animals');

SELECT * FROM animals_groups;

-- id|name_group  |
-- --+------------+
--  2|Pack Animals|
--  1|Pets        |




-- Создаю таблицу типов животных,
-- связанную с таблицей групп животных и заполняю её

CREATE TABLE animals_types (
	id SERIAL PRIMARY KEY, 
	group_id BIGINT UNSIGNED NOT NULL,
	name_type VARCHAR(20) UNIQUE NOT NULL,
	FOREIGN KEY (group_id) REFERENCES animals_groups(id) 
		ON UPDATE CASCADE ON DELETE CASCADE
);

INSERT INTO animals_types (group_id, name_type)
VALUES (1, 'Cat'), (1, 'Dog'), (1, 'Hamster'),
(2, 'Horse'), (2, 'Camel'), (2, 'Donkey');

SELECT * FROM animals_types;

-- id|group_id|name_type|
-- --+--------+---------+
--  1|       1|Cat      |
--  2|       1|Dog      |
--  3|       1|Hamster  |
--  4|       2|Horse    |
--  5|       2|Camel    |
--  6|       2|Donkey   |




-- Создаю таблицу реальных животных,
-- связанную с таблицей типов животных и заполняю её

CREATE TABLE animals (
	id SERIAL PRIMARY KEY,
	type_id BIGINT UNSIGNED NOT NULL,
	name VARCHAR(20) NOT NULL,
	birthday DATE,
	FOREIGN KEY (type_id) REFERENCES animals_types(id) 
		ON UPDATE CASCADE ON DELETE CASCADE
);

INSERT INTO animals (type_id, name, birthday)
VALUES 
(2, 'Fido', '2021-01-01'),
(1, 'Whiskers', '2020-05-15'),
(3, 'Hammy', '2022-03-10'),
(2, 'Buddy', '2019-12-10'),
(1, 'Smudge', '2021-02-20'),
(3, 'Peanut', '2022-08-01'),
(2, 'Bella', '2020-11-11'),
(1, 'Oliver', '2021-06-30'),
(4, 'Thunder', '2016-07-21'),
(5, 'Sandy', '2017-11-03'),
(6, 'Eeyore', '2018-09-18'),
(4, 'Storm', '2015-05-05'),
(5, 'Dune', '2019-12-12'),
(6, 'Burro', '2020-01-23'),
(4, 'Blaze', '2017-02-28'),
(5, 'Sahara', '2016-08-14');

SELECT * FROM animals;

-- id|type_id|name    |birthday  |
-- --+-------+--------+----------+
--  1|      2|Fido    |2021-01-01|
--  2|      1|Whiskers|2020-05-15|
--  3|      3|Hammy   |2022-03-10|
--  4|      2|Buddy   |2019-12-10|
--  5|      1|Smudge  |2021-02-20|
--  6|      3|Peanut  |2022-08-01|
--  7|      2|Bella   |2020-11-11|
--  8|      1|Oliver  |2021-06-30|
--  9|      4|Thunder |2016-07-21|
-- 10|      5|Sandy   |2017-11-03|
-- 11|      6|Eeyore  |2018-09-18|
-- 12|      4|Storm   |2015-05-05|
-- 13|      5|Dune    |2019-12-12|
-- 14|      6|Burro   |2020-01-23|
-- 15|      4|Blaze   |2017-02-28|
-- 16|      5|Sahara  |2016-08-14|




-- Создаю таблицу-справочник возможных команд,
--  выполняемых животными

CREATE TABLE commands (
	id SERIAL PRIMARY KEY,
	command VARCHAR(20) UNIQUE NOT NULL
);

INSERT INTO commands (command)
VALUES
('Sit'),
('Stay'),
('Fetch'),
('Pounce'),
('Roll'),
('Hide'),
('Paw'),
('Bark'),
('Scratch'),
('Spin'),
('Meow'),
('Jump'),
('Trot'),
('Ganter'),
('Gallop'),
('Walk'),
('Carry Load'),
('Bray'),
('Kick'),
('Run');

SELECT * FROM commands;

-- id|command   |
-- --+----------+
--  8|Bark      |
-- 18|Bray      |
-- 17|Carry Load|
--  3|Fetch     |
-- 15|Gallop    |
-- 14|Ganter    |
--  6|Hide      |
-- 12|Jump      |
-- 19|Kick      |
-- 11|Meow      |
--  7|Paw       |
--  4|Pounce    |
--  5|Roll      |
-- 20|Run       |
--  9|Scratch   |
--  1|Sit       |
-- 10|Spin      |
--  2|Stay      |
-- 13|Trot      |
-- 16|Walk      |




-- Создаю таблицу команд, выполняемых реальными животными,
-- связанную с таблицей реальных животных и справочником команд

CREATE TABLE animal_command (
	animal_id BIGINT UNSIGNED NOT NULL,
	command_id BIGINT UNSIGNED NOT NULL,
	PRIMARY KEY (animal_id, command_id),
	FOREIGN KEY (animal_id) REFERENCES animals(id) 
		ON UPDATE CASCADE ON DELETE CASCADE,
	FOREIGN KEY (command_id) REFERENCES commands(id) 
		ON UPDATE CASCADE ON DELETE CASCADE
);

INSERT INTO animal_command (animal_id, command_id)
VALUES
(1, 1), (1, 2), (1, 3),
(2, 1), (2, 4),
(3, 5), (3, 6),
(4, 1), (4, 7), (4, 8),
(5, 1), (5, 4), (5, 9),
(6, 5), (6, 10),
(7, 1), (7, 2), (7, 5),
(8, 11), (8, 9), (8, 12),
(9, 13), (9, 14), (9, 15),
(10, 16), (10, 17),
(11, 16), (11, 17), (11, 18),
(12, 13), (12, 14),
(13, 16), (13, 1),
(14, 16), (14, 18), (14, 19),
(15, 13), (15, 12), (15, 15),
(16, 16), (16, 20);

SELECT * FROM animal_command;

-- animal_id|command_id|
-- ---------+----------+
--         1|         1|
--         2|         1|
--         4|         1|
--         5|         1|
--         7|         1|
--        13|         1|
--         1|         2|
--         7|         2|
--         1|         3|
--         2|         4|
--         5|         4|
--         3|         5|
--         6|         5|
--         7|         5|
--         3|         6|
--         4|         7|
--         4|         8|
--         5|         9|
--         8|         9|
--         6|        10|
--         8|        11|
--         8|        12|
--        15|        12|
--         9|        13|
--        12|        13|
--        15|        13|
--         9|        14|
--        12|        14|
--         9|        15|
--        15|        15|
--        10|        16|
--        11|        16|
--        13|        16|
--        14|        16|
--        16|        16|
--        10|        17|
--        11|        17|
--        11|        18|
--        14|        18|
--        14|        19|
--        16|        20|



-- Объединяю все созданные таблицы в одно представление для дальнейшего использования 
-- и вывожу данное представление

CREATE OR REPLACE VIEW v_human_friends AS
(SELECT 
	a.id AS 'ID',
	a.name AS 'Name',
	at2.name_type AS '_Type',
	ag.name_group AS '_Group',
	a.birthday AS 'BirthDay',
	GROUP_CONCAT(' ', c.command) AS 'Commands'
FROM animals a 
JOIN animals_types at2 ON a.type_id = at2.id 
JOIN animals_groups ag ON at2.group_id = ag.id
JOIN animal_command ac ON a.id = ac.animal_id 
JOIN commands c ON ac.command_id = c.id 
GROUP BY a.id);

SELECT * FROM v_human_friends;

-- ID|Name    |_Type  |_Group      |BirthDay  |Commands               |
-- --+--------+-------+------------+----------+-----------------------+
--  1|Fido    |Dog    |Pets        |2021-01-01| Sit, Stay, Fetch      |
--  2|Whiskers|Cat    |Pets        |2020-05-15| Sit, Pounce           |
--  3|Hammy   |Hamster|Pets        |2022-03-10| Hide, Roll            |
--  4|Buddy   |Dog    |Pets        |2019-12-10| Bark, Sit, Paw        |
--  5|Smudge  |Cat    |Pets        |2021-02-20| Sit, Pounce, Scratch  |
--  6|Peanut  |Hamster|Pets        |2022-08-01| Roll, Spin            |
--  7|Bella   |Dog    |Pets        |2020-11-11| Sit, Stay, Roll       |
--  8|Oliver  |Cat    |Pets        |2021-06-30| Scratch, Meow, Jump   |
--  9|Thunder |Horse  |Pack Animals|2016-07-21| Trot, Ganter, Gallop  |
-- 10|Sandy   |Camel  |Pack Animals|2017-11-03| Walk, Carry Load      |
-- 11|Eeyore  |Donkey |Pack Animals|2018-09-18| Walk, Carry Load, Bray|
-- 12|Storm   |Horse  |Pack Animals|2015-05-05| Trot, Ganter          |
-- 13|Dune    |Camel  |Pack Animals|2019-12-12| Sit, Walk             |
-- 14|Burro   |Donkey |Pack Animals|2020-01-23| Walk, Bray, Kick      |
-- 15|Blaze   |Horse  |Pack Animals|2017-02-28| Jump, Trot, Gallop    |
-- 16|Sahara  |Camel  |Pack Animals|2016-08-14| Walk, Run             |



-- Создаю временную таблицу животных из группы "Pack Animals",
-- Удаляю записи о верблюдах из временной таблицы, 
-- и вывожу записи лошадей и ослов, для порядка с применением WHERE,
-- вдруг неожиданно кто лишний в таблицу попал.

DROP TABLE IF EXISTS tbl_pack_animals;
CREATE TEMPORARY TABLE tbl_pack_animals
SELECT * FROM v_human_friends
WHERE _group = 'Pack Animals';

DELETE FROM tbl_pack_animals
WHERE _type = 'Camel';

SELECT * FROM tbl_pack_animals
WHERE _type = 'Horse' OR _type = 'Donkey';

-- ID|Name   |_Type |_Group      |BirthDay  |Commands               |
-- --+-------+------+------------+----------+-----------------------+
--  9|Thunder|Horse |Pack Animals|2016-07-21| Trot, Ganter, Gallop  |
-- 11|Eeyore |Donkey|Pack Animals|2018-09-18| Walk, Carry Load, Bray|
-- 12|Storm  |Horse |Pack Animals|2015-05-05| Trot, Ganter          |
-- 14|Burro  |Donkey|Pack Animals|2020-01-23| Walk, Bray, Kick      |
-- 15|Blaze  |Horse |Pack Animals|2017-02-28| Jump, Trot, Gallop    |




-- Вывожу список животных в возрасте старше 1 года, но младше 3 лет 
-- и вычисляю их возраст с точностью до месяца

SELECT 
	*,
	CONCAT(TIMESTAMPDIFF(YEAR, birthday, CURDATE()), ' years, ',
	TIMESTAMPDIFF(MONTH, birthday, CURDATE())%12, ' monthes') AS 'Age'
FROM v_human_friends
WHERE TIMESTAMPDIFF(YEAR, birthday, CURDATE()) BETWEEN 1 AND 2;

-- ID|Name  |_Type  |_Group|BirthDay  |Commands             |Age                |
-- --+------+-------+------+----------+---------------------+-------------------+
--  1|Fido  |Dog    |Pets  |2021-01-01| Sit, Stay, Fetch    |2 years, 11 monthes|
--  3|Hammy |Hamster|Pets  |2022-03-10| Hide, Roll          |1 years, 8 monthes |
--  5|Smudge|Cat    |Pets  |2021-02-20| Sit, Pounce, Scratch|2 years, 9 monthes |
--  6|Peanut|Hamster|Pets  |2022-08-01| Roll, Spin          |1 years, 4 monthes |
--  8|Oliver|Cat    |Pets  |2021-06-30| Scratch, Meow, Jump |2 years, 5 monthes |




-- Вывожу список всех животных с объединенными данными, включая возраст 

SELECT 
	*,
	CONCAT(TIMESTAMPDIFF(YEAR, birthday, CURDATE()), ' years, ',
	TIMESTAMPDIFF(MONTH, birthday, CURDATE())%12, ' monthes') AS 'Age'
FROM v_human_friends;

-- ID|Name    |_Type  |_Group      |BirthDay  |Commands               |Age                |
-- --+--------+-------+------------+----------+-----------------------+-------------------+
--  1|Fido    |Dog    |Pets        |2021-01-01| Sit, Stay, Fetch      |2 years, 11 monthes|
--  2|Whiskers|Cat    |Pets        |2020-05-15| Sit, Pounce           |3 years, 6 monthes |
--  3|Hammy   |Hamster|Pets        |2022-03-10| Hide, Roll            |1 years, 8 monthes |
--  4|Buddy   |Dog    |Pets        |2019-12-10| Bark, Sit, Paw        |3 years, 11 monthes|
--  5|Smudge  |Cat    |Pets        |2021-02-20| Sit, Pounce, Scratch  |2 years, 9 monthes |
--  6|Peanut  |Hamster|Pets        |2022-08-01| Roll, Spin            |1 years, 4 monthes |
--  7|Bella   |Dog    |Pets        |2020-11-11| Sit, Stay, Roll       |3 years, 0 monthes |
--  8|Oliver  |Cat    |Pets        |2021-06-30| Scratch, Meow, Jump   |2 years, 5 monthes |
--  9|Thunder |Horse  |Pack Animals|2016-07-21| Trot, Ganter, Gallop  |7 years, 4 monthes |
-- 10|Sandy   |Camel  |Pack Animals|2017-11-03| Walk, Carry Load      |6 years, 1 monthes |
-- 11|Eeyore  |Donkey |Pack Animals|2018-09-18| Walk, Carry Load, Bray|5 years, 2 monthes |
-- 12|Storm   |Horse  |Pack Animals|2015-05-05| Trot, Ganter          |8 years, 6 monthes |
-- 13|Dune    |Camel  |Pack Animals|2019-12-12| Sit, Walk             |3 years, 11 monthes|
-- 14|Burro   |Donkey |Pack Animals|2020-01-23| Walk, Bray, Kick      |3 years, 10 monthes|
-- 15|Blaze   |Horse  |Pack Animals|2017-02-28| Jump, Trot, Gallop    |6 years, 9 monthes |
-- 16|Sahara  |Camel  |Pack Animals|2016-08-14| Walk, Run             |7 years, 3 monthes |

