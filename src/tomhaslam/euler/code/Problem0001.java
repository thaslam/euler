package tomhaslam.euler.code;

import java.util.ArrayList;

public class Problem0001 extends Problem {
	
	/*
	If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
	Find the sum of all the multiples of 3 or 5 below 1000.
	*/
	public long solve(int max)
	{
		if (max < 0) throw new IllegalArgumentException("Must be greater than 0");
			
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i=0; i<max; i++)
		{
			if (i % 3 == 0 || i % 5 == 0) list.add(i);
		}
		int sum = 0;
		for (int i:list)
		{
			sum += i;
		}
			
		return sum;
	}
}
