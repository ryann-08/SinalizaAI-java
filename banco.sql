-- MySQL dump 10.13  Distrib 8.0.46, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: sinalizaai_db
-- ------------------------------------------------------
-- Server version	8.0.46

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
-- Table structure for table `amostras_dataset`
--

DROP TABLE IF EXISTS `amostras_dataset`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `amostras_dataset` (
  `id` int NOT NULL AUTO_INCREMENT,
  `sinais_id` int NOT NULL,
  `arquivo` varchar(255) NOT NULL,
  `gravado_por` varchar(50) NOT NULL,
  `STATUS` enum('pendente','aprovado','rejeitado') DEFAULT 'pendente',
  `criado_em` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `sinais_id` (`sinais_id`),
  CONSTRAINT `amostras_dataset_ibfk_1` FOREIGN KEY (`sinais_id`) REFERENCES `sinais` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `amostras_dataset`
--

LOCK TABLES `amostras_dataset` WRITE;
/*!40000 ALTER TABLE `amostras_dataset` DISABLE KEYS */;
/*!40000 ALTER TABLE `amostras_dataset` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `atendentes`
--

DROP TABLE IF EXISTS `atendentes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `atendentes` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `cargo` varchar(100) NOT NULL,
  `ativo` tinyint(1) DEFAULT '1',
  `criado_em` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `atendentes`
--

LOCK TABLES `atendentes` WRITE;
/*!40000 ALTER TABLE `atendentes` DISABLE KEYS */;
/*!40000 ALTER TABLE `atendentes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `intencoes`
--

DROP TABLE IF EXISTS `intencoes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `intencoes` (
  `id` int NOT NULL AUTO_INCREMENT,
  `codigo` varchar(100) NOT NULL,
  `descricao` text NOT NULL,
  `sinal_id` int NOT NULL,
  `criado_em` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `sinal_id` (`sinal_id`),
  CONSTRAINT `intencoes_ibfk_1` FOREIGN KEY (`sinal_id`) REFERENCES `sinais` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `intencoes`
--

LOCK TABLES `intencoes` WRITE;
/*!40000 ALTER TABLE `intencoes` DISABLE KEYS */;
/*!40000 ALTER TABLE `intencoes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `logs_uso`
--

DROP TABLE IF EXISTS `logs_uso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `logs_uso` (
  `id` int NOT NULL AUTO_INCREMENT,
  `sinal_id` int NOT NULL,
  `usuario_id` int NOT NULL,
  `atendente_id` int NOT NULL,
  `intencao_id` int DEFAULT NULL,
  `resposta_dada` text,
  `canal` varchar(50) DEFAULT NULL,
  `criado_em` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `sinal_id` (`sinal_id`),
  KEY `usuario_id` (`usuario_id`),
  CONSTRAINT `logs_uso_ibfk_1` FOREIGN KEY (`sinal_id`) REFERENCES `sinais` (`id`),
  CONSTRAINT `logs_uso_ibfk_2` FOREIGN KEY (`usuario_id`) REFERENCES `usuarios_adm` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `logs_uso`
--

LOCK TABLES `logs_uso` WRITE;
/*!40000 ALTER TABLE `logs_uso` DISABLE KEYS */;
/*!40000 ALTER TABLE `logs_uso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `modelos_treinados`
--

DROP TABLE IF EXISTS `modelos_treinados`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `modelos_treinados` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `versao` varchar(50) NOT NULL,
  `quantidade_sinais` int NOT NULL,
  `precisao` decimal(5,2) NOT NULL,
  `arquivo_modelos` varchar(255) NOT NULL,
  `ativo` tinyint(1) DEFAULT '1',
  `criado_em` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `modelos_treinados`
--

LOCK TABLES `modelos_treinados` WRITE;
/*!40000 ALTER TABLE `modelos_treinados` DISABLE KEYS */;
/*!40000 ALTER TABLE `modelos_treinados` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `respostas`
--

DROP TABLE IF EXISTS `respostas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `respostas` (
  `id` int NOT NULL AUTO_INCREMENT,
  `intencao_id` int NOT NULL,
  `texto_resposta` text NOT NULL,
  `glosa` varchar(255) DEFAULT NULL,
  `arquivo_avatar` varchar(255) DEFAULT NULL,
  `criado_em` datetime DEFAULT CURRENT_TIMESTAMP,
  `atualizado_em` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `intencao_id` (`intencao_id`),
  CONSTRAINT `respostas_ibfk_1` FOREIGN KEY (`intencao_id`) REFERENCES `intencoes` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `respostas`
--

LOCK TABLES `respostas` WRITE;
/*!40000 ALTER TABLE `respostas` DISABLE KEYS */;
/*!40000 ALTER TABLE `respostas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sinais`
--

DROP TABLE IF EXISTS `sinais`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sinais` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `categoria` varchar(50) DEFAULT NULL,
  `ativo` tinyint(1) DEFAULT '1',
  `criado_em` datetime DEFAULT CURRENT_TIMESTAMP,
  `atualizado_em` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sinais`
--

LOCK TABLES `sinais` WRITE;
/*!40000 ALTER TABLE `sinais` DISABLE KEYS */;
INSERT INTO `sinais` VALUES (1,'AGUA','Substantivo',1,'2026-05-15 18:40:44','2026-06-02 23:34:54');
/*!40000 ALTER TABLE `sinais` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios_adm`
--

DROP TABLE IF EXISTS `usuarios_adm`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios_adm` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `senha_hash` varchar(255) NOT NULL,
  `nivel_acesso` enum('admin','colaborador') DEFAULT 'colaborador',
  `criado_em` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios_adm`
--

LOCK TABLES `usuarios_adm` WRITE;
/*!40000 ALTER TABLE `usuarios_adm` DISABLE KEYS */;
/*!40000 ALTER TABLE `usuarios_adm` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-06-03  0:00:10
