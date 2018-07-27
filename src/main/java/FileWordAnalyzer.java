import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FileWordAnalyzer {

    FilePartReader fileReader;
    ArrayList<String> theList;

    public FileWordAnalyzer() throws IOException {
        fileReader = new FilePartReader();
        theList = new ArrayList<>(Arrays.asList(fileReader.readLines().toLowerCase().replaceAll("[.|$|,|;|']", "").split("[\n| ]")));
    }

    public FileWordAnalyzer(String path, Integer fromLine, Integer toLine) throws IOException {
        fileReader = new FilePartReader(path, fromLine, toLine);
        theList = new ArrayList<>(Arrays.asList(fileReader.readLines().toLowerCase().replaceAll("[.|$|,|;|']", "").split("[\n| ]")));
    }

    public ArrayList wordsByABC() {
        List<String> resultList = theList.stream()
                .sorted()
                .collect(Collectors.toList());
        return (ArrayList) resultList;
    }

    public ArrayList wordsContainingSubString(String subString) {
        List<String> resultList = theList.stream()
                .filter(word -> word.contains(subString))
                .collect(Collectors.toList());
return (ArrayList) resultList;
    }

    public ArrayList wordsArePalindrome() {

        List<String> resultList = theList.stream()
                .filter(word -> word.equals(new StringBuilder(word).reverse().toString()))
                .collect(Collectors.toList());
 return (ArrayList) resultList;
    }
}
