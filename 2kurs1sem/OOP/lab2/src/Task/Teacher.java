package Task;

import Task.Support.Experience;

import java.util.GregorianCalendar;

import static Task.Support.ALLPOSTS.*;


public class Teacher implements Cloneable {

    private String fullName;
    private GregorianCalendar birth;
    private int post;
    private Experience experience = new Experience();
    private int load;
    private int salary;


    public Teacher(String fullName, GregorianCalendar birth, String post, int months, int load) {
        setFullName(fullName);
        setBirth(birth);
        setPost(post);
        setExperience(months);
        setLoad(load);
    }

    public Teacher(String fullName, GregorianCalendar birth, int postID, int months, int load) {
        setFullName(fullName);
        setBirth(birth);
        setPost(postID);
        setExperience(months);
        setLoad(load);
    }

    public Teacher(String fullName, GregorianCalendar birth, int postID, int months, int years, int load) {
        setFullName(fullName);
        setBirth(birth);
        setPost(postID);
        setExperience(months, years);
        setLoad(load);
    }

    public Teacher(String fullName, GregorianCalendar birth, String post, int months, int years, int load) {
        setFullName(fullName);
        setBirth(birth);
        setPost(post);
        setExperience(months, years);
        setLoad(load);
    }

    public Teacher() {
        setFullName("Full name of a teacher");
        setBirth(new GregorianCalendar(1, 1, 1));
        setPost(0);
        setExperience(0, 0);
        setLoad(1);

    }

    public void setBirth(GregorianCalendar birth) {
        this.birth = birth;
        this.birth.set(GregorianCalendar.MONTH, birth.get(GregorianCalendar.MONTH) - 1);
    }

    public String getBirth() {
        return birth.get(GregorianCalendar.DATE) + "." +
                (birth.get(GregorianCalendar.MONTH) + 1) + "." + birth.get(GregorianCalendar.YEAR);
    }

    public void setExperience(int months, int years) {
        setExperience(months);
        if (years < 0) {
            System.out.println("ERROR! Teaching experience in years should be equal 0 or more!");
            System.exit(-1);
        }

        experience.setYears(years + experience.getYears());
    }

    public void setExperience(int months) {
        if (months < 0) {
            System.out.println("ERROR! Teaching experience in months should be equal 0 or more!");
            System.exit(-1);
        }
        experience.setYears(months / 12);
        experience.setMonths(months % 12);
    }

    public String getExperience() {
        return "months=" + experience.getMonths() + ", years=" + experience.getYears();
    }


    public void setLoad(int load) {
        if (load <= 0 || load >= 36) {
            System.out.println("ERROR! Pedagogical load should be between 0 and 36 hours per week!");
            System.exit(-1);
        }
        this.load = load;
        calculateSalary();
    }

    public int getLoad() {
        return load;
    }

    public void setPost(String post) {
        for (int i = 0; i < ALLPOSTS.length; i++) {
            if (ALLPOSTS[i].equals(post)) {
                this.post = i;
                calculateSalary();
                return;
            }
        }
        System.out.println("ERROR! Wrong name of a post!");
        SHOWALLPOSTS();
        System.exit(-1);
    }

    public void setPost(int index) {
        if (index < 0 || index >= ALLPOSTS.length) {
            System.out.println("ERROR! Wrong id of a post!");
            SHOWALLPOSTS();
            System.exit(-1);
        }
        this.post = index;
        calculateSalary();
    }

     private void calculateSalary(){
        salary = 4500 + 100 * load + 500 * post ;
     }

     public int getSalary(){
        return salary ;
     }

    public boolean isBirthday(){

        GregorianCalendar current = new GregorianCalendar();
        boolean today = false;

        if(birth.get(GregorianCalendar.MONTH) == current.get(GregorianCalendar.MONTH)
                && birth.get(GregorianCalendar.DAY_OF_MONTH) == current.get(GregorianCalendar.DAY_OF_MONTH ))
                    today = true;

        return today;
    }

    public void compareTeachers(Teacher t) {

        System.out.println("\nLet's compare " + getFullName() + " and " + t.getFullName());

        if (post > t.post) System.out.println(getFullName() + " has higher post \"" + ALLPOSTS[post] + "\" than "
                + t.getFullName() + " \"" + ALLPOSTS[t.post] + "\"");
        else if (post == t.post) System.out.println(getFullName() + " has the same post \""
                + ALLPOSTS[post] + "\" as" + t.getFullName());
        else System.out.println(getFullName() + " has lower post \"" + ALLPOSTS[post] + "\" than "
                    + t.getFullName() + " \"" + ALLPOSTS[t.post] + "\"");

        if (experience.getExperienceInMonths() > t.experience.getExperienceInMonths())
            System.out.println(getFullName() + " has more experience {" + getExperience() + "} than "
                    + t.getFullName() + " {"+ t.getExperience() + "} ");
        else if (experience.getExperienceInMonths() == t.experience.getExperienceInMonths())
            System.out.println(getFullName() + " has the same experience {" + getExperience() + "} as " + t.getFullName());
        else System.out.println(getFullName() + " has less experience {" + getExperience() +"} than "
                    + t.getFullName() + " {"+ t.getExperience() +"}" );

        if (load > t.load) System.out.println(getFullName() + " has more load per week (" + getLoad()+ ")"
                + " than " + t.getFullName() +" ("+ t.getLoad()+ ")");
        else if (load == t.load) System.out.println(getFullName() + " has the same load per week as (" + t.getFullName() + ")");
        else System.out.println(getFullName() + " has less load per week (" + getLoad() + ") than "
                    + t.getFullName() + " (" + t.getLoad() + ")");

        System.out.println();

    }


    public String getPost() {
        return ALLPOSTS[post];
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public String toString() {
        return "Support{" +
                "fullName='" + getFullName() + '\'' +
                ", birth=" + getBirth() +
                ", post='" + getPost() + '\'' +
                ", experience{" + getExperience() +
                "}, load=" + getLoad() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Teacher)) return false;
        Teacher teacher = (Teacher) o;
        return getFullName().equals(teacher.getFullName()) &&
                getBirth().equals(teacher.getBirth());

    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

}
