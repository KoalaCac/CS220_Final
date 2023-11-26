import java.time.*;
import java.util.ArrayList;

public class Assignment extends Event {

    private double grade; 
    private String whichClass;
    private String name;
    private ArrayList<Assignment> assignments = new ArrayList<Assignment>();
    
    public Assignment(String whichClass, String name) {
        super();
        this.whichClass = whichClass;
        this.name = name;
        assignments.add(this);
    }


    public Assignment(String whichClass, String name, double grade) {
        super();
        this.whichClass = whichClass;
        this.name = name;
        this.grade = grade;
        assignments.add(this);
    }

    public Assignment(String whichClass, String name, double grade, String dateCreated) {
        super();
        setDateCreated(LocalDate.parse(dateCreated));
        this.whichClass = whichClass;
        this.name = name;
        this.grade = grade;
        assignments.add(this);
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public String getWhichClass() {
        return whichClass;
    }

    public void setWhichClass(String whichClass) {
        this.whichClass = whichClass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return whichClass + " " +  name + ": " + grade;
    }



    
}
