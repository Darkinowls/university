package Task.Support;

public final class ALLPOSTS {

    public final static String ALLPOSTS[] = {"assistant", "teacher", "lecture", "docent", "professor"};

    public final static void SHOWALLPOSTS() {
        System.out.println("All posts with their IDs :");
        for (int i = 0; i < ALLPOSTS.length; i++) System.out.println(i + "." + ALLPOSTS[i]);
    }

}
