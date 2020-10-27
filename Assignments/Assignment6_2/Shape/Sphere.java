import java.lang.Math;

public class Sphere extends ThreeDimensionalShape {
	
	public Sphere(double x1, double y1, double z1,
				  double x2, double y2, double z2)
	{
		Point3D[] points = new Point3D[2];
		
		points[0] = new Point3D(x1,y1,z1);
		points[1] = new Point3D(x2,y2,z2);
		
		setPoints(points);
	}
	
	public double getRadius()
	{
		double x = getPoint(1).getX() - getPoint(0).getX();
		double y = getPoint(1).getY() - getPoint(0).getY();
		double z = getPoint(1).getZ() - getPoint(0).getZ();
		
		
		double xPow = Math.pow(x, 2);
		double yPow = Math.pow(y, 2);
		double zPow = Math.pow(z, 2);
		
		double r = Math.sqrt(xPow + yPow + zPow);
		
		return r;
	}
	
	@Override
	public double getArea()
	{
		return 4.0 * Math.PI * Math.pow(getRadius(),2);
	}
	
	@Override
	public double getVolume()
	{
		return (4.0/3.0) * Math.PI * Math.pow(getRadius(),3);
	}
	
	@Override
	public String toString(){
		
		return String.format("\n%s: %,.2f\n%s: %,.2f\n\n",
							 "Sphere\nSurface Area is", getArea(),
							 "Volume is", getVolume());
		
	}
}