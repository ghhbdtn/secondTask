
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Tests {
    private boolean assertFileContent(String expectedFile, String actualFile) {
        List<String> expected = null;
        try {
            expected = Files.readAllLines(Paths.get(expectedFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<String> actual = null;
        try {
            actual = Files.readAllLines(Paths.get(actualFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < actual.size(); i++){
            if (expected.get(i) != actual.get(i)) return false;
        }
        return expected.size() == actual.size();
    }

    @Test
    public void pack () {
       assertEquals("5A7O4Y10M9P",  PackRle.packing("AAAAAOOOOOOOYYYYMMMMMMMMMMPPPPPPPPP"));
        assertEquals("DBAEFDBAFDABFDBAEDFABEDFAEBDFEABDFABED2FAD31BAEB2DBAEBDF",
                PackRle.packing("DBAEFDBAFDABFDBAEDFABEDFAEBDFEABDFABEDFFADBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBAEBDDBAEBDF"));
        assertEquals("7j7O5T4n10I6N",  PackRle.packing("jjjjjjjOOOOOOOTTTTTnnnnIIIIIIIIIINNNNNN"));
    }

    @Test
    public void unpack () {
        assertEquals("AAAAAOOOOOOOYYYYMMMMMMMMMMPPPPPPPPP", PackRle.unpacking("5A7O4Y10M9P"));
        assertEquals("DBAEFDBAFDABFDBAEDFABEDFAEBDFEABDFABEDFFADBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBAEBDDBAEBDF",
                PackRle.unpacking("DBAEFDBAFDABFDBAEDFABEDFAEBDFEABDFABED2FAD31BAEB2DBAEBDF"));
        assertEquals("hhhhhhhOOOOOOOTTTTTeeeeIIIIIIIIIINNNNNN",  PackRle.unpacking("7h7O5T4e10I6N"));
    }

}
