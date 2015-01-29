/*
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package main;
import java.awt.Dimension;
import java.io.IOException;

import Vue.AppliLaby;


public class Main {
	

	public static void main(String[] args) throws SecurityException, IOException {
		Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();

		
		AppliLaby myApp = new AppliLaby();
		
        
		myApp.getG().setSize((int) (screenSize.width*(0.6666)),screenSize.height);
		myApp.getG().setLocation(0,0);
        
		myApp.getVd().setSize((int) (screenSize.width*(0.3333)),screenSize.height/2);
		myApp.getVd().setVisible(true);
		myApp.getVd().setLocation((int) (screenSize.width*(0.6666)),0);
        
		
		
		myApp.getVdemo().setSize((int) (screenSize.width*(0.3333)),screenSize.height/2);
		myApp.getVdemo().setVisible(true);
		myApp.getVdemo().setLocation((int) (screenSize.width*(0.6666)),screenSize.height/2);
		
		myApp.getG().setVisible(true);

		
		myApp.start();
		
	}
}
