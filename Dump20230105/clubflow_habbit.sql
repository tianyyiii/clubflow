-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: localhost    Database: clubflow
-- ------------------------------------------------------
-- Server version	5.7.35-log

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
-- Table structure for table `habbit`
--

DROP TABLE IF EXISTS `habbit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `habbit` (
  `habbitId` int(11) NOT NULL AUTO_INCREMENT,
  `habbitName` varchar(80) CHARACTER SET utf8mb4 DEFAULT NULL,
  `habbitInfo` text CHARACTER SET utf8mb4,
  `createDate` datetime DEFAULT NULL,
  `creator` int(11) DEFAULT NULL,
  `state` tinyint(4) DEFAULT NULL,
  `image` varchar(2000) DEFAULT NULL,
  `publicationNum` int(11) DEFAULT NULL,
  `fansNum` int(11) DEFAULT NULL,
  `commentsNum` int(11) DEFAULT NULL,
  `announcement` text CHARACTER SET utf8mb4,
  PRIMARY KEY (`habbitId`),
  KEY `HabbitCreator_idx` (`creator`),
  KEY `HabbitProFile_idx` (`image`),
  CONSTRAINT `HabbitCreator` FOREIGN KEY (`creator`) REFERENCES `account` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `habbit`
--

LOCK TABLES `habbit` WRITE;
/*!40000 ALTER TABLE `habbit` DISABLE KEYS */;
INSERT INTO `habbit` VALUES (1,'puzzle habbit','solving puzzle','2015-12-20 10:01:00',2,1,'1',0,1,0,'这里是简介信息。简介信息简介信息简介信息简介信息简介信息简介信息简介信息简介信息简介信息简介信息简介信息简介信息简介信息简介信息简介信息简介信息简介信息简介信息简介信息简介信息简介信息简介信息简介信息简介信息简介信息简介信息简介信息简介信息'),(3,'晨跑小组','a habbit','2022-12-21 17:12:40',3,1,'1',0,0,0,NULL),(4,'DOTA','a club','2022-12-21 18:19:01',3,1,'1',0,0,0,NULL),(5,'车万分组','a club','2022-12-21 18:19:41',3,1,'1',0,0,0,NULL),(6,'红学','a club','2022-12-21 18:20:42',3,1,'1',0,0,0,NULL),(7,'app','a club','2022-12-21 18:21:04',3,1,'1',0,0,0,NULL),(12,'东方project','恋恋赛高','2023-01-04 20:36:52',3,1,'http://localhost:8080/file/iwqpxs.png',0,0,0,'《东方Project》，简称东方，是日本同人游戏社团上海爱丽丝幻乐团所制作的一系列同人游戏、相关作品。它以及其二次创作所构成的覆盖游戏、动画、漫画、音乐、文学等诸多方面的领域。');
/*!40000 ALTER TABLE `habbit` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-01-05  4:15:03
