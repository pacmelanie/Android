package utils;



import java.awt.Frame;
import java.util.ArrayList;
import java.util.Iterator;
import javax.media.j3d.Appearance;
import javax.media.j3d.BoundingSphere;
import javax.media.j3d.ColoringAttributes;
import javax.media.j3d.ImageComponent2D;
import javax.media.j3d.Texture;
import javax.media.j3d.Texture2D;
import javax.media.j3d.TextureAttributes;
import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;
import javax.vecmath.Point3d;
import javax.vecmath.Vector3f;

import Vue.VuePrincipale;

import com.sun.j3d.utils.geometry.Box;
import com.sun.j3d.utils.geometry.Cylinder;
import com.sun.j3d.utils.geometry.Sphere;
import com.sun.j3d.utils.image.TextureLoader;
import com.sun.j3d.utils.universe.SimpleUniverse;
import controlleur.ComportementCamera;
import modele.DroiteTrajectoire;
import modele.Labyrinthe;
import modele.Mur;

import modele.Plateau;

import modele.Trou;

public class Dessinateur {

	private Scene scene = new Scene();

	private TransformGroup T = new TransformGroup();

	private TransformGroup tgrx = new TransformGroup();

	private Transform3D transl = new Transform3D();

	private Transform3D transx = new Transform3D();

	private Transform3D transy = new Transform3D();

	private Transform3D transtr = new Transform3D();

	private Transform3D transz = new Transform3D();

	private Transform3D rotation = new Transform3D();

	private TransformGroup tgrmxx = new TransformGroup();

	private TransformGroup tgrmyx = new TransformGroup();

	private TransformGroup tgrtr = new TransformGroup();

	private TransformGroup tgrotbilleX = new TransformGroup();

	private TransformGroup tgrotbilleY = new TransformGroup();

	private Transform3D transmxx = new Transform3D();

	private Transform3D transmxy = new Transform3D();

	private Transform3D rotationmx = new Transform3D();

	private Transform3D transmyx = new Transform3D();

	private Transform3D transmyy = new Transform3D();

	private Transform3D rotbilleX = new Transform3D();

	private Transform3D rotbilleY = new Transform3D();

	private Transform3D rotationmy = new Transform3D();

	private Transform3D rotationtr = new Transform3D();

	private ArrayList tgalx = new ArrayList();

	private ArrayList t3dalx = new ArrayList();

	private ArrayList tgaly = new ArrayList();

	private ArrayList t3daly = new ArrayList();

	private ArrayList tgaltr = new ArrayList();

	private ArrayList t3daltr = new ArrayList();

	private ArrayList btdaltr = new ArrayList();

	private ArrayList tgdaltr = new ArrayList();
    
    private Convertisseur c = new Convertisseur();

	int cmpt = 0;

	int cmpttr = 0;

	public Dessinateur() {
		Scene scene = new Scene();
		this.scene = scene;
	}

	public Dessinateur(Scene scene) {
		this.scene = scene;
	}

	public void drawPlan(Plateau plan, Frame g) {
		//Appearance ap = new Appearance();
        //ColoringAttributes cs = new ColoringAttributes();
        //cs.setColor(1f, 0.75f, 0.5f);
        //(rouge,vert,bleu)
       // cs.setShadeModel(ColoringAttributes.NICEST);
        //ap.setColoringAttributes(cs);
		
		Appearance ap = mkAppWithTexture("textureplateau3.jpg",g);
		
		Box pbx = new Box((float) c.convert(134) ,(float) c.convert(119), 0.001f, Box.GENERATE_TEXTURE_COORDS,ap);

	
		
		tgrx.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		tgrx.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
		tgrx.setTransform(rotation);

		tgrx.addChild(pbx);

		scene.GetScene().addChild(tgrx);
	}

	public void redrawPlan(Plateau plan) {
		transx.rotX(plan.getAnglex());
        

		transy.rotY(plan.getAngley());

		rotation.mul(transx, transy);

		tgrx.setTransform(rotation);

	}

	public void drawBille(Labyrinthe bille, Plateau plan,Frame g) {
		//Appearance sphereApp = new Appearance();
		//ColoringAttributes cs = new ColoringAttributes();
		//cs.setColor(0.50f, 0.53f, 0.47f);
		//cs.setShadeModel(ColoringAttributes.NICEST);
		//sphereApp.setColoringAttributes(cs);
		Point3d center = new Point3d(bille.getGraphicCenter().getX(), bille
				.getGraphicCenter().getY(), 0);

		TransformGroup t = new TransformGroup();
		Appearance sphereApp=mkAppWithTexture("metal.jpg",g);
		Sphere sp = new Sphere(c.convert(bille.getRay()), Sphere.GENERATE_TEXTURE_COORDS,sphereApp);
		

		T.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		T.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);

		tgrotbilleX.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		tgrotbilleX.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);

		tgrotbilleY.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		tgrotbilleY.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);

		tgrotbilleX.setTransform(rotbilleX);
		tgrotbilleY.setTransform(rotbilleY);

		transl.setTranslation(new Vector3f(bille.getCenter().getX(), bille
				.getCenter().getY(), bille.getCenter().getZ()));
		T.setTransform(transl);

		Transform3D pos1 = new Transform3D();
		pos1.setTranslation(new Vector3f(0f, 0.0f, 0.033333333333333f));
		t.setTransform(pos1);

		scene.GetScene().addChild(tgrotbilleX);
		tgrotbilleX.addChild(tgrotbilleY);
		tgrotbilleY.addChild(t);
		t.addChild(T);
		T.addChild(sp);
	}

	public void reDrawBille(Labyrinthe bille, Plateau plan) {

		rotbilleX.rotX(plan.getAnglex());
		tgrotbilleX.setTransform(rotbilleX);

		rotbilleY.rotY(plan.getAngley());
		tgrotbilleY.setTransform(rotbilleY);

		float cst = 6.66666666667f;
		transl.setTranslation(new Vector3f(bille.getCenter().getX() * cst,
				-bille.getCenter().getY() * cst, 0));

		T.setTransform(transl);
	}
    
    public void reDrawBille2D(Labyrinthe bille) {

        
        float cst = 6.66666666667f;
        transl.setTranslation(new Vector3f(bille.getCenter().getX() * cst,
                -bille.getCenter().getY() * cst, 0));

        T.setTransform(transl);
    }
    
 

	public void view(SimpleUniverse myWorld) {
		myWorld.getViewingPlatform().setNominalViewingTransform();
		TransformGroup tg = myWorld.getViewingPlatform()
				.getViewPlatformTransform();

		ComportementCamera behav = new ComportementCamera(tg);

		BoundingSphere influPartout = new BoundingSphere(new Point3d(), 1000.0);
		behav.setSchedulingBounds(influPartout);
		scene.GetScene().addChild(behav);
	}
	
	

	public void drawMur(ArrayList mursx, ArrayList mursy,
			Plateau plan,Frame g) {

		tgrmxx.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		tgrmxx.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
		tgrmxx.setTransform(transx);

		tgrmyx.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		tgrmyx.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
		tgrmyx.setTransform(transx);

		Iterator iter = mursx.iterator();

		//Appearance ap = new Appearance();
		//ColoringAttributes cs = new ColoringAttributes();
		//cs.setColor(0.50f, 0.25f, 0f);
		//cs.setShadeModel(ColoringAttributes.NICEST);
		//ap.setColoringAttributes(cs);
		Appearance ap2 = mkAppWithTexture("textureMur.jpg",g);
		

		

		while (iter.hasNext()) {
	
			tgalx.add(new TransformGroup());
			t3dalx.add(new Transform3D());
			((Transform3D) (t3dalx.get(cmpt)))
					.setTranslation(new Vector3f(((Mur) (mursx.get(cmpt)))
							.getP1().getX() * 6.66666666f, -((Mur) (mursx
							.get(cmpt))).getP1().getY() * 6.666666666666f, 0));
			Box bx = new Box(
					((Mur) (mursx.get(cmpt))).getHeight() * 3.33333333333f,
					((Mur) (mursx.get(cmpt))).getThickness() * 3.33333333333f,
					((Mur) (mursx.get(cmpt))).getHauteur(), Box.GENERATE_TEXTURE_COORDS, ap2);
			((TransformGroup) tgalx.get(cmpt))
					.setTransform((Transform3D) t3dalx.get(cmpt));
			((TransformGroup) tgalx.get(cmpt)).addChild(bx);
			tgrmxx.addChild(((TransformGroup) tgalx.get(cmpt)));
			iter.next();
			cmpt = cmpt + 1;

		}

		cmpt = 0;

		this.scene.GetScene().addChild(tgrmxx);

		Iterator itery = mursy.iterator();

		while (itery.hasNext()) {
			tgaly.add(new TransformGroup());
			t3daly.add(new Transform3D());

			((Transform3D) (t3daly.get(cmpt)))
					.setTranslation(new Vector3f(((Mur) (mursy.get(cmpt)))
							.getP1().getX() * 6.666666666666f, -((Mur) (mursy
							.get(cmpt))).getP1().getY() * 6.66666666f, 0));
			Box bx = new Box(
					((Mur) (mursy.get(cmpt))).getThickness() * 3.33333333333f,
					((Mur) (mursy.get(cmpt))).getHeight() * 3.33333333333f,
					((Mur) (mursy.get(cmpt))).getHauteur(), Box.GENERATE_TEXTURE_COORDS, ap2);
			;
			((TransformGroup) tgaly.get(cmpt))
					.setTransform((Transform3D) t3daly.get(cmpt));
			((TransformGroup) tgaly.get(cmpt)).addChild(bx);
			tgrmyx.addChild(((TransformGroup) tgaly.get(cmpt)));
			itery.next();
			cmpt = cmpt + 1;

		}

		this.scene.GetScene().addChild(tgrmyx);

	}

	public void redrawMur(ArrayList mursx, ArrayList mursy,
			Plateau plan) {

		transmxx.rotX(plan.getAnglex());
		transmxy.rotY(plan.getAngley());
		rotationmx.mul(transmxx, transmxy);
		tgrmxx.setTransform(rotationmx);

		transmyx.rotX(plan.getAnglex());
		transmyy.rotY(plan.getAngley());
		rotationmy.mul(transmyx, transmyy);
		tgrmyx.setTransform(rotationmy);

	}

	public void drawTrous(ArrayList trous) {
		tgrtr.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		tgrtr.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
		tgrtr.setTransform(transtr);

		tgrtr.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		tgrtr.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
		tgrtr.setTransform(transtr);

		Iterator iter = trous.iterator();

		Appearance ap = new Appearance();
		ColoringAttributes cs = new ColoringAttributes();
		cs.setColor(0f, 0f, 0f);
		cs.setShadeModel(ColoringAttributes.NICEST);
		ap.setColoringAttributes(cs);

		while (iter.hasNext()) {
		
			tgaltr.add(new TransformGroup());
			t3daltr.add(new Transform3D());
			tgdaltr.add(new TransformGroup());
			btdaltr.add(new Transform3D());

			((Transform3D) (t3daltr.get(cmpttr)))
					.setTranslation(new Vector3f(((Trou) (trous.get(cmpttr)))
							.getCentre().getX() * 6.66666666f, ((Trou) (trous
							.get(cmpttr))).getCentre().getY()
							* -6.666666666666f, 0));
			Cylinder Cy = new Cylinder(
					((Trou) (trous.get(cmpttr))).getDiam() * 3.33333333333f,
					0.01f, ap);

			((Transform3D) (btdaltr.get(cmpttr))).rotX(Math.PI / 2);

			((TransformGroup) tgdaltr.get(cmpttr))
					.setTransform((Transform3D) btdaltr.get(cmpttr));

			((TransformGroup) tgaltr.get(cmpttr))
					.setTransform((Transform3D) t3daltr.get(cmpttr));

			((TransformGroup) tgaltr.get(cmpttr))
					.addChild(((TransformGroup) tgdaltr.get(cmpttr)));
			((TransformGroup) tgdaltr.get(cmpttr)).addChild(Cy);

			tgrtr.addChild(((TransformGroup) tgaltr.get(cmpttr)));
			iter.next();
			cmpttr = cmpttr + 1;

		}

		cmpttr = 0;
		TransformGroup tgtrinit = new TransformGroup();
		Transform3D trinit = new Transform3D();
		this.scene.GetScene().addChild(tgrtr);
	}

	public void redrawTrous(ArrayList trous, Plateau plan) {
		transtr.rotX(plan.getAnglex());
		transtr.rotY(plan.getAngley());
		rotationtr.mul(transmxx, transmxy);
		tgrtr.setTransform(rotationmx);

	}
	
	private Appearance mkAppWithTexture(String textureName, Frame vp)
	{
		Appearance app=new Appearance();
	        TextureLoader loader=new TextureLoader(textureName,vp);
        	ImageComponent2D image=loader.getImage();
        	
        	Texture2D texture=new Texture2D(Texture.BASE_LEVEL,Texture.RGBA,image.getWidth(),image.getHeight());
        	texture.setImage(0, image);
        	texture.setEnable(true);
        	texture.setMagFilter(Texture.BASE_LEVEL_LINEAR);
        	texture.setMinFilter(Texture.BASE_LEVEL_LINEAR);
        	        	
        	app.setTexture(texture);
        	app.setTextureAttributes(new TextureAttributes());
        	return app;
    	}
}
