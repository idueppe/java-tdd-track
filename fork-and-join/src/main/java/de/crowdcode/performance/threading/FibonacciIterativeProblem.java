package de.crowdcode.performance.threading;

import java.math.BigInteger;

public class FibonacciIterativeProblem implements Fibonacci {

	public BigInteger solve(long number) {
	    if (number == 0) {
	        return BigInteger.ZERO;
	    } else if (number < 3) {
	        return BigInteger.ONE;
	    } else {
    	    BigInteger fibonacci = BigInteger.ZERO;
    	    BigInteger minusOne = BigInteger.ONE;
    	    BigInteger minusTwo = BigInteger.ZERO;
    	    for (long n = 1; n < number; n++) {
    	        fibonacci = minusOne.add(minusTwo);
    	        minusTwo = minusOne;
    	        minusOne = fibonacci;
    	    }
    	    return fibonacci;
	    }
	}

}
