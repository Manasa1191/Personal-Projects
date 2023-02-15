package Project_Inheritance_Interface;

public class Square extends Shape_2D implements Shape{
		public double side;
		private double otherside;
		
		public Square(double side, double otherside) {
			super(side,otherside);
		}
		
		//returns area of square
		public double getArea() {
			return get_a()*get_a();
		}

		
		//returns perimeter of square
		public double getPerimeter() {
			return 4.0 * get_a();
		}
}
