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
-- Table structure for table `cperf_category`
--

DROP TABLE IF EXISTS `cperf_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cperf_category` (
  `id` varchar(10) NOT NULL,
  `name` varchar(50) NOT NULL,
  `period_type` varchar(10) NOT NULL,
  `period_value` int DEFAULT NULL,
  `method` varchar(10) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `cpcateg_method` (`method`),
  KEY `cpcateg_periodtype` (`period_type`),
  CONSTRAINT `cpcateg_method` FOREIGN KEY (`method`) REFERENCES `clistsys` (`id`),
  CONSTRAINT `cpcateg_periodtype` FOREIGN KEY (`period_type`) REFERENCES `clistsys` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cperf_category`
--

LOCK TABLES `cperf_category` WRITE;
/*!40000 ALTER TABLE `cperf_category` DISABLE KEYS */;
INSERT INTO `cperf_category` VALUES ('13W','Perf sur 13 semaines glissantes','WNBR',13,'RVB'),('1D','Perf quotidienne','DNBR',1,'RVB'),('1M','Perf sur 1 mois glissant','MNBR',1,'RVB'),('1W','Perf hebdomadaire','WNBR',1,'RVB'),('1Y','Perf sur 1 année glissante','YNBR',1,'RVB'),('26W','Perf sur 26 semaines glissantes','WNBR',26,'RVB'),('2Y','Perf sur 2 années glissantes','YNBR',2,'RVB'),('3M','Perf sur 3 mois glissants','MNBR',3,'RVB'),('3Y','Perf sur 3 années glissantes','YNBR',3,'RVB'),('4Y','Perf sur 4 années glissantes','YNBR',4,'RVB'),('52W','Perf sur 52 semaines glissantes','WNBR',52,'RVB'),('5Y','Perf sur 5 années glissantes','YNBR',5,'RVB'),('6M','Perf sur 6 mois glissants','MNBR',6,'RVB'),('YTD','Perf depuis début de l\'année','YTD',NULL,'RVB');
/*!40000 ALTER TABLE `cperf_category` ENABLE KEYS */;
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
