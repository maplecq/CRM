
create table FILMTYPE
(
  typeid   NUMBER(11) not null,
  typename NVARCHAR2(120)
);
alter table FILMTYPE
  add constraint FILMTYPE_KEY_ID primary key (TYPEID);
 

create table FILMINFO
(
  filmid      NUMBER(11) not null,
  filmname    VARCHAR2(50 CHAR) not null,
  typeid      NUMBER(11) not null,
  actor       VARCHAR2(255 CHAR),
  director    VARCHAR2(50 CHAR),
  ticketprice NUMBER(11) not null
);
alter table FILMINFO
  add primary key (FILMID);
 
alter table FILMINFO
  add constraint INFO_TYPE_FK foreign key (TYPEID)
  references FILMTYPE (TYPEID);

commit;

insert into FILMTYPE (typeid, typename)
values (1, '恐怖片');
insert into FILMTYPE (typeid, typename)
values (2, '动作片');
insert into FILMTYPE (typeid, typename)
values (3, '喜剧片');
insert into FILMTYPE (typeid, typename)
values (4, '战争片');
insert into FILMTYPE (typeid, typename)
values (5, '动漫片');
insert into FILMTYPE (typeid, typename)
values (6, '侦探片');
insert into FILMTYPE (typeid, typename)
values (7, '记录片');
commit;

insert into filminfo (FILMID, FILMNAME, TYPEID, ACTOR, DIRECTOR, TICKETPRICE, ROWID)
values (2, '猎杀红色十月', 2, '肖恩·康纳利', '约翰·麦克蒂尔南', 110, 'AAASd8AAGAAAAJsAAC');

insert into filminfo (FILMID, FILMNAME, TYPEID, ACTOR, DIRECTOR, TICKETPRICE, ROWID)
values (3, '兵临城下', 3, '裘德·洛 / 艾德·哈里斯', '让-雅克·阿诺', 90, 'AAASd8AAGAAAAJsAAD');

insert into filminfo (FILMID, FILMNAME, TYPEID, ACTOR, DIRECTOR, TICKETPRICE, ROWID)
values (4, '巴顿将军Patton ', 3, '乔治·C·斯科特', '弗兰克林·斯凡那', 88, 'AAASd8AAGAAAAJsAAE');

insert into filminfo (FILMID, FILMNAME, TYPEID, ACTOR, DIRECTOR, TICKETPRICE, ROWID)
values (7, '小时代', 3, '某某', '郭敬明', 122, 'AAASd8AAGAAAAJsAAF');

insert into filminfo (FILMID, FILMNAME, TYPEID, ACTOR, DIRECTOR, TICKETPRICE, ROWID)
values (1, '拯救大兵瑞恩Saving Private Ryan (1998)', 1, '汤姆·汉克斯', '史蒂文·斯皮尔伯格', 111, 'AAASd8AAGAAAAJsAAH');

insert into filminfo (FILMID, FILMNAME, TYPEID, ACTOR, DIRECTOR, TICKETPRICE, ROWID)
values (5, '心花怒放', 3, '黄渤', '未知', 66, 'AAASd8AAGAAAAJtAAA');

commit;

-- Create sequence 
create sequence SEQ_FTYPE
minvalue 0
maxvalue 9999999999
start with 1
increment by 1
cache 20;

-- Create sequence 
create sequence SEQ_FILM
minvalue 0
maxvalue 9999999999
start with 35
increment by 1
cache 20;