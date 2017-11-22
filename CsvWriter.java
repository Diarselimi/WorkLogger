import java.io.*;

class CsvWriter {
    private String row = "";
    private String filename = "./storage/data.csv";

    public void addColumn(String column) {
        if (column != null) {
            this.row += column + ',';
        }
    }

    public String getLastRow() {
        String lastLine = "";
        String line = null;
        try (BufferedReader br = new BufferedReader(new FileReader(this.filename))) {
            while ((line = br.readLine()) != null) {
                lastLine = line;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lastLine;
    }

    public boolean write() {
        this.row += "\n";
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
