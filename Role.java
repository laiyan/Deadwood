
/*
 * Team: Carroll, Cruz, Ng, Yung
 * CSCI 345: Deadwood Game Assignment
 * Summer 2017 
 * 
 * File: Role.java
 * Libraries used: org.w3c.dom (.Element, .Node, .NodeList)
 * 
 * Purpose: Maintains the attributes and behaviors of a role
 * 			Called in Extra, Player, Stage, Starring
 * 			Calls no classes
 *  
 */

import org.w3c.dom.*;


public abstract class Role {

	private String myName;
	private int myLevel;
	private String myLine;

	protected Role() {
		// myName = name;
		// myLevel = level;
		// myLine = line;
	}

	// Gets the name of the role
	public String getName() {
		return myName;
	}

	// Gets the level of the role
	public int getLevel() {
		return myLevel;
	}

	// Gets the line of the role
	public String getLine() {
		return myLine;
	}

	protected abstract Role clone();

	// Builds the role
	public Role build(Element element) {
		
		Role newRole 	= clone();
		newRole.myName  = element.getAttribute("name");
		newRole.myLevel = Integer.parseInt(element.getAttribute("level"));
		newRole.myLine  = null;
		NodeList lines  = element.getChildNodes();
		
		for (int i = 0; i < lines.getLength() && newRole.myLine == null; ++i) {
			Node n = lines.item(i);
			if (n.getNodeType() == Node.ELEMENT_NODE && n.getNodeName() == "line")
				newRole.myLine = n.getTextContent();
		}
		
		return newRole;
	}
}