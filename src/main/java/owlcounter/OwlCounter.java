package owlcounter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class OwlCounter {

    private List<String> dataLines;

    public void readFromFile(Path path) {
        try {
            dataLines = Files.readAllLines(path);
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file.", ioe);
        }
    }

    public int getNumberOfOwls(String county) {
        for (String actual : dataLines) {
            String temp[] = actual.split("=");
            if (temp[0].equals(county)) {
                return Integer.parseInt(temp[1]);
            }
        }
        throw new IllegalArgumentException("No such county in Hungary!");
    }

    public int getNumberOfAllOwls() {
        int sum = 0;
        for (String actual : dataLines) {
            sum += Integer.parseInt(actual.split("=")[1]);
        }
        return sum;
    }
}
