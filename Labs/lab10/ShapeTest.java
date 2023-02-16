interface ShapeProperties {
	public double perimeter();
	public double area();
	public double areaToPerimeterRatio();
}

abstract class Shape implements ShapeProperties {
	private String name;
	
	public Shape(String name) {
		this.name = name;
	}
	
	public abstract double perimeter();	
	public abstract double area();
	
	public double areaToPerimeterRatio() {
		return area() / perimeter();
	}
	
	public void print() {
		System.out.println(this.name + ": " + perimeter() + " " + area() + " " + areaToPerimeterRatio());
	}
}

class RightTriangle extends Shape {
	private double firstSide;
	private double secondSide;
	
	public RightTriangle(String name, double f, double s) {
		super(name);
		this.firstSide = f;
		this.secondSide = s;
	}
	
	public double area() {
		return this.firstSide * this.secondSide / 2;
	}
	
	public double perimeter() {
		double hypo = Math.sqrt(Math.pow(this.firstSide, 2) + Math.pow(this.secondSide, 2));
		return this.firstSide + this.secondSide + hypo;
	}
}

class Circle extends Shape {
	private double radius;
	
	public Circle(String name, double r) {
		super(name);
		this.radius = r;
	}
	
	public double area() {
		return Math.PI * radius * radius;
	}
	
	public double perimeter() {
		return 2 * Math.PI * radius;
	}
}

class ShapeTest {
	public static void main(String[] args) {
		ShapeProperties[] array = new ShapeProperties[4];
		array[0] = new RightTriangle("Triangle1", 2, 1);
		array[1] = new Circle("Circle1", 1);
		array[2] = new RightTriangle("Triangle2", 3, 2);
		array[3] = new Circle("Circle2", 2);

		Shape maxShape = null;
		double maxRatio = 0;
		for(int i = 0; i < 4; i++) {
			((Shape)array[i]).print();
			if(maxRatio < array[i].areaToPerimeterRatio()) {
				maxShape = (Shape)array[i];
				maxRatio = array[i].areaToPerimeterRatio();
			}
		}
		
		System.out.println("\nShape with max area/perimeter:");
		maxShape.print();
	}
}
