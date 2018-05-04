/*
 * Team: Carroll, Cruz, Ng, Yung
 * CSCI 345: Deadwood Game Assignment
 * Summer 2017 
 * 
 * File: CastingOffice.java
 * Libraries used: java.util.HashMap, java.util.Map, org.w3c.dom.Element, org.w3c.dom.Node, org.w3c.dom.NodeList
 * 
 * Purpose: Manages upgrading functions for either dollars or credits at the Casting Office room
 * 			Called in Player, Room classes
 * 			Calls no classes
 * 
 */

import java.util.*;
import org.w3c.dom.*;


public class CastingOffice extends Room {
	
	// -------------------------- Attributes ------------------------------------
		
	private Map<Integer, Integer> dollarList = new HashMap<Integer, Integer>();
	private Map<Integer, Integer> creditList = new HashMap<Integer, Integer>();
	
	// --------------------------------------------------------------------------

	// -------------------------- Constructor -----------------------------------

	public static CastingOffice build(Element e) {
		CastingOffice c = new CastingOffice(e);
		return c;
	}

	public CastingOffice(Element e) {
		super("Office");
		setDollarList(e);
		setCreditList(e);
	}
	
	// --------------------------------------------------------------------------

	// Returns the amount of dollars required for upgrading
	// Variable x is the desired rank to upgrade to
	public int getDollar(int x) {
		return this.dollarList.get(x);
	}

	// Gets the amount of credits required for upgrading
	// Variable x is the desired rank to upgrade to
	public int getCredit(int x) {
		return this.creditList.get(x);
	}

	// Adds keys with values for upgrading to a rank using dollars
	private void setDollarList(Element e) {
		
		NodeList upgrades = e.getElementsByTagName("upgrades").item(0).getChildNodes();
		
		for (int i = 0; i < upgrades.getLength(); ++i) {
			
			if (upgrades.item(i).getNodeType() == Node.ELEMENT_NODE) {
				Element upgrade = (Element) upgrades.item(i);
				
				if (upgrade.getAttribute("currency").equals("dollar")) {
					
					this.dollarList.put(Integer.parseInt(upgrade.getAttribute("level")),
										Integer.parseInt(upgrade.getAttribute("amt")));
				
				}
			
			}
		
		}
	}

	// Adds keys wih values for upgrading to a rank using credits
	private void setCreditList(Element e) {
		
		NodeList upgrades = e.getElementsByTagName("upgrades").item(0).getChildNodes();
		
		for (int i = 0; i < upgrades.getLength(); ++i) {
			
			if (upgrades.item(i).getNodeType() == Node.ELEMENT_NODE) {
				Element upgrade = (Element) upgrades.item(i);
				
				if (upgrade.getAttribute("currency").equals("credit")) {
					
					this.creditList.put(Integer.parseInt(upgrade.getAttribute("level")),
										Integer.parseInt(upgrade.getAttribute("amt")));
				
				}
			
			}
		
		}
	}
}