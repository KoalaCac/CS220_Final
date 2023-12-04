import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class GradesInfoGUI {
    
    public GradesInfoGUI() {
        generate(); //Calls method to generate an updated GUI
    }

    public static void generate() {

        Class.recalculateGrades(); //Update grades
        Class classSelected = GradesGUI.getClassSelected();

        //Instatiate a new window
        JPanel panel = new JPanel(null);
        JFrame frame = new JFrame(Student.getAsUser().getName() + " " + classSelected.getName() + " Grade");
        frame.setSize(300, 500);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.add(panel);

        //Title
        JLabel title = new JLabel("<html>Your grade for <br/>" + classSelected.getName() + ":<html>");
        title.setFont(new Font("Monospaced", Font.BOLD, 16));
        title.setVerticalAlignment(JLabel.TOP);
        title.setBounds(40, 50, 300, 200);
        panel.add(title);

        //Grade shown
        JLabel grade = new JLabel("" + classSelected.getGrades().get(Student.getAsUser()));
        grade.setFont(new Font("Monospaced", Font.BOLD, 30));
        grade.setVerticalAlignment(JLabel.TOP);
        grade.setBounds(100, 150, 100, 100);
        panel.add(grade);

        //Creates JSpinners to manipulate grades via all added assignments
        int yLevel = 0;
        HashMap<JSpinner, Assignment> spinnerMap = new HashMap<>();
        for (Assignment a : classSelected.getAssignments()) {
            JLabel assignLabel = new JLabel(a.getName() + ": ");
            assignLabel.setFont(new Font("Monospaced", Font.BOLD, 12)); 
            assignLabel.setBounds(0, 270 + (yLevel * 20), 300, 100);
            assignLabel.setVerticalAlignment(JLabel.TOP);
            panel.add(assignLabel);

            SpinnerNumberModel spinnerModel = new SpinnerNumberModel(a.getGradesMap().get(Student.getAsUser()), (Double)0.0, (Double)100.0, (Double)1.0);
            JSpinner spinner = new JSpinner(spinnerModel);
            spinner.setBounds(100, 270 + (yLevel * 20), 50, 20);
            panel.add(spinner);
            spinnerMap.put(spinner,a);

            yLevel++;
        }

        //Save data to call the generate method again to update grades
        JButton save = new JButton("Save data");
        save.setBounds(100, 240, 125,25);
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Map.Entry<JSpinner, Assignment> entry : spinnerMap.entrySet()) {
                    entry.getValue().getGradesMap().replace(Student.getAsUser(), (Double) entry.getKey().getValue());
                }
                frame.removeAll();
                frame.dispose();
                generate();
            }
        });
        panel.add(save);

        frame.setVisible(true);
    }
}
