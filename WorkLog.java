/**
* This class is for getting the data from the promter;
*/
class WorkLog
{
	private String task;
	private	int duration;

	public WorkLog(String task, int duration)
	{
		this.task = task;
		this.duration = duration;
	}
	
	public String getTask(){ return this.task; }
	public int getDuration() { return this.duration; }
}
