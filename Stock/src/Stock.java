
public class Stock {
	private String symbol = "";
	private String name = "";
	private double currentPrice = 1;
	private double previousClosingPrice = 1;
	
	public Stock() {}
	public Stock(String symbol, String name) {
		this.symbol = symbol;
		this.name = name;
	}
	public Stock(String symbol, String name, double currentPrice, double previousClosingPrice) {
		this.symbol = symbol;
		this.name = name;
		this.currentPrice = currentPrice;
		this.previousClosingPrice = previousClosingPrice;
	}
	public double getCurrent() {
		return currentPrice;
	}
	public void setCurrent(double currentPrice) {
		this.currentPrice = currentPrice;
	}
	public double getPrevious() {
		return previousClosingPrice;
	}
	public void setPrevious(double previousClosingPrice) {
		this.previousClosingPrice = previousClosingPrice;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	
	public double getChangePercent() {
		return ((currentPrice - previousClosingPrice) / previousClosingPrice);
	}
	
	public String toString() {
		String a = name + " " + symbol + " " + currentPrice + " " + previousClosingPrice;
		return a;
	}
}
