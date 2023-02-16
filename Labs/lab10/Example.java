class Person {
	private String firstName;
	private String lastName;
	
	public Person(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public String toString() {
		return this.firstName + " " + this.lastName;
	}
}

class IdPerson extends Person {
	private int id;
	
	public IdPerson(String firstName, String lastName, int id) {
		super(firstName, lastName);
		this.id = id;
	}
	
	public String toString() {
		return super.toString() + " " + this.id;
	}
}

class Example {
	public static void main(String[] args) {
		IdPerson p = new IdPerson("Alice", "Wonderland", 10);
		System.out.println(p);
	}
}
