package com.navi.stockexchange;

// import org.springframework.boot.SpringApplication;
import com.navi.stockexchange.services.StockTradingService;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.Scanner;

@SpringBootApplication
public class StockExchangeApplication {

	public static void main(String[] args) {

		StockTradingService trade = new StockTradingService();

		File file = new File("./src/main/input.txt");
		try{
			Scanner myReader = new Scanner(file);
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				var order = trade.addStockDetails(data);
				trade.doTrade(order);
				//System.out.println("order => "+ order.id +" "+ order.stockName + " " + order.orderCreationTime + " " + order.orderType.toString() + " " +order.orderQuantity+ " "+order.orderPrice);
			}
			myReader.close();
		} catch (FileNotFoundException | ParseException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

}
