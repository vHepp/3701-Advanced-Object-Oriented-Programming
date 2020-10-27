import java.lang.Math;

public class Circle extends TwoDimensionalShape {
	
	public Circle(double x1, double y1, double x2, double y2)
	{
		Point[] points = new Point[2];
		
		points[0] = new Point(x1,y1);
		points[1] = new Point(x2,y2);
		
		setPoints(points);
	}
	
	public double getRadius()
	{
		double x = getPoint(1).getX() - getPoint(0).getX();
		double y = getPoint(1).getY() - getPoint(0).getY();
		
		double xPow = Math.pow(x, 2);
		double yPow = Math.pow(y, 2);
		
		double r = Math.sqrt(xPow + yPow);
		
		return r;
	}
	
	@Override
	public double getArea()
	{
		return Math.PI * Math.pow(getRadius(),2);
	}
	
	@Override
	public String toString(){
		
		return String.format("\n%s: %,.2f\n\n", "Circle\nArea is", getArea());
		
	}
}