package modele;

import java.util.ArrayList;
import java.util.Iterator;

import controlleur.ComportementPlateau;


public class Labyrinthe extends Bille {
    
  

  
	private Plateau plan;
	
	private ComportementPlateau bp;

	private static final float B = 0.4f;

	private float g = 9.81f;

	private float k = 0.05f;

	private Point3D GraphicCenter = new Point3D();

	private float cx = this.getCenter().getX();

	private float cy = this.getCenter().getY();

	private float speedX = 0;

	private float speedY = 0;
    
   

	private float oldax = 0;

	private float olday = 0;

	private ArrayList mursx = new ArrayList();

	private ArrayList mursy = new ArrayList();
	
	private ArrayList Trous = new ArrayList();
	
	private boolean initialize=false;

	
    public Labyrinthe(Plateau plan,ComportementPlateau bp, ArrayList mursx, ArrayList mursy, ArrayList Trous) {
		super();
		this.plan = plan;
		this.mursx = mursx;
		this.mursy = mursy;
		this.Trous = Trous;
		this.bp=bp;
	

	}

/**calcule la nouvelle coordonnée en X du centre de la bille en fonction de sa position, sa vitesse et de la distance qu' elle parcourt en un petit temp "dtime" égal à la période du thread du moteur de calcul, c' est également cette méthode qui arrète la bille en X si elle se situe à coté d' un mur en utilisant les méthode passe** **/
	public void moveBilleX(float dtime) {
		boolean bool = false;
		Point3D cent = this.getCenter();
		float aY = plan.getAngley();
		float cst = (float) ((this.getMasse() * this.g * Math.sin(aY)) / k);
		float cst2 = (float) (k / ((1 + B) * this.getMasse()));
		float cst3 = this.getCenter().getX();
        
        
	
            cx = (float) (cst * dtime - 1 / cst2 * (speedX - cst)
				* Math.exp(-dtime * cst2) + 1 / cst2 * (speedX - cst) + cst3);
        

		Iterator iter = mursy.listIterator();
		while (iter.hasNext()) {
			passeX((Mur) iter.next());
		}

		Iterator iter2 = mursx.listIterator();
		while (iter2.hasNext()) {
			Mur nxt = (Mur) iter2.next();
			this.passeXY(nxt);
		}
		
      
		this.getCenter().setX(cx);
		
	}
    /** calcule la nouvelle coordonnée en Y du centre de la bille en fonction de sa position, sa vitesse et de la distance qu' elle parcourt en un petit temp "dtime" égal à la période du thread du moteurdecalcul sa vitesse et de la distance qu' elle parcourt en un petit temp "dtime" égal à la période du thread du moteur de calcul, c' est également cette méthode qui arrète la bille en X si elle se situe à coté d' un mur en utilisant les méthode passe** **/
	public float moveBilleY(float dtime) {

		Point3D cent = this.getCenter();
		float aX = plan.getAnglex();
		float cst = (float) ((this.getMasse() * this.g * Math.sin(aX)) / k);
		float cst2 = (float) (k / ((1 + B) * this.getMasse()));
		float cst3 = this.getCenter().getY();
		
        
       
		cy = (float) (cst * dtime - 1 / cst2 * (speedY - cst)
				* Math.exp(-dtime * cst2) + 1 / cst2 * (speedY - cst) + cst3);
       
        
		Iterator iter = mursx.listIterator();
		while (iter.hasNext()) {
			passey((Mur) iter.next());
		}

		Iterator iter2 = mursy.listIterator();
		while (iter2.hasNext()) {
			passeYX((Mur) iter2.next());
		}
		this.getCenter().setY(cy);

		return cy;
	}

	
	
/** calcule le nouveau centre de la bille aprés un temp dtime. Elle utilise les méthode moveBilleZ et moveBilleY, c' est également cette méthode qui regarde si la le centre de la bille n' est pas dans un trou et appelle la fonction tomber si c' est le cas **/
	public void moveBille(float dtime) {
		float aX = plan.getAnglex();
		float aY = plan.getAngley();
		this.moveBilleX(dtime);
		this.moveBilleY(dtime);
		
		Iterator iter = Trous.listIterator();
		while (iter.hasNext()) {
			tomber((Trou) iter.next());
		}

		this.calcSpeedX(dtime);
		this.calcSpeedY(dtime);

		this.getGraphicCenter().setX(
				(float) (this.getCenter().getX() * Math.cos(aY)));
		this.getGraphicCenter().setY(
				(float) (this.getCenter().getY() * Math.cos(aX)));

	
	

	}

	public void autoMove(DroiteTrajectoire dt, int t) {

		float aX = plan.getAnglex();
		float aY = plan.getAngley();
		if (((PointLaby)(dt.getListpoint().get(t))).equals(DroiteTrajectoire.getFIN())) {
			initialize=true;
	
			
		} else {
			
			this.getCenter()
					.setX(
							(float) (((PointLaby) (dt.getListpoint().get(t)))
									.getX() * Math.cos(aY)));
			this.getCenter()
					.setY(
							(float) (((PointLaby) (dt.getListpoint().get(t)))
									.getY() * Math.cos(aX)));
		}
	}
	
	/** Calcule la nouvelle vitesse en X de la bille aprés un temp "dtime" en fonction de sa vitesse vitesse précédente et l' inclinaison du plateau. Elle prend également compte des frottement et met la vitesse à zéros si elle n' est pas supérieur à la vitesse de dépacement**/  
	public void calcSpeedX(float t) {
		float aY = plan.getAngley();
		float cst = (float) ((this.getMasse() * this.g * Math.sin(aY)) / k);
		float cst2 = (float) (k / ((1 + B) * this.getMasse()));
		speedX = (float) ((this.getSpeedX() - cst) * Math.exp(-cst2 * t) + cst);
        
       
        
       

		
	}
    /** Calcule la nouvelle vitesse en Y de la bille aprés un temp "dtime" en fonction de sa vitesse vitesse précédente et l' inclinaison du plateau. Elle prend également compte des frottement et met la vitesse à zéros si elle n' est pas supérieur à la vitesse de dépacement**/
	public void calcSpeedY(float t) {
		float aX = plan.getAnglex();
       
		float cst = (float) ((this.getMasse() * this.g * Math.sin(aX)) / k);
		float cst2 = (float) (k / ((1 + B) * this.getMasse()));
		speedY = (float) ((this.getSpeedY() - cst) * Math.exp(-cst2 * t) + cst);
		
        
        

	}
/** reinitialise les vitesse, position, angles, etc...**/	
	public void tomber(Trou trou){
		if (Math.pow(this.getCenter().getX() - trou.getCentre().getX(),2)+ Math.pow(this.getCenter().getY() - trou.getCentre().getY(),2) < Math.pow(trou.getDiam()/2,2))
				{
              
					this.getCenter().move(-0.00509999f, 0.10482955f, 0f);
                    this.GraphicCenter.move(-0.00509999f, 0.10482955f, 0f);
                    cx=-0.00509999f;
                    cy=0.10482955f;
					this.plan.setAnglex(0);
					this.plan.setAngley(0);
					this.plan.setAnglez(0);
					this.bp.setAX(0);
					this.bp.setAY(0);
					this.setSpeedX(0);
					this.setSpeedY(0);
				}
	}
    
    /** arrète la bille si elle va dépacer un murX sur ca longeur **/ 
	public void passey(Mur mx) {
		if (Math.signum(speedY) == -1) {
			if ((cy - 0.005) < (mx.getP1().getY() + (mx.getThickness() / 2))
					&& ((cy - 0.005) > (mx.getP1().getY() - (mx.getThickness() / 2))))

			{
				
				if ((this.getCenter().getX() > mx.getP1().getX()
						- (mx.getHeight() / 2))
						&& (this.getCenter().getX() < mx.getP1().getX()
								+ (mx.getHeight() / 2))) {
					cy = (mx.getP1().getY() + (mx.getThickness() / 2) + 0.0051f);
					this.setSpeedY(- this.getSpeedY());
				}

			}
		} else {
			if (((cy + 0.005) > mx.getP1().getY() - (mx.getThickness() / 2))
					&& (cy + 0.005 < mx.getP1().getY()
							+ (mx.getThickness() / 2)))

			{
				
				if ((this.getCenter().getX() > (mx.getP1().getX() - (mx
						.getHeight() / 2)))
						&& (this.getCenter().getX() < mx.getP1().getX()
								+ (mx.getHeight() / 2))) {

					cy = (mx.getP1().getY() - (mx.getThickness() / 2) - 0.0051f);
					this.setSpeedY(- this.getSpeedY());
				}
			}
		}
	}
	  /** arrète la bille si elle va dépacer un Mur sur ca longeur **/ 
	public void passeX(Mur my) {
		if (Math.signum(speedX) == -1) {
			if (((cx - 0.005) < my.getP1().getX() + (my.getThickness() / 2))
					&& ((cx - 0.005) > my.getP1().getX()
							- (my.getThickness() / 2))) {
			
				if ((cy > (my.getP1().getY() - (my.getHeight() / 2)))
						&& ((this.getCenter().getY()) < (my.getP1().getY() + (my
								.getHeight() / 2)))) {
					cx = (my.getP1().getX() + (my.getThickness() / 2) + 0.0051f);
					this.setSpeedX(- this.getSpeedX());
				}
			}

		} else {
			if ((((cx + 0.005) > (my.getP1().getX() - (my.getThickness() / 2))))
					&& ((cx + 0.005) < (my.getP1().getX() + (my.getThickness() / 2)))) {
	
				if ((this.getCenter().getY() > (my.getP1().getY() - (my
						.getHeight() / 2)))
						&& (this.getCenter().getY() < my.getP1().getY()
								+ (my.getHeight() / 2))) {
					cx = (my.getP1().getX() - (my.getThickness() / 2) - 0.0051f);
					this.setSpeedX(- this.getSpeedX());
				}
			}
		}
	}
	  /** arrète la bille si elle va dépacer un murX sur ca largeur **/ 
	public void passeXY(Mur mx) {
		if (Math.signum(speedX) == -1) {
		
			if (((cx - 0.005) < mx.getP1().getX() + (mx.getHeight() / 2))
					&& ((cx - 0.005) > mx.getP1().getX()
							- (mx.getHeight() / 2))) {
		
				if ((cy > (mx.getP1().getY() - (mx.getThickness() / 2)))
						&& ((this.getCenter().getY()) < (mx.getP1().getY() + (mx
								.getThickness() / 2)))) {
					cx = (mx.getP1().getX() + (mx.getHeight() / 2) + 0.0051f);
					this.setSpeedX(- this.getSpeedX());
				}
			}

		} else {
			if ((((cx + 0.005) > (mx.getP1().getX() - (mx.getHeight() / 2))))
					&& ((cx + 0.005) < (mx.getP1().getX() + (mx.getHeight() / 2)))) {
			
				if ((this.getCenter().getY() > (mx.getP1().getY() - (mx
						.getThickness() / 2)))
						&& (this.getCenter().getY() < mx.getP1().getY()
								+ (mx.getThickness() / 2))) {
					cx = (mx.getP1().getX() - (mx.getHeight() / 2) - 0.0051f);
					this.setSpeedX(- this.getSpeedX());
				}
			}
		}
	}
	  /** arrète la bille si elle va dépacer un Mur sur ca largeur **/ 
	public void passeYX(Mur my) {
		if (Math.signum(speedY) == -1) {
			if ((cy - 0.005) < (my.getP1().getY() + (my.getHeight() / 2))
					&& ((cy - 0.005) > (my.getP1().getY() - (my.getHeight() / 2))))

			{
			
				if ((this.getCenter().getX() > my.getP1().getX()
						- (my.getThickness() / 2))
						&& (this.getCenter().getX() < my.getP1().getX()
								+ (my.getThickness() / 2))) {
					cy = (my.getP1().getY() + (my.getHeight() / 2) + 0.0051f);
					this.setSpeedY(- this.getSpeedY());
				}

			}
		} else {
			if (((cy + 0.005) > my.getP1().getY() - (my.getHeight() / 2))
					&& (cy + 0.005 < my.getP1().getY() + (my.getHeight() / 2)))

			{
				
				if ((this.getCenter().getX() > (my.getP1().getX() - (my
						.getThickness() / 2)))
						&& (this.getCenter().getX() < my.getP1().getX()
								+ (my.getThickness() / 2))) {

					cy = (my.getP1().getY() - (my.getHeight() / 2) - 0.0051f);
					this.setSpeedY(- this.getSpeedY());
				}
			}
		}
	}
	
	public Plateau getPlan() {
		return plan;
	}

	public void setPlan(Plateau plan) {
		this.plan = plan;
	}

	public float getCx() {
		return cx;
	}

	public void setCx(float cx) {
		this.cx = cx;
	}

	public float getCy() {
		return cy;
	}

	public void setCz(float cy) {
		this.cy = cy;
	}

	public float getSpeedX() {
		return speedX;
	}

	public float getSpeedY() {
		return speedY;
	}

	public Point3D getGraphicCenter() {
		return GraphicCenter;
	}

	

	public void setGraphicCenter(Point3D graphicCenter) {
		GraphicCenter = graphicCenter;
	}
	
	
	
	public void setSpeedX(float speedX) {
		this.speedX = speedX;
	}

	public void setSpeedY(float speedY) {
		this.speedY = speedY;
	}
	
	
	
	
	/**
	 * @return Returns the initialize.
	 */
	public boolean isInitialize() {
		return initialize;
	}
	/**
	 * @param initialize The initialize to set.
	 */
	public void setInitialize(boolean initialize) {
		this.initialize = initialize;
	}
}
