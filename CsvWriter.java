import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

class CsvWriter
{
	private String row = "";
	private String filename = "./storage/data.csv";

	public void addColumn(String column)
	{
		if(column != null){
			this.row += column+';';
		}
	}

	public boolean write()
	{
		this.row += '\n';
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(this.filename, true))) {
			bw.write(this.row);

			// no need to close it.
			//bw.close();

		} catch (IOException e) {

			e.printStackTrace();

		}
		return true;
	}
}
