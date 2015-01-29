package modele;

public class Trou {

	private float diam;

	private Point3D centre = new Point3D();

	public Trou(Point3D centre) {
		this.diam = 0.012f;
		this.centre = centre;
	}

	public Point3D getCentre() {
		return centre;
	}

	public void setCentre(Point3D centre) {
		this.centre = centre;
	}

	public float getDiam() {
		return diam;
	}

	public void setDiam(float diam) {
		this.diam = diam;
	}
}
