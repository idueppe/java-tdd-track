package de.crowdcode.performance.threading;

import java.math.BigInteger;
import java.util.concurrent.RecursiveTask;

import org.apache.log4j.Logger;

public class FibonacciTask extends RecursiveTask<BigInteger> {

	private static final long serialVersionUID = 1L;

	private static final Logger LOG = Logger.getLogger(FibonacciTask.class);

	private static final int THRESHOLD = 5;

	private long number;

	public FibonacciTask(long number) {
		this.number = number;
	}

	@Override
	protected BigInteger compute() {
		if (number < THRESHOLD) {
		    return new FibonacciProblem().solve(number);
		} else {
			LOG.debug("Forking problem "+number);
			FibonacciTask worker1 = new FibonacciTask(number - 1);
			FibonacciTask worker2 = new FibonacciTask(number - 2);
			worker1.fork();
			return worker2.compute().add(worker1.join());
		}
	}

}
