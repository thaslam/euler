package tomhaslam.euler.code;

import java.util.ArrayList;

public class Problem0003 extends Problem {
	/*
	The prime factors of 13195 are 5, 7, 13 and 29.
	What is the largest prime factor of the number 600851475143 ?
	loop from 1 to num
	if not mod 2 and not mod num then add to list
	*/
	public long solve(long num)
	{
		if (num < 1) throw new IllegalArgumentException("Input be greater than 0");
		long max = 0;
		
		long limit = (long)Math.sqrt(num);
		ArrayList<Long> factors = new ArrayList<Long>();
		
		System.out.printf("Starting...\n");
		for (long i=1; i<=limit; i++)
		{
			if (num % i == 0) 
			{
				factors.add(i);
				System.out.printf("Percent complete %d - %d \n", (i*100)/num, i);
			}
		}
		
		System.out.printf("Done %d factors found \n", factors.size());

		for (int i=(factors.size()-1); i>=0; i--)
		{
			if (isPrime(factors.get(i))) return factors.get(i);
		}
		return max;
	}
}
