package pt.marquesmota;

public class Guerrier extends Joueur{
	public Guerrier(String nouveauNom, int nouveauNiveau, int nouvelleVie, int nouvelleForce, int nouvelleAgilite, int nouvelleIntelligence) {
		super(nouveauNom, nouveauNiveau, nouvelleVie, nouvelleForce, nouvelleAgilite, nouvelleIntelligence);
	}
	public Effet attaque_basique() {
		return new Effet("Coup d'Épée", 0, this.getForce());
	}
	public Effet attaque_speciale() {
		return new Effet("Coup de Rage", this.getForce()/2, this.getForce()*2);
	}
	public String toString() {
		return "Woarg je suis le Guerrier "+this.getNom()+
				" niveau "+this.getNiveau()+
				" je possède "+this.getVie()+" de vitalité, "+
				this.getForce()+ " de force, "+
				this.getAgilite()+" d'agilité et "+
				this.getIntelligence()+" d'intelligence !";
	}
}
