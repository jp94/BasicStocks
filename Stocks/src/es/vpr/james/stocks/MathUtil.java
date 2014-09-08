package es.vpr.james.stocks;

public class MathUtil {

	public double stringToDouble(String s) {
		
		Double num;
		
		if (s.equals("N/A")) {
			num = 0.00;
		} else {
			num = Double.parseDouble(s);
		}
		return num;
	}

	public int stringToInt(String s) {
		int num;
		
		if (s.equals("N/A")) {
			num = 0;
		} else {
			num = Integer.parseInt(s);
		}
		return num;
	}

}
