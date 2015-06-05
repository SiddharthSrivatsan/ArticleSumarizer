import java.io.*;
import java.util.*;
import de.vogella.rss.read.*;
import de.vogella.rss.model.*;
import de.l3s.boilerpipe.extractors.*;
import java.net.URL;

public class RSSFeed {
	
	private static String article;
	private static String webAddress;
    private static URL url;
	
	public static void getURL() {
		Scanner input = new Scanner(System.in);
		System.out.print("Link to RSS Feed: ");
		String rss = input.next();
		RSSFeedParser parser = new RSSFeedParser(rss);
		Feed feed = parser.readFeed();
		webAddress = feed.getMessages().get(0).getLink();
		input.close();	
	}
	
	public static void extractArticle() {
		try {
			url = new URL(webAddress);
			article = DefaultExtractor.INSTANCE.getText(url);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void writeArticle() {
		try {
     	    FileWriter writer = new FileWriter("src/article.txt");
		    writer.write(article);
		    writer.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
