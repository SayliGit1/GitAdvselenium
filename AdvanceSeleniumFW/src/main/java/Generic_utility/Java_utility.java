package Generic_utility;

import java.util.Random;

public class Java_utility {
	
	 //this method is used to avoid duplicates
	
	public int getRandomValue() {
		Random ran = new Random();
		int ranNum = ran.nextInt(1000);
		
		return ranNum;
	}

}
