package pt.marquesmota;

public class Joueur {
	protected int Niveau, Vie, VieInitiale, Force, Agilite, Intelligence;
	protected String Nom;
	
	Joueur(String nouveauNom, int nouveauNiveau, int nouvelleVie, int nouvelleForce, int nouvelleAgilite, int nouvelleIntelligence) {
		Nom = nouveauNom;
		VieInitiale = nouvelleVie;
		Vie = nouvelleVie;
		Force = nouvelleForce;
		Agilite = nouvelleAgilite;
		Intelligence = nouvelleIntelligence;
	}
	
	/**
	 *  returns player life
	 */
	public int getVie() {
		return Vie;
	}
	
	/**
	 * change player life
	 */
	public void setVie(int nouvelleVie) {
		Vie = nouvelleVie;
	}

	public void attack(Joueur unJoueur) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println(Nom+" ("+Vie+" Vitalité) veuillez choisir votre action (1 : Attaque Basique, 2 : Attaque Spéciale");
		
	}
}
