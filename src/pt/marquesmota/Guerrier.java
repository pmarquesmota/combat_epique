package pt.marquesmota;

public class Guerrier extends Joueur{
	public Effet attaque_basique() {
		return new Effet("Coup d'Épée", 0, Force);
	}
	public Effet attaque_speciale() {
		return new Effet("Coup de Rage", Force/2, Force);
	}
}
