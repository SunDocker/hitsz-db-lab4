-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: campus_volunteer
-- ------------------------------------------------------
-- Server version	8.0.28

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `activity_category`
--

DROP TABLE IF EXISTS `activity_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `activity_category` (
  `name` varchar(15) NOT NULL COMMENT '类别名',
  `introduction` text COMMENT '类别简介',
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='志愿活动类别';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `activity_category`
--

LOCK TABLES `activity_category` WRITE;
/*!40000 ALTER TABLE `activity_category` DISABLE KEYS */;
INSERT INTO `activity_category` VALUES ('便民利民类','提供家电维修、家政联络、信息咨询等服务。'),('宣传教育类','开展政策法规、科普知识、安全常识、健康知识宣传等服务。'),('就业指导类','提供技能培训、岗位推荐、维权援助等服务。'),('扶贫帮困类','为下岗失业职工、残疾人、老年人、失学儿童、特殊困难家庭等弱势群体,提供力所能及的帮扶。'),('文体娱乐类','提供文艺宣传、健身活动、戏剧票友、棋牌娱乐、书画摄影等服务。'),('无类别',NULL),('环境维护类','提供环境保洁、绿化维护、家庭美化指导等服务。');
/*!40000 ALTER TABLE `activity_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admin` (
  `account` varchar(10) NOT NULL COMMENT '账号',
  `password` varchar(20) NOT NULL COMMENT '密码',
  `register_time` datetime DEFAULT NULL COMMENT '注册时间',
  PRIMARY KEY (`account`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='管理员';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES ('admin','123','2022-12-24 09:47:20'),('root','123456','2022-12-24 09:47:20'),('root2','12345678','2022-12-24 18:13:32'),('toor','654321','2022-12-24 09:47:20');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `ADMIN_FILL_TIME_BEFORE_INSERT` BEFORE INSERT ON `admin` FOR EACH ROW begin
    set new.register_time = now();
end */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `college`
--

DROP TABLE IF EXISTS `college`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `college` (
  `no` int NOT NULL COMMENT '学院编号',
  `name` varchar(15) NOT NULL COMMENT '学院名',
  `introduction` text COMMENT '学院简介',
  PRIMARY KEY (`no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='学院';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `college`
--

LOCK TABLES `college` WRITE;
/*!40000 ALTER TABLE `college` DISABLE KEYS */;
INSERT INTO `college` VALUES (0,'无学院',NULL),(1,'计算机科学与技术学院','分最高的学院'),(2,'机电工程与自动化学院','人最多的学院'),(3,'电子信息与工程学院',NULL);
/*!40000 ALTER TABLE `college` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `organization`
--

DROP TABLE IF EXISTS `organization`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `organization` (
  `no` int NOT NULL COMMENT '组织编号',
  `name` varchar(15) DEFAULT NULL COMMENT '组织名',
  `introduction` text COMMENT '组织简介',
  PRIMARY KEY (`no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='义工组织';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `organization`
--

LOCK TABLES `organization` WRITE;
/*!40000 ALTER TABLE `organization` DISABLE KEYS */;
INSERT INTO `organization` VALUES (0,'无义工组织',NULL),(1,'薪火光熙义工联','传承陈光熙先生的精神'),(2,'校义工联',NULL);
/*!40000 ALTER TABLE `organization` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `participate`
--

DROP TABLE IF EXISTS `participate`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `participate` (
  `activity_no` int NOT NULL COMMENT '活动编号',
  `volunteer_account` varchar(10) NOT NULL COMMENT '志愿者账号',
  `check_status` varchar(3) NOT NULL COMMENT '审核状态',
  `signup_time` datetime DEFAULT NULL COMMENT '报名时间',
  PRIMARY KEY (`activity_no`,`volunteer_account`),
  KEY `FK_VOLUNTEER_PARTICIPATE` (`volunteer_account`),
  CONSTRAINT `FK_ACTIVITY_PARTICIPATE` FOREIGN KEY (`activity_no`) REFERENCES `volunteer_activity` (`no`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_VOLUNTEER_PARTICIPATE` FOREIGN KEY (`volunteer_account`) REFERENCES `volunteer` (`account`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='报名参与';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `participate`
--

LOCK TABLES `participate` WRITE;
/*!40000 ALTER TABLE `participate` DISABLE KEYS */;
INSERT INTO `participate` VALUES (1,'lisi','通过','2022-12-24 09:57:43'),(1,'zhangsan','通过','2022-12-24 09:57:43'),(2,'lisi','拒绝','2022-12-24 09:57:43'),(3,'lisi','待审核','2022-12-27 12:22:35'),(3,'wangwu','拒绝','2022-12-27 12:16:12'),(4,'lisi','通过','2022-12-27 20:03:54'),(6,'wangwu','拒绝','2022-12-27 19:46:25');
/*!40000 ALTER TABLE `participate` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `PARTICIPATE_FILL_TIME_BEFORE_INSERT` BEFORE INSERT ON `participate` FOR EACH ROW begin
    set new.signup_time = now();
end */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `site`
--

DROP TABLE IF EXISTS `site`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `site` (
  `no` int NOT NULL COMMENT '地点编号',
  `name` varchar(15) NOT NULL COMMENT '地点名',
  `area` float NOT NULL COMMENT '场地面积',
  PRIMARY KEY (`no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='地点';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `site`
--

LOCK TABLES `site` WRITE;
/*!40000 ALTER TABLE `site` DISABLE KEYS */;
INSERT INTO `site` VALUES (0,'其他地点',0),(1,'A社区广场',50000),(2,'B社区广场',60000),(3,'C校区广场',66666),(4,'F校区操场',88888),(5,'G公园',54321);
/*!40000 ALTER TABLE `site` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `star_rating`
--

DROP TABLE IF EXISTS `star_rating`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `star_rating` (
  `name` varchar(15) NOT NULL COMMENT '星级名',
  `introduction` text COMMENT '星级要求',
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='志愿者星级';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `star_rating`
--

LOCK TABLES `star_rating` WRITE;
/*!40000 ALTER TABLE `star_rating` DISABLE KEYS */;
INSERT INTO `star_rating` VALUES ('一星级志愿者','志愿者注册后,参加志愿服务时间累计达到100小时的,认定为“一星级志愿者”。'),('三星级志愿者','志愿者注册后,参加志愿服务时间累计达到600小时的,认定为“三星级志愿者”。'),('二星级志愿者','志愿者注册后,参加志愿服务时间累计达到300小时的,认定为“二星级志愿者”。'),('普通志愿者',NULL);
/*!40000 ALTER TABLE `star_rating` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `volunteer`
--

DROP TABLE IF EXISTS `volunteer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `volunteer` (
  `account` varchar(10) NOT NULL COMMENT '账号',
  `college_no` int NOT NULL COMMENT '学院编号',
  `star` varchar(15) NOT NULL COMMENT '星级',
  `org_no` int NOT NULL COMMENT '义工组织编号',
  `password` varchar(20) NOT NULL COMMENT '密码',
  `register_time` datetime DEFAULT NULL COMMENT '注册时间',
  `nickname` varchar(15) DEFAULT NULL COMMENT '昵称',
  `volunteer_time` float NOT NULL COMMENT '志愿时长',
  PRIMARY KEY (`account`),
  KEY `FK_VOLUNTEE_STAR` (`star`),
  KEY `FK_VOLUNTEER_COLLEGE` (`college_no`),
  KEY `FK_VOLUNTEER_ORGANIZATION` (`org_no`),
  CONSTRAINT `FK_VOLUNTEE_STAR` FOREIGN KEY (`star`) REFERENCES `star_rating` (`name`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_VOLUNTEER_COLLEGE` FOREIGN KEY (`college_no`) REFERENCES `college` (`no`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_VOLUNTEER_ORGANIZATION` FOREIGN KEY (`org_no`) REFERENCES `organization` (`no`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='志愿者';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `volunteer`
--

LOCK TABLES `volunteer` WRITE;
/*!40000 ALTER TABLE `volunteer` DISABLE KEYS */;
INSERT INTO `volunteer` VALUES ('lisi',2,'二星级志愿者',2,'654321','2022-12-24 09:52:08','leesee',500),('wangwu',0,'普通志愿者',0,'123','2022-12-24 18:00:53','weiwu',0),('zhangsan',1,'普通志愿者',1,'123456','2022-12-24 09:52:08',NULL,0);
/*!40000 ALTER TABLE `volunteer` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `VOLUNTEER_FILL_TIME_BEFORE_INSERT` BEFORE INSERT ON `volunteer` FOR EACH ROW begin
    set new.register_time = now();
end */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `volunteer_activity`
--

DROP TABLE IF EXISTS `volunteer_activity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `volunteer_activity` (
  `no` int NOT NULL COMMENT '活动编号',
  `admin_account` varchar(10) NOT NULL COMMENT '管理员账号',
  `category` varchar(15) NOT NULL COMMENT '类别',
  `site_no` int NOT NULL COMMENT '地点编号',
  `name` varchar(15) NOT NULL COMMENT '活动名',
  `begin_time` datetime NOT NULL COMMENT '开始时间',
  `end_time` datetime NOT NULL COMMENT '结束时间',
  `content` text NOT NULL COMMENT '活动内容与要求',
  `num` int NOT NULL COMMENT '人数',
  PRIMARY KEY (`no`),
  KEY `idx_begin_time` (`begin_time`),
  KEY `idx_end_time` (`end_time`),
  KEY `FK_ACTIVITY_CATEGORIZ` (`category`),
  KEY `FK_ACTIVITY_SITE` (`site_no`),
  KEY `FK_ACTIVITY_ADMIN` (`admin_account`),
  CONSTRAINT `FK_ACTIVITY_ADMIN` FOREIGN KEY (`admin_account`) REFERENCES `admin` (`account`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_ACTIVITY_CATEGORIZ` FOREIGN KEY (`category`) REFERENCES `activity_category` (`name`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_ACTIVITY_SITE` FOREIGN KEY (`site_no`) REFERENCES `site` (`no`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='志愿活动';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `volunteer_activity`
--

LOCK TABLES `volunteer_activity` WRITE;
/*!40000 ALTER TABLE `volunteer_activity` DISABLE KEYS */;
INSERT INTO `volunteer_activity` VALUES (1,'admin','便民利民类',1,'家电维修','2023-01-06 14:00:00','2023-01-06 15:00:00','维修家电',10),(2,'root','文体娱乐类',4,'元旦晚会道具组','2022-12-31 16:00:45','2023-12-31 21:30:30','给节目演员搬道具',30),(3,'toor','环境维护类',3,'打扫广场','2022-01-02 08:45:45','2022-01-02 10:45:45','扫扫地',5),(4,'admin','就业指导类',2,'大沙河捡垃圾','2023-10-06 12:30:30','2023-10-06 16:21:38','保护大沙河环境人人有责',15),(5,'admin','宣传教育类',0,'实验室标数据','2022-12-13 13:58:48','2022-12-27 13:58:52','在L3021标数据，找张老师',10),(6,'admin','便民利民类',0,'食堂盛饭','2023-01-27 19:45:14','2023-02-23 22:48:23','在一食堂帮盛饭',20);
/*!40000 ALTER TABLE `volunteer_activity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `volunteer_activity_detail`
--

DROP TABLE IF EXISTS `volunteer_activity_detail`;
/*!50001 DROP VIEW IF EXISTS `volunteer_activity_detail`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `volunteer_activity_detail` AS SELECT 
 1 AS `no`,
 1 AS `name`,
 1 AS `category`,
 1 AS `site`,
 1 AS `beginTime`,
 1 AS `endTime`,
 1 AS `content`,
 1 AS `num`,
 1 AS `adminAccount`,
 1 AS `status`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `volunteer_detail`
--

DROP TABLE IF EXISTS `volunteer_detail`;
/*!50001 DROP VIEW IF EXISTS `volunteer_detail`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `volunteer_detail` AS SELECT 
 1 AS `account`,
 1 AS `college`,
 1 AS `star`,
 1 AS `organization`,
 1 AS `registerTime`,
 1 AS `nickname`,
 1 AS `volunteerTime`*/;
SET character_set_client = @saved_cs_client;

--
-- Dumping events for database 'campus_volunteer'
--

--
-- Dumping routines for database 'campus_volunteer'
--

--
-- Final view structure for view `volunteer_activity_detail`
--

/*!50001 DROP VIEW IF EXISTS `volunteer_activity_detail`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `volunteer_activity_detail` AS select `va`.`no` AS `no`,`va`.`name` AS `name`,`va`.`category` AS `category`,`s`.`name` AS `site`,`va`.`begin_time` AS `beginTime`,`va`.`end_time` AS `endTime`,`va`.`content` AS `content`,`va`.`num` AS `num`,`va`.`admin_account` AS `adminAccount`,(now() > `va`.`begin_time`) AS `status` from (`volunteer_activity` `va` join `site` `s`) where (`va`.`site_no` = `s`.`no`) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `volunteer_detail`
--

/*!50001 DROP VIEW IF EXISTS `volunteer_detail`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `volunteer_detail` AS select `volunteer`.`account` AS `account`,`college`.`name` AS `college`,`volunteer`.`star` AS `star`,`organization`.`name` AS `organization`,`volunteer`.`register_time` AS `registerTime`,`volunteer`.`nickname` AS `nickname`,`volunteer`.`volunteer_time` AS `volunteerTime` from ((`volunteer` join `college`) join `organization`) where ((`volunteer`.`college_no` = `college`.`no`) and (`volunteer`.`org_no` = `organization`.`no`)) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-12-27 20:20:11
