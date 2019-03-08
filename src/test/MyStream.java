package test;

import java.io.*;

public class MyStream {
	public static PrintStream old;
	
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
	
	public static void ResetStream() {
		// Put things back
		System.out.flush();
		System.setOut(old);
	}
}
