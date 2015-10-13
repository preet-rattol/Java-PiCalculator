package application;

import java.math.BigDecimal; 			// imports the BigDeciaml class 
import java.math.RoundingMode;			// imports theRoundingMode class

public class Calculator {
	public BigDecimal calculatePi(int iteration ,int precision) {		//method with 2 parameters for calcualting the value of PI.
		BigDecimal result = new BigDecimal(0);   // The result (summation of Taylor series)
		BigDecimal oddNum = new BigDecimal(1);   // Odd numbers (1, 3, 5, 7 etc.)
		BigDecimal pow5 = new BigDecimal(5);    // Odd powers of 5 (5^1, 5^3, 5^5 etc.)
		BigDecimal pow239 = new BigDecimal(239); // Odd powers of 239 (239^1, 239^3, 239^5 etc.)
		BigDecimal new239 = new BigDecimal(239); //constant for value 239.
		BigDecimal sign = new BigDecimal(1);     // Either 1 or -1 indicating the sign of the next term
		BigDecimal sixteen = new BigDecimal(16);  // variable for constant value 16	
		BigDecimal four = new BigDecimal(4);	  // variable for constant value 4
		
		BigDecimal five = new BigDecimal(5);	  // variable for constant value 5
		BigDecimal two = new BigDecimal(2);		  // variable for constant value 2
		BigDecimal minusOne = new BigDecimal(-1); // variable for constant value -1

		for (int count = 0; count < iteration; count++) {    //loop for number of times to repeat the formula for more accurate answer. 
			// The no. of repetitions depend on iteration parameter.

			// Calculate and add the next term in the series.
			// The sign of each new term alternates.

			// I have splited the formula into two parts :
			BigDecimal firstTerm = sixteen.divide(pow5.multiply(oddNum),precision,RoundingMode.HALF_UP);	// First half of the formula. 
			BigDecimal secondTerm =	four.divide(pow239.multiply(oddNum),precision,RoundingMode.HALF_UP);	// second half of the formula.

			BigDecimal nextTerm = firstTerm.subtract(secondTerm);			// first half subtracts second half								
			result = result.add(sign.multiply(nextTerm)) ;					// answer of calculation

			// Update variables for next time around loop
			pow5 = pow5.multiply(five.multiply(five));
			pow239 = pow239.multiply(new239.multiply(new239));
			oddNum = oddNum.add(two);
			sign = sign.multiply(minusOne);
		}
		return result;														//returns the final answer.

	}
}
