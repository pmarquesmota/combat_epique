package test;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import pt.marquesmota.*;

public class GuerrierTest {
	
	@Test
	public void test_toString() {
		Guerrier j = new Guerrier("Joueur 1", 10, 50, 10, 0, 0);
		assertEquals(j.toString(),"Woarg je suis le Guerrier Joueur 1 niveau 10 je possède 50 de vitalité, 10 de force, 0 d'agilité et 0 d'intelligence !");
	}
	
	@Test
	public void test_attaque_speciale() {
		Guerrier j = new Guerrier("Joueur 1", 10, 50, 10, 0, 0);
		Effet e = j.attaque_speciale();
		assertEquals(e.getChaine(),"Joueur 1 utilise Coup de Rage et inflige 20 dommages.");
		assertEquals(e.getDommageSoi(), 5);
		assertEquals(e.getDommageAutre(), 20);
	}
	
	@Test
	public void test_attaque_basique() {
		Guerrier j = new Guerrier("Joueur 1", 10, 50, 10, 0, 0);
		Effet e = j.attaque_basique();
		assertEquals(e.getChaine(),"Joueur 1 utilise Coup d'Épée et inflige 10 dommages.");
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

		Guerrier j = new Guerrier("Joueur 1", 10, 50, 10, 0, 0);
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

		Guerrier j = new Guerrier("Joueur 1", 10, 50, 10, 0, 0);
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

		Guerrier j = new Guerrier("Joueur 1", 10, 50, 10, 0, 0);
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

		Guerrier j1 = new Guerrier("Joueur 1", 10, 50, 10, 0, 0);
		Guerrier j2 = new Guerrier("Joueur 2", 10, 50, 10, 0, 0);
		j1.attaque(j2);

		// Put things back
		System.out.flush();
		System.setOut(old);

		assertEquals(j1.getVie(), 50);
		assertEquals(j2.getVie(), 40);
		assertEquals(baos.toString(), "Joueur 1 (50 Vitalité) veuillez choisir votre action (1 : Attaque Basique, 2 : Attaque Spéciale)\nJoueur 1 utilise Coup d'Épée et inflige 10 dommages.\nJoueur 2 perd 10 points de vie\n");
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

		Guerrier j1 = new Guerrier("Joueur 1", 10, 50, 10, 0, 0);
		Guerrier j2 = new Guerrier("Joueur 2", 10, 50, 10, 0, 0);
		j1.attaque(j2);

		// Put things back
		System.out.flush();
		System.setOut(old);

		assertEquals(j1.getVie(), 45);
		assertEquals(j2.getVie(), 30);
		assertEquals(baos.toString(), "Joueur 1 (50 Vitalité) veuillez choisir votre action (1 : Attaque Basique, 2 : Attaque Spéciale)\nJoueur 1 utilise Coup de Rage et inflige 20 dommages.\nJoueur 2 perd 20 points de vie\nJoueur 1 perd 5 points de vie\n");
	}
	
	@Test
	public void test_setVie_getVie() {
		Guerrier j = new Guerrier("Joueur 1", 10, 50, 10, 0, 0);
		j.setVie(60);
		assertEquals(j.getVie(), 60);
	}
	
	@Test
	public void test_getVieInitiale() {
		Guerrier j = new Guerrier("Joueur 1", 10, 50, 10, 0, 0);
		assertEquals(j.getVieInitiale(), 50);
	}
	
	@Test
	public void test_getNiveau() {
		Guerrier j = new Guerrier("Joueur 1", 10, 50, 10, 0, 0);
		assertEquals(j.getNiveau(), 10);
	}
	
	@Test
	public void test_getIntelligence() {
		Guerrier j = new Guerrier("Joueur 1", 10, 50, 10, 0, 0);
		assertEquals(j.getIntelligence(), 0);
	}
	
	@Test
	public void test_setAgilite_getAgilite() {
		Guerrier j = new Guerrier("Joueur 1", 10, 50, 10, 0, 0);
		j.setAgilite(10);
		assertEquals(j.getAgilite(), 10);
	}
	
	@Test
	public void test_getForce() {
		Guerrier j = new Guerrier("Joueur 1", 10, 50, 10, 0, 0);
		assertEquals(j.getForce(), 10);
	}
	
	@Test
	public void test_getNom() {
		Guerrier j = new Guerrier("Joueur 1", 10, 50, 10, 0, 0);
		assertEquals(j.getNom(), "Joueur 1");
	}
}
