package Project_Inheritance_Interface;

public class Rectangle extends Shape_2D implements Shape{

	public double width;
	public double height;
	
	//constructs a new rectangle with width and height
	public Rectangle(double width, double height) {
		super(width,height);
	}
	
	
	//returns area of rectangle
	public double getArea() {
		return get_a()*get_b();
	}

	
	//returns perimeter of rectangle
	public double getPerimeter() {
		return 2.0 * (get_a()+get_b());
	}
	
}
