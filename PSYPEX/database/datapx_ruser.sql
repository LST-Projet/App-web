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
-- Table structure for table `ruser`
--

DROP TABLE IF EXISTS `ruser`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ruser` (
  `id` int NOT NULL AUTO_INCREMENT,
  `u_code` varchar(15) NOT NULL,
  `first_name` varchar(30) NOT NULL,
  `last_name` varchar(30) NOT NULL,
  `function_` varchar(30) NOT NULL,
  `is_enabled` tinyint(1) NOT NULL DEFAULT '0',
  `profile_id` int NOT NULL,
  `password` varchar(100) DEFAULT NULL,
  `is_signatory` tinyint(1) NOT NULL DEFAULT '0',
  `password_date` date DEFAULT NULL,
  `grace_date` date DEFAULT NULL,
  `failed_attempts` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `u_code_UNIQUE` (`u_code`),
  KEY `ruser_profilId_idx` (`profile_id`),
  CONSTRAINT `ruser_profilId` FOREIGN KEY (`profile_id`) REFERENCES `ruser_profile` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ruser`
--

LOCK TABLES `ruser` WRITE;
/*!40000 ALTER TABLE `ruser` DISABLE KEYS */;
INSERT INTO `ruser` VALUES (1,'ADMIN','Administrateur','ADMIN','ADMIN',1,10,'$2a$10$3UrlHkeOyIE3Hfij/NAmO.tHiJ.U4pPLzUHDL2teaJXuh71ox1IWO',0,'2019-11-08',NULL,NULL),(3,'FOPCM','Front OPCVM','OPCVM','FO',1,5,'$2a$10$k6uWiAeD3fs7YlmRJ8c3.O9z3QuD2GJp3gqsX27sgdgIpagv5U9rS',0,'2019-11-08',NULL,NULL),(4,'FALTR','Front Alter','ALTER','FO',1,4,'$2a$10$k6uWiAeD3fs7YlmRJ8c3.O9z3QuD2GJp3gqsX27sgdgIpagv5U9rS',0,'2019-11-08',NULL,NULL),(5,'FOPCI','Front OPCI','OPCI','FO',1,6,'$2a$10$k6uWiAeD3fs7YlmRJ8c3.O9z3QuD2GJp3gqsX27sgdgIpagv5U9rS',0,'2019-11-08',NULL,NULL),(6,'FMAND','Front Mandat','MAND','FO',1,7,'$2a$10$k6uWiAeD3fs7YlmRJ8c3.O9z3QuD2GJp3gqsX27sgdgIpagv5U9rS',0,'2019-11-08',NULL,NULL),(7,'MO','Middle office','Middle','MO',1,2,'$2a$10$k6uWiAeD3fs7YlmRJ8c3.O9z3QuD2GJp3gqsX27sgdgIpagv5U9rS',0,'2019-11-08',NULL,NULL),(8,'SYPEX','SYPEX','SYPEX','SYPEX',1,1,'$2a$10$B4yHcNViKq/MRF0I.3Oym.pWesk7MwSa3Mf61Md79WoOmy4V5k0ty',0,'2019-11-09',NULL,NULL),(11,'USER3','USER 3','USER 3','TEST',0,1,'$2a$10$k6uWiAeD3fs7YlmRJ8c3.O9z3QuD2GJp3gqsX27sgdgIpagv5U9rS',0,'2019-11-08',NULL,NULL),(12,'DEMO','DEMO','DEMO','DEMO',1,9,'$2a$10$xsWGmmKCtPwoNkICY4bjXOIJkBbVuoUtzNy3LheCOx2eEAplyq4DC',0,NULL,NULL,NULL),(13,'FS','Faculte','Science','ADMIN',0,1,'$2a$10$txx1RH3xibAAhZ0wcAIIbOOITiDxpqolWi.gi6NcIq/eK/gVdfjk6',0,NULL,NULL,NULL),(16,'FST','Faculte','technique','ADMIN',0,10,'$2a$10$hPf9pxeLtTadzQOApsYoReYfAiHn4no3GcynFXeyiWcy85KvZwoXS',0,NULL,NULL,NULL),(19,'FSTSS','settat','Science','Firest Open',0,14,'$2a$10$ZY.m3xPm3pEkYn32NPM1buC.frb2XQjIm6AprTwe1ACOdROUoYha.',0,'2022-06-08','2022-06-08',1),(20,'GI','François ','Dumony','ADMIN',0,10,'$2a$10$9ylvH4ka.QwshMXuIgwlveViTsm4Ryh.mhvMqmGH5golQPIFAolxO',0,'2022-06-08','2022-06-08',1),(21,'GLT','Faris','Zaki','CLT',0,1,'$2a$10$3JSQIiKuwK.e2fumQi6piuZediByqzUjp01ISGYgsanF3zHeoKSoe',0,'2022-06-08','2022-06-08',1);
/*!40000 ALTER TABLE `ruser` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-06-12 19:20:29
