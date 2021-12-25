package task5;

import java.util.Calendar;
import java.util.Objects;
import java.util.Scanner;

/**
 * Class for storing data of messages on a forum
 *
 * <b>Author</b>, <b>Theme</b>, <b>Text</b>,
 * <b>Time</b>, <b>Redaction</b>
 *
 * @author Denis
 * @version 1.0
 */
public class Message implements Forum, Cloneable {

    /**
     * Author of a message
     */
    private String Author;
    /**
     * Theme of a message
     */
    private String Theme;
    /**
     * Text of a message
     */
    private String Text;
    /**
     * Creation time of a message
     */
    private String Time;
    /**
     * Redaction of a message
     */
    private int Redaction;

    {
        Redaction = 1;
    }
    /**
     * Constructor with values
     *
     * @param author
     * @param theme
     * @param text
     * @param time
     * @param redaction
     * @see Message#Message(String, String, String, String, int)
     */

    public Message(String author, String theme, String text, String time, int redaction) {
        Author = author;
        Theme = theme;
        Text = text;
        Time = time;
        Redaction = redaction;
    }

    /**
     * Constructor with only one value
     *
     * @param text
     * @see Message#Message(String) String of text
     */

    public Message(String text) {
        Text = text;
    }
    public Message(){}


    public void inputMessage(){
        Scanner scan = new Scanner(System.in);

        System.out.println("Input name of author : ");
        Author = scan.next();

        System.out.println("Input name of theme : ");
        Theme = scan.next();

        System.out.println("Input text : ");
        Text = scan.next();

        Calendar cal1 = Calendar.getInstance();

        Time = cal1.getTime().toString();

    }

    /**
     * Returns data of an another object to this object
     */
    @Override
    protected Message clone() throws CloneNotSupportedException {

        return (Message) super.clone();

    }

    /**
     * Compares two objects.
     *
     * @param o
     * @return True , if they are equal . Otherwise - false .
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Message)) return false;
        Message Message = (Message) o;
        return Objects.equals(getAuthor(), Message.getAuthor()) &&
                Objects.equals(getTheme(), Message.getTheme()) &&
                Objects.equals(getText(), Message.getText()) &&
                Objects.equals(getTime(), Message.getTime()) &&
                Objects.equals(getRedaction(), Message.getRedaction());
    }

    /**
     * Gets an unique integer from integer.
     *
     * @return Hash integer of a message.
     */

    @Override
    public int hashCode() {
        return Objects.hash(getAuthor(), getTheme(), getText(), getTime(), getRedaction());
    }

    /**
     * Shows all information about a message.
     *
     * @return All information about a message.
     */

    @Override
    public String toString() {
        return "Forum{" +
                "Author='" + Author + '\'' +
                ", Theme='" + Theme + '\'' +
                ", Text=" + Text +
                ", Time='" + Time + '\'' +
                ", Redaction='" + Redaction + '\'' +
                '}';
    }

    /**
     * Method for getting a field {@link Message#Author}
     *
     * @return A name of an authors .
     */
    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
        Redaction++;
    }

    /**
     * Method for getting a field {@link Message#Theme}
     *
     * @return A title of an theme .
     */
    public String getTheme() {
        return Theme;
    }

    public void setTheme(String theme) {
        Theme = theme;
        Redaction++;
    }

    /**
     * Method for getting a field {@link Message#Text}
     *
     * @return Text of a message .
     */
    public String getText() {
        return Text;
    }

    public void setText(String text) {
        Text = text;
        Redaction++;
    }

    /**
     * Method for getting a field {@link Message#Time}
     *
     * @return Time of bringing out .
     */
    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
        Redaction++;
    }

    /**
     * Method for getting a field {@link Message#Redaction}
     *
     * @return Redaction of a massage.
     */
    public int getRedaction() {
        return Redaction;
    }

    public void setRedaction(int redaction) {
        if(redaction <= 0) System.exit(-1);
        Redaction = redaction;
    }

}
