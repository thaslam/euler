package tomhaslam.euler.code;

public class Problem0009 extends Problem {
	/*
	A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,

	a2 + b2 = c2
	For example, 32 + 42 = 9 + 16 = 25 = 52.
	
	There exists exactly one Pythagorean triplet for which a + b + c = 1000.
	Find the product abc. 
	
	a + b + c = 1000
	a,b,c < square root of 1000
		i: 1
		J: 2,3...998
		k: 3,4...999
	*/
	public long solve(int sum)
	{
		int aSquared = 0;
		int bSquared = 0;
		int cSquared = 0;
		
		for (int a=0; a<sum-2; a++)
		{
			aSquared = (int)Math.pow(a, 2);
			for (int b=a+1; b<sum-1; b++)
			{
				bSquared = (int)Math.pow(b, 2);
				for (int c=b+1; c<sum; c++)
				{
					cSquared = (int)Math.pow(c, 2);
					
					if ((aSquared + bSquared) == cSquared &&
						(a + b + c) == sum) 
					{
						return a*b*c;
					}
				}
			}
		}
		
		return -1;
	}
}
