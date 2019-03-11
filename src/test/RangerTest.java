package test;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.Test;

import pt.marquesmota.*;

public class RangerTest {
	
	/**
	 * Test the toString method.	
	 */
	@Test
	public void test_toString() {
		Ranger j = new Ranger("Joueur 1", 10, 50, 0, 10, 0);
		assertEquals(j.toString(),"Woof je suis le Rodeur Joueur 1 niveau 10 je possède 50 de vitalité, 0 de force, 10 d'agilité et 0 d'intelligence !");
	}
	
	/**
	 * Test the special_attack method, which implements the special attack of the character.	
	 */
	@Test
	public void test_special_attack() {
		Ranger j = new Ranger("Joueur 1", 10, 50, 0, 10, 0);
		Effect e = j.special_attack();

		assertEquals(j.getAgility(), 15);
		assertEquals(e.getDisplay(),"Joueur 1 utilise Concentration et gagne 5 en agilité.");
		assertEquals(e.getSelfDamage(), 0);
		assertEquals(e.getOtherDamage(), 0);
	}
	
	/**
	 * Test the basic_attack method, which implements the basic attack of the character.	
	 */
	@Test
	public void test_basic_attack() {
		Ranger j = new Ranger("Joueur 1", 10, 50, 0, 10, 0);
		Effect e = j.basic_attack();
		assertEquals(e.getDisplay(),"Joueur 1 utilise Tir à l'Arc et inflige 10 dommages.");
		assertEquals(e.getSelfDamage(), 0);
		assertEquals(e.getOtherDamage(), 10);
	}
	
	/**
	 * Test the loseLife method when there is no life loss to the character.
	 */
	@Test
	public void test_loseLife_nothing() {
		ByteArrayOutputStream baos = MyStream.RedirectStream("");

		Ranger j = new Ranger("Joueur 1", 10, 50, 0, 10, 0);
		j.loseLife(0, j);

		MyStream.ResetStream();

		assertEquals(j.getLife(), 50);
		assertEquals(baos.toString(), "");
	}
	
	/**
	 * Test the loseLife method when there is some life loss to the character.
	 */
	@Test
	public void test_loseLife_little() {
		ByteArrayOutputStream baos = MyStream.RedirectStream("");

		Ranger j = new Ranger("Joueur 1", 10, 50, 0, 10, 0);
		j.loseLife(10, j);

		MyStream.ResetStream();

		assertEquals(j.getLife(), 40);
		assertEquals(baos.toString(), "Joueur 1 perd 10 points de vie\n");
	}
	
	/**
	 * Test the loseLife method when the character dies.
	 */
	@Test
	public void test_loseLife_all() {
		ByteArrayOutputStream baos = MyStream.RedirectStream("");

		Ranger j = new Ranger("Joueur 1", 10, 50, 0, 10, 0);
		j.loseLife(50, j);

		MyStream.ResetStream();

		assertEquals(j.getLife(), 0);
		assertEquals(baos.toString(), "Joueur 1 perd 50 points de vie\nJoueur 1 est mort\n");
	}
	
	/**
	 * Test the generic basic attack.
	 */
	@Test
	public void test_attack_basic_attack() {
		ByteArrayOutputStream baos = MyStream.RedirectStream("1\n");

		Game.s = new Scanner(System.in);

		Ranger j1 = new Ranger("Joueur 1", 10, 50, 0, 10, 0);
		Ranger j2 = new Ranger("Joueur 2", 10, 50, 0, 10, 0);
		j1.attack(j2);

		MyStream.ResetStream();

		assertEquals(j1.getLife(), 50);
		assertEquals(j2.getLife(), 40);
		assertEquals(baos.toString(), "Joueur 1 (50 Vitalité) veuillez choisir votre action (1 : Attaque Basique, 2 : Attaque Spéciale)\nJoueur 1 utilise Tir à l'Arc et inflige 10 dommages.\nJoueur 2 perd 10 points de vie\n");
	}
	
	/**
	 * Test the generic special attack.
	 */
	@Test
	public void test_attack_special_attack() {
		ByteArrayOutputStream baos = MyStream.RedirectStream("2\n");

		Game.s = new Scanner(System.in);

		Ranger j1 = new Ranger("Joueur 1", 10, 50, 0, 10, 0);
		Ranger j2 = new Ranger("Joueur 2", 10, 50, 0, 10, 0);
		j1.attack(j2);

		MyStream.ResetStream();

		assertEquals(j1.getLife(), 50);
		assertEquals(j2.getLife(), 50);
		assertEquals(baos.toString(), "Joueur 1 (50 Vitalité) veuillez choisir votre action (1 : Attaque Basique, 2 : Attaque Spéciale)\nJoueur 1 utilise Concentration et gagne 5 en agilité.\n");
	}
	
	/**
	 * Test the setter and getter for the Life variable
	 */
	@Test
	public void test_setVie_getLife() {
		Ranger j = new Ranger("Joueur 1", 10, 50, 0, 10, 0);
		j.setLife(60);
		assertEquals(j.getLife(), 60);
	}
	
	/**
	 * Test the getter for the InitialLife variable
	 */
	@Test
	public void test_getInitialLife() {
		Ranger j = new Ranger("Joueur 1", 10, 50, 0, 10, 0);
		assertEquals(j.getInitialLife(), 50);
	}
	
	/**
	 * Test the getter for the Level variable
	 */
	@Test
	public void test_getLevel() {
		Ranger j = new Ranger("Joueur 1", 10, 50,0, 10, 0);
		assertEquals(j.getLevel(), 10);
	}
	
	/**
	 * Test the getter for the Intelligence variable
	 */
	@Test
	public void test_getIntelligence() {
		Ranger j = new Ranger("Joueur 1", 10, 50, 0, 10, 0);
		assertEquals(j.getIntelligence(), 0);
	}
	
	/**
	 * Test the setter and getter for the Agility variable
	 */
	@Test
	public void test_setAgilite_getAgility() {
		Ranger j = new Ranger("Joueur 1", 10, 50, 0, 10, 0);
		j.setAgility(20);
		assertEquals(j.getAgility(), 20);
	}
	
	/**
	 * Test the getter for the Strength variable
	 */
	@Test
	public void test_getStrength() {
		Ranger j = new Ranger("Joueur 1", 10, 50, 0, 10, 0);
		assertEquals(j.getStrength(), 0);
	}
	
	/**
	 * Test the getter for the Name variable
	 */
	@Test
	public void test_getName() {
		Ranger j = new Ranger("Joueur 1", 10, 50, 0, 10, 0);
		assertEquals(j.getName(), "Joueur 1");
	}
}
