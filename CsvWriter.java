import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

class CsvWriter
{
	private String row;

	public void addColumn(String column)
	{
		this.row += ';'+column;
	}

	public boolean write()
	{
		FileWriter fr = new FileWriter("./storage/data.csv"); // After '.' write
		// your file extention (".txt" in this case)
		fr.write(this.row); // Warning: this will REPLACE your old file content!
		fr.close();
	}
}