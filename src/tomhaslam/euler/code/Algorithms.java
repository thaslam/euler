package tomhaslam.euler.code;
import java.util.*;

public class Algorithms{
	
	/*
	Each new term in the Fibonacci sequence is generated by adding the previous two terms. By starting with 1 and 2, the first 10 terms will be:
	1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
	By considering the terms in the Fibonacci sequence whose values do not exceed four million, find the sum of the even-valued terms.
	0,1,2,3
	0+1 = 1 (0,1) (1,1)
	1+1 = 2 (1,1) (1,2)
	1+2 = 3 (1,2) (2,3)
	3+2 = 5 (2,3) (3,5)
	5+3 = 8 (3,5) (5,8)
	5+8 = 13
	8+13 = 21
	21=13 = 34
	 */
	public int findFibonaccSum(int max)
	{
		int lastSum = 0;
		int runningSum = 1;
		ArrayList<Integer> evens = new ArrayList<Integer>();
			
		while(runningSum <= max)
		{
			if (runningSum % 2 == 0) evens.add(runningSum);
				
			runningSum = lastSum + runningSum;
			lastSum = runningSum - lastSum;
		}
			
		int sum = 0;
		for (int i : evens) sum += i;
			
		return sum;
	}
	
	/*
	If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
	Find the sum of all the multiples of 3 or 5 below 1000.
	*/
	public int findMultiplesOf3And5Sum(int max)
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

	/*
	The prime factors of 13195 are 5, 7, 13 and 29.
	What is the largest prime factor of the number 600851475143 ?
	loop from 1 to num
	if not mod 2 and not mod num then add to list
	*/
	public long findLargestPrimeFactor(long num)
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
	
	/*
	A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
	Find the largest palindrome made from the product of two 3-digit numbers.
	100-999
	999x999, 999x998, 999x997...999x100
	998x998, 998*997, 998*996...998x100
	997*997, 997*996 ... 
	*/
	public int findLargestPalindromeBetweenDigits(int min, int max)
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
	
	/*
	2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
	What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
	evens only
	take first even factor
	*/
	public int findSmallestMultipleBetween(int min, int max)
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
	/*
	The sum of the squares of the first ten natural numbers is,

	12 + 22 + ... + 102 = 385
	The square of the sum of the first ten natural numbers is,
	
	(1 + 2 + ... + 10)2 = 552 = 3025
	Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is 3025 − 385 = 2640.
	
	Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
	 */
	public long findSumofSquaresVsSquareOfSums(int max)
	{

		long sumOfSquares = 0;
		long squareOfSum = 0;
		
		for (int i=1; i<=max; i++)
		{
			sumOfSquares += Math.pow(i, 2);
			squareOfSum += i;
		}
		squareOfSum = (long)Math.pow(squareOfSum, 2);
		return squareOfSum - sumOfSquares;
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
