package pt.marquesmota;

/**
 * The Mage character class.
 * <p>
 * Creates the character object using the superclass constructor, manages the attacks, and print the object.
 * </p>
 * @author      Paul Marques Mota (pmarquesmota@gmail.com)
 * @version     1.0
 */
public class Wizard extends Player{
	/**
	 * The object constructor.
	 * @param newName Character name
	 * @param newLevel Character level
	 * @param newLife Character life
	 * @param newStrength Character strength
	 * @param newAgility Character agility
	 * @param newIntelligence Character int
	 * @see Player
	 */
	public Wizard (String newName, int newLevel, int newLife, int newStrength, int newAgility, int newIntelligence) {
		super(newName, newLevel, newLife, newStrength, newAgility, newIntelligence);
	}
	
	/**
	 * {@inheritDoc}
	 */
	public Effect basic_attack() {
		return new Effect(
			this.getName()+" utilise Boule de Feu et inflige "+this.getIntelligence()+" dommages.",
			0,
			this.getIntelligence()
		);
	}
	
	/**
	 * {@inheritDoc}
	 */
	public Effect special_attack() {
		int gain = this.getIntelligence()*2;
		this.setLife(this.getLife() + gain);
		if(this.getLife() > this.getInitialLife()) {
			this.setLife(this.getInitialLife());
		}
		return new Effect(
				this.getName()+" utilise Soin et gagne "+gain+" en vitalité",
				0,
				0
				);
	}
	
	/**
	 * {@inheritDoc}
	 */
	public String toString() {
		return "Abracadabra je suis le Mage "+this.getName()+
				" niveau "+this.getLevel()+
				" je possède "+this.getLife()+" de vitalité, "+
				this.getStrength()+ " de force, "+
				this.getAgility()+" d'agilité et "+
				this.getIntelligence()+" d'intelligence !";
	}
}
