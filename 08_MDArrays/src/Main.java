public class Main {

	public static void main(String[] args) {
		System.out.println("Work of Connor Redmond");
	}

	// return the total of all the values in the array.
	public static int getTotal(int[][] a) {
		int x = 0;
		for (int row = 0; row < a.length; row++) {
			for (int column = 0; column < a[row].length; column++) {
				x += a[row][column];
			}
		}
		return x;
	}

	// return the average of all the values in the array.
	public static double getAverage(int[][] a) {
		int numOfVal = 0;
		for (int row = 0; row < a.length; row++) {
			for (int column = 0; column < a[row].length; column++) {
				numOfVal += 1;
			}
		}
		int x = 0;
		for (int row = 0; row < a.length; row++) {
			for (int column = 0; column < a[row].length; column++) {
				x += a[row][column];
			}
		}
		return ((double) x / numOfVal);
	}

	// return the total of the values in the specified row.
	public static int getRowTotal(int[][] a, int row) {
		int total = 0;
		for (int column = 0; column < a[row].length; column++)
			total += a[row][column];
		return total;
	}

	// return the total of the values in the specified column.
	public static int getColumnTotal(int[][] a, int column) {
		int total = 0;
		for (int row = 0; row < a.length; row++)
			total += a[row][column];
		return total;
	}

	// return the highest value in the specified row of the array.
	public static int getHighestInRow(int[][] a, int row) {
		int x = 0;
		int z = -10000000; // could replace this with getLowest but im too lazy :(
		for (int column = 0; column < a[row].length; column++) {
			x = a[row][column];
			if (x > z) {
				z = x;
			}
		}
		return z;
	}

	// return the lowest value in the specified row of the array.
	public static int getLowestInRow(int[][] a, int row) {
		int x = 0;
		int z = 10000000;
		for (int column = 0; column < a[row].length; column++) {
			x = a[row][column];
			if (x < z) {
				z = x;
			}
		}
		return z;
	}

	// return the lowest value in the specified column of the array
	public static int getHighestInColumn(int[][] a, int column) {
		int x = 0;
		for (int row = 0; row < a.length; row++) {
			if (x < a[row][column]) {
				x = a[row][column];
			}
		}
		return x;
	}

	// return the highest value in the specified column of the array
	public static int getLowestInColumn(int[][] a, int column) {
		int x = 1000000; // could replace this with getHighest but im too lazy :(
		for (int row = 0; row < a.length; row++) {
			if (x > a[row][column]) {
				x = a[row][column];
			}
		}
		return x;
	}

	// return the diagonal sum, bottom left to top right
	public static int getBottomLeftToTopRightDiagonalSum(int[][] a) {
		int total = 0;
		int y = 0;
		int x = (a.length - 1);
		for (int i = 0; i < a.length; i++) {
			total += a[x][y];
			y += 1;
			x -= 1;
		}
		return total;
	}

	// return the diagonal sum, top left to bottom right
	public static int getTopLeftToBottomRightDiagonalSum(int[][] a) {
		int total = 0;
		int y = 0;
		for (int x = 0; x < a.length; x++) {
			total += a[x][x];
			y = x;
		}
		return total;
	}

	// return true if the array is sorted low to high
	public static boolean isArraySorted(int[][] a) {
		int x = 0;
		int y = 0;
		for (int row = 0; row < a.length; row++) {
			for (int column = 0; column < a[row].length; column++) {
				x = a[row][column];
				if (x > y) {
					y = x;
				} else {
					return false;
				}
			}
		}
		return true;
	}

	// return true if array is sorted high to low
	public static boolean isArrayReversed(int[][] a) {
		int x = 0;
		int y = 50; // could replace this with getHighest but im too lazy :(
		for (int row = 0; row < a.length; row++) {
			for (int column = 0; column < a[row].length; column++) {
				x = a[row][column];
				if (x < y) {
					y = x;
				} else {
					return false;
				}
			}
		}
		return true;
	}

	// return true if array is jagged
	public static boolean isJaggedArray(int[][] a) {
		int x = 0;
		int z = a[0].length;
		for (int row = 0; row < a.length; row++) {
			x = a[row].length;
			if (x != z) {
				return true;
			}
		}
		return false;
	}

	// return true if array is square (n x n)
	public static boolean isSquareArray(int[][] a) {
		int length = a.length;
		int test = 0;
		for (int row = 0; row < length; row++) {
			if (a[row].length == length) {
				test += 1;
			}
		}
		if (length == (test)) {
			return true;
		} else {
			return false;
		}
	}

	// return true if array is rectangular (n x m)
	public static boolean isRectangularArray(int[][] a) {
		if((a.length != a[0].length && a[0].length == a[a.length-1].length) || (a.length == a[0].length && a.length == a[a.length-1].length)) {

			return true;

		} else {

			return false;

		}
	}
}
