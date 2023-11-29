import java.util.ArrayList;

public class Class {
    
    private ArrayList<Student> usersInClass = new ArrayList<>();
    private ArrayList<Assignment> assignments = new ArrayList<>();
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

    public ArrayList<Assignment> getAssignments() {
        return assignments;
    }

    public void addUserToClass(Student stu) {
        usersInClass.add(stu);
    }

    public void setUsersInClass(ArrayList<Student> usersInClass) {
        this.usersInClass = usersInClass;
    }

    public ArrayList<Student> getUsersInClass() {
        return usersInClass;
    }

    public void addAssignment(Assignment a) {
        assignments.add(a);
    }

    public String getName() {
        return name;
    }

    public static Class findClass(String user) {
        for (Class c : classesAll) {
            if (c.getId().equalsIgnoreCase(user)) {
                return c;
            }
        }
        return null;
      }

    public String getId() {
        return id;
    }    


      

}
