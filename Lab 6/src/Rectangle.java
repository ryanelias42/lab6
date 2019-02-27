
public class Rectangle extends Polygon {
	
	private double height;
	private double width;
	
	public Rectangle (String id, double height, double width) {
		super(id);
		this.height = height;
		this.width = width;
		sideLengths.add(width);
		sideLengths.add(width);
		sideLengths.add(height);
		sideLengths.add(height);
		
		
	}
	
	@Override
	public double getArea() {
		return this.width * this.height;
	}
	@Override
	public String getShapeType() {
		return "Rectangle";
	}
}
