/**
 * 
 * - Sprite Sheet Loader
 * -   All sprite sheet related stuff!
 * -   blah
 *  @author Ché
 *  
 */

package com.spacegame.main;

import java.awt.image.BufferedImage;

public class SpriteSheet {

	private BufferedImage image;
	
	
	public SpriteSheet( BufferedImage sheet ) {
		
		this.image = sheet;
		
	}
	
	/**
	 * Selects a sprite inside a sprite sheet
	 * @param line - line of the sprite ( between 1 and n )
	 * @param column - column of the sprite ( between 1 and n )
	 * @param imageWidth - sprite width
	 * @param imageHeight - sprite height
	 * @return the chopped up image
	 */
	public BufferedImage selectSprite( int line, int column, int imageWidth, int imageHeight ) {
		
		BufferedImage choppedImage = image.getSubimage( ( line*imageHeight ) - imageHeight , 
				( column*imageWidth ) - imageWidth, imageWidth, imageHeight );
		
		return choppedImage;
	}
}
