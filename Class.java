import java.util.ArrayList;

public class Class {
    
    private ArrayList<Student> usersInClass;
    private static ArrayList<Class> classesAll = new ArrayList<>();
    private String name;
    private String year;
    private String semester;
    private String id;

    public Class(String name, String year, String semester, String id) {
        this.name = name;
        this.year = year;
        this.semester = semester;
        this.id = id;
        classesAll.add(this);
    }

    public String toString() {
        return "<html>" + (id + "_" + semester + "_" + year + "<br/>" + name).toUpperCase() + "<html>";
    }

    public static ArrayList<Class> getClassesAll() {
        return classesAll;
    }

    public String getName() {
        return name;
    }

    

}
