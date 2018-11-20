package com.genohm.util;

import java.time.Duration;
import java.time.Instant;
import java.util.function.Supplier;

public class PrintUtil {

	private PrintUtil() {}

	public static void executeAndPrint(Supplier<Object> factorialSupplier) {
		System.out.println("-----------------------");
		withTimeMeasurement(() -> System.out.println("Result is " + factorialSupplier.get()));
		System.out.println("-----------------------");
		System.out.println();
	}

	public static void withTimeMeasurement(Action action) {
		Instant starts = Instant.now();
		try {
			action.execute();
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
		Instant ends = Instant.now();
		Duration duration = Duration.between(starts, ends);
		System.out.println(String.format(
				"Operation took %sm %ss %sms %sns",
				duration.toMinutes(),
				duration.toSeconds(),
				duration.toMillis(),
				duration.toNanos()));
	}

	@FunctionalInterface
	public interface Action {
		void execute();
	}
}
