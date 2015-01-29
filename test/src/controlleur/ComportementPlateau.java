/*
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package controlleur;

/**
 * @author valentin vincent melanie
 */

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import modele.Plateau;


/** Permet de changer les angles du plateau grace au clavier */
public class ComportementPlateau implements KeyListener {
	//Determine l' angle maximal de rotation du plateau
	private static final double MAXROT = 0.2;

	//Determine le pas de rotation du plateau
	private static final double STEPROT = 0.02;

	private Plateau plan;

	//3 angles de rotations qui determineront ceux du plateau
	private double aX;

	private double aY;

	private double aZ;

	/** créer un plateau par défaut */
	public float step() {
		double d = Math.random();
		if (d < 0.33)
			return (0.015f);
		else {
			if (d > 0.66)
				return (0.025f);
			else
				return (0.020f);
		}
	}

	public ComportementPlateau() {
	}

	
	public ComportementPlateau(Plateau plan) {
		this.plan = plan;
	}

	public void keyTyped(KeyEvent arg0) {

	}

	public void keyPressed(KeyEvent arg0) {
		switch (arg0.getKeyCode()) {
		case KeyEvent.VK_DOWN:
			if (aX < MAXROT) {
				aX += step();
				plan.setAnglex((float) aX);
			}
			break;
		case KeyEvent.VK_UP:
			if (aX > -MAXROT) {
				aX -= step();
				plan.setAnglex((float) aX);
			}
			break;
		case KeyEvent.VK_RIGHT:
			if (aY < MAXROT) {
				aY += step();
				plan.setAngley((float) aY);
			}
			break;
		case KeyEvent.VK_LEFT:
			if (aY > -MAXROT) {
				aY -= step();
				plan.setAngley((float) aY);
			}
			break;
		}

	}

	/**
	 * @return Retourne l'angle aX.
	 */
	public double getAX() {
		return aX;
	}

	/**
	 * @param ax Modifie l'angle aX.
	 */
	public void setAX(double ax) {
		aX = ax;
	}

	/**
	 * @return Retourne l'angle aY.
	 */
	public double getAY() {
		return aY;
	}

	/**
	 * @param ay Modifie l'angle aY.
	 */
	public void setAY(double ay) {
		aY = ay;
	}

	public void keyReleased(KeyEvent arg0) {

		// TODO Auto-generated method stub

	}

}
