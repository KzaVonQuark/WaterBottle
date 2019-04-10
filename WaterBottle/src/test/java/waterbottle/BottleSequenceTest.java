package waterbottle;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BottleSequenceTest {

	private BottleSequence bottleSequence;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
		bottleSequence = null;
	}

	@Test
	public void testAllOperationsShouldPrinted() {
		bottleSequence = new BottleSequence(1);
		String stringToTest = "Fill the small bottle";
		assertTrue("Should contain info about the filling the small bottle",
				bottleSequence.toString().contains(stringToTest));

		bottleSequence = new BottleSequence(2);
		stringToTest = "Fill the large bottle";
		assertTrue("Should contain info about the filling the large bottle",
				bottleSequence.toString().contains(stringToTest));

		
		bottleSequence = new BottleSequence(3);
		stringToTest = "Pour the small bottle into the large bottle";
		assertTrue("Should contain info about pouring the large bottle into the large",
				bottleSequence.toString().contains(stringToTest));

		bottleSequence = new BottleSequence(4);
		stringToTest = "Pour the large bottle into the small bottle";
		assertTrue("Should contain info about pouring the large bottle into the small",
				bottleSequence.toString().contains(stringToTest));

		bottleSequence = new BottleSequence(5);
		stringToTest = "Empty the small bottle";
		assertTrue("Should contain info about the emptying the small bottle",
				bottleSequence.toString().contains(stringToTest));

		bottleSequence = new BottleSequence(6);
		stringToTest = "Empty the large bottle";
		assertTrue("Should contain info about the emptying the large bottle",
				bottleSequence.toString().contains(stringToTest));
	}

}
