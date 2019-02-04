package pt.marquesmota;

public class Mage extends Joueur{
	public Effet attaque_basique() {
		return new Effet("Boule de Feu", 0, Intelligence);
	}
	public Effet attaque_speciale() {
		return new Effet("", 0, 0);
	}

}
