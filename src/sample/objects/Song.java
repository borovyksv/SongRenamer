package sample.objects;

/**
 * Created by user-pc on 02.03.2017.
 */
public class Song {
    private String before;
    private String after;

    public Song(String before) {
        this.before = before;
    }

    public Song(String before, String after) {

        this.before = before;
        this.after = after;
    }

    public String getBefore() {
        return before;
    }

    public void setBefore(String before) {
        this.before = before;
    }

    public String getAfter() {
        return after;
    }

    public void setAfter(String after) {
        this.after = after;
    }
}
