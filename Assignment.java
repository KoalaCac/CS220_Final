import java.time.*;
import java.util.*;

public class Assignment extends Event {

    private Class assignClass;
    private String name;
    private static ArrayList<Assignment> assignments = new ArrayList<Assignment>();
    private HashMap<Student, Double> gradesMap = new HashMap<>();


    public Assignment(Class assignClass, String name) {
        super();
        this.assignClass = assignClass;
        this.name = name;
        assignments.add(this);
    }

    public Assignment(Class assignClass, String name, String dateCreated) {
        super();
        setDateCreated(LocalDate.parse(dateCreated));
        this.assignClass = assignClass;
        this.name = name;
        for (Student s : assignClass.getUsersInClass()) {
            gradesMap.put(s,0.0);
        }
        assignments.add(this);
    }

    public Class getassignClass() {
        return assignClass;
    }

    

    public HashMap<Student, Double> getGradesMap() {
        return gradesMap;
    }


    public void setassignClass(Class assignClass) {
        this.assignClass = assignClass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Class getAssignClass() {
        return assignClass;
    }



    
}
