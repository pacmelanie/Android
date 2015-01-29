package Vue;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.media.j3d.Canvas3D;

import utils.Dessinateur;
import utils.Scene;

import com.sun.j3d.utils.universe.SimpleUniverse;


/**
 * Construction de la fenêtre de la vue de dessus de l'application, utilise la
 * fenêtre principale pour accéder à son labyrinthe
 */

public class VueDessus extends Frame implements WindowListener {

	private static final long serialVersionUID = 1L;

	private Scene myScene = new Scene();

	private Dessinateur d = new Dessinateur(myScene);

	VueDessus(VuePrincipale g) {
		super("Dessus");

		this.setLayout(new BorderLayout());

		// creation de la scene java3d
		Canvas3D canvas = new Canvas3D(SimpleUniverse
				.getPreferredConfiguration());

		SimpleUniverse myWorld = new SimpleUniverse(canvas);

		myWorld.getViewingPlatform().setNominalViewingTransform();

		d.drawBille(g.getBille(), g.getPlan(), g);
		d.drawPlan(g.getPlan(), g);
		d.drawMur(g.getMursx(), g.getMursy(), g.getPlan(), g);
		d.drawTrous(g.getTrous().getTrous());
		myWorld.addBranchGraph(myScene.GetScene());
		this.add("Center", canvas);
		VuePrincipale graph = g;

	}

	/**
	 * utilise la methode redrawbille du draftman pour déssiner la bille de la
	 * vue principale *
	 */
	public void redrawBille(VuePrincipale g) {

		d.reDrawBille2D(g.getBille());

	}

	/**
	 * utilise la methode redrawPlan du draftman pour déssiner la plan de la vue
	 * principale *
	 */
	public void redrawPlan(VuePrincipale g) {

		d.redrawPlan(g.getPlan());

	}

	/**
	 * utilise la methode redrawMur du draftman pour déssiner les murs de la vue
	 * principale *
	 */
	public void redrawMur(VuePrincipale g) {

		d.redrawMur(g.getMursx(), g.getMursy(), g.getPlan());
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
