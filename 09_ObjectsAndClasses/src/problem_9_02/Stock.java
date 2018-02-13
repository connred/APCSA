package problem_9_02;

class Stock {
	String symbol, name;
	double previousClosingPrice, currentPrice;
	
	Stock(String symbol, String name) {
		this.symbol = symbol;
		this.name = name;
	}
	
	double getChangePercent() {
		return (currentPrice - previousClosingPrice) / previousClosingPrice; 
	}
}
