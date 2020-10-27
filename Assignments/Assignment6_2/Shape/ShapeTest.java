public class ShapeTest {
	public static void main(String [] args){
		
		Shape[] shapes = new Shape[6];
		
		//TwoDimensionalShapes
		Square square = new Square(0.0, 0.0, 0.0, 4.0, 4.0, 4.0, 4.0, 0.0);
		Triangle triangle = new Triangle(0.0,0.0, 0.0, 4.0, 4.0, 0.0);
		Circle circle = new Circle(0.0, 0.0, 0.0, 4.0);
		
		//ThreeDimensionalShapes
		Cube cube = new Cube(0.0, 0.0, 0.0,
							 0.0, 4.0, 0.0,
							 4.0, 4.0, 0.0,
							 4.0, 0.0, 0.0,
							 0.0, 0.0, 4.0,
							 0.0, 4.0, 4.0,
							 4.0, 4.0, 4.0,
							 4.0, 0.0, 4.0);
							 
		Tetrahedron tetrahedron = new Tetrahedron(0.0, 0.0, 0.0,
												  0.0, 4.0, 0.0,
												  4.0, 0.0, 0.0,
												  2.0, 2.0, 4.0);
												  
		Sphere sphere = new Sphere(0.0, 0.0, 0.0,
								   0.0, 4.0, 0.0);
		
		
		
		shapes[0] = square;
		shapes[1] = triangle;
		shapes[2] = circle;
		shapes[3] = cube;
		shapes[4] = tetrahedron;
		shapes[5] = sphere;
		
		for (Shape currentShape : shapes)
		{
			System.out.printf("%s: %s", "currentShape",currentShape);
		}
		
		
	}
}