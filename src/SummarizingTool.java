import java.util.*;
import java.io.*;

public class SummarizingTool {

	private static String article;
	private static String[] sentences;
	private static double[][] intersectScores;
	private static double[] indivScores;
	private static String summary;
	
	public static String getArticle() {
		String newArticle = "";
		
		File file = new File("src/article.txt");
		try {
			Scanner input = new Scanner(file);
			while(input.hasNextLine()) {
				newArticle += input.nextLine();
			}
			input.close();
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return newArticle;
	}
	
	public static String[] splitSentences(String s) {
		String[] mySentences = s.split("\n|\\.(?!\\d)|(?<!\\d)\\.");
		
		for(String x : mySentences) {
			System.out.println(x);
		}
		
		return mySentences;
	}
	
	public static String[] splitWords(String s) {
		String[] myWords = s.split(" ");
		
		return myWords;
	}
	
	public static double findIntersectionScore(String[] s1, String[] s2) {
		int max = (s1.length > s2.length) ? s1.length : s2.length;
		int min = (s1.length > s2.length) ? s2.length : s1.length;
		
		double score = 0.0;
		
		for(int i = 0; i < max; i++) {
			for(int k = 0; k < min; k++) {
				if(max == s1.length) {
					if(s1[i].equals(s2[k])) {
						score++;
					}
				}
				else {
					if(s2[i].equals(s1[k])) {
						score++;
					}
				}
			}
		}
		
		double averageWords = (s1.length + s2.length) / 2;
		score /= averageWords;
		return score;
	}
	
	public static void main(String[] args) {
		
		//RSSFeed.getURL();
		//RSSFeed.extractArticle();
		//RSSFeed.writeArticle();

		article = SummarizingTool.getArticle();
	
		sentences = SummarizingTool.splitSentences(article);
		
		intersectScores = new double[sentences.length][sentences.length];
		
		for(int i = 0; i < intersectScores.length; i++) {
			for(int k = 0; k < intersectScores[0].length; k++) {
				String[] sentence1 = SummarizingTool.splitWords(sentences[i]);
				String[] sentence2 = SummarizingTool.splitWords(sentences[k]);
				intersectScores[i][k] = SummarizingTool.findIntersectionScore(sentence1, sentence2);
			}
		}
		
		indivScores = new double[intersectScores.length];
		
		for(int i = 0; i < intersectScores.length; i++) {
			double sum = 0;
			for(int k = 0; k < intersectScores[0].length; k++) {
				sum += intersectScores[i][k];
			}
			indivScores[i] = sum;
		}
//		
//		for(int m = 0; m < indivScores.length - 1; m++) {
//			for(int i = 0; i < indivScores.length - 1; i++) {
//				int k = i + 1;
//				if(indivScores[i] < indivScores[k]) {
//					double temp = indivScores[k];
//					indivScores[k] = indivScores[i];
//					indivScores[i] = temp;
//					String alsoTemp = sentences[k];
//					sentences[k] = sentences[i];
//					sentences[i] = alsoTemp;
//				}
//			}
//		}
//		
//		for(double x : indivScores) {
//			System.out.println(x);
//		}
//		
//		for(int i = 0; i <5; i++) {
//			System.out.println(sentences[i]);
//		}
		
	}
}
