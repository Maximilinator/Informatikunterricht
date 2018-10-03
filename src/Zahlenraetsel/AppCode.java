package Zahlenraetsel;

import java.util.Random;

public class AppCode {

	private int maxNumber = 0;
	private int actualNumber = 0;
	private int triesLeft;

	Random random = new Random();

	public AppCode() {
	}

	public void start() {
		generateRandomNumber(maxNumber);
	}

	public int generateRandomNumber(int maxNumber) {
		actualNumber = random.nextInt(maxNumber + 1);
		System.out.println("Random number has been generated! (" + actualNumber + ")");
		return actualNumber;
	}

	public String tipHigherLower(String tip) {
		if (isInt(tip)) {
			int number = Integer.parseInt(tip);
			if (number < actualNumber) {
				triesLeft--;
				return "Größer!";
			} else if (number > actualNumber) {
				triesLeft--;
				return "Kleiner!";
			} else {
				triesLeft--;
				return "Richtig!";
			}
		} else return "Das war keine Zahl!";
	}

	public boolean isInt(String input) {
		try {
			Integer.parseInt(input);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public void setMaxNumber(int maxNumber) {
		this.maxNumber = maxNumber;
	}

	public int getMaxNumber() {
		return maxNumber;
	}

	public int getActualNumber() {
		return actualNumber;
	}
	
	public String getTriesLeftAsString() {
		return "" + triesLeft;
	}
	
	public void setTriesLeft(int triesLeft) {
		this.triesLeft = triesLeft;
	}
	
	public int getTriesLeft() {
		return triesLeft;
	}
}
