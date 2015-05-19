import java.io.*;
import java.util.*;
import de.vogella.rss.read.*;
import de.vogella.rss.model.*;
import de.vogella.rss.write.*;
import de.l3s.boilerpipe.extractors.ArticleExtractor;

public class RSSFeed {
	
	private static String article;
	private static String URL;
	
	public static void getURL()
	{
		
		Scanner input = new Scanner(System.in);
		System.out.print("Link to RSS Feed: ");
		String rss = input.next();
		RSSFeedParser parser = new RSSFeedParser(rss);
		Feed feed = parser.readFeed();
		URL = feed.getMessages().get(0).getLink();
		System.out.println(URL);
		input.close();
		
	}
	
	public static void extractArticle() throws Exception
	{
		article = ArticleExtractor.INSTANCE.getText(URL);
	}
	
	public static void writeArticle()
	{
		try
		{
     	    FileWriter writer = new FileWriter("src/article.txt");
		    writer.write(article);
		    writer.close();
		}
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		catch (IOException e) 
		{
		    e.printStackTrace();
		}
	}

}
