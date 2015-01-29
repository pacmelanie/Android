
package modele;

import java.util.ArrayList;

/** Création des listes "Mur" et "MurY" des murs du labyrinthe */
public class Trous {

	private ArrayList trous = new ArrayList();

	public Trous() {
		trous.add(new Trou(new Point3D(-0.0969f, -0.09460227f, 0)));
		trous.add(new Trou(new Point3D(-0.1122f, -0.07926137f, 0)));
		trous.add(new Trou(new Point3D(-0.07395f, -0.05880682f, 0)));
		trous.add(new Trou(new Point3D(-0.094349995f, -0.05880682f, 0)));
		trous.add(new Trou(new Point3D(-0.1173f, -0.040909093f, 0)));
		trous.add(new Trou(new Point3D(-0.0255f, -0.10482955f, 0)));
		trous.add(new Trou(new Point3D(-0.0255f, -0.084375f, 0)));
		trous.add(new Trou(new Point3D(-0.02805f, -0.040909093f, 0)));
		trous.add(new Trou(new Point3D(-0.0050999997f, -0.06392045f, 0)));
		trous.add(new Trou(new Point3D(0.015299999f, -0.086931825f, 0)));
		trous.add(new Trou(new Point3D(0.06375f, -0.10227273f, 0)));
		trous.add(new Trou(new Point3D(0.03825f, -0.048579548f, 0)));
		trous.add(new Trou(new Point3D(0.05865f, -0.048579548f, 0)));
		trous.add(new Trou(new Point3D(0.08415f, -0.074147737f, 0)));
		trous.add(new Trou(new Point3D(0.10455f, -0.092045456f, 0)));
		trous.add(new Trou(new Point3D(0.10455f, -0.048579548f, 0)));
		trous.add(new Trou(new Point3D(0.119849995f, -0.06947727f, 0)));
		trous.add(new Trou(new Point3D(0.081599995f, -0.028125f, 0)));
		trous.add(new Trou(new Point3D(0.12139999f, -0.012784091f, 0)));
		trous.add(new Trou(new Point3D(0.061199997f, -0.0025568183f, 0)));
		trous.add(new Trou(new Point3D(0.08415f, 0.010227273f, 0)));
		trous.add(new Trou(new Point3D(0.061199997f, 0.035795458f, 0)));
		trous.add(new Trou(new Point3D(0.015299999f, 0.038352273f, 0)));
		trous.add(new Trou(new Point3D(0.061199997f, 0.06903409f, 0)));
		trous.add(new Trou(new Point3D(0.08415f, 0.06903409f, 0)));
		trous.add(new Trou(new Point3D(0.102f, 0.06647727f, 0)));
		trous.add(new Trou(new Point3D(0.119849995f, 0.09971591f, 0)));
		trous.add(new Trou(new Point3D(-0.0076499996f, 0.084375f, 0)));
		trous.add(new Trou(new Point3D(-0.0076499996f, -0.0051136366f, 0)));
		trous.add(new Trou(new Point3D(-0.02805f, 0.035795458f, 0)));
		trous.add(new Trou(new Point3D(-0.030599998f, 0.06392045f, 0)));
		trous.add(new Trou(new Point3D(-0.030599998f, 0.10482955f, 0)));
		trous.add(new Trou(new Point3D(-0.053549998f, 0.012784091f, 0)));
		trous.add(new Trou(new Point3D(-0.07395f, 0.017897729f, 0)));
		trous.add(new Trou(new Point3D(-0.07395f, 0.06136364f, 0)));
		trous.add(new Trou(new Point3D(-0.07395f, 0.097159095f, 0)));
		trous.add(new Trou(new Point3D(-0.0969f, 0.025568182f, 0)));
		trous.add(new Trou(new Point3D(-0.09945f, 0.097159095f, 0)));
		trous.add(new Trou(new Point3D(-0.1122f, 0.081818186f, 0)));

	}

	public ArrayList getTrous() {
		return trous;
	}

	public void setTrous(ArrayList trous) {
		this.trous = trous;
	}
}
