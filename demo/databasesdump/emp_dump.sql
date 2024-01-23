-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: emp
-- ------------------------------------------------------
-- Server version	8.0.34

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `check_in_time` datetime(6) DEFAULT NULL,
  `check_out_time` datetime(6) DEFAULT NULL,
  `department` varchar(255) DEFAULT NULL,
  `employee_id` varchar(255) DEFAULT NULL,
  `last_attendance_date` datetime(6) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `total_hours_worked` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (1,'2024-01-22 00:06:40.972000','2024-01-21 23:14:53.885000','IT','em01',NULL,'Ashish vade',0),(2,'2024-01-23 15:44:05.493475','2024-01-22 08:49:55.496000','devlopment','em02','2024-01-21 22:56:28.402000','Atharv Vade',0),(4,'2024-01-21 23:33:42.450000','2024-01-22 08:50:24.354000','devlopment','Em04','2024-01-21 23:33:42.450000','Ashish vade',0),(5,'2024-01-21 23:34:17.867000','2024-01-22 08:50:29.372000','testing','Em05','2024-01-21 23:34:17.867000','aarohi kukade',0),(6,'2024-01-21 23:34:44.746000','2024-01-22 08:50:34.144000','devlopment','Em06','2024-01-21 23:34:44.746000','shubham k',0),(7,'2024-01-21 23:35:33.932000','2024-01-22 08:50:38.972000','testing','Em07','2024-01-21 23:35:33.932000','sourabh v',0),(8,'2024-01-21 23:36:00.570000','2024-01-22 08:50:43.756000','devlopment','Em08','2024-01-21 23:36:00.570000','tushar v',0),(9,'2024-01-21 23:36:26.733000','2024-01-22 08:50:49.578000','qa','Em09','2024-01-21 23:36:26.733000','om k',0),(10,'2024-01-22 08:41:48.372000','2024-01-22 08:51:27.522000','qa','Em10','2024-01-22 08:41:48.372000','omii kum',0),(11,'2024-01-23 15:57:20.323824',NULL,'IT','em11','2024-01-23 15:57:20.323824','raj thoke',0);
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-01-23 16:53:32