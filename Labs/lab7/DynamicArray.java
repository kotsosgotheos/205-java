class DynamicArray
{
	private int capacity;
	private int size = 0;
	private int[] array;
	
	public DynamicArray(int capacity){
		this.capacity = capacity;
		array = new int[capacity];
	}
	
	public void add(int x)
	{
		if (size == capacity){
			capacity = 2*capacity;
			int[] tempArray = new int[capacity];
			for (int i = 0; i < size; i ++){
				tempArray[i] = array[i];
			}
			array = tempArray;
		}
		array[size] = x;
		size ++;
	}
	
	public int remove()
	{
		if (size == 0){
			return -1;
		}
		size -- ;
		int retValue = array[size];
		if (size == capacity/4){
			capacity = capacity/2;
			int[] tempArray = new int[capacity];
			for (int i = 0; i < size; i ++){
				tempArray[i] = array[i];
			}
			array = tempArray;
		}
		return retValue;
	}	
}
	
