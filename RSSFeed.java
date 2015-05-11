import java.io.*;


public class RSSFeed {
	
	private static String article;
	private String URL;
	
	public static void getURL()
	{
		
	}
	
	public static void extractArticle()
	{
		
	}
	
	public static void writeArticle()
	{
		try
		{
		    FileWriter writer = new FileWriter("src/article.txt");
		    writer.write(article);
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
