package modele;

import java.util.ArrayList;

/**
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

/** Création de la liste "trous" composée  des trous du labyrinthe*/

public class Murs {

	private ArrayList mursx = new ArrayList();
	private ArrayList mursy = new ArrayList();

	public Murs() {
		Mur border1 = new Mur(new Point3D(0f, -0.1155f, 0f), 0.270f,0.041f);
		border1.setThickness(0.009f);
		mursx.add(border1);

		Mur border2 = new Mur(new Point3D(0f, 0.1155f, 0f), 0.270f,0.041f);
		border2.setThickness(0.009f);
		mursx.add(border2);

		Mur border3 = new Mur(new Point3D(-0.1305f, 0f, 0f), 0.240f,0.0405f);
		border3.setThickness(0.009f);
		mursy.add(border3);

		Mur border4 = new Mur(new Point3D(0.1305f, 0f, 0f), 0.240f, 0.0405f);
		border4.setThickness(0.009f);
		mursy.add(border4);
		mursy.add(new Mur(new Point3D(0.005099f, -0.005113f, 0f), 0.0204545f));
		mursy.add(new Mur(new Point3D(-0.01785f, -0.03579f, 0f), 0.0409090f));
		mursy.add(new Mur(new Point3D(-0.01785f, 0.06136f, 0f), 0.1022f));
		mursy.add(new Mur(new Point3D(0.005099f, 0.03835f, 0f), 0.01534f));
		mursy.add(new Mur(new Point3D(0.005099f, 0.06903f, 0f), 0.01534f));
		mursx.add(new Mur(new Point3D(-0.03825f, 0.046022f, 0f), 0.0459f));
		mursx.add(new Mur(new Point3D(-0.02805f, 0.07670f, 0f), 0.015299f));
		mursy.add(new Mur(new Point3D(-0.03825f, -0.02812f, 0f), 0.03068f));
		mursy.add(new Mur(new Point3D(-0.06375f, -0.06392f, 0f), 0.05113f));
		mursy.add(new Mur(new Point3D(-0.06375f, 0.0025f, 0f), 0.04090f));
		mursy.add(new Mur(new Point3D(-0.06375f, 0.06903f, 0f), 0.01022f));
		mursx.add(new Mur(new Point3D(-0.051f, -0.04090f, 0f), 0.02039f));
		mursx.add(new Mur(new Point3D(-0.056f, 0.00256f, 0f), 0.01019f));
		mursy.add(new Mur(new Point3D(-0.08415f, -0.084375f, 0f), 0.01022f));
		mursy.add(new Mur(new Point3D(-0.08415f, -0.03323f, 0f), 0.06136f));
		mursy.add(new Mur(new Point3D(-0.08415f, 0.04346f, 0f), 0.06136f));
		mursy.add(new Mur(new Point3D(-0.08415f, 0.104829f, 0f), 0.01534f));
		mursy.add(new Mur(new Point3D(-0.10965f, 0.104829f, 0f), 0.01534f));
		mursy.add(new Mur(new Point3D(-0.10965f, 0.06392f, 0f), 0.01534f));
		mursy.add(new Mur(new Point3D(-0.10965f, 0f, 0f), 0.061363f));
		mursx.add(new Mur(new Point3D(-0.11985f, -0.028125f, 0f), 0.015299f));
		mursx.add(new Mur(new Point3D(-0.0255f, -0.0946f, 0f), 0.0255f));
		mursx.add(new Mur(new Point3D(0.015299f, 0.0946f, 0f), 0.061199f));
		mursy.add(new Mur(new Point3D(0.02805f, -0.0102272f, 0f),0.06136364f));
        mursx.add(new Mur(new Point3D(0.015299f, -0.038352273f, 0f),0.020399f));
        mursy.add(new Mur(new Point3D(0.02805f, 0.053693183f, 0f),0.025568182f));
        mursx.add(new Mur(new Point3D(0.03825f, 0.043465912f, 0f),0.0152999f));
        mursy.add(new Mur(new Point3D(0.04845f, 0.035795458f, 0f),0.020454546f));
        mursy.add(new Mur(new Point3D(0.04845f, -0.007670455f, 0f),0.025568182f));
        mursy.add(new Mur(new Point3D(0.04845f, 0.084375f, 0f), 0.025568182f));
        mursy.add(new Mur(new Point3D(0.0050999997f, -0.07670455f, 0f),0.040909093f));
        mursy.add(new Mur(new Point3D(0.0255f, -0.086931825f, 0f),0.020454546f));
        mursx.add(new Mur(new Point3D(0.0357f, -0.05880682f, 0f),0.020399999f));
        mursy.add(new Mur(new Point3D(0.04845f, -0.07670455f, 0f),0.040909093f));
        mursx.add(new Mur(new Point3D(-0.07395f, 0.07670455f, 0f), 0.0255f));
        mursy.add(new Mur(new Point3D(0.07395f, 0.10482955f, 0f),0.01534091f));
        mursy.add(new Mur(new Point3D(0.07395f, 0.06903409f, 0f),0.01534091f));
        mursy.add(new Mur(new Point3D(0.07395f, 0.035795458f, 0f),0.010227273f));
        mursy.add(new Mur(new Point3D(0.07395f, -0.007670455f, 0f),0.025568182f));
        mursy.add(new Mur(new Point3D(0.07395f, -0.07414773f, 0f),0.01534091f));
        mursy.add(new Mur(new Point3D(0.094349995f, -0.06647727f, 0f),0.06136364f));
        mursx.add(new Mur(new Point3D(0.107099995f, -0.038352273f, 0f),0.020399999f));
        mursy.add(new Mur(new Point3D(0.092349995f, -0.010227273f, 0f),0.020454546f));
        mursy.add(new Mur(new Point3D(0.11075f, -0.010227273f, 0f),0.020454546f));
        mursy.add(new Mur(new Point3D(0.094349995f, 0.040909093f, 0f),0.040909093f));
        mursx.add(new Mur(new Point3D(0.107099995f, 0.023011364f, 0f),0.020399999f));
        mursy.add(new Mur(new Point3D(0.094349995f, 0.07926137f, 0f),0.01534091f));
        mursx.add(new Mur(new Point3D(0.12495f, 0.084375f, 0f), 0.010199999f));
        mursx.add(new Mur(new Point3D(0.12495f, 0.043465912f, 0f),0.010199999f));
        mursy.add(new Mur(new Point3D(0.07395f, -0.107386366f, 0f),0.01534091f));

	}
	
	
	

	/**
	 * @return Returns the mursx.
	 */
	public ArrayList getMursx() {
		return mursx;
	}
	/**
	 * @param mursx The mursx to set.
	 */
	public void setMursx(ArrayList mursx) {
		this.mursx = mursx;
	}
	/**
	 * @return Returns the mursy.
	 */
	public ArrayList getMursy() {
		return mursy;
	}
	/**
	 * @param mursy The mursy to set.
	 */
	public void setMursy(ArrayList mursy) {
		this.mursy = mursy;
	}
}
