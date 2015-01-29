
package modele;


public class Bille {

	private float ray;
    
    private float masse;

	private Point3D center = new Point3D();



	

	public Bille() {
		center.move(-0.00509999f, 0.10482955f, 0f);
		this.setRay(5f);
		masse = 0.0053f;
	}

	public Bille(float _ray, Point3D _center) {
		this(_ray, _center, 0.0053f);
	}

	public Bille(float _ray, Point3D _center, float masse) {
		center.move(_center);
		this.setRay(Math.abs(_ray));
		this.masse = masse;
	}

	public Point3D getCenter() {
		return center;
	}

	public void setCenter(Point3D center) {
		this.center = center;
	}

	public float getRay() {
		return ray;
	}

	public void setRay(float ray) {
		this.ray = ray;
	}

	public double getMasse() {
		return masse;
	}

	public void setMasse(float masse) {
		this.masse = masse;
	}

	public String toString() {
		StringBuffer buffy = new StringBuffer();
		buffy.append("Sphere :");
		buffy.append("rayon:  ");
		buffy.append(this.getRay());
		buffy.append("centre:  ");
		buffy.append(center);
		buffy.append("Masse:  ");
		buffy.append(this.getMasse());

		return buffy.toString();

	}
}
