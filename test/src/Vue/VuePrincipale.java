package Vue;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import javax.media.j3d.Canvas3D;
import utils.Dessinateur;
import modele.Labyrinthe;
import modele.Murs;
import modele.Trous;
import modele.Plateau;
import utils.Scene;
import com.sun.j3d.utils.universe.SimpleUniverse;
import controlleur.ComportementPlateau;

/** Ceci est la fenêtre principale du labyrinthe */

public class VuePrincipale extends Frame implements WindowListener {

	private static final long serialVersionUID = 1L;

	private Scene myScene = new Scene();

	private Plateau plan = new Plateau();

	private Murs murs = new Murs();

	private ComportementPlateau behav = new ComportementPlateau(plan);

	private Trous trous = new Trous();

	private Labyrinthe bille = new Labyrinthe(plan, behav, murs.getMursx(),
			murs.getMursy(), trous.getTrous());

	private Dessinateur d = new Dessinateur(myScene);

	VuePrincipale() {
		super("Labyrinthe Java3D");

		this.addWindowListener(this);

		this.setLayout(new BorderLayout());

		// creation de la scene java3d
		Canvas3D canvas = new Canvas3D(SimpleUniverse
				.getPreferredConfiguration());
		canvas.addKeyListener(behav);

		SimpleUniverse myWorld = new SimpleUniverse(canvas);
		d.view(myWorld);
		d.drawBille(bille, plan, this);
		d.drawPlan(plan, this);
		d.drawMur(murs.getMursx(), murs.getMursy(), plan, this);
		d.drawTrous(trous.getTrous());
		myWorld.addBranchGraph(myScene.GetScene());
		this.add("Center", canvas);

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
	 * @return Returns the bille.
	 */
	public Labyrinthe getBille() {
		return bille;
	}

	/**
	 * @param bille
	 *            The bille to set.
	 */
	public void setBille(Labyrinthe bille) {
		this.bille = bille;
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

	/**
	 * @return Returns the mursx.
	 */
	public ArrayList getMursx() {
		return murs.getMursx();
	}

	public ArrayList getMursy() {
		return murs.getMursy();
	}

	public Trous getTrous() {
		return trous;
	}

	public void setTrous(Trous trous) {
		this.trous = trous;
	}

	public void windowActivated(WindowEvent e) {
	}

	public void windowClosed(WindowEvent e) {
	}

	public void windowDeactivated(WindowEvent e) {
	}

	public void windowDeiconified(WindowEvent e) {
	}

	public void windowIconified(WindowEvent e) {
	}

	public void windowOpened(WindowEvent e) {
	}

	public void windowClosing(WindowEvent e) {
		System.exit(1);
	}

}
