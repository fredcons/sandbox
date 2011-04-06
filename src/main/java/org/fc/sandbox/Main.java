package org.fc.sandbox;

import twitter4j.AccountSettings;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;

public class Main {
	
	public static void main(String[] args) {
		try {
		    String login = args[0];
		    String password = args[1];
			Twitter tw = new TwitterFactory().getInstance(login, password);
			AccountSettings settings = tw.getAccountSettings();
			System.out.println(settings);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
