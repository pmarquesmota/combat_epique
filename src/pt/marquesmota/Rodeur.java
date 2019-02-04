package pt.marquesmota;

public class Rodeur extends Joueur{
	public Effet attaque_basique() {
		return new Effet("Tir à l'Arc", 0, Agilite);
	}
	public Effet attaque_speciale() {
		return new Effet("", 0, 0);
	}

}
