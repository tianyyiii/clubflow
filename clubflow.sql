/*
 Navicat Premium Data Transfer

 Source Server         : 羊的连接
 Source Server Type    : MySQL
 Source Server Version : 50735
 Source Host           : localhost:3306
 Source Schema         : clubflow

 Target Server Type    : MySQL
 Target Server Version : 50735
 File Encoding         : 65001

 Date: 05/01/2023 04:12:10
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(80) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `passwd` varchar(80) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `role` int(11) NULL DEFAULT NULL,
  `state` int(11) NULL DEFAULT NULL,
  `image` varchar(2000) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `Role_idx`(`role`) USING BTREE,
  CONSTRAINT `Role` FOREIGN KEY (`role`) REFERENCES `role` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES (1, 'geyuan', 'geyuan', 1, 1, '1');
INSERT INTO `account` VALUES (2, 'guitarclub', 'guitarclub', 2, 1, 'http://localhost:8080/file/ce42cs.png');
INSERT INTO `account` VALUES (3, 'geyuanyuan', 'geyuanyuan', 3, 1, '1');
INSERT INTO `account` VALUES (5, 'userr', 'user', 1, 1, NULL);
INSERT INTO `account` VALUES (8, 'yyang', 'yyang', 2, 1, 'http://localhost:8080/file/index_img_2.png');

-- ----------------------------
-- Table structure for club
-- ----------------------------
DROP TABLE IF EXISTS `club`;
CREATE TABLE `club`  (
  `clubId` int(11) NOT NULL AUTO_INCREMENT,
  `clubName` varchar(80) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `clubInfo` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
  `createDate` datetime NULL DEFAULT NULL,
  `creator` int(11) NULL DEFAULT NULL,
  `state` int(11) NULL DEFAULT NULL,
  `image` varchar(2000) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `publicationsNum` int(11) NULL DEFAULT NULL,
  `fansNum` int(11) NULL DEFAULT NULL,
  `commentsNum` int(11) NULL DEFAULT NULL,
  `announcement` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
  PRIMARY KEY (`clubId`) USING BTREE,
  INDEX `ClubCreator_idx`(`creator`) USING BTREE,
  INDEX `ClubProfile_idx`(`image`) USING BTREE,
  CONSTRAINT `ClubCreator` FOREIGN KEY (`creator`) REFERENCES `account` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of club
-- ----------------------------
INSERT INTO `club` VALUES (1, 'guitar club', 'playing guitar', '2015-12-20 10:01:00', 2, 1, 'http://localhost:8080/file/index_img_2.png', 2, 2, 0, '吉他协会的介绍。简要介绍民谣吉他(steel-string acoustic guitar,即原声钢弦吉他之意)，是种弹拨乐器，形状与提琴相似，通常有六根弦。最早是美国西部乡村音乐的伴奏乐器。通常作为歌曲的伴奏形式出现，以美国西部乡村音乐为主要演奏题材。');
INSERT INTO `club` VALUES (2, 'appp', 'a club', '2022-12-21 18:41:07', 3, 1, '1', 0, 0, 0, NULL);
INSERT INTO `club` VALUES (3, 'apppp', 'a club', '2022-12-21 23:08:07', 2, 1, '1', 1, 0, 0, NULL);
INSERT INTO `club` VALUES (4, 'ab', 'a club', '2022-12-22 16:45:11', 1, 1, '1', 0, 0, 0, NULL);
INSERT INTO `club` VALUES (5, 'abb', 'a club', '2022-12-22 16:52:23', 1, 1, '1', 0, 0, 0, NULL);
INSERT INTO `club` VALUES (6, 'movie', 'this is a club for movies', '2022-12-23 16:10:02', 3, 1, '1', 0, 0, 0, NULL);
INSERT INTO `club` VALUES (11, '象棋', '来玩', '2022-12-31 17:20:19', 8, 1, 'http://localhost:8080/file/9m6jc7jpeg', 0, 0, 0, 'dsfrgghhj');

-- ----------------------------
-- Table structure for clubfan
-- ----------------------------
DROP TABLE IF EXISTS `clubfan`;
CREATE TABLE `clubfan`  (
  `clubid` int(11) NOT NULL,
  `fanid` int(11) NOT NULL,
  `joinDate` datetime NULL DEFAULT NULL,
  `state` tinyint(4) NULL DEFAULT NULL,
  PRIMARY KEY (`clubid`, `fanid`) USING BTREE,
  INDEX `ClubFan_idx`(`fanid`) USING BTREE,
  CONSTRAINT `ClubFan` FOREIGN KEY (`fanid`) REFERENCES `account` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FanClub` FOREIGN KEY (`clubid`) REFERENCES `club` (`clubId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of clubfan
-- ----------------------------
INSERT INTO `clubfan` VALUES (1, 3, '2015-12-20 10:01:00', 1);
INSERT INTO `clubfan` VALUES (1, 8, '2023-01-01 16:44:10', 1);

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `commentId` int(11) NOT NULL AUTO_INCREMENT,
  `commenter` int(11) NULL DEFAULT NULL,
  `post` int(11) NULL DEFAULT NULL,
  `context` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
  `commentDate` datetime NULL DEFAULT NULL,
  `thumbs` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`commentId`) USING BTREE,
  INDEX `Commentor_idx`(`commenter`) USING BTREE,
  INDEX `CommentedPost_idx`(`post`) USING BTREE,
  CONSTRAINT `CommentedPost` FOREIGN KEY (`post`) REFERENCES `post` (`postId`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `Commentor` FOREIGN KEY (`commenter`) REFERENCES `account` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES (1, 3, 1, 'great!', '2015-12-20 10:01:00', 1);
INSERT INTO `comment` VALUES (2, 3, 6, '好看的图片！', '2023-01-04 20:42:57', 0);
INSERT INTO `comment` VALUES (3, 3, 6, '成功！', '2023-01-04 20:52:33', 0);
INSERT INTO `comment` VALUES (4, 3, 6, '测试评论样例', '2023-01-05 03:28:05', 1);

-- ----------------------------
-- Table structure for commnetthumb
-- ----------------------------
DROP TABLE IF EXISTS `commnetthumb`;
CREATE TABLE `commnetthumb`  (
  `commnetId` int(11) NOT NULL,
  `thumberId` int(11) NOT NULL,
  `lastThumbDate` datetime NULL DEFAULT NULL,
  `state` tinyint(4) NULL DEFAULT NULL,
  PRIMARY KEY (`commnetId`, `thumberId`) USING BTREE,
  INDEX `CommentThumber_idx`(`thumberId`) USING BTREE,
  CONSTRAINT `CommentThumber` FOREIGN KEY (`thumberId`) REFERENCES `account` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `ThumbedComment` FOREIGN KEY (`commnetId`) REFERENCES `comment` (`commentId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of commnetthumb
-- ----------------------------
INSERT INTO `commnetthumb` VALUES (1, 2, '2015-12-20 10:01:00', 1);
INSERT INTO `commnetthumb` VALUES (4, 3, '2023-01-05 03:28:38', 1);

-- ----------------------------
-- Table structure for habbit
-- ----------------------------
DROP TABLE IF EXISTS `habbit`;
CREATE TABLE `habbit`  (
  `habbitId` int(11) NOT NULL AUTO_INCREMENT,
  `habbitName` varchar(80) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `habbitInfo` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
  `createDate` datetime NULL DEFAULT NULL,
  `creator` int(11) NULL DEFAULT NULL,
  `state` tinyint(4) NULL DEFAULT NULL,
  `image` varchar(2000) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `publicationNum` int(11) NULL DEFAULT NULL,
  `fansNum` int(11) NULL DEFAULT NULL,
  `commentsNum` int(11) NULL DEFAULT NULL,
  `announcement` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
  PRIMARY KEY (`habbitId`) USING BTREE,
  INDEX `HabbitCreator_idx`(`creator`) USING BTREE,
  INDEX `HabbitProFile_idx`(`image`) USING BTREE,
  CONSTRAINT `HabbitCreator` FOREIGN KEY (`creator`) REFERENCES `account` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of habbit
-- ----------------------------
INSERT INTO `habbit` VALUES (1, 'puzzle habbit', 'solving puzzle', '2015-12-20 10:01:00', 2, 1, '1', 0, 1, 0, '这里是简介信息。简介信息简介信息简介信息简介信息简介信息简介信息简介信息简介信息简介信息简介信息简介信息简介信息简介信息简介信息简介信息简介信息简介信息简介信息简介信息简介信息简介信息简介信息简介信息简介信息简介信息简介信息简介信息简介信息');
INSERT INTO `habbit` VALUES (3, '晨跑小组', 'a habbit', '2022-12-21 17:12:40', 3, 1, '1', 0, 0, 0, NULL);
INSERT INTO `habbit` VALUES (4, 'DOTA', 'a club', '2022-12-21 18:19:01', 3, 1, '1', 0, 0, 0, NULL);
INSERT INTO `habbit` VALUES (5, '车万分组', 'a club', '2022-12-21 18:19:41', 3, 1, '1', 0, 0, 0, NULL);
INSERT INTO `habbit` VALUES (6, '红学', 'a club', '2022-12-21 18:20:42', 3, 1, '1', 0, 0, 0, NULL);
INSERT INTO `habbit` VALUES (7, 'app', 'a club', '2022-12-21 18:21:04', 3, 1, '1', 0, 0, 0, NULL);
INSERT INTO `habbit` VALUES (12, '东方project', '恋恋赛高', '2023-01-04 20:36:52', 3, 1, 'http://localhost:8080/file/iwqpxs.png', 0, 0, 0, '《东方Project》，简称东方，是日本同人游戏社团上海爱丽丝幻乐团所制作的一系列同人游戏、相关作品。它以及其二次创作所构成的覆盖游戏、动画、漫画、音乐、文学等诸多方面的领域。');

-- ----------------------------
-- Table structure for habbitfan
-- ----------------------------
DROP TABLE IF EXISTS `habbitfan`;
CREATE TABLE `habbitfan`  (
  `habbitid` int(11) NOT NULL,
  `fanid` int(11) NOT NULL,
  `joinDate` datetime NULL DEFAULT NULL,
  `state` tinyint(4) NULL DEFAULT NULL,
  PRIMARY KEY (`habbitid`, `fanid`) USING BTREE,
  INDEX `HabbitFan_idx`(`fanid`) USING BTREE,
  CONSTRAINT `FanHabbit` FOREIGN KEY (`habbitid`) REFERENCES `habbit` (`habbitId`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `HabbitFan` FOREIGN KEY (`fanid`) REFERENCES `account` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of habbitfan
-- ----------------------------
INSERT INTO `habbitfan` VALUES (1, 2, '2023-01-04 18:54:40', 1);

-- ----------------------------
-- Table structure for image
-- ----------------------------
DROP TABLE IF EXISTS `image`;
CREATE TABLE `image`  (
  `imageId` int(11) NOT NULL AUTO_INCREMENT,
  `imageSrc` varchar(80) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  PRIMARY KEY (`imageId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of image
-- ----------------------------
INSERT INTO `image` VALUES (1, 'http://localhost:8080/file/index_img_2.png');

-- ----------------------------
-- Table structure for post
-- ----------------------------
DROP TABLE IF EXISTS `post`;
CREATE TABLE `post`  (
  `postId` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(80) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `context` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
  `creator` int(11) NULL DEFAULT NULL,
  `club` int(11) NULL DEFAULT NULL,
  `thumbs` int(11) NULL DEFAULT NULL,
  `createDate` datetime NULL DEFAULT NULL,
  `lastModifyDate` datetime NULL DEFAULT NULL,
  `image` varchar(2000) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  PRIMARY KEY (`postId`) USING BTREE,
  INDEX `PostCreator_idx`(`creator`) USING BTREE,
  INDEX `PostClub_idx`(`club`) USING BTREE,
  CONSTRAINT `PostClub` FOREIGN KEY (`club`) REFERENCES `club` (`clubId`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `PostCreator` FOREIGN KEY (`creator`) REFERENCES `account` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of post
-- ----------------------------
INSERT INTO `post` VALUES (1, 'Play guitar', 'let\'s play guitar', 2, 1, 1, '2015-12-20 10:01:00', '2015-12-20 10:01:00', NULL);
INSERT INTO `post` VALUES (3, NULL, 'this is context for chat-gptt', 2, 3, 1, '2022-12-22 17:25:29', '2022-12-22 17:29:02', NULL);
INSERT INTO `post` VALUES (4, '恋恋世界第一', '<h1>恋恋世界第一</h1><h2>二级标题</h2><p><span class=\"ql-font-monospace\">换个字体</span></p><p><br></p><blockquote>“恋恋世界第一”</blockquote><p><br></p><pre class=\"ql-syntax\" spellcheck=\"false\">printf(\"恋恋世界第一！\");\n</pre><p><br></p><ol><li>直接上图</li></ol><p><br></p><p><span class=\"ql-size-large\">大大大大</span></p><p><br></p><p><br></p><p><img src=\"http://localhost:8080/file/nf8ipc.jpg\"></p><p><br></p><p><br></p><p class=\"ql-indent-1\">第一段：你看，恋恋这么可爱肯定是世界第一。</p>', 8, 1, 0, '2022-12-29 22:19:13', '2022-12-29 22:19:13', 'http://localhost:8080/file/nf8ipc.jpg');
INSERT INTO `post` VALUES (5, '测试', '<p>测试</p>', 8, 1, 0, '2022-12-29 22:24:38', '2022-12-29 22:24:38', '');
INSERT INTO `post` VALUES (6, '测试2', '<p><br></p><p><img src=\"http://localhost:8080/file/2tt6uk.jpg\"></p><p><br></p><h1>大标题</h1>', 8, 1, 0, '2022-12-31 15:46:16', '2022-12-31 15:46:16', 'http://localhost:8080/file/2tt6uk.jpg');

-- ----------------------------
-- Table structure for postimage
-- ----------------------------
DROP TABLE IF EXISTS `postimage`;
CREATE TABLE `postimage`  (
  `postId` int(11) NOT NULL,
  `imageId` int(11) NOT NULL,
  `order` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`postId`, `imageId`) USING BTREE,
  INDEX `PostImage_idx`(`imageId`) USING BTREE,
  CONSTRAINT `ImagePost` FOREIGN KEY (`postId`) REFERENCES `post` (`postId`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `PostImage` FOREIGN KEY (`imageId`) REFERENCES `image` (`imageId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of postimage
-- ----------------------------
INSERT INTO `postimage` VALUES (1, 1, 1);

-- ----------------------------
-- Table structure for postthumb
-- ----------------------------
DROP TABLE IF EXISTS `postthumb`;
CREATE TABLE `postthumb`  (
  `postId` int(11) NOT NULL,
  `thumberId` int(11) NOT NULL,
  `lastThumbDate` datetime NULL DEFAULT NULL,
  `state` tinyint(4) NULL DEFAULT NULL,
  PRIMARY KEY (`postId`, `thumberId`) USING BTREE,
  INDEX `PostThumber_idx`(`thumberId`) USING BTREE,
  CONSTRAINT `PostThumber` FOREIGN KEY (`thumberId`) REFERENCES `account` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `ThumbedPost` FOREIGN KEY (`postId`) REFERENCES `post` (`postId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of postthumb
-- ----------------------------
INSERT INTO `postthumb` VALUES (1, 1, '2015-12-20 10:01:00', 1);
INSERT INTO `postthumb` VALUES (3, 1, '2022-12-22 17:45:35', 1);
INSERT INTO `postthumb` VALUES (4, 8, '2022-12-31 15:44:48', 0);

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, 'administrator');
INSERT INTO `role` VALUES (2, 'official account');
INSERT INTO `role` VALUES (3, 'common user');
INSERT INTO `role` VALUES (4, 'black user');

-- ----------------------------
-- Table structure for subcomment
-- ----------------------------
DROP TABLE IF EXISTS `subcomment`;
CREATE TABLE `subcomment`  (
  `subcommentId` int(11) NOT NULL AUTO_INCREMENT,
  `subcommenter` int(11) NULL DEFAULT NULL,
  `context` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `commentDate` datetime NULL DEFAULT NULL,
  `comment` int(11) NULL DEFAULT NULL,
  `replyWho` int(11) NULL DEFAULT NULL,
  `thumbs` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`subcommentId`) USING BTREE,
  INDEX `Subcommmentor_idx`(`subcommenter`) USING BTREE,
  INDEX `CommentedComment_idx`(`comment`) USING BTREE,
  INDEX `ReplyedUser_idx`(`replyWho`) USING BTREE,
  CONSTRAINT `CommentedComment` FOREIGN KEY (`comment`) REFERENCES `comment` (`commentId`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `ReplyedUser` FOREIGN KEY (`replyWho`) REFERENCES `account` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `Subcommmentor` FOREIGN KEY (`subcommenter`) REFERENCES `account` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of subcomment
-- ----------------------------
INSERT INTO `subcomment` VALUES (1, 2, 'Thank you for your support!', '2015-12-20 10:01:00', 1, 3, 0);
INSERT INTO `subcomment` VALUES (2, 3, '梅西', '2022-12-21 16:32:28', 2, 3, 1);
INSERT INTO `subcomment` VALUES (3, 3, '二级评论', '2023-01-04 21:36:22', 3, 3, 0);
INSERT INTO `subcomment` VALUES (4, 3, '太成功辣', '2023-01-05 03:25:38', 3, 3, 0);
INSERT INTO `subcomment` VALUES (5, 3, '+1', '2023-01-05 03:26:49', 2, 3, 0);

-- ----------------------------
-- Table structure for subcommnetthumb
-- ----------------------------
DROP TABLE IF EXISTS `subcommnetthumb`;
CREATE TABLE `subcommnetthumb`  (
  `subcommmentId` int(11) NOT NULL,
  `thumberId` int(11) NOT NULL,
  `lastThumbDate` datetime NULL DEFAULT NULL,
  `state` tinyint(4) NULL DEFAULT NULL,
  PRIMARY KEY (`subcommmentId`, `thumberId`) USING BTREE,
  INDEX `SubcommentThumber_idx`(`thumberId`) USING BTREE,
  CONSTRAINT `SubcommentThumber` FOREIGN KEY (`thumberId`) REFERENCES `account` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `ThumbedSubcomment` FOREIGN KEY (`subcommmentId`) REFERENCES `subcomment` (`subcommentId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of subcommnetthumb
-- ----------------------------
INSERT INTO `subcommnetthumb` VALUES (2, 3, '2023-01-05 02:29:26', 1);

SET FOREIGN_KEY_CHECKS = 1;
