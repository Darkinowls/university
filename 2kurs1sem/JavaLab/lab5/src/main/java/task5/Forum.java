package task5;

public interface Forum {

    /**
     * Outputs data
     */
    String toString();

    /**
     * Inputs data
     */

    void setAuthor(String author);

    void setTheme(String theme);

    void setText(String text);

    void setTime(String time);

    void setRedaction(int redaction);

    void inputMessage();

}
