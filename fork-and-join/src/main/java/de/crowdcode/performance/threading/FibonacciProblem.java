package de.crowdcode.performance.threading;

import java.math.BigInteger;

import org.apache.log4j.Logger;

public class FibonacciProblem implements Fibonacci {

	private static final Logger LOG = Logger.getLogger(FibonacciProblem.class);

	/* (non-Javadoc)
     * @see de.crowdcode.performance.threading.Fibonacci#solve()
     */
	@Override
    public BigInteger solve(long number) {
		return BigInteger.valueOf(fibonacci(number));
	}

	private long fibonacci(long n) {
		LOG.debug("Thread: " + Thread.currentThread().getName() + " calculates " + n);
		if (n <= 1L) {
			return n;
		} else {
			return fibonacci(n-1) + fibonacci(n-2);
		}
	}
}
