package pt.marquesmota;

/**
 * Class for handling the effect of the attack
 * <p>
 * It returns 3 parameters with a string describing the effect, the damage taken and the damage given.
 * </p>
 * @author      Paul Marques Mota (pmarquesmota@gmail.com)
 * @version     1.0
 */
public class Effect {
	/**
	 * A String describing the effect.
	 */
	private String display;
	
	/**
	 * Damage taken.
	 */
	private int selfDamage;
	
	/**
	 * Damage given.
	 */
	private int otherDamage;
	
	/**
	 * The constructor of the class.
	 * <p>
	 * Creates the object with the description, damage taken and damage given.
	 * </p>
	 * @param initChaine
	 * @param initDommageSoi
	 * @param initDommageAutre
	 */
	public Effect(String initDisplay, int initSelfDamage, int initOtherDamage) {
		display = initDisplay;
		selfDamage = initSelfDamage;
		otherDamage = initOtherDamage;
	}
	
	/**
	 * A getter for the description of the effect.
	 * @return the String describing the effect.
	 */
	public String getDisplay() {
		return display;
	}
	
	/**
	 * A getter for the damage taken.
	 * @return the damage taken.
	 */
	public int getSelfDamage() {
		return selfDamage;
	}
	
	/**
	 * A getter for the damage given. 
	 * @return the damage given.
	 */
	public int getOtherDamage() {
		return otherDamage;
	}
}
