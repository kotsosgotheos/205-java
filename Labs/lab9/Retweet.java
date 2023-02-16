class Retweet extends Tweet {
	private Tweet original;
	
	public Retweet(String handle, String text, Tweet original) {
		super(handle, text);
		this.original = original;
		original.setRetweets(original.getRetweets() + 1);
	}
	
	public Retweet(String handle, Tweet original) {
		this(handle, "", original);
		// Εναλλακτική υλοποίηση
/* 		super(handle, "");
		this.original = original;
		original.setRetweets(original.getRetweets() + 1); */
	}
	
	public String toString() {
		return super.toString() + " RT -> " + original.toString();
	}
}