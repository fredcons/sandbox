package org.fc.sandbox;

import org.testng.annotations.Test;

import twitter4j.AccountSettings;
import twitter4j.IDs;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Tweet;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.User;
import twitter4j.conf.ConfigurationBuilder;

public class TwitterTest {
	
	@Test
	public void testSettings() {
		try {
			ConfigurationBuilder cb = new ConfigurationBuilder();
			cb.setDebugEnabled(true)
			  .setOAuthConsumerKey("VHEZ29G6E6QnV99YXyi5Ew")
			  .setOAuthConsumerSecret("9xcqNjcKkn3JCcuwlpTS7NOH6pmEUJ1BkcfmgyH1vjM")
			  .setOAuthAccessToken("251591990-RMpfKLSAYWdpt8I4fdMW2aLm3cvWjpn2yEDBcvKz")
			  .setOAuthAccessTokenSecret("aB7WbOkrijW4bNPH4LeOkqbL3jyA6ydMrPbK74YYQ");
			
			TwitterFactory tf = new TwitterFactory(cb.build());
			Twitter twitter = tf.getInstance();			
			
			/*
			Query q = new Query();
			q.setQuery("fullsix");
			q.setPage(1);
			q.setRpp(100);
			q.setSince("2011-02-01");
			
			QueryResult result = twitter.search(q);
			System.out.println("result : " + result);
			for (Tweet tweet : result.getTweets()) {
				System.out.println(tweet);
			}
			
			AccountSettings settings = twitter.getAccountSettings();
			System.out.println(settings.getRateLimitStatus());
			*/
			
			IDs followerIds = twitter.getFollowersIDs("FullsixGroup");
			System.out.println("FullsixGroup has " + followerIds.getIDs().length + " followers");
			int[] someIds = new int[5];
			for (int i = 0; i < 5; i++) {
				someIds[i] = followerIds.getIDs()[i];
			}
			
			ResponseList<User> followers = twitter.lookupUsers(someIds);
			for (User follower : followers) {
				System.out.println(follower);
			}
			
			ResponseList<Status> statuses = twitter.getUserTimeline("FullsixGroup");
			for (Status status : statuses) {
				System.out.println(status);
			}
				
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
