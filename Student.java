
import java.io.*;
import java.util.*;
import java.time.*;

public class Student {
  private String id;
  private String name;
  private int grade;
  private String email;
  private String pass;
  private static Student asUser;
  private ArrayList<Double> grades = new ArrayList<>();
  private static ArrayList<Student> studentList = new ArrayList<>(); //Master list
  private ArrayList<Class> classesEnrolled = new ArrayList<>();
  private HashMap<LocalDate, Boolean> attendanceData = new HashMap<>();
  

  public Student(String name, int grade, String email, String pass) throws IOException {
    //Calculate ID
    this.id = name.toLowerCase().substring(name.indexOf(" ") + 1) + name.toLowerCase().substring(0, name.indexOf(" ")) + grade;
    this.name = name;
    this.grade = grade;
    this.email = email;
    this.pass = pass;
    studentList.add(this);
  }

  

  public static void printStudents() throws IOException { //Print students to studentData.csv
    PrintWriter writeFile = new PrintWriter("studentData.csv");
    for (Student s : studentList) {
      writeFile.println(s.getId() + "," + s.getName() + "," + s.getGrade() + "," + s.getEmail() + "," + s.getPass());
    }
    writeFile.close();
  }

  public static Student findUser(String user) { //Find user in master list
    for (Student s : studentList) {
        if (s.getId().equalsIgnoreCase(user)) {
            return s;
        }
    }
    return null;
  }

  public String getId() {
    return id;
  }

  public void addClass(Class c) {
    classesEnrolled.add(c);
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getPass() {
    return pass;
  }

  public void setPass(String pass) {
    this.pass = pass;
  }

  public String getName() {
    return name;
  }

  public int getGrade() {
    return grade;
  }

  public String getEmail() {
    return email;
  }

  public static ArrayList<Student> getStudentList() {
    return studentList;
  }

  public static Student getAsUser() {
    return asUser;
  }

  public static void setAsUser(String asUser) { //set as current logged in user
    for (Student s : studentList) {
          if (s.getId().equalsIgnoreCase(asUser)) {
              Student.asUser = s;
          }
      }
  }

  public static void setAsUser(Student asUser) {
    Student.asUser = asUser;
  }

  public ArrayList<Class> getClassesEnrolled() {
    return classesEnrolled;
  }

  public ArrayList<Double> getGrades() {
    return grades;
  }

  public void addGrades(double g) {
    grades.add(g);
  }

  public double getGpa() { //calculate GPA
    double finsum = 0;
    for (Class c : classesEnrolled) {
      finsum += c.getGrades().get(this);
    }
    return ((finsum / classesEnrolled.size()) / 100) * 4;
  }



  public HashMap<LocalDate, Boolean> getAttendanceData() {
    return attendanceData;
  }

  public void updateAtt(LocalDate date, Boolean isPresent) {
    attendanceData.put(date, isPresent);
  }

  public String attendanceToString() { //Each attendance entry put into string format
    String result = "";
    for (Map.Entry<LocalDate, Boolean> set : attendanceData.entrySet()) {
      result = result + set.getKey() + ": " + ((set.getValue()) ? "Here" : "Absent") + "<br/>";
    }
    return result ;
  }

  public String allDataString() { //Used for generating personal report
    String result = getAsUser().getName().toUpperCase() + "'S INFO:<br/>";
    result += "----GRADES---- <br/>";
    for (Class c : classesEnrolled) {
      result += String.format(c.getName().toUpperCase() + ": %.2f <br/>" , c.getGrades().get(getAsUser()));
      for (Assignment a : c.getAssignments()) {
        result += String.format("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + a.getName() + ": %.2f <br/>" , a.getGradesMap().get(getAsUser()));
      }
    }
    result += "----ATTENDANCE---- <br/>" + getAsUser().attendanceToString();
    result += "----GPA---- <br/>" + getAsUser().getGpa();

    return result ;
  }
}