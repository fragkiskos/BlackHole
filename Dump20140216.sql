CREATE DATABASE  IF NOT EXISTS `itstock` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `itstock`;
-- MySQL dump 10.13  Distrib 5.5.34, for debian-linux-gnu (i686)
--
-- Host: localhost    Database: itstock
-- ------------------------------------------------------
-- Server version	5.5.34-0ubuntu0.12.04.1

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
-- Table structure for table `Negotiation`
--

DROP TABLE IF EXISTS `Negotiation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Negotiation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) DEFAULT NULL,
  `shareId` int(11) DEFAULT NULL,
  `new_price` double DEFAULT NULL,
  `old_price` double DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Negotiation`
--

LOCK TABLES `Negotiation` WRITE;
/*!40000 ALTER TABLE `Negotiation` DISABLE KEYS */;
INSERT INTO `Negotiation` VALUES (1,0,0,0,0,'2014-02-16 12:15:47');
/*!40000 ALTER TABLE `Negotiation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `exchangePanel`
--

DROP TABLE IF EXISTS `exchangePanel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `exchangePanel` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `isclosed` bit(1) DEFAULT b'0',
  `shareId` int(11) DEFAULT NULL,
  `createdDate` datetime DEFAULT NULL,
  `closedDate` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exchangePanel`
--

LOCK TABLES `exchangePanel` WRITE;
/*!40000 ALTER TABLE `exchangePanel` DISABLE KEYS */;
INSERT INTO `exchangePanel` VALUES (1,'',0,'2014-02-15 11:03:27','2014-02-15 11:03:27');
/*!40000 ALTER TABLE `exchangePanel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `panel_buyers`
--

DROP TABLE IF EXISTS `panel_buyers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `panel_buyers` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) DEFAULT NULL,
  `panelId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `panel_buyers`
--

LOCK TABLES `panel_buyers` WRITE;
/*!40000 ALTER TABLE `panel_buyers` DISABLE KEYS */;
INSERT INTO `panel_buyers` VALUES (3,0,0);
/*!40000 ALTER TABLE `panel_buyers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `exchange`
--

DROP TABLE IF EXISTS `exchange`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `exchange` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date` datetime DEFAULT NULL,
  `shareId` int(11) DEFAULT NULL,
  `sellerId` int(11) DEFAULT NULL,
  `buyerId` int(11) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `selled_shares_Number` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exchange`
--

LOCK TABLES `exchange` WRITE;
/*!40000 ALTER TABLE `exchange` DISABLE KEYS */;
INSERT INTO `exchange` VALUES (1,'2014-02-15 11:00:24',0,0,0,0,0);
/*!40000 ALTER TABLE `exchange` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `call_for_sell`
--

DROP TABLE IF EXISTS `call_for_sell`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `call_for_sell` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `callerId` int(11) DEFAULT NULL,
  `Date` datetime DEFAULT NULL,
  `panelId` int(11) DEFAULT NULL,
  `shareId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `call_for_sell`
--

LOCK TABLES `call_for_sell` WRITE;
/*!40000 ALTER TABLE `call_for_sell` DISABLE KEYS */;
INSERT INTO `call_for_sell` VALUES (1,0,'2014-02-15 10:56:37',0,0);
/*!40000 ALTER TABLE `call_for_sell` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `share`
--

DROP TABLE IF EXISTS `share`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `share` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(400) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `insertedDate` datetime DEFAULT NULL,
  `active` bit(1) DEFAULT b'1',
  `activateDate` datetime DEFAULT NULL,
  `deactivateDate` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `share`
--

LOCK TABLES `share` WRITE;
/*!40000 ALTER TABLE `share` DISABLE KEYS */;
INSERT INTO `share` VALUES (1,'sdfsd',4.3,'2014-02-09 15:25:42','','2014-02-09 15:25:42','2014-02-09 15:25:42'),(2,'sdfsd',4.3,'2014-02-09 15:26:50','','2014-02-09 15:26:50',NULL),(3,'sdfsd',4.3,'2014-02-09 18:38:22','','2014-02-09 18:38:22',NULL),(4,'sdfsd',4.3,'2014-02-09 18:43:26','','2014-02-09 18:43:26',NULL);
/*!40000 ALTER TABLE `share` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Users_Shares`
--

DROP TABLE IF EXISTS `Users_Shares`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Users_Shares` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) DEFAULT NULL,
  `shareid` int(11) DEFAULT NULL,
  `count` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Users_Shares`
--

LOCK TABLES `Users_Shares` WRITE;
/*!40000 ALTER TABLE `Users_Shares` DISABLE KEYS */;
/*!40000 ALTER TABLE `Users_Shares` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `call_for_buy`
--

DROP TABLE IF EXISTS `call_for_buy`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `call_for_buy` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `callerId` int(11) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `panelId` int(11) DEFAULT NULL,
  `shareId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `call_for_buy`
--

LOCK TABLES `call_for_buy` WRITE;
/*!40000 ALTER TABLE `call_for_buy` DISABLE KEYS */;
INSERT INTO `call_for_buy` VALUES (1,0,'2014-02-15 10:54:34',0,0);
/*!40000 ALTER TABLE `call_for_buy` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `panel_exchanges`
--

DROP TABLE IF EXISTS `panel_exchanges`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `panel_exchanges` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `exchangeId` int(11) DEFAULT NULL,
  `panelId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `panel_exchanges`
--

LOCK TABLES `panel_exchanges` WRITE;
/*!40000 ALTER TABLE `panel_exchanges` DISABLE KEYS */;
INSERT INTO `panel_exchanges` VALUES (1,0,0),(2,0,0),(3,0,0);
/*!40000 ALTER TABLE `panel_exchanges` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `User`
--

DROP TABLE IF EXISTS `User`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `User` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(400) DEFAULT NULL,
  `email` varchar(400) DEFAULT NULL,
  `name` varchar(400) DEFAULT NULL,
  `sirname` varchar(400) DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  `loginService` varchar(400) DEFAULT NULL,
  `locked` bit(1) DEFAULT b'0',
  `password` varchar(400) DEFAULT NULL,
  `passQuestion` varchar(400) DEFAULT NULL,
  `passAnswer` varchar(45) DEFAULT NULL,
  `frankos` double DEFAULT NULL,
  `active` bit(1) DEFAULT b'1',
  `InsertedDate` datetime DEFAULT NULL,
  `deactivateDate` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `User`
--

LOCK TABLES `User` WRITE;
/*!40000 ALTER TABLE `User` DISABLE KEYS */;
INSERT INTO `User` VALUES (2,'asda','aD','ASDA','ASDA','ASDA','','\0','asdad','zxc','adasd',2,'','2014-02-07 21:25:25','2014-02-07 21:25:25'),(3,'asda','aD','ASDA','ASDA','ASDA','','\0','asdad','zxc','adasd',2,'','2014-02-07 21:26:27','2014-02-07 21:26:27');
/*!40000 ALTER TABLE `User` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `panel_sellers`
--

DROP TABLE IF EXISTS `panel_sellers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `panel_sellers` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `panelId` int(11) DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `panel_sellers`
--

LOCK TABLES `panel_sellers` WRITE;
/*!40000 ALTER TABLE `panel_sellers` DISABLE KEYS */;
INSERT INTO `panel_sellers` VALUES (1,0,0);
/*!40000 ALTER TABLE `panel_sellers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `company`
--

DROP TABLE IF EXISTS `company`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `company` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `logoUrl` varchar(2000) DEFAULT NULL,
  `name` varchar(1000) DEFAULT NULL,
  `description` text,
  `siteUrl` varchar(2000) DEFAULT NULL,
  `shareId` int(11) DEFAULT NULL,
  `userId` int(11) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `company`
--

LOCK TABLES `company` WRITE;
/*!40000 ALTER TABLE `company` DISABLE KEYS */;
INSERT INTO `company` VALUES (1,'http://www.google.com','google','aasdsadadaada','sdfsf',1,1),(2,'http://www.google.com','google','aasdsadadaada','sdfsf',1,1);
/*!40000 ALTER TABLE `company` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `panel_share_negotiations`
--

DROP TABLE IF EXISTS `panel_share_negotiations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `panel_share_negotiations` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `panelId` int(11) DEFAULT NULL,
  `share_negotiationId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `panel_share_negotiations`
--

LOCK TABLES `panel_share_negotiations` WRITE;
/*!40000 ALTER TABLE `panel_share_negotiations` DISABLE KEYS */;
INSERT INTO `panel_share_negotiations` VALUES (1,0,0);
/*!40000 ALTER TABLE `panel_share_negotiations` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-02-16 19:50:23
