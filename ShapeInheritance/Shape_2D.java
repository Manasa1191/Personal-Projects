package Project_Inheritance_Interface;
// This is super class for square and rectangle sub classes
public class Shape_2D {
	private double a;
	private double b;
	
	//constructs a 2d figure 
	public Shape_2D(double a, double b) {
		this.a=a;
		this.b=b;
	}
	//returns value of a
	public double get_a() {
		return a;
	}
	//returns value of b
	public double get_b() {
		return b;
	}
	//set value of a
	public void set_a() {
		this.a=a;
	}
	//set value of b
	public void set_b() {
		this.b=b;
	}
	
}
