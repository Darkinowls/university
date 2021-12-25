drop database mydb;

CREATE database IF NOT EXISTS mydb DEFAULT CHARACTER SET utf8;


create table if not exists mydb.Type_City
(
    Id_Type   int         not null check (Id_Type >= 1 and Id_Type <= 3),
    Type      varchar(45) not null,
    Price_day int         not null check (Price_day > 0),
    Primary key (Id_Type)

);

insert into mydb.type_city
values (1, 'Big city', 1000),
       (2, 'Average city', 500),
       (3, 'Little city', 250);


CREATE TABLE IF NOT EXISTS mydb.City
(
    Id_City int         not null check ( Id_City>0 ),
    Name    varchar(45) null,
    Id_Type int         null,
    primary key (`Id_city`),
    foreign key (Id_Type) references `mydb`.`Type_city` (`Id_type`)
        ON DELETE CASCADE
        ON UPDATE CASCADE

);

insert into mydb.City (Id_City ,`Name`, Id_type)
values (1,'Kyiv', 1),
       (2,'Lviv', 2),
       (3,'White Church', 3),
       (4,'Ivanovo', 3),
       (5,'Harkiv', 2);


CREATE TABLE IF NOT EXISTS mydb.Task
(
    Id_Task         INT  NOT NULL check ( Id_Task>0 ),
    Start_Date      DATE NULL,
    End_Date        DATE NULL,
    Number_Days     INT  NULL check (Number_days >= 0) default (datediff(End_date, Start_date)),
    Price_Way       INT  NULL check (Price_way > 0),
    Price_Residence INT  NULL,
    Id_City         INT  NULL,
    PRIMARY KEY (Id_Task),
    FOREIGN KEY (Id_city)
        REFERENCES `mydb`.`City` (`Id_city`)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

insert into mydb.Task (Id_Task ,Start_date, End_date, Price_way, Id_city, Price_residence)
values (1, '2020-01-02', '2020-01-05', 1000, 1,
        (datediff(End_date, Start_date) * (
            select Price_day
            from mydb.Type_city
            where Id_type = (select Id_type
                             from mydb.City
                             where Id_city = 1)))),

       (2,'2020-02-27', '2020-03-03', 2000, 2,
        (datediff(End_date, Start_date) * (
            select Price_day
            from mydb.Type_city
            where Id_type = (select Id_type
                             from mydb.City
                             where Id_city = 2))));



CREATE TABLE IF NOT EXISTS mydb.Certification
(
    Id_Cert    INT  NOT NULL check ( Id_Cert>0 ),
    Issue_Date DATE NULL,
    Sum        INT  NULL,
    Id_Task1   INT  NULL,
    Id_Task2   INT  NULL,
    PRIMARY KEY (`Id_cert`),
    FOREIGN KEY (Id_task1)
        REFERENCES `mydb`.`Task` (Id_task)
        ON DELETE CASCADE
        ON UPDATE CASCADE,
    FOREIGN KEY (Id_task2)
        REFERENCES `mydb`.`Task` (Id_task)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

insert into mydb.Certification (Id_Cert,Id_task1, Id_Task2, Issue_date, sum)
values (1, 1, 2,
        least((select (Start_date - interval 7 day)
               from mydb.Task
               where Id_task = 1), (select (Start_date - interval 7 day)
                                    from mydb.Task
                                    where Id_task = 2)
            ),
        ((select Price_way + Price_residence
          from mydb.Task
          where Id_task = 1)
        ) + (select Price_way + Price_residence
             from mydb.Task
             where Id_task = 2)),

       (2, 2, null,
        least((select (Start_date - interval 7 day)
               from mydb.Task
               where Id_task = 2), '3000-01-01'),
        (select Price_way + Price_residence
         from mydb.Task
         where Id_task = 2));



CREATE TABLE IF NOT EXISTS mydb.Worker
(
    Id_Worker INT         NOT NULL check ( Id_Worker>0 ),
    Full_Name VARCHAR(45) NULL,
    Post      VARCHAR(45) NULL,
    Spent     int         NULL check ( Spent >= 0 ),
    Id_Cert   INT         NULL default 0,
    PRIMARY KEY (Id_Worker),
    FOREIGN KEY (Id_Cert)
        REFERENCES mydb.Certification (Id_Cert)
        ON DELETE set null
        ON UPDATE set null
);

insert into mydb.Worker (Id_Worker, Full_name, Post, Spent, Id_Cert)
values (1,'Vasya Dancer', 'teacher', 12000, 1),
       (2,'Arthur Lancer', 'manager', 3000, 2),
       (3,'Arthur Ginger', 'programmer', 3000, 2),
       (4,'George Soros', 'programmer', 9000, 2),
       (5,'Anton Truba', 'cleaner', NULL, NULL),
       (6,'Olia Dancer', 'teacher', 10000, 1),
       (7,'Uther Octopus', 'programmer', 10000, 2),
       (8,'Klenovich Dub', 'cleaner', NULL, NULL);

Select Id_Cert
from mydb.Certification;

CREATE TABLE IF NOT EXISTS mydb.Users
(
    Id_User  int         not NULL,
    Login    VARCHAR(45) NULL,
    Password VARCHAR(45) NULL,
    primary key (Id_User)
);

insert into mydb.Users
values (1, 'root', 'root'),
       (2, 'admin', 'admin');


SELECT *
from mydb.City;
SELECT *
from mydb.Type_City;
Select *
from mydb.Task;
Select *
from mydb.certification;
Select *
from mydb.worker;


Select *
from mydb.City
         LEFT OUTER JOIN mydb.Type_city ON city.Id_Type = type_city.Id_Type;
