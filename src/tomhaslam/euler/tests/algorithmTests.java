package tomhaslam.euler.tests;
import java.util.List;
import java.util.Arrays;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;
import tomhaslam.euler.code.*;

public class algorithmTests 
{	
	@Test
	public void problem0067()
	{
		Problem problem = new Problem0067();
		long result = problem.solve();
		
		System.out.printf("Problem 0067 answer is %d \n", result);
	}
	@Test
	public void problem0018()
	{
		Problem problem = new Problem0018();
		long result = problem.solve();
		
		System.out.printf("Problem 0018 answer is %d \n", result);
	}
	@Ignore @Test
	public void problem0016()
	{
		Problem problem = new Problem0016();
		long result = problem.solve(1000);
		
		System.out.printf("Problem 0016 answer is %d \n", result);
	}
	@Test
	public void problem0016Proof()
	{
		Problem problem = new Problem0016();
		long result = problem.solve(15);
		
		assertTrue("Sum of individual numbers is 26.", result == 26);
		System.out.printf("Problem 0016 proof is %d \n", result);
	}
	@Test
	public void problem0015()
	{
		Problem problem = new Problem0015();
		long result = problem.solve(3);
		
		assertTrue("Total count should be 20.", result == 20);
		System.out.printf("Problem 0015 answer is %d \n", result);
	}
	@Test
	public void problem0011()
	{
		Problem problem = new Problem0011();
		long result = problem.solve(4);
		
		System.out.printf("Problem 0011 answer is %d \n", result);
	}
	@Test
	public void problem0009()
	{
		Problem problem = new Problem0009();
		long result = problem.solve(1000);
		
		System.out.printf("Problem 0009 answer is %d \n", result);
	}
	@Test
	public void problem0008Proof()
	{
		Problem problem = new Problem0008();
		long result = problem.solve(4);
		
		assertTrue("Result is 5832", result == 5832);
		System.out.printf("Problem 0008 proof is %d \n", result);
	}
	@Test
	public void problem0008()
	{
		Problem problem = new Problem0008();
		long result = problem.solve(13);
		
		assertTrue("Result is not 0", result != 0);
		System.out.printf("Problem 0008 answer is %d \n", result);
	}
	@Test
	public void problem0007Proof()
	{
		Problem problem = new Problem0007();
		long result = problem.solve(6);
		
		assertTrue("Result is 13", result == 13);
		System.out.printf("Problem 0007 proof is %d \n", result);
	}
	
	@Test
	public void problem0007()
	{
		Problem problem = new Problem0007();
		long result = problem.solve(10001);
		
		assertTrue("Result is 10001", result != 0);
		System.out.printf("Problem 0007 answer is %d \n", result);
	}
	
	@Test
	public void problem0006Proof()
	{
		Problem problem = new Problem0006();
		long result = problem.solve(10);
		
		assertTrue("Result is 2640", result == 2640);
		System.out.printf("Problem 0006 proof is %d \n", result);
	}
	@Test
	public void problem0006()
	{
		Problem problem = new Problem0006();
		long result = problem.solve(100);
		
		System.out.printf("Problem 0006 answer is %d \n", result);
	}
	@Test
	public void problem0005Proof() 
	{
		Problem problem = new Problem0005();
		long result = problem.solve(1, 10);
		
		assertTrue("Result is not -1", result > -1);
		System.out.printf("Problem 0005 proof is %d \n", result);
	}
	
	@Test
	public void problem0005() 
	{
		Problem problem = new Problem0005();
		long result = problem.solve(1, 20);
		
		assertTrue("Result is not -1", result > -1);
		System.out.printf("Problem 0006 answer is %d \n", result);
	}
	
	@Test
	public void problem0004() 
	{
		Problem problem = new Problem0004();
		long result = problem.solve(100,999);
		
		assertTrue("Result is not -1", result > -1);
		System.out.printf("Problem 0004 answer is %d \n", result);
	}
	
	@Test
	public void problem0004Proof() 
	{
		Problem problem = new Problem0004();
		long result = problem.solve(10,99);
		
		assertTrue("Result is not -1", result > -1);
		System.out.printf("Problem 0004 proof is %d \n", result);
	}
	
	@Test
	public void baseProblemIsNotPalindrome() 
	{
		Problem problem = new Problem0001();
		boolean result = problem.isPalindrome(9833);
		
		assertFalse("Number 9833 is not a palindrome.", result);
		
		result = problem.isPalindrome(11111113);
		
		assertFalse("Number 11111113 is not a palindrome.", result);
	}
	
	@Test
	public void baseProblemIsPalindrome() 
	{
		Problem problem = new Problem0001();
		boolean result = problem.isPalindrome(9889);
		
		assertTrue("Number 9889 is a palindrome.", result);
		
		result = problem.isPalindrome(1111111);
		
		assertTrue("Number 1111111 is a palindrome.", result);
	}

}

