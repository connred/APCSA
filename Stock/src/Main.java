
public class Main {
	public static void main(String[] args) {
		Stock a = new Stock();
		Stock b = new Stock("B","b");
		Stock c = new Stock("C","c",7,4);
		
		a.setSymbol("A");
		a.setName("a");
		a.setPrevious(8);
		a.setCurrent(4);
		
		b.setPrevious(10);
		b.setCurrent(5);
		
		System.out.println(a);
		System.out.println(b);
		
		System.out.println("Best is " + getBestPerformance(a,b,c));
		System.out.println("Worst is " + getWorstPerformance(a,b,c));
		
	}
	public static Stock getBestPerformance(Stock... stocks) {
		Stock best = stocks[0];
		for(Stock s : stocks) {
			double cp = s.getChangePercent();
			double b = best.getChangePercent();
			if (cp > b) 
				best = s;
		}
		
		return best;
	}
	public static Stock getWorstPerformance(Stock... stocks) {
		Stock worst = stocks[0];
		for(Stock s : stocks) {
			double cp = s.getChangePercent();
			double w = worst.getChangePercent();
			if (cp < w) {
				worst = s;
			}
		}
		return worst;
	}
	
}
