## 创建数据库
CREATE DATABASE `csdn` /*!40100 COLLATE 'utf8mb4_general_ci' */;


## 创建表
CREATE TABLE `archival_storage`
(
    `pk_id`          BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
    `gmt_create`     DATETIME            NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `gmt_modified`   DATETIME            NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `remark`         VARCHAR(300)        NOT NULL DEFAULT '',
    `sort`           INT(11) UNSIGNED    NOT NULL DEFAULT '0',
    `deleted`        TINYINT(1) UNSIGNED NOT NULL DEFAULT '0',
    `article_number` INT(10) UNSIGNED    NOT NULL DEFAULT '0',
    `year`           INT(10) UNSIGNED    NOT NULL DEFAULT '0',
    `month`          INT(10) UNSIGNED    NOT NULL DEFAULT '0',
    PRIMARY KEY (`pk_id`),
    UNIQUE INDEX `year_month` (`year`, `month`)
)
    COLLATE = 'utf8mb4_general_ci'
    ENGINE = InnoDB
    AUTO_INCREMENT = 163
;


CREATE TABLE `article_info`
(
    `pk_id`          BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
    `gmt_create`     DATETIME            NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `gmt_modified`   DATETIME            NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `remark`         VARCHAR(300)        NOT NULL DEFAULT '',
    `sort`           INT(11) UNSIGNED    NOT NULL DEFAULT '0',
    `deleted`        TINYINT(1) UNSIGNED NOT NULL DEFAULT '0',
    `url`            VARCHAR(500)        NOT NULL DEFAULT '',
    `article_name`   VARCHAR(500)        NOT NULL DEFAULT '',
    `read_number`    INT(11)             NOT NULL DEFAULT '0',
    `comment_number` INT(11)             NOT NULL DEFAULT '0',
    PRIMARY KEY (`pk_id`),
    UNIQUE INDEX `url` (`url`)
)
    COLLATE = 'utf8mb4_general_ci'
    ENGINE = InnoDB
    AUTO_INCREMENT = 1325
;


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
    `time_point`     INT(10) UNSIGNED    NOT NULL DEFAULT '0',
    PRIMARY KEY (`pk_id`)
)
    COLLATE = 'utf8mb4_general_ci'
    ENGINE = InnoDB
    AUTO_INCREMENT = 197
;


CREATE TABLE `user_info`
(
    `pk_id`        BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
    `gmt_create`   DATETIME            NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `gmt_modified` DATETIME            NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `remark`       VARCHAR(300)        NOT NULL DEFAULT '',
    `sort`         INT(11) UNSIGNED    NOT NULL DEFAULT '0',
    `deleted`      TINYINT(1) UNSIGNED NOT NULL DEFAULT '0',
    `nickname`     VARCHAR(100)        NOT NULL DEFAULT '',
    `head_img_url` VARCHAR(200)        NOT NULL DEFAULT '',
    `motto`        VARCHAR(300)        NOT NULL DEFAULT '',
    `version`      BIGINT(20)          NOT NULL DEFAULT '0',
    PRIMARY KEY (`pk_id`)
)
    COLLATE = 'utf8mb4_general_ci'
    ENGINE = InnoDB
    AUTO_INCREMENT = 555
;
