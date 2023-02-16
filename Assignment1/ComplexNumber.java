/**
    Name: Athanasios Papapostolou
    AM  : 4147
**/

class ComplexNumber {
	private double real;
	private double imag;

	ComplexNumber(ComplexNumber original) {
		this.real = original.getReal();
		this.imag = original.getImag();
	}

	ComplexNumber(double real, double imag) {
		this.real = real;
		this.imag = imag;	
	}

	public void setReal(double value) {
		this.real = value;
	}

	public double getReal() {
		return real;
	}

	public void setImag(double value) {
		this.imag = value;
	}

	public double getImag() {
		return imag;
	}

	/* Format doubles in BigDecimal form in order to avoid false precision calculations */
	public ComplexNumber addComp(ComplexNumber num) {
		real += num.getReal();
        imag += num.getImag();
		return this;
	}

	public ComplexNumber subtractComp(ComplexNumber num) {
		real -= num.getReal();
        imag -= num.getImag();
		return this;
	}

	public ComplexNumber multiplyComp(ComplexNumber num) {
		/* Add first and last for the real value (with i^2 = -1) */
        real = (real * num.getReal()) + (-1 * imag * num.getImag());
		/* Add outer and inner for the imag value */
        imag = (real * num.getImag()) + (imag * num.getReal());
		return this;
	}

	public String toString() {
		if(imag > 0)
			return String.valueOf(real) + " + " + String.valueOf(imag) + "i";
		return String.valueOf(real) + " - " + String.valueOf(Math.abs(imag)) + "i";
	}

	public boolean equals(ComplexNumber num) {
		return (real == num.getReal() && imag == num.getImag());
	}

	/* Getter for accessing the overriden toString methods (TODO: CHECK IF IT IS OBJECT ORIENTED) */
	public String getToString() {
		return this.toString(); /* Sort of breaks encapsulation (Bad Design) */
	}
}
