package pt.marquesmota;

/**
 * Superclass of the character's object.
 * <p>
 * Marked as abstract since it contains the abstracts methods attaque_basique, attaque_speciale and toString implemented in the subclass
 * </p>
 * @author      Paul Marques Mota (pmarquesmota@gmail.com)
 * @version     1.0
 */
public abstract class Player {
	/**
	 * The level of the character.
	 */
	private int Level;
	/**
	 * The life of the character.
	 */
	private int Life;
	/**
	 * The initial life of the character.
	 */
	private int InitialLife; 
	/**
	 * The force of the character.
	 */
	private int Strength;
	/**
	 * The agility of the character.
	 */
	private int Agility; 
	/**
	 * The intelligence of the character.
	 */
	private int Intelligence;
	/**
	 * The name of the character.
	 */
	private String Name;
	
	/**
	 * The constructor of the class, creates a new character with the specified attributes
	 * @param nouveauNom character's name
	 * @param nouveauNiveau character's level
	 * @param nouvelleVie character's life
	 * @param nouvelleForce character's force
	 * @param nouvelleAgilite character's agility
	 * @param nouvelleIntelligence character's intelligence
	 */
	Player(String newName, int newLevel, int newLife, int newStrength, int newAgility, int newIntelligence) {
		Name = newName;
		Level = newLevel;
		InitialLife = newLife;
		Life = newLife;
		Strength = newStrength;
		Agility = newAgility;
		Intelligence = newIntelligence;
	}
	
	/**
	 * 
	 * @return the name of the character
	 */
	public String getName() {
		return Name;
	}
	
	/**
	 * 
	 * @return the force of the character
	 */
	public int getStrength() {
		return Strength;
	}
		
	/**
	 * 
	 * @return the agility of the character
	 */
	public int getAgility() {
		return Agility;
	}
		
	/**
	 * 
	 * @param newAgilite Sets the character agility
	 */
	public void setAgility(int newAgility) {
		Agility = newAgility;
	}
		
	/**
	 * 
	 * @return the character intelligence.
	 */
	public int getIntelligence() {
		return Intelligence;
	}
		
	/**
	 *  @return player level
	 */
	public int getLevel() {
		return Level;
	}
		
	/**
	 *  @return player life
	 */
	public int getLife() {
		return Life;
	}

	/**
	 *  @return player initial life
	 */
	public int getInitialLife() {
		return InitialLife;
	}
	
	/**
	 * 
	 * @param nouvelleVie Sets the character life
	 */
	public void setLife(int newLife) {
		Life = newLife;
	}

	/**
	 * High level attack method.
	 * <p>
	 * asks which kind of attack the player wishes to choose, then calls the object subclass attack method
	 * </p>
	 * @param unJoueur the character object
	 */
	public void attack(Player aPlayer) {	
		Effect result;
		
		int choix = Choose.choice(getName()+" ("+getLife()+" Vitalité) veuillez choisir votre action (1 : Attaque Basique, 2 : Attaque Spéciale)", 1, 2);
		if(choix == 1) {
			result = basic_attack();
		} else {
			result = special_attack();
		}
		System.out.println(result.getDisplay());
		loseLife(result.getOtherDamage(), aPlayer);
		loseLife(result.getSelfDamage(), this);
	}
	
	/**
	 * Called when a character loses some life
	 * @param dommage damage taken
	 * @param unJoueur the character object
	 */
	public void loseLife(int damage, Player aPlayer) {
		if(damage > 0) {
			System.out.println(aPlayer.getName()+" perd "+damage+" points de vie");
			aPlayer.setLife(aPlayer.getLife() - damage);
			if(aPlayer.getLife() <= 0) {
				System.out.println(aPlayer.getName() +" est mort");
			}
		}
	}
	
	/**
	 * A basic attack
	 * @return an object which contains the String description, damage taken and damage given
	 * @see Effet
	 */
	public abstract Effect basic_attack();
	
	/**
	 * A special attack
	 * @return an object which contains the String description, damage taken and damage given
	 * @see Effet
	 */
	public abstract Effect special_attack();
	
	/**
	 * Print the object.
	 * @return a description of the object characteristic 
	 */
	public abstract String toString();
}
