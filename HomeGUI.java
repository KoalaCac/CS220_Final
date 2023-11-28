import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class HomeGUI implements ActionListener {

    private JFrame frame;
    private JPanel panel;

    private enum Actions {
        ACCOUNTINFO,
        GRADES,
        ATTENDANCE,
        AGENDA,
        SCHEDULE,
        LOGOUT
      }

    public HomeGUI() {

        panel = new JPanel(null);
        frame = new JFrame("Welcome " + Student.getAsUser().getName());
        frame.setSize(1000,700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.add(panel);

        JScrollPane scrollBar = new JScrollPane(panel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        frame.add(scrollBar);
        
        
        JButton button = new JButton("Your account");
        button.setActionCommand(Actions.ACCOUNTINFO.name());
        button.setBounds(50, 10, 150, 25);
        button.addActionListener(this);
        panel.add(button);

        JButton button2 = new JButton("Grades");
        button2.setActionCommand(Actions.GRADES.name());
        button2.setBounds(410, 10, 150, 25);
        button2.addActionListener(this);
        panel.add(button2);

        JButton button5 = new JButton("Agenda");
        button5.setActionCommand(Actions.AGENDA.name());
        button5.setBounds(590, 10, 150, 25);
        button5.addActionListener(this);
        panel.add(button5);


        JButton button4 = new JButton("Log out");
        button4.setActionCommand(Actions.LOGOUT.name());
        button4.setBounds(770, 10, 150, 25);
        button4.addActionListener(this);
        panel.add(button4);

        String[] choices = { "New...", "Announcement", "Assignment", "Class" }; 
        JComboBox<String> button6 = new JComboBox<String>(choices);
        button6.setBounds(230, 10, 150, 25);

        button6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedItem = (String) button6.getSelectedItem();
                if (!selectedItem.equals("New...")) {new NewGUI(selectedItem); frame.dispose();}
            }
        });



        panel.add(button6);


        //Debug
        ArrayList<Double> arrGrades = new ArrayList<>();
        arrGrades.add(98.7);
        arrGrades.add(98.6);
        arrGrades.add(98.5);
        arrGrades.add(98.4);
        arrGrades.add(98.3);
        Student.getAsUser().setGrades(arrGrades);

        //Assignment as1 = new Assignment("COMPSCI220", "Java Collections Framework Quiz", 0);
        

        JLabel titleAnnounce = new JLabel("Announcements");
        titleAnnounce.setFont(new Font("Monospaced", Font.BOLD, 20));
        titleAnnounce.setBounds(50, 50, 500, 50);
        panel.add(titleAnnounce);

        int yLevel = 0;
        for (Announcement a : Announcement.getAnnounceList()) {
            JLabel currentAnnounce = new JLabel(a.getText());
            currentAnnounce.setFont(new Font("Monospaced", Font.PLAIN, 15));
            currentAnnounce.setBounds(50, 100 + yLevel, 500, 200);
            currentAnnounce.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createRaisedBevelBorder(), BorderFactory.createLoweredBevelBorder()));
            currentAnnounce.setVerticalAlignment(JLabel.TOP);
            panel.add(currentAnnounce);
            yLevel += 210;
        }

        panel.setPreferredSize(new Dimension(100, yLevel + 300));

        JLabel titleGrades = new JLabel("Classes");
        titleGrades.setFont(new Font("Monospaced", Font.BOLD, 20));
        titleGrades.setBounds(650, 50, 500, 50);
        panel.add(titleGrades);

        yLevel = 0;
        System.out.println(Class.getClassesAll().size());
        for (Class c : Class.getClassesAll()) {
            System.out.println("1");
            JLabel currentGrade = new JLabel(c.toString());
            currentGrade.setFont(new Font("Monospaced", Font.PLAIN, 15));
            currentGrade.setBounds(650, 100 + yLevel, 600, 50);
            currentGrade.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createRaisedBevelBorder(), BorderFactory.createLoweredBevelBorder()));
            currentGrade.setVerticalAlignment(JLabel.TOP);
            panel.add(currentGrade);
            yLevel += 60;
        }

        
        frame.setVisible(true);

    }


    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();
        
        switch (Actions.valueOf(actionCommand)) {
            case ACCOUNTINFO:
                frame.dispose();
                try {
                    new AccountGUI();
                } catch (IOException ioe) {

                }
                break;
            case GRADES:
                frame.dispose();
                new GradesGUI();
                break;
            case AGENDA:
                frame.dispose();
                new AgendaGUI();
                break;
            case LOGOUT:
                frame.dispose();
                try { 
                    new LoginGUI();
                } catch (IOException ioe) {
                    
                }
                break;
            default:
                break;
        }
    }
}
