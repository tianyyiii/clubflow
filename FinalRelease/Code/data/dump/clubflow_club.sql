-- MySQL dump 10.13  Distrib 8.0.26, for Win64 (x86_64)
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
-- Table structure for table `club`
--

DROP TABLE IF EXISTS `club`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `club` (
  `clubId` int(11) NOT NULL AUTO_INCREMENT,
  `clubName` varchar(80) CHARACTER SET utf8mb4 DEFAULT NULL,
  `clubInfo` text CHARACTER SET utf8mb4,
  `createDate` datetime DEFAULT NULL,
  `creator` int(11) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `image` varchar(2000) DEFAULT NULL,
  `publicationsNum` int(11) DEFAULT NULL,
  `fansNum` int(11) DEFAULT NULL,
  `commentsNum` int(11) DEFAULT NULL,
  `announcement` text CHARACTER SET utf8mb4,
  PRIMARY KEY (`clubId`),
  KEY `ClubCreator_idx` (`creator`),
  KEY `ClubProfile_idx` (`image`),
  FULLTEXT KEY `ClubIndex` (`clubName`,`clubInfo`) /*!50100 WITH PARSER `ngram` */ ,
  CONSTRAINT `ClubCreator` FOREIGN KEY (`creator`) REFERENCES `account` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `club`
--

LOCK TABLES `club` WRITE;
/*!40000 ALTER TABLE `club` DISABLE KEYS */;
INSERT INTO `club` VALUES (1,'guitar club','playing guitar','2015-12-20 10:01:00',2,1,'http://localhost:8080/file/index_img_2.png',2,2,0,'吉他协会的介绍。简要介绍民谣吉他(steel-string acoustic guitar,即原声钢弦吉他之意)，是种弹拨乐器，形状与提琴相似，通常有六根弦。最早是美国西部乡村音乐的伴奏乐器。通常作为歌曲的伴奏形式出现，以美国西部乡村音乐为主要演奏题材。'),(2,'appp','a club','2022-12-21 18:41:07',3,1,'1',0,0,0,NULL),(3,'apppp','a club','2022-12-21 23:08:07',2,1,'1',1,0,0,NULL),(4,'ab','a club','2022-12-22 16:45:11',1,1,'1',0,0,0,NULL),(5,'abb','a club','2022-12-22 16:52:23',1,1,'1',0,0,0,NULL),(6,'movie','this is a club for movies','2022-12-23 16:10:02',3,1,'1',0,0,0,NULL),(11,'象棋','来玩','2022-12-31 17:20:19',8,1,'http://localhost:8080/file/9m6jc7jpeg',0,0,0,'dsfrgghhj');
/*!40000 ALTER TABLE `club` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-01-12  1:22:01
