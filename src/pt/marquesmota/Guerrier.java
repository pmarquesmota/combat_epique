package pt.marquesmota;

public class Guerrier extends Joueur{
	public Guerrier(String nouveauNom, int nouveauNiveau, int nouvelleVie, int nouvelleForce, int nouvelleAgilite, int nouvelleIntelligence) {
		super(nouveauNom, nouveauNiveau, nouvelleVie, nouvelleForce, nouvelleAgilite, nouvelleIntelligence);
	}
	public Effet attaque_basique() {
		return new Effet("Coup d'Épée", 0, Force);
	}
	public Effet attaque_speciale() {
		return new Effet("Coup de Rage", Force/2, Force);
	}
	public String toString() {
		return "Woarg je suis le Guerrier "+Nom+
				" niveau "+Niveau+
				" je possède "+Vie+" de vitalité, "+
				Force+ " de force, "+
				Agilite+" d'agilité et"+
				Intelligence+" d'intelligence !";
	}
}
