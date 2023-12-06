import java.time.LocalDate;
import java.util.ArrayList;

public class Announcement extends Event {

    private String text;
    private Student user;
    private int lengthMult;
    private static ArrayList<Announcement> announceList = new ArrayList<Announcement>(); //Master list

    public Announcement(String user, String text, int lengthMult) {
        super();
        setDateCreated(LocalDate.now()); //If date is not answered, take the current one
        this.lengthMult = lengthMult;
        this.user = Student.getAsUser(); //Convert username to Student
        this.text = "<html>" + text + "<br/>-" + this.user.getName() + "<html>";
        announceList.add(0, this); //Add to bottom of list, so recent announcements show first when iterating
    }

    public Announcement(String user, String text, String changeDate) {
        super();
        setDateCreated(LocalDate.parse(changeDate)); //Convert string entered to date
        this.lengthMult = 0;
        this.user = Student.findUser(user);
        this.text = "<html>" + text + "<br/>-" + this.user.getName() + "<html>";
        announceList.add(0,this);
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

    @Override
    public String toString() {
        return user.getName() + " sent an announcement";
    }

    public int getLengthMult() {
        return lengthMult;
    }
}