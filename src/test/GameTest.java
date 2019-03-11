package test;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.util.Scanner;

import org.junit.Test;
import pt.marquesmota.*;

public class GameTest {

	/**
	 * Build the request String to the create_character method test as a Warrior.
	 * @return The request String.
	 */
	public String Build_request_to_test_create_character_as_Warrior() {
		String r = "";
		
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
	
	/**
	 * Build the answer String to the create_character method test as a Warrior, with invalid answers.
	 * @return The answer String.
	 */
	String Build_answer_to_test_create_character_as_Warrior() {
		String a = "";
		
		a = a + "Création du personnage du Joueur 1\n";
		a = a + "Veuillez choisir la classe de votre personnage (1 : Guerrier, 2 : Rôdeur, 3 : Mage)\n";
		a = a + "Niveau du personnage ?\n";
		a = a + "Force du personnage ?\n";
		a = a + "Agilité du personnage ?\n";
		a = a + "Intelligence du personnage ?\n";
		a = a + "Woarg je suis le Guerrier Joueur 1 niveau 10 je possède 50 de vitalité, 10 de force, 0 d'agilité et 0 d'intelligence !\n";

		return a;
	}
	
	/**
	 * Test the create_character method as a Warrior.
	 */
	@Test
	public void test_create_character_as_Warrior() {
		String request = Build_request_to_test_create_character_as_Warrior();
		ByteArrayOutputStream baos = MyStream.RedirectStream(request);

		String answer = Build_answer_to_test_create_character_as_Warrior();
		
		Game.s = new Scanner(System.in);
		Player ptest = Game.create_character("Joueur 1");
		Player p = new Warrior("Joueur 1", 10, 50, 10, 0, 0);

		MyStream.ResetStream();
		
		assertEquals(ptest.toString(), p.toString());
		assertEquals(baos.toString(), answer);
	}

	/**
	 * Build the request String to the create_character method test as a Ranger.
	 * @return The request String.
	 */
	public String Build_request_to_test_create_character_as_Ranger() {
		String r = "";
		
		// choose class Ranger
		r = r + "2\n";
		
		// choose level
		r = r + "10\n";
		
		// choose strength
		r = r + "0\n";
		
		// choose agility
		r = r + "10\n";
		
		//  choose intelligence
		r = r + "0\n";

		return r;
	}
	
	/**
	 * Build the answer String to the create_character method test as a Ranger.
	 * @return The answer String.
	 */
	String Build_answer_to_test_create_character_as_Ranger() {
		String a = "";
		
		a = a + "Création du personnage du Joueur 1\n";
		a = a + "Veuillez choisir la classe de votre personnage (1 : Guerrier, 2 : Rôdeur, 3 : Mage)\n";
		a = a + "Niveau du personnage ?\n";
		a = a + "Force du personnage ?\n";
		a = a + "Agilité du personnage ?\n";
		a = a + "Intelligence du personnage ?\n";
		a = a + "Woof je suis le Rodeur Joueur 1 niveau 10 je possède 50 de vitalité, 0 de force, 10 d'agilité et 0 d'intelligence !\n";

		return a;
	}
	
	/**
	 * Test the create_character method as a Ranger.
	 */
	@Test
	public void test_create_character_as_Ranger() {
		String request = Build_request_to_test_create_character_as_Ranger();
		ByteArrayOutputStream baos = MyStream.RedirectStream(request);

		String answer = Build_answer_to_test_create_character_as_Ranger();
		
		Game.s = new Scanner(System.in);
		Player ptest = Game.create_character("Joueur 1");
		Player p = new Ranger("Joueur 1", 10, 50, 0, 10, 0);

		MyStream.ResetStream();
		
		assertEquals(ptest.toString(), p.toString());
		assertEquals(baos.toString(), answer);
	}

	/**
	 * Build the request String to the create_character method test as a Wizard.
	 * @return The request String.
	 */
	public String Build_request_to_test_create_character_as_Wizard() {
		String r = "";
		
		// choose class Wizard
		r = r + "3\n";
		
		// choose level
		r = r + "10\n";
		
		// choose strength
		r = r + "0\n";
		
		// choose agility
		r = r + "0\n";
		
		//  choose intelligence
		r = r + "10\n";

		return r;
	}
	
	/**
	 * Build the answer String to the create_character method test as a Wizard.
	 * @return The answer String.
	 */
	String Build_answer_to_test_create_character_as_Wizard() {
		String a = "";
		
		a = a + "Création du personnage du Joueur 1\n";
		a = a + "Veuillez choisir la classe de votre personnage (1 : Guerrier, 2 : Rôdeur, 3 : Mage)\n";
		a = a + "Niveau du personnage ?\n";
		a = a + "Force du personnage ?\n";
		a = a + "Agilité du personnage ?\n";
		a = a + "Intelligence du personnage ?\n";
		a = a + "Abracadabra je suis le Mage Joueur 1 niveau 10 je possède 50 de vitalité, 0 de force, 0 d'agilité et 10 d'intelligence !\n";

		return a;
	}
	
	/**
	 * Test the create_character method as a Wizard.
	 */
	@Test
	public void test_create_character_as_Wizard() {
		String request = Build_request_to_test_create_character_as_Wizard();
		ByteArrayOutputStream baos = MyStream.RedirectStream(request);
		String answer = Build_answer_to_test_create_character_as_Wizard();
		
		Game.s = new Scanner(System.in);
		Player ptest = Game.create_character("Joueur 1");
		Player p = new Wizard("Joueur 1", 10, 50, 0, 0, 10);

		MyStream.ResetStream();
		
		assertEquals(ptest.toString(), p.toString());
		assertEquals(baos.toString(), answer);
	}
		
	/**
	 * Build the request String to the create_character method test as a Warrior, with invalid answers.
	 * @return The request String.
	 */
	public String build_request_to_choose_character_as_Warrior_with_invalid_answers() {
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
	
	/**
	 * Build the answer String to the create_character method test as a Warrior, with invalid answers.
	 * @return The answer String.
	 */
	String build_answer_to_choose_character_as_Warrior_with_invalid_answers() {
		String a = "";
		
		// Must choose class
		a = a + "Veuillez choisir la classe de votre personnage (1 : Guerrier, 2 : Rôdeur, 3 : Mage)\n";
		
		// Must choose level
		a = a + "Niveau du personnage ?\n";
		
		// Must choose strength
		a = a + "Force du personnage ?\n";
		
		// Must choose agility
		a = a + "Agilité du personnage ?\n";
		
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
		a = a + "Agilité du personnage ?\n";
		
		// Must choose intelligence
		a = a + "Intelligence du personnage ?\n";
		
		return a;
	}
	
	/**
	 * Test the create_character method as a Warrior, with invalid answers.
	 */
	@Test
	public void choose_character_as_Warrior_with_invalid_answers() {
		String request = build_request_to_choose_character_as_Warrior_with_invalid_answers();
		ByteArrayOutputStream baos = MyStream.RedirectStream(request);

		Game.s = new Scanner(System.in);

		Player ptest = Game.create_character_object("Joueur 1");
		Player p = new Warrior("Joueur 1", 10, 50, 10, 0, 0);

		MyStream.ResetStream();

		String answer = build_answer_to_choose_character_as_Warrior_with_invalid_answers();
		assertEquals(baos.toString(), answer);
		assertEquals(ptest.toString(), p.toString());
	}

	/**
	 * Build the request String to the create_character method test as a Ranger, with invalid answers.
	 * @return The request String.
	 */
	public String build_request_to_choose_character_as_Ranger_with_invalid_answers() {
		String r = "";
		
		// choose class Ranger
		r = r + "2\n";
		
		// choose level
		r = r + "10\n";
		
		// choose strength
		r = r + "10\n";
		
		// choose agility
		r = r + "10\n";
		
		//  choose intelligence
		r = r + "10\n";
		
		// choose class Ranger
		r = r + "2\n";
		
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
	
	/**
	 * Build the answer String to the create_character method test as a Ranger, with invalid answers.
	 * @return The answer String.
	 */
	String build_answer_to_choose_character_as_Ranger_with_invalid_answers() {
		String a = "";
		
		// Must choose class
		a = a + "Veuillez choisir la classe de votre personnage (1 : Guerrier, 2 : Rôdeur, 3 : Mage)\n";
		
		// Must choose level
		a = a + "Niveau du personnage ?\n";
		
		// Must choose strength
		a = a + "Force du personnage ?\n";
		
		// Must choose agility
		a = a + "Agilité du personnage ?\n";
		
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
		a = a + "Agilité du personnage ?\n";
		
		// Must choose intelligence
		a = a + "Intelligence du personnage ?\n";
		
		return a;
	}
	
	/**
	 * Test the create_character method as a Ranger, with invalid answers.
	 */
	@Test
	public void choose_character_as_Ranger_with_invalid_answers() {
		String request = build_request_to_choose_character_as_Ranger_with_invalid_answers();
		ByteArrayOutputStream baos = MyStream.RedirectStream(request);

		Game.s = new Scanner(System.in);

		Player ptest = Game.create_character_object("Joueur 1");
		Player p = new Ranger("Joueur 1", 10, 50, 10, 0, 0);

		MyStream.ResetStream();

		String answer = build_answer_to_choose_character_as_Ranger_with_invalid_answers();
		assertEquals(baos.toString(), answer);
		assertEquals(ptest.toString(), p.toString());
	}

	/**
	 * Build the request String to the create_character method test as a Wizard, with invalid answers.
	 * @return The request String.
	 */
	public String build_request_to_choose_character_as_Wizard_with_invalid_answers() {
		String r = "";
		
		// choose class Wizard
		r = r + "3\n";
		
		// choose level
		r = r + "10\n";
		
		// choose strength
		r = r + "10\n";
		
		// choose agility
		r = r + "10\n";
		
		//  choose intelligence
		r = r + "10\n";
		
		// choose class Wizard
		r = r + "3\n";
		
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
	
	/**
	 * Build the answer String to the create_character method test as a Wizard, with invalid answers.
	 * @return The answer String.
	 */
	String build_answer_to_choose_character_as_Wizard_with_invalid_answers() {
		String a = "";
		
		// Must choose class
		a = a + "Veuillez choisir la classe de votre personnage (1 : Guerrier, 2 : Rôdeur, 3 : Mage)\n";
		
		// Must choose level
		a = a + "Niveau du personnage ?\n";
		
		// Must choose strength
		a = a + "Force du personnage ?\n";
		
		// Must choose agility
		a = a + "Agilité du personnage ?\n";
		
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
		a = a + "Agilité du personnage ?\n";
		
		// Must choose intelligence
		a = a + "Intelligence du personnage ?\n";
		
		return a;
	}
	
	/**
	 * Test the create_character method as a Wizard, with invalid answers.
	 */
	@Test
	public void choose_character_as_Wizard_with_invalid_answers() {
		String request = build_request_to_choose_character_as_Wizard_with_invalid_answers();
		ByteArrayOutputStream baos = MyStream.RedirectStream(request);

		Game.s = new Scanner(System.in);

		Player ptest = Game.create_character_object("Joueur 1");
		Player p = new Wizard("Joueur 1", 10, 50, 10, 0, 0);

		MyStream.ResetStream();

		String answer = build_answer_to_choose_character_as_Wizard_with_invalid_answers();
		assertEquals(baos.toString(), answer);
		assertEquals(ptest.toString(), p.toString());
	}
}
