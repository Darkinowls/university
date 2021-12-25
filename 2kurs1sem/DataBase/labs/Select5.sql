Select Full_Name,Spent
from mydb.workers
where Spent = (select MAX(Spent)
               from mydb.workers);

Select Full_Name,Spent
from mydb.workers
where Spent = (select Min(Spent)
               from mydb.workers);

Select AVG(Spent)
from mydb.workers;

SELECT COUNT(Spent)
from mydb.workers;

SELECT *
from mydb.workers
GROUP BY Id_Cert;

SELECT *
from mydb.workers
GROUP BY Id_Cert , Spent;

SELECT Id_Cert, Full_Name , MAX(Spent)
from mydb.workers
GROUP BY Id_Cert;

SELECT Id_Cert, Full_Name , Min(Spent)
from mydb.workers
GROUP BY Id_Cert;

SELECT Id_Cert, Full_Name , COUNT(Spent)
from mydb.workers
GROUP BY Id_Cert;

SELECT Id_Cert, Full_Name , AVG(Spent)
from mydb.workers
GROUP BY Id_Cert;

SELECT Id_Cert,Full_Name, Sum(Spent)
from mydb.workers
GROUP BY Id_Cert;

SELECT Id_Cert,Full_Name, Sum(Spent)
from mydb.workers
GROUP BY Id_Cert
HAVING sum(Spent) > min(Spent);


SELECT Id_Cert , Full_Name , max(Spent)
from mydb.workers
GROUP BY Id_Cert
having max(Spent) > 11000 ;

SELECT Id_Cert , Full_Name , Spent , count(*) num
from mydb.workers
GROUP BY Id_Cert, Spent
having num is not null ;

select Id_Worker , Full_Name , Spent , COUNT(*) num
from mydb.workers
where Spent is not null
group by Id_Cert
HAVING num > 1;

select *
FROM mydb.workers
HAVING Spent is null;



