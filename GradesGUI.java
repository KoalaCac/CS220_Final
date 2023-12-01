import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class GradesGUI implements ActionListener{
    
    private static Class classSelected;
    private JFrame frame;
    JButton button0;

    public GradesGUI() {
        JPanel panel = new JPanel(null);
        frame = new JFrame(Student.getAsUser().getName() + " Grades");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.add(panel);

        JScrollPane scrollBar = new JScrollPane(panel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        frame.add(scrollBar);

        JLabel titleLabel = new JLabel("Your Classes:");
        titleLabel.setFont(new Font("Monospaced", Font.BOLD, 20));
        titleLabel.setBounds(160, 40, 200, 100);
        titleLabel.setVerticalAlignment(JLabel.TOP);
        panel.add(titleLabel);


        int yLevel = 0;
        for (Class c : Student.getAsUser().getClassesEnrolled()) {
            JButton button = new JButton(c.getName());
            button.setBounds(110 , yLevel + 100, 250, 50);
            titleLabel.setVerticalAlignment(JLabel.TOP);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    classSelected = c;
                    new GradesInfoGUI();
                }
            });
            panel.add(button);
            yLevel += 50;
        }

        button0 = new JButton("Back");
        button0.setBounds(0, 0, 100, 25);
        button0.setVerticalAlignment(JLabel.TOP);
        button0.addActionListener(this);
        panel.add(button0);




        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
            frame.dispose();
            new HomeGUI();
    }

    public static Class getClassSelected() {
        return classSelected;
    }


}
