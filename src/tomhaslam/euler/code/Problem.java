package tomhaslam.euler.code;

public abstract class Problem {
	public long solve() 
	{
		throw new UnsupportedOperationException();
	}
	public long solve(int value)
	{
		throw new UnsupportedOperationException();
	}
	public long solve(long value)
	{
		throw new UnsupportedOperationException();
	}
	public long solve(StringBuffer refAnswer) 
	{
		throw new UnsupportedOperationException();
	}
	public long solve(int a, int b)
	{
		throw new UnsupportedOperationException();
	}
	
	public boolean isPalindrome(int number)
	{
		char[] numChars = String.valueOf(number).toCharArray();
		int limit = numChars.length / 2;
		for (int i=0; i<limit; i++)
		{
			if (numChars[i] != numChars[numChars.length -(i+1)]) return false;
		}
		
		return true;
	}
	
	public boolean isPrime(long num)
	{
		if(num < 1) return false;
		if(num == 2 || num == 3) return true;
		if(num % 2 == 0 ) return false; // kick out even numbers
		
		long limit = (long)Math.sqrt(num);
		
		// this loops works for numbers greater than 4
		for (long i=2; i<=limit; i++)
		{
			if (num % i == 0) return false;
		}
		
		return true;
	}
}
