package com.navi.stockexchange.services;

import com.navi.stockexchange.models.Order;
import com.navi.stockexchange.utilities.BuyStockPriceComparator;
import com.navi.stockexchange.utilities.SellStockPriceComparator;

import java.util.Iterator;
import java.util.PriorityQueue;

public class StockExchangeService {
    public PriorityQueue<Order> buyOrders;
    public PriorityQueue<Order> sellOrders;

    public StockExchangeService() {
        buyOrders = new PriorityQueue<Order>(new BuyStockPriceComparator());
        sellOrders = new PriorityQueue<Order>(new SellStockPriceComparator());
    }

    public void exchange() {
        Iterator i1 = buyOrders.iterator(), i2 = sellOrders.iterator();

        while (buyOrders.size() > 0 && sellOrders.size() > 0) {
            Order buyOrder = buyOrders.peek(), sellOrder = sellOrders.peek();
            if(buyOrder.orderPrice >= sellOrder.orderPrice) {
                System.out.println(buyOrder.id + " " + sellOrder.orderPrice + " " + getUpdatedQuantity(buyOrder.orderQuantity, sellOrder.orderQuantity) + " " + sellOrder.id);

                if(buyOrder.orderQuantity > sellOrder.orderQuantity) {
                    buyOrder.orderQuantity -= sellOrder.orderQuantity;
                    sellOrders.remove(sellOrder);
                }
                else {
                    sellOrder.orderQuantity -= buyOrder.orderQuantity;
                    buyOrders.remove(buyOrder);
                }
            }
            else
                break;
        }
    }

    private int getUpdatedQuantity(int buyOrderQuantity, int sellOrderQuantity)
    {
        return (buyOrderQuantity <= sellOrderQuantity ? buyOrderQuantity : sellOrderQuantity);
    }
}
