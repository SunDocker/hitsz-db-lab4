/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2022/12/23 20:23:32                          */
/*==============================================================*/


drop trigger if exists ADMIN_FILL_TIME_AFTER_INSERT;

drop trigger if exists VOLUNTEER_FILL_TIME_AFTER_INSERT;

drop table if exists participate;

drop table if exists volunteer_activity;

drop table if exists activity_category;

drop table if exists admin;

drop table if exists volunteer;

drop table if exists college;

drop table if exists organization;

drop table if exists site;

drop table if exists star_rating;

drop table if exists volunteer_detail;

drop view if exists volunteer_detail;

/*==============================================================*/
/* Table: activity_category                                     */
/*==============================================================*/
create table activity_category
(
   name                 varchar(15) not null  comment '类别名',
   introduction         text  comment '类别简介',
   primary key (name)
);

alter table activity_category comment '志愿活动类别';

/*==============================================================*/
/* Table: admin                                                 */
/*==============================================================*/
create table admin
(
   account              varchar(10) not null  comment '账号',
   password             varchar(20) not null  comment '密码',
   register_time        datetime  comment '注册时间',
   primary key (account)
);

alter table admin comment '管理员';

/*==============================================================*/
/* Table: college                                               */
/*==============================================================*/
create table college
(
   no                   int not null  comment '学院编号',
   name                 varchar(15) not null  comment '学院名',
   introduction         text  comment '学院简介',
   primary key (no)
);

alter table college comment '学院';

/*==============================================================*/
/* Table: organization                                          */
/*==============================================================*/
create table organization
(
   no                   int not null  comment '组织编号',
   name                 varchar(15)  comment '组织名',
   introduction         text  comment '组织简介',
   primary key (no)
);

alter table organization comment '义工组织';

/*==============================================================*/
/* Table: participate                                           */
/*==============================================================*/
create table participate
(
   activity_no          int not null  comment '活动编号',
   volunteer_account    varchar(10) not null  comment '志愿者账号',
   check_status         varchar(3) not null  comment '审核状态',
   signup_time          datetime  comment '报名时间',
   primary key (activity_no, volunteer_account)
);

alter table participate comment '报名参与';

/*==============================================================*/
/* Table: site                                                  */
/*==============================================================*/
create table site
(
   no                   int not null  comment '地点编号',
   name                 varchar(15) not null  comment '地点名',
   area                 float not null  comment '场地面积',
   primary key (no)
);

alter table site comment '地点';

/*==============================================================*/
/* Table: star_rating                                           */
/*==============================================================*/
create table star_rating
(
   name                 varchar(15) not null  comment '星级名',
   introduction         text  comment '星级要求',
   primary key (name)
);

alter table star_rating comment '志愿者星级';

/*==============================================================*/
/* Table: volunteer                                             */
/*==============================================================*/
create table volunteer
(
   account              varchar(10) not null  comment '账号',
   college_no           int not null  comment '学院编号',
   star                 varchar(15) not null  comment '星级',
   org_no               int not null  comment '义工组织编号',
   password             varchar(20) not null  comment '密码',
   register_time        datetime  comment '注册时间',
   nickname             varchar(15)  comment '昵称',
   volunteer_time       float not null  comment '志愿时长',
   primary key (account)
);

alter table volunteer comment '志愿者';

/*==============================================================*/
/* Table: volunteer_activity                                    */
/*==============================================================*/
create table volunteer_activity
(
   no                   int not null  comment '活动编号',
   admin_account        varchar(10) not null  comment '管理员账号',
   category             varchar(15) not null  comment '类别',
   site_no              int not null  comment '地点编号',
   name                 varchar(15) not null  comment '活动名',
   begin_time           datetime not null  comment '开始时间',
   end_time             datetime not null  comment '结束时间',
   content              text not null  comment '活动内容与要求',
   num                  int not null  comment '人数',
   primary key (no)
);

alter table volunteer_activity comment '志愿活动';

/*==============================================================*/
/* Index: idx_begin_time                                        */
/*==============================================================*/
create index idx_begin_time on volunteer_activity
(
   begin_time
);

/*==============================================================*/
/* Index: idx_end_time                                          */
/*==============================================================*/
create index idx_end_time on volunteer_activity
(
   end_time
);

/*==============================================================*/
/* View: volunteer_detail                                       */
/*==============================================================*/
create VIEW  volunteer_detail as select 
									volunteer.account account,
									college.name college,
									volunteer.star star,
									organization.name organization,
									volunteer.register_time register_time,
									volunteer.nickname nickname,
									volunteer.volunteer_time volunteer_time
                                 from 
                                     volunteer,
                                     college,
                                     organization
                                 where
                                     volunteer.college_no = college.no
                                     and volunteer.org_no = organization.no;

alter table participate add constraint FK_ACTIVITY_PARTICIPATE foreign key (activity_no)
      references volunteer_activity (no) on delete restrict on update restrict;

alter table participate add constraint FK_VOLUNTEER_PARTICIPATE foreign key (volunteer_account)
      references volunteer (account) on delete restrict on update restrict;

alter table volunteer add constraint FK_VOLUNTEE_STAR foreign key (star)
      references star_rating (name) on delete restrict on update restrict;

alter table volunteer add constraint FK_VOLUNTEER_COLLEGE foreign key (college_no)
      references college (no) on delete restrict on update restrict;

alter table volunteer add constraint FK_VOLUNTEER_ORGANIZATION foreign key (org_no)
      references organization (no) on delete restrict on update restrict;

alter table volunteer_activity add constraint FK_ACTIVITY_CATEGORIZ foreign key (category)
      references activity_category (name) on delete restrict on update restrict;

alter table volunteer_activity add constraint FK_ACTIVITY_SITE foreign key (site_no)
      references site (no) on delete restrict on update restrict;

alter table volunteer_activity add constraint FK_ACTIVITY_ADMIN foreign key (admin_account)
      references admin (account) on delete restrict on update restrict;

delimiter ;;
create trigger ADMIN_FILL_TIME_BEFORE_INSERT
    before insert on admin
    for each row
begin
    set new.register_time = now();
end;;


create trigger VOLUNTEER_FILL_TIME_BEFORE_INSERT
    before insert on volunteer
    for each row
begin
    set new.register_time = now();
end;;

create trigger PARTICIPATE_FILL_TIME_BEFORE_INSERT
    before insert on participate
    for each row
begin
    set new.signup_time = now();
end;;
delimiter ;
