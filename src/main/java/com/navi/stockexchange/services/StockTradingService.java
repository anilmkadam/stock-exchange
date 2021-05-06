package com.navi.stockexchange.services;

import com.navi.stockexchange.models.Order;
import com.navi.stockexchange.models.OrderType;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Locale;

public class StockTradingService {
    public HashMap<String, StockExchangeService> stockExchangeServiceMap;

    public StockTradingService() {
        this.stockExchangeServiceMap = new HashMap<String, StockExchangeService>();
    }

    public Order addStockDetails(String stockDetail) throws ParseException {
        StockExchangeService stockOrder;
        Order order = parseStockOrder(stockDetail);

        if(!stockExchangeServiceMap.containsKey(order.stockName))
        {
            stockOrder = new StockExchangeService();
            stockExchangeServiceMap.put(order.stockName, stockOrder);
        }

        stockOrder = stockExchangeServiceMap.get(order.stockName);
        addStockToOrderBook(stockOrder, order);

        return order;
    }

    public void doTrade(Order order) {
        StockExchangeService stockExchangeService = stockExchangeServiceMap.get(order.stockName);
        stockExchangeService.exchange();
    }

    private void addStockToOrderBook(StockExchangeService stockOrderBook, Order order) {
        if (order.orderType == OrderType.BUY)
        {
            stockOrderBook.buyOrders.add(order);
            return;
        }
        stockOrderBook.sellOrders.add(order);
    }

    public Order parseStockOrder(String stockDetails) throws ParseException {
        var stockInfo = stockDetails.split(" +");
        String stockOrderId = stockInfo[0];
        Time time = new Time(new SimpleDateFormat("HH:mm").parse(stockInfo[1]).getTime());
        String stockName = stockInfo[2];
        OrderType stockType = OrderType.valueOf(stockInfo[3].toUpperCase(Locale.ROOT));
        double stockPrice = Double.parseDouble(stockInfo[4]);
        int stockQuantity = Integer.parseInt(stockInfo[5]);

        Order order = new Order(stockOrderId, stockName, time, stockType, stockQuantity, stockPrice);
        return order;
    }
}
