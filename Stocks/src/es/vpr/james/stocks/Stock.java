package es.vpr.james.stocks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class Stock {

    private String symbol;
    private double price;
    private int volume;
    private double daylow;
    private double dayhigh;
    private double marketcap;

    public Stock(String symbol, double price, int volume, double daylow,
            double dayhigh, double marketcap) {
        this.symbol = symbol;
        this.price = price;
        this.volume = volume;
        this.daylow = daylow;
        this.dayhigh = dayhigh;
        this.marketcap = marketcap;
    }

    public Stock(String symbol) {
        this(symbol, 0.0, 0, 0.0, 0.0, 0.0);
    }

    public String getSymbol() {
        return this.symbol;
    }

    public Double getPrice() {
        return this.price;
    }

    public int getVolume() {
        return this.volume;
    }

    public double getDaylow() {
        return this.daylow;
    }

    public double getDayhigh() {
        return this.dayhigh;
    }

    public double getMarketcap() {
        return this.marketcap;
    }

    public void update() {
        try {
            URL yahoo = new URL("http://finance.yahoo.com/d/quotes.csv?s="
                    + symbol + "&f=l1vghj3");
            URLConnection connection = yahoo.openConnection();
            InputStreamReader is = new InputStreamReader(
                    connection.getInputStream());
            BufferedReader br = new BufferedReader(is);

            String line = br.readLine();
            String[] stockinfo = line.split(",");

            MathUtil mu = new MathUtil();

            price = mu.stringToDouble(stockinfo[0]);
            volume = mu.stringToInt(stockinfo[1]);
            daylow = mu.stringToDouble(stockinfo[2]);
            dayhigh = mu.stringToDouble(stockinfo[3]);
            marketcap = mu.stringToDouble(stockinfo[4]);

        } catch (IOException e) {
            System.out.println("IOException!");
        }
    }
}
