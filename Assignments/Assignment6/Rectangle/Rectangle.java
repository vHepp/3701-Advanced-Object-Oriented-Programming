public class Rectangle{
	private float length, width;
	
	public Rectangle(){
		length = 1.0f;
		width = 1.0f;
	}
	
	public Rectangle(float l, float w){
		if (l > 0f && l < 20f)
			length = l;
		else
			throw new IllegalArgumentException("length out of range");
		
		
		if (w > 0f && w < 20f)
			width = w;
		else
			throw new IllegalArgumentException("width out of range");
	}
	
	public void setLength(float l){
		if (l > 0.f && l < 20.f)
			length = l;
		else
			throw new IllegalArgumentException("length out of range");
	}
	
	public void setWidth(float w){
		if (w > 0f && w < 20f)
			width = w;
		else
			throw new IllegalArgumentException("width out of range");
	}
	
	public float getLength(){
		return length;
	}
	
	public float getWidth(){
		return width;
	}
	
	public float getPerimeter(){
		return 2f * getLength() + 2f * getWidth();
	}
	
	public float getArea(){
		return getLength()*getWidth();
	}
	
	public String toString(){
		return String.format("%s: %f%n%s: %f%n%s: %f%n%s: %f", "Length", getLength(), "Width", getWidth(), "Perimeter", getPerimeter(), "Area", getArea());
	}
	
}