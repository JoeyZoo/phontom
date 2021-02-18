#
#Structure for table "outdoor_user_relation"
#

CREATE TABLE `outdoor_user_relation`(
`id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '����id',
`up_id` BIGINT UNSIGNED NOT NULL COMMENT 'up��id',
`fan_id` BIGINT UNSIGNED NOT NULL COMMENT '��˿id',
`is_deleted` TINYINT(1) UNSIGNED NOT NULL DEFAULT '0' COMMENT '�߼�ɾ�� 1��true��ȡ����ע��0��false����ע',
`gmt_create` DATETIME NOT NULL COMMENT '����ʱ�䣬����עupʱ���',
`gmt_modified` DATETIME NOT NULL COMMENT '����ʱ�䣬��ȡ��ʱ���',
PRIMARY KEY (`id`),
KEY `idx_up_id`(`up_id`),
KEY `idx_fan_id`(`fan_id`)
)ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='�û���ϵ��';


#
#Data FOR TABLE "outdoor_user_relation"
#

INSERT INTO outdoor_user_relation VALUES(NULL,12,21,0,'2013-09-01','2013-09-01');


###############################################################################


#
#Structure FOR TABLE 'outdoor_user'
#


CREATE TABLE `outdoor`.`outdoor_user`(  
  `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '�û�id',
  `account` VARCHAR(255) NOT NULL COMMENT '�˺ţ�ʹ����������ֻ���ע�ᣬȻ��ͨ��������֤�ʼ������ֻ���֤��ȷ���Ƿ���Ч������Ҫ��֤Ψһ���������unique',
  `avatar` VARCHAR(255) NOT NULL COMMENT 'ճ��Ĭ��ͷ���ַ',
  `nickname` VARCHAR(50) NOT NULL COMMENT '�ǳƣ��ǳ��ѱ�ע�� �ǳ�Ψһ�Թ��ܽ���Ӧ�ò�ȥ��ɣ������ڴ���ӹؼ���unique',
  `password` VARCHAR(255) NOT NULL COMMENT '����',
  `sex` TINYINT UNSIGNED NOT NULL DEFAULT 1 COMMENT '1�����У�0����Ů',
  `age` TINYINT UNSIGNED COMMENT '����',
  `motto` VARCHAR(255) NOT NULL DEFAULT '����һ��е�����ʲôҲû������' COMMENT '����ǩ��',
  `email` VARCHAR(255) NOT NULL COMMENT '����',
  `phonenumber` CHAR(11) NOT NULL COMMENT '�ֻ���',
  `is_member` TINYINT UNSIGNED NOT NULL DEFAULT 0 COMMENT '0��ͨ��1���Ա',
  `is_online` TINYINT UNSIGNED NOT NULL DEFAULT 0 COMMENT '0���ߣ�1���ߣ���¼���޸ĸ��ֶε�ֵ',
  `is_disabled` TINYINT UNSIGNED NOT NULL DEFAULT 0 COMMENT '0δ���ᣬ1����',
  `is_deleted` TINYINT UNSIGNED NOT NULL DEFAULT 0 COMMENT '0������1ע��',
  `gmt_create` DATETIME NOT NULL COMMENT 'ע��ʱ��',		
  `gmt_modified` DATETIME NOT NULL COMMENT '����ʱ��',		
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_account` (`account`),
  UNIQUE KEY `uk_nickname` (`nickname`),
  UNIQUE KEY `uk_email` (`email`),
  UNIQUE KEY `uk_phonenumber`(`phonenumber`)
) ENGINE=INNODB CHARSET=utf8 COLLATE=utf8_general_ci comment '�û���';

#
#Data FOR TABLE "outdoor_user"
#

INSERT INTO outdoor_user VALUES(NULL,"13121214151@163.com",'','joey','ahfofsdfag',1,NULL,"����һ��е�����ʲôҲû������",'13121214151@163.com','13162679462',0,0,0,0,"2020-12-03","2020-12-03");
INSERT INTO outdoor_user VALUES(NULL,"1312121411@163.com",'','jey','ahfofsdfag',1,NULL,"����һ��е�����ʲôҲû������",'1312121411@163.com','1316267962',0,0,0,0,"2020-12-03","2020-12-03");


#��ע���޸�ĳ���ֶε����ã����ڸ�ĳ�ֶ����Ψһ����֮ǰ�״�ȷ�����ݿ���и��ֶ��Ƿ�����ظ������ݣ������޷��ɹ����Ψһ����
#ALTER TABLE `outdoor`.`outdoor_user`   
# ADD  UNIQUE INDEX `uk_nickname` (`nickname`),
# ADD  UNIQUE INDEX `uk_email` (`email`),
# ADD  UNIQUE INDEX `uk_phonenumber` (`phonenumber`);


###############################################################################
#
#Structure FOR TABLE `outdoor_praise`
#

CREATE  TABLE `outdoor_praise`(
`id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '�޵�id',
`source_id` BIGINT UNSIGNED NOT NULL COMMENT '���޵���Ƶid��������id',
`source` TINYINT UNSIGNED NOT NULL DEFAULT 0 COMMENT '0��Ƶ��1����',
`fan_id` BIGINT UNSIGNED NOT NULL COMMENT '������id',
`up_id` BIGINT UNSIGNED NOT NULL COMMENT '������id',
`is_deleted` TINYINT UNSIGNED NOT NULL DEFAULT 0 COMMENT '0�ޣ�1δ��',
`gmt_create` DATETIME NOT NULL COMMENT'���޵�ʱ��',
`gmt_modified` DATETIME NOT NULL COMMENT'�޸�ʱ��',
PRIMARY KEY (`id`),
KEY `idx_source_id` (source_id),
KEY `idx_fan_id` (fan_id),
KEY `idx_up_id` (up_id)
)ENGINE=INNODB CHARSET=utf8 COLLATE=utf8_general_ci comment='���ޱ�';


#
#Data FOR TABLE `outdoor_praise`
#

INSERT INTO outdoor_praise VALUES(NULL,22,1,11,14,1,"2020-12-03","2020-12-03");

###############################################################################

CREATE TABLE `outdoor_type`(
`id` TINYINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '�����˶�id',
`type_name` VARCHAR(50) NOT NULL COMMENT '�˶�����',
`is_deleted` TINYINT UNSIGNED NOT NULL DEFAULT 0 COMMENT '0������1�߼�ɾ��',
`gmt_create` DATETIME NOT NULL COMMENT '����ʱ��',
`gmt_modified` DATETIME NOT NULL COMMENT '�޸�ʱ��',
PRIMARY KEY (`id`),
UNIQUE KEY `uk_type_name` (`type_name`)
)ENGINE=INNODB CHARSET=utf8 COLLATE=utf8_general_ci COMMENT='�����˶������';

#
#Data FOR TABLE `outdoor_type`
#

INSERT INTO outdoor_type VALUES(NULL,'¶Ӫ',0,"2019-12-01","2019-12-01");

##### ##########################################################################


#
#Structure FOR TABLE `outdoor_video_collect`
#


CREATE TABLE `outdoor_video_collect`(
`id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '�ղ�id',
`video_id` BIGINT UNSIGNED NOT NULL COMMENT '�ղص���Ƶid',
`fan_id` BIGINT UNSIGNED NOT NULL COMMENT '�ղ���id',
`favorite_id` BIGINT UNSIGNED NOT NULL COMMENT '�ղؼ�id',
`is_deleted` TINYINT UNSIGNED NOT NULL DEFAULT 0 COMMENT '0�ղأ�1δ�ղ�',
`gmt_create` DATETIME NOT NULL COMMENT '�ղ�ʱ��',
`gmt_modified` DATETIME NOT NULL COMMENT '����ʱ��',
PRIMARY KEY (`id`),
KEY `idx_video_id` (`video_id`),
KEY `idx_fan_id` (`fan_id`),
KEY `idx_favorite_id` (`favorite_id`)
)ENGINE=INNODB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci COMMENT='�ղ���Ƶ��';
 
#
#Data FOR TABLE `outdoor_video_collect`
#

INSERT INTO `outdoor_video_collect` VALUES(NULL,22,32,12,0,"2019-09-12","2019-09-12");


###############################################################################



#
#Structure FOR TABLE `outdoor_video_play_record`
#

CREATE TABLE `outdoor_video_play_record`(
`id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '����id',
`video_id` BIGINT UNSIGNED NOT NULL COMMENT '���ŵ���Ƶid',
`fan_id` BIGINT UNSIGNED NOT NULL COMMENT '������id',
`up_id` BIGINT UNSIGNED NOT NULL COMMENT '��Ƶ����id',
`is_deleted` TINYINT UNSIGNED NOT NULL DEFAULT 0 COMMENT '0������ʷ1�����ʷ',
`gmt_create` DATETIME NOT NULL COMMENT '����ʱ��',
`gmt_modified` DATETIME NOT NULL COMMENT '�����ʷʱ��',
PRIMARY KEY (`id`),
KEY `idx_video_id` (`video_id`),
KEY `idx_fan_id` (`fan_id`),
KEY `idx_up_id` (`up_id`) 
)ENGINE=INNODB DEFAULT CHARSET =utf8 COLLATE=utf8_general_ci COMMENT='������ʷ��' ;

 
#
#Data FOR TABLE `outdoor_video_play_record`
#


INSERT INTO `outdoor_video_play_record` VALUES(NULL,231,234,53,0,"2020-10-01","2020-10-01");


###############################################################################

#
#Structure FOR TABLE `outdoor_video_comment`
#

CREATE TABLE `outdoor_video_comment`(
`id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '����id',
`pid` BIGINT UNSIGNED NOT NULL DEFAULT 0 COMMENT '������id,0��ʾ������Ƶ���������ֱ�ʾ�����۵ĸ�����id',
`content` VARCHAR(1000) NOT NULL COMMENT '��������',
`uid` BIGINT UNSIGNED NOT NULL COMMENT '������id',
`video_id` BIGINT UNSIGNED NOT NULL COMMENT '��Ƶid',
`is_deleted` TINYINT UNSIGNED NOT NULL COMMENT '0������1�߼�ɾ������',
`gmt_create` DATETIME NOT NULL COMMENT '����ʱ��',
`gmt_modified` DATETIME NOT NULL COMMENT '�߼�ɾ��ʱ��',
PRIMARY KEY (`id`),
KEY `idx_pid` (`pid`),
KEY `idx_content` (`content`),
KEY `idx_uid` (`uid`),
KEY `idx_video_id` (`video_id`)
)ENGINE=INNODB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci COMMENT='��Ƶ���۱�';


#
#Data FOR TABLE `outdoor_video_comment`
#


INSERT INTO `outdoor_video_comment` VALUES(NULL,0,"��̽��lsp",3241,53625,0,"2020-12-01","2020-12-01");


###############################################################################

#
#Structure FOR TABLE `outdoor_user_favorite`
#


CREATE TABLE `outdoor_user_favorite`(
`id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '�ղؼ�id',
`favorite_name` VARCHAR(50) NOT NULL COMMENT '�ղؼ�����',
`uid` BIGINT UNSIGNED NOT NULL COMMENT'�û�id',
`is_deleted` TINYINT UNSIGNED NOT NULL DEFAULT 0 COMMENT '0����,1�߼�ɾ��',
`gmt_create` DATETIME NOT NULL COMMENT '�ղؼд���ʱ��',
`gmt_modified` DATETIME NOT NULL COMMENT '�ղؼи���ʱ��',
PRIMARY KEY (`id`),
KEY `idx_uid` (`uid`),
KEY `idx_favorite_name` (`favorite_name`)
)ENGINE=INNODB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci COMMENT='�û��ղؼб�';



#
#Data FOR TABLE `outdoor_user_favorite`
#


INSERT INTO `outdoor_user_favorite` VALUES(NULL,"ͽ��·��",23,0,"2020-10-13","2020-10-13");

###############################################################################

#
#Structure FOR TABLE `outdoor_video_type`
#

CREATE TABLE `outdoor_video_type`(
`id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'id',
`video_id` BIGINT UNSIGNED NOT NULL COMMENT'��Ƶid',
`type_id` TINYINT UNSIGNED NOT NULL COMMENT'����id',
`is_deleted` TINYINT UNSIGNED NOT NULL COMMENT'0����1�߼�ɾ��',
`gmt_create` DATETIME NOT NULL COMMENT '����ʱ��',
`gmt_modified` DATETIME NOT NULL COMMENT '�޸�ʱ��',
PRIMARY KEY (`id`),
KEY `idx_video_id` (`video_id`),
KEY `idx_type_id`(`type_id`)
)ENGINE=INNODB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci COMMENT'��Ƶ�����ϵ��';

#
#Data FOR TABLE `outdoor_video_type`
#


INSERT INTO outdoor_video_type VALUES(NULL,1,1,0,"2020-12-04","2020-12-04");

###############################################################################

#
#Structure FOR TABLE `outdoor_video`
#


CREATE TABLE `outdoor_video`(
`id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '��Ƶid',
`title` VARCHAR(255) NOT NULL COMMENT'��Ƶ����',
`description` VARCHAR(500) NOT NULL COMMENT '��Ƶ���',
`cover` VARCHAR(255) NOT NULL COMMENT '��Ƶ����',
`duration` TIME NOT NULL COMMENT '��Ƶʱ��',
`video_source_id` VARCHAR(100) NOT NULL COMMENT'�ƶ���Ƶid',
`video_original_name` VARCHAR(100) NOT NULL COMMENT '�ƶ���Ƶԭʼ��',
`up_id` BIGINT UNSIGNED NOT NULL COMMENT'��Ƶ����id',
`type_id` TINYINT UBSIGNED NOT NULL COMMENT'��Ƶ����id',
`is_free` TINYINT UNSIGNED NOT NULL DEFAULT 1 COMMENT '1Ϊ���,0Ϊ����',
`is_published` TINYINT UNSIGNED NOT NULL DEFAULT 0 COMMENT'1�ѷ���,0δ����',
`is_disabled` TINYINT UNSIGNED NOT NULL DEFAULT 0 COMMENT '0������1����/���¼�',
`is_deleted` TINYINT UNSIGNED NOT NULL DEFAULT 0 COMMENT'0������1�߼�ɾ��',
`gmt_create` DATETIME NOT NULL  COMMENT"����ʱ��",
`gmt_modified` DATETIME NOT NULL  COMMENT'����ʱ��',
PRIMARY KEY (`id`),
UNIQUE KEY `uk_title` (`title`),
UNIQUE KEY `uk_video_source_id` (`video_source_id`),
KEY `idx_up_id` (`up_id`),
KEY `idx_video_original_name` (`video_original_name`)
)ENGINE=INNODB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci COMMENT="��Ƶ��Ϣ��";


#
#Data FOR TABLE `outdoor_video`
#


INSERT INTO `outdoor_video` VALUES(NULL,"��̽���´���ľԭɭ��","��ѹ���ձ���ᣬ��ľԭ����ʧȥϣ�������ǵĹ���",'','35','2151','',1,1,1,0,0,0,"2020-09-09","2020-09-09");

###############################################################################
###############################################################################

#
#Structure FOR TABLE `outdoor_video_update`
#

CREATE TABLE `outdoor_video_update`(
`id` BIGINT UNSIGNED  NOT NULL AUTO_INCREMENT COMMENT 'id',
`video_source_id` VARCHAR(100) NOT NULL COMMENT '��Ƶ�ƶ�id',
`up_id` BIGINT UNSIGNED NOT NULL COMMENT 'up_id',
`fan_id` BIGINT UNSIGNED NOT NULL COMMENT 'fan_id',
`is_deleted` TINYINT UNSIGNED NOT NULL COMMENT '0Ϊδ���ģ�1Ϊ�Ѳ���',
`gmt_create` DATETIME NOT NULL COMMENT '��̬֪ͨʱ��',
`gmt_modified` DATETIME NOT NULL COMMENT '����ʱ��',
PRIMARY KEY (`id`),
KEY `idx_video_source_id` (`video_source_id`),
KEY `idx_up_id` (`up_id`),
KEY `idx_fan_id` (`fan_id`)
)ENGINE=INNODB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci COMMENT 'UP����̬֪ͨ��';

#δʵ�ֵ����ݿ����������Ա�����¼���