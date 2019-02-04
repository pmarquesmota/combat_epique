package pt.marquesmota;

public class Rodeur extends Joueur{
	public Effet attaque_basique() {
		return new Effet("Tir à l'Arc", 0, Agilite);
	}
	public Effet attaque_speciale() {
		Agilite += Niveau/2;
		System.out.println(Nom + " se concentre et gagne "+Niveau/2+" en agilité.");
		return new Effet("", 0, 0);
	}

}
