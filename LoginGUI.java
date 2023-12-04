import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.*;

public class LoginGUI implements ActionListener {

    private static JLabel userLabel;
    private static JTextField userText;
    private static JLabel passwordLabel;
    private static JPasswordField passwordText;
    private static JButton button;
    private static JLabel success;
    
    private JPanel panel;
    private JFrame frame;
    
    public LoginGUI() throws IOException {

        panel = new JPanel();
        frame = new JFrame("Account Sign In");
        frame.setSize(350,200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.add(panel);
        panel.setLayout(null);

        userLabel = new JLabel("ID:"); //ID label
        userLabel.setBounds(10, 20, 80, 25);
        panel.add(userLabel);

        userText = new JTextField(); //Enter id text
        userText.setBounds(100, 20, 165, 25);
        panel.add(userText);

        passwordLabel = new JLabel("PASSWORD:"); //Pass label
        passwordLabel.setBounds(10, 50, 80, 25);
        panel.add(passwordLabel);

        passwordText = new JPasswordField(); //Enter pass text
        passwordText.setBounds(100, 50, 165, 25);
        panel.add(passwordText);

        button = new JButton("Login"); //Submit info entered
        button.setBounds(10, 80, 80, 25);
        button.addActionListener(this);
        panel.add(button);
        
        success =  new JLabel(""); //Instantiate message
        success.setBounds(10, 110, 300, 25);
        panel.add(success);
        
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        String user = userText.getText();
        String password = passwordText.getText();
        if (foundInfoArr(user, password)) { //If info matches to an existing 
            success.setText("Login Successful");
            frame.dispose();
            new HomeGUI();
        }
        else {
            success.setText("Email or password incorrect");
        }
    }

    public static boolean foundInfo(String user, String pass) throws IOException { //Can be used for further development
        BufferedReader br = new BufferedReader(new FileReader("studentData.csv"));

        String line;
        while ((line = br.readLine()) != null) {
            String[] token = line.split(",");
            if (user.equals(token[0]) && pass.equals(token[4])) {
                br.close();
                Student.setAsUser(user);
                return true;
            }
        }
        br.close();
        return false;
    }

    public static boolean foundInfoArr(String user, String pass) { //Find username(ID) and password via master student list
        for (Student s : Student.getStudentList()) {
            if (user.equals(s.getId()) && pass.equals(s.getPass())) {
                Student.setAsUser(user);
                return true;
            }
        }
        return false;
    } 
}
