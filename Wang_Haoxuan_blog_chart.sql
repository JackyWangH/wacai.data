/*
 Navicat Premium Data Transfer

 Source Server         : bmatch.haoxuan
 Source Server Type    : MySQL
 Source Server Version : 50718
 Source Host           : rm-bp1s8wez9j4hw42oemo.mysql.rds.aliyuncs.com:3306
 Source Schema         : dizi-03

 Target Server Type    : MySQL
 Target Server Version : 50718
 File Encoding         : 65001

 Date: 31/07/2019 09:04:27
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for wang_haoxuan_blog_chart
-- ----------------------------
DROP TABLE IF EXISTS `wang_haoxuan_blog_chart`;
CREATE TABLE `wang_haoxuan_blog_chart`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `article_type` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '文章类型',
  `article_title` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '文章标题',
  `article_content` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '文章内容',
  `article_sdTime` datetime(0) NOT NULL COMMENT '文章发表时间',
  `article_count` bigint(30) NOT NULL COMMENT '阅读文章次数',
  `article_from` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '文章来源(原创转载)',
  `article_author` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '文章作者',
  `dz` bigint(255) NULL DEFAULT NULL COMMENT '点赞数',
  `sc` bigint(255) NULL DEFAULT NULL COMMENT '收藏数',
  `Mine` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '我发出的',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 31 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of wang_haoxuan_blog_chart
-- ----------------------------
INSERT INTO `wang_haoxuan_blog_chart` VALUES (1, 'c语言', '认识c语言', 'helloworld', '2019-03-17 15:04:04', 55, '原创', '谭浩强', 500, 234, '');
INSERT INTO `wang_haoxuan_blog_chart` VALUES (2, 'c语言', '了解c语言', '运算符', '2019-03-17 15:09:04', 98, '原创', '谭浩强', 120, 214, '');
INSERT INTO `wang_haoxuan_blog_chart` VALUES (3, 'c语言', '了解c语言', '运算方法', '2019-03-17 15:10:14', 83, '原创', '谭浩强', 421, 344, '');
INSERT INTO `wang_haoxuan_blog_chart` VALUES (4, 'c语言', '学习c语言', '循环', '2019-03-17 15:13:06', 200, '原创', '谭浩强', 42, 344, '');
INSERT INTO `wang_haoxuan_blog_chart` VALUES (5, 'c语言', '学习c语言', '语法', '2019-03-17 15:13:36', 430, '原创', '谭浩强', 422, 34, '');
INSERT INTO `wang_haoxuan_blog_chart` VALUES (6, 'c语言', '学习c语言', '条件语句', '2019-03-17 15:14:13', 430, '原创', '谭浩强', 42, 34, '');
INSERT INTO `wang_haoxuan_blog_chart` VALUES (7, 'c语言', '学习c语言', '数组', '2019-03-17 15:14:23', 430, '原创', '谭浩强', 42, 34, '');
INSERT INTO `wang_haoxuan_blog_chart` VALUES (8, 'c语言', '学习c语言', '指针', '2019-03-17 15:14:27', 430, '原创', '谭浩强', 42, 34, '');
INSERT INTO `wang_haoxuan_blog_chart` VALUES (9, 'c语言', '学习c语言', '链表', '2019-03-17 15:14:34', 430, '原创', '谭浩强', 42, 34, 'Y');
INSERT INTO `wang_haoxuan_blog_chart` VALUES (10, 'c语言', '学习c语言', '文件', '2019-03-17 15:14:39', 430, '原创', '谭浩强', 42, 34, '');
INSERT INTO `wang_haoxuan_blog_chart` VALUES (11, 'c语言', '学习c语言', '文件', '2019-03-17 15:15:01', 120, '原创', '谭浩强', 122, 223, 'Y');
INSERT INTO `wang_haoxuan_blog_chart` VALUES (12, 'c语言', '学习c语言', '坐标', '2019-03-17 15:15:07', 120, '原创', '谭浩强', 122, 223, '');
INSERT INTO `wang_haoxuan_blog_chart` VALUES (13, 'c语言', '学习c语言', '窗口', '2019-03-17 15:15:18', 120, '原创', '谭浩强', 122, 223, 'Y');
INSERT INTO `wang_haoxuan_blog_chart` VALUES (14, 'c语言', '学习c语言', '课程设计', '2019-03-17 15:15:24', 120, '原创', '谭浩强', 122, 223, '');
INSERT INTO `wang_haoxuan_blog_chart` VALUES (15, 'c语言', '学习c语言', '函数', '2019-03-17 15:15:39', 120, '原创', '谭浩强', 122, 223, 'Y');
INSERT INTO `wang_haoxuan_blog_chart` VALUES (16, 'c语言', '学习c语言', '递归', '2019-03-17 15:15:53', 120, '原创', '谭浩强', 98, 256, 'Y');
INSERT INTO `wang_haoxuan_blog_chart` VALUES (17, 'c语言', '学习c语言', '嵌套', '2019-03-17 15:16:00', 120, '原创', '谭浩强', 98, 256, '');
INSERT INTO `wang_haoxuan_blog_chart` VALUES (18, 'c语言', '学习c语言', '枚举', '2019-03-17 15:16:06', 120, '原创', '谭浩强', 98, 256, '');
INSERT INTO `wang_haoxuan_blog_chart` VALUES (19, 'c语言', '学习c语言', '转换', '2019-03-17 15:16:21', 120, '原创', '谭浩强', 98, 256, 'Y');
INSERT INTO `wang_haoxuan_blog_chart` VALUES (20, 'java语言', '学习java语言', '类', '2019-03-17 15:18:12', 90, '原创', '昊斯特曼', 99, 666, '');
INSERT INTO `wang_haoxuan_blog_chart` VALUES (21, 'java语言', '学习java语言', '方法', '2019-03-17 15:18:16', 90, '原创', '昊斯特曼', 99, 666, 'Y');
INSERT INTO `wang_haoxuan_blog_chart` VALUES (22, 'java语言', '学习java语言', '运算符', '2019-03-17 15:18:21', 90, '原创', '昊斯特曼', 99, 666, '');
INSERT INTO `wang_haoxuan_blog_chart` VALUES (23, 'java语言', '学习java语言', '循环', '2019-03-17 15:18:28', 90, '原创', '昊斯特曼', 99, 666, '');
INSERT INTO `wang_haoxuan_blog_chart` VALUES (24, 'java语言', '学习java语言', 'HashMap', '2019-03-17 15:18:37', 90, '原创', '昊斯特曼', 99, 666, 'Y');
INSERT INTO `wang_haoxuan_blog_chart` VALUES (25, 'java语言', '学习java语言', '流', '2019-03-17 15:18:46', 90, '原创', '昊斯特曼', 99, 666, '');
INSERT INTO `wang_haoxuan_blog_chart` VALUES (26, 'java语言', '学习java语言', '异常', '2019-03-17 15:18:51', 90, '原创', '昊斯特曼', 99, 666, '');
INSERT INTO `wang_haoxuan_blog_chart` VALUES (27, 'java语言', '学习java语言', '数组', '2019-03-17 15:18:54', 90, '原创', '昊斯特曼', 99, 666, 'Y');
INSERT INTO `wang_haoxuan_blog_chart` VALUES (28, 'java语言', '学习java语言', '枚举', '2019-03-17 15:19:06', 90, '原创', '昊斯特曼', 99, 666, '');
INSERT INTO `wang_haoxuan_blog_chart` VALUES (29, 'java语言', '学习java语言', '条件语句', '2019-03-17 15:19:49', 90, '原创', '昊斯特曼', 99, 666, 'Y');
INSERT INTO `wang_haoxuan_blog_chart` VALUES (30, 'java语言', '学习java语言', '项目实战', '2019-03-17 15:20:08', 90, '原创', 'Bmatch', 99, 666, '');

SET FOREIGN_KEY_CHECKS = 1;
