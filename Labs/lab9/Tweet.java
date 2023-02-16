class Tweet {
	private String handle;
	private String text = "";
	private int retweets = 0;
	
	public Tweet(String handle, String text) {
		this.handle = handle;
		this.text = text;
	}

	public void display() {
		System.out.println(this);
		System.out.println(retweets + " retweets");
	}
	
	public String toString() {
		return handle + ": " + text;
	}
	
	public void setRetweets(int retweets) {
		this.retweets = retweets;
	}
	
	public int getRetweets() {
		return retweets;
	}
}