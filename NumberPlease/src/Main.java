import java.util.Scanner;

public class Main {
	/*
	 * The upper left hand corner is (1, 1). The upper right is (10, 1) and the
	 * lower right is (10, 10). The input is four sets of two non-adjacent corners
	 * of a rectangle, in no particular order. The output is the sum of the numbers
	 * within the defined rectangle.
	 */
	static int[][] grid = new int[][] { { 2, 4, 5, 6, 1, 8, 9, 1, 4, 5 }, { 3, 5, 7, 9, 10, 3, 2, 5, 6, 7 },
			{ 6, 4, 4, 5, 10, 8, 5, 6, 7, 8 }, { 4, 7, 7, 9, 3, 2, 7, 14, 9, 0 }, { 5, 6, 8, 8, 8, 7, 7, 5, 5, 7 },
			{ 6, 5, 4, 6, 4, 1, 3, 6, 8, 7 }, { 8, 8, 3, 7, 8, 4, 4, 4, 6, 3 }, { 10, 8, 16, 7, 3, 7, 8, 25, 9, 2 },
			{ 4, 8, 3, 8, 2, 4, 6, 7, 10, 4 }, { 4, 3, 6, 8, 1, 4, 3, 7, 3, 4 } };

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		System.out.print("Enter column 1 index: ");
		int c1 = s.nextInt();
		System.out.print("Enter row 1 index: ");
		int r1 = s.nextInt();

		System.out.print("Enter column 2 index: ");
		int c2 = s.nextInt();
		System.out.print("Enter row 2 index: ");
		int r2 = s.nextInt();
		int x = 0;
		if (r1 < r2) {
			if (c2 < c1) {
				r1 -= 1;
				c2 -= 1;
				for (int i = r1; i < r2; i++) {
					for (int j = c2; j < c1; j++) {
						System.out.println(grid[i][j]);
						x += grid[i][j];
					}
				}
			}
			if (c1 < c2) {
				r1 -= 1;
				c1 -= 1;
				for (int i = r1; i < r2; i++) {
					for (int j = c1; j < c2; j++) {
						System.out.println(grid[i][j]);
						x += grid[i][j];
					}
				}
			}
			if (c1 == c2) {
				c1 -= 1;
				r1 -= 1;
				for (int i = r1; i < r2; i++) {
					x += grid[i][c1];
				}
			}
		}
		if (r2 < r1) {
			if (c1 < c2) {
				r2 -= 1;
				c1 -= 1;
				for (int i = r2; i < r1; i++) {
					for (int j = c1; j < c2; j++) {
						System.out.println(grid[i][j]);
						x += grid[i][j];
					}
				}
			}
			if (c2 < c1) {
				r1 -= 1;
				c2 -= 1;
				for (int i = r1; i < r2; i++) {
					for (int j = c2; j < c1; j++) {
						System.out.println(grid[i][j]);
						x += grid[i][j];
					}
				}
			}
			if (c1 == c2) {
				c1 -= 1;
				r2 -= 1;
				for (int i = r2; i < r1; i++) {
					x += grid[i][c1];
				}
			}
		}
		if (r1 == r2) {
			if (c1 < c2) {
				c1 -= 1;
				r1 -= 1;
				for (int i = c1; i < c2; i++) {
					System.out.println(grid[r1][i]);
					x += grid[r1][i];
				}
			}
			if (c2 < c1) {
				c2 -= 1;
				r1 -= 1;
				for (int i = c2; i < c1; i++) {
					System.out.println(grid[r1][i]);
					x += grid[r1][i];
				}
			}
			if (c1 == c2) {
				r1 -= 1;
				c1 -= 1;
				x = grid[r1][c1];
			}
		}
		System.out.print(x);
	}

}
