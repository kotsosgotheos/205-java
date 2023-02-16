class ItemDynamicArray {
	private int capacity;
	private int size = 0;
	private Item array[];
	
	public ItemDynamicArray(int capacity) {
		this.capacity = capacity;
		array = new Item[capacity];
	}
	
	public ItemDynamicArray(ItemDynamicArray other) {
		this.capacity = other.capacity;
		this.size = other.size;
		array = new Item[capacity];
		for(int i = 0; i < size; i++) {
			this.array[i] = new Item(other.array[i]);
		}
	}
	
	public void add(Item x) {
		if(size == capacity) {
			capacity = 2 * capacity;
			Item tempArray[] = new Item[capacity];
			for(int i = 0; i < size; i++) {
				tempArray[i] = array[i];
			}
			array = tempArray;
		}
		array[size] = x;
		size++;
	}
	
	public Item remove() {
		if(size == 0) {
			return null;
		}
		size--;

		Item retValue = array[size];

		if(size == capacity / 4) {
			capacity = capacity / 2;
			Item tempArray[] = new Item[capacity];
			for(int i = 0; i < size; i++) {
				tempArray[i] = array[i];
			}
			array = tempArray;
		}
		return retValue;
	}
	
	public Item get(int i) {
		if(i < 0 || i > size-1) {
			return null;
		}
		return array[i];
	}
	
	public String toString() {
		String retString = "";
		for (int i = 0; i < size; i++) {
			retString += array[i] + " ";
		}
		return retString;
	}
	
	public boolean equals(ItemDynamicArray other) {
		if(this.size != other.size) {
			return false;
		}
		for(int i = 0; i < size; i++) {
			if(!this.array[i].equals(other.array[i])) {
				return false;
			}
		}
		return true;
	}
	
	public void add(ItemDynamicArray other) {
		for(int i = 0; i < other.size; i++) {
			this.add(new Item(other.array[i]));
		}
	}
	
	public ItemDynamicArray merge(ItemDynamicArray other) {
		ItemDynamicArray retArray = new ItemDynamicArray(this.capacity+other.capacity);
		for(int i = 0; i < this.size; i ++) {
			retArray.add(this.get(i));
		}
		for(int i = 0; i < other.size; i ++) {
			retArray.add(other.get(i));
		}
		return retArray;
	}
}
