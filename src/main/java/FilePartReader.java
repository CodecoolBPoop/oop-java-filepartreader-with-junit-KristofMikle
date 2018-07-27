import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FilePartReader {

    private String filePath;
    private Integer fromLine;
    private Integer toLine;

    public FilePartReader() {
        filePath = "resources/test.txt";
        fromLine = 0;
        toLine = 1;
    }

    public FilePartReader(String filePath, Integer fromLine, Integer toLine) {
        this.filePath = filePath;
        this.fromLine = fromLine;
        this.toLine = toLine;
    }

    public static void main(String[] args) throws IOException {
        FileWordAnalyzer analyze = new FileWordAnalyzer();
        ArrayList theList = analyze.wordsByABC();
        for(Object word: theList) {
            System.out.println(word);
        }
        System.out.println(analyze.wordsContainingSubString("ali"));
        System.out.println(analyze.wordsArePalindrome());
    }

    public void setup(String filePath, Integer fromLine, Integer toLine) throws IllegalArgumentException {
        this.filePath = filePath;
        this.fromLine = fromLine;
        this.toLine = toLine;

        if (toLine < fromLine || fromLine < 1) {
            throw new IllegalArgumentException("'toLine' should be higher than 'fromLine' AND 'fromLine' must be higher than 0");
        }
    }

    public String read() throws IOException {
        StringBuilder text = new StringBuilder();
        List<String> lines = Files.readAllLines(Paths.get(filePath));
        for (String line : lines) {
            text.append(line);
            text.append(System.lineSeparator());
        }
        return String.valueOf(text);
    }

    public String readLines() throws IOException {
        BufferedReader br = new BufferedReader(new StringReader(read()));
        StringBuilder result = new StringBuilder();
        int counter = 0;
        String thisLine;
        while (((thisLine = br.readLine()) != null) && (counter <= toLine)) {
            if (counter >= fromLine) {
                result.append(thisLine);
                result.append(System.lineSeparator());
            }
            counter++;
        }
        return String.valueOf(result);
    }
}
