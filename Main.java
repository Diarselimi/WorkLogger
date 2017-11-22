
import entity.WorkLog;
import javafx.stage.WindowEvent;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

class Main
{

	public static void main(String[] args)
	{
		List<Panel> panels = new ArrayList<Panel>();
		Date startedDate = new Date();

		saveWorklogForStartingDay(new WorkLog());
		if (args.length == 0 || Integer.parseInt(args[0]) <= Calendar.getInstance().get(Calendar.HOUR_OF_DAY)) {
			System.out.println("Usage: java Main <Finish hour 24h format>");
			System.err.println("The end hour is required");
			System.err.println("The finish hour should be greater than current hour.");
			System.exit(1);
		}
		do {
		    WorkLog wlog = new WorkLog();

			int minutesToWait = (args.length == 2)? Integer.parseInt(args[1]): 30;
			try {
				TimeUnit.MINUTES.sleep(minutesToWait);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

			for (Panel panel : panels) {
				panel.closeIt();
			}

			Panel frame = new Panel(400,200, wlog);
			frame.setAlwaysOnTop(true);
			frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

			panels.add(0, frame);

		} while ( Integer.parseInt(args[0]) > Calendar.getInstance().get(Calendar.HOUR_OF_DAY));
	}

	private static void saveWorklogForStartingDay(WorkLog wlog) {
		wlog.setTask("started");
		wlog.setDescription("Day started");
		wlog.setFinishedAt(new Date());
		wlog.setDuration(0);
		Storage ss = new Storage(wlog);
		ss.save();
	}
}

