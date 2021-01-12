import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CSVReader {
    private final File csv;

    public CSVReader(File csv) {
        this.csv = csv;
    }

    public List<String[]> readLine() {
        List<String[]> info = new ArrayList<>();
        try (Scanner sc = new Scanner(csv)) {
            while (sc.hasNext()) {
                String line = sc.nextLine();
                info.add(line.split(","));
            }
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        }
        return info;
    }

    public void appendLine(String[] info) {
        try (FileWriter f = new FileWriter(csv, true)) {
            for (int i = 0; i < info.length; i++) {
                String s = info[i].trim();
                f.append(s);
                if (i != info.length - 1)
                    f.append(',');
            }
            f.append('\n');
        } catch (IOException e) {
            System.err.println("Error writing to " + csv);
        }
    }
}
