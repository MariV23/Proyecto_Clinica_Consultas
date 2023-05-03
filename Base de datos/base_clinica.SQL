CREATE DATABASE  IF NOT EXISTS `clinica` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `clinica`;
-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: localhost    Database: clinica
-- ------------------------------------------------------
-- Server version	8.0.30

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
-- Table structure for table `area`
--

DROP TABLE IF EXISTS `area`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `area` (
  `id_Area` int NOT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `descripcion` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id_Area`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `area`
--

LOCK TABLES `area` WRITE;
/*!40000 ALTER TABLE `area` DISABLE KEYS */;
INSERT INTO `area` VALUES (1,'Análisis Clínicos','Toma de muestras de EGO y sangre para estudios'),(2,'Consulta General','Atención en medicina general'),(3,'Dermatología','Atención especializada en cuidados de la piel'),(4,'Ginecología','Consulta especializada en cuidados de la mujer'),(5,'Cardiología','Atención médica para problemas cardiacos'),(6,'Podología','Atención médica para afecciones de pies y tobillos');
/*!40000 ALTER TABLE `area` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `can_cita`
--

DROP TABLE IF EXISTS `can_cita`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `can_cita` (
  `idcan_Cita` int NOT NULL,
  `motivo` varchar(45) DEFAULT NULL,
  `id_Cita` int NOT NULL,
  PRIMARY KEY (`idcan_Cita`),
  KEY `fk_citas_canCita_idx` (`id_Cita`),
  CONSTRAINT `fk_citas_canCita` FOREIGN KEY (`id_Cita`) REFERENCES `citas` (`id_Citas`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `can_cita`
--

LOCK TABLES `can_cita` WRITE;
/*!40000 ALTER TABLE `can_cita` DISABLE KEYS */;
/*!40000 ALTER TABLE `can_cita` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `citas`
--

DROP TABLE IF EXISTS `citas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `citas` (
  `id_Citas` int NOT NULL,
  `n_Paciente` varchar(45) DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  `hora` time DEFAULT NULL,
  `id_Paciente` int NOT NULL,
  `id_Especialista` int NOT NULL,
  PRIMARY KEY (`id_Citas`),
  KEY `fk_pac_citas_idx` (`id_Paciente`),
  KEY `fk_esp_citas_idx` (`id_Especialista`),
  CONSTRAINT `fk_esp_citas` FOREIGN KEY (`id_Especialista`) REFERENCES `especialistas` (`id_Especialistas`),
  CONSTRAINT `fk_pac_citas` FOREIGN KEY (`id_Paciente`) REFERENCES `pacientes` (`id_Pacientes`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `citas`
--

LOCK TABLES `citas` WRITE;
/*!40000 ALTER TABLE `citas` DISABLE KEYS */;
/*!40000 ALTER TABLE `citas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `especialistas`
--

DROP TABLE IF EXISTS `especialistas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `especialistas` (
  `id_Especialistas` int NOT NULL,
  `ced_Especialista` int DEFAULT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `correo` varchar(45) DEFAULT NULL,
  `hora_Entrada` time DEFAULT NULL,
  `hora_Salida` time DEFAULT NULL,
  `id_Area` int NOT NULL,
  PRIMARY KEY (`id_Especialistas`),
  KEY `fk_area_esp_idx` (`id_Area`),
  CONSTRAINT `fk_area_esp` FOREIGN KEY (`id_Area`) REFERENCES `area` (`id_Area`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `especialistas`
--

LOCK TABLES `especialistas` WRITE;
/*!40000 ALTER TABLE `especialistas` DISABLE KEYS */;
INSERT INTO `especialistas` VALUES (1,9174823,'Dra. Alba Lopez Guzman','albalopez@gmail.com','08:00:00','17:00:00',1),(2,5674824,'Dr. Alejandro Perez Gonzalez','alejandroperez@gmail.com','08:00:00','18:00:00',2),(3,3254679,'Dra. Luz Esperenza RuIZ Rojas','luzesperanza@gmail.com','08:00:00','13:00:00',3),(4,1214967,'Dra. Sara Avila Quiñones','saraquinones@gmail.com','08:00:00','14:00:00',4),(5,6349183,'Dr. Rual Arroyo Velasquez','raularroyo12@gmail.com','08:00:00','12:00:00',5),(6,3452612,'Dr. Hector Campos Sandoval','hectorsandoval@gmail.com','08:00:00','15:00:00',6);
/*!40000 ALTER TABLE `especialistas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pacientes`
--

DROP TABLE IF EXISTS `pacientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pacientes` (
  `id_Pacientes` int NOT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `telefono` int DEFAULT NULL,
  `correo` varchar(45) DEFAULT NULL,
  `edad` int DEFAULT NULL,
  PRIMARY KEY (`id_Pacientes`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pacientes`
--

LOCK TABLES `pacientes` WRITE;
/*!40000 ALTER TABLE `pacientes` DISABLE KEYS */;
/*!40000 ALTER TABLE `pacientes` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-04-27  8:44:54
