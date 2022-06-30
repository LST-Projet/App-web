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
-- Table structure for table `ccurve`
--

DROP TABLE IF EXISTS `ccurve`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ccurve` (
  `id` varchar(10) NOT NULL,
  `name` varchar(50) NOT NULL,
  `is_visible` tinyint(1) NOT NULL,
  `type_id` varchar(10) NOT NULL,
  `source_id` varchar(10) DEFAULT NULL,
  `rate_type_id` varchar(10) NOT NULL,
  `currency_id` varchar(10) NOT NULL,
  `matur_type_id` varchar(10) DEFAULT NULL,
  `flatt_maturity` int DEFAULT NULL,
  `rf_currency_id` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `ccurve_categ_id` (`type_id`),
  KEY `ccurve_source_id` (`source_id`),
  KEY `ccurve_currency_idx` (`currency_id`),
  KEY `ccurve_rfCurren` (`rf_currency_id`),
  CONSTRAINT `ccurve_categ_id` FOREIGN KEY (`type_id`) REFERENCES `clistsys` (`id`),
  CONSTRAINT `ccurve_currency` FOREIGN KEY (`currency_id`) REFERENCES `rcurrency` (`id`),
  CONSTRAINT `ccurve_rf_curren` FOREIGN KEY (`rf_currency_id`) REFERENCES `rcurrency` (`id`),
  CONSTRAINT `ccurve_source_id` FOREIGN KEY (`source_id`) REFERENCES `ccurve` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ccurve`
--

LOCK TABLES `ccurve` WRITE;
/*!40000 ALTER TABLE `ccurve` DISABLE KEYS */;
INSERT INTO `ccurve` VALUES ('CCM','Fast Open',0,'1M_MIND','CCM','AART','EUR','DYM',54,'EUR'),('JJBAM','Courbe spot BAM',1,'SPRC','CCM','MART','MAD','DDMT',56,'EUR'),('TNRBAM','Tenors',1,'TNRC','JJBAM','MART','MAD','DYMT',NULL,NULL),('ZCBAM','Courbe zéro coupon BAM',1,'ZCRC','JJBAM','AART','MAD','DYMT',NULL,NULL);
/*!40000 ALTER TABLE `ccurve` ENABLE KEYS */;
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
