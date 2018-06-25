package aysusayin.com.mynotebook;

/**
 * Created by Aysu on 9.07.2017.
 */

public class Note {
    private String title;
    private String note;
    private String user;
    private String date;

    public Note() {
    }

    public Note(String title, String note, String user, String date) {
        this.title = title;
        this.note = note;
        this.user = user;
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
