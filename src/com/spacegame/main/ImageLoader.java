/**
 * 
 * - Buffered Image Loader
 * -   Loads all the image stuff and stores them in a buffer
 * -   blah
 *  @author Ché
 *  
 */

package com.spacegame.main;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageLoader {

	private BufferedImage image;
	
	
	/**
	 * Returns the image buffer
	 * @param path - string containing the path
	 * @return
	 */
	public BufferedImage load( String path ) {
		
		try {
			
			this.image = ImageIO.read( getClass().getResource( path ) );
			
		} catch (IOException e) { e.printStackTrace(); }
		
		return this.image;
	}
	
}
