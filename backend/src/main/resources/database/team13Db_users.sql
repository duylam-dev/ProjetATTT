-- MySQL dump 10.13  Distrib 8.0.36, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: team13Db
-- ------------------------------------------------------
-- Server version	5.5.5-10.4.28-MariaDB

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
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `refresh_token` longtext DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `updated_by` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (2,'2024-06-17 20:51:13.000000','user@gmail.com','user@gmail.com','$2a$10$6/lT4O6QvUrzcEvsmSyikucs4JdVPhETaNQe9zTzBT9EHkjXJt3Gm','eyJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJ0ZWFtIDEzIiwic3ViIjoidXNlckBnbWFpbC5jb20iLCJleHAiOjE3MTg4MDYzMzIsImlhdCI6MTcxODcxOTkzMiwidXNlciI6eyJpZCI6MiwiZW1haWwiOiJ1c2VyQGdtYWlsLmNvbSIsIm5hbWUiOiJhYmMyIn19.ATAaqXvLLNd6oWbMIqpT0PEWmMkyOCzhL7KO7O2ag5vc-zmzMAa6mUurL8fllV2jpnIhdePbn2yRzbBlOFYPdsZscV_2_ky7Td9kGEOWQ1oQmSJeT78HPbNoDVqGfASLP90Lre5eKy3eD4CuBseqGJJQgV1p8g1SFQEMaCwJLNoap6w_zSs8dtuj1nPF9nzFO7j9kUwVfM18eGSfYVCg1ii9Gpi_kCa8I7RBjCW_QI3B2iYNCNPP5SOvg4mQPvLxsP3phceFpnzr-mYy6dZ6Epl1kpNfVNdqsd01EvWLndEa-3Q1yGbITGRmjMAexfedpyi5MObcFTRtDYTAxE-hRw','2024-06-18 14:12:12.000000','user@gmail.com','abc2'),(8,'2024-06-17 22:53:43.000000','user@gmail.com','duylam@gmail.com','$2a$10$/08GDfR4NKVqdvii9ZLU9O4VMsZMkLvnzIraxutItw1W7w9t0q6Va',NULL,NULL,NULL,'lam'),(9,'2024-06-17 23:05:18.000000','user@gmail.com','duylam1@gmail.com','$2a$10$pBvMGqmnMWSrK1pKb.qwd.4D8k0lr83nIYh9ChC.M9IF1mgSCENq6',NULL,NULL,NULL,'lam'),(10,'2024-06-18 00:27:58.000000','user@gmail.com','duylam2@gmail.com','$2a$10$k.B/iFzkL2NZhWhid002E.2rh4K9pKHdwncxuhVHwm.JGRV.F0AVe',NULL,NULL,NULL,'lam');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-06-18 21:23:16
