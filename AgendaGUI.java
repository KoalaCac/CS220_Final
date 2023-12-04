import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.time.*;


public class AgendaGUI implements ActionListener {

    private JFrame frame;
    private JPanel panel;
    private JTable table;
    private JLabel dateLabel;
    private DefaultTableModel tableModel;
    private String cellVal;
    private int monthInd;
    
    
    public AgendaGUI() {
        //Instantiate the window
        frame = new JFrame("Your Agenda");
        panel = new JPanel(new BorderLayout());
        frame.setSize(1000, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.add(panel);

        //creates a JTabel that displays a calendar
        table = new JTable();
        panel.add(table);

        //Back to Home
        JButton button0 = new JButton("Back");
        button0.setBounds(0, 0, 100, 25);
        button0.setVerticalAlignment(JLabel.TOP);
        button0.addActionListener(this);
        panel.add(button0);

        JPanel header = new JPanel(); //Creates a header to stay in a position while the table changes
        JButton nextMonth = new JButton(">"); 
        JButton lastMonth = new JButton("<");
        dateLabel = new JLabel("", SwingConstants.CENTER);

        lastMonth.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateCal(monthInd-1); //Move back one month
            }
        });

        nextMonth.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateCal(monthInd+1); //Move forward one month
            }
        });

        //Add components to respective panels
        header.add(lastMonth);
        header.add(nextMonth);
        header.add(dateLabel);
        panel.add(header, BorderLayout.NORTH);

        tableModel = new DefaultTableModel() {

            public boolean isCellEditable(int row, int column) {
                return false;
            }

        };
        table = new JTable(tableModel);
        panel.add(new JScrollPane(table), BorderLayout.CENTER);

        updateCal(0); //Called to simply form the table's data




        frame.setVisible(true);

        

    }


    public void updateCal(int change) {
        monthInd = change; //Remember the last value so the table will change properly
        
        //reset the table
        tableModel.setColumnCount(0);
        tableModel.setRowCount(0);
        LocalDate currentDate = LocalDate.now().plusMonths(change); // calculate month based on if moved forward/backward
        YearMonth yearMonth = YearMonth.of(currentDate.getYear(), currentDate.getMonth());
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setVerticalAlignment(SwingConstants.TOP);
        
        //Define days of the week and months of the year
        String[] days = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

        int firstDay = yearMonth.atDay(1).getDayOfWeek().getValue();

        //Add 7 columns according to days
        for (String d : days) {
            tableModel.addColumn(d);
        }

        tableModel.addRow(new Object[7]);

        //For loop user to add data to the table
        int row = 0;
        int col = firstDay-1;
        for (int i = 0; i <= yearMonth.lengthOfMonth(); i++) {
            //display day's attendance, if data is missing, skip it.
            try {
                cellVal = "<html>" + i + "<br/>" + (Student.getAsUser().getAttendanceData().get(currentDate.withDayOfMonth(i)) ? "Here" : "Absent") + "<br/>";
            } catch (NullPointerException e) {
                cellVal = "<html>" + i + "<br/>";
            } catch (DateTimeException e) {
                cellVal = "<html>" + i + "<br/>";
            }
            for (Event e : Event.getEventList()) { //Add each event to the current day
                if (e.getDateCreated().toString().equals(String.format("%02d", currentDate.getYear()) + "-" + String.format("%02d", currentDate.getMonthValue()) + "-" + String.format("%02d", i))) {
                        cellVal = cellVal + e.toString() + "<br/>";
                }
            }
            if (i != 0) {
                tableModel.setValueAt(cellVal + "<html>", row, col); 
            }
            table.getColumnModel().getColumn(col).setCellRenderer(centerRenderer);
            table.setRowHeight(row, 100);
            col++;
            if (col == 7) {
                row++;
                col = 0;
                if (i < yearMonth.lengthOfMonth()) {
                    tableModel.addRow(new Object[7]);
                }
            }
        }
        //Text for header
        String monthYearText = months[currentDate.getMonthValue() - 1] + " " + currentDate.getYear();
        dateLabel.setText(monthYearText);
    }


   public void actionPerformed(ActionEvent e) {
        frame.dispose();
        new HomeGUI();
   }
}
