package de.crowdcode.performance.threading;

import static org.junit.Assert.*;

import java.math.BigInteger;

import org.junit.Test;

public class FibonacciIterativeTest {

    @Test
    public void testFibonacci() {
        Fibonacci fibonacci = new FibonacciIterativeProblem();
        assertEquals(BigInteger.valueOf(0), fibonacci.solve(0));
        assertEquals(BigInteger.valueOf(1), fibonacci.solve(1));
        assertEquals(BigInteger.valueOf(1), fibonacci.solve(2));
        assertEquals(BigInteger.valueOf(2), fibonacci.solve(3));
        assertEquals(BigInteger.valueOf(3), fibonacci.solve(4));
        assertEquals(BigInteger.valueOf(5), fibonacci.solve(5));
        assertEquals(BigInteger.valueOf(8), fibonacci.solve(6));
        assertEquals(BigInteger.valueOf(13), fibonacci.solve(7));
        assertEquals(BigInteger.valueOf(21), fibonacci.solve(8));
        assertEquals(BigInteger.valueOf(34), fibonacci.solve(9));
        assertEquals(BigInteger.valueOf(55), fibonacci.solve(10));
        assertEquals(BigInteger.valueOf(89), fibonacci.solve(11));
    }
    
    @Test
    public void testBigFibonacci() {
        long number = 2_000_000l;
        BigInteger solve = new FibonacciIterativeProblem().solve(number);
        System.out.println("Fibonacci from " + number + " has " + solve.toString().length() + " digits.");
        System.out.println(solve);
    }

}
