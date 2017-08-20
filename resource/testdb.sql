CREATE DATABASE  IF NOT EXISTS `testdb`;
USE `testdb`;
-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: testdb
-- ------------------------------------------------------
-- Server version	5.7.17-log

--
-- Table structure for table `plsysuser`
--

DROP TABLE IF EXISTS `sysuser`;
CREATE TABLE `sysuser` (
  `acct` varchar(45) NOT NULL COMMENT '用户账号',
  `passw` varchar(45) NOT NULL COMMENT '密码',
  `type` varchar(10) NOT NULL COMMENT '用户类型，区别普通人员和管理员',
  `name` varchar(20) DEFAULT NULL COMMENT '真实姓名',
  `phone` varchar(20) DEFAULT NULL COMMENT '手机号码',
  PRIMARY KEY (`acct`),
  UNIQUE KEY `acct_UNIQUE` (`acct`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dump completed
