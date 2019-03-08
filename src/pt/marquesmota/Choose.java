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
		int line = 0;
		
		do {
			try {
				System.out.println(question);
				line = Game.s.nextInt();
				if (line < minimum || line > maximum) {
					System.out.println("Choix incorrect. Veuillez recommencer");
				}
			} catch(Exception e) {
				System.out.println("Choix incorrect. Veuillez recommencer et saisir un nombre");
				//Flush line before reading another
				if(Game.s.hasNextLine()) {
					Game.s.nextLine();
				}
				line = 0;
			}
		} while (line < minimum || line > maximum);
		return line;
	}
}
