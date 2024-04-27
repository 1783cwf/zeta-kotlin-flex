-- MySQL dump 10.13  Distrib 8.3.0, for macos14.2 (arm64)
--
-- Host: localdev    Database: zeta_kotlin
-- ------------------------------------------------------
-- Server version	8.2.0

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
-- Table structure for table `sys_dict`
--

DROP TABLE IF EXISTS `sys_dict`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_dict` (
  `id` bigint NOT NULL COMMENT 'id',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `created_by` bigint DEFAULT NULL COMMENT '创建人',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `updated_by` bigint DEFAULT NULL COMMENT '修改人',
  `name` varchar(32) NOT NULL COMMENT '名称',
  `code` varchar(32) NOT NULL COMMENT '编码',
  `describe_` varchar(255) DEFAULT NULL COMMENT '描述',
  `sort_value` int DEFAULT NULL COMMENT '排序',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '逻辑删除字段',
  `version` int DEFAULT NULL COMMENT '乐观锁字段',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC COMMENT='字典表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_dict`
--

INSERT INTO `sys_dict` (`id`, `create_time`, `created_by`, `update_time`, `updated_by`, `name`, `code`, `describe_`, `sort_value`, `deleted`, `version`) VALUES (1645607079798374400,'2023-04-11 09:57:56',0,'2023-04-11 09:57:56',0,'设备状态','device_status','设备运行状态',0,_binary '\0',0);

--
-- Table structure for table `sys_dict_item`
--

DROP TABLE IF EXISTS `sys_dict_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_dict_item` (
  `id` bigint NOT NULL COMMENT 'id',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `created_by` bigint DEFAULT NULL COMMENT '创建人',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `updated_by` bigint DEFAULT NULL COMMENT '修改人',
  `dict_id` bigint NOT NULL COMMENT '字典id',
  `name` varchar(32) NOT NULL COMMENT '字典项',
  `value` varchar(32) NOT NULL COMMENT '值',
  `describe_` varchar(255) DEFAULT NULL COMMENT '描述',
  `sort_value` int DEFAULT NULL COMMENT '排序',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '逻辑删除字段',
  `version` int DEFAULT NULL COMMENT '乐观锁字段',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC COMMENT='字典项表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_dict_item`
--

INSERT INTO `sys_dict_item` (`id`, `create_time`, `created_by`, `update_time`, `updated_by`, `dict_id`, `name`, `value`, `describe_`, `sort_value`, `deleted`, `version`) VALUES (1645607080020672512,'2023-04-11 09:57:56',0,'2023-04-11 09:57:56',0,1645607079798374400,'运行','RUNNING','设备正在运行',1,_binary '\0',0),(1645607080020672513,'2023-04-11 09:57:56',0,'2023-04-11 09:57:56',0,1645607079798374400,'停止','WAITING','设备已停止',2,_binary '\0',0);

--
-- Table structure for table `sys_file`
--

DROP TABLE IF EXISTS `sys_file`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_file` (
  `id` bigint NOT NULL COMMENT 'id',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `created_by` bigint DEFAULT NULL COMMENT '创建人',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `updated_by` bigint DEFAULT NULL COMMENT '修改人',
  `biz_type` varchar(255) DEFAULT NULL COMMENT '业务类型',
  `bucket` varchar(255) NOT NULL COMMENT '桶',
  `storage_type` varchar(255) NOT NULL COMMENT '存储类型',
  `path` varchar(255) NOT NULL COMMENT '文件相对地址',
  `url` varchar(255) DEFAULT NULL COMMENT '文件访问地址',
  `unique_file_name` varchar(255) NOT NULL COMMENT '唯一文件名',
  `original_file_name` varchar(255) DEFAULT NULL COMMENT '原始文件名',
  `file_type` varchar(255) DEFAULT NULL COMMENT '文件类型',
  `content_type` varchar(255) DEFAULT NULL COMMENT '内容类型',
  `suffix` varchar(255) DEFAULT NULL COMMENT '后缀',
  `size` bigint DEFAULT NULL COMMENT '文件大小',
  `version` int DEFAULT NULL COMMENT '乐观锁字段',
  `deleted` bigint NOT NULL COMMENT '逻辑删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC COMMENT='系统文件表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_file`
--


--
-- Table structure for table `sys_login_log`
--

DROP TABLE IF EXISTS `sys_login_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_login_log` (
  `id` bigint NOT NULL COMMENT 'id',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `created_by` bigint DEFAULT NULL COMMENT '创建人',
  `state` varchar(10) NOT NULL COMMENT '状态',
  `account` varchar(64) NOT NULL COMMENT '账号',
  `comments` varchar(255) DEFAULT NULL COMMENT '备注',
  `os` varchar(50) DEFAULT NULL COMMENT '操作系统',
  `device` varchar(50) DEFAULT NULL COMMENT '设备名称',
  `browser` varchar(50) DEFAULT NULL COMMENT '浏览器类型',
  `ip` varchar(50) DEFAULT NULL COMMENT 'ip地址',
  `ip_region` varchar(255) DEFAULT NULL COMMENT 'ip所在地区',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC COMMENT='登录日志表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_login_log`
--


--
-- Table structure for table `sys_menu`
--

DROP TABLE IF EXISTS `sys_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_menu` (
  `id` bigint NOT NULL COMMENT 'id',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `created_by` bigint DEFAULT NULL COMMENT '创建人',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `updated_by` bigint DEFAULT NULL COMMENT '修改人',
  `label` varchar(32) DEFAULT NULL COMMENT '名称',
  `parent_id` bigint unsigned NOT NULL COMMENT '父级id',
  `sort_value` int DEFAULT NULL COMMENT '排序',
  `name` varchar(255) DEFAULT NULL COMMENT '路由名称',
  `path` varchar(255) DEFAULT NULL COMMENT '路由地址',
  `component` varchar(255) DEFAULT NULL COMMENT '组件地址',
  `redirect` varchar(255) DEFAULT NULL COMMENT '重定向地址',
  `icon` varchar(32) DEFAULT NULL COMMENT '图标',
  `authority` varchar(100) DEFAULT NULL COMMENT '权限标识',
  `type` varchar(32) NOT NULL COMMENT '菜单类型',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '逻辑删除字段',
  `hide` bit(1) DEFAULT b'0' COMMENT '是否隐藏 0否 1是',
  `keep_alive` bit(1) DEFAULT b'0' COMMENT '是否缓存 0否 1是',
  `href` varchar(255) DEFAULT NULL COMMENT '外链地址',
  `frame_src` varchar(255) DEFAULT NULL COMMENT '内链地址',
  `version` int DEFAULT NULL COMMENT '乐观锁字段',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC COMMENT='菜单表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_menu`
--

INSERT INTO `sys_menu` (`id`, `create_time`, `created_by`, `update_time`, `updated_by`, `label`, `parent_id`, `sort_value`, `name`, `path`, `component`, `redirect`, `icon`, `authority`, `type`, `deleted`, `hide`, `keep_alive`, `href`, `frame_src`, `version`) VALUES (1645607074249310208,'2023-04-11 09:57:55',0,'2024-01-08 16:18:18',1645607078095486976,'系统管理',0,1,'system','/system','dashboard/workbench/index',NULL,'ant-design:setting-filled','','MENU',_binary '\0',_binary '\0',_binary '\0',NULL,NULL,0),(1645607074253504512,'2023-04-11 09:57:55',0,'2024-01-08 20:52:20',1645607078095486976,'用户管理',1645607074249310208,1,'system_user','/system/user','system/user/index',NULL,'ant-design:user-outlined','','MENU',_binary '\0',_binary '\0',_binary '\0',NULL,NULL,0),(1645607074253504513,'2023-04-11 09:57:55',0,'2024-01-08 15:17:57',1645607078095486976,'查看用户',1645607074253504512,1,NULL,'','',NULL,'ant-design:aliwangwang-filled','sys:user:view','RESOURCE',_binary '\0',_binary '\0',_binary '\0','','',0),(1645607074253504514,'2023-04-11 09:57:55',0,'2023-04-11 09:57:55',0,'新增用户',1645607074253504512,2,NULL,NULL,NULL,NULL,NULL,'sys:user:save','RESOURCE',_binary '\0',_binary '\0',_binary '\0',NULL,NULL,0),(1645607074253504515,'2023-04-11 09:57:55',0,'2023-04-11 09:57:55',0,'修改用户',1645607074253504512,3,NULL,NULL,NULL,NULL,NULL,'sys:user:update','RESOURCE',_binary '\0',_binary '\0',_binary '\0',NULL,NULL,0),(1645607074253504516,'2023-04-11 09:57:55',0,'2023-04-11 09:57:55',0,'删除用户',1645607074253504512,4,NULL,NULL,NULL,NULL,NULL,'sys:user:delete','RESOURCE',_binary '\0',_binary '\0',_binary '\0',NULL,NULL,0),(1645607074253504517,'2023-04-11 09:57:55',0,'2024-01-08 20:54:00',1645607078095486976,'角色管理',1645607074249310208,2,'system_role','/system/role','system/role/index',NULL,'ant-design:user-switch-outlined','','MENU',_binary '\0',_binary '\0',_binary '\0',NULL,NULL,0),(1645607074253504518,'2023-04-11 09:57:55',0,'2023-04-11 09:57:55',0,'查看角色',1645607074253504517,1,NULL,NULL,NULL,NULL,NULL,'sys:role:view','RESOURCE',_binary '\0',_binary '\0',_binary '\0',NULL,NULL,0),(1645607074253504519,'2023-04-11 09:57:55',0,'2023-04-11 09:57:55',0,'新增角色',1645607074253504517,2,NULL,NULL,NULL,NULL,NULL,'sys:role:save','RESOURCE',_binary '\0',_binary '\0',_binary '\0',NULL,NULL,0),(1645607074253504520,'2023-04-11 09:57:55',0,'2023-04-11 09:57:55',0,'修改角色',1645607074253504517,3,NULL,NULL,NULL,NULL,NULL,'sys:role:update','RESOURCE',_binary '\0',_binary '\0',_binary '\0',NULL,NULL,0),(1645607074253504521,'2023-04-11 09:57:55',0,'2023-04-11 09:57:55',0,'删除角色',1645607074253504517,4,NULL,NULL,NULL,NULL,NULL,'sys:role:delete','RESOURCE',_binary '\0',_binary '\0',_binary '\0',NULL,NULL,0),(1645607074253504522,'2023-04-11 09:57:55',0,'2024-01-08 16:18:37',1645607078095486976,'菜单管理',1645607074249310208,3,'system_menu','/system/menu','system/menu/index',NULL,'ant-design:apartment-outlined','','MENU',_binary '\0',_binary '\0',_binary '\0',NULL,NULL,0),(1645607074253504523,'2023-04-11 09:57:55',0,'2023-04-11 09:57:55',0,'查看菜单',1645607074253504522,1,NULL,NULL,NULL,NULL,NULL,'sys:menu:view','RESOURCE',_binary '\0',_binary '\0',_binary '\0',NULL,NULL,0),(1645607074253504524,'2023-04-11 09:57:55',0,'2023-04-11 09:57:55',0,'新增菜单',1645607074253504522,2,NULL,NULL,NULL,NULL,NULL,'sys:menu:save','RESOURCE',_binary '\0',_binary '\0',_binary '\0',NULL,NULL,0),(1645607074253504525,'2023-04-11 09:57:55',0,'2023-04-11 09:57:55',0,'修改菜单',1645607074253504522,3,NULL,NULL,NULL,NULL,NULL,'sys:menu:update','RESOURCE',_binary '\0',_binary '\0',_binary '\0',NULL,NULL,0),(1645607074253504526,'2023-04-11 09:57:55',0,'2023-04-11 09:57:55',0,'删除菜单',1645607074253504522,4,NULL,NULL,NULL,NULL,NULL,'sys:menu:delete','RESOURCE',_binary '\0',_binary '\0',_binary '\0',NULL,NULL,0),(1645607074253504527,'2023-04-11 09:57:55',0,'2024-01-08 20:55:02',1645607078095486976,'操作日志',1645607074249310208,4,'system_optLog','/system/optLog','system/opt-log/index',NULL,'ant-design:align-left-outlined','','MENU',_binary '\0',_binary '\0',_binary '\0',NULL,NULL,0),(1645607074253504528,'2023-04-11 09:57:55',0,'2023-04-11 09:57:55',0,'查看操作日志',1645607074253504527,1,NULL,NULL,NULL,NULL,NULL,'sys:optLog:view','RESOURCE',_binary '\0',_binary '\0',_binary '\0',NULL,NULL,0),(1645607074253504529,'2023-04-11 09:57:55',0,'2024-01-08 20:55:14',1645607078095486976,'登录日志',1645607074249310208,5,'system_loginLog','/system/loginLog','system/login-log/index',NULL,'ant-design:align-left-outlined','','MENU',_binary '\0',_binary '\0',_binary '\0',NULL,NULL,0),(1645607074253504530,'2023-04-11 09:57:55',0,'2023-04-11 09:57:55',0,'查看登录日志',1645607074253504529,1,NULL,NULL,NULL,NULL,NULL,'sys:loginLog:view','RESOURCE',_binary '\0',_binary '\0',_binary '\0',NULL,NULL,0),(1645607074253504531,'2023-04-11 09:57:55',0,'2024-01-08 20:55:29',1645607078095486976,'文件管理',1645607074249310208,6,'system_file','/system/file','system/file/index',NULL,'ant-design:file-done-outlined','','MENU',_binary '\0',_binary '\0',_binary '\0',NULL,NULL,0),(1645607074253504532,'2023-04-11 09:57:55',0,'2023-04-11 09:57:55',0,'查看文件',1645607074253504531,1,NULL,NULL,NULL,NULL,NULL,'sys:file:view','RESOURCE',_binary '\0',_binary '\0',_binary '\0',NULL,NULL,0),(1645607074253504533,'2023-04-11 09:57:55',0,'2023-04-11 09:57:55',0,'上传文件',1645607074253504531,2,NULL,NULL,NULL,NULL,NULL,'sys:file:save','RESOURCE',_binary '\0',_binary '\0',_binary '\0',NULL,NULL,0),(1645607074253504534,'2023-04-11 09:57:55',0,'2023-04-11 09:57:55',0,'下载文件',1645607074253504531,3,NULL,NULL,NULL,NULL,NULL,'sys:file:export','RESOURCE',_binary '\0',_binary '\0',_binary '\0',NULL,NULL,0),(1645607074253504535,'2023-04-11 09:57:55',0,'2023-04-11 09:57:55',0,'删除文件',1645607074253504531,4,NULL,NULL,NULL,NULL,NULL,'sys:file:delete','RESOURCE',_binary '\0',_binary '\0',_binary '\0',NULL,NULL,0),(1645607074253504536,'2023-04-11 09:57:55',0,'2024-01-08 20:56:22',1645607078095486976,'数据字典',1645607074249310208,7,'system_dict','/system/dict','system/dict/index',NULL,'ant-design:container-outlined','','MENU',_binary '\0',_binary '\0',_binary '\0',NULL,NULL,0),(1645607074253504537,'2023-04-11 09:57:55',0,'2023-04-11 09:57:55',0,'查看字典',1645607074253504536,1,NULL,NULL,NULL,NULL,NULL,'sys:dict:view','RESOURCE',_binary '\0',_binary '\0',_binary '\0',NULL,NULL,0),(1645607074253504538,'2023-04-11 09:57:55',0,'2023-04-11 09:57:55',0,'新增字典',1645607074253504536,2,NULL,NULL,NULL,NULL,NULL,'sys:dict:save','RESOURCE',_binary '\0',_binary '\0',_binary '\0',NULL,NULL,0),(1645607074253504539,'2023-04-11 09:57:55',0,'2023-04-11 09:57:55',0,'修改字典',1645607074253504536,3,NULL,NULL,NULL,NULL,NULL,'sys:dict:update','RESOURCE',_binary '\0',_binary '\0',_binary '\0',NULL,NULL,0),(1645607074253504540,'2023-04-11 09:57:55',0,'2023-04-11 09:57:55',0,'删除字典',1645607074253504536,4,NULL,NULL,NULL,NULL,NULL,'sys:dict:delete','RESOURCE',_binary '\0',_binary '\0',_binary '\0',NULL,NULL,0),(1645607074257698816,'2023-04-11 09:57:55',0,'2023-04-11 09:57:55',0,'查看字典项',1645607074253504536,5,NULL,NULL,NULL,NULL,NULL,'sys:dictItem:view','RESOURCE',_binary '\0',_binary '\0',_binary '\0',NULL,NULL,0),(1645607074257698817,'2023-04-11 09:57:55',0,'2023-04-11 09:57:55',0,'新增字典项',1645607074253504536,6,NULL,NULL,NULL,NULL,NULL,'sys:dictItem:save','RESOURCE',_binary '\0',_binary '\0',_binary '\0',NULL,NULL,0),(1645607074257698818,'2023-04-11 09:57:55',0,'2023-04-11 09:57:55',0,'修改字典项',1645607074253504536,7,NULL,NULL,NULL,NULL,NULL,'sys:dictItem:update','RESOURCE',_binary '\0',_binary '\0',_binary '\0',NULL,NULL,0),(1645607074257698819,'2023-04-11 09:57:55',0,'2024-03-31 21:18:01',1645607078095486976,'删除字典项',1645607074253504536,8,NULL,'','',NULL,'','sys:dictItem:delete','RESOURCE',_binary '\0',_binary '\0',_binary '\0','','',2);

--
-- Table structure for table `sys_opt_log`
--

DROP TABLE IF EXISTS `sys_opt_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_opt_log` (
  `id` bigint NOT NULL COMMENT 'id',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `created_by` bigint DEFAULT NULL COMMENT '创建人',
  `type` varchar(10) NOT NULL COMMENT '操作类型',
  `description` varchar(255) DEFAULT NULL COMMENT '操作描述',
  `url` varchar(255) NOT NULL COMMENT '请求地址',
  `http_method` varchar(10) NOT NULL COMMENT '请求方式',
  `class_path` varchar(255) NOT NULL COMMENT '类路径',
  `params` longtext COMMENT '请求参数',
  `result` longtext COMMENT '返回值',
  `exception` longtext COMMENT '异常描述',
  `spend_time` int NOT NULL COMMENT '消耗时间 单位毫秒',
  `os` varchar(50) DEFAULT NULL COMMENT '操作系统',
  `device` varchar(50) DEFAULT NULL COMMENT '设备名称',
  `browser` varchar(50) DEFAULT NULL COMMENT '浏览器类型',
  `ip` varchar(50) DEFAULT NULL COMMENT 'ip地址',
  `ip_region` varchar(255) DEFAULT NULL COMMENT 'ip所在地区',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC COMMENT='操作日志表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_opt_log`
--


--
-- Table structure for table `sys_role`
--

DROP TABLE IF EXISTS `sys_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_role` (
  `id` bigint NOT NULL COMMENT 'id',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `created_by` bigint DEFAULT NULL COMMENT '创建人',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `updated_by` bigint DEFAULT NULL COMMENT '修改人',
  `name` varchar(32) NOT NULL COMMENT '角色名',
  `code` varchar(32) NOT NULL COMMENT '角色编码',
  `describe_` varchar(255) DEFAULT NULL COMMENT '描述',
  `deleted` bit(1) DEFAULT b'0' COMMENT '逻辑删除字段',
  `readonly_` bit(1) NOT NULL DEFAULT b'0' COMMENT '内置',
  `version` int DEFAULT NULL COMMENT '乐观锁字段',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC COMMENT='角色表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_role`
--

INSERT INTO `sys_role` (`id`, `create_time`, `created_by`, `update_time`, `updated_by`, `name`, `code`, `describe_`, `deleted`, `readonly_`, `version`) VALUES (1645607076937859072,'2023-04-11 09:57:56',0,'2023-04-11 09:57:56',0,'超级管理员','SUPER_ADMIN','超级管理员，拥有至高无上的权利',_binary '\0',_binary '',0),(1645607076937859073,'2023-04-11 09:57:56',0,'2023-04-11 09:57:56',0,'管理员','ADMIN','管理员，拥有99%的权利',_binary '\0',_binary '\0',0),(1645607076937859074,'2023-04-11 09:57:56',0,'2023-04-11 09:57:56',0,'普通用户','USER','普通用户，拥有管理员赋予的权利',_binary '\0',_binary '\0',0);

--
-- Table structure for table `sys_role_menu`
--

DROP TABLE IF EXISTS `sys_role_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_role_menu` (
  `id` bigint NOT NULL COMMENT 'id',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `created_by` bigint DEFAULT NULL COMMENT '创建人',
  `role_id` bigint NOT NULL COMMENT '角色id',
  `menu_id` bigint NOT NULL COMMENT '菜单id',
  `version` int DEFAULT NULL COMMENT '乐观锁字段',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC COMMENT='角色菜单关联表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_role_menu`
--

INSERT INTO `sys_role_menu` (`id`, `create_time`, `created_by`, `role_id`, `menu_id`, `version`) VALUES (1645607077265014784,'2023-04-11 09:57:56',0,1645607076937859072,1645607074249310208,NULL),(1645607077269209088,'2023-04-11 09:57:56',0,1645607076937859072,1645607074253504512,NULL),(1645607077269209089,'2023-04-11 09:57:56',0,1645607076937859072,1645607074253504513,NULL),(1645607077273403392,'2023-04-11 09:57:56',0,1645607076937859072,1645607074253504514,NULL),(1645607077273403393,'2023-04-11 09:57:56',0,1645607076937859072,1645607074253504515,NULL),(1645607077277597696,'2023-04-11 09:57:56',0,1645607076937859072,1645607074253504516,NULL),(1645607077277597697,'2023-04-11 09:57:56',0,1645607076937859072,1645607074253504517,NULL),(1645607077281792000,'2023-04-11 09:57:56',0,1645607076937859072,1645607074253504518,NULL),(1645607077281792001,'2023-04-11 09:57:56',0,1645607076937859072,1645607074253504519,NULL),(1645607077281792002,'2023-04-11 09:57:56',0,1645607076937859072,1645607074253504520,NULL),(1645607077281792003,'2023-04-11 09:57:56',0,1645607076937859072,1645607074253504521,NULL),(1645607077285986304,'2023-04-11 09:57:56',0,1645607076937859072,1645607074253504522,NULL),(1645607077285986305,'2023-04-11 09:57:56',0,1645607076937859072,1645607074253504523,NULL),(1645607077285986306,'2023-04-11 09:57:56',0,1645607076937859072,1645607074253504524,NULL),(1645607077290180608,'2023-04-11 09:57:56',0,1645607076937859072,1645607074253504525,NULL),(1645607077290180609,'2023-04-11 09:57:56',0,1645607076937859072,1645607074253504526,NULL),(1645607077294374912,'2023-04-11 09:57:56',0,1645607076937859072,1645607074253504527,NULL),(1645607077294374913,'2023-04-11 09:57:56',0,1645607076937859072,1645607074253504528,NULL),(1645607077294374914,'2023-04-11 09:57:56',0,1645607076937859072,1645607074253504529,0),(1645607077298569216,'2023-04-11 09:57:56',0,1645607076937859072,1645607074253504530,0),(1645607077298569217,'2023-04-11 09:57:56',0,1645607076937859072,1645607074253504531,0),(1645607077298569218,'2023-04-11 09:57:56',0,1645607076937859072,1645607074253504532,0),(1645607077298569219,'2023-04-11 09:57:56',0,1645607076937859072,1645607074253504533,0),(1645607077302763520,'2023-04-11 09:57:56',0,1645607076937859072,1645607074253504534,0),(1645607077302763521,'2023-04-11 09:57:56',0,1645607076937859072,1645607074253504535,0),(1645607077306957824,'2023-04-11 09:57:56',0,1645607076937859072,1645607074253504536,0),(1645607077306957825,'2023-04-11 09:57:56',0,1645607076937859072,1645607074253504537,0),(1645607077306957826,'2023-04-11 09:57:56',0,1645607076937859072,1645607074253504538,0),(1645607077311152128,'2023-04-11 09:57:56',0,1645607076937859072,1645607074253504539,0),(1645607077311152129,'2023-04-11 09:57:56',0,1645607076937859072,1645607074253504540,0),(1645607077311152130,'2023-04-11 09:57:56',0,1645607076937859072,1645607074257698816,0),(1645607077315346432,'2023-04-11 09:57:56',0,1645607076937859072,1645607074257698817,0),(1645607077315346433,'2023-04-11 09:57:56',0,1645607076937859072,1645607074257698818,0),(1645607077315346434,'2023-04-11 09:57:56',0,1645607076937859072,1645607074257698819,0);

--
-- Table structure for table `sys_user`
--

DROP TABLE IF EXISTS `sys_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_user` (
  `id` bigint NOT NULL COMMENT 'id',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `created_by` bigint DEFAULT NULL COMMENT '创建人',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `updated_by` bigint DEFAULT NULL COMMENT '修改人',
  `username` varchar(32) NOT NULL COMMENT '用户名',
  `account` varchar(64) NOT NULL COMMENT '账号',
  `password` varchar(64) NOT NULL COMMENT '密码',
  `email` varchar(32) DEFAULT NULL COMMENT '邮箱',
  `mobile` varchar(20) DEFAULT NULL COMMENT '手机号',
  `sex` int NOT NULL DEFAULT '0' COMMENT '性别 0未知 1男 2女',
  `avatar` varchar(255) DEFAULT NULL COMMENT '头像',
  `birthday` date DEFAULT NULL COMMENT '生日',
  `readonly_` bit(1) NOT NULL DEFAULT b'0' COMMENT '内置',
  `state` int NOT NULL COMMENT '状态',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '逻辑删除字段',
  `version` int DEFAULT NULL COMMENT '乐观锁字段',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC COMMENT='用户表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_user`
--

INSERT INTO `sys_user` (`id`, `create_time`, `created_by`, `update_time`, `updated_by`, `username`, `account`, `password`, `email`, `mobile`, `sex`, `avatar`, `birthday`, `readonly_`, `state`, `deleted`, `version`) VALUES (1645607078095486976,'2023-04-11 09:57:56',0,'2023-04-11 09:57:56',0,'zeta管理员','zetaAdmin','$2a$10$M8Q6189WcePNJ7d50FvOKOdCtcyy0hxyFKL6z8jxmhyvkLHIP8ZBC',NULL,NULL,1,NULL,NULL,_binary '',1,_binary '\0',0);

--
-- Table structure for table `sys_user_role`
--

DROP TABLE IF EXISTS `sys_user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_user_role` (
  `id` bigint NOT NULL COMMENT 'id',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `created_by` bigint DEFAULT NULL COMMENT '创建人',
  `user_id` bigint NOT NULL COMMENT '用户id',
  `role_id` bigint NOT NULL COMMENT '角色id',
  `version` int DEFAULT NULL COMMENT '乐观锁字段',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC COMMENT='用户角色表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_user_role`
--

INSERT INTO `sys_user_role` (`id`, `create_time`, `created_by`, `user_id`, `role_id`, `version`) VALUES (1645607079659962368,'2023-04-11 09:57:56',0,1645607078095486976,1645607076937859072,0);
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-04-14 13:18:48
