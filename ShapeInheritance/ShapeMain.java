package Project_Inheritance_Interface;

public class ShapeMain {

	public static void main(String[] args) {
		//Polymorphism at work.
		//Using interface as a type
		//The code in shape interface will be used by all objects
		Shape[] shapes = new Shape[3];
		shapes[0] = new Rectangle(8.0,10.2);
		shapes[1] = new Triangle(4,5,3.2);
		shapes[2] = new Square(3.2,0);
		for(int i=0;i<shapes.length;i++) {
			System.out.println("Area: "+shapes[i].getArea());
			System.out.println("Perimeter: "+shapes[i].getPerimeter());
			System.out.println();
		}
	}

}
