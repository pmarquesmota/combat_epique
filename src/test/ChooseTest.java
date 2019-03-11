package test;

import java.io.ByteArrayOutputStream;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

import pt.marquesmota.*;

public class ChooseTest {
	
	/**
	 * Test the choice method with correct numerical input
	 */
	@Test
	public void test_choice_with_correct_input() {
		ByteArrayOutputStream baos = MyStream.RedirectStream("1\n");

		Game.s = new Scanner(System.in);

		int result = Choose.choice("Question", 1, 3);

		MyStream.ResetStream();

		assertEquals(baos.toString(),"Question\n");
		assertTrue(result == 1);
	}

	/**
	 * Test the choice method with incorrect numerical input
	 */
	@Test
	public void test_choice_with_incorrect_numeric_input() {
		ByteArrayOutputStream baos = MyStream.RedirectStream("10\n1\n");

		Game.s = new Scanner(System.in);

		int result = Choose.choice("Question", 1, 3);

		MyStream.ResetStream();

		assertEquals(baos.toString(),"Question\nChoix incorrect. Veuillez recommencer\nQuestion\n");
		assertTrue(result == 1);
	}

	/**
	 * Test the choice method with incorrect alphanumerical input
	 */
	@Test
	public void test_choice_with_incorrect_string_input() {
		ByteArrayOutputStream baos = MyStream.RedirectStream("a\n1\n");

		Game.s = new Scanner(System.in);

		int result = Choose.choice("Question", 1, 3);

		MyStream.ResetStream();

		assertEquals(baos.toString(),"Question\nChoix incorrect. Veuillez recommencer et saisir un nombre\nQuestion\n");
		assertTrue(result == 1);
	}
}














