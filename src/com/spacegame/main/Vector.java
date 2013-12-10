/**
 * 
 * - Vector Class
 * -   A simple vector class
 * -   blah
 *  @author Ché
 *  
 */

package com.spacegame.main;

public class Vector {

	private double x;
	private double y;
	
	
	/**
	 * Constructor of the vector
	 * @param x - double x
	 * @param y - double y
	 */
	public Vector( double x, double y ) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Constructor of the vector
	 * @param x - int x
	 * @param y - int y
	 */
	public Vector( int x, int y ) {
		
		this.x = x*1.0;
		this.y = y*1.0;
		
	}
	
	/**
	 * 
	 * @param other
	 * @return
	 */
	public Vector sub( Vector other ) {
		
		Vector temp = new Vector( this.x - other.x, this.y - other.y);
		return temp;
		
	}
	
	/**
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	public Vector sub( double x, double y ) {
		
		Vector temp = new Vector( this.x - x, this.y - y);
		return temp;
		
	}
	
	/**
	 * 
	 * @param other
	 * @return
	 */
	public Vector add( Vector other ) {
		
		Vector temp = new Vector( this.x + other.x, this.y + other.y);
		return temp;
		
	}
	
	/**
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	public Vector add( double x, double y ) {
		
		Vector temp = new Vector( this.x + x, this.y + y);
		return temp;
		
	}
	
	/**
	 * 
	 * @param factor
	 * @return
	 */
	public Vector mul( double factor ) {
		
		Vector temp = new Vector( this.x * factor, this.y * factor);
		return temp;
		
	}
	
	/**
	 * 
	 * @param factor
	 * @return
	 */
	public Vector div( double factor ) {
	
		Vector temp = new Vector( this.x / factor, this.y / factor);
		return temp;
	
	}
	
	/**
	 * 
	 * @param other
	 * @return
	 */
	public Vector director( Vector other ) {
		return other.sub( this );
	}
	
	/**
	 * 
	 * @return
	 */
	public double x() {
		return this.x;
	}
	
	/**
	 * 
	 * @return
	 */
	public double y() {
		return this.y;
	}
	
	
}
