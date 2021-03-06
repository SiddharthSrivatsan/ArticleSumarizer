package de.vogella.rss.tests;

import de.vogella.rss.model.Feed;
import de.vogella.rss.model.FeedMessage;
import de.vogella.rss.read.RSSFeedParser;

public class ReadTest {
  public static void main(String[] args) {
    RSSFeedParser parser = new RSSFeedParser("http://rss.nytimes.com/services/xml/rss/nyt/MiddleEast.xml");
    Feed feed = parser.readFeed();
    System.out.println(feed);
    for (FeedMessage message : feed.getMessages()) {
      System.out.println(message);

    }

  }
} 
