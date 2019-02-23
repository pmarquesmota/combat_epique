package pt.marquesmota;

/**
 * Superclass of the character's object.
 * <p>
 * Marked as abstract since it contains the abstracts methods attaque_basique, attaque_speciale and toString implemented in the subclass
 * </p>
 * @author      Paul Marques Mota (pmarquesmota@gmail.com)
 * @version     1.0
 */
public abstract class Joueur {
	/**
	 * The level of the character.
	 */
	private int Niveau;
	/**
	 * The life of the character.
	 */
	private int Vie;
	/**
	 * The initial life of the character.
	 */
	private int VieInitiale; 
	/**
	 * The force of the character.
	 */
	private int Force;
	/**
	 * The agility of the character.
	 */
	private int Agilite; 
	/**
	 * The intelligence of the character.
	 */
	private int Intelligence;
	/**
	 * The name of the character.
	 */
	private String Nom;
	
	/**
	 * The constructor of the class, creates a new character with the specified attributes
	 * @param nouveauNom character's name
	 * @param nouveauNiveau character's level
	 * @param nouvelleVie character's life
	 * @param nouvelleForce character's force
	 * @param nouvelleAgilite character's agility
	 * @param nouvelleIntelligence character's intelligence
	 */
	Joueur(String nouveauNom, int nouveauNiveau, int nouvelleVie, int nouvelleForce, int nouvelleAgilite, int nouvelleIntelligence) {
		Nom = nouveauNom;
		Niveau = nouveauNiveau;
		VieInitiale = nouvelleVie;
		Vie = nouvelleVie;
		Force = nouvelleForce;
		Agilite = nouvelleAgilite;
		Intelligence = nouvelleIntelligence;
	}
	
	/**
	 * 
	 * @return the name of the character
	 */
	public String getNom() {
		return Nom;
	}
	
	/**
	 * 
	 * @return the force of the character
	 */
	public int getForce() {
		return Force;
	}
		
	/**
	 * 
	 * @return the agility of the character
	 */
	public int getAgilite() {
		return Agilite;
	}
		
	/**
	 * 
	 * @param newAgilite Sets the character agility
	 */
	public void setAgilite(int newAgilite) {
		Agilite = newAgilite;
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
	public int getNiveau() {
		return Niveau;
	}
		
	/**
	 *  @return player life
	 */
	public int getVie() {
		return Vie;
	}

	/**
	 *  @return player initial life
	 */
	public int getVieInitiale() {
		return VieInitiale;
	}
	
	/**
	 * 
	 * @param nouvelleVie Sets the character life
	 */
	public void setVie(int nouvelleVie) {
		Vie = nouvelleVie;
	}

	/**
	 * High level attack method.
	 * <p>
	 * asks which kind of attack the player wishes to choose, then calls the object subclass attack method
	 * </p>
	 * @param unJoueur the character object
	 */
	public void attaque(Joueur unJoueur) {	
		Effet resultat;
		int choix = Choose.choice(getNom()+" ("+getVie()+" Vitalité) veuillez choisir votre action (1 : Attaque Basique, 2 : Attaque Spéciale)", 1, 2);
		if(choix == 1) {
			resultat = attaque_basique();
		} else {
			resultat = attaque_speciale();
		}
		System.out.println(resultat.getChaine());
		perdVie(resultat.getDommageAutre(), unJoueur);
		perdVie(resultat.getDommageSoi(), this);
	}
	
	/**
	 * Called when a character loses some life
	 * @param dommage damage taken
	 * @param unJoueur the character object
	 */
	public void perdVie(int dommage, Joueur unJoueur) {
		if(dommage > 0) {
			System.out.println(unJoueur.getNom()+" perd "+dommage+" points de vie");
			unJoueur.setVie(unJoueur.getVie() - dommage);
			if(unJoueur.getVie() <= 0) {
				System.out.println(unJoueur.getNom() +" est mort");
			}
		}
	}
	
	/**
	 * A basic attack
	 * @return an object which contains the String description, damage taken and damage given
	 * @see Effet
	 */
	public abstract Effet attaque_basique();
	
	/**
	 * A special attack
	 * @return an object which contains the String description, damage taken and damage given
	 * @see Effet
	 */
	public abstract Effet attaque_speciale();
	
	/**
	 * Print the object.
	 * @return a description of the object characteristic 
	 */
	public abstract String toString();
}
