package tomhaslam.euler.code;

import java.util.HashMap;

public class Problem0018 extends Problem {	
	public long solve() 
	{
		/*
		 * steps
		 * start from the bottom and traverse up
		 * when on the second to last row start calculating greatest path
		 * set greatest path foreach index value
		 * move up to the next row, keep calculating the greatest path up to the top
		 * this is recursive so when start = 0 exit and return index 0 greatest path value
		 */
		
		int[] triangle = new int[] {
				                            75,
				                          95, 64,
				                        17, 47, 82,
				                      18, 35, 87, 10,
				                    20,  4, 82, 47, 65,
				                  19,  1, 23, 75,  3, 34,
				                88, 02, 77, 73, 07, 63, 67,
				              99, 65, 04, 28, 06, 16, 70, 92,
				            41, 41, 26, 56, 83, 40, 80, 70, 33,
				          41, 48, 72, 33, 47, 32, 37, 16, 94, 29,
				        53, 71, 44, 65, 25, 43, 91, 52, 97, 51, 14,
				      70, 11, 33, 28, 77, 73, 17, 78, 39, 68, 17, 57,
				    91, 71, 52, 38, 17, 14, 91, 43, 58, 50, 27, 29, 48,
				  63, 66, 04, 68, 89, 53, 67, 30, 73, 16, 69, 87, 40, 31,
				04, 62, 98, 27, 23,  9, 70, 98, 73, 93, 38, 53, 60,  4, 23
		};
		
		return traversePreviousRow(triangle, 105, 119);
	}
	
	private HashMap<Integer, Integer> longestPath = new HashMap<Integer, Integer>();
	public int traversePreviousRow(int[] source, int start, int end) 
	{		
		for (int i=start; i<=end; i++) 
		{
			// we are on the last row, this it the longest path at this time
			if (end == source.length-1) 
			{
				longestPath.put(i, source[i]);
				continue;
			}
			
			// look at the previous longest path
			int offSet = i - start;
			int leftMax = longestPath.get(end + offSet + 1);
			int rightMax = longestPath.get(end + offSet + 2);
			longestPath.put(i, source[i]+ (leftMax > rightMax ? leftMax : rightMax));
		}
		
		// base case
		if (end == 0)
			return longestPath.get(0);
		
		return traversePreviousRow(source, start - (end - start), start - 1);
	}
}
