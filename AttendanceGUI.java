import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.YearMonth;

public class AttendanceGUI {

        JFrame frame;
        JPanel panel;
        JLabel dateLabel;
        int monthInd;


    public AttendanceGUI() {
        panel = new JPanel(new BorderLayout());
        frame = new JFrame("Edit attendance for students");
        frame.setSize(1000,700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.add(panel);

        


        JPanel header = new JPanel();
        JPanel buttonsPanel = new JPanel();
        JButton nextMonth = new JButton(">");
        JButton lastMonth = new JButton("<");
        dateLabel = new JLabel("", SwingConstants.CENTER);

        header.add(lastMonth);
        header.add(nextMonth);
        header.add(dateLabel);
        panel.add(header, BorderLayout.NORTH);
        panel.add(buttonsPanel, BorderLayout.CENTER);

        updateCal(0);
        
        int i = 0;
        for (Student stu : Student.getStudentList()) {
            JCheckBox checkBox = new JCheckBox(stu.getName());
            checkBox.setFont(new Font("Arial", Font.PLAIN, 20));
            
            checkBox.setBounds(10 + (150 * (i % 6)), 100 + (50 * (i / 6)), 150, 25);
            checkBox.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    
                }
            });
            buttonsPanel.add(checkBox);
            i++;
        }

        lastMonth.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateCal(monthInd-1);
            }
        });

        nextMonth.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateCal(monthInd+1);
            }
        });

        
        


        
        frame.setVisible(true);
    }

    public void updateCal(int change) {
        monthInd = change;
        LocalDate currentDate = LocalDate.now().plusMonths(change);
        YearMonth yearMonth = YearMonth.of(currentDate.getYear(), currentDate.getMonth());
        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

        String monthYearText = months[currentDate.getMonthValue() - 1] + " " + currentDate.getYear();
        dateLabel.setText(monthYearText);
    }




}