package pt.marquesmota;

public class Effet {
	private String Chaine;
	private int DommageSoi;
	private int DommageAutre;
	
	public Effet(String initChaine, int initDommageSoi, int initDommageAutre) {
		Chaine = initChaine;
		DommageSoi = initDommageSoi;
		DommageAutre = initDommageAutre;
	}
	public String getChaine() {
		return Chaine;
	}
	public int getDommageSoi() {
		return DommageSoi;
	}
	public int getDommageAutre() {
		return DommageAutre;
	}
}
