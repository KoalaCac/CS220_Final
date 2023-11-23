import java.util.ArrayList;

public class Class {
    
    private ArrayList<Student> usersInClass;
    private static ArrayList<Class> classesAll = new ArrayList<>();
    private String name;
    private String year;
    private String semester;
    private String major;
    private int number;

    public Class(String name, String year, String semester, String major, int number) {
        this.name = name;
        this.year = year;
        this.semester = semester;
        this.major = major;
        this.number = number;
        classesAll.add(this);
    }

    public String toString() {
        return (major + number + "_" + semester + "_" + year).toUpperCase();
    }

    public static ArrayList<Class> getClassesAll() {
        return classesAll;
    }

    public String getName() {
        return name;
    }

    

}
