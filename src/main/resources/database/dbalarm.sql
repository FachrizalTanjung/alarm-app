/*
SQLyog Community v12.4.3 (64 bit)
MySQL - 5.0.77-community-nt : Database - dbalarm
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`dbalarm` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `dbalarm`;

/*Table structure for table `kategori` */

DROP TABLE IF EXISTS `kategori`;

CREATE TABLE `kategori` (
  `id_kategori` int(11) NOT NULL auto_increment,
  `kategori` varchar(50) NOT NULL,
  `file` blob,
  PRIMARY KEY  (`id_kategori`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `kategori` */

/*Table structure for table `reminder` */

DROP TABLE IF EXISTS `reminder`;

CREATE TABLE `reminder` (
  `id` int(11) NOT NULL auto_increment,
  `catatan` text NOT NULL,
  `tanggal_aktif` datetime NOT NULL,
  `tanggal_sebelum_aktif` datetime default NULL,
  `membuat_tanggal` datetime NOT NULL,
  `mengupdate_tanggal` datetime default NULL,
  `membuat_nama` varchar(30) default NULL,
  `mengupdate_nama` varchar(30) default NULL,
  `id_kategori` int(11) NOT NULL,
  PRIMARY KEY  (`id`),
  KEY `reminder_fk1` (`membuat_nama`),
  KEY `reminder_fk2` (`mengupdate_nama`),
  KEY `reminder_fk3` (`id_kategori`),
  CONSTRAINT `reminder_fk1` FOREIGN KEY (`membuat_nama`) REFERENCES `user` (`username`),
  CONSTRAINT `reminder_fk2` FOREIGN KEY (`mengupdate_nama`) REFERENCES `user` (`username`),
  CONSTRAINT `reminder_fk3` FOREIGN KEY (`id_kategori`) REFERENCES `kategori` (`id_kategori`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `reminder` */

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `username` varchar(30) NOT NULL,
  `password` varchar(12) NOT NULL,
  PRIMARY KEY  (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `user` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
