package pt.marquesmota;

public class Effet {
	private String Nom;
	private int DommageSoi;
	private int DommageAutre;
	
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
