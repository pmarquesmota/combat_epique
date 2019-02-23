package pt.marquesmota;

import java.util.Scanner;

public interface Game_interface {
	public Scanner getSc();
	public void setSc(Scanner sc);
	public int getClasse();
	public void setClasse(int classe);
	public int getNiveau();
	public void setNiveau(int niveau);
	public int getForce();
	public void setForce(int force);
	public int getAgilite();
	public void setAgilite(int agilite);
	public int getIntelligence();
	public void setIntelligence(int intelligence);
	public void start();
	public Joueur create_character(String nouveauNom);
	public void choose_character();
	public Joueur create_character_object(String nouveauNom);
}
