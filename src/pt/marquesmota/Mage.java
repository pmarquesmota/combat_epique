package pt.marquesmota;

public class Mage extends Joueur{
	public Mage (String nouveauNom, int nouveauNiveau, int nouvelleVie, int nouvelleForce, int nouvelleAgilite, int nouvelleIntelligence) {
		super(nouveauNom, nouveauNiveau, nouvelleVie, nouvelleForce, nouvelleAgilite, nouvelleIntelligence);
	}
	public Effet attaque_basique() {
		return new Effet("Boule de Feu", 0, this.getIntelligence());
	}
	public Effet attaque_speciale() {
		int gain = this.getIntelligence()*2;
		this.setVie(this.getVie() + gain);
		if(this.getVie() > this.getVieInitiale()) {
			this.setVie(this.getVieInitiale());
		}
		System.out.println(this.getNom()+" utilise soin et gagne "+gain+" en vitalité");
		return new Effet("", 0, 0);
	}
	public String toString() {
		return "Abracadabra je suis le Mage "+this.getNom()+
				" niveau "+this.getNiveau()+
				" je possède "+this.getVie()+" de vitalité, "+
				this.getForce()+ " de force, "+
				this.getAgilite()+" d'agilité et"+
				this.getIntelligence()+" d'intelligence !";
	}
}
