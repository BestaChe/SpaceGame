/**
 * 
 * - Player class
 * -   player WOOOOOOO
 * -   blah
 *  @author Ché
 *  
 */

package com.spacegame.main;

public class Player {
	
	private Vector pos;
	private double posX;
	private double posY;
	
	public Player( Vector pos, Main game ) {
		
		this.pos = pos;
		this.posX = this.pos.x();
		this.posY = this.pos.y();
		
	}
	
	public Player( double x, double y, Main game ) {
		
		this.pos = new Vector( x, y );
		this.posX = x;
		this.posY = y;
		
	}

}
