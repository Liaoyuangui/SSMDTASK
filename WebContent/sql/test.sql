/*
SQLyog 企业版 - MySQL GUI v8.14 
MySQL - 5.0.22-community-nt : Database - test
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`test` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `test`;

/*Table structure for table `person` */

DROP TABLE IF EXISTS `person`;

CREATE TABLE `person` (
  `id` int(10) NOT NULL auto_increment,
  `name` varchar(50) default NULL,
  `age` varchar(50) default NULL,
  `sex` varchar(50) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `person` */

insert  into `person`(`id`,`name`,`age`,`sex`) values (1,'黄晓明','35','男'),(2,'杨幂','31','女'),(3,'赵丽颖','31','女');

/*Table structure for table `t_comment` */

DROP TABLE IF EXISTS `t_comment`;

CREATE TABLE `t_comment` (
  `id` int(10) NOT NULL auto_increment COMMENT 'id',
  `customer_id` varchar(32) NOT NULL default '' COMMENT '用户id',
  `parent_comment_id` varchar(32) NOT NULL default '' COMMENT '父id,0表示无父级',
  `content_id` varchar(32) NOT NULL default '' COMMENT '文章id',
  `type` int(11) default NULL COMMENT '类型',
  `content` varchar(140) default NULL COMMENT '内容',
  `comment_date` varchar(10) default NULL COMMENT '评论日期',
  `comment_time` varchar(12) default NULL COMMENT '评论时间',
  `state` int(11) default NULL COMMENT '状态',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_comment` */

insert  into `t_comment`(`id`,`customer_id`,`parent_comment_id`,`content_id`,`type`,`content`,`comment_date`,`comment_time`,`state`) values (1,'1','0','1',1,'这把手里剑还是很不错的哦。。。','2014-12-18','23:00:00.000',0),(2,'2','1','1',1,'你用的感觉怎么样啊？？？','2014-12-18','23:01:00.000',0),(3,'3','1','1',1,'飞雷神啊???','2014-12-18','23:02:00.000',0),(4,'1','2','1',1,'用的很不错啊!!!','2014-12-18','23:03:00.000',0),(5,'2','0','1',1,'这把手里剑哪来的','2014-12-19','23:00:00.000',0),(6,'3','5','1',1,'哪来的，哪来的？？？','2014-12-19','23:01:00.000',0),(7,'2','0','2',1,'我怎么知道！','2018-03-27','04:12:37',0),(8,'1','0','2',1,'晴天！','2018-03-27','04:16:13',0),(9,'1','7','2',1,'不知道...','2018-03-27','05:02:18',0),(10,'3','9','2',1,'我知道就是不告诉你','2018-03-27','05:04:49',0),(11,'2','10','2',1,'为什么不说啊','2018-03-27','05:07:11',0),(12,'1','11','2',1,'她跟我调皮呢...','2018-03-27','05:10:22',0);

/*Table structure for table `t_customer` */

DROP TABLE IF EXISTS `t_customer`;

CREATE TABLE `t_customer` (
  `id` varchar(32) NOT NULL,
  `nick_name` varchar(50) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_customer` */

insert  into `t_customer`(`id`,`nick_name`) values ('1','宫本'),('2','小乔'),('3','雪女');

/*Table structure for table `t_item` */

DROP TABLE IF EXISTS `t_item`;

CREATE TABLE `t_item` (
  `id` varchar(32) NOT NULL,
  `name` varchar(32) NOT NULL,
  `type` int(11) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_item` */

insert  into `t_item`(`id`,`name`,`type`) values ('1','俺手里有把剑',1),('2','谁知道明天的天气会怎么样？',1);

/*Table structure for table `t_menu` */

DROP TABLE IF EXISTS `t_menu`;

CREATE TABLE `t_menu` (
  `id` varchar(10) NOT NULL,
  `js` varchar(3) default '1',
  `pid` varchar(10) default NULL,
  `name` varchar(100) default NULL,
  `url` varchar(100) default NULL,
  `yxbz` varchar(3) NOT NULL default 'Y',
  `bz` varchar(300) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_menu` */

insert  into `t_menu`(`id`,`js`,`pid`,`name`,`url`,`yxbz`,`bz`) values ('1','1','0','系统管理','sys/xtgl.shtml','Y',NULL),('10','2','8','圈子管理','../managePage/circle/circle.html','Y',NULL),('11','1','0','产品管理',NULL,'Y',NULL),('12','2','11','服务管理','../managePage/service/service.html','Y',NULL),('121','1','0','发票管理',NULL,'Y',NULL),('122','2','121','发票列表','../managePage/invoice/invoice.html','Y',NULL),('123','2','65','支付宝交易查询','../managePage/orderManager/transaction_records.html','Y',NULL),('124','2','65','微信交易支付查询','../managePage/orderManager/wxOrder.html','Y',NULL),('125','1','62','收到的简历',NULL,'Y',NULL),('13','2','11','实体产品管理','../managePage/product/product.html','Y',NULL),('14','2','11','预约产品管理','../managePage/reserveProduct/reserveProduct.html','Y',NULL),('15','1','0','客户管理',NULL,'Y',NULL),('16','2','15','客户信息管理','../managePage/customer/customer.html','Y',NULL),('17','1','0','数据分析',NULL,'Y',NULL),('18','2','17','用户使用分析',NULL,'N',NULL),('19','2','17','图文消息分析',NULL,'N',NULL),('2','2','1','用户管理','../managePage/user/querylist.html','Y',NULL),('20','2','17','菜单点击分析',NULL,'N',NULL),('21','2','17','订单分析',NULL,'N',NULL),('22','2','8','服务商管理','../managePage/cooperative/cooperative2.html','Y',NULL),('23','2','5','期刊管理','../managePage/periodical/periodical.html','Y',NULL),('3','2','1','菜单管理','../managePage/menu/settingMenu.html','N',NULL),('4','2','1','角色管理','../managePage/menu/settingRole.html','Y',NULL),('5','1','0','通知公告',NULL,'Y',NULL),('6','2','5','通知类别管理','../managePage/notice/noticeClass.html','Y',NULL),('61','1','0','招聘管理',NULL,'Y',NULL),('62','2','61','职位管理','../managePage/resume/job.html','Y',NULL),('63','2','61','简历管理','../managePage/resume/resume.html','Y',NULL),('65','1','0','订单管理',NULL,'Y',NULL),('66','2','65','预约订单管理','../managePage/customerBespoke/customerBespoke.html','Y',NULL),('67','2','1','消息管理','../managePage/message/querylist.html','Y',NULL),('68','2','15','客户需求管理','../managePage/customer/customerNeed.html','Y',NULL),('7','2','5','通知公告管理','../managePage/notice/notice.shtml','Y',NULL),('8','1','0','营销推广',NULL,'Y',NULL),('81','2','11','功能管理','../managePage/function/function.html','Y',NULL),('82','2','65','金税/金盾订单查询','../managePage/orderManager/order.html','Y',NULL),('83','2','65','签约/VIP订单查询','../managePage/orderManager/jyAndVip.html','Y',NULL),('9','2','8','广告管理','../managePage/adv/adv.html','Y',NULL);

/*Table structure for table `users` */

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `id` int(10) NOT NULL auto_increment COMMENT 'id',
  `user_name` varchar(50) default NULL,
  `password` varchar(100) default NULL,
  `add_time` datetime default NULL,
  `is_used` int(2) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `users` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
