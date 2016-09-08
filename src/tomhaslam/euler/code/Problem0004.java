package tomhaslam.euler.code;

public class Problem0004 extends Problem {
	/*
	A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
	Find the largest palindrome made from the product of two 3-digit numbers.
	100-999
	999x999, 999x998, 999x997...999x100
	998x998, 998*997, 998*996...998x100
	997*997, 997*996 ... 
	*/
	public long solve(int min, int max)
	{
		int product = 0;
		int maxProduct = -1;
		
		for (int i=max; i>=min; i--)
		{
			for (int j=i; j>=min; j--) 
			{
				product = i * j;
				if (isPalindrome(product) && product > maxProduct) maxProduct = product;
			}
		}
		
		return maxProduct;
	}
}
