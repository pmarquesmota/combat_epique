package pt.marquesmota;

import java.util.Scanner;

/**
 * class which is used to manage the abstract high level view of the game.
 * 
 * @author Paul Marques Mota (pmarquesmota@gmail.com)
 * @version 1.0
 */
public class Game {
	public static Scanner s;

	/**
	 * Creates the characters and pass the execution to run_game to carry on to the
	 * main loop of the game.
	 */
	public static void start() {
		Player Player1, Player2;

		Player1 = create_character("Joueur 1");
		Player2 = create_character("Joueur 2");

		run_game(Player1, Player2);
	}

	/**
	 * The main loop.
	 * <p>
	 * the characters attack each other until one of them is dead
	 * </p>
	 * 
	 * @param joueur1 the first character
	 * @param joueur2 the second character
	 */
	private static void run_game(Player player1, Player player2) {
		while (player1.getLife() > 0 && player2.getLife() > 0) {
			player1.attack(player2);
			if (player1.getLife() > 0 && player2.getLife() > 0) {
				player2.attack(player1);
			}
		}
		if (player1.getLife() <= 0) {
			System.out.println("Joueur 1 a perdu !");
		} else {
			System.out.println("Joueur 2 a perdu !");
		}
	}

	/**
	 * Actually creates the character
	 * <p>
	 * The player is asked to choose a name and characteristics of her character.
	 * Then a new character object is created according the player specifications.
	 * </p>
	 * 
	 * @param nouveauNom the name of the character.
	 * @return an object representing the character chosen.
	 */
	public static Player create_character(String newName) {
		Player aPlayer;
		System.out.println("Création du personnage du " + newName);

		aPlayer = create_character_object(newName);
		System.out.println(aPlayer.toString());

		return aPlayer;
	}

	// Interface for the array of methods
	// see: https://stackoverflow.com/questions/4280727/java-creating-an-array-of-methods
	interface CharacterAction {
		Player Create(String newName, int Level, int Strength, int Agility, int Intelligence);
	}
	
	// Array of methods
	private static CharacterAction[] CharacterActions = new CharacterAction[] {
	        new CharacterAction()	{
	        							public Player Create(String newName, int Level, int Strength, int Agility, int Intelligence) {
	        								return new Warrior(newName, Level, Level * 5, Strength, Agility, Intelligence);
	        							}
	        						},
	        new CharacterAction()	{
	        							public Player Create(String newName, int Level, int Strength, int Agility, int Intelligence) {
	        								return new Ranger(newName, Level, Level * 5, Strength, Agility, Intelligence);
	        							}
	        						},
	        new CharacterAction()	{
	        							public Player Create(String newName, int Level, int Strength, int Agility, int Intelligence) {
	        								return new Wizard(newName, Level, Level * 5, Strength, Agility, Intelligence);
	        							}
	        						}
	    };
	
	/**
	 * Create the character's object
	 * @param nouveauNom
	 * @return an object representing the player
	 */
	public static Player create_character_object(String name) {
		int myClass, myLevel, myStrength, myAgility, myIntelligence;
		
		do {
			myClass = Choose.choice(
					"Veuillez choisir la classe de votre personnage (1 : Guerrier, 2 : Rôdeur, 3 : Mage)", 1, 3);
			myLevel = Choose.choice("Niveau du personnage ?", 1, 100);
			myStrength = Choose.choice("Force du personnage ?", 0, 100);
			myAgility = Choose.choice("Agilité du personnage ?", 0, 100);
			myIntelligence = Choose.choice("Intelligence du personnage ?", 0, 100);
			if (myStrength + myAgility + myIntelligence != myLevel) {
				System.out.println(
						"Attention le total force + agilité + intelligence doit être égal au niveau du joueur. Veuillez recommencer, s'il vous plait.");
			}
		} while (myStrength + myAgility + myIntelligence != myLevel);

		// Selects the method in the array of methods according to the character's Class
		return CharacterActions[myClass - 1].Create(name, myLevel, myStrength, myAgility, myIntelligence);
	}
}
