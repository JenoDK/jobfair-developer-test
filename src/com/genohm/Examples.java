package com.genohm;

import java.math.BigInteger;
import java.util.stream.LongStream;

import com.genohm.util.PrintUtil;

public class Examples {

	public static void main(String[] args) {
		int number = 21;

		System.out.println("Factorial normal");
		PrintUtil.executeAndPrint(() -> factorialNormal(number));

		System.out.println("Factorial with recursion");
		PrintUtil.executeAndPrint(() -> factorialRecursion(number));

		System.out.println("Factorial with a stream");
		PrintUtil.executeAndPrint(() -> factorialStream(number));

		System.out.println("Factorial with BigInteger");
		PrintUtil.executeAndPrint(() -> factorialBigInteger(BigInteger.valueOf(number)));
	}

	public static long factorialNormal(int number) {
		checkNumberIsInRange(number);
		long result = 1;
		for (int i = 2; i <= number; i++) {
			result = result * i;
		}
		return result;
	}

	public static long factorialRecursion(int number) {
		checkNumberIsInRange(number);
		if (number <= 1) {
			return 1;
		}
		return number * factorialRecursion(number - 1);
	}

	public static long factorialStream(int number) {
		checkNumberIsInRange(number);
		return LongStream.rangeClosed(2, number)
				.reduce(1, (a, b) -> a * b);
	}

	public static BigInteger factorialBigInteger(BigInteger bigInteger) {
		if (bigInteger.equals(BigInteger.ONE) || bigInteger.equals(BigInteger.ZERO)) {
			return BigInteger.ONE;
		}
		return bigInteger.multiply(factorialBigInteger(BigInteger.valueOf(bigInteger.longValue() - 1)));
	}

	private static void checkNumberIsInRange(int number) {
		if (number > 20 && number >= 0) {
			throw new IllegalArgumentException(number + " is out of range");
		}
	}
}
