package tomhaslam.euler.code;

import java.util.HashMap;

/*
A permutation is an ordered arrangement of objects. For example, 3124 is one possible permutation of the digits 1, 2, 3 and 4. 
If all of the permutations are listed numerically or alphabetically, we call it lexicographic order. 
The lexicographic permutations of 0, 1 and 2 are:
012   021   102   120   201   210
What is the millionth lexicographic permutation of the digits 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?
 */
public class Problem0024 extends Problem 
{
	HashMap<Integer, Integer> reserved = new HashMap<Integer, Integer>();
	StringBuffer permutation = new StringBuffer();
	String answer = null;
	int count = 0;
	
	public long solve(StringBuffer refAnswer)
	{
		permute(10, 1000000);
		refAnswer.append(answer);
		System.out.print(refAnswer.toString() + "\n");
		return -1;
	}
	
	private void permute(int length, int stopAt) 
	{	
		for (int i=0; i<length; i++) 
		{
			// if number already being used move to next iteration
			if (reserved.containsKey(i)) continue;
			
			reserved.put(i, i);
			permutation.append(i);
			
			if (reserved.size() == length)
			{
				count++;
				// check for our answer to the problem
				if (count == stopAt)
				{
					answer = permutation.toString();
					return;
				}
				
				reserved.remove(i);
				permutation.setLength(permutation.length() - 1);
				return;
			}
			
			permute(length, stopAt);
			if (answer != null) return; // found answer stop here
			
			reserved.remove(i);
			permutation.setLength(permutation.length() - 1);
		}
	}
}
