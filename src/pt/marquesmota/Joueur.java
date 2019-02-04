package pt.marquesmota;

public class Joueur {
	int Niveau, Vie, Force, Agilite, Intelligence;
	String Nom;
	
	public Joueur() {
		
	}
	
	public String getName() {
		return Nom;
	}
	
	public void setName(String nouveauNom) {
		Nom = nouveauNom;
	}
}
