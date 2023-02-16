class SplitArray {
	public static void main(String args[]) {
		int A[] = {1, 5, 7, 9, 12, 15, 23, 34, 56, 76, 87, 99, 100, 101};
		int B[] = {2, 3, 4, 2, 1, 1};
		int offset = 0;
		
        for(int i = 0; i < B.length; i++) {
			for(int j = 0; j < B[i]; j++) {
                System.out.print(A[offset + j] + " ");
			}
			System.out.println();
			offset += B[i];
		}
	}
}
