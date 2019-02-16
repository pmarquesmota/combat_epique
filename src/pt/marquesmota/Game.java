package pt.marquesmota;

import java.util.Scanner;

/**
 * class which is used to manage the abstract high level view of the game.
 * 
 * @author Paul Marques Mota <pmarquesmota@gmail.com>
 * @version 1.0
 */
public class Game {
	/**
	 * This variable is declared once here to avoid being instanced each time
	 * Choose.choice is called
	 */
	static Scanner sc;

	private int Classe;
	private int Niveau;
	private int Force;
	private int Agilite;
	private int Intelligence;

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

		choose_character();
		unJoueur = create_character_object(nouveauNom);
		System.out.println(unJoueur.toString());

		return unJoueur;
	}

	public void choose_character() {
		Classe = Choose.choice("Veuillez choisir la classe de votre personnage (1 : Guerrier, 2 : Rôdeur, 3 : Mage)", 1,
				3);
		Niveau = Choose.choice("Niveau du personnage ?", 1, 100);
		Force = Choose.choice("Force du personnage ?", 0, 100);
		Agilite = Choose.choice("Agilite du personnage ?", 0, 100);
		Intelligence = Choose.choice("Intelligence du personnage ?", 0, 100);
	}

	public Joueur create_character_object(String nouveauNom) {
		Joueur nouveauJoueur = null;

		switch (Classe) {
		case 1:
			nouveauJoueur = new Guerrier(nouveauNom, Niveau, Niveau * 5, Force, Agilite, Intelligence);
			break;
		case 2:
			nouveauJoueur = new Rodeur(nouveauNom, Niveau, Niveau * 5, Force, Agilite, Intelligence);
			break;
		case 3:
			nouveauJoueur = new Mage(nouveauNom, Niveau, Niveau * 5, Force, Agilite, Intelligence);
			break;
		}
		return nouveauJoueur;
	}
}
