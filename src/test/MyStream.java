package test;

import java.io.*;

/**
 * Methods related to the input and output redirection
 * @author Paul Marques Mota (pmarquesmota@gmail.com)
 *
 */
public class MyStream {
	public static PrintStream old;
	
	/**
	 * Redirect the input and output to a String.
	 * @param s The String to feed to the input Stream
	 * @return A ByteArrayOutputStream containing the String from the redirected output
	 */
	public static ByteArrayOutputStream RedirectStream(String s) {
		System.setIn(new ByteArrayInputStream(s.getBytes()));
		
		// Create a stream to hold the output
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		// IMPORTANT: Save the old System.out!
		old = System.out;
		// Tell Java to use our special stream
		System.setOut(ps);

		return baos;
	}
	
	/**
	 * Reset the output stream back to its normal state.
	 */
	public static void ResetStream() {
		// Put things back
		System.out.flush();
		System.setOut(old);
	}
}
