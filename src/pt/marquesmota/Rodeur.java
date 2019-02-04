package pt.marquesmota;

public class Rodeur extends Joueur{
	public Rodeur (String nouveauNom, int nouveauNiveau, int nouvelleVie, int nouvelleForce, int nouvelleAgilite, int nouvelleIntelligence) {
		super(nouveauNom, nouveauNiveau, nouvelleVie, nouvelleForce, nouvelleAgilite, nouvelleIntelligence);
	}
	public Effet attaque_basique() {
		return new Effet("Tir à l'Arc", 0, Agilite);
	}
	public Effet attaque_speciale() {
		Agilite += Niveau/2;
		System.out.println(Nom + " utilise Concentration et gagne "+Niveau/2+" en agilité.");
		return new Effet("", 0, 0);
	}
	public String toString() {
		return "Woof je suis le Rodeur "+Nom+
				" niveau "+Niveau+
				" je possède "+Vie+" de vitalité, "+
				Force+ " de force, "+
				Agilite+" d'agilité et"+
				Intelligence+" d'intelligence !";
	}
}
