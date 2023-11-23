
import java.io.*;
import java.util.ArrayList;

public class Student {
  private String id;
  private String name;
  private int grade;
  private String email;
  private String pass;
  private static Student asUser;
  private static ArrayList<Student> studentList = new ArrayList<>();
  private ArrayList<Double> grades = new ArrayList<>(); 
  private ArrayList<Class> classesEnrolled = Class.getClassesAll(); //Change soon
  

  public Student(String name, int grade, String email, String pass) throws IOException {
    this.id = name.toLowerCase().substring(name.indexOf(" ") + 1) + name.toLowerCase().substring(0, name.indexOf(" ")) + grade;
    this.name = name;
    this.grade = grade;
    this.email = email;
    this.pass = pass;
    studentList.add(this);
  }

  

  public static void printStudents() throws IOException {
    PrintWriter writeFile = new PrintWriter("studentData.csv");
    for (Student s : studentList) {
      writeFile.println(s.getId() + "," + s.getName() + "," + s.getGrade() + "," + s.getEmail() + "," + s.getPass());
    }
    writeFile.close();
  }

  public static Student findUser(String user) {
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

  public static void setAsUser(String asUser) {
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

  public void setGrades(ArrayList<Double> grades) {
    this.grades = grades;
  }

  public double getGpa() {
    double sum = 0;
    for (double g : grades) {
      sum += (g / 100) * 4;
    }
    return sum / grades.size();
  }



}