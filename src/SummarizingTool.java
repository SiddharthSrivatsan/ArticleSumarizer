import java.util.*;
import java.io.*;
import java.text.*;

public class SummarizingTool {

	private static String article;
	private static String[] sentences;
	private static double[][] intersectScores;
	private static double[] indivScores;
	private static String[] paragraphs;
	private static String summary;
	
	public static String getArticle() {
		String newArticle = "";
		
		File file = new File("src/article.txt");
		try {
			Scanner input = new Scanner(file);
			while(input.hasNext()) {
				newArticle += input.next() + " ";
			}
			input.close();
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return newArticle;
	}
	
	public static String[] splitSentences(String s) {
<<<<<<< HEAD
		BreakIterator iterator = BreakIterator.getSentenceInstance(Locale.US);
		ArrayList<String> sentenceS = new ArrayList<String>();
		iterator.setText(s);
		int start = iterator.first();
		for (int end = iterator.next();
		    end != BreakIterator.DONE;
		    start = end, end = iterator.next()) {
		  sentenceS.add(s.substring(start,end));
		}
		
		String[] mySentences = new String[sentenceS.size()];
		for(int i = 0; i < mySentences.length; i++) {
			mySentences[i] = sentenceS.get(i);
		}
		
=======
		String[] mySentences = s.split("\n|\\.(?!\\d)|(?<!\\d)\\.");
>>>>>>> origin/master
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
	
	public static String buildSummary(double[] n, String[] s) {
		String mySummary = s[0];
		for(int i = 1; i < n.length; i+=4) {
			int maxPos = i;
			double max = n[i];
			for(int k = i; k < n.length && k < i + 5; k++) {
				if(n[k] > max) {
					max = n[k];
					maxPos = k;
				}
			}
<<<<<<< HEAD
			mySummary += s[maxPos];
=======
			mySummary += s[maxPos] + ". ";
>>>>>>> origin/master
		}
		
		return mySummary;
	}
	
	public static void main(String[] args) {
		
		RSSFeed.getURL();
		RSSFeed.extractArticle();
		RSSFeed.writeArticle();

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
		
		summary = SummarizingTool.buildSummary(indivScores, sentences);
		
		String[] s = SummarizingTool.splitSentences(summary);
		
		for(String x : s) {
			System.out.println(x);
		}
		
	}
}