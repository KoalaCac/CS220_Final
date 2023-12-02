import java.time.LocalDate;
import java.util.ArrayList;

public class Announcement extends Event {

    private String text;
    private Student user;
    private int lengthMult;
    private static ArrayList<Announcement> announceList = new ArrayList<Announcement>();

    public Announcement(String user, String text, int lengthMult) {
        super();
        setDateCreated(LocalDate.now());
        this.lengthMult = lengthMult;
        this.user = Student.findUser(user);
        this.text = "<html>" + text + "<br/>-" + this.user.getName() + "<html>";
        announceList.add(0, this);
    }

    public Announcement(String user, String text, String changeDate) {
        super();
        setDateCreated(LocalDate.parse(changeDate));
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