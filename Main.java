import java.util.Scanner;

class Main 
{
	public static void main(String[] args)
	{
		int minutesToWait = 30;
		int counter = 3;
		do{
			Scanner scanner = new Scanner(System.in);
			System.out.print("Enter the task you are working: ");
			String task = scanner.nextLine(); 
			WorkLog worklog = new WorkLog(task, 30);
		
			System.out.printf("You have spent %d minutes on %s",worklog.getDuration(),worklog.getTask());	
			counter --;
			try {
				Thread.sleep(5*1000);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		} while(counter > 0);
	}
}
