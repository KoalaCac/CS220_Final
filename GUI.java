//Will include each student, their grades, and attendance in an interface
//Log in as well for professors and students
//This is the class where student data will be visualized using JFrame
//Will not be implemented until I feel like it lol
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.BorderFactory;

public class GUI implements ActionListener {

  private int count = 0;
  private JLabel label;
  private JFrame frame;
  private JPanel panel;
  private int act;
  
  public GUI() { //I learn swing 
  }

  public void actionPerformed(ActionEvent e) {
    switch(act) {
      case 1:
        count++;
        label.setText("Number of clicks: " + count);
        break;

      case 2:
        
        break;

      default:
        break;

    }
  }

  //Learning swing for the first time
  public void clickerGui() {
    act = 1;
    frame = new JFrame("Student Data");
    frame.setSize(100, 100);

    JButton button = new JButton("Click");
    button.addActionListener(this);
    label = new JLabel("Num clicks:" + count);

    panel = new JPanel();
    panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
    panel.setLayout(new GridLayout(0, 1));
    panel.add(button);
    panel.add(label);

    frame.add(panel, BorderLayout.CENTER);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);


  }

  //Setting up GUI methods for different pages
  //Each method is a page
  
  public void login() { //Login screen
    act = 2;
    panel = new JPanel();
    frame = new JFrame("Account Sign In");
    frame.setSize(350,200);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    frame.add(panel);

    panel.setLayout(null);

    JLabel userLabel = new JLabel("ID:");
    userLabel.setBounds(10, 20, 80, 25);
    panel.add(userLabel);

    JTextField userText = new JTextField();
    userText.setBounds(100, 20, 165, 25);
    panel.add(userText);

    JLabel passLabel = new JLabel("PASSWORD:");
    passLabel.setBounds(10, 50, 80, 25);
    panel.add(passLabel);

    JPasswordField passText = new JPasswordField();
    passText.setBounds(100, 50, 165, 25);
    panel.add(passText);

    JButton button = new JButton("Login");
    button.setBounds(10, 80, 80, 25);
    button.addActionListener(this);
    panel.add(button);
    
    JLabel success =  new JLabel("");
    success.setBounds(10, 110, 300, 25);
    panel.add(success);
    

    frame.setVisible(true);
  }

  public void grades() { //Spreadsheet of grades
    
  }

  public void attendance() { //Spreadsheet of att
    
  }

  public void studentInfo(Student s) { //page of student info 
    
  }

  
}
  