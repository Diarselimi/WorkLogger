import config.PropertyLoader;
import entity.WorkLog;
import service.DateService;

import javax.swing.*;
import java.awt.*;
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

        this.setAlwaysOnTop(true);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        button.addActionListener(e -> {
            workLog.setTask(jtextfield.getText());
            workLog.setFinishedAt(new Date());

            CsvWriter csv = new CsvWriter();
            WorkLog previousWlog = new WorkLog();
            previousWlog.setValuedFromString(csv.getLastRow());

            workLog.setCreatedAt(previousWlog.getFinishedAt());
            DateService ds = new DateService(previousWlog.getFinishedAt());
            workLog.setDuration((int) ds.getDiff(workLog.getFinishedAt()));

            Storage store = new CsvWriter();
            store.addColumns(workLog.valuesToArray());
            store.save();

            getContentPane().setVisible(false);
            dispose();

            if( workLog.getTask().contains("-") ) {

                Request request = new Request(
                        PropertyLoader.getProp("api_url") + workLog.getTask() + "/worklog",
                        workLog);
            }

        });
    }

    private JPanel latestLogsInfo() {
        Storage csv = new CsvWriter();
        String[] last = csv.lastSaved();
        JPanel pane = new JPanel(new FlowLayout());
        JLabel task = new JLabel("Last task: "+last[0]);
        JLabel description = new JLabel("Description: "+last[1]);
        JLabel timeSpent = new JLabel("Duration: "+last[2]+"m");

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
