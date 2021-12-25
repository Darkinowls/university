<<<<<<< HEAD
select *
from lab5.days;


=======
# виводимо усі дні
select *
from lab5.days;

# виводимо усіх учнів, що мають клас
>>>>>>> master
select students.id, name, fullname
from lab5.students,
     lab5.classes
where students.classes_id = classes.id
ORDER BY students.id;


<<<<<<< HEAD
=======
# виводимо усі отримані оцінки учня
>>>>>>> master
select students.fullname, students_objects.grade
FROM lab5.students_objects,
     lab5.students
where students.id = students_id
ORDER BY students.id;


<<<<<<< HEAD
select students_id, fullname, students_objects.grade, COUNT(grade)
from lab5.students_objects,
     lab5.students
where students_id = 1
  and students.id = 1
GROUP BY students_id, fullname, students_objects.grade;


=======
# виводимо усі отримані оцінки учня та предмет, з якого отримали
select students.fullname, students_objects.grade, objects.name
FROM lab5.students_objects,
     lab5.students,
     lab5.objects
where students.id = students_objects.students_id and students_objects.objects_id = objects.id
ORDER BY students.id;


# виводимо журнал оцінок та присутностей для учня з ід 1.
# Там де NULL, та відповідно присутність == 0, тоді учень був відсутній на заняті
select students_id, fullname, students_objects.grade, COUNT(grade) as 'присутність', objects.name
from lab5.students_objects,
     lab5.students,
     lab5.objects
where students_id = 1
  and students.id = 1 and objects.id = students_objects.objects_id
GROUP BY students_id,  students_objects.grade, objects.id;


# кількість уроків, на який був учень ід=1
>>>>>>> master
select COUNT(id)
from lab5.students_objects
where students_id = 1
  and grade is not null;

<<<<<<< HEAD

=======
# кількість уроків, на яких мав бути учень ід=1. Усі його уроки
>>>>>>> master
select COUNT(students_objects.id)
from lab5.students_objects
where students_id = 1;


<<<<<<< HEAD
=======
# Журнал учня ід=1. Коли і на які уроки ходив, які бали отримав, хто йому ці бали поставив
>>>>>>> master
select s.id, s.fullname, so.grade, o.time, o.name, t.fullname
from lab5.students_objects as so,
     lab5.students as s,
     lab5.objects as o,
     lab5.teachers as t
where s.id = 1
  and s.id = so.students_id
  and o.id = so.objects_id
  and t.id = o.teachers_id;


<<<<<<< HEAD
select COUNT(id)
from lab5.students_objects
where students_id = 1
  and students_objects.grade is not null;


=======
# виводимо середню оцінку учня ід=1 (8+10+12)/3=10
>>>>>>> master
select students.fullname, AVG(GRADE)
from lab5.students_objects,
     lab5.students
where students_id = 1;

<<<<<<< HEAD

=======
# виводимо середню оцінку усіх учів, що ходили на уроки
>>>>>>> master
select s.id, s.fullname, AVG(so.grade) as average_grade
from lab5.students_objects as so,
     lab5.students as s
where so.students_id = s.id
GROUP BY s.id;

<<<<<<< HEAD
select count(ISNULL(grade)) as absences
from lab5.students_objects as so
where grade is null;


=======
# Виводимо кількість усіх уроків, на яких могли ходити учні(all_fields), та присутностей на усіх парах(precences)
# count(ISNULL(grade)) - враховує усі значення оцінки, включно з NULL, ЦЮ ФІЧУ БУДЕМО АБЮЗИТИ!!!!!!!1111
select count(ISNULL(grade)) as all_fields, count(grade) as precenses
from lab5.students_objects as so;

# Виводимо присутність(presence) учня у процентному відношені та середню оцінку учня за УСІ предмети
>>>>>>> master
select s.id, s.fullname, count(grade) / count(ISNULL(grade)) * 100 as presence, AVG(so.grade) as average_grade
from lab5.students_objects as so,
     lab5.students as s
where so.students_id = s.id
GROUP BY s.id;


<<<<<<< HEAD
=======
# Виводимо присутність(presence) учня у процентному відношені та середню оцінку учня за КОНКРЕТНИЙ предмет
>>>>>>> master
select s.id,
       s.fullname,
       count(grade) / count(ISNULL(grade)) * 100 as presence,
       AVG(so.grade)                             as average_grade,
       o.name
from lab5.students_objects as so,
     lab5.students as s,
     lab5.objects as o
where so.students_id = s.id
  and o.id = so.objects_id
<<<<<<< HEAD
GROUP BY s.id, o.name;
=======
GROUP BY s.id, o.name;

# Виводимо присутність(presence) учня у процентному відношені.
# Виводимо середню оцінку учня за КОНКРЕТНИЙ предмет та КОНКРЕТНОГО викладача
select s.id,
       s.fullname                                as student,
       count(grade) / count(ISNULL(grade)) * 100 as presence,
       AVG(so.grade)                             as average_grade,
       o.name,
       t.fullname                                as teacher
from lab5.students_objects as so,
     lab5.students as s,
     lab5.objects as o,
     lab5.teachers as t
where so.students_id = s.id
  and o.id = so.objects_id
  and o.teachers_id = t.id
GROUP BY s.id, o.name, t.fullname;


# REGEX що виводить усі дані про учня, якого ПРІЗВИЩЕ починається на M
# Тобто імя це крапка(.), далі йде пробіл( ), а за ним буква з якої починається прізвище(M)
SELECT *
from lab5.students
where fullname  REGEXP '. M'
>>>>>>> master
