package com.navi.stockexchange.models;

import java.sql.Time;
import java.util.Date;

public class Order {
    public String id;
    public String stockName;
    public Time orderCreationTime;
    public OrderType orderType;
    public int orderQuantity;
    public double orderPrice;

    public Order(String id, String stockName, Time orderCreationTime, OrderType orderType, int orderQuantity, double orderPrice) {
        this.id = id;
        this.stockName = stockName;
        this.orderCreationTime = orderCreationTime;
        this.orderType = orderType;
        this.orderQuantity = orderQuantity;
        this.orderPrice = orderPrice;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public Time getOrderCreationTime() {
        return orderCreationTime;
    }

    public void setOrderCreationTime(Time orderCreationTime) {
        this.orderCreationTime = orderCreationTime;
    }

    public OrderType getOrderType() {
        return orderType;
    }

    public void setOrderType(OrderType orderType) {
        this.orderType = orderType;
    }

    public int getOrderQuantity() {
        return orderQuantity;
    }

    public void setOrderQuantity(int orderQuantity) {
        this.orderQuantity = orderQuantity;
    }

    public double getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(double orderPrice) {
        this.orderPrice = orderPrice;
    }
}
