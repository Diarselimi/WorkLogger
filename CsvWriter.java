import config.PropertyLoader;

import java.io.*;

class CsvWriter implements Storage {
    private String row = "";
    private String filename = PropertyLoader.getProp("storage_path") + "data.csv";

    public void addColumns(String[] columns) {
        for (String col : columns) {
            this.addColumn(col);
        }
    }

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

    @Override
    public final String[] lastSaved() {
        return this.getLastRow().split(",");
    }

    public boolean save() {
        this.row += "\n";

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(this.filename, true))) {
            bw.write(this.row);

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

}
