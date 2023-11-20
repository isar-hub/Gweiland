package com.gweiland.Adapter;

public class MyListData {

    String logo,name,symbol,change24h,priceUSD;

    public MyListData(String logo, String name, String symbol, String change24h, String priceUSD) {
        this.logo = logo;
        this.name = name;
        this.symbol = symbol;
        this.change24h = change24h;
        this.priceUSD = priceUSD;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
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

    public String getChange24h() {
        return change24h;
    }

    public void setChange24h(String change24h) {
        this.change24h = change24h;
    }

    public String getPriceUSD() {
        return priceUSD;
    }

    public void setPriceUSD(String priceUSD) {
        this.priceUSD = priceUSD;
    }
}
