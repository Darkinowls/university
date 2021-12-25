SELECT *
from mydb.workers
UNION
SELECT *
from mydb.certification;

SELECT *
from mydb.workers
UNION
SELECT *
from mydb.task;

SELECT Spent,
       case when Spent >= 10000 then Id_Worker end     IdwhereSpentIsBig,
       case when Id_Cert is null then 5 else Spent end SomeOutput
from mydb.workers;



SELECT Spent,
       case
           when Spent >= 10000 then Id_Worker
           when Id_Cert is null then 5
           else Spent end SomeOutput,
       count(*)
from mydb.workers
GROUP BY SomeOutput;

SELECT Spent,
       case when Spent >= 10000 then Id_Worker end     IdWhenSpentBig,
       case when Id_Cert is null then 5 else Spent end SomeOutput,
       count(*)
from mydb.workers
GROUP BY SomeOutput;

SELECT if(Spent > 5000, Id_Worker, null) as uni, Full_Name, COUNT(*)
from mydb.workers
GROUP BY uni;


SELECT *
from mydb.workers
where Id_Cert = (select Id_Cert
                 from mydb.certification
                 WHERE Id_Task1 = (select Id_Task
                                   from mydb.task
                                   where Id_City = (select city.Id_City
                                                    from mydb.city
                                                    where Name = 'Kyiv'
                                   )));

select Id_Worker, Full_Name, Spent, Sum
from mydb.workers
         left join mydb.certification on workers.Id_Cert = certification.Id_Cert;


select *
from mydb.workers
where Spent > any (SELECT Sum
                   from mydb.certification);

select *
FROM mydb.workers
where Spent <= any (select sum
                    from mydb.certification);

SELECT *
from mydb.workers
where EXISTS(select Id_Cert
             from mydb.certification
                where Id_Cert = 1);

SELECT *
from mydb.workers
where EXISTS(select Id_Cert
             from mydb.certification
                where Id_Cert = 3);

SELECT *
    from mydb.workers
    where Spent < all (select sum
                            from mydb.certification);






