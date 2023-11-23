import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.*;
import java.awt.*;

public class GradesInfoGUI {
    
    public GradesInfoGUI() {
        int classInd = GradesGUI.getGradeInd();
        JPanel panel = new JPanel(null);
        JFrame frame = new JFrame(Student.getAsUser().getName() + " " + Student.getAsUser().getClassesEnrolled().get(classInd).getName() + " Grade");
        frame.setSize(300, 500);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.add(panel);

        JLabel title = new JLabel("<html>Your grade for <br/>" + Student.getAsUser().getClassesEnrolled().get(classInd).getName() + ":<html>");
        title.setFont(new Font("Monospaced", Font.BOLD, 16));
        title.setVerticalAlignment(JLabel.TOP);
        title.setBounds(40, 50, 300, 200);
        panel.add(title);

        JLabel grade = new JLabel("" + Student.getAsUser().getGrades().get(classInd));
        grade.setFont(new Font("Monospaced", Font.BOLD, 30));
        grade.setVerticalAlignment(JLabel.TOP);
        grade.setBounds(100, 150, 100, 100);
        panel.add(grade);

        frame.setVisible(true);
    }
}
