public abstract class TwoDimensionalShape extends Shape {
	
	//Array of Points used in the TwoDimensionalShape
	private Point[] points;
	
	//gets a specific point from Array points
	public Point getPoint(int index)
	{
		return points[index];
	}
	
	//sets a specific point in Array points
	public void setPoints(Point[] points)
	{
		this.points = points;
	}
	
	public abstract double getArea(); //abstract method
	
	//toString is not concrete, still abstract
	
}