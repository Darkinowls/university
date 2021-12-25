# Вставляємо в таблицю дані про дні

INSERT into lab5.days (id, name)
values (1, 'Monday'),
       (2, 'Tuesday'),
       (3, 'Wednesday'),
       (4, 'Thursday'),
       (5, 'Friday'),
       (6, 'Saturday');


# Вставляємо в таблицю дані про викладачів

INSERT INTO lab5.teachers (fullname)
values ('Vasil Doter'),
       ('Richard Mikos'),
       ('Rickardo Milas'),
       ('Miho Sgurovsky'),
       ('Denis Blackowl'),
       ('Dmitry Pavlenko');


# Вставляємо в таблицю дані про класи

INSERT INTO lab5.classes (name, teachers_id)
VALUES ('11b', 1),
       ('10a', 2),
       ('9a', 4),
       ('5b', 4);


# Вставляємо в таблицю дані про розклад на тиждень

INSERT INTO lab5.schedule_weeks(classes_id)
values (1),
       (2),
       (3),
       (4);


# Вставляємо в таблицю дані про розклад на день

INSERT INTO lab5.schedule_days (weeks_id, days_id)
values (1, 1),
       (1, 2),

       (2, 1),
       (2, 3),

       (3, 4),
       (3, 5),

       (4, 2),
       (4, 6);


# Вставляємо в таблицю дані про предмети

INSERT INTO lab5.objects(name, time, teachers_id, schedule_days_id)
VALUES ('biology', '10:00', 1, 1),
       ('biology', '12:00', 2, 3),
       ('biology', '11:00', 1, 5),
       ('math', '9:00', 1, 6),
       ('dancing', '10:30', 2, 5),
       ('dancing', '9:30', 3, 6),
       ('math', '12:30', 2, 2),
       ('math', '10:00', 3, 4),
       ('ukrainian', '11:00', 1, 1),
       ('ukrainian', '12:00', 4, 1);


# Вставляємо в таблицю дані про учні

INSERT INTO lab5.students (classes_id, first_name, second_name)
VALUES (1, 'Danil', ' Dance'),
       (1, 'Vasya ', 'Domestos'),
       (1, 'Retro', ' Mobile'),
       (2, 'Karl', ' Mobile'),
       (2, 'Oleh ', 'Mobile'),
       (3, 'Ura', ' Urashko'),
       (3, 'Sasha ', 'Pikalo'),
       (4, 'Grisha ', ' Singletonenko');


INSERT INTO lab5.students_objects (students_id, objects_id, grade)
VALUES (1, 2, 10),
       (1, 4, null);


# Вставляємо в таблицю дані про учні й передмети, які бали отримали або не отримали
INSERT INTO lab5.students_objects (students_id, objects_id, grade)
VALUES (1, 2, 10),
    (1, 4, null),
    (1, 4, 8),

    (1, 3, 12),
    (1, 1, null),
    (2, 3, 9),
    (2, 6, 10),
    (3, 3, 9),
    (3, 6, NULL),
    (3, 6, 6),
    (3, 1, 7),
    (3, 2, 8),
    (4, 4, 2),
    (4, 5, NULL),
    (5, 3, 10);