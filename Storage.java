
class Storage
{
	private WorkLog workLog;
	private CsvWriter csvWriter;

	public Storage(WorkLog workLog)
	{
		this.workLog = workLog;
		this.csvWriter = new CsvWriter();

		for (String column: workLog.valuesToArray())
		{
			this.csvWriter.addColumn(column);
		}

	}

	public boolean save()
	{
		this.csvWriter.write();
		return true;
	}
}
