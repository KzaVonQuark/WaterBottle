package waterbottle;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LaboratoryTest {

	private Laboratory lab;

	@Before
	public void setUp() throws Exception {
		lab = new Laboratory(new Bottle(3), new Bottle(5), 1);
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testFillBottles() {
		lab.runSequence(1);
		assertEquals("Small bottle should contain 3 liters", 3, lab.getSmallBottle().getVolume());
		lab.runSequence(2);
		assertEquals("Large bottle should contain 5 liters", 5, lab.getLargeBottle().getVolume());
	}
	
	@Test
	public void testFillLargeBottleWithSmall() {
		lab.runSequence(1, 3);
		assertEquals("Large bottle should contain 3 liters", 3, lab.getLargeBottle().getVolume());
		assertTrue("Small bottle should be empty", lab.getSmallBottle().isEmpty());
	}
	
	@Test
	public void testFillSmallBottleWithLarge() {
		lab.runSequence(2, 4);
		assertTrue("Small bottle should be full", lab.getSmallBottle().isFull());
		assertEquals("Large bottle should contain 2L", 2, lab.getLargeBottle().getVolume());
	}
	
	@Test
	public void testEmptyBottles() {
		lab.runSequence(1, 2, 5, 6);
		assertTrue("Small bottle should be empty", lab.getSmallBottle().isEmpty());
		assertTrue("Large bottle should be empty", lab.getLargeBottle().isEmpty());
	}
	
	@Test
	public void testWeHaveAWinner() {
		lab.setTargetVolume(5);
		lab.runSequence(2);
		assertTrue("doWeHaveAWinner should be true", lab.doWeHaveAWinner());
	}

	@Test
	public void testFindSolutionForOneLiter() {
		BottleSequence winner = lab.findTargetVolume();
		System.out.println(winner);
		assertTrue("'Do we have a winner' should be true", lab.doWeHaveAWinner());
		assertEquals("Small bottle should contain target volume", 1, winner.getFinalVolumeSmallBottle());
		assertEquals("Number of steps should be four", 4, winner.getSequence().length);
	}
	
	@Test
	public void testFindSolutionForFourLiter() {
		lab.setTargetVolume(4);
		BottleSequence winner = lab.findTargetVolume();
		System.out.println(winner);
		assertTrue("'Do we have a winner' should be true", lab.doWeHaveAWinner());
		assertEquals("Large bottle should contain target volume", 4, winner.getFinalVolumeLargeBottle());
		assertEquals("Number of steps should be six", 6, winner.getSequence().length);
	}
}
