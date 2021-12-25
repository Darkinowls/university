<<<<<<< HEAD
DROP DATABASE lab5;

CREATE DATABASE lab5;

=======
# Видаляємо існуючу базу даних з іменем lab5
DROP DATABASE lab5;

# Створюємо базу даних з назвою lab5
CREATE DATABASE lab5;

# Створюємо таблицю у цій базі даних з класами учнів classes
# Клас містить свій унікальний id, імя класу (111б наприклад), та id викладача що відповідальний за клас
>>>>>>> master
CREATE TABLE lab5.classes
(
    `id`          INT          NOT NULL AUTO_INCREMENT,
    `name`        varchar(255) NOT NULL UNIQUE,
    `teachers_id` INT          NOT NULL,
    PRIMARY KEY (`id`)
);

<<<<<<< HEAD
=======
# Створюємо таблицю розклад на тиждень, що придназначена для одного ЛИШЕ одного класу
>>>>>>> master
CREATE TABLE lab5.schedule_weeks
(
    `id`         INT NOT NULL AUTO_INCREMENT,
    `classes_id` INT NOT NULL UNIQUE,
    PRIMARY KEY (`id`)
);

<<<<<<< HEAD
=======

# Створюємо таблицю з розладом дня, що привязаний до розкладу на тиждень
# Ця Таблиця звязана з таблицями днів
>>>>>>> master
CREATE TABLE lab5.schedule_days
(
    `id`       INT NOT NULL AUTO_INCREMENT,
    `weeks_id` INT NOT NULL,
    `days_id`  INT NOT NULL,
    PRIMARY KEY (`id`)
);

<<<<<<< HEAD
=======
# Створюємо таблицю зі студентами, які належать певному одному класу та мають своє унікальне id та імя
>>>>>>> master
CREATE TABLE lab5.students
(
    `id`         INT          NOT NULL AUTO_INCREMENT,
    `classes_id` INT          NOT NULL,
    `fullname`   varchar(255) NOT NULL UNIQUE,
    PRIMARY KEY (`id`)
);

<<<<<<< HEAD
=======
# Створюємо таблицю з викладачами. викладач має id та унікальне імя
>>>>>>> master
CREATE TABLE lab5.teachers
(
    `id`       INT          NOT NULL AUTO_INCREMENT,
    `fullname` varchar(255) NOT NULL UNIQUE,
    PRIMARY KEY (`id`)
);

<<<<<<< HEAD
=======
# Створюємо таблицю з придметами, що привязані до певних викладачів та днів у розкладі
>>>>>>> master
CREATE TABLE lab5.objects
(
    `id`               INT          NOT NULL AUTO_INCREMENT,
    `name`             varchar(255) NOT NULL,
    `time`             TIME         NOT NULL,
    `teachers_id`      INT          NOT NULL,
    `schedule_days_id` INT          NOT NULL,
    PRIMARY KEY (`id`)

);

<<<<<<< HEAD
=======
# Створюємо звязну таблицю студент-предмет для запису оцінок(grade) конкретного учня на конкретному предметі.
# бвли варіюються від 1 до 12 включно. Можна поставити учню NULL - пропуск
>>>>>>> master
CREATE TABLE lab5.students_objects
(
    `id`          INT NOT NULL AUTO_INCREMENT,
    `students_id` INT NOT NULL,
    `objects_id`  INT NOT NULL,
    `grade`       INT NULL check ( grade > 0 and grade < 13 ),
<<<<<<< HEAD
    PRIMARY KEY (`id`)
);

=======
        PRIMARY KEY (`id`)
);

# Створюємо таблицю, яку ми заповнемо днями: Понеділок, Вівторок ...
# Всі дні мають мати унікальні імена й їх має бути не більше 6
>>>>>>> master
CREATE TABLE lab5.days
(
    `id`   INT          NOT NULL check ( id < 7 and id > 0 ),
    `name` varchar(255) NOT NULL UNIQUE,
    PRIMARY KEY (`id`)
);

<<<<<<< HEAD
=======

# ВАЖЛИВО ДАЛІ ми змінюємо таблиці, а саме з'єднуємо primery key  з foreign key
# АБИ ЗРОЗУМІТИ ЛОГІКУ з'єднань - ДИВИСЬ картинку lab5.png

# клас має викладача, який відповідальний за нього
>>>>>>> master
ALTER TABLE lab5.classes
    ADD FOREIGN KEY (`teachers_id`) REFERENCES `teachers` (`id`)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION;

<<<<<<< HEAD
=======
# Клас має ЄДИНИЙ розклад
>>>>>>> master
ALTER TABLE lab5.schedule_weeks
    ADD FOREIGN KEY (`classes_id`) REFERENCES lab5.classes (`id`)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION;

<<<<<<< HEAD
=======
# Розклад на тиждень має багато розкладів на кожен день тижня
>>>>>>> master
ALTER TABLE lab5.schedule_days
    ADD FOREIGN KEY (`weeks_id`) REFERENCES `schedule_weeks` (`id`)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION;

<<<<<<< HEAD
=======
# Розклад на день має день в який уроки відбуваються
>>>>>>> master
ALTER TABLE lab5.schedule_days
    ADD FOREIGN KEY (`days_id`) REFERENCES `days` (`id`)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION;

<<<<<<< HEAD
=======
# Студент належить класу
>>>>>>> master
ALTER TABLE lab5.students
    ADD FOREIGN KEY (`classes_id`) REFERENCES `classes` (`id`)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION;

<<<<<<< HEAD
=======
# Викладач має предмети
>>>>>>> master
ALTER TABLE lab5.objects
    ADD FOREIGN KEY (`teachers_id`) REFERENCES `teachers` (`id`)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION;

<<<<<<< HEAD
=======
# Розклад на день має безліч предметів
>>>>>>> master
ALTER TABLE lab5.objects
    ADD FOREIGN KEY (`schedule_days_id`) REFERENCES `schedule_days` (`id`)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION;

<<<<<<< HEAD
=======
# таблиця студент-предмет (журнал) має ід стулентів
>>>>>>> master
ALTER TABLE lab5.students_objects
    ADD FOREIGN KEY (`students_id`) REFERENCES `students` (`id`)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION;

<<<<<<< HEAD
=======
# таблиця студент-предмет (журнал) має ід предметів
>>>>>>> master
ALTER TABLE lab5.students_objects
    ADD FOREIGN KEY (`objects_id`) REFERENCES `objects` (`id`)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION;









