package io.dy.dto;

public class TickerDTO {

    //滞后15分钟的市场价格
    private String syncTime;
    //最新的市场价格
    private double last;
    //买入价格
    private double buy;
    //卖出价格
    private double sell;
    //币种符号
    private String symbol;

    public String getSyncTime() {
        return syncTime;
    }

    public TickerDTO setSyncTime(String syncTime) {
        this.syncTime = syncTime;
        return this;
    }

    public double getLast() {
        return last;
    }

    public TickerDTO setLast(double last) {
        this.last = last;
        return this;
    }

    public double getBuy() {
        return buy;
    }

    public TickerDTO setBuy(double buy) {
        this.buy = buy;
        return this;
    }

    public double getSell() {
        return sell;
    }

    public TickerDTO setSell(double sell) {
        this.sell = sell;
        return this;
    }

    public String getSymbol() {
        return symbol;
    }

    public TickerDTO setSymbol(String symbol) {
        this.symbol = symbol;
        return this;
    }

    public TickerDTO(String syncTime, double last, double buy, double sell, String symbol) {
        this.syncTime = syncTime;
        this.last = last;
        this.buy = buy;
        this.sell = sell;
        this.symbol = symbol;
    }

    public TickerDTO() {
    }
}
