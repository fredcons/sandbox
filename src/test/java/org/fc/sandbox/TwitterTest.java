package org.fc.sandbox;

import org.testng.annotations.Test;

import twitter4j.IDs;
import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.User;
import twitter4j.conf.ConfigurationBuilder;

public class TwitterTest {
	
	@Test
	public void testSettings() {
		try {
		    String oAuthConsumerKey = System.getProperty("oauth.consumer.key");
		    String oAuthConsumerSecret = System.getProperty("oauth.consumer.secret");
		    String oAuthAccessToken = System.getProperty("oauth.access.token");
		    String oAuthAccessTokenSecret = System.getProperty("oauth.access.token.secret");
		    
		    System.out.println("oAuthConsumerKey       : " + oAuthConsumerKey);
		    System.out.println("oAuthConsumerSecret    : " + oAuthConsumerSecret);
		    System.out.println("oAuthAccessToken       : " + oAuthAccessToken);
		    System.out.println("oAuthAccessTokenSecret : " + oAuthAccessTokenSecret);
		    
			ConfigurationBuilder cb = new ConfigurationBuilder();
			cb.setDebugEnabled(true)
			  .setOAuthConsumerKey(oAuthConsumerKey)
			  .setOAuthConsumerSecret(oAuthConsumerSecret)
			  .setOAuthAccessToken(oAuthAccessToken)
			  .setOAuthAccessTokenSecret(oAuthAccessTokenSecret);
			
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
