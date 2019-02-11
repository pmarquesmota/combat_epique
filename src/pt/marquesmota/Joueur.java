package pt.marquesmota;

public class Joueur {
	private int Niveau, Vie, VieInitiale, Force, Agilite, Intelligence;
	private String Nom;
	
	Joueur(String nouveauNom, int nouveauNiveau, int nouvelleVie, int nouvelleForce, int nouvelleAgilite, int nouvelleIntelligence) {
		Nom = nouveauNom;
		VieInitiale = nouvelleVie;
		Vie = nouvelleVie;
		Force = nouvelleForce;
		Agilite = nouvelleAgilite;
		Intelligence = nouvelleIntelligence;
	}
	
	/**
	 *  returns player name
	 */
	public String getNom() {
		return Nom;
	}
	
	/**
	 *  returns player level
	 */
	public int getForce() {
		return Force;
	}
		
	/**
	 *  returns player agility
	 */
	public int getAgilite() {
		return Agilite;
	}
		
	/**
	 *  Sets player agility
	 */
	public void setAgilite(int newAgilite) {
		Agilite = newAgilite;
	}
		
	/**
	 *  returns player int
	 */
	public int getIntelligence() {
		return Intelligence;
	}
		
	/**
	 *  returns player level
	 */
	public int getNiveau() {
		return Niveau;
	}
		
	/**
	 *  returns player life
	 */
	public int getVie() {
		return Vie;
	}

	/**
	 *  returns player initial life
	 */
	public int getVieInitiale() {
		return VieInitiale;
	}
	
	/**
	 * change player life
	 */
	public void setVie(int nouvelleVie) {
		Vie = nouvelleVie;
	}

	public void attack(Joueur unJoueur) {		
		Choose.choice(Nom+" ("+Vie+" Vitalité) veuillez choisir votre action (1 : Attaque Basique, 2 : Attaque Spéciale", 1, 2);
	}
}
