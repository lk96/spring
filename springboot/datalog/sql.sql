create table product(
id number not null,
name varchar2(11),
category varchar2(11),
detail  varchar2(11),
buyPrice number,
sellPrice number,
provider varchar2(11),
onlineTime date,
updateTime date,
primary key(id)
)