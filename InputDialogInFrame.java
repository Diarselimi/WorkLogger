import java.util.concurrent.TimeUnit;
import java.util.Scanner;
import javax.swing.JOptionPane;
import java.util.Calendar;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

class InputDialogInFrame extends JFrame
{
	public InputDialogInFrame() {

		getContentPane().setBackground(Color.DARK_GRAY);
		setTitle("Input Dialog in Frame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(false);
		setSize(400, 300);
		getContentPane().setLayout(null);

	}

	private void closeIt(){

		this.getContentPane().setVisible(false);
		this.dispose();

	}

	public static void main(String[] args)
	{
		if (args.length == 0 || Integer.parseInt(args[0]) <= Calendar.getInstance().get(Calendar.HOUR_OF_DAY)) {
			System.out.println("Usage: java Main <Finish hour 24h format>");
			System.err.println("The end hour is required");
			System.err.println("The finish hour should be greater than current hour.");
			System.exit(1);
		}
		do {


			int minutesToWait = (args.length == 2)? Integer.parseInt(args[1]): 30;
			try {	
				TimeUnit.MINUTES.sleep(minutesToWait);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			InputDialogInFrame frame = new InputDialogInFrame();
			frame.setAlwaysOnTop(true);
			String task = JOptionPane.showInputDialog(frame, "Enter the Task code:");

			int counter = 3;

			WorkLog worklog = new WorkLog(task, minutesToWait);		
			System.out.printf("You have spent %d minutes on %s \n",
			worklog.getDuration(),
			worklog.getTask());	
			Storage storage = new Storage(worklog);
			storage.save();
			frame.closeIt();
		} while ( Integer.parseInt(args[0]) > Calendar.getInstance().get(Calendar.HOUR_OF_DAY));
	}
	
}
