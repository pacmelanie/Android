package modele;

/**
 * TODO To change the template for this generated type comment go to Window -
 * Preferences - Java - Code Style - Code Templates
 */
public class Point3D {

	private float x;

	private float y;

	private float z;

	public Point3D() {
		this(0f, 0f, 0f);
	}

	public Point3D(float _x, float _y, float _z) {
		x = _x;
		y = _y;
		z = _z;
	}

	public Point3D(Point3D p) {
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

	public void setZ(float z) {
		this.z = z;
	}
	
	public void move(float _x,float _y,float _z)
	{
		x = _x;
		y = _y;
		z = _z;
	}
	
	public void move(Point3D _center) {
		
		x = _center.getX();
		y = _center.getY();
		z = _center.getZ();
	}

	public String toString() {
		StringBuffer buffy = new StringBuffer("Point3D( ");
		buffy.append(this.getX());
		buffy.append(", ");
		buffy.append(this.getY());
		buffy.append(", ");
		buffy.append(this.getZ());
		buffy.append(" )");

		return buffy.toString();
	}



}
