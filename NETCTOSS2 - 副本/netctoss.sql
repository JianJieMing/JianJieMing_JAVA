-- MySQL dump 10.13  Distrib 5.7.23, for Win64 (x86_64)
--
-- Host: localhost    Database: netctoss
-- ------------------------------------------------------
-- Server version	5.7.23

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `account` (
  `account_id` int(11) NOT NULL AUTO_INCREMENT,
  `recommender_id` int(11) DEFAULT NULL,
  `login_name` varchar(30) NOT NULL,
  `login_passwd` varchar(30) NOT NULL,
  `status` char(1) DEFAULT '0',
  `create_date` datetime DEFAULT NULL,
  `pause_date` datetime DEFAULT NULL,
  `close_date` datetime DEFAULT NULL,
  `real_name` varchar(20) NOT NULL,
  `idcard_no` char(18) NOT NULL,
  `birthdate` datetime DEFAULT NULL,
  `gender` char(1) DEFAULT NULL,
  `occupation` varchar(50) DEFAULT NULL,
  `telephone` varchar(15) NOT NULL,
  `email` varchar(50) DEFAULT NULL,
  `mailaddress` varchar(200) DEFAULT NULL,
  `zipcode` char(6) DEFAULT NULL,
  `qq` varchar(15) DEFAULT NULL,
  `last_login_time` datetime DEFAULT NULL,
  `last_login_ip` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`account_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1026 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES (1011,1010,'dgbf70','270429','1','2018-10-13 08:58:18','2018-10-17 21:03:19','2018-10-17 21:03:18','huangrong','330902197108270429','1971-08-27 00:00:00',NULL,NULL,'13637811357',NULL,NULL,NULL,NULL,'2018-10-13 08:59:01','192.158.0.20'),(1019,1011,'ljxj90','310346','1','2018-10-13 08:58:20','2018-10-13 08:58:38','2018-10-13 08:58:39','luwushuang','320211199307310346','1993-07-31 00:00:00',NULL,NULL,'13186454984',NULL,NULL,NULL,NULL,'2018-10-13 08:59:03','192.168.0.20'),(1020,NULL,'kxhxd20','012115','1','2018-10-13 08:58:21','2018-10-13 08:58:40','2018-10-13 08:58:40','weixiaobao','321022200010012115','2000-10-01 00:00:00',NULL,NULL,'13953410078',NULL,NULL,NULL,NULL,'2018-10-13 08:59:04','192.168.0.20'),(1023,NULL,'kxhxd23','012118','1','2018-10-13 08:58:23','2018-10-13 08:58:44','2018-10-13 08:58:44','wangwu','321022200010012118','2000-10-04 00:00:00',NULL,NULL,'13953410081',NULL,NULL,NULL,NULL,'2018-10-13 08:59:06','192.168.0.20'),(1025,NULL,'kxhxd25','012120','1','2018-10-13 08:58:25','2018-10-13 08:58:47','2018-10-13 08:58:47','maqi','321022200010012120','2000-10-06 00:00:00',NULL,NULL,'13953410083',NULL,NULL,NULL,NULL,'2018-10-13 08:59:08','192.168.0.20');
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `admin_info`
--

DROP TABLE IF EXISTS `admin_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `admin_info` (
  `admin_id` int(8) NOT NULL AUTO_INCREMENT,
  `admin_code` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  `name` varchar(30) NOT NULL,
  `telephone` varchar(15) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `enrolldate` datetime DEFAULT NULL,
  PRIMARY KEY (`admin_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10088 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin_info`
--

LOCK TABLES `admin_info` WRITE;
/*!40000 ALTER TABLE `admin_info` DISABLE KEYS */;
INSERT INTO `admin_info` VALUES (5000,'caocao','caoca','曹操','2323112','231323@qq.com','2017-08-30 00:00:00'),(8000,'admin','55555','ADMIN','666666','admin@tarena.com.cn','2018-10-09 05:39:02'),(9000,'33333','333333','MLXGzzz','32321322132312','32432432@qq.com','2018-10-11 00:40:32'),(10013,'ZiJian','00000','郭子健','623712678','634726@qq.com','2018-10-19 03:17:35'),(10014,'3333','123123','张有朋','22222','2321321@qq.com','2018-10-19 03:17:37'),(10086,'anduyin','312312','安度因','23141','1235235@qq.com','2018-10-17 09:46:09'),(10087,'jianna','00000','吉安娜','13999999999','2432746@qq.com','2018-10-17 09:50:12');
/*!40000 ALTER TABLE `admin_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `admin_role`
--

DROP TABLE IF EXISTS `admin_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `admin_role` (
  `admin_id` int(8) NOT NULL,
  `role_id` int(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin_role`
--

LOCK TABLES `admin_role` WRITE;
/*!40000 ALTER TABLE `admin_role` DISABLE KEYS */;
INSERT INTO `admin_role` VALUES (8000,700),(8000,100),(8000,200),(8000,300),(8000,726),(10013,700),(10013,726),(9000,700),(10014,700),(10049,100),(10049,200),(10056,100),(10057,100),(10060,200),(10061,100),(10061,200),(10076,100),(10076,200),(10077,100),(10077,200),(10078,100),(10078,200),(10079,100),(10079,200),(10080,100),(10080,200),(10081,100),(10081,200),(10082,200),(10082,726),(10083,200),(10083,726),(10084,200),(10084,726),(10086,300),(10086,700),(5000,200),(10087,726);
/*!40000 ALTER TABLE `admin_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cost`
--

DROP TABLE IF EXISTS `cost`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cost` (
  `cost_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `base_duration` int(11) DEFAULT NULL,
  `base_cost` int(11) DEFAULT NULL,
  `unit_cost` int(11) DEFAULT NULL,
  `status` char(1) DEFAULT NULL,
  `descr` varchar(100) DEFAULT NULL,
  `creatime` datetime DEFAULT NULL,
  `startime` datetime DEFAULT NULL,
  `cost_type` char(1) DEFAULT NULL,
  PRIMARY KEY (`cost_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cost`
--

LOCK TABLES `cost` WRITE;
/*!40000 ALTER TABLE `cost` DISABLE KEYS */;
INSERT INTO `cost` VALUES (2,'6.9元套餐',40,7,0,'1','6.9元40小时/月,超出部分0.3元/时','2018-10-13 08:57:27','2018-10-18 10:40:44','1'),(4,'10.5元套餐',200,11,0,'0','10.5元200小时/月,超出部分0.1元/时','2018-10-13 08:57:28','2018-10-13 08:57:16','1'),(5,'计时收费',NULL,NULL,1,'1','0.5元/时,不使用不收费','2018-10-13 08:57:29','2018-10-18 10:40:42','2');
/*!40000 ALTER TABLE `cost` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `module_info`
--

DROP TABLE IF EXISTS `module_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `module_info` (
  `module_id` int(4) NOT NULL DEFAULT '0',
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`module_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `module_info`
--

LOCK TABLES `module_info` WRITE;
/*!40000 ALTER TABLE `module_info` DISABLE KEYS */;
INSERT INTO `module_info` VALUES (1,'角色管理'),(2,'管理员'),(3,'资费管理'),(4,'账务账号'),(5,'业务账号'),(6,'账单管理'),(7,'报表');
/*!40000 ALTER TABLE `module_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role_info`
--

DROP TABLE IF EXISTS `role_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role_info` (
  `role_id` int(4) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=733 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role_info`
--

LOCK TABLES `role_info` WRITE;
/*!40000 ALTER TABLE `role_info` DISABLE KEYS */;
INSERT INTO `role_info` VALUES (100,'管理员'),(200,'营业员'),(300,'经理'),(700,'超级管理员'),(726,'董事长'),(730,'秘书'),(732,'煤气费');
/*!40000 ALTER TABLE `role_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role_module`
--

DROP TABLE IF EXISTS `role_module`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role_module` (
  `role_id` int(4) NOT NULL,
  `module_id` int(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role_module`
--

LOCK TABLES `role_module` WRITE;
/*!40000 ALTER TABLE `role_module` DISABLE KEYS */;
INSERT INTO `role_module` VALUES (100,1),(200,3),(300,7),(726,4),(726,7),(700,1),(700,2),(700,3),(700,4),(700,5),(700,6),(700,7),(730,6),(730,7),(732,2),(732,5);
/*!40000 ALTER TABLE `role_module` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `service`
--

DROP TABLE IF EXISTS `service`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `service` (
  `service_id` int(10) NOT NULL AUTO_INCREMENT,
  `account_id` int(9) NOT NULL,
  `unix_host` varchar(15) NOT NULL,
  `os_username` varchar(8) NOT NULL,
  `login_passwd` varchar(30) NOT NULL,
  `status` char(1) DEFAULT '0',
  `create_date` datetime DEFAULT NULL,
  `pause_date` datetime DEFAULT NULL,
  `close_date` datetime DEFAULT NULL,
  `cost_id` int(4) NOT NULL,
  PRIMARY KEY (`service_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2008 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `service`
--

LOCK TABLES `service` WRITE;
/*!40000 ALTER TABLE `service` DISABLE KEYS */;
INSERT INTO `service` VALUES (2002,1011,'192.168.0.26','huangr','huang234','1','2017-08-30 00:00:00',NULL,NULL,2),(2003,1011,'192.168.0.20','huangr','huang234','1','2017-08-30 00:00:00',NULL,NULL,4),(2004,1011,'192.168.0.23','huangr','huang234','0','2017-08-30 00:00:00',NULL,NULL,6),(2005,1019,'192.168.0.26','luwsh','luwu2345','0','2017-08-30 00:00:00',NULL,NULL,4),(2006,1019,'192.168.0.20','luwsh','luwu2345','0','2017-08-30 00:00:00',NULL,NULL,5),(2007,1020,'192.168.0.20','weixb','wei12345','1','2017-08-30 00:00:00',NULL,NULL,6);
/*!40000 ALTER TABLE `service` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `service_update_bak`
--

DROP TABLE IF EXISTS `service_update_bak`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `service_update_bak` (
  `ID` int(10) NOT NULL DEFAULT '0',
  `SERVICE_ID` int(9) NOT NULL,
  `COST_ID` int(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `service_update_bak`
--

LOCK TABLES `service_update_bak` WRITE;
/*!40000 ALTER TABLE `service_update_bak` DISABLE KEYS */;
/*!40000 ALTER TABLE `service_update_bak` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-10-20  8:51:27
