package tomhaslam.euler.code;

public class Problem0005 extends Problem {
	/*
	2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
	What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
	evens only
	take first even factor
	*/
	public long solve(int min, int max)
	{
		int smallest = -1;
		int count = max;
		
		while (smallest < 0)
		{
			if (count % max == 0) 
			{
				smallest = count; // test
				for (int i=max-1;i>=min;i--)
				{
					if (count % i != 0)  
					{
						smallest = -1;
						break;
					}
				}
			}
			count += max;
		}
		
		return smallest;
	}
}
