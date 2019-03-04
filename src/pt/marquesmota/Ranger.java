package pt.marquesmota;

/**
 * The Ranger character class.
 * <p>
 * Creates the character object using the superclass constructor, manages the attacks, and print the object.
 * </p>
 * @author      Paul Marques Mota (pmarquesmota@gmail.com)
 * @version     1.0
 */
public class Ranger extends Player{
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
	public Ranger (String newName, int newLevel, int newLife, int newStrength, int newAgility, int newIntelligence) {
		super(newName, newLevel, newLife, newStrength, newAgility, newIntelligence);
	}
	
	/**
	 * {@inheritDoc}
	 */
	public Effect basic_attack() {
		return new Effect(
				this.getName()+" utilise Tir à l'Arc et inflige "+this.getAgility()+" dommages.",
				0,
				this.getAgility()
		);
	}
	
	/**
	 * {@inheritDoc}
	 */
	public Effect special_attack() {
		int gain = this.getLevel()/2;
		this.setAgility(this.getAgility() + gain);
		return new Effect(
				this.getName() + " utilise Concentration et gagne "+gain+" en agilité.",
				0,
				0
		);
	}
	
	/**
	 * {@inheritDoc}
	 */
	public String toString() {
		return "Woof je suis le Rodeur "+this.getName()+
				" niveau "+this.getLevel()+
				" je possède "+this.getLife()+" de vitalité, "+
				this.getStrength()+ " de force, "+
				this.getAgility()+" d'agilité et "+
				this.getIntelligence()+" d'intelligence !";
	}
}
