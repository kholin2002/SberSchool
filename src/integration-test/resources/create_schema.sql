--create schema example;

create table ANIMAL(
    age int not null,
    name varchar2(20) not null
);

insert into ANIMAL values (5,'JACK');
insert into ANIMAL values (10,'DEXTER');
insert into ANIMAL values (5,'ZEUS');

commit;