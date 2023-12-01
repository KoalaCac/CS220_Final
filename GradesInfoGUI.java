import javax.swing.*;
import java.awt.*;

public class GradesInfoGUI {
    
    public GradesInfoGUI() {
        Class classSelected = GradesGUI.getClassSelected();
        JPanel panel = new JPanel(null);
        JFrame frame = new JFrame(Student.getAsUser().getName() + " " + classSelected.getName() + " Grade");
        frame.setSize(300, 500);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.add(panel);

        JLabel title = new JLabel("<html>Your grade for <br/>" + classSelected.getName() + ":<html>");
        title.setFont(new Font("Monospaced", Font.BOLD, 16));
        title.setVerticalAlignment(JLabel.TOP);
        title.setBounds(40, 50, 300, 200);
        panel.add(title);

        JLabel grade = new JLabel("" + classSelected.getGrades().get(Student.getAsUser()));
        grade.setFont(new Font("Monospaced", Font.BOLD, 30));
        grade.setVerticalAlignment(JLabel.TOP);
        grade.setBounds(100, 150, 100, 100);
        panel.add(grade);

        int yLevel = 0;
        for (Assignment a : classSelected.getAssignments()) {
            JLabel assignLabel = new JLabel(a.getName() + ": " + a.getGradesMap().get(Student.getAsUser()) + "%");
            assignLabel.setFont(new Font("Monospaced", Font.BOLD, 12)); 
            assignLabel.setBounds(0, 270 + (yLevel * 20), 300, 100);
            assignLabel.setVerticalAlignment(JLabel.TOP);
            panel.add(assignLabel);
            yLevel++;
        }

        

        frame.setVisible(true);
    }
}
