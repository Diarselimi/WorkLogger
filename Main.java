
import entity.WorkLog;

import java.util.Calendar;
import java.util.Date;

class Main
{

	public static void main(String[] args)
	{
		saveWorklogForStartingDay(new WorkLog());

		if (args.length == 0 || Integer.parseInt(args[0]) <= Calendar.getInstance().get(Calendar.HOUR_OF_DAY)) {
			System.out.println("Usage: java Main <Finish hour 24h format>");
			System.err.println("The end hour is required");
			System.err.println("The finish hour should be greater than current hour.");
			System.exit(1);
		}

		Promter promter = new Promter();
		int minutesToWait = (args.length == 2)? Integer.parseInt(args[1]): 30;

		do {
			WorkLog wlog = new WorkLog();

			promter.wait(minutesToWait);

			Panel frame = new Panel(400,200, wlog);
			promter.prompt(frame);

    	} while ( Integer.parseInt(args[0]) > Calendar.getInstance().get(Calendar.HOUR_OF_DAY));
	}

	private static void saveWorklogForStartingDay(WorkLog wlog) {
		wlog.setTask("started");
		wlog.setDescription("Day started");
		wlog.setFinishedAt(new Date());
		wlog.setDuration(0);

		Storage ss = new CsvWriter();
		ss.addColumns(wlog.valuesToArray());
		ss.save();
	}
}

