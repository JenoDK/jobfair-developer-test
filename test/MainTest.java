import org.junit.Assert;
import org.junit.Test;


public class MainTest {

	@Test
	public void testForZero() {
		long result = Main.factorial(0);
		Assert.assertEquals(1, result);
	}

	@Test
	public void testForOne() {
		long result = Main.factorial(1);
		Assert.assertEquals(1, result);
	}

	@Test
	public void testForFive() {
		long result = Main.factorial(5);
		Assert.assertEquals(120, result);
	}

	@Test(expected = Exception.class)
	public void testForTwentyOne() {
		Main.factorial(21);
	}
}
