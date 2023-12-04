import java.util.*;

public class Class {
    
    private ArrayList<Student> usersInClass = new ArrayList<>(); 
    private HashMap<Student, Double> grades; 
    private ArrayList<Assignment> assignments = new ArrayList<>();
    private static ArrayList<Class> classesAll = new ArrayList<>(); //Master list
    private String name;
    private String year;
    private String semester;
    private String id;

    public Class(String name, String year, String semester, String id) {
        this.name = name;
        this.year = year;
        this.semester = semester;
        this.id = id;
        grades = new HashMap<>();
        classesAll.add(this);
    }

    public String toString() {
        return "<html>" + (id + "_" + semester + "_" + year + "<br/>" + name).toUpperCase() + "<html>"; //Used for classes area
    }

    public static ArrayList<Class> getClassesAll() {
        return classesAll;
    }

    public void setGrades(HashMap<Student, Double> grades) {
        this.grades = grades;
    }

    public HashMap<Student, Double> getGrades() {
        return grades;
    }

    public void putGrades(Student stu, Double dou) {
        grades.put(stu, dou);        
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

    public static Class findClass(String user) { // Find class according to ID
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

    public static void recalculateGrades() { //Used to swiftly calculate grades after changes
        for (Class c : classesAll) {
            c.setGrades(new HashMap<>());
            for (Student s : c.getUsersInClass()) {
                double sum = 0;
                for (Assignment a : c.getAssignments()) {
                    sum = sum + a.getGradesMap().get(s);
                }
                if (c.getAssignments().size() > 0) {
                    sum = sum / c.getAssignments().size();
                    s.addGrades(sum);
                    c.putGrades(s, sum);
                }
            }
        }
    }
}
