
/*
 * Team: Carroll, Cruz, Ng, Yung
 * CSCI 345: Deadwood Game Assignment
 * Summer 2017 
 * 
 * File: Trailer.java
 * Purpose: Constructs a Trailer. Used when starting the game and each round
 * 			Extends Room class
 * 			Called in Room class
 */

import org.w3c.dom.Element;

public class Trailer extends Room {
	
	// Constructor
	public Trailer(Element e) {
		super("Trailer");
	}

	public static Trailer build(Element e) {
		Trailer t = new Trailer(e);
		return t;
	}
}
