package pt.marquesmota;

import java.util.Scanner;

public class Game {
	public static void start() {
		Joueur Joueur1, Joueur2;

		System.out.println("Création du personnage du Joueur 1");
		Joueur1 = create_character("Joueur 1");
		System.out.println(Joueur1.toString());

		System.out.println("Création du personnage du Joueur 2");
		Joueur2 = create_character("Joueur 2");
		System.out.println(Joueur2.toString());

		run_game(Joueur1, Joueur2);
	}

	private static void run_game(Joueur joueur1, Joueur joueur2) {
		while (joueur1.Vie !=0 || joueur2.Vie != 0) {
			
		}
	}

	public static Joueur create_character(String nouveauNom) {
		Joueur nouveauJoueur = null;

		int Classe = choice("Veuillez choisir la classe de votre personnage (1 : Guerrier, 2 : Rôdeur, 3 : Mage)", 1, 3);
		int Niveau = choice("Niveau du personnage ?", 1, 100);
		int Force = choice("Force du personnage ?", 0, 100);
		int Agilite = choice("Agilite du personnage ?", 0, 100);
		int Intelligence = choice("Intelligence du personnage ?", 0, 100);
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

	private static int choice(String question, int minimum, int maximum) {
		int i;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println(question);
			i = sc.nextInt();
			if (i<minimum || i>maximum) {
				System.out.println("Choix incorrect. Veuillez recommencer");
			}
		} while (i<minimum || i>minimum);
		return i;
	}
}
