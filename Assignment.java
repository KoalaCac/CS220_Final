import java.time.*;
import java.util.*;

public class Assignment extends Event {

    private double grade; 
    private Class assignClass;
    private String name;
    private static ArrayList<Assignment> assignments = new ArrayList<Assignment>();
    private HashMap<Student, Double> gradesMap = new HashMap<>();
    
    public Assignment(Class assignClass, String name) {
        super();
        this.assignClass = assignClass;
        this.name = name;
        assignments.add(this);
        for (Student s : assignClass.getUsersInClass()) {
            gradesMap.put(s,0.0);
        }
        
    }


    public Assignment(Class assignClass, String name, double grade) {
        super();
        this.assignClass = assignClass;
        this.name = name;
        this.grade = grade;
        assignments.add(this);
    }

    public Assignment(Class assignClass, String name, double grade, String dateCreated) {
        super();
        setDateCreated(LocalDate.parse(dateCreated));
        this.assignClass = assignClass;
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

    @Override
    public String toString() {
        return assignClass + " " +  name + ": " + grade;
    }


    public Class getAssignClass() {
        return assignClass;
    }



    
}
