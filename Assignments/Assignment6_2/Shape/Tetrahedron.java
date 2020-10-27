public class Tetrahedron extends ThreeDimensionalShape {
	
	public Tetrahedron(double x1, double y1, double z1,
					   double x2, double y2, double z2,
					   double x3, double y3, double z3,
					   double x4, double y4, double z4)
	{
		Point3D[] points = new Point3D[4];
		
		points[0] = new Point3D(x1,y1,z1);
		points[1] = new Point3D(x2,y2,z2);
		points[2] = new Point3D(x3,y3,z3);
		points[3] = new Point3D(x4,y4,z4);
		
		setPoints(points);
	}
	
	public double getDistance(int p1, int p2)
	{
		double x = getPoint(p2).getX() - getPoint(p1).getX();
		double y = getPoint(p2).getY() - getPoint(p1).getY();
		double z = getPoint(p2).getZ() - getPoint(p1).getZ();
		
		double xPow = Math.pow(x, 2);
		double yPow = Math.pow(y, 2);
		double zPow = Math.pow(z, 2);
		
		double d = Math.sqrt(xPow + yPow + zPow);
		
		return d;
	}
	
	@Override
	public double getArea()
	{
		double V = getDistance(0,1);
		double W = getDistance(0,2);
		double u = getDistance(0,3);
		double U = getDistance(1,2);
		double w = getDistance(1,3);
		double v = getDistance(2,3);
		
		double p1 = .5 * (V + u + w);
		double p2 = .5 * (w + U + v);
		double p3 = .5 * (u + v + W);
		double p4 = .5 * (V + U + W);
		
		double a1 = Math.sqrt(p1 * (p1 - V) * (p1 - u) * (p1 - w));
		double a2 = Math.sqrt(p2 * (p2 - w) * (p2 - U) * (p2 - v));
		double a3 = Math.sqrt(p3 * (p3 - u) * (p3 - v) * (p3 - W));
		double a4 = Math.sqrt(p4 * (p4 - V) * (p4 - U) * (p4 - W));
		
		double sArea = a1 + a2 + a3 + a4;
		
		return sArea;
	}
	
	@Override
	public double getVolume()
	{
		double V = getDistance(0,1);
		double W = getDistance(0,2);
		double u = getDistance(0,3);
		double U = getDistance(1,2);
		double w = getDistance(1,3);
		double v = getDistance(2,3);
		
		double uPow = Math.pow(u, 2);
		double vPow = Math.pow(v, 2);
		double wPow = Math.pow(w, 2);
		double UPow = Math.pow(U, 2); 
		double VPow = Math.pow(V, 2); 
		double WPow = Math.pow(W, 2);
		
		double a = 4 * (uPow * vPow * wPow) 
        - uPow * Math.pow((vPow + wPow - UPow), 2) 
        - vPow * Math.pow((wPow + uPow - VPow), 2) 
        - wPow * Math.pow((uPow + vPow - WPow), 2) 
        + (vPow + wPow - UPow) * (wPow + uPow - VPow)  
        * (uPow + vPow - WPow);
		
		return Math.sqrt(a) / 12.0;
	}
	
	@Override
	public String toString(){
		
		return String.format("\n%s: %,.2f\n%s: %,.2f\n\n",
							 "Tetrahedron\nSurface Area is", getArea(),
							 "Volume is", getVolume());
	}
}