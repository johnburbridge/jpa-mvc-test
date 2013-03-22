create table PERSONS (
  ID varchar(36) not null,
  NAME varchar(60) not null, 
  unique UQ_PERSONS_1 (ID), 
  unique UQ_PERSONS_2 (NAME), 
  primary key (ID) 
); 

create table GROUPS (
  ID varchar(36) not null,
  NAME varchar(60) not null,
  unique UQ_GROUPS_1 (ID), 
  unique UQ_GROUPS_2 (NAME), 
  primary key (ID) 
); 

create table GROUP_MEMBERS (
  PERSON_ID varchar(36) not null, 
  GROUP_ID varchar(36) not null, 
  constraint FK_GROUP_MEMBERS_1 foreign key (PERSON_ID)
    references PERSONS (ID) on delete cascade,
  constraint FK_GROUP_MEMBERS_2 foreign key (GROUP_ID)
    references GROUPS (ID) on delete cascade,
  primary key (PERSON_ID, GROUP_ID) 
); 
