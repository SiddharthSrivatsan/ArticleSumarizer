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
		try
		{
		    RSSFeed.extractArticle();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
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
		
	
		sentences = article.split(". ");
	
//		for(String x : sentences)
//		{
//			System.out.println(x);
//		}

	}
	
}
