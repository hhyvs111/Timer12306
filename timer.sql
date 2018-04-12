/*
SQLyog Ultimate v12.08 (32 bit)
MySQL - 5.1.55-community : Database - timer
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`timer` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `timer`;

/*Table structure for table `orderinfo` */

DROP TABLE IF EXISTS `orderinfo`;

CREATE TABLE `orderinfo` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `status` varchar(100) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `payTime` datetime DEFAULT NULL,
  `lastUpdateDate` datetime DEFAULT NULL,
  `price` int(100) DEFAULT NULL,
  `userId` int(10) DEFAULT NULL,
  `routeId` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `userId` (`userId`),
  KEY `routeId` (`routeId`),
  CONSTRAINT `orderinfo_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `user` (`id`),
  CONSTRAINT `orderinfo_ibfk_2` FOREIGN KEY (`routeId`) REFERENCES `route` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8;

/*Data for the table `orderinfo` */

/*Table structure for table `route` */

DROP TABLE IF EXISTS `route`;

CREATE TABLE `route` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `trainType` varchar(100) DEFAULT NULL,
  `fromStation` varchar(100) DEFAULT NULL,
  `toStation` varchar(100) DEFAULT NULL,
  `departureTime` datetime DEFAULT NULL,
  `arrivalTime` datetime DEFAULT NULL,
  `businessSeatCount` int(10) DEFAULT NULL,
  `bPrice` int(100) DEFAULT NULL,
  `specialSeatCount` int(10) DEFAULT NULL,
  `spPrice` int(100) DEFAULT NULL,
  `softSeatCount` int(10) DEFAULT NULL,
  `sfPrice` int(100) DEFAULT NULL,
  `hardSeatCount` int(10) DEFAULT NULL,
  `hPrice` int(100) DEFAULT NULL,
  `noSeatCount` int(10) DEFAULT NULL,
  `nPrice` int(100) DEFAULT NULL,
  `remark` varchar(300) DEFAULT NULL,
  `fromStationId` int(10) DEFAULT NULL,
  `toStationId` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `from` (`fromStationId`),
  KEY `to` (`toStationId`),
  CONSTRAINT `from` FOREIGN KEY (`fromStationId`) REFERENCES `station` (`id`),
  CONSTRAINT `to` FOREIGN KEY (`toStationId`) REFERENCES `station` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

/*Data for the table `route` */

insert  into `route`(`id`,`name`,`trainType`,`fromStation`,`toStation`,`departureTime`,`arrivalTime`,`businessSeatCount`,`bPrice`,`specialSeatCount`,`spPrice`,`softSeatCount`,`sfPrice`,`hardSeatCount`,`hPrice`,`noSeatCount`,`nPrice`,`remark`,`fromStationId`,`toStationId`) values (9,'北京-上海','G123','北京','上海','2016-07-19 10:10:10','2016-07-20 07:07:07',990,500,399,400,298,300,399,200,399,100,'',8,9);

/*Table structure for table `station` */

DROP TABLE IF EXISTS `station`;

CREATE TABLE `station` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `level` varchar(100) DEFAULT NULL,
  `desb` varchar(400) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

/*Data for the table `station` */

insert  into `station`(`id`,`name`,`level`,`desb`) values (8,'北京','特级站','首都'),(9,'上海','特级站','经济'),(10,'长沙','一级站','湖南省会');

/*Table structure for table `ticket` */

DROP TABLE IF EXISTS `ticket`;

CREATE TABLE `ticket` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `route` varchar(100) DEFAULT NULL,
  `routeType` varchar(100) DEFAULT NULL,
  `seatNum` varchar(100) DEFAULT NULL,
  `seatType` varchar(100) DEFAULT NULL,
  `departureTime` datetime DEFAULT NULL,
  `price` int(100) DEFAULT NULL,
  `fromPlace` varchar(100) DEFAULT NULL,
  `toPlace` varchar(100) DEFAULT NULL,
  `remark` varchar(200) DEFAULT NULL,
  `orderId` int(10) DEFAULT NULL,
  `routeId` int(10) DEFAULT NULL,
  `userId` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `orderId` (`orderId`),
  KEY `routeId` (`routeId`),
  KEY `userId` (`userId`),
  CONSTRAINT `ticket_ibfk_1` FOREIGN KEY (`orderId`) REFERENCES `orderinfo` (`id`),
  CONSTRAINT `ticket_ibfk_2` FOREIGN KEY (`routeId`) REFERENCES `route` (`id`),
  CONSTRAINT `ticket_ibfk_3` FOREIGN KEY (`userId`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

/*Data for the table `ticket` */

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `username` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  `mail` varchar(30) NOT NULL,
  `name` varchar(30) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `phoneNumber` varchar(30) NOT NULL,
  `idCard` varchar(30) DEFAULT NULL,
  `idType` varchar(30) DEFAULT NULL,
  `balance` int(30) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`username`,`password`,`mail`,`name`,`birthday`,`phoneNumber`,`idCard`,`idType`,`balance`) values (9,'hhyvs111','1234567','445622919@qq.com','张三','2016-07-11','132456','4456','身份证',100630),(12,'123123','456','456@qq.com','123132','1991-01-01','12332111111','123333333333333333','二代身份证',0),(13,'admin','admin','123@qq.com','admin','2016-07-19','11111111111','111111111111111111','二代身份证',0),(15,'a12456','123456','445612@qq.com','李白','2016-07-01','12345678913','123456789456123465','二代身份证',0);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
