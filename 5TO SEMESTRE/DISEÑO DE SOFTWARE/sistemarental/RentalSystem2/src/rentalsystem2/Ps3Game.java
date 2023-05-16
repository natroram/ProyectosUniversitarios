package rentalsystem2;


public class Ps3Game {

	private static final double CONSOLE_COST = 299.99 ;
	private static final double CONSOLE_RENTAL_COST = 29.99 ;
	private static final int NUM_DAYS_BASE_PRICE = 4;
	private static final double BASE_PRICE = 4;
	private static final double EXTRA_PRICE = 1.25;
	private static final int FREQUENT_RENTER_POINTS = 2;
	private static final String CONSOLE_NAME = "Playstation 3";
	
	private String _gameName;
		
	public Ps3Game(String name) {
		super();
		_gameName = name;
	}

	public String get_gameName() {
		return _gameName;
	}

	public String get_consoleName() {
		return CONSOLE_NAME;
	}
	

	public double getCharge(int _daysRented, boolean _consoleRented) {
		double result = 0;
		result += BASE_PRICE;
		if(_daysRented > NUM_DAYS_BASE_PRICE)
			result += (_daysRented - NUM_DAYS_BASE_PRICE)*EXTRA_PRICE;
		if(_consoleRented)
			result += CONSOLE_RENTAL_COST + _daysRented;
		return result;
	}
	
	public int getFrequentRenterPoints(int _daysRented, boolean _consoleRented) {
		if(_consoleRented && _daysRented > NUM_DAYS_BASE_PRICE)
			return FREQUENT_RENTER_POINTS + _daysRented - NUM_DAYS_BASE_PRICE;
		else 
			return FREQUENT_RENTER_POINTS;
	}
	
	public String toString() {
		return _gameName;
	}
}
