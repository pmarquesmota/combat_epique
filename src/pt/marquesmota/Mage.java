package pt.marquesmota;

public class Mage extends Joueur{
	public Mage (String nouveauNom, int nouveauNiveau, int nouvelleVie, int nouvelleForce, int nouvelleAgilite, int nouvelleIntelligence) {
		super(nouveauNom, nouveauNiveau, nouvelleVie, nouvelleForce, nouvelleAgilite, nouvelleIntelligence);
	}
	public Effet attaque_basique() {
		return new Effet("Boule de Feu", 0, Intelligence);
	}
	public Effet attaque_speciale() {
		int gain = Intelligence*2;
		Vie += gain;
		if(Vie > VieInitiale) {
			Vie = VieInitiale;
		}
		System.out.println(Nom+" se soigne et regagne "+gain+" points de vie");
		return new Effet("", 0, 0);
	}
	public String toString() {
		return "Abracadabra je suis le Mage "+Nom+
				" niveau "+Niveau+
				" je possède "+Vie+" de vitalité, "+
				Force+ " de force, "+
				Agilite+" d'agilité et"+
				Intelligence+" d'intelligence !";
	}
}
