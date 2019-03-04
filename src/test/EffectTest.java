package test;

import static org.junit.Assert.*;
import org.junit.Test;
import pt.marquesmota.*;

public class EffectTest {
	/**
	 * Checks whether the getters work.
	 */
	@Test
	public void test_Effect() {
		Effect e = new Effect("Test", 10, 20);
		assertEquals(e.getDisplay(), "Test");
		assertEquals(e.getSelfDamage(), 10);
		assertEquals(e.getOtherDamage(), 20);
	}

}
