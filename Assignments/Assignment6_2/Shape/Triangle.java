public class Triangle extends TwoDimensionalShape {
	
	public Triangle(double x1, double y1, double x2, double y2, double x3, double y3)
	{
		Point[] points = new Point[3];
		
		points[0] = new Point(x1,y1);
		points[1] = new Point(x2,y2);
		points[2] = new Point(x3,y3);
		
		setPoints(points);
	}
	
	public double getBase()
	{
		if(getPoint(0).getY() == getPoint(1).getY())
		{
			return Math.abs(getPoint(0).getX() - getPoint(1).getX());
		}
		else 
		{
			return Math.abs(getPoint(1).getX() - getPoint(2).getX());
		}
	}
	
	public double getHeight()
	{
		if(getPoint(0).getY() == getPoint(1).getY())
		{
			return Math.abs(getPoint(1).getY() - getPoint(2).getY());
		}
		else 
		{
			return Math.abs(getPoint(0).getY() - getPoint(1).getY());
		}
	}
	
	@Override
	public double getArea()
	{
		return .5 * getBase() * getHeight();
	}
	
	@Override
	public String toString(){
		return String.format("\n%s: %,.2f\n\n", "Triangle\nArea is", getArea());
	}
	
}