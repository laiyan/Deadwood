/*
 * Team: Carroll, Cruz, Ng, Yung
 * CSCI 345: Deadwood Game Assignment
 * Summer 2017 
 * 
 * File: DiceRoll.java
 * Purpose: 
 * 
 */

import java.util.Random;

public class DiceRoll {

	public static int RollDice() {
		
		Random rand = new Random();
		return (rand.nextInt(6) + 1);

	}
}
