package es.vpr.james.stocks;

import java.util.ArrayList;
import java.util.TimerTask;

public class Repeater extends TimerTask {

    private ArrayList<Stock> stocks;

    public Repeater(ArrayList<Stock> stocks) {
        this.stocks = stocks;
    }

    @Override
    public void run() {
        for (Stock stock : stocks) {
            stock.update();
            runAlgorithms();
            System.out
                    .println("===============================================");
            System.out.println("STOCK SYMBOL: " + stock.getSymbol());
            System.out.println("Price: " + stock.getPrice());
            System.out.println("Volume: " + stock.getVolume());
            System.out.println("Day Low: " + stock.getDaylow());
            System.out.println("Day High: " + stock.getDayhigh());
            System.out.println("Market Cap: " + stock.getMarketcap());
            System.out
                    .println("===============================================");

        }
    }

    //private void checkHold
    private void runAlgorithms() {
        new PriceMonitor();
    }
}
