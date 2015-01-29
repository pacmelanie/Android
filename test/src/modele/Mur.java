package modele;

/**
 * TODO To change the template for this generated type comment go to Window -
 * Preferences - Java - Code Style - Code Templates
 */
public class Mur
{

    private Point3D p1 = new Point3D();
    private float height;
    private float thickness = 0.005f;
    private float hauteur = 0.04f;
   

    public Mur (Point3D p, float height,float hauteur)
    {
    	 this.p1 = p;
         this.height = height;
         this.hauteur=hauteur;
    }
    public Mur(Point3D p, float height)
    {
        this.p1 = p;
        this.height = height;
    }

    public Mur()
    {

    }

    public float getThickness()
    {
        return thickness;
    }

    public void setThickness(float thickness)
    {
        this.thickness = thickness;
    }

    public float getHeight()
    {
        return height;
    }

    public void setHeight(float height)
    {
        this.height = height;
    }

    public Point3D getP1()
    {
        return p1;
    }

    public void setP1(Point3D p1)
    {
        this.p1 = p1;
    }

   
    public String toString()
    {
        StringBuffer buffy = new StringBuffer();
        buffy.append("Pb  :  ");
        buffy.append(this.getP1());
        buffy.append("         Height : ");
        buffy.append(this.getHeight());
        buffy.append("         Thicknes : ");
        buffy.append(this.getThickness());
        return buffy.toString();
    }
    
    
	/**
	 * @return Returns the hauteur.
	 */
	public float getHauteur() {
		return hauteur;
	}
	/**
	 * @param hauteur The hauteur to set.
	 */
	public void setHauteur(float hauteur) {
		this.hauteur = hauteur;
	}
}
