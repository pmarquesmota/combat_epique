package pt.marquesmota;

import java.util.Scanner;

/**
 * class which is used to manage the abstract high level view of the game.
 * 
 * @author Paul Marques Mota (pmarquesmota@gmail.com)
 * @version 1.0
 */
public class Game {
	/**
	 * This variable is declared once here to avoid being instanced each time
	 * Choose.choice is called
	 */
	static Scanner sc;

	/**
	 * The player's class
	 */
	private int Classe;
	
	/**
	 * The player's level
	 */
	private int Niveau;
	
	/**
	 * The player's force
	 */
	private int Force;
	
	/**
	 * The player's agility
	 */
	private int Agilite;
	
	/**
	 * The player's intelligence
	 */
	private int Intelligence;

	public static Scanner getSc() {
		return sc;
	}

	public static void setSc(Scanner sc) {
		Game.sc = sc;
	}

	public int getClasse() {
		return Classe;
	}

	public void setClasse(int classe) {
		Classe = classe;
	}

	public int getNiveau() {
		return Niveau;
	}

	public void setNiveau(int niveau) {
		Niveau = niveau;
	}

	public int getForce() {
		return Force;
	}

	public void setForce(int force) {
		Force = force;
	}

	public int getAgilite() {
		return Agilite;
	}

	public void setAgilite(int agilite) {
		Agilite = agilite;
	}

	public int getIntelligence() {
		return Intelligence;
	}

	public void setIntelligence(int intelligence) {
		Intelligence = intelligence;
	}

	/**
	 * Creates the characters and pass the execution to run_game to carry on to the
	 * main loop of the game.
	 */
	public void start() {
		Joueur Joueur1, Joueur2;

		sc = new Scanner(System.in);

		Joueur1 = create_character("Joueur 1");
		Joueur2 = create_character("Joueur 2");

		run_game(Joueur1, Joueur2);
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
	private void run_game(Joueur joueur1, Joueur joueur2) {
		while (joueur1.getVie() > 0 && joueur2.getVie() > 0) {
			joueur1.attaque(joueur2);
			if (joueur1.getVie() > 0 && joueur2.getVie() > 0) {
				joueur2.attaque(joueur1);
			}
		}
		if (joueur1.getVie() <= 0) {
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
	public Joueur create_character(String nouveauNom) {
		Joueur unJoueur;
		System.out.println("Création du personnage du " + nouveauNom);

		unJoueur = create_character_object(nouveauNom);
		System.out.println(unJoueur.toString());

		return unJoueur;
	}

	// Interface for the array of methods
	interface CharacterAction {
		Joueur Create(String nouveauNom, int Niveau, int Force, int Agilite, int Intelligence);
	}
	
	// Array of methods which implement the Adapter pattern
	private CharacterAction[] CharacterActions = new CharacterAction[] {
	        new CharacterAction()	{
	        							public Joueur Create(String nouveauNom, int Niveau, int Force, int Agilite, int Intelligence) {
	        								return new Guerrier(nouveauNom, Niveau, Niveau * 5, Force, Agilite, Intelligence);
	        							}
	        						},
	        new CharacterAction()	{
	        							public Joueur Create(String nouveauNom, int Niveau, int Force, int Agilite, int Intelligence) {
	        								return new Rodeur(nouveauNom, Niveau, Niveau * 5, Force, Agilite, Intelligence);
	        							}
	        						},
	        new CharacterAction()	{
	        							public Joueur Create(String nouveauNom, int Niveau, int Force, int Agilite, int Intelligence) {
	        								return new Mage(nouveauNom, Niveau, Niveau * 5, Force, Agilite, Intelligence);
	        							}
	        						}
	    };
	
	/**
	 * Create the character's object
	 * @param nouveauNom
	 * @return an object representing the player
	 */
	public Joueur create_character_object(String Nom) {
		
		do {
			Classe = Choose.choice(
					"Veuillez choisir la classe de votre personnage (1 : Guerrier, 2 : Rôdeur, 3 : Mage)", 1, 3);
			Niveau = Choose.choice("Niveau du personnage ?", 1, 100);
			Force = Choose.choice("Force du personnage ?", 0, 100);
			Agilite = Choose.choice("Agilite du personnage ?", 0, 100);
			Intelligence = Choose.choice("Intelligence du personnage ?", 0, 100);
			if (Force + Agilite + Intelligence != Niveau) {
				System.out.println(
						"Attention le total force + agilité + intelligence doit être égal au niveau du joueur. Veuillez recommencer, s'il vous plait.");
			}
		} while (Force + Agilite + Intelligence != Niveau);

		// Selects the method in the array of methods according to the character's Class
		return CharacterActions[Classe - 1].Create(Nom, Niveau, Force, Agilite, Intelligence);
	}
}
