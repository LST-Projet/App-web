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
-- Table structure for table `cpnl_setting_detail`
--

DROP TABLE IF EXISTS `cpnl_setting_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cpnl_setting_detail` (
  `id` int NOT NULL AUTO_INCREMENT,
  `pnl_setting_id` varchar(10) NOT NULL,
  `class_id` varchar(10) NOT NULL,
  `category_id` varchar(10) DEFAULT NULL,
  `inventory_meth_id` varchar(10) NOT NULL,
  `is_gross_mode` tinyint(1) NOT NULL DEFAULT '0',
  `is_provisioned` tinyint(1) NOT NULL DEFAULT '0',
  `provision_rate` decimal(10,6) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cpnl_setd_unique` (`pnl_setting_id`,`class_id`,`category_id`),
  KEY `cpnl_setd_pnl_setti_idx` (`pnl_setting_id`),
  KEY `cpnl_setd_category` (`category_id`),
  KEY `cpnl_setd_inventor` (`inventory_meth_id`),
  KEY `cpnl_setd_class_id` (`class_id`),
  CONSTRAINT `cpnl_setd_category` FOREIGN KEY (`category_id`) REFERENCES `clistcust` (`id`),
  CONSTRAINT `cpnl_setd_class_id` FOREIGN KEY (`class_id`) REFERENCES `clistsys` (`id`),
  CONSTRAINT `cpnl_setd_inventor` FOREIGN KEY (`inventory_meth_id`) REFERENCES `clistsys` (`id`),
  CONSTRAINT `cpnl_setd_pnl_setti` FOREIGN KEY (`pnl_setting_id`) REFERENCES `cpnl_setting` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cpnl_setting_detail`
--

LOCK TABLES `cpnl_setting_detail` WRITE;
/*!40000 ALTER TABLE `cpnl_setting_detail` DISABLE KEYS */;
INSERT INTO `cpnl_setting_detail` VALUES (5,'AGC','EQ',NULL,'AVC',1,0,NULL),(7,'ANC','EQ',NULL,'AVC',0,0,NULL),(9,'FGC','EQ',NULL,'FIFO',1,0,NULL),(11,'FNC','EQ',NULL,'FIFO',0,0,NULL),(13,'AGC','FI',NULL,'AVC',1,0,NULL),(15,'ANC','FI',NULL,'AVC',0,0,NULL),(17,'FGC','FI',NULL,'FIFO',1,0,NULL),(19,'FNC','FI',NULL,'FIFO',0,0,NULL),(28,'AGC','UC',NULL,'AVC',1,0,NULL),(30,'ANC','UC',NULL,'AVC',0,0,NULL),(32,'FGC','UC',NULL,'FIFO',1,0,NULL),(34,'FNC','UC',NULL,'FIFO',0,0,NULL),(36,'AGC','1M_MIND','10_CREG','1Y_PRS',1,0,NULL),(38,'AGC','1Y_RREVP','16_CREG','1M_MIND',1,0,NULL),(41,'FNC','1M_MIND','10_CREG','1M_MIND',0,0,NULL);
/*!40000 ALTER TABLE `cpnl_setting_detail` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-06-12 19:20:27
