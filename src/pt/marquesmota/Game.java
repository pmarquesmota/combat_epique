package pt.marquesmota;

import java.util.Scanner;

/**
 * class which is used to manage the abstract high level view of the game.
 * @author      Paul Marques Mota <pmarquesmota@gmail.com>
 * @version     1.0
 */
public class Game {
	
	static Scanner sc;
	
	/**
	 * Creates the characters and pass the execution to run_game to carry on to the main loop of the game.
	 */
	public static void start() {
		Joueur Joueur1, Joueur2;

		sc = new Scanner(System.in);
		
		System.out.println("Création du personnage du Joueur 1");
		Joueur1 = create_character("Joueur 1");
		System.out.println(Joueur1.toString());

		System.out.println("Création du personnage du Joueur 2");
		Joueur2 = create_character("Joueur 2");
		System.out.println(Joueur2.toString());

		run_game(Joueur1, Joueur2);
	}
	
	/**
	 * The main loop.
	 * <p>
	 * the characters attack each other until one of them is dead
	 * </p>
	 * @param joueur1 the first character
	 * @param joueur2 the second character
	 */
	private static void run_game(Joueur joueur1, Joueur joueur2) {
		while (joueur1.getVie() > 0 && joueur2.getVie() > 0) {
			joueur1.attaque(joueur2);
			if(joueur1.getVie()>0 && joueur2.getVie()>0) {
				joueur2.attaque(joueur1);
			}
		}
		if(joueur1.getVie() <= 0) {
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
	 * @param nouveauNom the name of the character.
	 * @return an object representing the character chosen.
	 */
	public static Joueur create_character(String nouveauNom) {
		Joueur nouveauJoueur = null;

		int Classe = Choose.choice("Veuillez choisir la classe de votre personnage (1 : Guerrier, 2 : Rôdeur, 3 : Mage)", 1, 3);
		int Niveau = Choose.choice("Niveau du personnage ?", 1, 100);
		int Force = Choose.choice("Force du personnage ?", 0, 100);
		int Agilite = Choose.choice("Agilite du personnage ?", 0, 100);
		int Intelligence = Choose.choice("Intelligence du personnage ?", 0, 100);
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
