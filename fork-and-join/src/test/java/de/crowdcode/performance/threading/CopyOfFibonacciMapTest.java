package de.crowdcode.performance.threading;

import java.math.BigInteger;

import org.junit.Test;

public class CopyOfFibonacciMapTest {

    @Test
    public void testFibonacciMillion() {
        BigInteger fibonacci = new FibonacciIterativeProblem().solve(500_000l);
        System.out.println(fibonacci.toString().length());
    }

}
