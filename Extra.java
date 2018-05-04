/*
 * Team: Carroll, Cruz, Ng, Yung
 * CSCI 345: Deadwood Game Assignment
 * Summer 2017 
 * 
 * File: Extra.java
 * 
 * Purpose: The player is working as an extra
 * 			Called in no classes
 * 			Inherits from Role class
 *   
 */

public class Extra extends Role {

	protected Role clone() {

		Role r = new Extra();
		return r;
	}

}
