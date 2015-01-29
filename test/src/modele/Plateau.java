package modele;

/**
 * TODO To change the template for this generated type comment go to Window -
 * Preferences - Java - Code Style - Code Templates
 */
public class Plateau {

	private float anglex;

	private float angley;

	private float anglez;

	private float longueur;

	private float largeur;

	private DroiteTrajectoire dt = new DroiteTrajectoire();

	public Plateau() {
		anglex = 0;
		angley = 0;
		anglez = 0;
	}

	public void move(float _anglex, float _angley, float _anglez) {
		anglex = _anglex;
		angley = _angley;
		anglez = _anglez;
	}

	public void automove(int t) {

		this.anglex=
				(float) (2*((PointLaby) (dt.getListpoint().get(t))).getV());
		this.angley=
			(float) (2*((PointLaby) (dt.getListpoint().get(t))).getW());
	
	}

	public float getAnglex() {
		return anglex;
	}

	public void setAnglex(float anglex) {
		this.anglex = anglex;
	}

	public float getAngley() {
		return angley;
	}

	public void setAngley(float angley) {
		this.angley = angley;
	}

	public float getAnglez() {
		return anglez;
	}

	public void setAnglez(float anglez) {
		this.anglez = anglez;
	}

	public String toString() {
		StringBuffer buffy = new StringBuffer();
		buffy.append("Plan :");
		buffy.append("  aX : ");
		buffy.append(this.getAnglex());
		buffy.append("  aY : ");
		buffy.append(this.getAngley());
		buffy.append("  aY : ");
		buffy.append(this.getAnglez());
		return buffy.toString();

	}

}
