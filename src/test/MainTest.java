package test;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import pt.marquesmota.*;

/** 
 * Test the Main class
 * @author Paul Marques Mota (pmarquesmota@gmail.com)
 *
 */
public class MainTest {
	/**
	 * Build the answer String
	 * @return a String with all the answers
	 */
	public String build_answer_to_test_Main() {
		String r = "";
		
		//Choose Warrior
		r = r + "1\n";

		//Choose level
		r = r + "10\n";

		//Choose strength
		r = r + "10\n";

		//Choose agility
		r = r + "0\n";

		//Choose int
		r = r + "0\n";

		//Choose Wizard
		r = r + "3\n";

		//Choose level
		r = r + "10\n";

		//Choose strength
		r = r + "0\n";

		//Choose agility
		r = r + "0\n";

		//Choose int
		r = r + "10\n";

		//Player 1 basic attack
		r = r + "1\n";

		//Player 2 basic attack
		r = r + "1\n";

		//Player 1 special attack
		r = r + "2\n";

		//Player 2 special attack
		r = r + "2\n";

		//Player 1 special attack
		r = r + "2\n";

		//Player 2 basic attack
		r = r + "1\n";

		//Player 1 special attack
		r = r + "2\n";

		return r;
	}
	
	/**
	 * Build the request String
	 * @return a String with all the Strings which are to be printed by the program
	 */
	public String build_request_to_test_Main() {
		String a = "";
		
		a = a + "Création du personnage du Joueur 1\n";
		a = a + "Veuillez choisir la classe de votre personnage (1 : Guerrier, 2 : Rôdeur, 3 : Mage)\n";
		a = a + "Niveau du personnage ?\n";
		a = a + "Force du personnage ?\n";
		a = a + "Agilité du personnage ?\n";
		a = a + "Intelligence du personnage ?\n";
		a = a + "Woarg je suis le Guerrier Joueur 1 niveau 10 je possède 50 de vitalité, 10 de force, 0 d'agilité et 0 d'intelligence !\n";
		a = a + "Création du personnage du Joueur 2\n";
		a = a + "Veuillez choisir la classe de votre personnage (1 : Guerrier, 2 : Rôdeur, 3 : Mage)\n";
		a = a + "Niveau du personnage ?\n";
		a = a + "Force du personnage ?\n";
		a = a + "Agilité du personnage ?\n";
		a = a + "Intelligence du personnage ?\n";
		a = a + "Abracadabra je suis le Mage Joueur 2 niveau 10 je possède 50 de vitalité, 0 de force, 0 d'agilité et 10 d'intelligence !\n";
		a = a + "Joueur 1 (50 Vitalité) veuillez choisir votre action (1 : Attaque Basique, 2 : Attaque Spéciale)\n";
		a = a + "Joueur 1 utilise Coup d'Épée et inflige 10 dommages.\n";
		a = a + "Joueur 2 perd 10 points de vie\n";
		a = a + "Joueur 2 (40 Vitalité) veuillez choisir votre action (1 : Attaque Basique, 2 : Attaque Spéciale)\n";
		a = a + "Joueur 2 utilise Boule de Feu et inflige 10 dommages.\n";
		a = a + "Joueur 1 perd 10 points de vie\n";
		a = a + "Joueur 1 (40 Vitalité) veuillez choisir votre action (1 : Attaque Basique, 2 : Attaque Spéciale)\n";
		a = a + "Joueur 1 utilise Coup de Rage et inflige 20 dommages.\n";
		a = a + "Joueur 2 perd 20 points de vie\n";
		a = a + "Joueur 1 perd 5 points de vie\n";
		a = a + "Joueur 2 (20 Vitalité) veuillez choisir votre action (1 : Attaque Basique, 2 : Attaque Spéciale)\n";
		a = a + "Joueur 2 utilise Soin et gagne 20 en vitalité\n";
		a = a + "Joueur 1 (35 Vitalité) veuillez choisir votre action (1 : Attaque Basique, 2 : Attaque Spéciale)\n";
		a = a + "Joueur 1 utilise Coup de Rage et inflige 20 dommages.\n";
		a = a + "Joueur 2 perd 20 points de vie\n";
		a = a + "Joueur 1 perd 5 points de vie\n";
		a = a + "Joueur 2 (20 Vitalité) veuillez choisir votre action (1 : Attaque Basique, 2 : Attaque Spéciale)\n";
		a = a + "Joueur 2 utilise Boule de Feu et inflige 10 dommages.\n";
		a = a + "Joueur 1 perd 10 points de vie\n";
		a = a + "Joueur 1 (20 Vitalité) veuillez choisir votre action (1 : Attaque Basique, 2 : Attaque Spéciale)\n";
		a = a + "Joueur 1 utilise Coup de Rage et inflige 20 dommages.\n";
		a = a + "Joueur 2 perd 20 points de vie\n";
		a = a + "Joueur 2 est mort\n";
		a = a + "Joueur 1 perd 5 points de vie\n";
		a = a + "Joueur 2 a perdu !\n";

		return a;
	}
	
	@Test
	public void test_Main() {
		String answer = build_answer_to_test_Main();
		
		System.setIn(new ByteArrayInputStream(answer.getBytes()));
		// Create a stream to hold the output
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		// IMPORTANT: Save the old System.out!
		PrintStream old = System.out;
		// Tell Java to use our special stream
		System.setOut(ps);
		Game.s = new Scanner(System.in);

		String[] arg = {};
		Main.main(arg);

		// Put things back
		System.out.flush();
		System.setOut(old);

		String request = build_request_to_test_Main();
		assertEquals(baos.toString(), request);
		
	}
}
