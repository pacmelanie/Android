/*
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package modele;

import Vue.Activite;

/**
 * @author projet
 * 
 * TODO To change the template for this generated type comment go to Window -
 * Preferences - Java - Code Style - Code Templates
 */
public class MoteurDeCalcul extends Activite {
	private Labyrinthe laby;

	private Labyrinthe labyDemo;

	private boolean locked;

	private DroiteTrajectoire dt = new DroiteTrajectoire();

	private Plateau p = new Plateau();

	int i = 0;

	public MoteurDeCalcul(Labyrinthe laby, Labyrinthe labyDemo, Plateau p) {

		this.laby = laby;
		this.labyDemo = labyDemo;
		this.p = p;

	}

	/**
	 * calcul toute les 25 ms la position de la bille grace à la méthode
	 * movebille du labyrinthe.*
	 */
	protected void step() {
		if (locked = true) {
			locked = false;
			laby.moveBille(0.025f);
			if (labyDemo.isInitialize()) {

				i = 0;
				labyDemo.setInitialize(false);
			}

			labyDemo.autoMove(dt, i);
			p.automove(i);

			locked = true;
			i += 2;
		}

	}

	public Labyrinthe getLaby() {
		return laby;
	}

	public void setLaby(Labyrinthe laby) {
		this.laby = laby;
	}

	public boolean isLocked() {
		return locked;
	}

	public void setLocked(boolean locked) {
		this.locked = locked;
	}

	public Labyrinthe getLabyDemo() {
		return labyDemo;
	}

	public void setLabyDemo(Labyrinthe labyDemo) {
		this.labyDemo = labyDemo;
	}
}