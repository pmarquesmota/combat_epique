package pt.marquesmota;

import java.util.Scanner;

/**
 * Class for handling the choices asked to the player
 * @author      Paul Marques Mota (pmarquesmota@gmail.com)
 * @version     1.0
 */
public class Choose {
	/**
     * Given a question, a minimum number and a maximum number, it returns a number between the minimum and the maximum. 
	 * @param question The question asked.
	 * @param minimum The minimum number that can be accepted.
	 * @param maximum The maximum number that can be accepted.
	 * @return The number chosen by the user.
	 */
	public static int choice(String question, int minimum, int maximum) {
		int i = 0;
		Scanner s = Game.getSc();
		do {
			try {
				System.out.println(question);
				i = s.nextInt();
				if (i<minimum || i>maximum) {
					System.out.println("Choix incorrect. Veuillez recommencer");
				}
			} catch(Exception e) {
				System.out.println("Choix incorrect. Veuillez recommencer et saisir un nombre");
				//On vide la ligne avant d'en lire une autre
				if(s.hasNextLine()) {
					s.nextLine();
				}
				i=0;
			}
		} while (i<minimum || i>maximum);
		return i;
	}
}
