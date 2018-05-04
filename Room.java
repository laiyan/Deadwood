/*
 * Team: Carroll, Cruz, Ng, Yung
 * CSCI 345: Deadwood Game Assignment
 * Summer 2017 
 * 
 * File: Room.java
 * Libraries: org.w3c.dom (.Element, .NodeList)
 * 
 * Purpose: Maintains attributes and behaviors of Room object
 * 			Calls Stage, Trailer, Card, Role classes
 * 			Called in Deadwood, Player, Stage, Trailer classes
 * 
 */



import java.util.ArrayList;
import org.w3c.dom.*;

public abstract class Room {
	
	// Attributes
	private ArrayList<String> adjacentRooms;
	protected String name;

	
	// Constructor
	public Room(String roomName) {
		this.name = roomName;
	}

	// Builds Room object depending on if it is a movie set, the trailer, or casting office
	public static Room build(Element e) {
		Room r = null;
		switch (e.getTagName()) {
		
		case "set":
			r = Stage.build(e);
			r.adjacentRooms = XMLAdjacentRooms(e);
			break;
		
		case "trailer":
			r = Trailer.build(e);
			r.adjacentRooms = XMLAdjacentRooms(e);
			break;
		
		case "office":
			r = CastingOffice.build(e);
			r.adjacentRooms = XMLAdjacentRooms(e);
			break;
		}
		
		return r;
	}

	// Constructs an ArrayList containing all adjacent rooms to a room
	public static ArrayList<String> XMLAdjacentRooms(Element e) {
		ArrayList<String> list = new ArrayList<String>();
		NodeList neighbors 	   = e.getElementsByTagName("neighbor");
		
		for (int i = 0; i < neighbors.getLength(); i++) {
			Element neighbor = (Element) neighbors.item(i);
			list.add(neighbor.getAttribute("name"));
		}
		
		return list;
	}

	// Gets an ArrayList of all adjacent rooms
	public ArrayList<String> getAdjacentRooms() {
		return adjacentRooms;
	}

	// Gets name of room
	public String getroomName() {
		return name;
	}
}