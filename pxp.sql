/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1_3306
Source Server Version : 50712
Source Host           : 127.0.0.1:3306
Source Database       : p2p

Target Server Type    : MYSQL
Target Server Version : 50712
File Encoding         : 65001

Date: 2017-10-30 22:15:55
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `id` bigint(20) NOT NULL,
  `tradePassword` varchar(255) DEFAULT NULL,
  `usableAmount` decimal(18,4) NOT NULL,
  `freezedAmount` decimal(18,4) NOT NULL,
  `borrowLimitAmount` decimal(18,4) NOT NULL,
  `version` int(11) NOT NULL,
  `unReceiveInterest` decimal(18,4) NOT NULL,
  `unReceivePrincipal` decimal(18,4) NOT NULL,
  `unReturnAmount` decimal(18,4) NOT NULL,
  `remainBorrowLimit` decimal(18,4) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES ('4', null, '9878.0000', '122.0000', '3000.0000', '2', '0.0000', '0.0000', '0.0000', '3000.0000');
INSERT INTO `account` VALUES ('5', null, '0.0000', '0.0000', '3000.0000', '0', '0.0000', '0.0000', '0.0000', '3000.0000');
INSERT INTO `account` VALUES ('9', null, '0.0000', '0.0000', '3000.0000', '0', '0.0000', '0.0000', '0.0000', '3000.0000');
INSERT INTO `account` VALUES ('12', null, '9000.0000', '1000.0000', '3000.0000', '5', '0.0000', '0.0000', '0.0000', '3000.0000');
INSERT INTO `account` VALUES ('13', null, '9000.0000', '1000.0000', '3000.0000', '2', '0.0000', '0.0000', '0.0000', '3000.0000');

-- ----------------------------
-- Table structure for accountflow
-- ----------------------------
DROP TABLE IF EXISTS `accountflow`;
CREATE TABLE `accountflow` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `accountActionType` tinyint(4) NOT NULL,
  `amount` decimal(18,4) NOT NULL,
  `note` varchar(255) NOT NULL,
  `balance` decimal(18,4) NOT NULL,
  `freezed` decimal(18,4) NOT NULL,
  `actionTime` datetime NOT NULL,
  `account_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of accountflow
-- ----------------------------
INSERT INTO `accountflow` VALUES ('1', '0', '10000.0000', '线下充值:10000.0000 成功!', '10000.0000', '0.0000', '2017-09-22 20:01:14', '4');
INSERT INTO `accountflow` VALUES ('2', '0', '10000.0000', '线下充值:10000.0000 成功!', '10000.0000', '0.0000', '2017-09-22 20:17:38', '12');
INSERT INTO `accountflow` VALUES ('14', '10', '200.0000', '投标金额:200 成功!', '9800.0000', '200.0000', '2017-09-22 22:36:36', '12');
INSERT INTO `accountflow` VALUES ('15', '0', '10000.0000', '线下充值:10000.0000 成功!', '10000.0000', '0.0000', '2017-09-23 21:40:13', '13');
INSERT INTO `accountflow` VALUES ('28', '10', '200.0000', '投标金额:200 成功!', '9600.0000', '400.0000', '2017-09-23 21:56:38', '12');
INSERT INTO `accountflow` VALUES ('29', '10', '1000.0000', '投标金额:1000 成功!', '9000.0000', '1000.0000', '2017-09-23 21:57:54', '13');
INSERT INTO `accountflow` VALUES ('30', '10', '200.0000', '投标金额:200 成功!', '9400.0000', '600.0000', '2017-09-23 21:59:59', '12');
INSERT INTO `accountflow` VALUES ('32', '10', '400.0000', '投标金额:400.0000 成功!', '9000.0000', '1000.0000', '2017-09-23 22:19:05', '12');
INSERT INTO `accountflow` VALUES ('33', '10', '122.0000', '投标金额:122 成功!', '9878.0000', '122.0000', '2017-09-26 16:01:11', '4');
INSERT INTO `accountflow` VALUES ('50', '14', '100.0000', '投标活动金额:100 成功!', '4778.0000', '222.0000', '2017-09-26 17:17:58', '4');
INSERT INTO `accountflow` VALUES ('51', '14', '1000.0000', '投标活动金额:1000 成功!', '3778.0000', '1222.0000', '2017-09-26 17:18:39', '4');
INSERT INTO `accountflow` VALUES ('52', '14', '1500.0000', '投标活动金额:1500 成功!', '2278.0000', '2722.0000', '2017-09-26 17:19:15', '4');
INSERT INTO `accountflow` VALUES ('53', '14', '278.0000', '投标活动金额:278.0000 成功!', '2000.0000', '3000.0000', '2017-09-26 17:19:55', '4');

-- ----------------------------
-- Table structure for bid
-- ----------------------------
DROP TABLE IF EXISTS `bid`;
CREATE TABLE `bid` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `actualRate` decimal(8,4) NOT NULL,
  `availableAmount` decimal(18,4) NOT NULL,
  `bidrequest_id` bigint(20) NOT NULL,
  `bidUser_id` bigint(20) NOT NULL,
  `bidTime` datetime NOT NULL,
  `bidRequestTitle` varchar(255) DEFAULT NULL,
  `bidRequestState` tinyint(4) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bid
-- ----------------------------
INSERT INTO `bid` VALUES ('1', '33.3333', '200.0000', '9', '12', '2017-09-22 22:36:36', '给审核人充电(收下吧)', '4');
INSERT INTO `bid` VALUES ('2', '33.3333', '200.0000', '9', '12', '2017-09-23 21:56:38', '给审核人充电(收下吧)', '4');
INSERT INTO `bid` VALUES ('3', '33.3333', '1000.0000', '9', '13', '2017-09-23 21:57:54', '给审核人充电(收下吧)', '4');
INSERT INTO `bid` VALUES ('4', '33.3333', '200.0000', '9', '12', '2017-09-23 21:59:59', '给审核人充电(收下吧)', '4');
INSERT INTO `bid` VALUES ('6', '33.3333', '400.0000', '9', '12', '2017-09-23 22:19:05', '给审核人充电(收下吧)', '4');
INSERT INTO `bid` VALUES ('7', '12.5000', '122.0000', '10', '4', '2017-09-26 16:01:11', '平台大放水-大家快来抢啊', '1');
INSERT INTO `bid` VALUES ('8', '12.5000', '100.0000', '10', '4', '2017-09-26 17:17:58', '平台大放水-大家快来抢啊', '1');
INSERT INTO `bid` VALUES ('9', '12.5000', '1000.0000', '10', '4', '2017-09-26 17:18:39', '平台大放水-大家快来抢啊', '1');
INSERT INTO `bid` VALUES ('10', '12.5000', '1500.0000', '10', '4', '2017-09-26 17:19:15', '平台大放水-大家快来抢啊', '1');
INSERT INTO `bid` VALUES ('11', '12.5000', '278.0000', '10', '4', '2017-09-26 17:19:55', '平台大放水-大家快来抢啊', '1');

-- ----------------------------
-- Table structure for bidrequest
-- ----------------------------
DROP TABLE IF EXISTS `bidrequest`;
CREATE TABLE `bidrequest` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` int(11) NOT NULL,
  `bidRequestType` tinyint(4) DEFAULT NULL,
  `bidRequestState` tinyint(4) DEFAULT NULL,
  `bidRequestAmount` decimal(18,4) DEFAULT NULL,
  `currentRate` decimal(8,4) DEFAULT NULL,
  `monthes2Return` tinyint(4) DEFAULT NULL,
  `bidCount` int(11) DEFAULT NULL,
  `totalRewardAmount` decimal(18,4) DEFAULT NULL,
  `currentSum` decimal(18,4) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `disableDate` datetime DEFAULT NULL,
  `createuser_id` bigint(20) DEFAULT NULL,
  `disableDays` tinyint(4) DEFAULT NULL,
  `minBidAmount` decimal(18,4) DEFAULT NULL,
  `applyTime` datetime DEFAULT NULL,
  `publishTime` datetime DEFAULT NULL,
  `returnType` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bidrequest
-- ----------------------------
INSERT INTO `bidrequest` VALUES ('1', '1', '0', '2', '2000.0000', '5.0000', '3', null, '16.6898', null, '想要限量版figure', '-发薪日即可还', null, null, '4', '1', '100.0000', '2017-09-20 13:40:29', null, '0');
INSERT INTO `bidrequest` VALUES ('2', '1', '0', '2', '2000.0000', '5.0000', '1', null, '8.3333', null, '需要给信仰充值', '能还', null, null, '4', '1', '100.0000', '2017-09-20 21:38:24', null, '0');
INSERT INTO `bidrequest` VALUES ('3', '1', '0', '2', '2000.0000', '5.0000', '1', null, '8.3333', null, '交学费', '必还', null, null, '4', '1', '100.0000', '2017-09-20 21:44:33', null, '0');
INSERT INTO `bidrequest` VALUES ('4', '1', '0', '2', '2000.0000', '5.0000', '1', null, '8.3333', null, '交学费', '必还', null, null, '4', '1', '100.0000', '2017-09-20 21:44:33', null, '0');
INSERT INTO `bidrequest` VALUES ('5', '1', '0', '2', '2000.0000', '5.0000', '1', null, '8.3333', null, '再交学费', '必还', null, null, '4', '1', '100.0000', '2017-09-20 21:47:08', null, '0');
INSERT INTO `bidrequest` VALUES ('6', '1', '0', '2', '2000.0000', '10.0000', '6', null, '58.7367', null, '大保健', '必还', null, null, '4', '1', '100.0000', '2017-09-20 21:48:45', null, '0');
INSERT INTO `bidrequest` VALUES ('7', '1', '0', '2', '2000.0000', '20.0000', '1', null, '33.3333', null, '给审核人充电', '必还', null, null, '4', '1', '200.0000', '2017-09-20 22:02:52', null, '0');
INSERT INTO `bidrequest` VALUES ('8', '0', '0', '0', '2000.0000', '20.0000', '1', null, '33.3333', null, '给审核人充电', '必还', null, null, '4', '1', '200.0000', '2017-09-20 22:02:52', null, '0');
INSERT INTO `bidrequest` VALUES ('9', '6', '0', '4', '2000.0000', '20.0000', '1', '5', '33.3333', '2000.0000', '给审核人充电(收下吧)', '必还', null, '2017-09-21 22:08:54', '4', '1', '100.0000', '2017-09-20 22:08:09', '2017-09-20 22:08:54', '0');
INSERT INTO `bidrequest` VALUES ('10', '6', '1', '4', '3000.0000', '5.0000', '1', '5', '12.5000', '3000.0000', '平台大放水-大家快来抢啊', null, null, '2017-09-27 11:24:15', '10', '1', '50.0000', null, '2017-09-26 11:24:15', '0');

-- ----------------------------
-- Table structure for bidrequestaudithistory
-- ----------------------------
DROP TABLE IF EXISTS `bidrequestaudithistory`;
CREATE TABLE `bidrequestaudithistory` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `state` tinyint(4) NOT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `auditTime` datetime DEFAULT NULL,
  `applyTime` datetime DEFAULT NULL,
  `auditor_id` bigint(20) DEFAULT NULL,
  `applier_id` bigint(20) NOT NULL,
  `bidRequestId` bigint(20) NOT NULL,
  `auditType` tinyint(4) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bidrequestaudithistory
-- ----------------------------
INSERT INTO `bidrequestaudithistory` VALUES ('2', '2', '信息不明确', '2017-09-20 20:12:42', '2017-09-20 13:40:29', '10', '4', '1', '0');
INSERT INTO `bidrequestaudithistory` VALUES ('3', '2', 'sorry', '2017-09-20 21:41:36', '2017-09-20 21:38:24', '10', '4', '2', '0');
INSERT INTO `bidrequestaudithistory` VALUES ('4', '2', '重复了', '2017-09-20 21:45:10', '2017-09-20 21:44:33', '10', '4', '3', '0');
INSERT INTO `bidrequestaudithistory` VALUES ('5', '2', 'bug了', '2017-09-20 21:46:26', '2017-09-20 21:44:33', '10', '4', '4', '0');
INSERT INTO `bidrequestaudithistory` VALUES ('6', '2', '我要测试', '2017-09-20 21:47:34', '2017-09-20 21:47:08', '10', '4', '5', '0');
INSERT INTO `bidrequestaudithistory` VALUES ('7', '2', '最后一次', '2017-09-20 21:57:55', '2017-09-20 21:48:45', '10', '4', '6', '0');
INSERT INTO `bidrequestaudithistory` VALUES ('8', '2', '我不要', '2017-09-20 22:07:17', '2017-09-20 22:02:52', '10', '4', '7', '0');
INSERT INTO `bidrequestaudithistory` VALUES ('9', '1', '……', '2017-09-20 22:08:54', '2017-09-20 22:08:09', '10', '4', '9', '0');
INSERT INTO `bidrequestaudithistory` VALUES ('10', '1', 'pass', '2017-09-26 11:24:15', null, '10', '10', '10', '1');

-- ----------------------------
-- Table structure for employees
-- ----------------------------
DROP TABLE IF EXISTS `employees`;
CREATE TABLE `employees` (
  `employee_id` int(6) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(20) DEFAULT NULL,
  `last_name` varchar(25) NOT NULL,
  `email` varchar(25) NOT NULL,
  `phone_int` varchar(20) DEFAULT NULL,
  `hire_date` date NOT NULL,
  `job_id` varchar(10) NOT NULL,
  `salary` decimal(8,2) DEFAULT NULL,
  `commission_pct` decimal(2,2) DEFAULT NULL,
  `manager_id` int(6) DEFAULT NULL,
  `department_id` int(4) DEFAULT NULL,
  PRIMARY KEY (`employee_id`),
  UNIQUE KEY `emp_email_uk` (`email`),
  UNIQUE KEY `emp_emp_id_pk` (`employee_id`),
  KEY `emp_job_fk` (`job_id`),
  CONSTRAINT `employees_ibfk_1` FOREIGN KEY (`job_id`) REFERENCES `jobs` (`job_id`)
) ENGINE=InnoDB AUTO_INCREMENT=207 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of employees
-- ----------------------------
INSERT INTO `employees` VALUES ('100', 'Steven', 'King', 'SKING', '515.123.4567', '1987-06-17', 'AD_PRES', '24000.00', null, null, '90');
INSERT INTO `employees` VALUES ('101', 'Neena', 'Kochhar', 'NKOCHHAR', '515.123.4568', '1989-09-21', 'AD_VP', '17000.00', null, '100', '90');
INSERT INTO `employees` VALUES ('102', 'Lex', 'De Haan', 'LDEHAAN', '515.123.4569', '1993-01-13', 'AD_VP', '17000.00', null, '100', '90');
INSERT INTO `employees` VALUES ('103', 'Alexander', 'Hunold', 'AHUNOLD', '590.423.4567', '1990-01-03', 'IT_PROG', '9000.00', null, '102', '60');
INSERT INTO `employees` VALUES ('104', 'Bruce', 'Ernst', 'BERNST', '590.423.4568', '1991-05-21', 'IT_PROG', '6000.00', null, '103', '60');
INSERT INTO `employees` VALUES ('105', 'David', 'Austin', 'DAUSTIN', '590.423.4569', '1997-06-25', 'IT_PROG', '4800.00', null, '103', '60');
INSERT INTO `employees` VALUES ('106', 'Valli', 'Pataballa', 'VPATABAL', '590.423.4560', '1998-02-05', 'IT_PROG', '4800.00', null, '103', '60');
INSERT INTO `employees` VALUES ('107', 'Diana', 'Lorentz', 'DLORENTZ', '590.423.5567', '1999-02-07', 'IT_PROG', '4200.00', null, '103', '60');
INSERT INTO `employees` VALUES ('108', 'Nancy', 'Greenberg', 'NGREENBE', '515.124.4569', '1994-08-17', 'FI_MGR', '12000.00', null, '101', '100');
INSERT INTO `employees` VALUES ('109', 'Daniel', 'Faviet', 'DFAVIET', '515.124.4169', '1994-08-16', 'FI_ACCOUNT', '9000.00', null, '108', '100');
INSERT INTO `employees` VALUES ('110', 'John', 'Chen', 'JCHEN', '515.124.4269', '1997-09-28', 'FI_ACCOUNT', '8200.00', null, '108', '100');
INSERT INTO `employees` VALUES ('111', 'Ismael', 'Sciarra', 'ISCIARRA', '515.124.4369', '1997-09-30', 'FI_ACCOUNT', '7700.00', null, '108', '100');
INSERT INTO `employees` VALUES ('112', 'Jose Manuel', 'Urman', 'JMURMAN', '515.124.4469', '1998-03-07', 'FI_ACCOUNT', '7800.00', null, '108', '100');
INSERT INTO `employees` VALUES ('113', 'Luis', 'Popp', 'LPOPP', '515.124.4567', '1999-12-07', 'FI_ACCOUNT', '6900.00', null, '108', '100');
INSERT INTO `employees` VALUES ('114', 'Den', 'Raphaely', 'DRAPHEAL', '515.127.4561', '1994-12-07', 'PU_MAN', '11000.00', null, '100', '30');
INSERT INTO `employees` VALUES ('115', 'Alexander', 'Khoo', 'AKHOO', '515.127.4562', '1995-05-18', 'PU_CLERK', '3100.00', null, '114', '30');
INSERT INTO `employees` VALUES ('116', 'Shelli', 'Baida', 'SBAIDA', '515.127.4563', '1997-12-24', 'PU_CLERK', '2900.00', null, '114', '30');
INSERT INTO `employees` VALUES ('117', 'Sigal', 'Tobias', 'STOBIAS', '515.127.4564', '1997-07-24', 'PU_CLERK', '2800.00', null, '114', '30');
INSERT INTO `employees` VALUES ('118', 'Guy', 'Himuro', 'GHIMURO', '515.127.4565', '1998-11-15', 'PU_CLERK', '2600.00', null, '114', '30');
INSERT INTO `employees` VALUES ('119', 'Karen', 'Colmenares', 'KCOLMENA', '515.127.4566', '1999-08-10', 'PU_CLERK', '2500.00', null, '114', '30');
INSERT INTO `employees` VALUES ('120', 'Matthew', 'Weiss', 'MWEISS', '650.123.1234', '1996-07-18', 'ST_MAN', '8000.00', null, '100', '50');
INSERT INTO `employees` VALUES ('121', 'Adam', 'Fripp', 'AFRIPP', '650.123.2234', '1997-04-10', 'ST_MAN', '8200.00', null, '100', '50');
INSERT INTO `employees` VALUES ('122', 'Payam', 'Kaufling', 'PKAUFLIN', '650.123.3234', '1995-05-01', 'ST_MAN', '7900.00', null, '100', '50');
INSERT INTO `employees` VALUES ('123', 'Shanta', 'Vollman', 'SVOLLMAN', '650.123.4234', '1997-10-10', 'ST_MAN', '6500.00', null, '100', '50');
INSERT INTO `employees` VALUES ('124', 'Kevin', 'Mourgos', 'KMOURGOS', '650.123.5234', '1999-11-16', 'ST_MAN', '5800.00', null, '100', '50');
INSERT INTO `employees` VALUES ('125', 'Julia', 'Nayer', 'JNAYER', '650.124.1214', '1997-07-16', 'ST_CLERK', '3200.00', null, '120', '50');
INSERT INTO `employees` VALUES ('126', 'Irene', 'Mikkilineni', 'IMIKKILI', '650.124.1224', '1998-09-28', 'ST_CLERK', '2700.00', null, '120', '50');
INSERT INTO `employees` VALUES ('127', 'James', 'Landry', 'JLANDRY', '650.124.1334', '1999-01-14', 'ST_CLERK', '2400.00', null, '120', '50');
INSERT INTO `employees` VALUES ('128', 'Steven', 'Markle', 'SMARKLE', '650.124.1434', '2000-03-08', 'ST_CLERK', '2200.00', null, '120', '50');
INSERT INTO `employees` VALUES ('129', 'Laura', 'Bissot', 'LBISSOT', '650.124.5234', '1997-08-20', 'ST_CLERK', '3300.00', null, '121', '50');
INSERT INTO `employees` VALUES ('130', 'Mozhe', 'Atkinson', 'MATKINSO', '650.124.6234', '1997-10-30', 'ST_CLERK', '2800.00', null, '121', '50');
INSERT INTO `employees` VALUES ('131', 'James', 'Marlow', 'JAMRLOW', '650.124.7234', '1997-02-16', 'ST_CLERK', '2500.00', null, '121', '50');
INSERT INTO `employees` VALUES ('132', 'TJ', 'Olson', 'TJOLSON', '650.124.8234', '1999-04-10', 'ST_CLERK', '2100.00', null, '121', '50');
INSERT INTO `employees` VALUES ('133', 'Jason', 'Mallin', 'JMALLIN', '650.127.1934', '1996-06-14', 'ST_CLERK', '3300.00', null, '122', '50');
INSERT INTO `employees` VALUES ('134', 'Michael', 'Rogers', 'MROGERS', '650.127.1834', '1998-08-26', 'ST_CLERK', '2900.00', null, '122', '50');
INSERT INTO `employees` VALUES ('135', 'Ki', 'Gee', 'KGEE', '650.127.1734', '1999-12-12', 'ST_CLERK', '2400.00', null, '122', '50');
INSERT INTO `employees` VALUES ('136', 'Hazel', 'Philtanker', 'HPHILTAN', '650.127.1634', '2000-02-06', 'ST_CLERK', '2200.00', null, '122', '50');
INSERT INTO `employees` VALUES ('137', 'Renske', 'Ladwig', 'RLADWIG', '650.121.1234', '1995-07-14', 'ST_CLERK', '3600.00', null, '123', '50');
INSERT INTO `employees` VALUES ('138', 'Stephen', 'Stiles', 'SSTILES', '650.121.2034', '1997-10-26', 'ST_CLERK', '3200.00', null, '123', '50');
INSERT INTO `employees` VALUES ('139', 'John', 'Seo', 'JSEO', '650.121.2019', '1998-02-12', 'ST_CLERK', '2700.00', null, '123', '50');
INSERT INTO `employees` VALUES ('140', 'Joshua', 'Patel', 'JPATEL', '650.121.1834', '1998-04-06', 'ST_CLERK', '2500.00', null, '123', '50');
INSERT INTO `employees` VALUES ('141', 'Trenna', 'Rajs', 'TRAJS', '650.121.8009', '1995-10-17', 'ST_CLERK', '3500.00', null, '124', '50');
INSERT INTO `employees` VALUES ('142', 'Curtis', 'Davies', 'CDAVIES', '650.121.2994', '1997-01-29', 'ST_CLERK', '3100.00', null, '124', '50');
INSERT INTO `employees` VALUES ('143', 'Randall', 'Matos', 'RMATOS', '650.121.2874', '1998-03-15', 'ST_CLERK', '2600.00', null, '124', '50');
INSERT INTO `employees` VALUES ('144', 'Peter', 'Vargas', 'PVARGAS', '650.121.2004', '1998-07-09', 'ST_CLERK', '2500.00', null, '124', '50');
INSERT INTO `employees` VALUES ('145', 'John', 'Russell', 'JRUSSEL', '011.44.1344.429268', '1996-10-01', 'SA_MAN', '14000.00', '0.40', '100', '80');
INSERT INTO `employees` VALUES ('146', 'Karen', 'Partners', 'KPARTNER', '011.44.1344.467268', '1997-01-05', 'SA_MAN', '13500.00', '0.30', '100', '80');
INSERT INTO `employees` VALUES ('147', 'Alberto', 'Errazuriz', 'AERRAZUR', '011.44.1344.429278', '1997-03-10', 'SA_MAN', '12000.00', '0.30', '100', '80');
INSERT INTO `employees` VALUES ('148', 'Gerald', 'Cambrault', 'GCAMBRAU', '011.44.1344.619268', '1999-10-15', 'SA_MAN', '11000.00', '0.30', '100', '80');
INSERT INTO `employees` VALUES ('149', 'Eleni', 'Zlotkey', 'EZLOTKEY', '011.44.1344.429018', '2000-01-29', 'SA_MAN', '10500.00', '0.20', '100', '80');
INSERT INTO `employees` VALUES ('150', 'Peter', 'Tucker', 'PTUCKER', '011.44.1344.129268', '1997-01-30', 'SA_REP', '10000.00', '0.30', '145', '80');
INSERT INTO `employees` VALUES ('151', 'David', 'Bernstein', 'DBERNSTE', '011.44.1344.345268', '1997-03-24', 'SA_REP', '9500.00', '0.25', '145', '80');
INSERT INTO `employees` VALUES ('152', 'Peter', 'Hall', 'PHALL', '011.44.1344.478968', '1997-08-20', 'SA_REP', '9000.00', '0.25', '145', '80');
INSERT INTO `employees` VALUES ('153', 'Christopher', 'Olsen', 'COLSEN', '011.44.1344.498718', '1998-03-30', 'SA_REP', '8000.00', '0.20', '145', '80');
INSERT INTO `employees` VALUES ('154', 'Nanette', 'Cambrault', 'NCAMBRAU', '011.44.1344.987668', '1998-12-09', 'SA_REP', '7500.00', '0.20', '145', '80');
INSERT INTO `employees` VALUES ('155', 'Oliver', 'Tuvault', 'OTUVAULT', '011.44.1344.486508', '1999-11-23', 'SA_REP', '7000.00', '0.15', '145', '80');
INSERT INTO `employees` VALUES ('156', 'Janette', 'King', 'JKING', '011.44.1345.429268', '1996-01-30', 'SA_REP', '10000.00', '0.35', '146', '80');
INSERT INTO `employees` VALUES ('157', 'Patrick', 'Sully', 'PSULLY', '011.44.1345.929268', '1996-03-04', 'SA_REP', '9500.00', '0.35', '146', '80');
INSERT INTO `employees` VALUES ('158', 'Allan', 'McEwen', 'AMCEWEN', '011.44.1345.829268', '1996-08-01', 'SA_REP', '9000.00', '0.35', '146', '80');
INSERT INTO `employees` VALUES ('159', 'Lindsey', 'Smith', 'LSMITH', '011.44.1345.729268', '1997-03-10', 'SA_REP', '8000.00', '0.30', '146', '80');
INSERT INTO `employees` VALUES ('160', 'Louise', 'Doran', 'LDORAN', '011.44.1345.629268', '1997-12-15', 'SA_REP', '7500.00', '0.30', '146', '80');
INSERT INTO `employees` VALUES ('161', 'Sarath', 'Sewall', 'SSEWALL', '011.44.1345.529268', '1998-11-03', 'SA_REP', '7000.00', '0.25', '146', '80');
INSERT INTO `employees` VALUES ('162', 'Clara', 'Vishney', 'CVISHNEY', '011.44.1346.129268', '1997-11-11', 'SA_REP', '10500.00', '0.25', '147', '80');
INSERT INTO `employees` VALUES ('163', 'Danielle', 'Greene', 'DGREENE', '011.44.1346.229268', '1999-03-19', 'SA_REP', '9500.00', '0.15', '147', '80');
INSERT INTO `employees` VALUES ('164', 'Mattea', 'Marvins', 'MMARVINS', '011.44.1346.329268', '2000-01-24', 'SA_REP', '7200.00', '0.10', '147', '80');
INSERT INTO `employees` VALUES ('165', 'David', 'Lee', 'DLEE', '011.44.1346.529268', '2000-02-23', 'SA_REP', '6800.00', '0.10', '147', '80');
INSERT INTO `employees` VALUES ('166', 'Sundar', 'Ande', 'SANDE', '011.44.1346.629268', '2000-03-24', 'SA_REP', '6400.00', '0.10', '147', '80');
INSERT INTO `employees` VALUES ('167', 'Amit', 'Banda', 'ABANDA', '011.44.1346.729268', '2000-04-21', 'SA_REP', '6200.00', '0.10', '147', '80');
INSERT INTO `employees` VALUES ('168', 'Lisa', 'Ozer', 'LOZER', '011.44.1343.929268', '1997-03-11', 'SA_REP', '11500.00', '0.25', '148', '80');
INSERT INTO `employees` VALUES ('169', 'Harrison', 'Bloom', 'HBLOOM', '011.44.1343.829268', '1998-03-23', 'SA_REP', '10000.00', '0.20', '148', '80');
INSERT INTO `employees` VALUES ('170', 'Tayler', 'Fox', 'TFOX', '011.44.1343.729268', '1998-01-24', 'SA_REP', '9600.00', '0.20', '148', '80');
INSERT INTO `employees` VALUES ('171', 'William', 'Smith', 'WSMITH', '011.44.1343.629268', '1999-02-23', 'SA_REP', '7400.00', '0.15', '148', '80');
INSERT INTO `employees` VALUES ('172', 'Elizabeth', 'Bates', 'EBATES', '011.44.1343.529268', '1999-03-24', 'SA_REP', '7300.00', '0.15', '148', '80');
INSERT INTO `employees` VALUES ('173', 'Sundita', 'Kumar', 'SKUMAR', '011.44.1343.329268', '2000-04-21', 'SA_REP', '6100.00', '0.10', '148', '80');
INSERT INTO `employees` VALUES ('174', 'Ellen', 'Abel', 'EABEL', '011.44.1644.429267', '1996-05-11', 'SA_REP', '11000.00', '0.30', '149', '80');
INSERT INTO `employees` VALUES ('175', 'Alyssa', 'Hutton', 'AHUTTON', '011.44.1644.429266', '1997-03-19', 'SA_REP', '8800.00', '0.25', '149', '80');
INSERT INTO `employees` VALUES ('176', 'Jonathon', 'Taylor', 'JTAYLOR', '011.44.1644.429265', '1998-03-24', 'SA_REP', '8600.00', '0.20', '149', '80');
INSERT INTO `employees` VALUES ('177', 'Jack', 'Livingston', 'JLIVINGS', '011.44.1644.429264', '1998-04-23', 'SA_REP', '8400.00', '0.20', '149', '80');
INSERT INTO `employees` VALUES ('178', 'Kimberely', 'Grant', 'KGRANT', '011.44.1644.429263', '1999-05-24', 'SA_REP', '7000.00', '0.15', '149', null);
INSERT INTO `employees` VALUES ('179', 'Charles', 'Johnson', 'CJOHNSON', '011.44.1644.429262', '2000-01-04', 'SA_REP', '6200.00', '0.10', '149', '80');
INSERT INTO `employees` VALUES ('180', 'Winston', 'Taylor', 'WTAYLOR', '650.507.9876', '1998-01-24', 'SH_CLERK', '3200.00', null, '120', '50');
INSERT INTO `employees` VALUES ('181', 'Jean', 'Fleaur', 'JFLEAUR', '650.507.9877', '1998-02-23', 'SH_CLERK', '3100.00', null, '120', '50');
INSERT INTO `employees` VALUES ('182', 'Martha', 'Sullivan', 'MSULLIVA', '650.507.9878', '1999-06-21', 'SH_CLERK', '2500.00', null, '120', '50');
INSERT INTO `employees` VALUES ('183', 'Girard', 'Geoni', 'GGEONI', '650.507.9879', '2000-02-03', 'SH_CLERK', '2800.00', null, '120', '50');
INSERT INTO `employees` VALUES ('184', 'Nandita', 'Sarchand', 'NSARCHAN', '650.509.1876', '1996-01-27', 'SH_CLERK', '4200.00', null, '121', '50');
INSERT INTO `employees` VALUES ('185', 'Alexis', 'Bull', 'ABULL', '650.509.2876', '1997-02-20', 'SH_CLERK', '4100.00', null, '121', '50');
INSERT INTO `employees` VALUES ('186', 'Julia', 'Dellinger', 'JDELLING', '650.509.3876', '1998-06-24', 'SH_CLERK', '3400.00', null, '121', '50');
INSERT INTO `employees` VALUES ('187', 'Anthony', 'Cabrio', 'ACABRIO', '650.509.4876', '1999-02-07', 'SH_CLERK', '3000.00', null, '121', '50');
INSERT INTO `employees` VALUES ('188', 'Kelly', 'Chung', 'KCHUNG', '650.505.1876', '1997-06-14', 'SH_CLERK', '3800.00', null, '122', '50');
INSERT INTO `employees` VALUES ('189', 'Jennifer', 'Dilly', 'JDILLY', '650.505.2876', '1997-08-13', 'SH_CLERK', '3600.00', null, '122', '50');
INSERT INTO `employees` VALUES ('190', 'Timothy', 'Gates', 'TGATES', '650.505.3876', '1998-07-11', 'SH_CLERK', '2900.00', null, '122', '50');
INSERT INTO `employees` VALUES ('191', 'Randall', 'Perkins', 'RPERKINS', '650.505.4876', '1999-12-19', 'SH_CLERK', '2500.00', null, '122', '50');
INSERT INTO `employees` VALUES ('192', 'Sarah', 'Bell', 'SBELL', '650.501.1876', '1996-02-04', 'SH_CLERK', '4000.00', null, '123', '50');
INSERT INTO `employees` VALUES ('193', 'Britney', 'Everett', 'BEVERETT', '650.501.2876', '1997-03-03', 'SH_CLERK', '3900.00', null, '123', '50');
INSERT INTO `employees` VALUES ('194', 'Samuel', 'McCain', 'SMCCAIN', '650.501.3876', '1998-07-01', 'SH_CLERK', '3200.00', null, '123', '50');
INSERT INTO `employees` VALUES ('195', 'Vance', 'Jones', 'VJONES', '650.501.4876', '1999-03-17', 'SH_CLERK', '2800.00', null, '123', '50');
INSERT INTO `employees` VALUES ('196', 'Alana', 'Walsh', 'AWALSH', '650.507.9811', '1998-04-24', 'SH_CLERK', '3100.00', null, '124', '50');
INSERT INTO `employees` VALUES ('197', 'Kevin', 'Feeney', 'KFEENEY', '650.507.9822', '1998-05-23', 'SH_CLERK', '3000.00', null, '124', '50');
INSERT INTO `employees` VALUES ('198', 'Donald', 'OConnell', 'DOCONNEL', '650.507.9833', '1999-06-21', 'SH_CLERK', '2600.00', null, '124', '50');
INSERT INTO `employees` VALUES ('199', 'Douglas', 'Grant', 'DGRANT', '650.507.9844', '2000-01-13', 'SH_CLERK', '2600.00', null, '124', '50');
INSERT INTO `employees` VALUES ('200', 'Jennifer', 'Whalen', 'JWHALEN', '515.123.4444', '1987-09-17', 'AD_ASST', '4400.00', null, '101', '10');
INSERT INTO `employees` VALUES ('201', 'Michael', 'Hartstein', 'MHARTSTE', '515.123.5555', '1996-02-17', 'MK_MAN', '13000.00', null, '100', '20');
INSERT INTO `employees` VALUES ('202', 'Pat', 'Fay', 'PFAY', '603.123.6666', '1997-08-17', 'MK_REP', '6000.00', null, '201', '20');
INSERT INTO `employees` VALUES ('203', 'Susan', 'Mavris', 'SMAVRIS', '515.123.7777', '1994-06-07', 'HR_REP', '6500.00', null, '101', '40');
INSERT INTO `employees` VALUES ('204', 'Hermann', 'Baer', 'HBAER', '515.123.8888', '1994-06-07', 'PR_REP', '10000.00', null, '101', '70');
INSERT INTO `employees` VALUES ('205', 'Shelley', 'Higgins', 'SHIGGINS', '515.123.8080', '1994-06-07', 'AC_MGR', '12000.00', null, '101', '110');
INSERT INTO `employees` VALUES ('206', 'William', 'Gietz', 'WGIETZ', '515.123.8181', '1994-06-07', 'AC_ACCOUNT', '8300.00', null, '205', '110');

-- ----------------------------
-- Table structure for expaccount
-- ----------------------------
DROP TABLE IF EXISTS `expaccount`;
CREATE TABLE `expaccount` (
  `id` bigint(20) NOT NULL,
  `version` int(11) NOT NULL,
  `usableAmount` decimal(18,4) NOT NULL,
  `freezedAmount` decimal(18,4) NOT NULL,
  `unReturnExpAmount` decimal(18,4) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of expaccount
-- ----------------------------
INSERT INTO `expaccount` VALUES ('4', '4', '2000.0000', '3000.0000', '0.0000');

-- ----------------------------
-- Table structure for expaccountflow
-- ----------------------------
DROP TABLE IF EXISTS `expaccountflow`;
CREATE TABLE `expaccountflow` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `actionType` tinyint(4) NOT NULL,
  `amount` decimal(18,4) NOT NULL,
  `note` varchar(255) NOT NULL,
  `usableAmount` decimal(18,4) NOT NULL,
  `freezedAmount` decimal(18,4) NOT NULL,
  `actionTime` datetime NOT NULL,
  `expAccountId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of expaccountflow
-- ----------------------------
INSERT INTO `expaccountflow` VALUES ('1', '1', '122.0000', '体验金金额减少:122,冻结金额增加122', '4878.0000', '122.0000', '2017-09-26 16:06:44', '4');

-- ----------------------------
-- Table structure for expaccountgrantrecord
-- ----------------------------
DROP TABLE IF EXISTS `expaccountgrantrecord`;
CREATE TABLE `expaccountgrantrecord` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `grantUserId` bigint(20) DEFAULT NULL,
  `amount` decimal(18,4) DEFAULT NULL,
  `grantDate` datetime DEFAULT NULL,
  `returnDate` datetime DEFAULT NULL,
  `grantType` tinyint(4) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `state` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of expaccountgrantrecord
-- ----------------------------

-- ----------------------------
-- Table structure for figure
-- ----------------------------
DROP TABLE IF EXISTS `figure`;
CREATE TABLE `figure` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `sex` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of figure
-- ----------------------------
INSERT INTO `figure` VALUES ('1', 'zx', 'm');
INSERT INTO `figure` VALUES ('2', 'ko', 'f');

-- ----------------------------
-- Table structure for iplog
-- ----------------------------
DROP TABLE IF EXISTS `iplog`;
CREATE TABLE `iplog` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `ip` varchar(20) NOT NULL,
  `state` tinyint(4) NOT NULL,
  `username` varchar(20) DEFAULT NULL,
  `logintime` datetime NOT NULL,
  `userType` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=191 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of iplog
-- ----------------------------
INSERT INTO `iplog` VALUES ('16', '0:0:0:0:0:0:0:1', '1', 'flow', '2017-09-15 18:35:12', '管理员');
INSERT INTO `iplog` VALUES ('17', '0:0:0:0:0:0:0:1', '1', 'wall', '2017-09-15 19:04:45', '普通用户');
INSERT INTO `iplog` VALUES ('18', '0:0:0:0:0:0:0:1', '1', 'wall', '2017-09-15 19:05:42', '普通用户');
INSERT INTO `iplog` VALUES ('19', '0:0:0:0:0:0:0:1', '1', 'flow', '2017-09-15 19:06:36', '管理员');
INSERT INTO `iplog` VALUES ('20', '0:0:0:0:0:0:0:1', '1', 'flow', '2017-09-15 19:18:48', '管理员');
INSERT INTO `iplog` VALUES ('21', '0:0:0:0:0:0:0:1', '1', 'flow', '2017-09-15 19:22:52', '管理员');
INSERT INTO `iplog` VALUES ('22', '0:0:0:0:0:0:0:1', '1', 'flow', '2017-09-15 19:25:32', '管理员');
INSERT INTO `iplog` VALUES ('23', '0:0:0:0:0:0:0:1', '1', 'flow', '2017-09-15 19:33:13', '管理员');
INSERT INTO `iplog` VALUES ('24', '0:0:0:0:0:0:0:1', '1', 'wall', '2017-09-15 19:52:50', '普通用户');
INSERT INTO `iplog` VALUES ('25', '0:0:0:0:0:0:0:1', '1', 'wall', '2017-09-15 21:37:29', '普通用户');
INSERT INTO `iplog` VALUES ('26', '0:0:0:0:0:0:0:1', '1', 'wall', '2017-09-15 21:37:34', '普通用户');
INSERT INTO `iplog` VALUES ('27', '0:0:0:0:0:0:0:1', '1', 'wall', '2017-09-15 23:12:54', '普通用户');
INSERT INTO `iplog` VALUES ('28', '0:0:0:0:0:0:0:1', '1', 'flow', '2017-09-16 13:14:11', '管理员');
INSERT INTO `iplog` VALUES ('29', '0:0:0:0:0:0:0:1', '1', 'flow', '2017-09-16 13:31:22', '管理员');
INSERT INTO `iplog` VALUES ('30', '0:0:0:0:0:0:0:1', '1', 'flow', '2017-09-16 19:07:34', '管理员');
INSERT INTO `iplog` VALUES ('31', '0:0:0:0:0:0:0:1', '1', 'flow', '2017-09-16 20:28:22', '管理员');
INSERT INTO `iplog` VALUES ('32', '0:0:0:0:0:0:0:1', '1', 'flow', '2017-09-16 20:51:52', '管理员');
INSERT INTO `iplog` VALUES ('33', '0:0:0:0:0:0:0:1', '1', 'flow', '2017-09-16 21:07:52', '管理员');
INSERT INTO `iplog` VALUES ('34', '0:0:0:0:0:0:0:1', '1', 'flow', '2017-09-16 21:39:57', '管理员');
INSERT INTO `iplog` VALUES ('35', '0:0:0:0:0:0:0:1', '1', 'wall', '2017-09-16 22:43:28', '普通用户');
INSERT INTO `iplog` VALUES ('36', '0:0:0:0:0:0:0:1', '1', 'wall', '2017-09-17 00:46:52', '普通用户');
INSERT INTO `iplog` VALUES ('37', '0:0:0:0:0:0:0:1', '1', 'wall', '2017-09-17 11:58:38', '普通用户');
INSERT INTO `iplog` VALUES ('38', '0:0:0:0:0:0:0:1', '1', 'wall', '2017-09-17 12:31:59', '普通用户');
INSERT INTO `iplog` VALUES ('39', '0:0:0:0:0:0:0:1', '1', 'wall', '2017-09-17 13:15:38', '普通用户');
INSERT INTO `iplog` VALUES ('40', '0:0:0:0:0:0:0:1', '1', 'wall', '2017-09-17 14:02:50', '普通用户');
INSERT INTO `iplog` VALUES ('41', '0:0:0:0:0:0:0:1', '1', 'flow', '2017-09-18 05:47:05', '管理员');
INSERT INTO `iplog` VALUES ('42', '0:0:0:0:0:0:0:1', '1', 'flow', '2017-09-18 06:22:04', '管理员');
INSERT INTO `iplog` VALUES ('43', '0:0:0:0:0:0:0:1', '1', 'flow', '2017-09-18 06:27:38', '管理员');
INSERT INTO `iplog` VALUES ('44', '0:0:0:0:0:0:0:1', '1', 'flow', '2017-09-18 06:32:21', '管理员');
INSERT INTO `iplog` VALUES ('45', '0:0:0:0:0:0:0:1', '1', 'flow', '2017-09-18 06:40:45', '管理员');
INSERT INTO `iplog` VALUES ('46', '0:0:0:0:0:0:0:1', '1', 'flow', '2017-09-18 07:01:59', '管理员');
INSERT INTO `iplog` VALUES ('47', '0:0:0:0:0:0:0:1', '1', 'flow', '2017-09-18 07:05:01', '管理员');
INSERT INTO `iplog` VALUES ('48', '0:0:0:0:0:0:0:1', '1', 'flow', '2017-09-18 07:32:59', '管理员');
INSERT INTO `iplog` VALUES ('49', '0:0:0:0:0:0:0:1', '1', 'flow', '2017-09-18 18:36:38', '管理员');
INSERT INTO `iplog` VALUES ('50', '0:0:0:0:0:0:0:1', '1', 'flow', '2017-09-18 18:42:25', '管理员');
INSERT INTO `iplog` VALUES ('51', '0:0:0:0:0:0:0:1', '1', 'wall', '2017-09-18 18:44:54', '普通用户');
INSERT INTO `iplog` VALUES ('52', '127.0.0.1', '1', 'wall', '2017-09-18 19:23:30', '普通用户');
INSERT INTO `iplog` VALUES ('53', '0:0:0:0:0:0:0:1', '1', 'flow', '2017-09-18 19:26:28', '管理员');
INSERT INTO `iplog` VALUES ('54', '0:0:0:0:0:0:0:1', '1', 'flow', '2017-09-18 19:26:28', '管理员');
INSERT INTO `iplog` VALUES ('55', '0:0:0:0:0:0:0:1', '1', 'flow', '2017-09-18 20:13:23', '管理员');
INSERT INTO `iplog` VALUES ('56', '127.0.0.1', '1', 'wall', '2017-09-18 20:39:55', '普通用户');
INSERT INTO `iplog` VALUES ('57', '127.0.0.1', '1', 'wall', '2017-09-18 21:03:44', '普通用户');
INSERT INTO `iplog` VALUES ('58', '0:0:0:0:0:0:0:1', '1', 'wall', '2017-09-18 21:09:34', '普通用户');
INSERT INTO `iplog` VALUES ('59', '0:0:0:0:0:0:0:1', '1', 'wall', '2017-09-18 21:14:42', '普通用户');
INSERT INTO `iplog` VALUES ('60', '0:0:0:0:0:0:0:1', '1', 'wall', '2017-09-18 21:15:29', '普通用户');
INSERT INTO `iplog` VALUES ('61', '0:0:0:0:0:0:0:1', '1', 'wall', '2017-09-18 23:30:35', '普通用户');
INSERT INTO `iplog` VALUES ('62', '0:0:0:0:0:0:0:1', '1', 'wall', '2017-09-18 23:31:19', '普通用户');
INSERT INTO `iplog` VALUES ('63', '0:0:0:0:0:0:0:1', '1', 'wall', '2017-09-18 23:31:27', '普通用户');
INSERT INTO `iplog` VALUES ('64', '0:0:0:0:0:0:0:1', '1', 'wall', '2017-09-18 23:33:11', '普通用户');
INSERT INTO `iplog` VALUES ('65', '0:0:0:0:0:0:0:1', '1', 'wall', '2017-09-18 23:34:04', '普通用户');
INSERT INTO `iplog` VALUES ('66', '0:0:0:0:0:0:0:1', '1', 'wall', '2017-09-18 23:34:09', '普通用户');
INSERT INTO `iplog` VALUES ('67', '0:0:0:0:0:0:0:1', '1', 'wall', '2017-09-18 23:35:06', '普通用户');
INSERT INTO `iplog` VALUES ('68', '0:0:0:0:0:0:0:1', '1', 'wall', '2017-09-18 23:35:30', '普通用户');
INSERT INTO `iplog` VALUES ('69', '0:0:0:0:0:0:0:1', '1', 'wall', '2017-09-18 23:35:43', '普通用户');
INSERT INTO `iplog` VALUES ('70', '0:0:0:0:0:0:0:1', '1', 'flow', '2017-09-18 23:39:52', '管理员');
INSERT INTO `iplog` VALUES ('71', '0:0:0:0:0:0:0:1', '1', 'flow', '2017-09-18 23:42:44', '管理员');
INSERT INTO `iplog` VALUES ('72', '0:0:0:0:0:0:0:1', '1', 'wall', '2017-09-19 01:37:52', '普通用户');
INSERT INTO `iplog` VALUES ('73', '0:0:0:0:0:0:0:1', '1', 'wall', '2017-09-19 02:18:39', '普通用户');
INSERT INTO `iplog` VALUES ('74', '0:0:0:0:0:0:0:1', '1', 'wall', '2017-09-19 02:39:00', '普通用户');
INSERT INTO `iplog` VALUES ('75', '0:0:0:0:0:0:0:1', '1', 'wall', '2017-09-19 02:44:45', '普通用户');
INSERT INTO `iplog` VALUES ('76', '0:0:0:0:0:0:0:1', '1', 'flow', '2017-09-19 09:24:02', '管理员');
INSERT INTO `iplog` VALUES ('77', '0:0:0:0:0:0:0:1', '1', 'flow', '2017-09-19 09:27:55', '管理员');
INSERT INTO `iplog` VALUES ('78', '0:0:0:0:0:0:0:1', '1', 'flow', '2017-09-19 09:34:27', '管理员');
INSERT INTO `iplog` VALUES ('79', '0:0:0:0:0:0:0:1', '1', 'flow', '2017-09-19 18:57:30', '管理员');
INSERT INTO `iplog` VALUES ('80', '0:0:0:0:0:0:0:1', '1', 'flow', '2017-09-19 19:34:55', '管理员');
INSERT INTO `iplog` VALUES ('81', '0:0:0:0:0:0:0:1', '1', 'flow', '2017-09-19 19:42:17', '管理员');
INSERT INTO `iplog` VALUES ('82', '0:0:0:0:0:0:0:1', '1', 'flow', '2017-09-19 19:51:14', '管理员');
INSERT INTO `iplog` VALUES ('83', '0:0:0:0:0:0:0:1', '1', 'flow', '2017-09-19 19:52:14', '管理员');
INSERT INTO `iplog` VALUES ('84', '0:0:0:0:0:0:0:1', '1', 'flow', '2017-09-19 20:16:11', '管理员');
INSERT INTO `iplog` VALUES ('85', '127.0.0.1', '1', 'wall', '2017-09-19 21:05:13', '普通用户');
INSERT INTO `iplog` VALUES ('86', '127.0.0.1', '1', 'wall', '2017-09-19 21:15:51', '普通用户');
INSERT INTO `iplog` VALUES ('87', '0:0:0:0:0:0:0:1', '1', 'wall', '2017-09-19 21:25:28', '普通用户');
INSERT INTO `iplog` VALUES ('88', '0:0:0:0:0:0:0:1', '1', 'flow', '2017-09-19 21:29:13', '管理员');
INSERT INTO `iplog` VALUES ('89', '0:0:0:0:0:0:0:1', '1', 'flow', '2017-09-19 22:40:40', '管理员');
INSERT INTO `iplog` VALUES ('90', '0:0:0:0:0:0:0:1', '1', 'flow', '2017-09-19 22:42:31', '管理员');
INSERT INTO `iplog` VALUES ('91', '0:0:0:0:0:0:0:1', '1', 'flow', '2017-09-19 22:45:56', '管理员');
INSERT INTO `iplog` VALUES ('92', '0:0:0:0:0:0:0:1', '1', 'flow', '2017-09-19 23:43:56', '管理员');
INSERT INTO `iplog` VALUES ('93', '0:0:0:0:0:0:0:1', '1', 'wall', '2017-09-19 23:49:12', '普通用户');
INSERT INTO `iplog` VALUES ('94', '0:0:0:0:0:0:0:1', '1', 'wall', '2017-09-20 10:38:19', '普通用户');
INSERT INTO `iplog` VALUES ('95', '0:0:0:0:0:0:0:1', '1', 'wall', '2017-09-20 12:44:54', '普通用户');
INSERT INTO `iplog` VALUES ('96', '0:0:0:0:0:0:0:1', '1', 'flow', '2017-09-20 15:51:22', '管理员');
INSERT INTO `iplog` VALUES ('97', '0:0:0:0:0:0:0:1', '1', 'flow', '2017-09-20 16:20:12', '管理员');
INSERT INTO `iplog` VALUES ('98', '0:0:0:0:0:0:0:1', '1', 'flow', '2017-09-20 17:16:20', '管理员');
INSERT INTO `iplog` VALUES ('99', '0:0:0:0:0:0:0:1', '1', 'flow', '2017-09-20 19:34:45', '管理员');
INSERT INTO `iplog` VALUES ('100', '0:0:0:0:0:0:0:1', '1', 'flow', '2017-09-20 21:21:36', '管理员');
INSERT INTO `iplog` VALUES ('101', '0:0:0:0:0:0:0:1', '1', 'flow', '2017-09-20 21:32:33', '管理员');
INSERT INTO `iplog` VALUES ('102', '0:0:0:0:0:0:0:1', '1', 'wall', '2017-09-20 21:36:00', '普通用户');
INSERT INTO `iplog` VALUES ('103', '0:0:0:0:0:0:0:1', '1', 'flow', '2017-09-20 21:53:25', '管理员');
INSERT INTO `iplog` VALUES ('104', '0:0:0:0:0:0:0:1', '1', 'flow', '2017-09-20 21:56:27', '管理员');
INSERT INTO `iplog` VALUES ('105', '0:0:0:0:0:0:0:1', '1', 'flow', '2017-09-20 22:30:30', '管理员');
INSERT INTO `iplog` VALUES ('106', '0:0:0:0:0:0:0:1', '1', 'flow', '2017-09-21 11:56:55', '管理员');
INSERT INTO `iplog` VALUES ('107', '0:0:0:0:0:0:0:1', '1', 'flow', '2017-09-21 12:39:03', '管理员');
INSERT INTO `iplog` VALUES ('108', '0:0:0:0:0:0:0:1', '1', 'wall', '2017-09-21 12:45:52', '普通用户');
INSERT INTO `iplog` VALUES ('109', '0:0:0:0:0:0:0:1', '1', 'wall', '2017-09-21 13:12:25', '普通用户');
INSERT INTO `iplog` VALUES ('110', '0:0:0:0:0:0:0:1', '1', 'flow', '2017-09-21 18:44:58', '管理员');
INSERT INTO `iplog` VALUES ('111', '0:0:0:0:0:0:0:1', '1', 'flow', '2017-09-21 19:49:06', '管理员');
INSERT INTO `iplog` VALUES ('112', '0:0:0:0:0:0:0:1', '1', 'wall', '2017-09-21 20:29:33', '普通用户');
INSERT INTO `iplog` VALUES ('113', '0:0:0:0:0:0:0:1', '1', 'flow', '2017-09-21 22:39:31', '管理员');
INSERT INTO `iplog` VALUES ('114', '0:0:0:0:0:0:0:1', '1', 'flow', '2017-09-22 01:55:30', '管理员');
INSERT INTO `iplog` VALUES ('115', '127.0.0.1', '1', 'wall', '2017-09-22 01:56:53', '普通用户');
INSERT INTO `iplog` VALUES ('116', '127.0.0.1', '1', 'wall', '2017-09-22 02:05:01', '普通用户');
INSERT INTO `iplog` VALUES ('117', '127.0.0.1', '1', 'wall', '2017-09-22 02:14:13', '普通用户');
INSERT INTO `iplog` VALUES ('118', '127.0.0.1', '1', 'wall', '2017-09-22 02:15:08', '普通用户');
INSERT INTO `iplog` VALUES ('119', '0:0:0:0:0:0:0:1', '1', 'flow', '2017-09-22 02:19:24', '管理员');
INSERT INTO `iplog` VALUES ('120', '0:0:0:0:0:0:0:1', '1', 'flow', '2017-09-22 18:33:09', '管理员');
INSERT INTO `iplog` VALUES ('121', '0:0:0:0:0:0:0:1', '1', 'flow', '2017-09-22 18:49:11', '管理员');
INSERT INTO `iplog` VALUES ('122', '0:0:0:0:0:0:0:1', '1', 'flow', '2017-09-22 19:39:49', '管理员');
INSERT INTO `iplog` VALUES ('123', '127.0.0.1', '1', 'wall', '2017-09-22 19:59:54', '普通用户');
INSERT INTO `iplog` VALUES ('124', '0:0:0:0:0:0:0:1', '1', 'flow', '2017-09-22 20:00:45', '管理员');
INSERT INTO `iplog` VALUES ('125', '127.0.0.1', '1', 'wall', '2017-09-22 20:01:34', '普通用户');
INSERT INTO `iplog` VALUES ('126', '0:0:0:0:0:0:0:1', '1', 'flow', '2017-09-22 20:01:50', '管理员');
INSERT INTO `iplog` VALUES ('127', '0:0:0:0:0:0:0:1', '1', 'wall', '2017-09-22 20:02:04', '普通用户');
INSERT INTO `iplog` VALUES ('128', '0:0:0:0:0:0:0:1', '0', 'UnknownZ', '2017-09-22 20:13:30', '普通用户');
INSERT INTO `iplog` VALUES ('129', '0:0:0:0:0:0:0:1', '0', 'UnknownZ', '2017-09-22 20:13:35', '普通用户');
INSERT INTO `iplog` VALUES ('130', '0:0:0:0:0:0:0:1', '0', 'UnknownZ', '2017-09-22 20:13:44', '普通用户');
INSERT INTO `iplog` VALUES ('131', '0:0:0:0:0:0:0:1', '0', 'UnknownZ', '2017-09-22 20:13:51', '普通用户');
INSERT INTO `iplog` VALUES ('132', '0:0:0:0:0:0:0:1', '0', 'UnknownZ', '2017-09-22 20:14:08', '普通用户');
INSERT INTO `iplog` VALUES ('133', '0:0:0:0:0:0:0:1', '0', 'UnknownZ', '2017-09-22 20:14:17', '普通用户');
INSERT INTO `iplog` VALUES ('134', '0:0:0:0:0:0:0:1', '0', 'UnknownZ', '2017-09-22 20:14:52', '普通用户');
INSERT INTO `iplog` VALUES ('135', '0:0:0:0:0:0:0:1', '0', 'UnknownZ', '2017-09-22 20:15:06', '普通用户');
INSERT INTO `iplog` VALUES ('136', '0:0:0:0:0:0:0:1', '1', 'UnknowZ', '2017-09-22 20:15:21', '普通用户');
INSERT INTO `iplog` VALUES ('137', '0:0:0:0:0:0:0:1', '1', 'wall', '2017-09-22 20:23:09', '普通用户');
INSERT INTO `iplog` VALUES ('138', '0:0:0:0:0:0:0:1', '1', 'UnknowZ', '2017-09-22 20:24:07', '普通用户');
INSERT INTO `iplog` VALUES ('139', '0:0:0:0:0:0:0:1', '1', 'wall', '2017-09-22 20:37:47', '普通用户');
INSERT INTO `iplog` VALUES ('140', '0:0:0:0:0:0:0:1', '1', 'UnknowZ', '2017-09-22 20:39:53', '普通用户');
INSERT INTO `iplog` VALUES ('141', '0:0:0:0:0:0:0:1', '1', 'UnknowZ', '2017-09-22 20:39:54', '普通用户');
INSERT INTO `iplog` VALUES ('142', '0:0:0:0:0:0:0:1', '1', 'wall', '2017-09-22 20:40:13', '普通用户');
INSERT INTO `iplog` VALUES ('143', '0:0:0:0:0:0:0:1', '1', 'wall', '2017-09-22 20:40:24', '普通用户');
INSERT INTO `iplog` VALUES ('144', '0:0:0:0:0:0:0:1', '1', 'wall', '2017-09-22 20:40:30', '普通用户');
INSERT INTO `iplog` VALUES ('145', '0:0:0:0:0:0:0:1', '1', 'UnknowZ', '2017-09-22 20:40:42', '普通用户');
INSERT INTO `iplog` VALUES ('146', '127.0.0.1', '1', 'wall', '2017-09-22 20:41:45', '普通用户');
INSERT INTO `iplog` VALUES ('147', '0:0:0:0:0:0:0:1', '1', 'flow', '2017-09-22 20:43:38', '管理员');
INSERT INTO `iplog` VALUES ('148', '0:0:0:0:0:0:0:1', '1', 'wall', '2017-09-22 20:53:12', '普通用户');
INSERT INTO `iplog` VALUES ('149', '0:0:0:0:0:0:0:1', '1', 'UnknowZ', '2017-09-22 20:53:52', '普通用户');
INSERT INTO `iplog` VALUES ('150', '127.0.0.1', '1', 'UnknowZ', '2017-09-22 20:55:51', '普通用户');
INSERT INTO `iplog` VALUES ('151', '0:0:0:0:0:0:0:1', '1', 'flow', '2017-09-22 21:25:19', '管理员');
INSERT INTO `iplog` VALUES ('152', '127.0.0.1', '1', 'UnknowZ', '2017-09-22 22:26:41', '普通用户');
INSERT INTO `iplog` VALUES ('153', '0:0:0:0:0:0:0:1', '1', 'UnknowZ', '2017-09-22 22:29:29', '普通用户');
INSERT INTO `iplog` VALUES ('154', '0:0:0:0:0:0:0:1', '1', 'wall', '2017-09-23 10:27:51', '普通用户');
INSERT INTO `iplog` VALUES ('155', '0:0:0:0:0:0:0:1', '1', 'UnknowZ', '2017-09-23 10:32:46', '普通用户');
INSERT INTO `iplog` VALUES ('156', '0:0:0:0:0:0:0:1', '1', 'wall', '2017-09-23 10:44:03', '普通用户');
INSERT INTO `iplog` VALUES ('157', '0:0:0:0:0:0:0:1', '1', 'wall', '2017-09-23 11:00:05', '普通用户');
INSERT INTO `iplog` VALUES ('158', '127.0.0.1', '1', 'flow', '2017-09-23 11:25:59', '管理员');
INSERT INTO `iplog` VALUES ('159', '0:0:0:0:0:0:0:1', '1', 'wall', '2017-09-23 21:36:49', '普通用户');
INSERT INTO `iplog` VALUES ('160', '0:0:0:0:0:0:0:1', '1', 'Zhui', '2017-09-23 21:38:19', '普通用户');
INSERT INTO `iplog` VALUES ('161', '0:0:0:0:0:0:0:1', '1', 'flow', '2017-09-23 21:39:56', '管理员');
INSERT INTO `iplog` VALUES ('162', '0:0:0:0:0:0:0:1', '1', 'UnknowZ', '2017-09-23 21:52:08', '普通用户');
INSERT INTO `iplog` VALUES ('163', '0:0:0:0:0:0:0:1', '1', 'UnknowZ', '2017-09-23 21:53:36', '普通用户');
INSERT INTO `iplog` VALUES ('164', '0:0:0:0:0:0:0:1', '1', 'Zhui', '2017-09-23 21:57:38', '普通用户');
INSERT INTO `iplog` VALUES ('165', '0:0:0:0:0:0:0:1', '1', 'wall', '2017-09-23 21:58:40', '普通用户');
INSERT INTO `iplog` VALUES ('166', '0:0:0:0:0:0:0:1', '1', 'UnknowZ', '2017-09-23 21:58:57', '普通用户');
INSERT INTO `iplog` VALUES ('167', '0:0:0:0:0:0:0:1', '1', 'flow', '2017-09-24 20:38:44', '管理员');
INSERT INTO `iplog` VALUES ('168', '0:0:0:0:0:0:0:1', '1', 'wall', '2017-09-24 20:41:21', '普通用户');
INSERT INTO `iplog` VALUES ('169', '0:0:0:0:0:0:0:1', '1', 'wall', '2017-09-24 21:30:30', '普通用户');
INSERT INTO `iplog` VALUES ('170', '0:0:0:0:0:0:0:1', '1', 'wall', '2017-09-24 21:32:51', '普通用户');
INSERT INTO `iplog` VALUES ('171', '0:0:0:0:0:0:0:1', '1', 'wall', '2017-09-24 21:38:29', '普通用户');
INSERT INTO `iplog` VALUES ('172', '0:0:0:0:0:0:0:1', '1', 'wall', '2017-09-24 21:46:50', '普通用户');
INSERT INTO `iplog` VALUES ('173', '127.0.0.1', '1', 'flow', '2017-09-24 21:50:46', '管理员');
INSERT INTO `iplog` VALUES ('174', '0:0:0:0:0:0:0:1', '1', 'flow', '2017-09-25 13:01:55', '管理员');
INSERT INTO `iplog` VALUES ('175', '0:0:0:0:0:0:0:1', '1', 'flow', '2017-09-25 14:08:29', '管理员');
INSERT INTO `iplog` VALUES ('176', '127.0.0.1', '1', 'wall', '2017-09-25 20:35:28', '普通用户');
INSERT INTO `iplog` VALUES ('177', '0:0:0:0:0:0:0:1', '1', 'flow', '2017-09-26 11:24:05', '管理员');
INSERT INTO `iplog` VALUES ('178', '127.0.0.1', '1', 'wall', '2017-09-26 11:25:33', '普通用户');
INSERT INTO `iplog` VALUES ('179', '0:0:0:0:0:0:0:1', '1', 'wall', '2017-09-26 15:20:57', '普通用户');
INSERT INTO `iplog` VALUES ('180', '0:0:0:0:0:0:0:1', '1', 'wall', '2017-09-26 17:10:44', '普通用户');
INSERT INTO `iplog` VALUES ('181', '0:0:0:0:0:0:0:1', '1', 'flow', '2017-09-26 17:21:03', '管理员');
INSERT INTO `iplog` VALUES ('182', '0:0:0:0:0:0:0:1', '1', 'flow', '2017-10-07 22:35:58', '管理员');
INSERT INTO `iplog` VALUES ('183', '0:0:0:0:0:0:0:1', '1', 'flow', '2017-10-20 14:16:59', '管理员');
INSERT INTO `iplog` VALUES ('184', '0:0:0:0:0:0:0:1', '1', 'flow', '2017-10-20 15:07:24', '管理员');
INSERT INTO `iplog` VALUES ('185', '0:0:0:0:0:0:0:1', '1', 'flow', '2017-10-30 20:19:56', '管理员');
INSERT INTO `iplog` VALUES ('186', '127.0.0.1', '1', 'wall', '2017-10-30 20:24:24', '普通用户');
INSERT INTO `iplog` VALUES ('187', '0:0:0:0:0:0:0:1', '1', 'wall', '2017-10-30 21:05:34', '普通用户');
INSERT INTO `iplog` VALUES ('188', '0:0:0:0:0:0:0:1', '1', 'wall', '2017-10-30 21:39:24', '普通用户');
INSERT INTO `iplog` VALUES ('189', '0:0:0:0:0:0:0:1', '1', 'wall', '2017-10-30 21:41:17', '普通用户');
INSERT INTO `iplog` VALUES ('190', '0:0:0:0:0:0:0:1', '1', 'wall', '2017-10-30 21:44:03', '普通用户');

-- ----------------------------
-- Table structure for logininfo
-- ----------------------------
DROP TABLE IF EXISTS `logininfo`;
CREATE TABLE `logininfo` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `state` tinyint(4) DEFAULT NULL,
  `userType` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of logininfo
-- ----------------------------
INSERT INTO `logininfo` VALUES ('4', 'wall', 'xx', '1', '0');
INSERT INTO `logininfo` VALUES ('5', 'flow', 'zz', '1', '0');
INSERT INTO `logininfo` VALUES ('9', 'loss', '0000', '0', '0');
INSERT INTO `logininfo` VALUES ('10', 'flow', 'zz', '1', '1');
INSERT INTO `logininfo` VALUES ('12', 'UnknowZ', 'xx', '0', '0');
INSERT INTO `logininfo` VALUES ('13', 'Zhui', 'xx', '0', '0');

-- ----------------------------
-- Table structure for mailverify
-- ----------------------------
DROP TABLE IF EXISTS `mailverify`;
CREATE TABLE `mailverify` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `userinfo_id` bigint(20) NOT NULL,
  `deadline` datetime NOT NULL,
  `randomcode` varchar(255) NOT NULL,
  `email` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mailverify
-- ----------------------------
INSERT INTO `mailverify` VALUES ('4', '4', '2017-09-15 23:41:55', 'adf42135-20eb-4be6-8208-b6b475aa50dd', '1992');
INSERT INTO `mailverify` VALUES ('5', '4', '2017-09-15 23:44:25', '7a9b932e-8b58-4793-a5a9-0e713d3c2d67', '1992');
INSERT INTO `mailverify` VALUES ('6', '4', '2017-09-15 23:49:22', '3bdb6f14-b6d2-4816-ada3-14515f351f54', '1992');
INSERT INTO `mailverify` VALUES ('7', '4', '2017-09-15 23:59:01', '787cbd99-59c2-4dec-a8bb-acc5416d129e', '1992');

-- ----------------------------
-- Table structure for platformbankinfo
-- ----------------------------
DROP TABLE IF EXISTS `platformbankinfo`;
CREATE TABLE `platformbankinfo` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `bankname` varchar(255) DEFAULT NULL,
  `accountname` varchar(255) DEFAULT NULL,
  `banknumber` varchar(255) DEFAULT NULL,
  `bankforkname` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of platformbankinfo
-- ----------------------------
INSERT INTO `platformbankinfo` VALUES ('2', '1', 'wall', '62220273020', '天河');
INSERT INTO `platformbankinfo` VALUES ('3', '2', 'wall', '6222020', '番禺');

-- ----------------------------
-- Table structure for realauth
-- ----------------------------
DROP TABLE IF EXISTS `realauth`;
CREATE TABLE `realauth` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `realname` varchar(50) NOT NULL,
  `sex` tinyint(4) NOT NULL,
  `birthDate` varchar(50) DEFAULT NULL,
  `idNumber` varchar(50) NOT NULL,
  `address` varchar(255) NOT NULL,
  `state` tinyint(4) NOT NULL,
  `image1` varchar(255) NOT NULL,
  `image2` varchar(255) NOT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `auditTime` datetime DEFAULT NULL,
  `applyTime` datetime NOT NULL,
  `auditor_id` bigint(20) DEFAULT NULL,
  `applier_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of realauth
-- ----------------------------
INSERT INTO `realauth` VALUES ('3', '左秋明', '0', '1992', '4……', '韶关', '2', '', '', '', null, '2017-09-17 14:21:13', '10', '4');
INSERT INTO `realauth` VALUES ('4', '左秋明', '0', '1992', '4*', '韶关', '2', '', '', '', null, '2017-09-18 19:24:09', '10', '4');
INSERT INTO `realauth` VALUES ('5', '', '0', null, '', '', '2', '2672d8d8-01a9-4ee6-86f4-4aa9fa5127af.jpg', '', '', null, '2017-09-18 23:35:54', '10', '4');
INSERT INTO `realauth` VALUES ('6', '左秋明', '0', '1992', '4*', '地球', '1', 'daa96c40-e517-4fdb-8a15-a8a042ed8cb2.jpg', 'dfbb99a8-e0cc-4bd0-a5c3-307c5ab1876f.jpg', 'goodjob!', null, '2017-09-18 23:43:35', '10', '4');

-- ----------------------------
-- Table structure for rechargeoffline
-- ----------------------------
DROP TABLE IF EXISTS `rechargeoffline`;
CREATE TABLE `rechargeoffline` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `state` tinyint(4) NOT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `auditTime` datetime DEFAULT NULL,
  `applyTime` datetime NOT NULL,
  `auditor_id` bigint(20) DEFAULT NULL,
  `applier_id` bigint(20) NOT NULL,
  `tradeCode` varchar(255) NOT NULL,
  `tradeTime` datetime NOT NULL,
  `amount` decimal(18,4) NOT NULL,
  `note` varchar(255) DEFAULT NULL,
  `bankinfo_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of rechargeoffline
-- ----------------------------
INSERT INTO `rechargeoffline` VALUES ('1', '2', '都借钱了还充什么钱', '2017-09-22 19:59:13', '2017-09-22 02:15:17', '10', '4', '010674', '2017-09-22 00:00:00', '10000.0000', '没什么好说的', '2');
INSERT INTO `rechargeoffline` VALUES ('2', '1', 'ok', '2017-09-22 20:01:14', '2017-09-22 20:00:29', '10', '4', '622266', '2017-09-22 00:00:00', '10000.0000', '打给审核人', '2');
INSERT INTO `rechargeoffline` VALUES ('3', '1', '无异议', '2017-09-22 20:17:38', '2017-09-22 20:16:53', '10', '12', '0101666', '2017-09-22 00:00:00', '10000.0000', '资本家的决心', '2');
INSERT INTO `rechargeoffline` VALUES ('4', '1', 'ok', '2017-09-23 21:40:13', '2017-09-23 21:38:53', '10', '13', '2017923', '2017-09-23 00:00:00', '10000.0000', '', '2');

-- ----------------------------
-- Table structure for systemaccount
-- ----------------------------
DROP TABLE IF EXISTS `systemaccount`;
CREATE TABLE `systemaccount` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` int(11) NOT NULL,
  `totalbalance` decimal(18,4) NOT NULL,
  `freezedamount` decimal(18,4) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of systemaccount
-- ----------------------------
INSERT INTO `systemaccount` VALUES ('1', '0', '1000000.0000', '0.0000');

-- ----------------------------
-- Table structure for systemaccountflow
-- ----------------------------
DROP TABLE IF EXISTS `systemaccountflow`;
CREATE TABLE `systemaccountflow` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `createdDate` datetime NOT NULL,
  `accountactiontype` tinyint(4) NOT NULL,
  `amount` decimal(18,4) NOT NULL,
  `note` varchar(255) DEFAULT NULL,
  `balance` decimal(18,4) NOT NULL,
  `freezedAmount` decimal(18,4) NOT NULL,
  `targetuser_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of systemaccountflow
-- ----------------------------
INSERT INTO `systemaccountflow` VALUES ('1', '2017-09-24 22:42:56', '1', '1000000.0000', '幕后白手给平台打钱', '10000.0000', '0.0000', '1');

-- ----------------------------
-- Table structure for systemdictionary
-- ----------------------------
DROP TABLE IF EXISTS `systemdictionary`;
CREATE TABLE `systemdictionary` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `sn` varchar(50) NOT NULL,
  `title` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of systemdictionary
-- ----------------------------
INSERT INTO `systemdictionary` VALUES ('1', 'brain', '脑残情况');
INSERT INTO `systemdictionary` VALUES ('2', 'record', '学历状况');
INSERT INTO `systemdictionary` VALUES ('3', 'marriage', '婚姻状况');
INSERT INTO `systemdictionary` VALUES ('4', 'son', '子女情况');
INSERT INTO `systemdictionary` VALUES ('5', 'live', '住房条件');
INSERT INTO `systemdictionary` VALUES ('6', 'income', '月收入');
INSERT INTO `systemdictionary` VALUES ('7', 'wind', '风控材料');

-- ----------------------------
-- Table structure for systemdictionaryitem
-- ----------------------------
DROP TABLE IF EXISTS `systemdictionaryitem`;
CREATE TABLE `systemdictionaryitem` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parentId` bigint(20) NOT NULL,
  `title` varchar(50) NOT NULL,
  `sequence` tinyint(4) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of systemdictionaryitem
-- ----------------------------
INSERT INTO `systemdictionaryitem` VALUES ('1', '1', '脑积水', '1');
INSERT INTO `systemdictionaryitem` VALUES ('2', '2', '小学生', '1');
INSERT INTO `systemdictionaryitem` VALUES ('3', '2', '中学生', '2');
INSERT INTO `systemdictionaryitem` VALUES ('4', '2', '大学生', '3');
INSERT INTO `systemdictionaryitem` VALUES ('5', '2', '研究生', '4');
INSERT INTO `systemdictionaryitem` VALUES ('6', '2', '博士', '5');
INSERT INTO `systemdictionaryitem` VALUES ('7', '2', '外星生物', '6');
INSERT INTO `systemdictionaryitem` VALUES ('8', '3', '已昏', '1');
INSERT INTO `systemdictionaryitem` VALUES ('9', '3', '未昏', '2');
INSERT INTO `systemdictionaryitem` VALUES ('10', '3', '狸昏', '3');
INSERT INTO `systemdictionaryitem` VALUES ('11', '4', '60~80', '1');
INSERT INTO `systemdictionaryitem` VALUES ('12', '4', '1000~20000', '2');
INSERT INTO `systemdictionaryitem` VALUES ('13', '4', '10亿左右', '3');
INSERT INTO `systemdictionaryitem` VALUES ('14', '5', '天桥', '1');
INSERT INTO `systemdictionaryitem` VALUES ('15', '5', '网吧', '2');
INSERT INTO `systemdictionaryitem` VALUES ('16', '5', '深山', '3');
INSERT INTO `systemdictionaryitem` VALUES ('17', '5', '派出所', '4');
INSERT INTO `systemdictionaryitem` VALUES ('18', '5', '星际酒店', '5');
INSERT INTO `systemdictionaryitem` VALUES ('19', '6', '1-2元人民币', '1');
INSERT INTO `systemdictionaryitem` VALUES ('20', '6', '5-6元人民币', '2');
INSERT INTO `systemdictionaryitem` VALUES ('21', '6', '6-7元人民币', '3');
INSERT INTO `systemdictionaryitem` VALUES ('22', '6', '9元', '4');
INSERT INTO `systemdictionaryitem` VALUES ('23', '1', '脑萎缩', '2');
INSERT INTO `systemdictionaryitem` VALUES ('24', '1', '脑膜炎', '3');
INSERT INTO `systemdictionaryitem` VALUES ('25', '7', '家属身份证正面', '1');
INSERT INTO `systemdictionaryitem` VALUES ('26', '7', '家属身份证背面', '2');
INSERT INTO `systemdictionaryitem` VALUES ('27', '7', '毕业证', '3');
INSERT INTO `systemdictionaryitem` VALUES ('28', '7', '护照', '4');
INSERT INTO `systemdictionaryitem` VALUES ('29', '7', '工作证', '5');
INSERT INTO `systemdictionaryitem` VALUES ('30', '7', '通行证', '6');

-- ----------------------------
-- Table structure for userfile
-- ----------------------------
DROP TABLE IF EXISTS `userfile`;
CREATE TABLE `userfile` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `state` tinyint(4) NOT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `auditTime` datetime DEFAULT NULL,
  `applyTime` datetime NOT NULL,
  `auditor_id` bigint(20) DEFAULT NULL,
  `applier_id` bigint(20) NOT NULL,
  `score` tinyint(4) DEFAULT NULL,
  `file` varchar(255) NOT NULL,
  `filetype_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of userfile
-- ----------------------------
INSERT INTO `userfile` VALUES ('1', '2', '换图片', '2017-09-19 21:04:36', '2017-09-19 01:48:25', '10', '4', '0', '2d030d33-2e5a-4e11-b24c-22f28ad97d53.jpg', '25');
INSERT INTO `userfile` VALUES ('2', '1', 'good job', '2017-09-19 21:04:16', '2017-09-19 01:48:25', '10', '4', '5', 'c3992be4-742f-47e9-9252-ac697c62af35.jpg', '25');
INSERT INTO `userfile` VALUES ('3', '2', '换图片', '2017-09-19 20:56:37', '2017-09-19 01:48:25', '10', '4', '0', '2bc64333-21a4-4cf9-9c45-81bf8fdf5187.jpg', '25');
INSERT INTO `userfile` VALUES ('4', '1', 'goodjob', '2017-09-19 21:29:35', '2017-09-19 21:25:55', '10', '4', '1', '656fd860-601b-4883-aa84-3367959e48a2.jpg', '26');
INSERT INTO `userfile` VALUES ('5', '1', 'goodjob', '2017-09-19 21:29:44', '2017-09-19 21:25:55', '10', '4', '5', 'd21ff0bc-c2bd-470e-b714-3aa585e28c8c.jpg', '27');
INSERT INTO `userfile` VALUES ('6', '1', 'goodjob', '2017-09-19 21:30:21', '2017-09-19 21:25:55', '10', '4', '5', 'e9f72930-94cc-4404-bcff-a7025f686784.jpg', '28');
INSERT INTO `userfile` VALUES ('7', '1', 'goodjob', '2017-09-19 21:30:29', '2017-09-19 21:25:55', '10', '4', '5', '6e270f08-e84a-4d2a-8ff6-50d462e6c78f.jpg', '29');
INSERT INTO `userfile` VALUES ('8', '1', 'goodjob', '2017-09-19 21:30:37', '2017-09-19 21:25:55', '10', '4', '5', '1e7271f0-409d-4492-8a27-65dbcd982aa3.jpg', '30');
INSERT INTO `userfile` VALUES ('9', '1', 'goodjob', '2017-09-19 21:31:12', '2017-09-19 21:30:58', '10', '4', '4', '65cb09c7-5b54-40ff-a25b-97ca0cf30d12.jpg', '25');

-- ----------------------------
-- Table structure for userinfo
-- ----------------------------
DROP TABLE IF EXISTS `userinfo`;
CREATE TABLE `userinfo` (
  `id` bigint(20) NOT NULL,
  `version` int(11) NOT NULL,
  `bitState` bigint(20) NOT NULL,
  `realName` varchar(30) DEFAULT NULL,
  `score` int(8) DEFAULT NULL,
  `idNumber` varchar(30) DEFAULT NULL,
  `phoneNumber` varchar(30) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `realAuthId` bigint(20) DEFAULT NULL,
  `incomeGrade_id` bigint(20) DEFAULT NULL,
  `marriage_id` bigint(20) DEFAULT NULL,
  `kidCount_id` bigint(20) DEFAULT NULL,
  `educationBackground_id` bigint(20) DEFAULT NULL,
  `houseCondition_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of userinfo
-- ----------------------------
INSERT INTO `userinfo` VALUES ('4', '42', '63', null, '30', null, '130', '1992', '6', '22', '9', '13', '2', '16');
INSERT INTO `userinfo` VALUES ('5', '0', '0', null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `userinfo` VALUES ('9', '0', '0', null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `userinfo` VALUES ('12', '0', '0', null, '0', null, null, null, null, null, null, null, null, null);
INSERT INTO `userinfo` VALUES ('13', '0', '0', null, '0', null, null, null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for vedioauth
-- ----------------------------
DROP TABLE IF EXISTS `vedioauth`;
CREATE TABLE `vedioauth` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `state` tinyint(4) NOT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `auditTime` datetime DEFAULT NULL,
  `applyTime` datetime NOT NULL,
  `auditor_id` bigint(20) DEFAULT NULL,
  `applier_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of vedioauth
-- ----------------------------
INSERT INTO `vedioauth` VALUES ('1', '2', 'no', '2017-09-19 23:42:12', '2017-09-19 23:42:12', '10', '4');
INSERT INTO `vedioauth` VALUES ('2', '1', 'good', '2017-09-19 23:47:54', '2017-09-19 23:47:54', '10', '4');
