package test;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.Test;

import pt.marquesmota.*;

public class WizardTest {
	
	@Test
	public void test_toString() {
		Wizard j = new Wizard("Joueur 1", 10, 50, 0, 0, 10);
		assertEquals(j.toString(),"Abracadabra je suis le Mage Joueur 1 niveau 10 je possède 50 de vitalité, 0 de force, 0 d'agilité et 10 d'intelligence !");
	}
	
	@Test
	public void test_special_attack() {
		Wizard j = new Wizard("Joueur 1", 10, 50, 0, 0, 10);
		Effect e = j.special_attack();
		assertEquals(e.getDisplay(),"Joueur 1 utilise Soin et gagne 20 en vitalité");
		assertEquals(e.getSelfDamage(), 0);
		assertEquals(e.getOtherDamage(), 0);
	}
	
	@Test
	public void test_basic_attack() {
		Wizard j = new Wizard("Joueur 1", 10, 50, 0, 0, 10);
		Effect e = j.basic_attack();
		assertEquals(e.getDisplay(),"Joueur 1 utilise Boule de Feu et inflige 10 dommages.");
		assertEquals(e.getSelfDamage(), 0);
		assertEquals(e.getOtherDamage(), 10);
	}
	
	@Test
	public void test_loseLife_nothing() {
		// Create a stream to hold the output
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		// IMPORTANT: Save the old System.out!
		PrintStream old = System.out;
		// Tell Java to use our special stream
		System.setOut(ps);

		Wizard j = new Wizard("Joueur 1", 10, 50, 0, 0, 10);
		j.loseLife(0, j);

		// Put things back
		System.out.flush();
		System.setOut(old);

		assertEquals(j.getLife(), 50);
		assertEquals(baos.toString(), "");
	}
	
	@Test
	public void test_loseLife_little() {
		// Create a stream to hold the output
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		// IMPORTANT: Save the old System.out!
		PrintStream old = System.out;
		// Tell Java to use our special stream
		System.setOut(ps);

		Wizard j = new Wizard("Joueur 1", 10, 50, 0, 0, 10);
		j.loseLife(10, j);

		// Put things back
		System.out.flush();
		System.setOut(old);

		assertEquals(j.getLife(), 40);
		assertEquals(baos.toString(), "Joueur 1 perd 10 points de vie\n");
	}
	
	@Test
	public void test_loseLife_all() {
		// Create a stream to hold the output
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		// IMPORTANT: Save the old System.out!
		PrintStream old = System.out;
		// Tell Java to use our special stream
		System.setOut(ps);

		Wizard j = new Wizard("Joueur 1", 10, 50, 0, 0, 10);
		j.loseLife(50, j);

		// Put things back
		System.out.flush();
		System.setOut(old);

		assertEquals(j.getLife(), 0);
		assertEquals(baos.toString(), "Joueur 1 perd 50 points de vie\nJoueur 1 est mort\n");
	}
	
	@Test
	public void test_attack_basic_attack() {
		// Create a stream to hold the output
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		// IMPORTANT: Save the old System.out!
		PrintStream old = System.out;
		// Tell Java to use our special stream
		System.setOut(ps);

		System.setIn(new ByteArrayInputStream("1\n".getBytes()));
		Scanner s = new Scanner(System.in);
		Game.setSc(s);

		Wizard j1 = new Wizard("Joueur 1", 10, 50, 0, 0, 10);
		Wizard j2 = new Wizard("Joueur 2", 10, 50, 0, 0, 10);
		j1.attack(j2);

		// Put things back
		System.out.flush();
		System.setOut(old);

		assertEquals(j1.getLife(), 50);
		assertEquals(j2.getLife(), 40);
		assertEquals(baos.toString(), "Joueur 1 (50 Vitalité) veuillez choisir votre action (1 : Attaque Basique, 2 : Attaque Spéciale)\nJoueur 1 utilise Boule de Feu et inflige 10 dommages.\nJoueur 2 perd 10 points de vie\n");
	}
	
	@Test
	public void test_attack_special_attack() {
		// Create a stream to hold the output
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		// IMPORTANT: Save the old System.out!
		PrintStream old = System.out;
		// Tell Java to use our special stream
		System.setOut(ps);

		System.setIn(new ByteArrayInputStream("2\n".getBytes()));
		Scanner s = new Scanner(System.in);
		Game.setSc(s);

		Wizard j1 = new Wizard("Joueur 1", 10, 50, 0, 0, 10);
		Wizard j2 = new Wizard("Joueur 2", 10, 50, 0, 0, 10);
		j1.attack(j2);

		// Put things back
		System.out.flush();
		System.setOut(old);

		assertEquals(j1.getLife(), 50);
		assertEquals(j2.getLife(), 50);
		assertEquals(baos.toString(), "Joueur 1 (50 Vitalité) veuillez choisir votre action (1 : Attaque Basique, 2 : Attaque Spéciale)\nJoueur 1 utilise Soin et gagne 20 en vitalité\n");
	}
	
	@Test
	public void test_setVie_getVie() {
		Wizard j = new Wizard("Joueur 1", 10, 50, 0, 0, 10);
		j.setLife(60);
		assertEquals(j.getLife(), 60);
	}
	
	@Test
	public void test_getVieInitiale() {
		Wizard j = new Wizard("Joueur 1", 10, 50, 0, 0, 10);
		assertEquals(j.getInitialLife(), 50);
	}
	
	@Test
	public void test_getNiveau() {
		Wizard j = new Wizard("Joueur 1", 10, 50, 0, 0, 10);
		assertEquals(j.getLevel(), 10);
	}
	
	@Test
	public void test_getIntelligence() {
		Wizard j = new Wizard("Joueur 1", 10, 50, 0, 0, 10);
		assertEquals(j.getIntelligence(), 10);
	}
	
	@Test
	public void test_setAgilite_getAgilite() {
		Wizard j = new Wizard("Joueur 1", 10, 50, 0, 0, 10);
		j.setAgility(20);
		assertEquals(j.getAgility(), 20);
	}
	
	@Test
	public void test_getForce() {
		Wizard j = new Wizard("Joueur 1", 10, 50, 0, 0, 10);
		assertEquals(j.getStrength(), 0);
	}
	
	@Test
	public void test_getNom() {
		Wizard j = new Wizard("Joueur 1", 10, 50, 0, 0, 10);
		assertEquals(j.getName(), "Joueur 1");
	}
}
