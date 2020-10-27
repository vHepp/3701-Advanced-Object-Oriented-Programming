public abstract class ThreeDimensionalShape extends Shape {
	
	//Array of Points used in the ThreeDimensionalShape
	private Point3D[] points;
	
	//gets a specific point from Array points
	public Point3D getPoint(int index)
	{
		return points[index];
	}
	
	//sets a specific point in Array points
	public void setPoints(Point3D[] points)
	{
		this.points = points;
	}
	
	public abstract double getArea(); //abstract method
	
	public abstract double getVolume(); //abstract method
	
	//toString is not concrete, still abstract
	
}