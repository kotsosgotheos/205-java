import java.util.Random;

class ComplexMatrix {
	private ComplexNumber[][] matrix;
	private Random rand = new Random(); /* Used for creating random doubles to fill our matrices with */
	private int rows;
	private int cols;

	private double computeRandom() {
		int randomNum = (int)((rand.nextDouble() - 0.5) * rand.nextInt(20) * 100);
        return randomNum / 100.0;
	}
	
	ComplexMatrix(ComplexMatrix original) {
		this.rows = original.getRows();
		this.cols = original.getCols();
		this.matrix = new ComplexNumber[rows][cols];

		for(int i = 0; i < rows; i++)
			for(int j = 0; j < cols; j++)
				matrix[i][j] = new ComplexNumber(original.getMatrix()[i][j]);
	}

	ComplexMatrix(int rows, int cols) {
		this.rows = rows;
		this.cols = cols;
		this.matrix = new ComplexNumber[rows][cols];

		for(int i = 0; i < rows; i++)
			for(int j = 0; j < cols; j++)
				matrix[i][j] = new ComplexNumber(computeRandom(), computeRandom());
	}

	public int getRows() {
		return this.rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getCols() {
		return this.cols;
	}

	public void setCols(int cols) {
		this.cols = cols;
	}

	public ComplexNumber[][] getMatrix() {
		return this.matrix;
	}

	public ComplexMatrix CompAdd(ComplexMatrix other_matrix) {
		ComplexMatrix dup = new ComplexMatrix(this);

		if(rows != other_matrix.getRows() || cols != other_matrix.getCols())
			return null; /* If the matrices have different sizes, just return a null object */

		for(int i = 0; i < rows; i++)
			for(int j = 0; j < cols; j++)
				dup.getMatrix()[i][j].addComp(other_matrix.getMatrix()[i][j]);

        return dup; /* self does not change */
	}

	public ComplexMatrix CompSubtract(ComplexMatrix other_matrix) {
		ComplexMatrix dup = new ComplexMatrix(this);

		if(rows != other_matrix.getRows() || cols != other_matrix.getCols())
			return null; /* If the matrices have different sizes, just return a null object */

		for(int i = 0; i < rows; i++)
			for(int j = 0; j < cols; j++)
				dup.getMatrix()[i][j].subtractComp(other_matrix.getMatrix()[i][j]);

        return dup; /* self does not change */
	}

	public String toString() {
		String retstring = "[";
		
        for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				retstring += matrix[i][j].getToString();

				if(j != cols - 1)
					retstring += ", ";
			}
			
            if(i == rows - 1) /* Checks for string formatting */
				retstring += ";]";
			else
				retstring += ";\n";
		}
		
        return retstring;
	}
}
