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
import java.util.HashSet;
import java.util.Set;

//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.CsvFileSource;
import static org.junit.jupiter.api.Assertions.*;


public class PageParserTests {

    @Test
    @DisplayName("Testing an html with no <a> tag.")
    void pPTestATag1() {
        String html = "<html>https://www.google.com/</body></html>";
        Document doc = Jsoup.parse(html);
        PageParser parser = new PageParser();
        Set<String> links = parser.findLinks(doc);
        assertFalse(links.contains("https://www.google.com/"));
    }

    @Test
    @DisplayName("Testing an html with 1 <a> tag.")
    void pPTestATag2() {
        String html = "<html><a href='https://www.google.com/'>https://www.google.com/</a></body></html>";
        Document doc = Jsoup.parse(html);
        PageParser parser = new PageParser();
        Set<String> links = parser.findLinks(doc);
        assertTrue(links.contains("https://www.google.com/"));
    }

    @Test
    @DisplayName("Testing an html with multiple <a> tags.")
    void pPTestATag3() {
        String html = "<html><a href='https://www.google.com/'><a href='https://www.google.com/'>https://www.google.com/</a></a></body></html>";
        Document doc = Jsoup.parse(html);
        PageParser parser = new PageParser();
        Set<String> links = parser.findLinks(doc);
        System.out.println(links);
        assertTrue(links.contains("https://www.google.com/"));
    }
}

