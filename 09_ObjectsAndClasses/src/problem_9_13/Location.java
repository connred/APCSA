package problem_9_13;

public class Location {

	public int row;
	public int column;
	public double maxValue;
	
	public static Location locateLargest(double[][] a) {
		Location loc = new Location();		
		loc.maxValue = Double.MIN_VALUE;
		loc.row = 0;
		loc.column = 0;

		for(int i = 0; i < a.length; i++) {
			for(int j = 0; j < a[i].length; j++) {
				if(a[i][j] > loc.maxValue) {
					loc.maxValue = a[i][j];
					loc.row = i;
					loc.column = j;
				}
			}
		}
		
		return loc;
	}
}
