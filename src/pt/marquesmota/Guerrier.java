package pt.marquesmota;

/**
 * The Warrior character class.
 * <p>
 * Creates the character object using the superclass constructor, manages the attacks, and print the object.
 * </p>
 * @author      Paul Marques Mota <pmarquesmota@gmail.com>
 * @version     1.0
 */
public class Guerrier extends Joueur{
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
	public Guerrier(String nouveauNom, int nouveauNiveau, int nouvelleVie, int nouvelleForce, int nouvelleAgilite, int nouvelleIntelligence) {
		super(nouveauNom, nouveauNiveau, nouvelleVie, nouvelleForce, nouvelleAgilite, nouvelleIntelligence);
	}
	
	/**
	 * {@inheritDoc}
	 */
	public Effet attaque_basique() {
		return new Effet(this.getNom()+" utilise Coup d'Épée et inflige "+this.getForce()+" dommages.", 0, this.getForce());
	}
	
	/**
	 * {@inheritDoc}
	 */
	public Effet attaque_speciale() {
		return new Effet(this.getNom()+" utilise Coup de Rage et inflige "+this.getForce()*2+" dommages.", this.getForce()/2, this.getForce()*2);
	}

	/**
	 * {@inheritDoc}
	 */
	public String toString() {
		return "Woarg je suis le Guerrier "+this.getNom()+
				" niveau "+this.getNiveau()+
				" je possède "+this.getVie()+" de vitalité, "+
				this.getForce()+ " de force, "+
				this.getAgilite()+" d'agilité et "+
				this.getIntelligence()+" d'intelligence !";
	}
}
