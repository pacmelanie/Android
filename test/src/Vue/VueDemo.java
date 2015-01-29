
package Vue;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.media.j3d.Canvas3D;

import modele.DroiteTrajectoire;
import modele.Labyrinthe;
import modele.Murs;
import modele.Plateau;
import modele.Trous;
import utils.Scene;

import utils.Dessinateur;

import com.sun.j3d.utils.universe.SimpleUniverse;

import controlleur.ComportementPlateau;

/**
 * TODO To change the template for this generated type comment go to Window -
 * Preferences - Java - Code Style - Code Templates
 */
public class VueDemo

extends Frame implements WindowListener {

	private static final long serialVersionUID = 1L;

	private Scene myScene = new Scene();

	private Dessinateur d = new Dessinateur(myScene);

	private Plateau plan = new Plateau();

	private Labyrinthe bille;

	private DroiteTrajectoire dt = new DroiteTrajectoire();

	private ComportementPlateau bp = new ComportementPlateau();

	private Trous trous = new Trous();

	private Murs murs = new Murs();
	/** C' est la vue ou la bille se déplace automatiquement*/
	VueDemo() {
		super("Demo");

		this.setLayout(new BorderLayout());

		// creation de la scene java3d
		Canvas3D canvas = new Canvas3D(SimpleUniverse
				.getPreferredConfiguration());

		SimpleUniverse myWorld = new SimpleUniverse(canvas);

		myWorld.getViewingPlatform().setNominalViewingTransform();

		this.bille = new Labyrinthe(plan, bp, murs.getMursx(), murs.getMursy(),
				trous.getTrous());
		d.drawBille(bille, plan, this);
		d.drawPlan(plan, this);
		d.drawMur(murs.getMursx(), murs.getMursy(), plan, this);
		d.drawTrous(trous.getTrous());
		myWorld.addBranchGraph(myScene.GetScene());
		this.add("Center", canvas);

	}

	/**
	 * @return Returns the d.
	 */
	public Dessinateur getD() {
		return d;
	}

	/**
	 * @param d
	 *            The d to set.
	 */
	public void setD(Dessinateur d) {
		this.d = d;
	}

	public Labyrinthe getBille() {
		return bille;
	}

	public void setBille(Labyrinthe bille) {
		this.bille = bille;
	}

	/**
	 * @return Returns the dt.
	 */
	public DroiteTrajectoire getDt() {
		return dt;
	}

	/**
	 * @param dt
	 *            The dt to set.
	 */
	public void setDt(DroiteTrajectoire dt) {
		this.dt = dt;
	}

	/**
	 * @return Returns the plan.
	 */
	public Plateau getPlan() {
		return plan;
	}

	/**
	 * @param plan
	 *            The plan to set.
	 */
	public void setPlan(Plateau plan) {
		this.plan = plan;
	}

	/**
	 * @return Returns the trous.
	 */
	public Trous getTrous() {
		return trous;
	}

	/**
	 * @param trous
	 *            The trous to set.
	 */
	public void setTrous(Trous trous) {
		this.trous = trous;
	}

	/**
	 * @return Returns the murs.
	 */
	public Murs getMurs() {
		return murs;
	}

	/**
	 * @param murs
	 *            The murs to set.
	 */
	public void setMurs(Murs murs) {
		this.murs = murs;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.event.WindowListener#windowOpened(java.awt.event.WindowEvent)
	 */
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.event.WindowListener#windowClosing(java.awt.event.WindowEvent)
	 */
	public void windowClosing(WindowEvent arg0) {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.event.WindowListener#windowClosed(java.awt.event.WindowEvent)
	 */
	public void windowClosed(WindowEvent arg0) {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.event.WindowListener#windowIconified(java.awt.event.WindowEvent)
	 */
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.event.WindowListener#windowDeiconified(java.awt.event.WindowEvent)
	 */
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.event.WindowListener#windowActivated(java.awt.event.WindowEvent)
	 */
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.event.WindowListener#windowDeactivated(java.awt.event.WindowEvent)
	 */
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	/**
	 * @param g
	 */
}
