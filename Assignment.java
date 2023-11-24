import java.time.*;
import java.util.ArrayList;

public class Assignment extends Event {

    private double grade; 
    private String whichClass;
    private String name;
    private LocalDate dateCreated;
    private ArrayList<Assignment> assignments = new ArrayList<Assignment>();
    
    public Assignment(String whichClass, String name, double grade) {
        super();
        this.whichClass = whichClass;
        this.name = name;
        this.grade = grade;
        dateCreated = LocalDate.now();
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

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Override
    public String toString() {
        return whichClass + " " +  name + ": " + grade;
    }



    
}
