import java.util.ArrayList;

class Twitter {
	public static void main(String[] args) {
		ArrayList<Tweet> tweets = new ArrayList<Tweet>();

		Tweet t = new Tweet("@Alice", "Hello World");
		tweets.add(t);
		
		PhotoTweet pt = new PhotoTweet("@Bob", "Good morning", "Coffee Cup");
		tweets.add(pt);
		
		Retweet rt = new Retweet("@Charlie", "Good morning Bob", pt);
		tweets.add(rt);
		
		Retweet rt2 = new Retweet("@David", pt);
		tweets.add(rt2);
		
		displayTweets(tweets);
	}
	
	private static void displayTweets(ArrayList<Tweet> tweets) {
		for(Tweet t : tweets) {
			t.display();
			System.out.println();
		}
	}
}