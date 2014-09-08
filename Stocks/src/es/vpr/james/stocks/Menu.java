package es.vpr.james.stocks;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    private Scanner scanner;
    private ArrayList<Stock> stocks;

    public Menu() {
        scanner = new Scanner(System.in);
        stocks = new ArrayList<>();
    }

    public void run() {
        System.out.println("Program Initiated.");
        System.out.println("Please input a command.");
        String input = "";

        for (;;) {
            input = scanner.nextLine();
            if (input.equalsIgnoreCase("add")) {
                add();
            } else if (input.equalsIgnoreCase("remove")) {
                remove();
            } else if (input.equalsIgnoreCase("set commision")) {
                setCommision();
            } else if (input.equalsIgnoreCase("set refresh")) {
                setRefresh();
            } else if (input.equalsIgnoreCase("start")) {
                if (stocks.size() != 0) {
                    break;
                }
                System.out
                        .println("Please add at least one symbol before starting.");
            } else {
                System.out
                        .println("Supported inputs: add, remove, set commision, set refresh");
            }
        }
    }

    private void add() {
        System.out.print("Input SYMBOL ");
        System.out.println("(Currently does not check for wrong symbols.) : ");
        String symbol = scanner.nextLine();
        stocks.add(new Stock(symbol.toUpperCase()));
        System.out.println("Symbol " + symbol
                + " has been added to the portfolio.");
    }

    private void remove() {
        System.out.println("Currently not supported.");
        System.out.println("Restart please");
    }

    private void setCommision() {
        System.out.println("Currently not supported.");
        System.out.println("Restart please");
    }

    private void setRefresh() {
        System.out.println("Currently not supported.");
        System.out.println("Restart please");
    }

    public ArrayList<Stock> getStocks() {
        return stocks;
    }

}
