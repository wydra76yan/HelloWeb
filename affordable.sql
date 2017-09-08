/*
SQLyog Ultimate v11.52 (64 bit)
MySQL - 5.7.16 
*********************************************************************
*/
/*!40101 SET NAMES utf8 */;

create table `posts` (
	`id` int (11),
	`txt` varchar (675)
); 
insert into `posts` (`id`, `txt`) values('126','Oleg Vydra');
insert into `posts` (`id`, `txt`) values('129','Yan Vydra');
insert into `posts` (`id`, `txt`) values('130','Maya Vydra Olegovna');
insert into `posts` (`id`, `txt`) values('134','test test1');


DELIMITER $$

USE `test`$$

DROP PROCEDURE IF EXISTS `post_save`$$

CREATE PROCEDURE `post_save`(IN param1 VARCHAR(220))
BEGIN
       INSERT INTO posts(txt) VALUES (param1);
END$$

DELIMITER ;