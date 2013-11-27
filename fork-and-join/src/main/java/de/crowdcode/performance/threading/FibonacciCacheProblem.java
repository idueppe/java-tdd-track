package de.crowdcode.performance.threading;

import java.math.BigInteger;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.log4j.Logger;

public class FibonacciCacheProblem implements Fibonacci {

	private static final Logger LOG = Logger.getLogger(FibonacciCacheProblem.class);
	
	private static Map<BigInteger, BigInteger> fibonacciCache = new ConcurrentHashMap<>();
	
	private BigInteger ONE = BigInteger.ONE;
	private BigInteger TWO = BigInteger.valueOf(2);

	public BigInteger solve(long number) {
	    BigInteger fibonacci = BigInteger.ZERO;
	    for (long n = 0; n <= number; n++) {
	        
	    }
//	    for (long i = 0; i <= number; i++) {
//	        fibonacci(BigInteger.valueOf(i));
//	    }
		return fibonacci(BigInteger.valueOf(number));
	}

	private BigInteger fibonacci(BigInteger n) {
		LOG.debug("Thread: " + Thread.currentThread().getName() + " calculates " + n);
		if (n.compareTo(BigInteger.ONE) <= 0) {
			return n;
		} else {
		    BigInteger fibo = fibonacciCache.get(n);
		    if (fibo != null) {
		        return fibo;
		    } else {
		        fibo = fibonacci(n.subtract(ONE)).add(fibonacci(n.subtract(TWO)));
		        fibonacciCache.put(n, fibo);
		        return fibo;
		    }
		}
	}

}
