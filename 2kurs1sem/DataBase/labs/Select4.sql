SELECT *
from mydb.Workers
where Id_Worker = 1;

SELECT *
from mydb.workers
where not Id_Worker = 1;

select Id_Worker, Full_Name as Імя, Post as Посада , Id_Cert
from mydb.workers
where Id_Cert = 1
   or Id_Cert = 2;

SELECT *
from mydb.workers
where Id_Worker in (2, 3, 100);

#only with in
SELECT *
from mydb.workers
where Id_Cert in (select Id_Cert
                  from mydb.certification
                  where Id_Task1 is not null);

SELECT *
from mydb.workers
where Id_Worker between 1 and 4;

select *
from mydb.workers
where Full_Name like '%er%'
ORDER BY Spent;

select *
from mydb.workers
where Full_Name like '%Dance_'
order by Id_Cert;

SELECT *
from mydb.workers
WHERE Id_Cert is NULL;

SELECT *
from mydb.workers
         left join mydb.city on Id_City = Id_Worker;

SELECT *
from mydb.workers
         inner join mydb.city on Id_City = Id_Worker;



select Id_Cert
from mydb.workers;

select DISTINCT Id_Cert
from mydb.workers;

select *
from mydb.workers
limit 4;

select *
from mydb.workers
order by Spent DESC
limit 4;