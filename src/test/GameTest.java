package test;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.Test;
import pt.marquesmota.*;

public class GameTest {

	@Test
	public void test_create_character_is_Guerrier() {
		System.setIn(new ByteArrayInputStream("1\n10\n10\n0\n0\n".getBytes()));
		
		// Create a stream to hold the output
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		// IMPORTANT: Save the old System.out!
		PrintStream old = System.out;
		// Tell Java to use our special stream
		System.setOut(ps);
		
		Scanner s = new Scanner(System.in);
		Game.setSc(s);

		Game g = new Game();
		Joueur jtest = g.create_character("Joueur 1");
		Joueur j = new Guerrier("Joueur 1", 10, 50, 10, 0, 0);

		// Put things back
		System.out.flush();
		System.setOut(old);
		
		assertEquals(jtest.toString(), j.toString());
	}

	@Test
	public void test_create_character_is_Rodeur() {
		System.setIn(new ByteArrayInputStream("2\n10\n0\n10\n0\n".getBytes()));
		
		// Create a stream to hold the output
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		// IMPORTANT: Save the old System.out!
		PrintStream old = System.out;
		// Tell Java to use our special stream
		System.setOut(ps);
		
		Scanner s = new Scanner(System.in);
		Game.setSc(s);

		Game g = new Game();
		Joueur jtest = g.create_character("Joueur 1");
		Joueur j = new Rodeur("Joueur 1", 10, 50, 0, 10, 0);

		// Put things back
		System.out.flush();
		System.setOut(old);
		
		assertEquals(jtest.toString(), j.toString());
	}

	@Test
	public void test_create_character_is_Mage() {
		System.setIn(new ByteArrayInputStream("3\n10\n0\n0\n10\n".getBytes()));
		
		// Create a stream to hold the output
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		// IMPORTANT: Save the old System.out!
		PrintStream old = System.out;
		// Tell Java to use our special stream
		System.setOut(ps);
		
		Scanner s = new Scanner(System.in);
		Game.setSc(s);

		Game g = new Game();

		Joueur jtest = g.create_character("Joueur 1");
		Joueur j = new Mage("Joueur 1", 10, 50, 0, 0, 10);

		// Put things back
		System.out.flush();
		System.setOut(old);
		
		assertEquals(jtest.toString(), j.toString());
	}
	
	@Test
	public void choose_character_as_Guerrier_with_Force_10() {
		System.setIn(new ByteArrayInputStream("1\n10\n10\n0\n0\n".getBytes()));
		
		// Create a stream to hold the output
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		// IMPORTANT: Save the old System.out!
		PrintStream old = System.out;
		// Tell Java to use our special stream
		System.setOut(ps);
		
		Scanner s = new Scanner(System.in);
		Game.setSc(s);

		Game g = new Game();
		g.create_character_object("Joueur 1");

		// Put things back
		System.out.flush();
		System.setOut(old);

		assertEquals(g.getClasse(),1);
		assertEquals(g.getNiveau(),10);
		assertEquals(g.getForce(),10);
		assertEquals(g.getAgilite(),0);
		assertEquals(g.getIntelligence(),0);
	}
	
	public String build_request_to_choose_character_as_Guerrier_with_invalid_answers() {
		String r = "";
		
		// choose class Warrior
		r = r + "1\n";
		
		// choose level
		r = r + "10\n";
		
		// choose strength
		r = r + "10\n";
		
		// choose agility
		r = r + "10\n";
		
		//  choose intelligence
		r = r + "10\n";
		
		// choose class Warrior
		r = r + "1\n";
		
		// choose level
		r = r + "10\n";
		
		// choose strength
		r = r + "10\n";
		
		// choose agility
		r = r + "0\n";
		
		//  choose intelligence
		r = r + "0\n";
		
		return r;
	}
	
	String build_answer_to_choose_character_as_Guerrier_with_invalid_answers() {
		String a ="";
		
		// Must choose class
		a = a + "Veuillez choisir la classe de votre personnage (1 : Guerrier, 2 : Rôdeur, 3 : Mage)\n";
		
		// Must choose level
		a = a + "Niveau du personnage ?\n";
		
		// Must choose strength
		a = a + "Force du personnage ?\n";
		
		// Must choose agility
		a = a + "Agilite du personnage ?\n";
		
		// Must choose intelligence
		a = a + "Intelligence du personnage ?\n";
		
		// Wrong choices
		a = a + "Attention le total force + agilité + intelligence doit être égal au niveau du joueur. Veuillez recommencer, s'il vous plait.\n";
		
		// Must choose class
		a = a + "Veuillez choisir la classe de votre personnage (1 : Guerrier, 2 : Rôdeur, 3 : Mage)\n";
		
		// Must choose level
		a = a + "Niveau du personnage ?\n";
		
		// Must choose strength
		a = a + "Force du personnage ?\n";
		
		// Must choose agility
		a = a + "Agilite du personnage ?\n";
		
		// Must choose intelligence
		a = a + "Intelligence du personnage ?\n";
		
		return a;
	}
	
	@Test
	public void choose_character_as_Guerrier_with_invalid_answers() {
		String request = build_request_to_choose_character_as_Guerrier_with_invalid_answers();
				
		System.setIn(new ByteArrayInputStream(request.getBytes()));
		// Create a stream to hold the output
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		// IMPORTANT: Save the old System.out!
		PrintStream old = System.out;
		// Tell Java to use our special stream
		System.setOut(ps);
		Game g = new Game();

		Scanner s = new Scanner(System.in);
		Game.setSc(s);

		g.create_character_object("Joueur 1");

		// Put things back
		System.out.flush();
		System.setOut(old);

		String answer = build_answer_to_choose_character_as_Guerrier_with_invalid_answers();
		assertEquals(baos.toString(), answer);
	}
}
