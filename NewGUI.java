import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.*;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

public class NewGUI {
    
    private JFrame frame;
    private JPanel panel;
    private JScrollPane scrollPane;

    public NewGUI(String selectedItem) {

        panel = new JPanel(null);
        frame = new JFrame("Make a new " + selectedItem);
        frame.setSize(700,700);
        frame.setLocationRelativeTo(null);
        frame.add(panel);

        scrollPane = new JScrollPane(panel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setSize(700, 500);
        frame.add(scrollPane);

        JFrame success = new JFrame("Message");
        success.setSize(600,600);

        //Back to Home, cancel
        JButton back = new JButton("Back");
        back.setBounds(0,0,100,25);
        panel.add(back);

        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new HomeGUI();
            }
        });

        //Add components based on what new object you want to create
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

                //Submit info, get an error or success
                JButton enter = new JButton("Enter");
                enter.setBounds(20,600,150,25);
                panel.add(enter);

                enter.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        try {
                            if (textArea.getText().equals("") || dateField.getText().equals("")) {
                                throw new IllegalAccessError();
                            }
                            new Announcement(Student.getAsUser().getId(), textArea.getText(), dateField.getText());
                            frame.dispose();
                            new HomeGUI();
                            JOptionPane.showMessageDialog(success, selectedItem + " created!");
                        } catch (IllegalAccessError iee) { //Input Validation
                            JOptionPane.showMessageDialog(success, "Error! Some fields not filled out");
                        } catch (DateTimeParseException dtpe) { //Input Validation
                            JOptionPane.showMessageDialog(success, "Invalid Date! Use YYYY-MM-DD");
                        }
                    }
                });
            }
            if (selectedItem.equals("Assignment")) {
                JLabel textLabel = new JLabel("Class ID:");
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

               //Submit info, get an error or success
                JButton enter = new JButton("Enter");
                enter.setBounds(20,600,150,25);
                panel.add(enter);

                enter.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        try {
                            if (textField.getText().equals("") || nameField.getText().equals("") || dateField.getText().equals("")) {
                                throw new IllegalAccessError();
                            }
                            Class.findClass(textField.getText()).addAssignment(new Assignment(Class.findClass(textField.getText()), nameField.getText(), dateField.getText()));
                            frame.dispose();
                            new HomeGUI();
                            JOptionPane.showMessageDialog(success, selectedItem + " created!");
                        } catch (NullPointerException npe) { //Input Validation
                            JOptionPane.showMessageDialog(success, "No matching Class ID");
                        } catch (DateTimeParseException dtpe) { //Input Validation
                            JOptionPane.showMessageDialog(success, "Invalid Date! Use YYYY-MM-DD");
                        } catch (IllegalAccessError iee) { //Input Validation
                            JOptionPane.showMessageDialog(success, "Error! Some fields not filled out");
                        }
                        
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

            //Add a button for each user in order to add them to the class
            JLabel usersLabel = new JLabel("Add Users");
            usersLabel.setBounds(20, 440, 200, 30);
            usersLabel.setVerticalAlignment(JLabel.TOP);
            usersLabel.setFont(new Font("Monospaced", Font.PLAIN, 20));
            panel.add(usersLabel);
            ArrayList<Student> temp = new ArrayList<>();
            int i = 0;
            for (Student s : Student.getStudentList()) {
                JToggleButton toggle = new JToggleButton(s.getId().toUpperCase());
                toggle.setBounds(20 + ((i % 4) * 150), 490 + ((i / 4) * 50), 140, 25);
                panel.add(toggle);
                toggle.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (toggle.isSelected()) {
                            temp.add(s);
                        }
                    }
                });
                i++;
            }

            panel.setPreferredSize(new Dimension(700, (i * 25) + 300));

            //Submit info, get an error or success
            JButton enter = new JButton("Enter");
            enter.setBounds(400,390,150,25);
            panel.add(enter);

            enter.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        try {
                            //If any field is empty, throw an error
                            if (nameField.getText().equals("") || yearField.getText().equals("") || semesterField.getText().equals("") || idField.getText().equals("")) {
                                throw new IllegalAccessError();
                            }
                            Class createdC = new Class(nameField.getText(), yearField.getText(), semesterField.getText(), idField.getText());
                            createdC.setUsersInClass(temp);
                            for (Student s : temp) { //Add the class to each selected user's enrolled classes
                                s.addClass(createdC);
                            }
                            frame.dispose();
                            new HomeGUI();
                            JOptionPane.showMessageDialog(success, selectedItem + " created!"); //Success message
                        } catch(IllegalAccessError iee) { //Input Validation
                            JOptionPane.showMessageDialog(success, "Error! Some fields not filled out");
                        }
                    }
                });
        }
        frame.setVisible(true);
    }
}
