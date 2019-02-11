package pt.marquesmota;

public class Rodeur extends Joueur{
	public Rodeur (String nouveauNom, int nouveauNiveau, int nouvelleVie, int nouvelleForce, int nouvelleAgilite, int nouvelleIntelligence) {
		super(nouveauNom, nouveauNiveau, nouvelleVie, nouvelleForce, nouvelleAgilite, nouvelleIntelligence);
	}
	public Effet attaque_basique() {
		return new Effet("Tir à l'Arc", 0, this.getAgilite());
	}
	public Effet attaque_speciale() {
		int gain = this.getNiveau()/2;
		this.setAgilite(this.getAgilite() + gain);
		System.out.println(this.getNom() + " utilise Concentration et gagne "+gain+" en agilité.");
		return new Effet("", 0, 0);
	}
	public String toString() {
		return "Woof je suis le Rodeur "+this.getNom()+
				" niveau "+this.getNiveau()+
				" je possède "+this.getVie()+" de vitalité, "+
				this.getForce()+ " de force, "+
				this.getAgilite()+" d'agilité et"+
				this.getIntelligence()+" d'intelligence !";
	}
}
