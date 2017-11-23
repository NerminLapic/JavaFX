-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: firma
-- ------------------------------------------------------
-- Server version	5.7.16-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `ugovori`
--

DROP TABLE IF EXISTS `ugovori`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ugovori` (
  `idUgovora` int(11) NOT NULL AUTO_INCREMENT,
  `ime` varchar(45) NOT NULL,
  `prezime` varchar(45) NOT NULL,
  `adresa` varchar(45) DEFAULT NULL,
  `brzina` varchar(45) DEFAULT NULL,
  `protok` varchar(45) DEFAULT NULL,
  `trajanjeUgovora` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idUgovora`),
  UNIQUE KEY `idUgovora_UNIQUE` (`idUgovora`)
) ENGINE=InnoDB AUTO_INCREMENT=63 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ugovori`
--

LOCK TABLES `ugovori` WRITE;
/*!40000 ALTER TABLE `ugovori` DISABLE KEYS */;
INSERT INTO `ugovori` VALUES (62,'Nermin','Lapic','Sarajevo','10 MBit','10 GB','1 godina');
/*!40000 ALTER TABLE `ugovori` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `uposlenici`
--

DROP TABLE IF EXISTS `uposlenici`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `uposlenici` (
  `idUposlenika` int(11) NOT NULL AUTO_INCREMENT,
  `adresaUposlenika` varchar(255) DEFAULT NULL,
  `imeUposlenika` varchar(255) DEFAULT NULL,
  `brojGodina` int(11) DEFAULT NULL,
  `visinaDohodka` int(11) DEFAULT NULL,
  PRIMARY KEY (`idUposlenika`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `uposlenici`
--

LOCK TABLES `uposlenici` WRITE;
/*!40000 ALTER TABLE `uposlenici` DISABLE KEYS */;
INSERT INTO `uposlenici` VALUES (6,'Sarajevon','Nermin Lapic',30,20000),(8,'Lukacica','Semir',30,3030);
/*!40000 ALTER TABLE `uposlenici` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-10-05 10:00:32
