/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 8.0.22 : Database - bees
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`bees` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `bees`;

/*Table structure for table `appmag` */

DROP TABLE IF EXISTS `appmag`;

CREATE TABLE `appmag` (
  `VersionCode` varchar(16) NOT NULL COMMENT '版本号',
  `num` int NOT NULL COMMENT '使用人数',
  PRIMARY KEY (`VersionCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `appmag` */

insert  into `appmag`(`VersionCode`,`num`) values ('1.0.1',2),('1.0.2',2),('1.0.3',1),('1.0.5',1),('101',3);

/*Table structure for table `collect` */

DROP TABLE IF EXISTS `collect`;

CREATE TABLE `collect` (
  `collectid` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `inviid` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `userid` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `intime` timestamp NOT NULL,
  PRIMARY KEY (`collectid`),
  KEY `FK_Reference_7` (`userid`),
  KEY `invi_id` (`inviid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `collect` */

insert  into `collect`(`collectid`,`inviid`,`userid`,`intime`) values ('1841625730006674','2471625729333846','8491625242487926','2021-07-08 07:40:07'),('3741625730044105','2471625729333846','8491625242487926','2021-07-08 07:40:44'),('6541625730060362','2471625729333846','8491625242487926','2021-07-08 07:41:00'),('6731625729957311','2471625729333846','8491625242487926','2021-07-08 07:39:17'),('8141625729863705','2471625729333846','8491625242487926','2021-07-08 07:37:44');

/*Table structure for table `commentinfo` */

DROP TABLE IF EXISTS `commentinfo`;

CREATE TABLE `commentinfo` (
  `infoid` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `inviid` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `userid` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `username` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `userhead` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `likenum` int NOT NULL,
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `intime` timestamp NOT NULL,
  PRIMARY KEY (`infoid`),
  KEY `FK_Reference_4` (`userid`),
  KEY `to_id` (`inviid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `commentinfo` */

insert  into `commentinfo`(`infoid`,`inviid`,`userid`,`username`,`userhead`,`likenum`,`content`,`intime`) values ('2751624863169100','3241622895276508','1620552328155','大狗狗','dawd',-1,'wadawd','2021-06-28 06:52:49'),('8491625035419415','6331625035359137','1620646833485','杰克','http:\\\\localhost\\image\\1620646833485\\1625035079956.png',-1,'想画个心形，有很多的样式可以供你选择。心形常在图案设计、剪贴簿设计以及活动主题中被用到。咱们开始吧&image;http://localhost/image/1620646833485/6331625035359137/8491625035419415/1625035419415.png&image;http://localhost/image/1620646833485/6331625035359137/8491625035419415/1625035419416.png&image;http://localhost/image/1620646833485/6331625035359137/8491625035419415/1625035419422.png','2021-06-30 06:43:39'),('9071625323325915','8111625244085619','8491625242487926','爷爷X2','http://47.101.198.228/image/user/8491625242487926/1625323230570.png',1,'测试文件删除&image;http://47.101.198.228/image/invi/8111625244085619/9071625323325915/1625323325915.png&image;http://47.101.198.228/image/invi/8111625244085619/9071625323325915/1625323325917.png&image;http://47.101.198.228/image/invi/8111625244085619/9071625323325915/1625323325917.png&image;http://47.101.198.228/image/invi/8111625244085619/9071625323325915/1625323325918.png','2021-07-03 14:42:06'),('9991624865375581','0231624864335591','1620552328155','大狗狗','diohwaidu8aw',-1,'新测试加图片','2021-06-28 07:29:36');

/*Table structure for table `commentreply` */

DROP TABLE IF EXISTS `commentreply`;

CREATE TABLE `commentreply` (
  `replyid` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `inviid` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `userhead` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `username` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `userid` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `infoid` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `intime` timestamp NOT NULL,
  `likenum` int NOT NULL,
  PRIMARY KEY (`replyid`),
  KEY `FK_Reference_5` (`infoid`),
  KEY `FK_Reference_6` (`userid`),
  KEY `invi_id` (`inviid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `commentreply` */

insert  into `commentreply`(`replyid`,`inviid`,`userhead`,`username`,`userid`,`infoid`,`content`,`intime`,`likenum`) values ('0131624865440915','0231624864335591','diohwaidu8aw','大狗狗','1620552328155','9991624865375581','新测试加图片','2021-06-28 07:30:41',0),('4531625035471498','6331625035359137','http:\\\\localhost\\image\\1620646833485\\1625035079956.png','杰克','1620646833485','8491625035419415','想画个心形，有很多的样式可以供你选择。心形常在图案设计、剪贴簿设计以及活动主题中被用到。咱们开始吧&image;http://localhost/image/1620646833485/6331625035359137/8491625035419415/4531625035471498/1625035471498.png&image;http://localhost/image/1620646833485/6331625035359137/8491625035419415/4531625035471498/1625035471499.png&image;http://localhost/image/1620646833485/6331625035359137/8491625035419415/4531625035471498/1625035471503.png','2021-06-30 06:44:32',0);

/*Table structure for table `feedback` */

DROP TABLE IF EXISTS `feedback`;

CREATE TABLE `feedback` (
  `feedbackid` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `content` text,
  `userid` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `intime` date DEFAULT NULL,
  `mold` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`feedbackid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `feedback` */

insert  into `feedback`(`feedbackid`,`content`,`userid`,`intime`,`mold`) values ('3881625066275093','意见反馈测试&image;http://47.101.198.228/image/反馈/875555555555645/3881625066275093/1625066275094.png','875555555555645','2021-06-30','反馈'),('5591625065738254','意见反馈测试&image;http://47.101.198.228/image/反馈/dajkwbdkbdkl/5591625065738254/1625065738254.png','dajkwbdkbdkl','2021-06-30','反馈'),('8491625066121448','意见反馈测试&image;http://47.101.198.228/image/反馈/dajkwbdkbdkl/8491625066121448/1625066121448.png','dajkwbdkbdkl','2021-06-30','反馈'),('8501625066283980','意见反馈测试&image;http://47.101.198.228/image/反馈/875555555555645/8501625066283980/1625066283980.png','875555555555645','2021-06-30','反馈意见'),('9781625066013634','意见反馈测试&image;http://47.101.198.228/image/反馈/dajkwbdkbdkl/9781625066013634/1625066013635.png','dajkwbdkbdkl','2021-06-30','反馈');

/*Table structure for table `history` */

DROP TABLE IF EXISTS `history`;

CREATE TABLE `history` (
  `historyid` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `inviid` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `userid` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `intime` timestamp NOT NULL,
  PRIMARY KEY (`historyid`),
  KEY `FK_Reference_8` (`userid`),
  KEY `invi_id` (`inviid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `history` */

/*Table structure for table `invitation` */

DROP TABLE IF EXISTS `invitation`;

CREATE TABLE `invitation` (
  `inviid` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `userid` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `userhead` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `username` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `postTime` timestamp NOT NULL,
  `Boardid` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `likes` int NOT NULL,
  `collects` int NOT NULL,
  `readly` int NOT NULL,
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `title` varchar(128) NOT NULL,
  `reply` int NOT NULL,
  PRIMARY KEY (`inviid`),
  KEY `Boardid` (`Boardid`),
  KEY `userid` (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `invitation` */

/*Table structure for table `mags` */

DROP TABLE IF EXISTS `mags`;

CREATE TABLE `mags` (
  `homemag` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `mags` */

insert  into `mags`(`homemag`) values ('公告修改');

/*Table structure for table `module` */

DROP TABLE IF EXISTS `module`;

CREATE TABLE `module` (
  `id` varchar(16) NOT NULL,
  `moduleid` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `name` varchar(32) NOT NULL,
  `Head` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `module` */

insert  into `module`(`id`,`moduleid`,`name`,`Head`) values ('1234','1','美食',NULL);

/*Table structure for table `notecard` */

DROP TABLE IF EXISTS `notecard`;

CREATE TABLE `notecard` (
  `id` varchar(32) NOT NULL,
  `son` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `posttime` timestamp NOT NULL,
  PRIMARY KEY (`id`),
  KEY `son` (`son`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `notecard` */

insert  into `notecard`(`id`,`son`,`content`,`posttime`) values ('1421622451458583','201917190179','这个软件挺好用的，哈哈哈哈','2021-05-31 00:00:00'),('1431622454326973','201917190179','测试','2021-05-31 09:45:27'),('7101622454731831','201917190179','测试2','2021-05-31 09:52:12');

/*Table structure for table `pak` */

DROP TABLE IF EXISTS `pak`;

CREATE TABLE `pak` (
  `id` varchar(32) NOT NULL,
  `num` int DEFAULT NULL COMMENT '查课表人数',
  `zf` int DEFAULT NULL COMMENT '教务系统点击次数',
  `pass` varchar(16) DEFAULT NULL COMMENT '服务器校验码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `pak` */

insert  into `pak`(`id`,`num`,`zf`,`pass`) values ('1234',6,4,NULL);

/*Table structure for table `qqinfo` */

DROP TABLE IF EXISTS `qqinfo`;

CREATE TABLE `qqinfo` (
  `QQToken` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `QQname` varchar(32) NOT NULL,
  `QQsex` varchar(2) NOT NULL,
  `QQHead` varchar(512) NOT NULL,
  `QQage` int NOT NULL,
  PRIMARY KEY (`QQToken`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `qqinfo` */

insert  into `qqinfo`(`QQToken`,`QQname`,`QQsex`,`QQHead`,`QQage`) values ('00000000000000000000000','大狗狗','女','头像地址',18),('09weiqwhduiuqhdwuawidwa','而哈哈','男','http://192.168.137.1/image/1620636501723.png',17),('321e2qdqd323wdsa3wewe','马冬梅','女','dwoiajwiohuid',28),('321e2qdqdwdsad3e23e3wewe','冯姐','男','hdiowjadio',888219),('321egji2qdqd323wwewe','马冬梅','女','dwoiajwiohuid',28),('321enejsfbjkesfbje3wewe','杰克','男','http//ei3eowjdw',17),('djw8audiokanwjkdwad','哇塞','男','heihwioaudhnw',20),('oiwajd09waudjiwaojd','大狗狗','男','diohwaidu8aw',18);

/*Table structure for table `son` */

DROP TABLE IF EXISTS `son`;

CREATE TABLE `son` (
  `son` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `pass` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`son`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `son` */

insert  into `son`(`son`,`pass`) values ('201917190176','1q2w3e'),('201917190177','1q2w3e'),('201917190178','1q2w3e'),('201917190179','1q2w3e');

/*Table structure for table `test` */

DROP TABLE IF EXISTS `test`;

CREATE TABLE `test` (
  `id` int NOT NULL,
  `password` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `test` */

insert  into `test`(`id`,`password`,`time`) values (1231,'3214214','2021-05-09 00:00:00'),(12324,'42149u',NULL),(123456,'a123456',NULL),(11232331,'32wadwad3314',NULL),(12312331,'32wadwad3314',NULL),(123232331,'32142213232333314',NULL),(695278459,'a695278459',NULL),(1231232331,'32wadwad3314',NULL),(1232323331,'你好吗',NULL);

/*Table structure for table `token` */

DROP TABLE IF EXISTS `token`;

CREATE TABLE `token` (
  `userid` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `token` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `token` */

insert  into `token`(`userid`,`token`) values ('0331625154337364','0331625154337364-1625154399788-9e863e63-493a-46ff-81da-9f1a647ef2f4'),('0971625159290004','0971625159290004-1625159290021-18988cae-9f02-48a3-bb7e-1f1eeeb3f82f'),('2371625237485152','2371625237485152-1625237485166-afb48b03-c24b-42bc-a794-7d98c45dea93'),('4821631971574988','4821631971574988-1631971575008-6d732690-2c8c-45a3-ae93-b87b22aa2590'),('8491625242487926','8491625242487926-1625242487934-f59e23a4-e9d4-4fe0-a7cb-73bb1e9b2496'),('9881625237576192','9881625237576192-1625237576195-a8741df5-d52d-4a35-8639-bae58b583d27');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `userid` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `userpass` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `username` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `RegTime` timestamp NULL DEFAULT NULL,
  `LastLogTime` timestamp NULL DEFAULT NULL,
  `userhead` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `age` int DEFAULT NULL,
  `sex` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `QQToken` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `school` varchar(64) DEFAULT NULL,
  `son` varchar(16) DEFAULT NULL,
  `score` int DEFAULT NULL,
  `postnumber` int DEFAULT NULL,
  `collects` int DEFAULT NULL,
  `signature` varchar(100) DEFAULT NULL,
  `phone` varchar(12) DEFAULT NULL,
  PRIMARY KEY (`userid`),
  KEY `FK_Reference_12` (`QQToken`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `user` */

insert  into `user`(`userid`,`userpass`,`username`,`RegTime`,`LastLogTime`,`userhead`,`age`,`sex`,`QQToken`,`school`,`son`,`score`,`postnumber`,`collects`,`signature`,`phone`) values ('4821631971574988','e10adc3949ba59abbe56e057f20f883e','19283923321','2021-09-18 13:26:15','2021-09-18 13:26:15','http://47.101.198.228/image/apk/head.png',NULL,NULL,NULL,NULL,NULL,0,0,0,'空空如也...','19283923321'),('8491625242487926','8491625242487926-1625242487934-f59e23a4-e9d4-4fe0-a7cb-73bb1e9b2496','爷爷X2','2021-07-02 16:14:48','2021-07-02 16:14:48','http://47.101.198.228/image/Imagepath/user/8491625242487926/1632241573248-56743c55-c9f9-4276-b3ec-8df2e372e5d0X.jpg',NULL,NULL,NULL,NULL,NULL,0,5,5,'爷只是怕错过','18823789299');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
