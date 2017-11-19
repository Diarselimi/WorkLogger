import java.util.concurrent.TimeUnit;
import java.util.Scanner;
import javax.swing.JOptionPane;
import java.util.Calendar;

class Main 
{
	public static void main(String[] args)
	{
		if (args.length == 0 || Integer.parseInt(args[0]) <= Calendar.getInstance().get(Calendar.HOUR_OF_DAY)) {
			System.out.println("Usage: java Main <Finish hour 24h format>");
			System.err.println("The end hour is required");
			System.err.println("The finish hour should be greater than current hour.");
			System.exit(1);
		}
		do {	
			int minutesToWait = 30;
			try {	
				TimeUnit.MINUTES.sleep(minutesToWait);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			String task = JOptionPane.showInputDialog("Enter the task code:");


			int counter = 3;

			WorkLog worklog = new WorkLog(task, 30);		
			System.out.printf("You have spent %d minutes on %s", 
			worklog.getDuration(),
			worklog.getTask());	
			Storage storage = new Storage(worklog);
			storage.save();
		} while ( Integer.parseInt(args[0]) > Calendar.getInstance().get(Calendar.HOUR_OF_DAY));
	}
	
}
