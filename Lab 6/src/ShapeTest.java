import org.junit.Assert;
import org.junit.Test;

/**
 * Lab 6
 *
 * Test class for shapes and their comparators.
 *
 * @author Stephen
 * @version 2019-02-18
 */
public class ShapeTest
{
	//==================================================================================================================
	// Basic Shape Testing:
	//==================================================================================================================
    /**
     * Tests for the square class.
     */
	@Test
	public void SquareTest()
	{
		Shape sqr = new Square("Square1", 3.0);
		Assert.assertEquals("Square area incorrect.", 9.0, sqr.getArea(), 0.0001);
		Assert.assertEquals("Square perimeter incorrect.", 12.0, sqr.getPerimeter(), 0.0001);
		Assert.assertEquals("Square type incorrect.", "Square", sqr.getShapeType());
		Assert.assertEquals("Shape ID incorrect.", "Square1", sqr.getId());
	}

	/**
     * Tests for the rectangle class.
     */
	@Test
	public void RectangleTest()
	{
		Shape rec = new Rectangle("rec1", 5,4);
		Assert.assertEquals("Rectangle area incorrect.", 20.0, rec.getArea(), 0.0001);
		Assert.assertEquals("Rectangle perimeter incorrect.",18.0,rec.getPerimeter(),0.0001);
		Assert.assertEquals("Rectangle type incorrect.", "Rectangle", rec.getShapeType());
		Assert.assertEquals("Shape ID incorrect.","rec1",rec.getId());
	}

	/**
     * Tests for the EquilateralTriangle class.
     */
	@Test
	public void TriangleTest()
	{
		Shape tri = new EquilateralTriangle("tri1",4.81);
		Assert.assertEquals("Triangle area incorrect.", 10.018225172248574, tri.getArea(),0.0001);
		Assert.assertEquals("Triangle perimeter incorrect.", 14.43, tri.getPerimeter(),0.0001);
		Assert.assertEquals("Triangle type incorrect","Equilateral Triangle", tri.getShapeType());
		Assert.assertEquals("Triangle ID incorrect.","tri1",tri.getId());
	}

	/**
     * Tests for the trapezoid class. Also test that IDs are done correctly.
     */
	@Test
	public void TrapezoidTest()
	{
		Shape trap = new Trapezoid("trap1",5,4,8,5);
		Assert.assertEquals("Trapezoid area incorrect.",26,trap.getArea(),0.0001);
		Assert.assertEquals("Trapezoid perimeter incorrect.",22, trap.getPerimeter(),0.0001);
		Assert.assertEquals("Trapezoid type incorrect.", "Trapezoid",trap.getShapeType());
		Assert.assertEquals("Trapezoid ID incorrect.", "trap1",trap.getId());
	}

	/**
     * Tests for the ellipse class. Also test that IDs are done correctly.
     */
	@Test
	public void EllipseTest()
	{
		Shape circ = new Ellipse("Ellipse1", 3.0, 3.0);
		Assert.assertEquals("Ellipse area incorrect.", Math.PI*3.0*3.0, circ.getArea(),0.0001);
		Assert.assertEquals("Ellipse perimeter incorrect.",
				2 * Math.PI * Math.sqrt((Math.pow(3, 2) + Math.pow(3, 2)) / 2),
				circ.getPerimeter(),0.0001);
		Assert.assertEquals("Ellipse type incorrect.", "Ellipse",circ.getShapeType());
		Assert.assertEquals("Shape ID incorrect.", "Ellipse1", circ.getId());

		Shape circs = new Ellipse("Ellipse2", 5.0, 3.0);
		Assert.assertEquals("Ellipse area incorrect.", Math.PI*3*5, circs.getArea(),0.0001);
		Assert.assertEquals("Ellipse perimeter incorrect.",
				2 * Math.PI * Math.sqrt((Math.pow(5.0, 2) + Math.pow(3.0, 2)) / 2),
				circs.getPerimeter(),0.0001);
		Assert.assertEquals("Ellipse type incorrect.", "Ellipse",circs.getShapeType());
		Assert.assertEquals("Shape ID incorrect.", "Ellipse2", circs.getId());
	}

	/**
     * Tests for the circle class. Also test that IDs are done correctly.
     */
	@Test
	public void CircleTest()
	{
		Shape circle = new Circle("cir1", 5);
		Assert.assertEquals("Circle area incorrect.", 78.53981633974483, circle.getArea(),0.0001);
		Assert.assertEquals("Circle perimeter incorrect.",31.41592653589793,circle.getPerimeter(),0.0001);
		Assert.assertEquals("Circle type incorrect.", "Circle", circle.getShapeType());
		Assert.assertEquals("Circle ID incorrect.", "cir1", circle.getId());
	}

	/**
	 * Tests for Shape's toString().
	 */
	@Test
	public void ShapeToStringTest()
	{
		Shape sqr = new Square("sqr", 3);		
		Assert.assertEquals("Shape toString incorrect.", "Square:\t ID = sqr\t area = 9.000\t perimeter = 12.000",sqr.toString());
		
	}

	//==================================================================================================================
	// Comparisons:
	//==================================================================================================================
	/**
     * Tests for the Shape Area Comparator class.
     */
	@Test
	public void CompareAreaTest()
	{
	    // Test equals:
		Shape rect = new Rectangle("R1", 3.0,3.0);
		Shape sqr = new Square("S1", 3.0);
		ShapeAreaComparator sc = new ShapeAreaComparator();
		Assert.assertEquals("ShapeAreaComparator should find shapes equal.", 0, sc.compare(rect, sqr));
		Assert.assertTrue("ShapeAreaComparator should find shapes equal.", sc.equals(rect, sqr));

		// Test equal perimeter, different area:
        Shape rect2 = new Rectangle("R2", 1.0, 9.0);
        Shape sqr2 = new Square("S2", 5.0);
        Assert.assertEquals("ShapeAreaComparator gave incorrect ordering.", -1, sc.compare(rect2, sqr2));
        Assert.assertEquals("ShapeAreaComparator gave incorrect ordering.", 1, sc.compare(sqr2, rect2));
        Assert.assertFalse("ShapeAreaComparator incorrectly finds shapes equal.", sc.equals(rect2, sqr2));

        // Test unequal perimeter and area:
        Assert.assertEquals("ShapeAreaComparator gave incorrect ordering.", 1, sc.compare(sqr2, rect));
        Assert.assertEquals("ShapeAreaComparator gave incorrect ordering.", -1, sc.compare(rect, sqr2));
        Assert.assertFalse("ShapeAreaComparator incorrectly finds shapes equal.", sc.equals(sqr2, rect));
	}

	/**
     * Tests for the Shape Perimter Comparator class.
     */
	@Test
	public void ComparePerimeterTest()
	{
		//test equal perimeter
		Shape s1 = new Square ("s1", 5);
		Shape r1 = new Rectangle("r1", 9, 1);
		ShapePerimeterComparator pc = new ShapePerimeterComparator();
		Assert.assertEquals("ShapePerimeterComparator should find shapes equal.", 0, pc.compare(s1,r1));
		Assert.assertTrue("ShapePerimeterComparator should find shapes equal", pc.equals(s1,r1));
		//test unequal perimeter
		Shape s2 = new Square ("s2", 5);
		Shape s3 = new Square ("s3", 4);
		Assert.assertEquals("ShapePerimeterComparator should find shapes unequal.",1, pc.compare(s2,s3));
		Assert.assertFalse("ShapePerimeterComparator should find shapes unequal.", pc.equals(s2,s3));
		
	}

	/**
	 * Tests the natural ordering of shapes (compareTo in shape)
	 */
	@Test
    public void NaturalCompareTest()
    {
		//test equal areas, equal perimeters
		Shape a = new Square("a", 5);
		Shape b = new Rectangle("b", 5,5);
		Assert.assertEquals("compareTo should return 0.",0,a.compareTo(b));
		//test equal areas, unequal perimeters
		Shape c = new Square("c", 10);
		Shape d = new Rectangle("d", 50,2);
		Assert.assertEquals("compareTo should return -1.",-1,c.compareTo(d));
		//test unequal areas, equal perimeters
		Shape e = new Square("e", 4);
		Shape f = new Rectangle("f", 6, 2);
		Assert.assertEquals("compareTo should return 1",1,e.compareTo(f));
		//test unequal areas, unequal perimeters
		Shape g = new Square("g", 6);
		Shape h = new Rectangle("h", 6,4);
		Assert.assertEquals("compareTo should return 1.",1,g.compareTo(h));
		//fixed missing test pointed out by webcat
		Assert.assertEquals("compareTo should return 1.",1,d.compareTo(c));
    }
}
