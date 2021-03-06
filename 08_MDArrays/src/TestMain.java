import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class TestMain {
	// example arrays for testing
	public int[][] 
		squarepos1, squarepos2,
		squareneg1, squareneg2,
		sorted1, sorted2, 
		reverse1, reverse2,
		jagged1, jagged2, 
		tall1, tall2, 
		wide1, wide2,
		negative1, negative2;
		
	@Before 
	public void setUp() {
	   sorted1 = new int[][] { //s
		   {1,2,3,4},
		   {5,6,7,8},
		   {9,10,11,12},
		   {13,14,15,16}
	   };
 	   sorted2 = new int[][] {  //s
		   {11,12,13},
		   {15,16,17},
		   {19,20,21},
		   {23,24,25}
	   };
	   reverse1 = new int[][] {//s
		   {16,15,14,13},
		   {12,11,10,9},
		   {8,7,6,5},
		   {4,3,2,1}
	   };
	   reverse2 = new int[][] {//s
		   {26,25,24,23},
		   {22,21,20,19},
		   {18,17,16,15},
		   {14,13,12,11}
	   };
	   squarepos1 = new int[][] {//s
		   {2,2,3,4},
		   {5,8,7,8},
		   {0,10,3,12},
		   {13,22,15,8}
	   };
	   squarepos2 = new int[][] { //s
		   {12,22,33,44},
		   {55,68,77,88},
		   {90,110,23,312},
		   {413,522,615,78}
	   };
	   squareneg1 = new int[][] { //s
		   {-1,-4,-22,-18},
		   {-20,-6,-3,-1},
		   {-99,-15,-18,-6},
		   {-7,-7,-6,-12}
	   };
	   squareneg2 = new int[][] { //s
		   {-11,-41,-221,-181},
		   {-201,-61,-31,-11},
		   {-991,-151,-181,-61},
		   {-71,-71,-61,-121}
	   };
	   jagged1 = new int[][] { //j
		   {1,2},
		   {3,4,6},
		   {8,0,1,9},
		   {-2,-20,-33},
		   {0}
	   };
	   jagged2 = new int[][] { //j
		   {12,22},
		   {32,42,62},
		   {82,02,12,92},
		   {-22,-202,-332},
		   {0}
	   };
	   tall1 = new int[][] { //r
		   {0,1},
		   {2,3},
		   {9,5},
		   {4,-20},
		   {18,16},
		   {20,20}
	   };
	   tall2 = new int[][] { //r
		   {30,31},
		   {32,33},
		   {39,35},
		   {34,-320},
		   {318,316},
		   {320,320}
	   };
	   wide1 = new int[][] {
		   {1,2,3,4,5,6},
		   {9,8,7,6,5,4},
		   {2,8,1,4,2,5}
	   };
	   wide2 = new int[][] {
		   {21,22,23,24,25,26},
		   {29,28,72,62,52,24},
		   {22,82,12,42,22,25}
	   };
	   negative1 = new int[][] {
		   {-3,-4,-12},
		   {-5,-7,-13},
		   {-20,-18,-1}
	   };
	   negative2 = new int[][] {
		   {-31,-41,-112},
		   {-51,-71,-113},
		   {-210,-118,-11}
	   };
    }

	@Test public void testGetTotal() {
		assertEquals(136, Main.getTotal(sorted1));
		assertEquals(216, Main.getTotal(sorted2));
		assertEquals(-198, Main.getTotal(jagged2));
	}

	@Test 
	public void testGetAverage() {
		assertEquals(8.5, Main.getAverage(sorted1), 0.00);
		assertEquals(18.0, Main.getAverage(sorted2), 0.00);
		assertEquals(-1.6153846153846154, Main.getAverage(jagged1), 0.001);
	}
	
	@Test public void testGetRowTotal() {
		assertEquals(10, Main.getRowTotal(sorted1, 0));
		assertEquals(-1384, Main.getRowTotal(squareneg2, 2));
		assertEquals(1, Main.getRowTotal(tall1, 0));
	}
	
	@Test public void testGetColumnTotal() {
		assertEquals(28, Main.getColumnTotal(sorted1, 0));
		assertEquals(-494, Main.getColumnTotal(squareneg2, 2));
		assertEquals(14, Main.getColumnTotal(wide1, 3));
	}
	
	@Test public void testGetHighestInRow() {
		assertEquals(4, Main.getHighestInRow(sorted1, 0));
		assertEquals(0, Main.getHighestInRow(jagged2, 4));
		assertEquals(-11, Main.getHighestInRow(squareneg2, 1));
	}
	
	@Test public void testGetLowestInRow() {
		assertEquals(1, Main.getLowestInRow(sorted1, 0));
		assertEquals(-201, Main.getLowestInRow(squareneg2, 1));
		assertEquals(0, Main.getLowestInRow(jagged2, 4));
	}
	
	@Test public void testGetHighestInColumn() {
		assertEquals(13, Main.getHighestInColumn(sorted1, 0));
		assertEquals(23, Main.getHighestInColumn(sorted2, 0));
		assertEquals(72, Main.getHighestInColumn(wide2, 2));
	}
	
	@Test public void testGetLowestInColumn() {
		assertEquals(1, Main.getLowestInColumn(sorted1, 0));
		assertEquals(13, Main.getLowestInColumn(sorted2, 2));
		assertEquals(-20, Main.getLowestInColumn(tall1, 1));
		assertEquals(-22, Main.getLowestInColumn(jagged2, 0));
	}
	
	@Test public void testGetBottomLeftToTopRightDiagonalSum() {
		assertEquals(34, Main.getBottomLeftToTopRightDiagonalSum(sorted1));
		assertEquals(644, Main.getBottomLeftToTopRightDiagonalSum(squarepos2));
		assertEquals(-43, Main.getBottomLeftToTopRightDiagonalSum(squareneg1));
	}
	
	@Test public void testGetTopLeftToBottomRightDiagonalSum() {
		assertEquals(34, Main.getTopLeftToBottomRightDiagonalSum(sorted1));
		assertEquals(74, Main.getTopLeftToBottomRightDiagonalSum(reverse2));
		assertEquals(-11, Main.getTopLeftToBottomRightDiagonalSum(negative1));
	}
	
	@Test public void testIsArraySorted() {
		assertEquals(true, Main.isArraySorted(sorted1));
		assertEquals(true, Main.isArraySorted(sorted2));
		assertEquals(false, Main.isArraySorted(reverse1));
		assertEquals(false, Main.isArraySorted(reverse2));
		assertEquals(false, Main.isArraySorted(squarepos1));
		assertEquals(false, Main.isArraySorted(squarepos2));
		assertEquals(false, Main.isArraySorted(squareneg1));
		assertEquals(false, Main.isArraySorted(squareneg2));
	}
	
	@Test public void testIsArrayReversed() {
		assertEquals(true, Main.isArrayReversed(reverse1));
		assertEquals(true, Main.isArrayReversed(reverse2));
	}
	
	@Test public void testIsJaggedArray() {
		assertEquals(true, Main.isJaggedArray(jagged1));
		assertEquals(true, Main.isJaggedArray(jagged1));
		assertEquals(false, Main.isJaggedArray(wide1));
		assertEquals(false, Main.isJaggedArray(wide2));
		assertEquals(false, Main.isJaggedArray(squareneg1));
		assertEquals(false, Main.isJaggedArray(squareneg2));
	}
	
	@Test public void testIsSquareArray() {
		assertEquals(true, Main.isSquareArray(sorted1));
		assertEquals(false, Main.isSquareArray(sorted2));
		assertEquals(false, Main.isSquareArray(jagged1));
		assertEquals(false, Main.isSquareArray(jagged2));
		assertEquals(false, Main.isSquareArray(tall1));
		assertEquals(false, Main.isSquareArray(tall2));
		assertEquals(false, Main.isSquareArray(wide1));
		assertEquals(false, Main.isSquareArray(wide2));
		assertEquals(true, Main.isSquareArray(negative1));
		assertEquals(true, Main.isSquareArray(negative2));
	}
	
	@Test public void testIsRectangularArray() {
		assertEquals(true, Main.isRectangularArray(wide1));
		assertEquals(true, Main.isRectangularArray(wide2));
		assertEquals(true, Main.isRectangularArray(tall1));
		assertEquals(true, Main.isRectangularArray(tall2));
		assertEquals(false, Main.isRectangularArray(jagged1));
		assertEquals(false, Main.isRectangularArray(jagged2));
		assertEquals(true, Main.isRectangularArray(squareneg1));
		assertEquals(true, Main.isRectangularArray(squareneg2));
		assertEquals(true, Main.isRectangularArray(squarepos1));
		assertEquals(true, Main.isRectangularArray(squarepos2));
	}
}
