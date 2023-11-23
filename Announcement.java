import java.util.ArrayList;


public class Announcement {

    private String text;
    private Student user;
    private static ArrayList<Announcement> announceList = new ArrayList<Announcement>();

    public Announcement(String user, String text) {
        this.user = Student.findUser(user);
        this.text = "<html>" + text + "<br/>-" + this.user.getName() + "<html>";
        announceList.add(this);
    }

    public static ArrayList<Announcement> getAnnounceList() {
        return announceList;
    }

    public String getText() {
        return text;
    }

    public Student getUser() {
        return user;
    }


    
    



}