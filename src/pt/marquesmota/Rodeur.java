package pt.marquesmota;

/**
 * The Ranger character class.
 * <p>
 * Creates the character object using the superclass constructor, manages the attacks, and print the object.
 * </p>
 * @author      Paul Marques Mota <pmarquesmota@gmail.com>
 * @version     1.0
 */
public class Rodeur extends Joueur{
	/**
	 * The object constructor.
	 * @param nouveauNom Character name
	 * @param nouveauNiveau Character level
	 * @param nouvelleVie Character life
	 * @param nouvelleForce Character force
	 * @param nouvelleAgilite Character agility
	 * @param nouvelleIntelligence Character int
	 * @see Joueur
	 */
	public Rodeur (String nouveauNom, int nouveauNiveau, int nouvelleVie, int nouvelleForce, int nouvelleAgilite, int nouvelleIntelligence) {
		super(nouveauNom, nouveauNiveau, nouvelleVie, nouvelleForce, nouvelleAgilite, nouvelleIntelligence);
	}
	
	/**
	 * {@inheritDoc}
	 */
	public Effet attaque_basique() {
		return new Effet(this.getNom()+" utilise Tir à l'Arc et inflige "+this.getAgilite()+" dommages.", 0, this.getAgilite());
	}
	
	/**
	 * {@inheritDoc}
	 */
	public Effet attaque_speciale() {
		int gain = this.getNiveau()/2;
		this.setAgilite(this.getAgilite() + gain);
		return new Effet(this.getNom() + " utilise Concentration et gagne "+gain+" en agilité.", 0, 0);
	}
	
	/**
	 * {@inheritDoc}
	 */
	public String toString() {
		return "Woof je suis le Rodeur "+this.getNom()+
				" niveau "+this.getNiveau()+
				" je possède "+this.getVie()+" de vitalité, "+
				this.getForce()+ " de force, "+
				this.getAgilite()+" d'agilité et "+
				this.getIntelligence()+" d'intelligence !";
	}
}
