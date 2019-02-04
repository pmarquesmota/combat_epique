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
	
	public String getName() {
		return Nom;
	}
	
	public void setName(String nouveauNom) {
		Nom = nouveauNom;
	}
}
