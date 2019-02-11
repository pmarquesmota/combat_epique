package pt.marquesmota;

import java.util.Scanner;

public class Choose {
	public static int choice(String question, int minimum, int maximum) {
		int i;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println(question);
			i = sc.nextInt();
			if (i<minimum || i>maximum) {
				System.out.println("Choix incorrect. Veuillez recommencer");
			}
		} while (i<minimum || i>minimum);
		return i;
	}
}
