
/*
 * Team: Carroll, Cruz, Ng, Yung
 * CSCI 345: Deadwood Game Assignment
 * Summer 2017 
 * 
 * File: Starring.java
 * Purpose: Refers to roles on the card (starring roles)
 * 			Extends Role class
 * 			Called in Card, Player class 
 * 
 */

public class Starring extends Role {
	
	public Starring() {
		super();
	}
	
	protected Role clone() {
		Role r = new Starring();
		return r;
	}
}
