import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.*;

public class NewGUI implements ActionListener {
    
    JFrame frame;
    JPanel panel;

    public NewGUI(String selectedItem) {

        panel = new JPanel(null);
        frame = new JFrame("Make a new " + selectedItem);
        frame.setSize(700,700);
        frame.setLocationRelativeTo(null);
        frame.add(panel);

        JFrame success = new JFrame("Message");
        success.setSize(600,600);

        JButton back = new JButton("Back");
                back.setBounds(0,0,100,25);
                panel.add(back);

                back.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        frame.dispose();
                        new HomeGUI();
                    }
                });

        if (selectedItem.equals("Announcement") || selectedItem.equals("Assignment")) {
            JLabel dateLabel = new JLabel("Date Created:");
            dateLabel.setBounds(20, 40, 200, 30);
            dateLabel.setVerticalAlignment(JLabel.TOP);
            dateLabel.setFont(new Font("Monospaced", Font.PLAIN, 20));
            panel.add(dateLabel);

            JTextField dateField = new JTextField(LocalDate.now().toString());
            dateField.setBounds(20, 90, 200,30);
            panel.add(dateField);

            

            if (selectedItem.equals("Announcement")) {
                JLabel textLabel = new JLabel("Text:");
                textLabel.setBounds(20, 150, 200, 30);
                textLabel.setVerticalAlignment(JLabel.TOP);
                textLabel.setFont(new Font("Monospaced", Font.PLAIN, 20));
                panel.add(textLabel);

                JTextArea textArea = new JTextArea();
                textArea.setBounds(20,200,200,30);
                textArea.setSize(200,200);
                textArea.setLineWrap(true);
                textArea.setWrapStyleWord(true);
                textArea.setMargin(new Insets(5, 5, 5, 5));
                textArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                panel.add(textArea);

                JButton enter = new JButton("Enter");
                enter.setBounds(20,400,150,25);
                panel.add(enter);

                enter.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        new Announcement(Student.getAsUser().getId(), textArea.getText(), dateField.getText());
                        new HomeGUI();
                        JOptionPane.showMessageDialog(success, selectedItem + " created!");
                        
                    }
                });
            }
            if (selectedItem.equals("Assignment")) {
                JLabel textLabel = new JLabel("Class:");
                textLabel.setBounds(20, 130, 200, 30);
                textLabel.setVerticalAlignment(JLabel.TOP);
                textLabel.setFont(new Font("Monospaced", Font.PLAIN, 20));
                panel.add(textLabel);

                JTextField textField = new JTextField();
                textField.setBounds(20,180,200,30);
                panel.add(textField);

                JLabel nameLabel = new JLabel("Name:");
                nameLabel.setBounds(20, 230, 200, 30);
                nameLabel.setVerticalAlignment(JLabel.TOP);
                nameLabel.setFont(new Font("Monospaced", Font.PLAIN, 20));
                panel.add(nameLabel);

                JTextField nameField = new JTextField();
                nameField.setBounds(20,280,200,30);
                panel.add(nameField);

                JButton enter = new JButton("Enter");
                enter.setBounds(20,330,150,25);
                panel.add(enter);

                enter.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        new Assignment(textField.getText(), nameField.getText(), 0, dateField.getText());
                        new HomeGUI();
                        JOptionPane.showMessageDialog(success, selectedItem + " created!");
                    }
                });


            }
        }

        if (selectedItem.equals("Class")) {
            JLabel nameLabel = new JLabel("Name of Class:");
            nameLabel.setBounds(20, 40, 200, 30);
            nameLabel.setVerticalAlignment(JLabel.TOP);
            nameLabel.setFont(new Font("Monospaced", Font.PLAIN, 20));
            panel.add(nameLabel);

            JTextField nameField = new JTextField();
            nameField.setBounds(20,90,200,30);
            panel.add(nameField);

            JLabel idLabel = new JLabel("ID:");
            idLabel.setBounds(20, 140, 200, 30);
            idLabel.setVerticalAlignment(JLabel.TOP);
            idLabel.setFont(new Font("Monospaced", Font.PLAIN, 20));
            panel.add(idLabel);

            JTextField idField = new JTextField();
            idField.setBounds(20,190,200,30);
            panel.add(idField);

            JLabel yearLabel = new JLabel("Year:");
            yearLabel.setBounds(20, 240, 200, 30);
            yearLabel.setVerticalAlignment(JLabel.TOP);
            yearLabel.setFont(new Font("Monospaced", Font.PLAIN, 20));
            panel.add(yearLabel);

            JTextField yearField = new JTextField();
            yearField.setBounds(20,290,200,30);
            panel.add(yearField);

            JLabel semesterLabel = new JLabel("Semester: (S1 or S2)");
            semesterLabel.setBounds(20, 340, 200, 30);
            semesterLabel.setVerticalAlignment(JLabel.TOP);
            semesterLabel.setFont(new Font("Monospaced", Font.PLAIN, 20));
            panel.add(semesterLabel);

            JTextField semesterField = new JTextField();
            semesterField.setBounds(20,390,200,30);
            panel.add(semesterField);

            JButton enter = new JButton("Enter");
            enter.setBounds(20,440,150,25);
            panel.add(enter);

            enter.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        new Class(nameField.getText(), yearField.getText(), semesterField.getText(), idField.getText());
                        new HomeGUI();
                        JOptionPane.showMessageDialog(success, selectedItem + " created!");
                    }
                });


        }
        


        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
    }
}
