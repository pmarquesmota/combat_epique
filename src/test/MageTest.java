package test;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.Test;

import pt.marquesmota.Effet;
import pt.marquesmota.Game;
import pt.marquesmota.Mage;

public class MageTest {
	
	@Test
	public void test_toString() {
		Mage j = new Mage("Joueur 1", 10, 50, 0, 0, 10);
		assertEquals(j.toString(),"Abracadabra je suis le Mage Joueur 1 niveau 10 je possède 50 de vitalité, 0 de force, 0 d'agilité et 10 d'intelligence !");
	}
	
	@Test
	public void test_attaque_speciale() {
		Mage j = new Mage("Joueur 1", 10, 50, 0, 0, 10);
		Effet e = j.attaque_speciale();
		assertEquals(e.getChaine(),"Joueur 1 utilise Soin et gagne 20 en vitalité");
		assertEquals(e.getDommageSoi(), 0);
		assertEquals(e.getDommageAutre(), 0);
	}
	
	@Test
	public void test_attaque_basique() {
		Mage j = new Mage("Joueur 1", 10, 50, 0, 0, 10);
		Effet e = j.attaque_basique();
		assertEquals(e.getChaine(),"Joueur 1 utilise Boule de Feu et inflige 10 dommages.");
		assertEquals(e.getDommageSoi(), 0);
		assertEquals(e.getDommageAutre(), 10);
	}
	
	@Test
	public void test_perdVie_rien() {
		// Create a stream to hold the output
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		// IMPORTANT: Save the old System.out!
		PrintStream old = System.out;
		// Tell Java to use our special stream
		System.setOut(ps);

		Mage j = new Mage("Joueur 1", 10, 50, 0, 0, 10);
		j.perdVie(0, j);

		// Put things back
		System.out.flush();
		System.setOut(old);

		assertEquals(j.getVie(), 50);
		assertEquals(baos.toString(), "");
	}
	
	@Test
	public void test_perdVie_un_peu() {
		// Create a stream to hold the output
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		// IMPORTANT: Save the old System.out!
		PrintStream old = System.out;
		// Tell Java to use our special stream
		System.setOut(ps);

		Mage j = new Mage("Joueur 1", 10, 50, 0, 0, 10);
		j.perdVie(10, j);

		// Put things back
		System.out.flush();
		System.setOut(old);

		assertEquals(j.getVie(), 40);
		assertEquals(baos.toString(), "Joueur 1 perd 10 points de vie\n");
	}
	
	@Test
	public void test_perdVie_tout() {
		// Create a stream to hold the output
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		// IMPORTANT: Save the old System.out!
		PrintStream old = System.out;
		// Tell Java to use our special stream
		System.setOut(ps);

		Mage j = new Mage("Joueur 1", 10, 50, 0, 0, 10);
		j.perdVie(50, j);

		// Put things back
		System.out.flush();
		System.setOut(old);

		assertEquals(j.getVie(), 0);
		assertEquals(baos.toString(), "Joueur 1 perd 50 points de vie\nJoueur 1 est mort\n");
	}
	
	@Test
	public void test_attaque_attaque_basique() {
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

		Mage j1 = new Mage("Joueur 1", 10, 50, 0, 0, 10);
		Mage j2 = new Mage("Joueur 2", 10, 50, 0, 0, 10);
		j1.attaque(j2);

		// Put things back
		System.out.flush();
		System.setOut(old);

		assertEquals(j1.getVie(), 50);
		assertEquals(j2.getVie(), 40);
		assertEquals(baos.toString(), "Joueur 1 (50 Vitalité) veuillez choisir votre action (1 : Attaque Basique, 2 : Attaque Spéciale)\nJoueur 1 utilise Boule de Feu et inflige 10 dommages.\nJoueur 2 perd 10 points de vie\n");
	}
	
	@Test
	public void test_attaque_attaque_speciale() {
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

		Mage j1 = new Mage("Joueur 1", 10, 50, 0, 0, 10);
		Mage j2 = new Mage("Joueur 2", 10, 50, 0, 0, 10);
		j1.attaque(j2);

		// Put things back
		System.out.flush();
		System.setOut(old);

		assertEquals(j1.getVie(), 50);
		assertEquals(j2.getVie(), 50);
		assertEquals(baos.toString(), "Joueur 1 (50 Vitalité) veuillez choisir votre action (1 : Attaque Basique, 2 : Attaque Spéciale)\nJoueur 1 utilise Soin et gagne 20 en vitalité\n");
	}
	
	@Test
	public void test_setVie_getVie() {
		Mage j = new Mage("Joueur 1", 10, 50, 0, 0, 10);
		j.setVie(60);
		assertEquals(j.getVie(), 60);
	}
	
	@Test
	public void test_getVieInitiale() {
		Mage j = new Mage("Joueur 1", 10, 50, 0, 0, 10);
		assertEquals(j.getVieInitiale(), 50);
	}
	
	@Test
	public void test_getNiveau() {
		Mage j = new Mage("Joueur 1", 10, 50, 0, 0, 10);
		assertEquals(j.getNiveau(), 10);
	}
	
	@Test
	public void test_getIntelligence() {
		Mage j = new Mage("Joueur 1", 10, 50, 0, 0, 10);
		assertEquals(j.getIntelligence(), 10);
	}
	
	@Test
	public void test_setAgilite_getAgilite() {
		Mage j = new Mage("Joueur 1", 10, 50, 0, 0, 10);
		j.setAgilite(20);
		assertEquals(j.getAgilite(), 20);
	}
	
	@Test
	public void test_getForce() {
		Mage j = new Mage("Joueur 1", 10, 50, 0, 0, 10);
		assertEquals(j.getForce(), 0);
	}
	
	@Test
	public void test_getNom() {
		Mage j = new Mage("Joueur 1", 10, 50, 0, 0, 10);
		assertEquals(j.getNom(), "Joueur 1");
	}
}
