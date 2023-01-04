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
-- Table structure for table `subcomment`
--

DROP TABLE IF EXISTS `subcomment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `subcomment` (
  `subcommentId` int(11) NOT NULL AUTO_INCREMENT,
  `subcommenter` int(11) DEFAULT NULL,
  `context` text CHARACTER SET utf8,
  `commnetDate` datetime DEFAULT NULL,
  `comment` int(11) DEFAULT NULL,
  `replyWho` int(11) DEFAULT NULL,
  `thumbs` int(11) DEFAULT NULL,
  PRIMARY KEY (`subcommentId`),
  KEY `Subcommmentor_idx` (`subcommenter`),
  KEY `CommentedComment_idx` (`comment`),
  KEY `ReplyedUser_idx` (`replyWho`),
  CONSTRAINT `CommentedComment` FOREIGN KEY (`comment`) REFERENCES `comment` (`commentId`),
  CONSTRAINT `ReplyedUser` FOREIGN KEY (`replyWho`) REFERENCES `account` (`id`),
  CONSTRAINT `Subcommmentor` FOREIGN KEY (`subcommenter`) REFERENCES `account` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subcomment`
--

LOCK TABLES `subcomment` WRITE;
/*!40000 ALTER TABLE `subcomment` DISABLE KEYS */;
INSERT INTO `subcomment` VALUES (1,2,'Thank you for your support!','2015-12-20 10:01:00',1,3,1),(2,3,'梅西','2022-12-21 16:32:28',NULL,NULL,0);
/*!40000 ALTER TABLE `subcomment` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-01-01  0:33:40
