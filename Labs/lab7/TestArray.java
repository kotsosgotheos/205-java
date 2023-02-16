class TestArray {
	public static void main(String[] args) {
		ItemDynamicArray storeList1 = new ItemDynamicArray(2);
		storeList1.add(new Item("Phone", 250));
		storeList1.add(new Item("TV", 1000));
		storeList1.add(new Item("Laptop", 500));

		System.out.println(storeList1);
		
		//Δημιουργήστε ένα αντικείμενο – αντίγραφο του storeList1
		System.out.println("Equality of list 1 and 2 is " + storeList1.equals(storeList2));

		storeList1.get(1).setPrice(1000 * 0.9);
		System.out.println("Equality of list 1 and 2 is " + storeList1.equals(storeList2));
		
		//Κάντε merge τα δύο αντικείμενα ItemDynamicArray που δημιουργήσατε πιο πάνω στο αντικείμενο storeList3
		//Προσθέστε (add) το πίνακα storeList2 στο πίνακα storeList1
		System.out.println("Equality of list 1 and 3 is " + storeList1.equals(storeList3));
		System.out.println(storeList3);
	}
}
