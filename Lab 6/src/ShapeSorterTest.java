import java.util.Comparator;

import org.junit.Assert;
import org.junit.Test;

/**
 * Lab 6
 *
 * Test class for ShapeSorter.
 * Implicitly tests that the comparators are implemented correctly.
 *
 * @author Stephen
 * @version 2019-02-18
 */
public class ShapeSorterTest
{
	/**
	 * Test that shapes are added correctly.
	 */
	@Test
	public void AddShapeTest()
	{
		ShapeSorter sorter = new ShapeSorter();

		Shape a = new Rectangle("test", 3, 3);
		Shape b = new EquilateralTriangle("test2", 4);
		Shape c = new Square("test3", 3);
		Shape d = new Circle("test4", 1.5);

		sorter.addShape(a);
		sorter.addShape(b);
		sorter.addShape(c);
		sorter.addShape(d);

		Assert.assertEquals("Shapes added incorrectly...", sorter.shapes.get(0), a);
		Assert.assertEquals("Shapes added incorrectly...", sorter.shapes.get(1), b);
		Assert.assertEquals("Shapes added incorrectly...", sorter.shapes.get(2), c);
		Assert.assertEquals("Shapes added incorrectly...", sorter.shapes.get(3), d);
	}

	/**
	 * Tests sorting via the default ordering.
	 */
	@Test
	public void SortShapesDefaultTest()
	{
		ShapeSorter sorter = new ShapeSorter();
		Shape a = new Square("a",5);
		Shape b = new Square("b", 4);
		Shape c = new Rectangle("c",2,3);
		sorter.addShape(a);
		sorter.addShape(b);
		sorter.addShape(c);
		
		sorter.sortShapes();
		String ex = sorter.toString();
		Assert.assertEquals("Rectangle:\t ID = c\t area = 6.000\t perimeter = 10.000Square:\t ID = b\t area = 16.000\t perimeter = 16.000Square:\t ID = a\t area = 25.000\t perimeter = 20.000",ex);
	}

	/**
	 * Tests sorting by area ordering.
	 */
	@Test
	public void SortShapesAreaTest()
	{
		ShapeSorter sorter = new ShapeSorter();
		Shape a = new Square("a",5);
		Shape b = new Square("b", 3);
		sorter.addShape(a);
		sorter.addShape(b);
		sorter.sortShapes(new ShapeAreaComparator());
		String ans = sorter.toString();
		Assert.assertEquals(ans,"Square:\t ID = b\t area = 9.000\t perimeter = 12.000Square:\t ID = a\t area = 25.000\t perimeter = 20.000");
	}

	/**
	 * Tests sorting by perimeter ordering.
	 */
	@Test
	public void SortShapesPerimeterTest()
	{
		ShapeSorter sorter = new ShapeSorter();
		Shape c = new Rectangle ("c",3,2);
		Shape d = new Square ("d", 2);
		
		sorter.addShape(c);
		sorter.addShape(d);
		sorter.sortShapes(new ShapePerimeterComparator());
		String ans = sorter.toString();
		Assert.assertEquals(ans,"Square:\t ID = d\t area = 4.000\t perimeter = 8.000Rectangle:\t ID = c\t area = 6.000\t perimeter = 10.000");
	}

	/**
	 * Tests the toString.
	 */
	@Test
	public void ToStringTest()
	{
		Shape x = new EquilateralTriangle("x", 6);
		String xx = x.toString();
		Assert.assertEquals(xx, "Equilateral Triangle:\t ID = x\t area = 15.588\t perimeter = 18.000");
	}
}
