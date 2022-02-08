package mockitousingjunitexample;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;


import stocks.Portfolio;
import stocks.Stock;
import stocks.StockService;

public class PortfolioTester {
	 Portfolio  portfolio;
	 StockService stockService;
		public static void main(String[] args) {
		PortfolioTester tester=new PortfolioTester();
		tester.setUp();
		System.out.println(tester.testMarketValue()?"pass":"fail");
	}
	public void setUp() {
		// portfolio to created to be tested
		portfolio = new Portfolio();
		//CREATING MOCK Object of stock service
		stockService = mock(StockService.class);
		//set the stock service to the portfolio
		portfolio.setStockService(stockService);
	}
	public boolean testMarketValue() {
		//creating list of stocks to add the portfolio
		List<Stock> stocks=new ArrayList<Stock>();
		Stock googleStock = new Stock("1","Google",10);
		Stock wiproStock = new Stock("2","Wipro",100);
		//adding stocks to portfolio
		 stocks.add(googleStock);
		 stocks.add(wiproStock);
		 //mock the behaviour of stock service to return the value of various stocks
		 when(stockService.getPrice(wiproStock)).thenReturn(50.0);
		 when(stockService.getPrice(googleStock)).thenReturn(1000.0);
		 double marketValue = portfolio.getMarketValue();
		 return marketValue == 100500.0;
	
	}
}
