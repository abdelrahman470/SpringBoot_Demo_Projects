CREATE DATABASE  IF NOT EXISTS `employee_directory02`;
USE `employee_directory02`;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Data for table `employee`
--

INSERT INTO `employee` VALUES 
	(1,'Leslie','Andrews','leslie@luv2code.com'),
	(2,'Emma','Baumgarten','emma@luv2code.com'),
	(3,'Avani','Gupta','avani@luv2code.com'),
	(4,'Yuri','Petrov','yuri@luv2code.com'),
	(5,'Juan','Vega','juan@luv2code.com'),
	(6,	'Leslie','Andrews','leslie@luv2code.com'),
	(7,'Emma','Baumgarten','emma@gmail.com'),
	(8,	'Rick','Grimes','rick3223@gmail.com'),
	(9,'Yuri','Petrov','yuri@gmail.com'),
	(10,'Abdo','Abdelkawy','abdo122320.com'),
	(11,'jail','hemo','jail4330.com'),
	(12,'mikel','tail','tail4sdc0@gmail.com'),
	(13,'lily','mikel','lily43344@gmail.com');

