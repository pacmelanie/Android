/*
 * TODO To change the template for this generated file go 
 * 
 */
package modele;

/**
 * TODO To change the template for this generated type comment go to Window -
 * Preferences - Java - Code Style - Code Templates
 */
public class PointLaby {

	private float x;

	private float y;

	private int z;

	private double v;

	private double w;

	public PointLaby() {
		this(0, 0, 0, 0, 0);
	}

	public PointLaby(float _x, float _y, int _z, double _v, double _w) {
		x = _x;
		y = _y;
		z = _z;
		v = _v;
		w = _w;
	}

	public PointLaby(PointLaby p) {
		x = p.x;
		y = p.y;
		z = p.z;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public float getZ() {
		return z;
	}

	public void setZ(int z) {
		this.z = z;
	}

	public boolean equals(PointLaby pl) {
		return (x == pl.getX() && y == pl.getY());
	}

	/**
	 * @return Returns the v.
	 */
	public double getV() {
		return v;
	}

	/**
	 * @param v
	 *            The v to set.
	 */
	public void setV(float v) {
		this.v = v;
	}

	/**
	 * @return Returns the w.
	 */
	public double getW() {
		return w;
	}

	/**
	 * @param w
	 *            The w to set.
	 */
	public void setW(double w) {
		this.w = w;
	}

	public String toString() {
		StringBuffer buffy = new StringBuffer("Point4D( ");
		buffy.append(this.getX());
		buffy.append(", ");
		buffy.append(this.getY());
		buffy.append(", ");
		buffy.append(this.getZ());
		buffy.append(", ");
		buffy.append(this.getV());
		buffy.append(" )");

		return buffy.toString();
	}

}
