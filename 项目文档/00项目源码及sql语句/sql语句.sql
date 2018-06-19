
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
values (1, '�ֲ�Ƭ');
insert into FILMTYPE (typeid, typename)
values (2, '����Ƭ');
insert into FILMTYPE (typeid, typename)
values (3, 'ϲ��Ƭ');
insert into FILMTYPE (typeid, typename)
values (4, 'ս��Ƭ');
insert into FILMTYPE (typeid, typename)
values (5, '����Ƭ');
insert into FILMTYPE (typeid, typename)
values (6, '��̽Ƭ');
insert into FILMTYPE (typeid, typename)
values (7, '��¼Ƭ');
commit;

insert into filminfo (FILMID, FILMNAME, TYPEID, ACTOR, DIRECTOR, TICKETPRICE, ROWID)
values (2, '��ɱ��ɫʮ��', 2, 'Ф����������', 'Լ������˵ٶ���', 110, 'AAASd8AAGAAAAJsAAC');

insert into filminfo (FILMID, FILMNAME, TYPEID, ACTOR, DIRECTOR, TICKETPRICE, ROWID)
values (3, '���ٳ���', 3, '�õ¡��� / ���¡�����˹', '��-�ſˡ���ŵ', 90, 'AAASd8AAGAAAAJsAAD');

insert into filminfo (FILMID, FILMNAME, TYPEID, ACTOR, DIRECTOR, TICKETPRICE, ROWID)
values (4, '�Ͷٽ���Patton ', 3, '���Ρ�C��˹����', '�������֡�˹����', 88, 'AAASd8AAGAAAAJsAAE');

insert into filminfo (FILMID, FILMNAME, TYPEID, ACTOR, DIRECTOR, TICKETPRICE, ROWID)
values (7, 'Сʱ��', 3, 'ĳĳ', '������', 122, 'AAASd8AAGAAAAJsAAF');

insert into filminfo (FILMID, FILMNAME, TYPEID, ACTOR, DIRECTOR, TICKETPRICE, ROWID)
values (1, '���ȴ�����Saving Private Ryan (1998)', 1, '��ķ������˹', 'ʷ���ġ�˹Ƥ������', 111, 'AAASd8AAGAAAAJsAAH');

insert into filminfo (FILMID, FILMNAME, TYPEID, ACTOR, DIRECTOR, TICKETPRICE, ROWID)
values (5, '�Ļ�ŭ��', 3, '�Ʋ�', 'δ֪', 66, 'AAASd8AAGAAAAJtAAA');

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