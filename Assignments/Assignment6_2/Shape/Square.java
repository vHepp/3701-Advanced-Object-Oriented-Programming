public class Square extends TwoDimensionalShape{
	
	public Square(double x1, double y1, double x2, double y2, double x3, double y3, double x4, double y4)
	{
		Point[] points = new Point[4];
		
		points[0] = new Point(x1,y1);
		points[1] = new Point(x2,y2);
		points[2] = new Point(x3,y3);
		points[3] = new Point(x4,y4);
		
		setPoints(points);
	}
	
	public double getLength()
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
	
	@Override
	public double getArea()
	{
		return Math.pow(getLength(), 2);
	}
	
	@Override
	public String toString(){
		return String.format("\n%s: %,.2f\n\n", "Square\nArea is", getArea());
	}
}