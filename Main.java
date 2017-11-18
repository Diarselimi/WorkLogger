import java.util.Scanner;
import javax.swing.JOptionPane;

class Main 
{
	public static void main(String[] args)
	{
		String task = JOptionPane.showInputDialog("Enter the task code:");

		int minutesToWait = 30;
		int counter = 3;

		WorkLog worklog = new WorkLog(task, 30);		
		System.out.printf("You have spent %d minutes on %s", 
		worklog.getDuration(),
		worklog.getTask());	
		Storage storage = new Storage(worklog);
		storage.save();
	}
	
}
