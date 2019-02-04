package pt.marquesmota;

public class Effet {
	public String Nom;
	public int DommageSoi;
	public int DommageAutre;
	
	public Effet(String initNom, int initDommageSoi, int initDommageAutre) {
		Nom = initNom;
		DommageSoi = initDommageSoi;
		DommageAutre = initDommageAutre;
	}
	public String getNom() {
		return Nom;
	}
	public int getDommageSoi() {
		return DommageSoi;
	}
	public int getDommageAutre() {
		return DommageAutre;
	}
}
