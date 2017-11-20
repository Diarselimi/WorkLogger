package entity;

import service.DateService;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
* This class is for getting the data from the promter;
*/
public class WorkLog
{
	public static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

	private Date createdAt;
	private String task;
	private String description;
	private	int duration;
	private Date finishedAt;

	public WorkLog()
	{
		this.createdAt = new Date();
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getFinishedAt() {
		return finishedAt;
	}

	public void setFinishedAt(Date finishedAt) {
		this.finishedAt = finishedAt;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getTask(){ return this.task; }
	public int getDuration() { return this.duration; }

	/**
	 * This should be called after the task has the StarTime and EndTime
	 *
	 * @return String[]
	 */
	public String[] valuesToArray()
	{
		DateService created = new DateService(this.createdAt);
		DateService finished = new DateService(this.finishedAt);

		String[] result = {this.task, this.description,
				Long.toString(created.getDiff(this.finishedAt)),
				created.toFormat(DATE_FORMAT), finished.toFormat(DATE_FORMAT)};
		return result;
	}

	/**
	 * Will be used later
	 * @return List
	 */
	public List<Field> getDeclaredFields()
	{
		List<Field> privateFields = new ArrayList<>();
		Field[] allFields = WorkLog.class.getDeclaredFields();
		for (Field field : allFields) {
			if (Modifier.isPrivate(field.getModifiers())) {
				privateFields.add(field);
			}
		}
		return privateFields;
	}

}
