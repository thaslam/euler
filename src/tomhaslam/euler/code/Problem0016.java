package tomhaslam.euler.code;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Problem0016 extends Problem {
	
	public long solve(int exp) 
	{
		List<Character> product = this.twoToThePowerOf(Arrays.asList('2'), exp, 1);
		int sum = 0;
		for(char c : product) sum += Character.getNumericValue(c);
		return sum;
	}
	
	// I could have used BigInteger to solve this problem, 
	// but that would not have been any fun
	public List<Character> twoToThePowerOf(List<Character> number, int exp, int count)
	{
		if (count == exp) return number; // base case
		
		int carry = 0;
		List<Character> product = new ArrayList<Character>();
		for (int i=number.size()-1; i>=0; i--)
		{
			int value = Character.getNumericValue(number.get(i)) * 2;
			value += carry;
			
			// not last number but need to assign carry value
			if (i!=0 && value > 9) 
			{
				carry = 1;
				value = value % 10;
				product.add(0,(char)('0' + value));
			}
			// last value but greater than 9 so need to breakup the number into two elements
			else if (value > 9) 
			{
				value = value % 10;
				product.add(0,(char)('0' + value));
				product.add(0,'1');
			}
			// only single digit don't need to do anything
			else
			{
				carry = 0;
				product.add(0,(char)('0' + value));
			}
		}
		
		return twoToThePowerOf(product, exp, count+1);
	}
	
	
}
