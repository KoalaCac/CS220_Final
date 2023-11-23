import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.time.*;


public class AgendaGUI implements ActionListener {

    JFrame frame;
    JPanel panel;
    JTable table;
    JLabel dateLabel;
    DefaultTableModel tableModel;
    int monthInd;
    
    
    public AgendaGUI() {
        frame = new JFrame("Your Agenda");
        panel = new JPanel(new BorderLayout());
        frame.setSize(1000, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.add(panel);

        table = new JTable();
        panel.add(table);

        JButton button0 = new JButton("Back");
        button0.setBounds(0, 0, 100, 25);
        button0.setVerticalAlignment(JLabel.TOP);
        button0.addActionListener(this);
        panel.add(button0);

        JPanel header = new JPanel();
        JButton nextMonth = new JButton(">");
        JButton lastMonth = new JButton("<");
        dateLabel = new JLabel("", SwingConstants.CENTER);

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

        
        header.add(lastMonth);
        header.add(nextMonth);
        header.add(dateLabel);
        panel.add(header, BorderLayout.NORTH);

        tableModel = new DefaultTableModel();
        table = new JTable(tableModel);
        panel.add(new JScrollPane(table), BorderLayout.CENTER);

        updateCal(0);




        frame.setVisible(true);

        

    }


    public void updateCal(int change) {
        monthInd = change;
        tableModel.setColumnCount(0);
        tableModel.setRowCount(0);
        LocalDate currentDate = LocalDate.now().plusMonths(change);
        YearMonth yearMonth = YearMonth.of(currentDate.getYear(), currentDate.getMonth());
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setVerticalAlignment(SwingConstants.TOP);
        
                

        String[] days = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

        int firstDay = yearMonth.atDay(1).getDayOfWeek().getValue();


        for (String d : days) {
            tableModel.addColumn(d);
        }

        tableModel.addRow(new Object[7]);

        int row = 0;
        int col = firstDay-1;

        for (int i = 0; i <= yearMonth.lengthOfMonth(); i++) {
            tableModel.setValueAt(i, row, col); 
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


        String monthYearText = months[currentDate.getMonthValue() - 1] + " " + currentDate.getYear();
        dateLabel.setText(monthYearText);


    }


   public void actionPerformed(ActionEvent e) {
        frame.dispose();
        new HomeGUI();
   }
}
