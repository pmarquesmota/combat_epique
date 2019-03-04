package test;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.Test;

import pt.marquesmota.*;

public class RangerTest {
	
	@Test
	public void test_toString() {
		Ranger j = new Ranger("Joueur 1", 10, 50, 0, 10, 0);
		assertEquals(j.toString(),"Woof je suis le Rodeur Joueur 1 niveau 10 je possède 50 de vitalité, 0 de force, 10 d'agilité et 0 d'intelligence !");
	}
	
	@Test
	public void test_special_attack() {
		Ranger j = new Ranger("Joueur 1", 10, 50, 0, 10, 0);
		Effect e = j.special_attack();

		assertEquals(j.getAgility(), 15);
		assertEquals(e.getDisplay(),"Joueur 1 utilise Concentration et gagne 5 en agilité.");
		assertEquals(e.getSelfDamage(), 0);
		assertEquals(e.getOtherDamage(), 0);
	}
	
	@Test
	public void test_basic_attack() {
		Ranger j = new Ranger("Joueur 1", 10, 50, 0, 10, 0);
		Effect e = j.basic_attack();
		assertEquals(e.getDisplay(),"Joueur 1 utilise Tir à l'Arc et inflige 10 dommages.");
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

		Ranger j = new Ranger("Joueur 1", 10, 50, 0, 10, 0);
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

		Ranger j = new Ranger("Joueur 1", 10, 50, 0, 10, 0);
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

		Ranger j = new Ranger("Joueur 1", 10, 50, 0, 10, 0);
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

		Ranger j1 = new Ranger("Joueur 1", 10, 50, 0, 10, 0);
		Ranger j2 = new Ranger("Joueur 2", 10, 50, 0, 10, 0);
		j1.attack(j2);

		// Put things back
		System.out.flush();
		System.setOut(old);

		assertEquals(j1.getLife(), 50);
		assertEquals(j2.getLife(), 40);
		assertEquals(baos.toString(), "Joueur 1 (50 Vitalité) veuillez choisir votre action (1 : Attaque Basique, 2 : Attaque Spéciale)\nJoueur 1 utilise Tir à l'Arc et inflige 10 dommages.\nJoueur 2 perd 10 points de vie\n");
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

		Ranger j1 = new Ranger("Joueur 1", 10, 50, 0, 10, 0);
		Ranger j2 = new Ranger("Joueur 2", 10, 50, 0, 10, 0);
		j1.attack(j2);

		// Put things back
		System.out.flush();
		System.setOut(old);

		assertEquals(j1.getLife(), 50);
		assertEquals(j2.getLife(), 50);
		assertEquals(baos.toString(), "Joueur 1 (50 Vitalité) veuillez choisir votre action (1 : Attaque Basique, 2 : Attaque Spéciale)\nJoueur 1 utilise Concentration et gagne 5 en agilité.\n");
	}
	
	@Test
	public void test_setVie_getVie() {
		Ranger j = new Ranger("Joueur 1", 10, 50, 0, 10, 0);
		j.setLife(60);
		assertEquals(j.getLife(), 60);
	}
	
	@Test
	public void test_getVieInitiale() {
		Ranger j = new Ranger("Joueur 1", 10, 50, 0, 10, 0);
		assertEquals(j.getInitialLife(), 50);
	}
	
	@Test
	public void test_getNiveau() {
		Ranger j = new Ranger("Joueur 1", 10, 50,0, 10, 0);
		assertEquals(j.getLevel(), 10);
	}
	
	@Test
	public void test_getIntelligence() {
		Ranger j = new Ranger("Joueur 1", 10, 50, 0, 10, 0);
		assertEquals(j.getIntelligence(), 0);
	}
	
	@Test
	public void test_setAgilite_getAgilite() {
		Ranger j = new Ranger("Joueur 1", 10, 50, 0, 10, 0);
		j.setAgility(20);
		assertEquals(j.getAgility(), 20);
	}
	
	@Test
	public void test_getForce() {
		Ranger j = new Ranger("Joueur 1", 10, 50, 0, 10, 0);
		assertEquals(j.getStrength(), 0);
	}
	
	@Test
	public void test_getNom() {
		Ranger j = new Ranger("Joueur 1", 10, 50, 0, 10, 0);
		assertEquals(j.getName(), "Joueur 1");
	}
}
