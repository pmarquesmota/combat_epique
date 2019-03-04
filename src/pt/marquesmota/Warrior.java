package pt.marquesmota;

/**
 * The Warrior character class.
 * <p>
 * Creates the character object using the superclass constructor, manages the attacks, and print the object.
 * </p>
 * @author      Paul Marques Mota (pmarquesmota@gmail.com)
 * @version     1.0
 */
public class Warrior extends Player{
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
	public Warrior (String newName, int newLevel, int newLife, int newStrength, int newAgility, int newIntelligence) {
		super(newName, newLevel, newLife, newStrength, newAgility, newIntelligence);
	}
	
	/**
	 * {@inheritDoc}
	 */
	public Effect basic_attack() {
		return new Effect(
				this.getName()+" utilise Coup d'Épée et inflige "+this.getStrength()+" dommages.",
				0,
				this.getStrength()
		);
	}
	
	/**
	 * {@inheritDoc}
	 */
	public Effect special_attack() {
		return new Effect(
				this.getName()+" utilise Coup de Rage et inflige "+this.getStrength()*2+" dommages.",
				this.getStrength()/2,
				this.getStrength()*2
		);
	}

	/**
	 * {@inheritDoc}
	 */
	public String toString() {
		return "Woarg je suis le Guerrier "+this.getName()+
				" niveau "+this.getLevel()+
				" je possède "+this.getLife()+" de vitalité, "+
				this.getStrength()+ " de force, "+
				this.getAgility()+" d'agilité et "+
				this.getIntelligence()+" d'intelligence !";
	}
}
