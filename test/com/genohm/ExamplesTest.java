package com.genohm;

import org.junit.Assert;
import org.junit.Test;

import com.genohm.Examples;


public class ExamplesTest {

	@Test
	public void testForZero() {
		long result = Examples.factorialRecursion(0);
		Assert.assertEquals(1, result);
	}

	@Test
	public void testForOne() {
		long result = Examples.factorialRecursion(1);
		Assert.assertEquals(1, result);
	}

	@Test
	public void testForFive() {
		long result = Examples.factorialRecursion(5);
		Assert.assertEquals(120, result);
	}

	@Test(expected = Exception.class)
	public void testForTwentyOne() {
		Examples.factorialRecursion(21);
	}
}
