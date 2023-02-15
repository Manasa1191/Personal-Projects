package Project_Inheritance_Interface;

public class Triangle implements Shape{

	public double a,b,c;
	
	//constructs new triangle with sides
	public Triangle(double a, double b, double c) {
		this.a=a;
		this.b=b;
		this.c=c;
	}
	
	public double getArea() {
		double s = (a+b+c)/2.0;
		return Math.sqrt(s*(s-a)*(s-b)*(s-c));
	}

	
	public double getPerimeter() {
		return a+b+c;
	}
	
}
