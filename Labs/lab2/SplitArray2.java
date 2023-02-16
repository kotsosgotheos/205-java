class SplitArray2 {
	public static void main(String args[]) {
		int A[] = {1, 5, 7, 9, 12, 15, 23, 34, 56, 76, 87, 99, 100, 101};
		int B[] = {2, 3, 4, 2, 1, 1};
		int C[][] = new int[B.length][];
		int offset = 0;
		
        for(int i = 0; i < B.length; i++) {
			C[i] = new int[B[i]];
			
            for(int j = 0; j < B[i]; j++) {
				C[i][j] = A[offset + j];
			}
			offset += B[i];
		}

		for(int i = 0; i < C.length; i++){
			for(int j = 0; j < C[i].length; j++){
				System.out.print(C[i][j] + " ");
			}
			System.out.println();
		}
	}
}
