create table tbl_memo_type(
type BIGINT not null auto_increment comment'类型ID',
name varchar(50) NOT NULL comment'类型名称',
username  varchar(50) NOT NULL comment'所属用户',
createTime datetime not null COMMENT'创建时间',
primary key(type)
)
comment = '备忘类型';

CREATE table tbl_user
(
username varchar(50) not null comment'用户名',
password varchar(50) not null comment'密码',
gender int comment'性别',
birthDate date comment'出生日期',
tel varchar(255) comment'联系电话',
email varchar(255)comment'email',
createTime datetime not null comment'创建时间',
description varchar(255) comment'账户简述',
primary key(username)
)
COMMENT = '用户信息表';

ALTER table tbl_memo add CONSTRAINT FK_typeId_memo_memotype foreign key(typeId)
references tbl_memo_type(type) on delete restrict on update restrict;

ALTER table tbl_memo add CONSTRAINT FK_username_memo_user foreign key(username)
references tbl_user(username) on delete restrict on update restrict;

ALTER table tbl_memo_type add CONSTRAINT FK_username_memotype_user foreign key(username)
references tbl_user(username) on delete restrict on update restrict;

insert into tbl_user VALUES('admin','admin',0,'1982-11-21','15901945302','zxh0302@163.com',
'2013-12-26',NULL);

insert into tbl_user VALUES('amigo','amigo',0,'1982-11-21','15901945302','zxh0302@163.com',
'2013-12-26',NULL);