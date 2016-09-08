package tomhaslam.euler.code;

public class Problem0007 extends Problem {
	/*
	By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
	What is the 10 001st prime number?
	 */
	public long solve(int nth)
	{
		int primeCount = 0;
		long number = 0;
		while(primeCount <= nth)
		{
			number++;
			if (this.isPrime(number)) primeCount++;
		}
		
		return number;
	}
}
