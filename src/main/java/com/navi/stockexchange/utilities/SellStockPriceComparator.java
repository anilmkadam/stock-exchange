package com.navi.stockexchange.utilities;

import com.navi.stockexchange.models.Order;

import java.util.Comparator;

public class SellStockPriceComparator implements Comparator<Order> {
    @Override
    public int compare(Order o1, Order o2) {
        if(o1.orderPrice == o2.orderPrice)
            return o1.orderCreationTime.compareTo(o2.orderCreationTime);

        return (o1.orderPrice > o2.orderPrice) ? 1 : -1;
    }
}
