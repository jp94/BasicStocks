package es.vpr.james.stocks;

import java.util.Timer;

public class Main {

	private Timer timer;
	private Menu menu;

	public Main() {
		menu = new Menu();
		menu.run();
		timer = new Timer();
		timer.schedule(new Repeater(menu.getStocks()), 0, 2000);
	}

	public static void main(String[] args) {
		new Main();
	}

}
