package pt.marquesmota;

/**
 * Class for handling the effect of the attack
 * <p>
 * It returns 3 parameters with a string describing the effect, the damage taken and the damage given.
 * </p>
 * @author      Paul Marques Mota (pmarquesmota@gmail.com)
 * @version     1.0
 */
public class Effet {
	/**
	 * A String describing the effect.
	 */
	private String Chaine;
	
	/**
	 * Damage taken.
	 */
	private int DommageSoi;
	
	/**
	 * Damage given.
	 */
	private int DommageAutre;
	
	/**
	 * The constructor of the class.
	 * <p>
	 * Creates the object with the description, damage taken and damage given.
	 * </p>
	 * @param initChaine
	 * @param initDommageSoi
	 * @param initDommageAutre
	 */
	public Effet(String initChaine, int initDommageSoi, int initDommageAutre) {
		Chaine = initChaine;
		DommageSoi = initDommageSoi;
		DommageAutre = initDommageAutre;
	}
	
	/**
	 * A getter for the description of the effect.
	 * @return the String describing the effect.
	 */
	public String getChaine() {
		return Chaine;
	}
	
	/**
	 * A getter for the damage taken.
	 * @return the damage taken.
	 */
	public int getDommageSoi() {
		return DommageSoi;
	}
	
	/**
	 * A getter for the damage given. 
	 * @return the damage given.
	 */
	public int getDommageAutre() {
		return DommageAutre;
	}
}
