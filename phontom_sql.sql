#
#Structure for table "outdoor_user_relation"
#

CREATE TABLE `outdoor_user_relation`(
`id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键id',
`up_id` BIGINT UNSIGNED NOT NULL COMMENT 'up主id',
`fan_id` BIGINT UNSIGNED NOT NULL COMMENT '粉丝id',
`is_deleted` TINYINT(1) UNSIGNED NOT NULL DEFAULT '0' COMMENT '逻辑删除 1（true）取消关注，0（false）关注',
`gmt_create` DATETIME NOT NULL COMMENT '创建时间，即关注up时间点',
`gmt_modified` DATETIME NOT NULL COMMENT '更新时间，即取关时间点',
PRIMARY KEY (`id`),
KEY `idx_up_id`(`up_id`),
KEY `idx_fan_id`(`fan_id`)
)ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='用户关系表';


#
#Data FOR TABLE "outdoor_user_relation"
#

INSERT INTO outdoor_user_relation VALUES(NULL,12,21,0,'2013-09-01','2013-09-01');


###############################################################################


#
#Structure FOR TABLE 'outdoor_user'
#


CREATE TABLE `outdoor`.`outdoor_user`(  
  `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `account` VARCHAR(255) NOT NULL COMMENT '账号，使用邮箱或者手机号注册，然后通过发送验证邮件或者手机验证码确认是否有效，且需要验证唯一，或者添加unique',
  `avatar` VARCHAR(255) NOT NULL COMMENT '粘贴默认头像地址',
  `nickname` VARCHAR(50) NOT NULL COMMENT '昵称，昵称已被注册 昵称唯一性功能交由应用层去完成，或者在此添加关键字unique',
  `password` VARCHAR(255) NOT NULL COMMENT '密码',
  `sex` TINYINT UNSIGNED NOT NULL DEFAULT 1 COMMENT '1代表男，0代表女',
  `age` TINYINT UNSIGNED COMMENT '年龄',
  `motto` VARCHAR(255) NOT NULL DEFAULT '这个家伙有点懒，什么也没有留下' COMMENT '个性签名',
  `email` VARCHAR(255) NOT NULL COMMENT '邮箱',
  `phonenumber` CHAR(11) NOT NULL COMMENT '手机号',
  `is_member` TINYINT UNSIGNED NOT NULL DEFAULT 0 COMMENT '0普通，1大会员',
  `is_online` TINYINT UNSIGNED NOT NULL DEFAULT 0 COMMENT '0下线，1上线，登录后修改该字段的值',
  `is_disabled` TINYINT UNSIGNED NOT NULL DEFAULT 0 COMMENT '0未冻结，1冻结',
  `is_deleted` TINYINT UNSIGNED NOT NULL DEFAULT 0 COMMENT '0正常，1注销',
  `gmt_create` DATETIME NOT NULL COMMENT '注册时间',		
  `gmt_modified` DATETIME NOT NULL COMMENT '更新时间',		
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_account` (`account`),
  UNIQUE KEY `uk_nickname` (`nickname`),
  UNIQUE KEY `uk_email` (`email`),
  UNIQUE KEY `uk_phonenumber`(`phonenumber`)
) ENGINE=INNODB CHARSET=utf8 COLLATE=utf8_general_ci comment '用户表';

#
#Data FOR TABLE "outdoor_user"
#

INSERT INTO outdoor_user VALUES(NULL,"13121214151@163.com",'','joey','ahfofsdfag',1,NULL,"这个家伙有点懒，什么也没有留下",'13121214151@163.com','13162679462',0,0,0,0,"2020-12-03","2020-12-03");
INSERT INTO outdoor_user VALUES(NULL,"1312121411@163.com",'','jey','ahfofsdfag',1,NULL,"这个家伙有点懒，什么也没有留下",'1312121411@163.com','1316267962',0,0,0,0,"2020-12-03","2020-12-03");


#备注：修改某表字段的设置，如在给某字段添加唯一索引之前首次确认数据库表中该字段是否存在重复的数据，否则无法成功添加唯一索引
#ALTER TABLE `outdoor`.`outdoor_user`   
# ADD  UNIQUE INDEX `uk_nickname` (`nickname`),
# ADD  UNIQUE INDEX `uk_email` (`email`),
# ADD  UNIQUE INDEX `uk_phonenumber` (`phonenumber`);


###############################################################################
#
#Structure FOR TABLE `outdoor_praise`
#

CREATE  TABLE `outdoor_praise`(
`id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '赞的id',
`source_id` BIGINT UNSIGNED NOT NULL COMMENT '获赞的视频id或者评论id',
`source` TINYINT UNSIGNED NOT NULL DEFAULT 0 COMMENT '0视频，1评论',
`fan_id` BIGINT UNSIGNED NOT NULL COMMENT '点赞者id',
`up_id` BIGINT UNSIGNED NOT NULL COMMENT '获赞者id',
`is_deleted` TINYINT UNSIGNED NOT NULL DEFAULT 0 COMMENT '0赞，1未赞',
`gmt_create` DATETIME NOT NULL COMMENT'点赞的时间',
`gmt_modified` DATETIME NOT NULL COMMENT'修改时间',
PRIMARY KEY (`id`),
KEY `idx_source_id` (source_id),
KEY `idx_fan_id` (fan_id),
KEY `idx_up_id` (up_id)
)ENGINE=INNODB CHARSET=utf8 COLLATE=utf8_general_ci comment='点赞表';


#
#Data FOR TABLE `outdoor_praise`
#

INSERT INTO outdoor_praise VALUES(NULL,22,1,11,14,1,"2020-12-03","2020-12-03");

###############################################################################

CREATE TABLE `outdoor_type`(
`id` TINYINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '户外运动id',
`type_name` VARCHAR(50) NOT NULL COMMENT '运动名称',
`is_deleted` TINYINT UNSIGNED NOT NULL DEFAULT 0 COMMENT '0正常，1逻辑删除',
`gmt_create` DATETIME NOT NULL COMMENT '创建时间',
`gmt_modified` DATETIME NOT NULL COMMENT '修改时间',
PRIMARY KEY (`id`),
UNIQUE KEY `uk_type_name` (`type_name`)
)ENGINE=INNODB CHARSET=utf8 COLLATE=utf8_general_ci COMMENT='户外运动分类表';

#
#Data FOR TABLE `outdoor_type`
#

INSERT INTO outdoor_type VALUES(NULL,'露营',0,"2019-12-01","2019-12-01");

##### ##########################################################################


#
#Structure FOR TABLE `outdoor_video_collect`
#


CREATE TABLE `outdoor_video_collect`(
`id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '收藏id',
`video_id` BIGINT UNSIGNED NOT NULL COMMENT '收藏的视频id',
`fan_id` BIGINT UNSIGNED NOT NULL COMMENT '收藏者id',
`favorite_id` BIGINT UNSIGNED NOT NULL COMMENT '收藏夹id',
`is_deleted` TINYINT UNSIGNED NOT NULL DEFAULT 0 COMMENT '0收藏，1未收藏',
`gmt_create` DATETIME NOT NULL COMMENT '收藏时间',
`gmt_modified` DATETIME NOT NULL COMMENT '更改时间',
PRIMARY KEY (`id`),
KEY `idx_video_id` (`video_id`),
KEY `idx_fan_id` (`fan_id`),
KEY `idx_favorite_id` (`favorite_id`)
)ENGINE=INNODB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci COMMENT='收藏视频表';
 
#
#Data FOR TABLE `outdoor_video_collect`
#

INSERT INTO `outdoor_video_collect` VALUES(NULL,22,32,12,0,"2019-09-12","2019-09-12");


###############################################################################



#
#Structure FOR TABLE `outdoor_video_play_record`
#

CREATE TABLE `outdoor_video_play_record`(
`id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '播放id',
`video_id` BIGINT UNSIGNED NOT NULL COMMENT '播放的视频id',
`fan_id` BIGINT UNSIGNED NOT NULL COMMENT '播放者id',
`up_id` BIGINT UNSIGNED NOT NULL COMMENT '视频作者id',
`is_deleted` TINYINT UNSIGNED NOT NULL DEFAULT 0 COMMENT '0播放历史1清除历史',
`gmt_create` DATETIME NOT NULL COMMENT '播放时间',
`gmt_modified` DATETIME NOT NULL COMMENT '清除历史时间',
PRIMARY KEY (`id`),
KEY `idx_video_id` (`video_id`),
KEY `idx_fan_id` (`fan_id`),
KEY `idx_up_id` (`up_id`) 
)ENGINE=INNODB DEFAULT CHARSET =utf8 COLLATE=utf8_general_ci COMMENT='播放历史表' ;

 
#
#Data FOR TABLE `outdoor_video_play_record`
#


INSERT INTO `outdoor_video_play_record` VALUES(NULL,231,234,53,0,"2020-10-01","2020-10-01");


###############################################################################

#
#Structure FOR TABLE `outdoor_video_comment`
#

CREATE TABLE `outdoor_video_comment`(
`id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '评论id',
`pid` BIGINT UNSIGNED NOT NULL DEFAULT 0 COMMENT '父评论id,0表示评论视频，其它数字表示子评论的父评论id',
`content` VARCHAR(1000) NOT NULL COMMENT '评论内容',
`uid` BIGINT UNSIGNED NOT NULL COMMENT '评论者id',
`video_id` BIGINT UNSIGNED NOT NULL COMMENT '视频id',
`is_deleted` TINYINT UNSIGNED NOT NULL COMMENT '0正常，1逻辑删除评论',
`gmt_create` DATETIME NOT NULL COMMENT '评论时间',
`gmt_modified` DATETIME NOT NULL COMMENT '逻辑删除时间',
PRIMARY KEY (`id`),
KEY `idx_pid` (`pid`),
KEY `idx_content` (`content`),
KEY `idx_uid` (`uid`),
KEY `idx_video_id` (`video_id`)
)ENGINE=INNODB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci COMMENT='视频评论表';


#
#Data FOR TABLE `outdoor_video_comment`
#


INSERT INTO `outdoor_video_comment` VALUES(NULL,0,"雷探长lsp",3241,53625,0,"2020-12-01","2020-12-01");


###############################################################################

#
#Structure FOR TABLE `outdoor_user_favorite`
#


CREATE TABLE `outdoor_user_favorite`(
`id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '收藏夹id',
`favorite_name` VARCHAR(50) NOT NULL COMMENT '收藏夹名称',
`uid` BIGINT UNSIGNED NOT NULL COMMENT'用户id',
`is_deleted` TINYINT UNSIGNED NOT NULL DEFAULT 0 COMMENT '0正常,1逻辑删除',
`gmt_create` DATETIME NOT NULL COMMENT '收藏夹创建时间',
`gmt_modified` DATETIME NOT NULL COMMENT '收藏夹更新时间',
PRIMARY KEY (`id`),
KEY `idx_uid` (`uid`),
KEY `idx_favorite_name` (`favorite_name`)
)ENGINE=INNODB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci COMMENT='用户收藏夹表';



#
#Data FOR TABLE `outdoor_user_favorite`
#


INSERT INTO `outdoor_user_favorite` VALUES(NULL,"徒步路线",23,0,"2020-10-13","2020-10-13");

###############################################################################

#
#Structure FOR TABLE `outdoor_video_type`
#

CREATE TABLE `outdoor_video_type`(
`id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'id',
`video_id` BIGINT UNSIGNED NOT NULL COMMENT'视频id',
`type_id` TINYINT UNSIGNED NOT NULL COMMENT'分类id',
`is_deleted` TINYINT UNSIGNED NOT NULL COMMENT'0正常1逻辑删除',
`gmt_create` DATETIME NOT NULL COMMENT '创建时间',
`gmt_modified` DATETIME NOT NULL COMMENT '修改时间',
PRIMARY KEY (`id`),
KEY `idx_video_id` (`video_id`),
KEY `idx_type_id`(`type_id`)
)ENGINE=INNODB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci COMMENT'视频分类关系表';

#
#Data FOR TABLE `outdoor_video_type`
#


INSERT INTO outdoor_video_type VALUES(NULL,1,1,0,"2020-12-04","2020-12-04");

###############################################################################

#
#Structure FOR TABLE `outdoor_video`
#


CREATE TABLE `outdoor_video`(
`id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '视频id',
`title` VARCHAR(255) NOT NULL COMMENT'视频标题',
`description` VARCHAR(500) NOT NULL COMMENT '视频简介',
`cover` VARCHAR(255) NOT NULL COMMENT '视频封面',
`duration` TIME NOT NULL COMMENT '视频时长',
`video_source_id` VARCHAR(100) NOT NULL COMMENT'云端视频id',
`video_original_name` VARCHAR(100) NOT NULL COMMENT '云端视频原始名',
`up_id` BIGINT UNSIGNED NOT NULL COMMENT'视频作者id',
`type_id` TINYINT UBSIGNED NOT NULL COMMENT'视频分类id',
`is_free` TINYINT UNSIGNED NOT NULL DEFAULT 1 COMMENT '1为免费,0为付费',
`is_published` TINYINT UNSIGNED NOT NULL DEFAULT 0 COMMENT'1已发表,0未发表',
`is_disabled` TINYINT UNSIGNED NOT NULL DEFAULT 0 COMMENT '0正常，1被禁/被下架',
`is_deleted` TINYINT UNSIGNED NOT NULL DEFAULT 0 COMMENT'0正常，1逻辑删除',
`gmt_create` DATETIME NOT NULL  COMMENT"创建时间",
`gmt_modified` DATETIME NOT NULL  COMMENT'更新时间',
PRIMARY KEY (`id`),
UNIQUE KEY `uk_title` (`title`),
UNIQUE KEY `uk_video_source_id` (`video_source_id`),
KEY `idx_up_id` (`up_id`),
KEY `idx_video_original_name` (`video_original_name`)
)ENGINE=INNODB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci COMMENT="视频信息表";


#
#Data FOR TABLE `outdoor_video`
#


INSERT INTO `outdoor_video` VALUES(NULL,"雷探长勇闯青木原森林","高压的日本社会，青木原成了失去希望的人们的归宿",'','35','2151','',1,1,1,0,0,0,"2020-09-09","2020-09-09");

###############################################################################
###############################################################################

#
#Structure FOR TABLE `outdoor_video_update`
#

CREATE TABLE `outdoor_video_update`(
`id` BIGINT UNSIGNED  NOT NULL AUTO_INCREMENT COMMENT 'id',
`video_source_id` VARCHAR(100) NOT NULL COMMENT '视频云端id',
`up_id` BIGINT UNSIGNED NOT NULL COMMENT 'up_id',
`fan_id` BIGINT UNSIGNED NOT NULL COMMENT 'fan_id',
`is_deleted` TINYINT UNSIGNED NOT NULL COMMENT '0为未查阅，1为已查阅',
`gmt_create` DATETIME NOT NULL COMMENT '动态通知时间',
`gmt_modified` DATETIME NOT NULL COMMENT '查阅时间',
PRIMARY KEY (`id`),
KEY `idx_video_source_id` (`video_source_id`),
KEY `idx_up_id` (`up_id`),
KEY `idx_fan_id` (`fan_id`)
)ENGINE=INNODB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci COMMENT 'UP主动态通知表';

#未实现的数据库表：订单表，会员购买记录表等