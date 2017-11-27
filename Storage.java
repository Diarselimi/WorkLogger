interface Storage
{
	public void addColumns(String[] columns);
	public boolean save();
	public String[] lastSaved();
}
