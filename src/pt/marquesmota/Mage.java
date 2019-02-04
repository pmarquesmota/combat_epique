package pt.marquesmota;

public class Mage extends Joueur{
	public Effet attaque_basique() {
		return new Effet("Boule de Feu", 0, Intelligence);
	}
	public Effet attaque_speciale() {
		int gain = Intelligence*2;
		Vie += gain;
		if(Vie > VieInitiale) {
			Vie = VieInitiale;
		}
		System.out.println(Nom+" se soigne et regagne "+gain+" points de vie");
		return new Effet("", 0, 0);
	}

}
