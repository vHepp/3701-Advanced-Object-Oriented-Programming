public class Cube extends ThreeDimensionalShape{
	
	public Cube(double x1, double y1, double z1,
				  double x2, double y2, double z2,
				  double x3, double y3, double z3,
				  double x4, double y4, double z4,
				  double x5, double y5, double z5,
				  double x6, double y6, double z6,
				  double x7, double y7, double z7,
				  double x8, double y8, double z8)
	{
		Point3D[] points = new Point3D[8];
		
		points[0] = new Point3D(x1,y1,z1);
		points[1] = new Point3D(x2,y2,z2);
		points[2] = new Point3D(x3,y3,z3);
		points[3] = new Point3D(x4,y4,z4);
		points[4] = new Point3D(x5,y5,z5);
		points[5] = new Point3D(x6,y6,z6);
		points[6] = new Point3D(x7,y7,z7);
		points[7] = new Point3D(x8,y8,z8);
		
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
		return Math.pow(getLength(), 2) * 6.0;
	}
	
	@Override
	public double getVolume()
	{
		return Math.pow(getLength(), 3);
	}
	
	@Override
	public String toString(){
		
		return String.format("\n%s: %,.2f\n%s: %,.2f\n\n",
							 "Cube\nSurface Area is", getArea(),
							 "Volume is", getVolume());
		
	}
}