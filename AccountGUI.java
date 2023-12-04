import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Map;
import java.awt.event.*;

public class AccountGUI implements ActionListener {
    

    private JFrame frame;
    private JPanel panel;

    public AccountGUI() throws IOException {
        //Instantiate the window
        panel = new JPanel(null);
        frame = new JFrame(Student.getAsUser().getName() + "'s Account Info");
        frame.setSize(700, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.add(panel);

        //Creates a header above your info
        JLabel title = new JLabel("Your info:");
        title.setFont(new Font("Monospaced", Font.BOLD, 20));
        title.setBounds(50, 50, 500, 50);
        panel.add(title);

        //Shows a box containing the current user's name
        JLabel nameInfo = new JLabel("<html> User Name:<br/>" + Student.getAsUser().getName() + "<html>");
        nameInfo.setFont(new Font("Monospaced", Font.PLAIN, 15));
        nameInfo.setBounds(50, 100, 500, 50);
        nameInfo.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createRaisedBevelBorder(), BorderFactory.createLoweredBevelBorder()));
        nameInfo.setVerticalAlignment(JLabel.TOP);
        panel.add(nameInfo);

        //Current user's ID
        JLabel idInfo = new JLabel("<html>User ID:<br/>" + Student.getAsUser().getId() + "<html>");
        idInfo.setFont(new Font("Monospaced", Font.PLAIN, 15));
        idInfo.setBounds(50, 170, 500, 50);
        idInfo.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createRaisedBevelBorder(), BorderFactory.createLoweredBevelBorder()));
        idInfo.setVerticalAlignment(JLabel.TOP);
        panel.add(idInfo);

        //Current user's grade
        //If their grade is zero, they are faculty
        JLabel gradeInfo = new JLabel("<html>User Grade:<br/>" + Student.getAsUser().getGrade() + "<html>");
        gradeInfo.setFont(new Font("Monospaced", Font.PLAIN, 15));
        gradeInfo.setBounds(50, 240, 500, 50);
        gradeInfo.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createRaisedBevelBorder(), BorderFactory.createLoweredBevelBorder()));
        gradeInfo.setVerticalAlignment(JLabel.TOP);
        if (Student.getAsUser().getGrade() == 0) {
            gradeInfo.setText("<html>User Grade:<br/> You are logged in as a faculty member<html>");
        }
        panel.add(gradeInfo);

        //User's email
        JLabel emailInfo = new JLabel("<html>User Email:<br/>" + Student.getAsUser().getEmail() + "<html>");
        emailInfo.setFont(new Font("Monospaced", Font.PLAIN, 15));
        emailInfo.setBounds(50, 310, 500, 50);
        emailInfo.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createRaisedBevelBorder(), BorderFactory.createLoweredBevelBorder()));
        emailInfo.setVerticalAlignment(JLabel.TOP);
        panel.add(emailInfo);

        //Displays every day current user was set to be absent
        JLabel attendanceInfo = new JLabel();
        String formatString = "";
        for (Map.Entry<LocalDate, Boolean> set : Student.getAsUser().getAttendanceData().entrySet()) {
            if (set.getValue() == false) {
                formatString = formatString + set.getKey() + ": Absent" + "<br/>";
            }
            
        }
        attendanceInfo.setText("<html>Absent Days:<br/>" + formatString + "<html>");
        attendanceInfo.setFont(new Font("Monospaced", Font.PLAIN, 15));
        attendanceInfo.setBounds(50, 380, 500, 200);
        attendanceInfo.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createRaisedBevelBorder(), BorderFactory.createLoweredBevelBorder()));
        attendanceInfo.setVerticalAlignment(JLabel.TOP);
        panel.add(attendanceInfo);

        //Go back to Home
        JButton button0 = new JButton("Back");
        button0.setBounds(0, 0, 100, 25);
        button0.setVerticalAlignment(JLabel.TOP);
        button0.addActionListener(this);
        panel.add(button0);

        //Generates a report of grades, attendance, and GPA in anouncements in Home
        JButton reportButton =  new JButton("Generate Personal Report");
        reportButton.setVerticalAlignment(JLabel.TOP);
        reportButton.setBounds(350, 70, 200, 25);
        reportButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Announcement(Student.getAsUser().getId(), Student.getAsUser().allDataString(), 20);
                
            }
        });
        panel.add(reportButton);

        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
            frame.dispose();
            new HomeGUI();
    }
}
