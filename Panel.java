import entity.WorkLog;
import javafx.event.ActionEvent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Date;

public class Panel extends JFrame {

    public Panel(int width, int height, WorkLog workLog) {

        JPanel header = new JPanel(new FlowLayout());

        JButton button = new JButton("Log It");
        JTextField jtextfield = new JTextField("", 20);

        FlowLayout pane = new FlowLayout();

        JLabel label = new JLabel("Enter the task-key : *comment");

        pane.addLayoutComponent("test", button);


        header.add(label);

        this.add(header);
        this.add(jtextfield);
        this.add(button);

        this.add(this.latestLogsInfo());

        setTitle("Input Dialog in Frame");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);

        setSize(width, height);
        getContentPane().setLayout(pane);

        button.addActionListener(e -> {
            workLog.setTask(jtextfield.getText());
            workLog.setFinishedAt(new Date());

            CsvWriter csv = new CsvWriter();
            WorkLog previousWlog = new WorkLog();
            previousWlog.setValuedFromString(csv.getLastRow());

            System.out.println(previousWlog.getTask());
            workLog.setCreatedAt(previousWlog.getFinishedAt());

            Storage store = new Storage(workLog);
            store.save();

            getContentPane().setVisible(false);
            dispose();
        });
    }

    private JPanel latestLogsInfo() {
        JPanel pane = new JPanel(new FlowLayout());
        JLabel task = new JLabel("Last task: ST-123");
        JLabel description = new JLabel("Description: asdasdasdas");
        JLabel timeSpent = new JLabel("Time: 45m");

        pane.add(task);
        pane.add(description);
        pane.add(timeSpent);

        return pane;
    }

    public void closeIt() {
        this.getContentPane().setVisible(false);
        this.dispose();
    }

}
