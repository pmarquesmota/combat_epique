package pt.marquesmota;

/**
 * The Mage character class.
 * <p>
 * Creates the character object using the superclass constructor, manages the attacks, and print the object.
 * </p>
 * @author      Paul Marques Mota (pmarquesmota@gmail.com)
 * @version     1.0
 */
public class Mage extends Joueur{
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
	public Mage (String nouveauNom, int nouveauNiveau, int nouvelleVie, int nouvelleForce, int nouvelleAgilite, int nouvelleIntelligence) {
		super(nouveauNom, nouveauNiveau, nouvelleVie, nouvelleForce, nouvelleAgilite, nouvelleIntelligence);
	}
	
	/**
	 * {@inheritDoc}
	 */
	public Effet attaque_basique() {
		return new Effet(this.getNom()+" utilise Boule de Feu et inflige "+this.getIntelligence()+" dommages.", 0, this.getIntelligence());
	}
	
	/**
	 * {@inheritDoc}
	 */
	public Effet attaque_speciale() {
		int gain = this.getIntelligence()*2;
		this.setVie(this.getVie() + gain);
		if(this.getVie() > this.getVieInitiale()) {
			this.setVie(this.getVieInitiale());
		}
		return new Effet(this.getNom()+" utilise Soin et gagne "+gain+" en vitalité", 0, 0);
	}
	
	/**
	 * {@inheritDoc}
	 */
	public String toString() {
		return "Abracadabra je suis le Mage "+this.getNom()+
				" niveau "+this.getNiveau()+
				" je possède "+this.getVie()+" de vitalité, "+
				this.getForce()+ " de force, "+
				this.getAgilite()+" d'agilité et "+
				this.getIntelligence()+" d'intelligence !";
	}
}
