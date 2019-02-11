package pt.marquesmota;

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
		while (joueur1.getVie() > 0 && joueur2.getVie() > 0) {
			joueur1.attaque(joueur2);
			if(joueur1.getVie()>0 || joueur2.getVie()>0) {
				joueur2.attaque(joueur1);
			}
		}
		if(joueur1.getVie() <= 0) {
			System.out.println("Joueur 1 a perdu !");
		} else {
			System.out.println("Joueur 2 a perdu !");			
		}
	}

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
