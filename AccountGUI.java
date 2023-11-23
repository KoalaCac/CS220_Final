import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.awt.event.*;

public class AccountGUI implements ActionListener {
    

    JFrame frame;
    JPanel panel;

    public AccountGUI() throws IOException {
        panel = new JPanel(null);
        frame = new JFrame(Student.getAsUser().getName() + "'s Account Info");
        frame.setSize(700, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.add(panel);

        JLabel title = new JLabel("Your info:");
        title.setFont(new Font("Monospaced", Font.BOLD, 20));
        title.setBounds(50, 50, 500, 50);
        panel.add(title);

        
        JLabel nameInfo = new JLabel("<html> User Name:<br/>" + Student.getAsUser().getName() + "<html>");
        nameInfo.setFont(new Font("Monospaced", Font.PLAIN, 15));
        nameInfo.setBounds(50, 100, 500, 50);
        nameInfo.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createRaisedBevelBorder(), BorderFactory.createLoweredBevelBorder()));
        nameInfo.setVerticalAlignment(JLabel.TOP);
        panel.add(nameInfo);

        JLabel idInfo = new JLabel("<html>User ID:<br/>" + Student.getAsUser().getId() + "<html>");
        idInfo.setFont(new Font("Monospaced", Font.PLAIN, 15));
        idInfo.setBounds(50, 170, 500, 50);
        idInfo.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createRaisedBevelBorder(), BorderFactory.createLoweredBevelBorder()));
        idInfo.setVerticalAlignment(JLabel.TOP);
        panel.add(idInfo);

        JLabel gradeInfo = new JLabel("<html>User Grade:<br/>" + Student.getAsUser().getGrade() + "<html>");
        gradeInfo.setFont(new Font("Monospaced", Font.PLAIN, 15));
        gradeInfo.setBounds(50, 240, 500, 50);
        gradeInfo.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createRaisedBevelBorder(), BorderFactory.createLoweredBevelBorder()));
        gradeInfo.setVerticalAlignment(JLabel.TOP);
        if (Student.getAsUser().getGrade() == 0) {
            gradeInfo.setText("<html>User Grade:<br/> You are logged in as a faculty member<html>");
        }
        panel.add(gradeInfo);

        JLabel emailInfo = new JLabel("<html>User Email:<br/>" + Student.getAsUser().getEmail() + "<html>");
        emailInfo.setFont(new Font("Monospaced", Font.PLAIN, 15));
        emailInfo.setBounds(50, 310, 500, 50);
        emailInfo.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createRaisedBevelBorder(), BorderFactory.createLoweredBevelBorder()));
        emailInfo.setVerticalAlignment(JLabel.TOP);
        panel.add(emailInfo);

        JButton button0 = new JButton("Back");
        button0.setBounds(0, 0, 100, 25);
        button0.setVerticalAlignment(JLabel.TOP);
        button0.addActionListener(this);
        panel.add(button0);

        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
            frame.dispose();
            new HomeGUI();
    }
}
