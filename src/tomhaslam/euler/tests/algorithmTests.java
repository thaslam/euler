package tomhaslam.euler.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import tomhaslam.euler.code.*;

public class algorithmTests {
	
	@Test
	public void whatIsDifferenceBetweenSumOfSquaresAndSquareOfSum()
	{
		Algorithms algs = new Algorithms();
		long result = algs.findSumofSquaresVsSquareOfSums(10);
		
		assertTrue("Result is 2640", result == 2640);
		System.out.printf("Difference between SumOfSquares and SquareOfSums for first 10 numbers is %d \n", result);
	}
	@Test
	public void whatIsDifferenceBetweenSumOfSquaresAndSquareOfSumFirst100()
	{
		Algorithms algs = new Algorithms();
		long result = algs.findSumofSquaresVsSquareOfSums(100);
		
		//assertTrue("Result is 2640", result == 2640);
		System.out.printf("Difference between SumOfSquares and SquareOfSums for first 100 numbers is %d \n", result);
	}
	@Test
	public void whatIsSmallestMultipleOf1to10() 
	{
		Algorithms algs = new Algorithms();
		int result = algs.findSmallestMultipleBetween(1, 10);
		
		assertTrue("Result is not -1", result > -1);
		System.out.printf("Smallest multiple between 1 and 10 is %d \n", result);
	}
	@Test
	public void whatIsSmallestMultipleOf1to20() 
	{
		Algorithms algs = new Algorithms();
		int result = algs.findSmallestMultipleBetween(1, 20);
		
		assertTrue("Result is not -1", result > -1);
		System.out.printf("Smallest multiple between 1 and 20 is %d \n", result);
	}
	@Test
	public void whatIsThreeDigitPalindrome() 
	{
		Algorithms algs = new Algorithms();
		int result = algs.findLargestPalindromeBetweenDigits(100,999);
		
		assertTrue("Result is not -1", result > -1);
		System.out.printf("Largest palindrome product of three digits is %d \n", result);
	}
	
	@Test
	public void whatIsTwoDigitPalindrome() 
	{
		Algorithms algs = new Algorithms();
		int result = algs.findLargestPalindromeBetweenDigits(10,99);
		
		assertTrue("Result is not -1", result > -1);
		System.out.printf("Largest palindrome product of two digits is %d \n", result);
	}
	
	@Test
	public void isNotPalindrome() 
	{
		Algorithms algs = new Algorithms();
		boolean result = algs.isPalindrome(9833);
		
		assertFalse("Number 9833 is not a palindrome.", result);
		
		result = algs.isPalindrome(11111113);
		
		assertFalse("Number 11111113 is not a palindrome.", result);
	}
	
	@Test
	public void isPalindrome() 
	{
		Algorithms algs = new Algorithms();
		boolean result = algs.isPalindrome(9889);
		
		assertTrue("Number 9889 is a palindrome.", result);
		
		result = algs.isPalindrome(1111111);
		
		assertTrue("Number 1111111 is a palindrome.", result);
	}

}
