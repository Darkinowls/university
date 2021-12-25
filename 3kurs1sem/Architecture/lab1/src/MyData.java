public   class MyData implements Consts{
    private int year;
    private int month;
    private int day;

    public MyData(int year, int month, int day) {
        this.setYear(year);
        this.setMonth(month);
        this.setDay(day);
    }


    public MyData() {
        this.year = -1;
        this.month = 0;
        this.day = 0;
    }

    @MyAnnotation(name = "getYear")
    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public void setYear(int year) {
        if (year < MINYEAR ) try {
            throw new Exception("Year has not to be negative ");
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.year = year;
    }

    public void setMonth(int month) {
        if (month < MINMONTH || month > MAXMONTH ) try {
            throw new Exception("Month has to be within 1 and 12");
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.month = month;
    }

    public void setDay(int day) {
        if (day < MINDAY || day > MAXDAY ) try {
            throw new Exception("Day has to be within 0 and 31");
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.day = day;
    }


    public void showAll(){
        System.out.println("\tData show");
        System.out.print(((this.day == 0) ? "Set valid day" : "day:" + this.getDay()) + " ");
        System.out.print(((this.month == 0) ? "Set valid month" : "month:" + this.getMonth()) + " ");
        System.out.print((this.year == -1) ? "Set valid year" : "year:" + this.getYear() + "\n");

    }


}
