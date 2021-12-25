package project.models;

import project.interfaces.Consts;
import project.Month;
import project.annotations.MyAnnotation;

// Всередені містить Builder
public class MyDate extends Watch implements Consts {
    private int year;
    private Month month;
    private int day;

    private MyDate(DateBuilder db) throws Exception {
        this.year = db.year;
        this.month = db.month;
        this.day = db.day;
    }


    @MyAnnotation(name = "getYear")
    public int getYear() {
        return year;
    }

    public String getMonth() {
        Month m = Month.valueOf(String.valueOf(month));
        return m.name();
    }

    public int getDay() {
        return day;
    }


    // реалізація патерну Builder
    public static class DateBuilder {
        private int year;
        private Month month;
        private int day;

        public DateBuilder(int year, int month, int day) throws Exception {
            this.setYear(year);
            this.setMonth(month);
            this.setDay(day);
        }

        public DateBuilder() {
        }

        public DateBuilder setYear(int year) throws Exception {
            // примітивна перевірка вхідних даних
            if (year < MINYEAR) throw new Exception("Year has not to be negative ");
            this.year = year;
            return this;
        }

        public DateBuilder setMonth(int month) throws Exception {
            // примітивна перевірка вхідних даних
            if (month < MINMONTH || month > MAXMONTH) throw new Exception("project.Month has to be within 1 and 12");
            Month month1 = null;
            // знаходимо місяць з enum
            for (Month m :
                    Month.values()) {
                if (m.ordinal() == month) month1 = m;
            }
            this.month = month1;
            return this;
        }

        public DateBuilder setDay(int day) throws Exception {
            // примітивна перевірка вхідних даних
            if (day < MINDAY || day > MAXDAY) throw new Exception("Day has to be within 0 and 31");
            this.day = day;
            return this;
        }

        // Будуємо об'єкт класу MyDate
        public MyDate build() throws Exception {
            return new MyDate(this);
        }
    }


}
