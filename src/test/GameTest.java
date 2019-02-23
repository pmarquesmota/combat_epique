package test;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.hamcrest.BaseMatcher;

import org.junit.Test;
import pt.marquesmota.*;

public class GameTest {

	@Test
	public void test_create_character_is_Guerrier() {
		Game g = new Game();
		g.setClasse(1); // Guerrier
		g.setNiveau(10);
		g.setForce(10);
		g.setAgilite(0);
		g.setIntelligence(0);
		Joueur jtest = g.create_character("Joueur 1");
		Joueur j = new Guerrier("Joueur 1", 10, 50, 10, 0, 0);
		fail("Not yet implemented");
	}

	@Test
	public void test_create_character_is_Rodeur() {
		Game g = new Game();
		g.setClasse(2); // Rodeur
		g.setNiveau(10);
		g.setForce(0);
		g.setAgilite(10);
		g.setIntelligence(0);
		Joueur jtest = g.create_character("Joueur 1");
		Joueur j = new Rodeur("Joueur 1", 10, 50, 0, 10, 0);
		fail("Not yet implemented");
	}

	@Test
	public void test_create_character_is_Mage() {
		Game g = new Game();
		g.setClasse(3); // Mage
		g.setNiveau(10);
		g.setForce(0);
		g.setAgilite(0);
		g.setIntelligence(10);
		Joueur jtest = g.create_character("Joueur 1");
		Joueur j = new Mage("Joueur 1", 10, 50, 0, 0, 10);
		fail("Not yet implemented");
	}
	
	@Test
	public void choose_character_as_Guerrier_with_Force_10() {
		System.setIn(new ByteArrayInputStream("1\n10\n10\n0\n0\n".getBytes()));
		Game g = new Game();
		g.choose_character();
		assertEquals(g.getClasse(),1);
		assertEquals(g.getNiveau(),10);
		assertEquals(g.getForce(),10);
		assertEquals(g.getAgilite(),0);
		assertEquals(g.getIntelligence(),0);
	}
	
	@Test
	public void choose_character_as_Guerrier_with_invalid_answers() {
		System.setIn(new ByteArrayInputStream("1\n10\n10\n10\n10\n1\n10\n10\n0\n0\n".getBytes()));
		// Create a stream to hold the output
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		// IMPORTANT: Save the old System.out!
		PrintStream old = System.out;
		// Tell Java to use our special stream
		System.setOut(ps);
		Game g = new Game();

		g.choose_character();

		// Put things back
		System.out.flush();
		System.setOut(old);

		assertThat(baos.toString(),
				anyOf("Attention le total force + agilité + intelligence doit être égal au niveau du joueur. Veuillez recommencer, s'il vous plait.\n")
			);
	}
}
