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
-- Table structure for table `cdocument_list`
--

DROP TABLE IF EXISTS `cdocument_list`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cdocument_list` (
  `id` int NOT NULL AUTO_INCREMENT,
  `type_id` varchar(15) NOT NULL,
  `category_id` varchar(10) NOT NULL,
  `name` varchar(50) NOT NULL,
  `is_mandatory` tinyint NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `cdocument_lis_typeId` (`type_id`),
  KEY `cdocument_lis_categId` (`category_id`),
  CONSTRAINT `cdocument_lis_categId` FOREIGN KEY (`category_id`) REFERENCES `clistcust` (`id`),
  CONSTRAINT `cdocument_lis_typeId` FOREIGN KEY (`type_id`) REFERENCES `clistsys` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cdocument_list`
--

LOCK TABLES `cdocument_list` WRITE;
/*!40000 ALTER TABLE `cdocument_list` DISABLE KEYS */;
INSERT INTO `cdocument_list` VALUES (1,'DOC_CENTR','ACPR_EDMC','Accord de principe',0),(2,'DOC_ACTOR','ADOC_EDMC','Document',0),(4,'DOC_TICKET','AOP_EDMDC','Avis d\'opéré',0),(5,'DOC_CORPAC','APFON_EDMC','Appel de fonds',0),(6,'DOC_ACTOR','APHOT_EDMC','Photos',0),(7,'DOC_CORPAC','ATTPR_EDMC','Attestation de propriété',0),(9,'DOC_CENTR','AVCR_EDMC','Avis de création',0);
/*!40000 ALTER TABLE `cdocument_list` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-06-12 19:20:28
