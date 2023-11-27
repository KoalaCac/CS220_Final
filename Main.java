import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws IOException {
    // Student jonjon =  new Student(12345, "Jon Jon", 12, "tugrp@example.com", "password"); 
    // System.out.println(jonjon.getAttend());
    Student.setAsUser(new Student("Empty User", 0, "", "00000"));
    new Student("Johnny Test", 11, "imnotreal@gmail.com", "abc123");
    new Student("admin ",0,"admin@root.com", "password");
    new Announcement("testjohnny11", "Hello everyone, In Wednesday class (11/01), we had a review class. We reviewed the sample questions. The review guideline and sample questions with solutions are posted in week-9 page. Midterm Exam Review Students will take the midterm exam in-class on Monday Nov. 6, 9:30am-10:45am. Let me know if you have any further questions. See you all in class next Monday, Nov. 6 at 9:30am.");
    new Announcement("testjohnny11", "Helllooooo", "2023-09-09");
    new Announcement("testjohnny11", "KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK", "2023-11-04");
    new Announcement("testjohnny11", "Hello everyone, In Wednesday class (11/01), we had a review class. We reviewed the sample questions. The review guideline and sample questions with solutions are posted in week-9 page. Midterm Exam Review Students will take the midterm exam in-class on Monday Nov. 6, 9:30am-10:45am. Let me know if you have any further questions. See you all in class next Monday, Nov. 6 at 9:30am.", "2023-11-14");
    new Announcement("testjohnny11", "Hello everyone, In Wednesday class (11/01), we had a review class. We reviewed the sample questions. The review guideline and sample questions with solutions are posted in week-9 page. Midterm Exam Review Students will take the midterm exam in-class on Monday Nov. 6, 9:30am-10:45am. Let me know if you have any further questions. See you all in class next Monday, Nov. 6 at 9:30am.", "2023-10-31");
    new Announcement("testjohnny11", "Hello everyone, In Wednesday class (11/01), we had a review class. We reviewed the sample questions. The review guideline and sample questions with solutions are posted in week-9 page. Midterm Exam Review Students will take the midterm exam in-class on Monday Nov. 6, 9:30am-10:45am. Let me know if you have any further questions. See you all in class next Monday, Nov. 6 at 9:30am.", "2024-02-27");
    new Class("Intermediate Java", "2023", "S1", "COMPSCI220");
    new Class("College English", "2023", "S2", "ENG101");
    new Class("Server Side Scripting", "2023", "S1", "compsci382");
    new Class("Discrete Structures", "2023", "S1", "CompSci215");
    new Class("Swagger", "2025", "S1", "Swagg999");
    Student.printStudents();
    // new GradesGUI();
    new LoginGUI();
    //g.clickerGui();
    
    
  }
}