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
                          `name` varchar(32) DEFAULT NULL COMMENT '名称',
                          `code` varchar(32) DEFAULT NULL COMMENT '编码',
                          `describe` varchar(255) DEFAULT NULL COMMENT '描述',
                          `sort_value` int DEFAULT NULL COMMENT '排序',
                          `id` bigint NOT NULL AUTO_INCREMENT,
                          `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                          `created_by` bigint DEFAULT NULL COMMENT '创建人ID',
                          `update_time` datetime DEFAULT NULL COMMENT '最后修改时间',
                          `updated_by` bigint DEFAULT NULL COMMENT '最后修改人ID',
                          `version` int DEFAULT '0' COMMENT '乐观锁',
                          `describe_` varchar(255) DEFAULT NULL COMMENT '描述',
                          `deleted` tinyint DEFAULT '0' COMMENT '逻辑删除字段',
                          PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1645607079798374401 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC COMMENT='字典表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_dict`
--

INSERT INTO `sys_dict` (`name`, `code`, `describe`, `sort_value`, `id`, `create_time`, `created_by`, `update_time`, `updated_by`, `version`, `describe_`, `deleted`) VALUES ('设备状态','device_status',NULL,0,1645607079798374400,'2023-04-11 09:57:56',0,'2023-04-11 09:57:56',0,0,'设备运行状态',0);

--
-- Table structure for table `sys_dict_item`
--

DROP TABLE IF EXISTS `sys_dict_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_dict_item` (
                               `dict_id` bigint DEFAULT NULL COMMENT '字典id',
                               `name` varchar(32) DEFAULT NULL COMMENT '字典项',
                               `value` varchar(32) DEFAULT NULL COMMENT '值',
                               `describe` varchar(255) DEFAULT NULL COMMENT '描述',
                               `sort_value` int DEFAULT NULL COMMENT '排序',
                               `id` bigint NOT NULL AUTO_INCREMENT,
                               `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                               `created_by` bigint DEFAULT NULL COMMENT '创建人ID',
                               `update_time` datetime DEFAULT NULL COMMENT '最后修改时间',
                               `updated_by` bigint DEFAULT NULL COMMENT '最后修改人ID',
                               `version` int DEFAULT '0' COMMENT '乐观锁',
                               `describe_` varchar(255) DEFAULT NULL COMMENT '描述',
                               `deleted` tinyint DEFAULT '0' COMMENT '逻辑删除字段',
                               PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1645607080020672514 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC COMMENT='字典项';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_dict_item`
--

INSERT INTO `sys_dict_item` (`dict_id`, `name`, `value`, `describe`, `sort_value`, `id`, `create_time`, `created_by`, `update_time`, `updated_by`, `version`, `describe_`, `deleted`) VALUES (1645607079798374400,'运行','RUNNING',NULL,1,1645607080020672512,'2023-04-11 09:57:56',0,'2023-04-11 09:57:56',0,0,'设备正在运行',0),(1645607079798374400,'停止','WAITING',NULL,2,1645607080020672513,'2023-04-11 09:57:56',0,'2023-04-11 09:57:56',0,0,'设备已停止',0);

--
-- Table structure for table `sys_file`
--

DROP TABLE IF EXISTS `sys_file`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_file` (
                          `biz_type` varchar(255) DEFAULT NULL COMMENT '业务类型',
                          `bucket` varchar(255) DEFAULT NULL COMMENT '桶',
                          `storage_type` varchar(255) DEFAULT NULL COMMENT '存储类型',
                          `path` varchar(255) DEFAULT NULL COMMENT '文件相对地址',
                          `url` varchar(255) DEFAULT NULL COMMENT '文件访问地址',
                          `unique_file_name` varchar(255) DEFAULT NULL COMMENT '唯一文件名',
                          `original_file_name` varchar(255) DEFAULT NULL COMMENT '原始文件名',
                          `file_type` varchar(255) DEFAULT NULL COMMENT '文件类型',
                          `content_type` varchar(255) DEFAULT NULL COMMENT '内容类型',
                          `suffix` varchar(50) DEFAULT NULL COMMENT '后缀',
                          `size` bigint DEFAULT NULL COMMENT '文件大小',
                          `id` bigint NOT NULL AUTO_INCREMENT,
                          `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                          `created_by` bigint DEFAULT NULL COMMENT '创建人ID',
                          `update_time` datetime DEFAULT NULL COMMENT '最后修改时间',
                          `updated_by` bigint DEFAULT NULL COMMENT '最后修改人ID',
                          `version` int DEFAULT '0' COMMENT '乐观锁',
                          `deleted` tinyint DEFAULT '0' COMMENT '逻辑删除字段',
                          PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC COMMENT='系统文件';
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
                               `state` varchar(10) DEFAULT NULL COMMENT '状态',
                               `account` varchar(64) DEFAULT NULL COMMENT '账号',
                               `comments` varchar(255) DEFAULT NULL COMMENT '备注',
                               `os` varchar(50) DEFAULT NULL COMMENT '操作系统',
                               `device` varchar(50) DEFAULT NULL COMMENT '设备名称',
                               `browser` varchar(50) DEFAULT NULL COMMENT '浏览器类型',
                               `ip` varchar(50) DEFAULT NULL COMMENT 'ip地址',
                               `ip_region` varchar(255) DEFAULT NULL COMMENT 'ip所在地区',
                               `id` bigint DEFAULT NULL,
                               `create_time` datetime DEFAULT NULL,
                               `created_by` bigint DEFAULT NULL COMMENT '创建人'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC COMMENT='登录日志';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_login_log`
--

INSERT INTO `sys_login_log` (`state`, `account`, `comments`, `os`, `device`, `browser`, `ip`, `ip_region`, `id`, `create_time`, `created_by`) VALUES ('SUCCESS','zetaAdmin','登录成功','Mac','OSX','Chrome','127.0.0.1','0|0|0|内网IP|内网IP',33814407208000111,'2024-04-27 21:54:27',1645607078095486976);

--
-- Table structure for table `sys_menu`
--

DROP TABLE IF EXISTS `sys_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_menu` (
                          `name` varchar(255) DEFAULT NULL COMMENT '路由名称',
                          `path` varchar(255) DEFAULT NULL COMMENT '路由地址',
                          `component` varchar(255) DEFAULT NULL COMMENT '组件地址',
                          `redirect` varchar(255) DEFAULT NULL COMMENT '重定向地址',
                          `icon` varchar(255) DEFAULT NULL COMMENT '图标',
                          `authority` varchar(255) DEFAULT NULL COMMENT '权限标识',
                          `type` varchar(32) DEFAULT NULL COMMENT '菜单类型',
                          `hide` tinyint(1) DEFAULT NULL COMMENT '是否隐藏 0否 1是',
                          `keep_alive` tinyint(1) DEFAULT NULL COMMENT '是否缓存 0否 1是',
                          `href` varchar(255) DEFAULT NULL COMMENT '外链地址',
                          `frame_src` varchar(255) DEFAULT NULL COMMENT '内链地址',
                          `label` varchar(255) DEFAULT NULL,
                          `parent_id` bigint DEFAULT NULL,
                          `sort_value` int DEFAULT NULL,
                          `children` varchar(255) DEFAULT NULL,
                          `id` bigint NOT NULL AUTO_INCREMENT,
                          `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                          `created_by` bigint DEFAULT NULL COMMENT '创建人ID',
                          `update_time` datetime DEFAULT NULL COMMENT '最后修改时间',
                          `updated_by` bigint DEFAULT NULL COMMENT '最后修改人ID',
                          `version` int DEFAULT '0' COMMENT '乐观锁',
                          `deleted` tinyint DEFAULT '0' COMMENT '逻辑删除字段',
                          PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1645607074257698820 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC COMMENT='菜单';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_menu`
--

INSERT INTO `sys_menu` (`name`, `path`, `component`, `redirect`, `icon`, `authority`, `type`, `hide`, `keep_alive`, `href`, `frame_src`, `label`, `parent_id`, `sort_value`, `children`, `id`, `create_time`, `created_by`, `update_time`, `updated_by`, `version`, `deleted`) VALUES ('system','/system','dashboard/workbench/index',NULL,'ant-design:setting-filled','','MENU',0,0,NULL,NULL,'系统管理',0,1,NULL,1645607074249310208,'2023-04-11 09:57:55',0,'2024-01-08 16:18:18',1645607078095486976,0,0),('system_user','/system/user','system/user/index',NULL,'ant-design:user-outlined','','MENU',0,0,NULL,NULL,'用户管理',1645607074249310208,1,NULL,1645607074253504512,'2023-04-11 09:57:55',0,'2024-01-08 20:52:20',1645607078095486976,0,0),(NULL,'','',NULL,'ant-design:aliwangwang-filled','sys:user:view','RESOURCE',0,0,'','','查看用户',1645607074253504512,1,NULL,1645607074253504513,'2023-04-11 09:57:55',0,'2024-01-08 15:17:57',1645607078095486976,0,0),(NULL,NULL,NULL,NULL,NULL,'sys:user:save','RESOURCE',0,0,NULL,NULL,'新增用户',1645607074253504512,2,NULL,1645607074253504514,'2023-04-11 09:57:55',0,'2023-04-11 09:57:55',0,0,0),(NULL,NULL,NULL,NULL,NULL,'sys:user:update','RESOURCE',0,0,NULL,NULL,'修改用户',1645607074253504512,3,NULL,1645607074253504515,'2023-04-11 09:57:55',0,'2023-04-11 09:57:55',0,0,0),(NULL,NULL,NULL,NULL,NULL,'sys:user:delete','RESOURCE',0,0,NULL,NULL,'删除用户',1645607074253504512,4,NULL,1645607074253504516,'2023-04-11 09:57:55',0,'2023-04-11 09:57:55',0,0,0),('system_role','/system/role','system/role/index',NULL,'ant-design:user-switch-outlined','','MENU',0,0,NULL,NULL,'角色管理',1645607074249310208,2,NULL,1645607074253504517,'2023-04-11 09:57:55',0,'2024-01-08 20:54:00',1645607078095486976,0,0),(NULL,NULL,NULL,NULL,NULL,'sys:role:view','RESOURCE',0,0,NULL,NULL,'查看角色',1645607074253504517,1,NULL,1645607074253504518,'2023-04-11 09:57:55',0,'2023-04-11 09:57:55',0,0,0),(NULL,NULL,NULL,NULL,NULL,'sys:role:save','RESOURCE',0,0,NULL,NULL,'新增角色',1645607074253504517,2,NULL,1645607074253504519,'2023-04-11 09:57:55',0,'2023-04-11 09:57:55',0,0,0),(NULL,NULL,NULL,NULL,NULL,'sys:role:update','RESOURCE',0,0,NULL,NULL,'修改角色',1645607074253504517,3,NULL,1645607074253504520,'2023-04-11 09:57:55',0,'2023-04-11 09:57:55',0,0,0),(NULL,NULL,NULL,NULL,NULL,'sys:role:delete','RESOURCE',0,0,NULL,NULL,'删除角色',1645607074253504517,4,NULL,1645607074253504521,'2023-04-11 09:57:55',0,'2023-04-11 09:57:55',0,0,0),('system_menu','/system/menu','system/menu/index',NULL,'ant-design:apartment-outlined','','MENU',0,0,NULL,NULL,'菜单管理',1645607074249310208,3,NULL,1645607074253504522,'2023-04-11 09:57:55',0,'2024-01-08 16:18:37',1645607078095486976,0,0),(NULL,NULL,NULL,NULL,NULL,'sys:menu:view','RESOURCE',0,0,NULL,NULL,'查看菜单',1645607074253504522,1,NULL,1645607074253504523,'2023-04-11 09:57:55',0,'2023-04-11 09:57:55',0,0,0),(NULL,NULL,NULL,NULL,NULL,'sys:menu:save','RESOURCE',0,0,NULL,NULL,'新增菜单',1645607074253504522,2,NULL,1645607074253504524,'2023-04-11 09:57:55',0,'2023-04-11 09:57:55',0,0,0),(NULL,NULL,NULL,NULL,NULL,'sys:menu:update','RESOURCE',0,0,NULL,NULL,'修改菜单',1645607074253504522,3,NULL,1645607074253504525,'2023-04-11 09:57:55',0,'2023-04-11 09:57:55',0,0,0),(NULL,NULL,NULL,NULL,NULL,'sys:menu:delete','RESOURCE',0,0,NULL,NULL,'删除菜单',1645607074253504522,4,NULL,1645607074253504526,'2023-04-11 09:57:55',0,'2023-04-11 09:57:55',0,0,0),('system_optLog','/system/optLog','system/opt-log/index',NULL,'ant-design:align-left-outlined','','MENU',0,0,NULL,NULL,'操作日志',1645607074249310208,4,NULL,1645607074253504527,'2023-04-11 09:57:55',0,'2024-01-08 20:55:02',1645607078095486976,0,0),(NULL,NULL,NULL,NULL,NULL,'sys:optLog:view','RESOURCE',0,0,NULL,NULL,'查看操作日志',1645607074253504527,1,NULL,1645607074253504528,'2023-04-11 09:57:55',0,'2023-04-11 09:57:55',0,0,0),('system_loginLog','/system/loginLog','system/login-log/index',NULL,'ant-design:align-left-outlined','','MENU',0,0,NULL,NULL,'登录日志',1645607074249310208,5,NULL,1645607074253504529,'2023-04-11 09:57:55',0,'2024-01-08 20:55:14',1645607078095486976,0,0),(NULL,NULL,NULL,NULL,NULL,'sys:loginLog:view','RESOURCE',0,0,NULL,NULL,'查看登录日志',1645607074253504529,1,NULL,1645607074253504530,'2023-04-11 09:57:55',0,'2023-04-11 09:57:55',0,0,0),('system_file','/system/file','system/file/index',NULL,'ant-design:file-done-outlined','','MENU',0,0,NULL,NULL,'文件管理',1645607074249310208,6,NULL,1645607074253504531,'2023-04-11 09:57:55',0,'2024-01-08 20:55:29',1645607078095486976,0,0),(NULL,NULL,NULL,NULL,NULL,'sys:file:view','RESOURCE',0,0,NULL,NULL,'查看文件',1645607074253504531,1,NULL,1645607074253504532,'2023-04-11 09:57:55',0,'2023-04-11 09:57:55',0,0,0),(NULL,NULL,NULL,NULL,NULL,'sys:file:save','RESOURCE',0,0,NULL,NULL,'上传文件',1645607074253504531,2,NULL,1645607074253504533,'2023-04-11 09:57:55',0,'2023-04-11 09:57:55',0,0,0),(NULL,NULL,NULL,NULL,NULL,'sys:file:export','RESOURCE',0,0,NULL,NULL,'下载文件',1645607074253504531,3,NULL,1645607074253504534,'2023-04-11 09:57:55',0,'2023-04-11 09:57:55',0,0,0),(NULL,NULL,NULL,NULL,NULL,'sys:file:delete','RESOURCE',0,0,NULL,NULL,'删除文件',1645607074253504531,4,NULL,1645607074253504535,'2023-04-11 09:57:55',0,'2023-04-11 09:57:55',0,0,0),('system_dict','/system/dict','system/dict/index',NULL,'ant-design:container-outlined','','MENU',0,0,NULL,NULL,'数据字典',1645607074249310208,7,NULL,1645607074253504536,'2023-04-11 09:57:55',0,'2024-01-08 20:56:22',1645607078095486976,0,0),(NULL,NULL,NULL,NULL,NULL,'sys:dict:view','RESOURCE',0,0,NULL,NULL,'查看字典',1645607074253504536,1,NULL,1645607074253504537,'2023-04-11 09:57:55',0,'2023-04-11 09:57:55',0,0,0),(NULL,NULL,NULL,NULL,NULL,'sys:dict:save','RESOURCE',0,0,NULL,NULL,'新增字典',1645607074253504536,2,NULL,1645607074253504538,'2023-04-11 09:57:55',0,'2023-04-11 09:57:55',0,0,0),(NULL,NULL,NULL,NULL,NULL,'sys:dict:update','RESOURCE',0,0,NULL,NULL,'修改字典',1645607074253504536,3,NULL,1645607074253504539,'2023-04-11 09:57:55',0,'2023-04-11 09:57:55',0,0,0),(NULL,NULL,NULL,NULL,NULL,'sys:dict:delete','RESOURCE',0,0,NULL,NULL,'删除字典',1645607074253504536,4,NULL,1645607074253504540,'2023-04-11 09:57:55',0,'2023-04-11 09:57:55',0,0,0),(NULL,NULL,NULL,NULL,NULL,'sys:dictItem:view','RESOURCE',0,0,NULL,NULL,'查看字典项',1645607074253504536,5,NULL,1645607074257698816,'2023-04-11 09:57:55',0,'2023-04-11 09:57:55',0,0,0),(NULL,NULL,NULL,NULL,NULL,'sys:dictItem:save','RESOURCE',0,0,NULL,NULL,'新增字典项',1645607074253504536,6,NULL,1645607074257698817,'2023-04-11 09:57:55',0,'2023-04-11 09:57:55',0,0,0),(NULL,NULL,NULL,NULL,NULL,'sys:dictItem:update','RESOURCE',0,0,NULL,NULL,'修改字典项',1645607074253504536,7,NULL,1645607074257698818,'2023-04-11 09:57:55',0,'2023-04-11 09:57:55',0,0,0),(NULL,'','',NULL,'','sys:dictItem:delete','RESOURCE',0,0,'','','删除字典项',1645607074253504536,8,NULL,1645607074257698819,'2023-04-11 09:57:55',0,'2024-03-31 21:18:01',1645607078095486976,2,0);

--
-- Table structure for table `sys_opt_log`
--

DROP TABLE IF EXISTS `sys_opt_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_opt_log` (
                             `type` varchar(10) DEFAULT NULL COMMENT '操作类型',
                             `description` varchar(255) DEFAULT NULL COMMENT '操作描述',
                             `url` varchar(255) DEFAULT NULL COMMENT '请求地址',
                             `http_method` varchar(10) DEFAULT NULL COMMENT '请求方式',
                             `class_path` varchar(255) DEFAULT NULL COMMENT '类路径',
                             `params` longtext COMMENT '请求参数',
                             `result` longtext COMMENT '返回值',
                             `exception` longtext COMMENT '异常描述',
                             `spend_time` int DEFAULT NULL COMMENT '消耗时间 单位毫秒',
                             `os` varchar(50) DEFAULT NULL COMMENT '操作系统',
                             `device` varchar(50) DEFAULT NULL COMMENT '设备名称',
                             `browser` varchar(50) DEFAULT NULL COMMENT '浏览器类型',
                             `ip` varchar(50) DEFAULT NULL COMMENT 'ip地址',
                             `ip_region` varchar(255) DEFAULT NULL COMMENT 'ip所在地区',
                             `user_name` varchar(50) DEFAULT NULL COMMENT '操作人',
                             `id` bigint DEFAULT NULL,
                             `create_time` datetime DEFAULT NULL,
                             `created_by` bigint DEFAULT NULL COMMENT '创建人'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC COMMENT='操作日志';
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
                          `name` varchar(32) DEFAULT NULL COMMENT '角色名',
                          `code` varchar(32) DEFAULT NULL COMMENT '角色编码',
                          `describe` varchar(255) DEFAULT NULL COMMENT '描述',
                          `readonly` tinyint(1) DEFAULT NULL COMMENT '是否内置 0否 1是',
                          `id` bigint NOT NULL AUTO_INCREMENT,
                          `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                          `created_by` bigint DEFAULT NULL COMMENT '创建人ID',
                          `update_time` datetime DEFAULT NULL COMMENT '最后修改时间',
                          `updated_by` bigint DEFAULT NULL COMMENT '最后修改人ID',
                          `version` int DEFAULT '0' COMMENT '乐观锁',
                          `describe_` varchar(255) DEFAULT NULL COMMENT '描述',
                          `deleted` tinyint DEFAULT '0' COMMENT '逻辑删除字段',
                          `readonly_` bit(1) NOT NULL DEFAULT b'0' COMMENT '内置',
                          PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1645607076937859075 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC COMMENT='角色';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_role`
--

INSERT INTO `sys_role` (`name`, `code`, `describe`, `readonly`, `id`, `create_time`, `created_by`, `update_time`, `updated_by`, `version`, `describe_`, `deleted`, `readonly_`) VALUES ('超级管理员','SUPER_ADMIN',NULL,NULL,1645607076937859072,'2023-04-11 09:57:56',0,'2023-04-11 09:57:56',0,0,'超级管理员，拥有至高无上的权利',0,_binary ''),('管理员','ADMIN',NULL,NULL,1645607076937859073,'2023-04-11 09:57:56',0,'2023-04-11 09:57:56',0,0,'管理员，拥有99%的权利',0,_binary '\0'),('普通用户','USER',NULL,NULL,1645607076937859074,'2023-04-11 09:57:56',0,'2023-04-11 09:57:56',0,0,'普通用户，拥有管理员赋予的权利',0,_binary '\0');

--
-- Table structure for table `sys_role_menu`
--

DROP TABLE IF EXISTS `sys_role_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_role_menu` (
                               `role_id` bigint DEFAULT NULL COMMENT '角色id',
                               `menu_id` bigint DEFAULT NULL COMMENT '菜单id',
                               `id` bigint NOT NULL AUTO_INCREMENT,
                               `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                               `created_by` bigint DEFAULT NULL COMMENT '创建人ID',
                               `update_time` datetime DEFAULT NULL COMMENT '最后修改时间',
                               `updated_by` bigint DEFAULT NULL COMMENT '最后修改人ID',
                               `version` int DEFAULT '0' COMMENT '乐观锁',
                               `deleted` tinyint DEFAULT '0' COMMENT '逻辑删除字段',
                               PRIMARY KEY (`id`) USING BTREE,
                               KEY `auto_idx_role_id` (`role_id`),
                               KEY `auto_idx_menu_id` (`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1645607077315346435 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC COMMENT='角色菜单';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_role_menu`
--

INSERT INTO `sys_role_menu` (`role_id`, `menu_id`, `id`, `create_time`, `created_by`, `update_time`, `updated_by`, `version`, `deleted`) VALUES (1645607076937859072,1645607074249310208,1645607077265014784,'2023-04-11 09:57:56',0,NULL,NULL,NULL,0),(1645607076937859072,1645607074253504512,1645607077269209088,'2023-04-11 09:57:56',0,NULL,NULL,NULL,0),(1645607076937859072,1645607074253504513,1645607077269209089,'2023-04-11 09:57:56',0,NULL,NULL,NULL,0),(1645607076937859072,1645607074253504514,1645607077273403392,'2023-04-11 09:57:56',0,NULL,NULL,NULL,0),(1645607076937859072,1645607074253504515,1645607077273403393,'2023-04-11 09:57:56',0,NULL,NULL,NULL,0),(1645607076937859072,1645607074253504516,1645607077277597696,'2023-04-11 09:57:56',0,NULL,NULL,NULL,0),(1645607076937859072,1645607074253504517,1645607077277597697,'2023-04-11 09:57:56',0,NULL,NULL,NULL,0),(1645607076937859072,1645607074253504518,1645607077281792000,'2023-04-11 09:57:56',0,NULL,NULL,NULL,0),(1645607076937859072,1645607074253504519,1645607077281792001,'2023-04-11 09:57:56',0,NULL,NULL,NULL,0),(1645607076937859072,1645607074253504520,1645607077281792002,'2023-04-11 09:57:56',0,NULL,NULL,NULL,0),(1645607076937859072,1645607074253504521,1645607077281792003,'2023-04-11 09:57:56',0,NULL,NULL,NULL,0),(1645607076937859072,1645607074253504522,1645607077285986304,'2023-04-11 09:57:56',0,NULL,NULL,NULL,0),(1645607076937859072,1645607074253504523,1645607077285986305,'2023-04-11 09:57:56',0,NULL,NULL,NULL,0),(1645607076937859072,1645607074253504524,1645607077285986306,'2023-04-11 09:57:56',0,NULL,NULL,NULL,0),(1645607076937859072,1645607074253504525,1645607077290180608,'2023-04-11 09:57:56',0,NULL,NULL,NULL,0),(1645607076937859072,1645607074253504526,1645607077290180609,'2023-04-11 09:57:56',0,NULL,NULL,NULL,0),(1645607076937859072,1645607074253504527,1645607077294374912,'2023-04-11 09:57:56',0,NULL,NULL,NULL,0),(1645607076937859072,1645607074253504528,1645607077294374913,'2023-04-11 09:57:56',0,NULL,NULL,NULL,0),(1645607076937859072,1645607074253504529,1645607077294374914,'2023-04-11 09:57:56',0,NULL,NULL,0,0),(1645607076937859072,1645607074253504530,1645607077298569216,'2023-04-11 09:57:56',0,NULL,NULL,0,0),(1645607076937859072,1645607074253504531,1645607077298569217,'2023-04-11 09:57:56',0,NULL,NULL,0,0),(1645607076937859072,1645607074253504532,1645607077298569218,'2023-04-11 09:57:56',0,NULL,NULL,0,0),(1645607076937859072,1645607074253504533,1645607077298569219,'2023-04-11 09:57:56',0,NULL,NULL,0,0),(1645607076937859072,1645607074253504534,1645607077302763520,'2023-04-11 09:57:56',0,NULL,NULL,0,0),(1645607076937859072,1645607074253504535,1645607077302763521,'2023-04-11 09:57:56',0,NULL,NULL,0,0),(1645607076937859072,1645607074253504536,1645607077306957824,'2023-04-11 09:57:56',0,NULL,NULL,0,0),(1645607076937859072,1645607074253504537,1645607077306957825,'2023-04-11 09:57:56',0,NULL,NULL,0,0),(1645607076937859072,1645607074253504538,1645607077306957826,'2023-04-11 09:57:56',0,NULL,NULL,0,0),(1645607076937859072,1645607074253504539,1645607077311152128,'2023-04-11 09:57:56',0,NULL,NULL,0,0),(1645607076937859072,1645607074253504540,1645607077311152129,'2023-04-11 09:57:56',0,NULL,NULL,0,0),(1645607076937859072,1645607074257698816,1645607077311152130,'2023-04-11 09:57:56',0,NULL,NULL,0,0),(1645607076937859072,1645607074257698817,1645607077315346432,'2023-04-11 09:57:56',0,NULL,NULL,0,0),(1645607076937859072,1645607074257698818,1645607077315346433,'2023-04-11 09:57:56',0,NULL,NULL,0,0),(1645607076937859072,1645607074257698819,1645607077315346434,'2023-04-11 09:57:56',0,NULL,NULL,0,0);

--
-- Table structure for table `sys_user`
--

DROP TABLE IF EXISTS `sys_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_user` (
                          `username` varchar(32) DEFAULT NULL COMMENT '用户名',
                          `account` varchar(64) DEFAULT NULL COMMENT '账号',
                          `password` varchar(64) DEFAULT NULL COMMENT '密码',
                          `email` varchar(32) DEFAULT NULL COMMENT '邮箱',
                          `mobile` varchar(20) DEFAULT NULL COMMENT '手机号',
                          `sex` tinyint(1) DEFAULT '0',
                          `avatar` varchar(255) DEFAULT NULL COMMENT '头像',
                          `birthday` date DEFAULT NULL COMMENT '生日',
                          `readonly` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否内置 0否 1是',
                          `test` tinyint NOT NULL DEFAULT '0',
                          `test1` tinyint NOT NULL DEFAULT '0',
                          `state` int NOT NULL DEFAULT '0' COMMENT '状态',
                          `id` bigint NOT NULL AUTO_INCREMENT,
                          `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                          `created_by` bigint DEFAULT NULL COMMENT '创建人ID',
                          `update_time` datetime DEFAULT NULL COMMENT '最后修改时间',
                          `updated_by` bigint DEFAULT NULL COMMENT '最后修改人ID',
                          `version` int DEFAULT '0' COMMENT '乐观锁',
                          `readonly_` bit(1) NOT NULL DEFAULT b'0' COMMENT '内置',
                          `deleted` tinyint DEFAULT '0' COMMENT '逻辑删除字段',
                          PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1645607078095486977 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC COMMENT='用户表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_user`
--

INSERT INTO `sys_user` (`username`, `account`, `password`, `email`, `mobile`, `sex`, `avatar`, `birthday`, `readonly`, `test`, `test1`, `state`, `id`, `create_time`, `created_by`, `update_time`, `updated_by`, `version`, `readonly_`, `deleted`) VALUES ('zeta管理员','zetaAdmin','$2a$10$M8Q6189WcePNJ7d50FvOKOdCtcyy0hxyFKL6z8jxmhyvkLHIP8ZBC',NULL,NULL,1,NULL,NULL,0,0,0,1,1645607078095486976,'2023-04-11 09:57:56',0,'2023-04-11 09:57:56',0,0,_binary '',0);

--
-- Table structure for table `sys_user_role`
--

DROP TABLE IF EXISTS `sys_user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_user_role` (
                               `user_id` bigint DEFAULT NULL COMMENT '用户id',
                               `role_id` bigint DEFAULT NULL COMMENT '角色id',
                               `id` bigint NOT NULL AUTO_INCREMENT,
                               `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                               `created_by` bigint DEFAULT NULL COMMENT '创建人ID',
                               `update_time` datetime DEFAULT NULL COMMENT '最后修改时间',
                               `updated_by` bigint DEFAULT NULL COMMENT '最后修改人ID',
                               `version` int DEFAULT '0' COMMENT '乐观锁',
                               `deleted` tinyint DEFAULT '0' COMMENT '逻辑删除字段',
                               PRIMARY KEY (`id`) USING BTREE,
                               KEY `auto_idx_user_id` (`user_id`),
                               KEY `auto_idx_role_id` (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1645607079659962369 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC COMMENT='用户角色';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_user_role`
--

INSERT INTO `sys_user_role` (`user_id`, `role_id`, `id`, `create_time`, `created_by`, `update_time`, `updated_by`, `version`, `deleted`) VALUES (1645607078095486976,1645607076937859072,1645607079659962368,'2023-04-11 09:57:56',0,NULL,NULL,0,0);
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-04-27 22:15:37
