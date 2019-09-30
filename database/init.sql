## 创建数据库
CREATE DATABASE `csdn` /*!40100 COLLATE 'utf8mb4_general_ci' */;


## 创建表
CREATE TABLE `data`
(
    `pk_id`          BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
    `gmt_create`     DATETIME            NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `gmt_modified`   DATETIME            NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `remark`         VARCHAR(300)        NOT NULL DEFAULT '',
    `sort`           INT(11) UNSIGNED    NOT NULL DEFAULT '0',
    `deleted`        TINYINT(1) UNSIGNED NOT NULL DEFAULT '0',
    `level`          INT(10) UNSIGNED    NOT NULL DEFAULT '0',
    `visit_number`   INT(10) UNSIGNED    NOT NULL DEFAULT '0',
    `integral`       INT(10) UNSIGNED    NOT NULL DEFAULT '0',
    `top`            INT(10) UNSIGNED    NOT NULL DEFAULT '0',
    `article_number` INT(10) UNSIGNED    NOT NULL DEFAULT '0',
    `fans`           INT(10) UNSIGNED    NOT NULL DEFAULT '0',
    `like_number`    INT(10) UNSIGNED    NOT NULL DEFAULT '0',
    `comment_number` INT(10) UNSIGNED    NOT NULL DEFAULT '0',
    PRIMARY KEY (`pk_id`)
)
    COLLATE = 'utf8mb4_general_ci'
    ENGINE = InnoDB
;
