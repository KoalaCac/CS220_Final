import java.util.ArrayList;
import java.time.*;

public class Event {
    
    private static ArrayList<Event> eventList = new ArrayList<Event>(); //Master list
    private LocalDate dateCreated;

    public Event() {
        eventList.add(this);
        dateCreated = LocalDate.now();
    }

    public static ArrayList<Event> getEventList() {
        return eventList;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }
    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    

    
}
