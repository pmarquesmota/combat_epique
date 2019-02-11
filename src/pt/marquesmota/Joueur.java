package pt.marquesmota;

public abstract class Joueur {
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

	public void attaque(Joueur unJoueur) {	
		Effet resultat;
		int choix = Choose.choice(getNom()+" ("+getVie()+" Vitalité) veuillez choisir votre action (1 : Attaque Basique, 2 : Attaque Spéciale)", 1, 2);
		if(choix == 1) {
			resultat = attaque_basique();
		} else {
			resultat = attaque_speciale();
		}
		System.out.println(resultat.getChaine());
		perdVie(resultat.getDommageAutre(), unJoueur);
		perdVie(resultat.getDommageSoi(), this);
	}
	
	public void perdVie(int dommage, Joueur unJoueur) {
		if(dommage > 0) {
			System.out.println(unJoueur.getNom()+" perd "+dommage+" points de vie");
			unJoueur.setVie(unJoueur.getVie() - dommage);
		}
	}

	public abstract Effet attaque_basique();
	public abstract Effet attaque_speciale();
	public abstract String toString();
}
