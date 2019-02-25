package test;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

import pt.marquesmota.*;

public class ChooseTest {
	@Test
	public void test_choice_with_correct_input() {
		// Create a stream to hold the output
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		// IMPORTANT: Save the old System.out!
		PrintStream old = System.out;
		// Tell Java to use our special stream
		System.setOut(ps);

		Scanner s = new Scanner(System.in);
		Game.setSc(s);

		System.setIn(new ByteArrayInputStream("1\n".getBytes()));
		int result = Choose.choice("Question", 1, 3);

		// Put things back
		System.out.flush();
		System.setOut(old);

		assertEquals(baos.toString(),"Question\n");
		assertTrue(result == 1);
	}

	@Test
	public void test_choice_with_incorrect_numeric_input() {
		// Create a stream to hold the output
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		// IMPORTANT: Save the old System.out!
		PrintStream old = System.out;
		// Tell Java to use our special stream
		System.setOut(ps);

		System.setIn(new ByteArrayInputStream("10\n1\n".getBytes()));
		Scanner s = new Scanner(System.in);
		Game.setSc(s);

		int result = Choose.choice("Question", 1, 3);

		// Put things back
		System.out.flush();
		System.setOut(old);

		assertEquals(baos.toString(),"Question\nChoix incorrect. Veuillez recommencer\nQuestion\n");
		assertTrue(result == 1);
	}

	@Test
	public void test_choice_with_incorrect_string_input() {
		// Create a stream to hold the output
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		// IMPORTANT: Save the old System.out!
		PrintStream old = System.out;
		// Tell Java to use our special stream
		System.setOut(ps);

		System.setIn(new ByteArrayInputStream("a\n1\n".getBytes()));
		Scanner s = new Scanner(System.in);
		Game.setSc(s);

		int result = Choose.choice("Question", 1, 3);

		// Put things back
		System.out.flush();
		System.setOut(old);

		assertEquals(baos.toString(),"Question\nChoix incorrect. Veuillez recommencer et saisir un nombre\nQuestion\n");
		assertTrue(result == 1);
	}
}














