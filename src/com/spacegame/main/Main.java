/**
 * 
 * - Main file for the game!
 * -   Every main stuff is made here :p
 * -   blah
 *  @author Ché
 *  
 */

/*
 * 
 * IMPORTS AND PACKAGES
 * 
 */
package com.spacegame.main;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

/*
 * 
 * CLASSES 'N STUFF
 * 
 */
public class Main extends Canvas implements Runnable {

	
	// IMPORT GENERATED STUFF
	private static final long serialVersionUID = 1L;
	
	// WINDOW STUFF
	public static final int WINDOW_WIDTH  = 320;
	public static final int WINDOW_HEIGHT = 200;
	public static final int WINDOW_SCALE  = 2;
	public static boolean resizableWindow = false;
	public static boolean visibleWindow   = true;
	
	// GAME STUFF
	public static final int MAXIMUM_SPRITESHEETS = 10;
	public static String NAME = "Space Game v1";
	
	private boolean gameRunning = false;
	private Thread thread;
	
	// GRAPHICS AND BUFFERS
	private BufferedImage graphicImage = new BufferedImage( WINDOW_WIDTH, WINDOW_HEIGHT, BufferedImage.TYPE_INT_RGB );
	private BufferedImage spriteSheet[] = new BufferedImage[MAXIMUM_SPRITESHEETS];
	
	
	/**
	 *
	 *  ** GAME METHODS **
	 * 
	 */
	
	// GAME LOOP, START AND END
	public void run() {
		
		// INIT GAME
		initialize();
		//-----------
		
		long lastTime 		= System.nanoTime(); 	// TIME PASSED IN NANO SECONDS
		final double ticks 	= 60.0; 				// FRAMES PER SECOND -> FPS
		double nSec			= 1000000000 / ticks;   // NANO SECONDS
		double deltaTime    = 0;					// TIME PASSED
		
		int frames = 0;   // FRAME COUNT
		int tick = 0;     // TICK COUNT
		
		long timer = System.currentTimeMillis(); // TIMER COUNTER
		
		// Main while loop
		while ( gameRunning ) {
			
			long currentTime = System.nanoTime();
			
			deltaTime += ( currentTime - lastTime ) / nSec;
			lastTime = currentTime;
			
			if ( deltaTime >= 1 ) {
				update( deltaTime );
				
				tick++;
				timer++;
				
				deltaTime--;
			}
			render();
			frames++;
			
			if ( System.currentTimeMillis() - timer >= 1000 ) {
				timer += 1000;
				
				System.out.println("FPS: " + frames + " || Ticks: " + ticks);
				tick = 0;
				frames = 0;
			}
			
			
		}
		end();
	}
	
	private synchronized void start() {
		if ( gameRunning )
			return;
		
		gameRunning = true;
		
		// initialize thread
		thread = new Thread( this );
		thread.start();
	}
	
	private synchronized void end() {
		
		if ( !gameRunning )
			return;
		
		gameRunning = false;
		
		try {
			
			thread.join();
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// closes it up
		System.exit( 1 );
		
	}
	
	// GAME UPDATE AND RENDER
	
	private void update( double dt ) {
		
	}
	
	private void render() {
		
		BufferStrategy buffer = this.getBufferStrategy();
		
		if ( buffer == null ) {
			
			createBufferStrategy( 3 ); // CREATES 3 BUFFERS
			return;
			
		}
		
		Graphics g = buffer.getDrawGraphics();
		
		/*
		 * DRAW STUFF HERE 
		 */
		
		g.drawImage( graphicImage, 0, 0, getWidth(), getHeight(), this );
		
		draw(g);
		
		/***********/
		
		g.dispose();
		buffer.show();
		
	}
	
	// GAME INITIALIZATION
	
	private void initialize() {
		
		ImageLoader loader = new ImageLoader();
		
		spriteSheet[0] = loader.load("/sprite_ships_small.png");
		
	}
	
	// MAIN METHOD
	public static void main( String args[] ) {
		
		Main game = new Main();
		
		// Window stuff
		JFrame windowFrame = new JFrame(NAME);
		
		Dimension windowSize = new Dimension( WINDOW_WIDTH * WINDOW_SCALE, WINDOW_HEIGHT * WINDOW_SCALE );
		game.setPreferredSize( windowSize );
		game.setMaximumSize( windowSize );
		game.setMinimumSize( windowSize );
		
		windowFrame.add( game );
		windowFrame.pack();
		windowFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		windowFrame.setResizable( resizableWindow );
		windowFrame.setLocationRelativeTo( null );
		windowFrame.setVisible( visibleWindow );
		
		
		
		
		// GAME START
		game.start();
	}
	
	// DRAW METHOD
	public static void draw(Graphics g) {
		
		
	}
	
}