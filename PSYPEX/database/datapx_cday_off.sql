-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: localhost    Database: datapx
-- ------------------------------------------------------
-- Server version	8.0.27

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
-- Table structure for table `cday_off`
--

DROP TABLE IF EXISTS `cday_off`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cday_off` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `is_lunar_day` tinyint(1) NOT NULL,
  `day` int NOT NULL,
  `month` int NOT NULL,
  `year` int DEFAULT NULL,
  `place_id` varchar(10) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `cday_off_day` (`day`),
  KEY `cday_off_month` (`month`),
  KEY `cday_off_placeId` (`place_id`),
  CONSTRAINT `cday_off_placeId` FOREIGN KEY (`place_id`) REFERENCES `clistcust` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cday_off`
--

LOCK TABLES `cday_off` WRITE;
/*!40000 ALTER TABLE `cday_off` DISABLE KEYS */;
INSERT INTO `cday_off` VALUES (1,'Manifeste de l\'Indépendance',0,11,1,NULL,'BVC'),(2,'Fête du travail',0,1,5,NULL,'BVC'),(3,'Fête du trône',0,30,7,NULL,'BVC'),(4,'Allégeance Oued Eddahab',0,14,8,NULL,'BVC'),(5,'La Révolution du Roi et du peuple',0,20,8,NULL,'BVC'),(6,'Fête de la jeunesse',0,21,8,NULL,'BVC'),(7,'La marche verte',0,6,11,NULL,'BVC'),(8,'Fête de l\'Indépendance',0,18,11,NULL,'BVC'),(9,'Aid-al-adha',1,22,8,2018,'BVC'),(10,'Aid-al-adha',1,23,8,2018,'BVC'),(11,'Jour de l\'an',0,1,1,NULL,'BVC'),(12,'AID MAWLID ',1,20,11,NULL,'BVC'),(13,'AID MAWLID',1,21,11,NULL,'BVC');
/*!40000 ALTER TABLE `cday_off` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-06-12 19:20:26
