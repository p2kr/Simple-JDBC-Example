import java.io.File;

public class Back_End {

    public Back_End(String[] data) {
        CSVReader reader = new CSVReader(new File("src/main/resources/user_info.csv"));
        reader.appendLine(data);
    }
}
