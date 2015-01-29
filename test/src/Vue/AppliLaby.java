
package Vue;

import java.io.FileWriter;
import java.io.IOException;

import modele.MoteurDeCalcul;

public class AppliLaby extends Activite {

	private VueDemo vdemo = new VueDemo();

	private VuePrincipale g = new VuePrincipale();

	private VueDessus vd = new VueDessus(g);

	private FileWriter writer;

	private MoteurDeCalcul mc = new MoteurDeCalcul(g.getBille(), vdemo
			.getBille(), vdemo.getPlan());

	private boolean creer = true;

	private int i = 0;

	public AppliLaby() throws IOException {

		super();

		this.setPeriod(0.1f);
		mc.start();
	}

	/**
	 * utilise le dessinateur pour rafraichir le plan, la bille, les trous et
	 * les murs dans les différentes vues.
	 * 
	 * @throws IOException
	 * @throws IOException
	 */
	protected void step() throws IOException {

		if (mc.isLocked()) {
			vdemo.getD().redrawPlan(vdemo.getPlan());
			vdemo.getD().redrawMur(vdemo.getMurs().getMursx(),
					vdemo.getMurs().getMursy(), vdemo.getPlan());
			vdemo.getD().redrawTrous(vdemo.getTrous().getTrous(),
					vdemo.getPlan());
			vdemo.getD().reDrawBille(vdemo.getBille(), vdemo.getPlan());

			g.getD().reDrawBille(g.getBille(), g.getPlan());
		}
		g.getD().redrawPlan(g.getPlan());
		g.getD().redrawMur(g.getMursx(), g.getMursy(), g.getPlan());
		g.getD().redrawTrous(g.getTrous().getTrous(), g.getPlan());
		vd.redrawBille(g);

	}

	/**
	 * @return Returns the g.
	 */
	public VuePrincipale getG() {
		return g;
	}

	/**
	 * @param g
	 *            The g to set.
	 */
	public void setG(VuePrincipale g) {
		this.g = g;
	}

	/**
	 * @return Returns the vd.
	 */
	public VueDessus getVd() {
		return vd;
	}

	/**
	 * @param vd
	 *            The vd to set.
	 */
	public void setVd(VueDessus vd) {
		this.vd = vd;
	}

	/**
	 * @return Returns the vdemo.
	 */
	public VueDemo getVdemo() {
		return vdemo;
	}

	/**
	 * @param vdemo
	 *            The vdemo to set.
	 */
	public void setVdemo(VueDemo vdemo) {
		this.vdemo = vdemo;
	}
}
