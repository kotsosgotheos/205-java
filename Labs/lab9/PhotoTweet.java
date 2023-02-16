class PhotoTweet extends Tweet {
	private String photo;
	
	public PhotoTweet(String handle, String text, String photo) {
		super(handle, text);
		this.photo = photo;
	}

	public String toString() {
		return super.toString() + ", Photo: " + photo;
	}
}