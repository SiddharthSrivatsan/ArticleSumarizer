import java.util.*;
import java.io.*;


public class SummarizingTool {

	private static String article;
	private static String[] sentences;
	private static int[][] intersectScores;
	private static int[][] indivScores;
	private static String summary;
	
	public static void main(String[] args)
	{
		RSSFeed.getURL();
		RSSFeed.extractArticle();
		RSSFeed.writeArticle();
		
		article = "";
		
		File file = new File("src/article.txt");
		try 
		{
			Scanner input = new Scanner(file);
			while(input.hasNextLine())
			{
				article += input.nextLine();
			}
			
			input.close();
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		
	
		sentences = article.split("(?<=[a-z])\\.\\s+");
		
		for(String x : sentences)
		{
			System.out.println(x);
		}

	}
	
}
