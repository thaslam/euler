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
	
	/*
	By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
	What is the 10 001st prime number?
	 */
	public long findNthPrimeNumber(int nth)
	{
		int primeCount = 0;
		long number = 0;
		while(primeCount <= nth)
		{
			number++;
			if (this.isPrime(number)) primeCount++;
		}
		
		return number;
	}
	
	/*
	The four adjacent digits in the 1000-digit number that have the greatest product are 9 × 9 × 8 × 9 = 5832.

	73167176531330624919225119674426574742355349194934
	96983520312774506326239578318016984801869478851843
	85861560789112949495459501737958331952853208805511
	12540698747158523863050715693290963295227443043557
	66896648950445244523161731856403098711121722383113
	62229893423380308135336276614282806444486645238749
	30358907296290491560440772390713810515859307960866
	70172427121883998797908792274921901699720888093776
	65727333001053367881220235421809751254540594752243
	52584907711670556013604839586446706324415722155397
	53697817977846174064955149290862569321978468622482
	83972241375657056057490261407972968652414535100474
	82166370484403199890008895243450658541227588666881
	16427171479924442928230863465674813919123162824586
	17866458359124566529476545682848912883142607690042
	24219022671055626321111109370544217506941658960408
	07198403850962455444362981230987879927244284909188
	84580156166097919133875499200524063689912560717606
	05886116467109405077541002256983155200055935729725
	71636269561882670428252483600823257530420752963450

	Find the thirteen adjacent digits in the 1000-digit number that have the greatest product. What is the value of this product?
	*/
	public long findGreatestAdjacentProductOfNSize(int size) 
	{
		String numberText = 
			"73167176531330624919225119674426574742355349194934" +
			"96983520312774506326239578318016984801869478851843" +
			"85861560789112949495459501737958331952853208805511" +
			"12540698747158523863050715693290963295227443043557" +
			"66896648950445244523161731856403098711121722383113" +
			"62229893423380308135336276614282806444486645238749" +
			"30358907296290491560440772390713810515859307960866" +
			"70172427121883998797908792274921901699720888093776" +
			"65727333001053367881220235421809751254540594752243" +
			"52584907711670556013604839586446706324415722155397" +
			"53697817977846174064955149290862569321978468622482" +
			"83972241375657056057490261407972968652414535100474" +
			"82166370484403199890008895243450658541227588666881" +
			"16427171479924442928230863465674813919123162824586" +
			"17866458359124566529476545682848912883142607690042" +
			"24219022671055626321111109370544217506941658960408" +
			"07198403850962455444362981230987879927244284909188" +
			"84580156166097919133875499200524063689912560717606" +
			"05886116467109405077541002256983155200055935729725" +
			"71636269561882670428252483600823257530420752963450";
		
		
		long maxProduct = 0;
		for (int i=0; i<numberText.length() - size; i++) 
		{
			char[] numbers = numberText.substring(i, i + size).toCharArray();
			long product = 1;
			for(char c : numbers) 
			{
				product *= Character.getNumericValue(c);
			}
			
			if (product > maxProduct) maxProduct = product;
		}
		
		return maxProduct;
	}
	
	
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
	public long finePathagoreanTripletProduct(int sum)
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
