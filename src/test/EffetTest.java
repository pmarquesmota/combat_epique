package test;

import static org.junit.Assert.*;
import org.junit.Test;
import pt.marquesmota.*;

public class EffetTest {
	/**
	 * Checks whether the getters work.
	 */
	@Test
	public void test_Effet() {
		Effet e = new Effet("Test", 10, 20);
		assertEquals(e.getChaine(), "Test");
		assertEquals(e.getDommageSoi(), 10);
		assertEquals(e.getDommageAutre(), 20);
	}

}
