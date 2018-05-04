/*
 * Team: Carroll, Cruz, Ng, Yung
 * CSCI 345: Deadwood Game Assignment
 * Summer 2017 
 * 
 * File: Card.java
 * Libraries used: org.w3c.dom.Element, org.w3c.dom.NodeList
 * 
 * Purpose: Contains the attributes and behaviors for a movie card object
 * 			Called in the Deadwood, Player, and Stage classes
 * 			Calls the Starring class
 * 
 */

import org.w3c.dom.*;
import javax.swing.*;
public class Card {

	// -------------------------- Attributes ------------------------------------

	private String name;
	private String budget;
	private JLabel img;								
	private JLabel cardBack;
	private int n_scene;
	private NodeList sceneLine;
   private int x;
   private int y;						
	
	private Starring[] starrings;

	private boolean is_used = false;
	

	// --------------------------------------------------------------------------

	// -------------------------- Constructor -----------------------------------

	public Card(Element card) {
		
		this.name 		= card.getAttribute("name");
		this.budget 	= card.getAttribute("budget");
		//this.img 		= card.getAttribute("img");
		
		this.sceneLine 	= card.getElementsByTagName("scene");
		Element scene 	= (Element) card.getElementsByTagName("scene").item(0);
		this.n_scene 	= Integer.parseInt(scene.getAttribute("number"));
		
		setParts(card);

	}

	// --------------------------------------------------------------------------

	// Returns the name of the movie
	public String getName() {
		return this.name;
	}
	
	// Returns the budget of the movie
	public String getBudget() {
		return this.budget;
	}

	// Returns an array of starring roles
	public Starring[] getStarrings() {
		return starrings;
	}
	
	// Returns the card's status if it has been used or not
	public boolean get_is_used() {
		return is_used;
	}
	
	// Returns the number of scenes for a movie
	public int getNumOfScene() {
		return n_scene;
	}
	
	// Returns the img of the movie
	public JLabel getImg () {
		return img;
	}
   
   public void setImg(JLabel s){
      this.img = s;
   }
   
   public void setCardBack(JLabel j){
      this.cardBack = j;
   }
	
	// Returns the sceneLine of the movie
	public NodeList getSceneLine() {
		return sceneLine;
	}
	
	// Sets the card's status as it has been used
	public void set_is_used(boolean b) {
		this.is_used = b;
	}
	
	// Sets the individual parts of the card
	private void setParts(Element card) {

		NodeList parts	= card.getElementsByTagName("part");
		Starring[] temp = new Starring[parts.getLength()];
		
		for (int i = 0; i < parts.getLength(); i++) {
			
			Starring s = new Starring();
			// System.out.println(((Element)parts.item(0)).getAttribute("name"));
			temp[i] = (Starring) s.build((Element) parts.item(i));
			
		}
		this.starrings = temp;
	}

	
}
