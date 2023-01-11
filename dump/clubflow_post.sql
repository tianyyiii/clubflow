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
-- Table structure for table `post`
--

DROP TABLE IF EXISTS `post`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `post` (
  `postId` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(80) CHARACTER SET utf8mb4 DEFAULT NULL,
  `context` text CHARACTER SET utf8mb4,
  `creator` int(11) DEFAULT NULL,
  `club` int(11) DEFAULT NULL,
  `thumbs` int(11) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `lastModifyDate` datetime DEFAULT NULL,
  `image` varchar(2000) DEFAULT NULL,
  PRIMARY KEY (`postId`),
  KEY `PostCreator_idx` (`creator`),
  KEY `PostClub_idx` (`club`),
  FULLTEXT KEY `PostIndex` (`title`,`context`) /*!50100 WITH PARSER `ngram` */ ,
  CONSTRAINT `PostClub` FOREIGN KEY (`club`) REFERENCES `club` (`clubId`),
  CONSTRAINT `PostCreator` FOREIGN KEY (`creator`) REFERENCES `account` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `post`
--

LOCK TABLES `post` WRITE;
/*!40000 ALTER TABLE `post` DISABLE KEYS */;
INSERT INTO `post` VALUES (1,'Play guitar','let\'s play guitar',2,1,1,'2015-12-20 10:01:00','2015-12-20 10:01:00',NULL),(3,NULL,'this is context for chat-gptt',2,3,1,'2022-12-22 17:25:29','2022-12-22 17:29:02',NULL),(4,'恋恋世界第一','<h1>恋恋世界第一</h1><h2>二级标题</h2><p><span class=\"ql-font-monospace\">换个字体</span></p><p><br></p><blockquote>“恋恋世界第一”</blockquote><p><br></p><pre class=\"ql-syntax\" spellcheck=\"false\">printf(\"恋恋世界第一！\");\n</pre><p><br></p><ol><li>直接上图</li></ol><p><br></p><p><span class=\"ql-size-large\">大大大大</span></p><p><br></p><p><br></p><p><img src=\"http://localhost:8080/file/nf8ipc.jpg\"></p><p><br></p><p><br></p><p class=\"ql-indent-1\">第一段：你看，恋恋这么可爱肯定是世界第一。</p>',8,1,0,'2022-12-29 22:19:13','2022-12-29 22:19:13','http://localhost:8080/file/nf8ipc.jpg'),(5,'测试','<p>测试</p>',8,1,0,'2022-12-29 22:24:38','2022-12-29 22:24:38',''),(6,'测试2','<p><br></p><p><img src=\"http://localhost:8080/file/2tt6uk.jpg\"></p><p><br></p><h1>大标题</h1>',8,1,0,'2022-12-31 15:46:16','2022-12-31 15:46:16','http://localhost:8080/file/2tt6uk.jpg');
/*!40000 ALTER TABLE `post` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-01-11 16:34:29
