import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import edu.depaul.email.StorageService;
import edu.depaul.email.EmailFinder;
import edu.depaul.email.EmailFinderException;
import edu.depaul.email.ListWriter;
import edu.depaul.email.PageCrawler;
import edu.depaul.email.PageFetcher;
import edu.depaul.email.PageParser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.CsvFileSource;
import static org.junit.jupiter.api.Assertions.*;

public class EmailFinderTests {
    @Test
    @DisplayName("Checking to see if good-links.txt is created/already exists.")
    void EFTestFileExist1(){
        String[] strURL = new String[] {"https://www.google.com/"};
        EmailFinder.main(strURL);
        File file = new File("C:/Users/Warliz/Desktop/SE333-email-finder/good-links.txt");
        assertTrue(file.exists());
    }

    @Test
    @DisplayName("Checking to see if email.txt is created/already exists.")
    void EFTestFileExist2(){
        String[] strURL = new String[] {"https://www.google.com/"};
        EmailFinder.main(strURL);
        File file = new File("C:/Users/Warliz/Desktop/SE333-email-finder/email.txt");
        assertTrue(file.exists());
    }

    @Test
    @DisplayName("Checking to see if badlinks.txt is created/already exists.")
    void EFTestFileExist3(){
        String[] strURL = new String[] {"https://www.google.com/"};
        EmailFinder.main(strURL);
        File file = new File("C:/Users/Warliz/Desktop/SE333-email-finder/badlinks.txt");
        assertTrue(file.exists());
    }

    @Test
    @DisplayName("Checking badlinks.txt to see if it displays the URL used.")
    void EFTestTextCheck1(){
        String[] strURL = new String[] {"thebomb.com"};
        EmailFinder.main(strURL);
        String badLink = "thebomb.com";
        try {
            String firstLine = Files.readAllLines(Paths.get("badlinks.txt")).get(0);
            assertTrue(badLink.equals(firstLine));
        }
        catch(IOException e) {
        }
    }

    @Test
    @DisplayName("Checking good-links.txt to see if it displays the URL used.")
    void EFTestTextCheck2(){
        String[] strURL = new String[] {"https://www.google.com/"};
        EmailFinder.main(strURL);
        String goodLink = "https://safebrowsing.google.com/?utm_source=pp&hl=en";
        try {
            String firstLine = Files.readAllLines(Paths.get("good-links.txt")).get(0);
            assertTrue(goodLink.equals(firstLine));
        }
        catch(IOException e) {
        }
    }

    @Test
    @DisplayName("Checking email.txt to see if it displays the URL used.")
    void EFTestTextCheck3(){
        String[] strURL = new String[] {"https://www.google.com/"};
        EmailFinder.main(strURL);
        String email = "Username@gmail.com";
        try {
            String firstLine = Files.readAllLines(Paths.get("email.txt")).get(0);
            assertTrue(email.equals(firstLine));
        }
        catch(IOException e) {
        }
    }
}
