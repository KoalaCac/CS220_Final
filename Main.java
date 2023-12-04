import java.io.*;

public class Main {

  public static void main(String[] args) throws IOException {

    //Make some new users
    Student.setAsUser(new Student("Empty User", 0, "", "00000"));
    
    new Student("admin ",0,"admin@root.com", "password");
    new Student("Nikola Tesla", 0, "electric@gmail.com", "coil");
    new Student("Issac Newton", 0, "physics@gmail.com", "calc");
    new Student("Albert Einstein", 0, "reletivity@gmail.com", "EMC");
    new Student("Neil Tyson", 0, "startalk@gmail.com", "quantum");
    
    new Student("Keller Hominick", 11, "kellerzoozoo@gmail.com", "toor");
    new Student("Johnny Test", 11, "imnotreal@gmail.com", "abc123");
    new Student("John Doe", 9, "doejohn@gmail.com", "wasd");

    //Add a few test announcements
    new Announcement("testjohnny11", "Hello everyone, In Wednesday class (11/01), we had a review class. We reviewed the sample questions. The review guideline and sample questions with solutions are posted in week-9 page. Midterm Exam Review Students will take the midterm exam in-class on Monday Nov. 6, 9:30am-10:45am. Let me know if you have any further questions. See you all in class next Monday, Nov. 6 at 9:30am.", "2023-09-09");
    new Announcement("testjohnny11", "Hello HomeGUI!", "2023-09-09");
    Student.printStudents(); // prints every student to a .CSV file, for further development
    new LoginGUI(); //Kickstart GUI
   
    
  }
}