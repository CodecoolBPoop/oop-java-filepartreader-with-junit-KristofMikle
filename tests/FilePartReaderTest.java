import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class FilePartReaderTest {
    @Test
    public void testIsToLineSmallerThanFromLine() {
        FilePartReader file = new FilePartReader();
        assertThrows(IllegalArgumentException.class, () -> {
            file.setup("", 15, 5);
        });
    }

    @Test
    public void testIfFileNotFound() {
        FilePartReader file = new FilePartReader();
        file.setup("badpath/bad.txt", 5, 10);
        assertThrows(IOException.class, () -> {
            file.read();
        });
    }

    @Test
    public void testWordsArePalindromeMethod() throws IOException {
        FileWordAnalyzer file = new FileWordAnalyzer("resources/test.txt", 0, 10);
        ArrayList<String> testList = new ArrayList<>(Arrays.asList("non", "a", "non"));
        assertEquals(file.wordsArePalindrome(), testList);
    }

    @Test
    public void testWordsABCMethod() throws IOException {
        FileWordAnalyzer file = new FileWordAnalyzer("resources/test.txt", 0, 1);
        ArrayList<String> testList = new ArrayList<>(Arrays.asList(
                "adipiscing",
                "amet",
                "amet",
                "consectetur",
                "cras",
                "diam",
                "dolor",
                "elit",
                "ipsum",
                "lorem",
                "lorem",
                "nec",
                "neque",
                "pellentesque",
                "pretium",
                "sit",
                "sit",
                "tempus",
                "tincidunt"));
        assertEquals(file.wordsByABC(), testList);
    }

    @Test
    public void testWordsContaininSubStringMethod() throws IOException {
        FileWordAnalyzer file = new FileWordAnalyzer("resources/test.txt", 0, 10);
        ArrayList<String> testList = new ArrayList<>(Arrays.asList("aliquam", "aliquet", "aliquet", "aliquet"));
        assertEquals(file.wordsContainingSubString("ali"), testList);
    }
}