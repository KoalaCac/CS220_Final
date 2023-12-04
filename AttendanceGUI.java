import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class AttendanceGUI implements ActionListener {

        private JFrame frame;
        private JPanel panel;
        private JLabel dateLabel;
        private int monthInd;
        private JPanel buttonsPanel;

    public AttendanceGUI() {
        panel = new JPanel(new BorderLayout());
        frame = new JFrame("Edit attendance for students");
        frame.setSize(1000,700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.add(panel);

        JPanel header = new JPanel();
        buttonsPanel = new JPanel();
        JButton nextDay = new JButton(">");
        dateLabel = new JLabel("", SwingConstants.CENTER);
        JButton lastDay = new JButton("<");
        
        //Add to panels
        header.add(lastDay);
        header.add(nextDay);
        header.add(dateLabel);
        panel.add(header, BorderLayout.NORTH);
        panel.add(buttonsPanel, BorderLayout.CENTER);

        updateCal(0);
        
        lastDay.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateCal(monthInd-1);
            }
        });

        nextDay.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateCal(monthInd+1);
            }
        });

        //Back to home
        JButton button0 = new JButton("Back");
        button0.addActionListener(this);
        button0.setBounds(0,0, 125, 25);
        header.add(button0);    
        
        frame.setVisible(true);
    }

    public void updateCal(int change) { //Same idea as agenda, this time adding checkboxes instead of cells
        monthInd = change;
        buttonsPanel.removeAll();
        LocalDate currentDate = LocalDate.now().plusDays(change);
        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

        int i = 0;
        for (Student stu : Student.getStudentList()) {
            JCheckBox checkBox = new JCheckBox(stu.getName());
            checkBox.setFont(new Font("Arial", Font.PLAIN, 20));
            checkBox.setBounds(10 + (150 * (i % 6)), 100 + (50 * (i / 6)), 150, 25);
            checkBox.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (checkBox.isSelected()) {
                        stu.updateAtt(currentDate, true); //User is here
                    }
                    else {
                        stu.updateAtt(currentDate, false); //User is absent
                    }
                }
            });
            buttonsPanel.add(checkBox);
            i++;
        }

        String monthYearText = months[currentDate.getMonthValue() - 1] + " " + currentDate.getDayOfMonth() + " " + currentDate.getYear();
        dateLabel.setText(monthYearText);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        frame.dispose();
        new HomeGUI();
    }
}