package tomhaslam.euler.code;

public class Problem0016 extends Problem {
	
	public long solve(int exp) 
	{
		long product = (long)Math.pow(2, exp);
		char[] numbers = String.valueOf(product).toCharArray();
		int sum = 0;
		
		for(char c : numbers)
		{
			int i = Integer.valueOf(String.valueOf(c));
			sum += i;
		}
		
		return sum;
	}
	
}
