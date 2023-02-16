class DynamicArray {
    private int size;
    private int capacity;
    private int array[];

    public DynamicArray(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.array = new int[capacity];
    }

    public void add(int x) {
        if(size == capacity) {
            capacity *= 2;
            int tempArray[] = new int[capacity];
            
            for(int i = 0; i < size; i++) {
                tempArray[i] = array[i];
            }
            array = tempArray;
        }

        array[size] = x;
        size++;
    }

    public int remove() {
        if(size == 0) return -1;

        size--;
        int retValue = array[size];

        if(size == capacity / 4) {
            capacity /= 2;
            int tempArray[] = new int[capacity];

            for(int i = 0; i < size; i++) {
                tempArray[i] = array[i];
            }
            array = tempArray;
        }
        return retValue;
    }

    public int getCapacity() {
        return capacity;
    }

    public void print() {
        for(int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}

class DynamicArrayTest {
	public static void main(String args[]) {
		DynamicArray array = new DynamicArray(2);
		System.out.println("Removed: " + array.remove());
		
        array.add(8);
		array.add(6);
		array.add(9);
		
        System.out.println("Capacity: " + array.getCapacity());
		array.print();
		
        System.out.println("Removed: " + array.remove());
		System.out.println("Removed: " + array.remove());
		System.out.println("Capacity: " + array.getCapacity());
		array.print();
	}
}
