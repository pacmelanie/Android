package controlleur;

/**
 * @author valentin vincent melanie
 */

/** Permet de controler l'angle de vue la caméra */

import javax.media.j3d.Behavior;
import javax.media.j3d.TransformGroup;
import javax.media.j3d.Transform3D;
import javax.media.j3d.WakeupOnAWTEvent;
import javax.vecmath.Vector3f;
import java.awt.AWTEvent;
import java.util.Enumeration;
import java.awt.event.KeyEvent;

public class ComportementCamera extends Behavior {
	private TransformGroup TG;

	private Transform3D rot = new Transform3D();

	private Transform3D rotation = new Transform3D();

	private Vector3f translation = new Vector3f();

	private WakeupOnAWTEvent keyEvent = new WakeupOnAWTEvent(
			KeyEvent.KEY_PRESSED);

	public ComportementCamera(TransformGroup TG) {
		this.TG = TG;
	}

	public void initialize() {
		this.wakeupOn(keyEvent);

		TG.getTransform(rotation);
		rot.rotX(0.5);
		translation.set(0f, -1.5f, 0);
		rot.setTranslation(translation);
		rotation.mul(rot);
		TG.setTransform(rotation);

	}

	public void processStimulus(Enumeration criteria) {
		AWTEvent events[] = keyEvent.getAWTEvent();
		rot.setIdentity();
		TG.getTransform(rotation);

		switch (((KeyEvent) events[0]).getKeyCode()) {
		case KeyEvent.VK_D: {
			translation.set(0.02f, 0f, 0f);
			rot.setTranslation(translation);
		}
			break;

		case KeyEvent.VK_Q: {
			translation.set(-0.02f, 0f, 0f);
			rot.setTranslation(translation);
		}
			break;

		case KeyEvent.VK_M: {
			translation.set(0f, 0f, 0.02f);
			rot.setTranslation(translation);
		}
			break;

		case KeyEvent.VK_P: {
			translation.set(0f, 0f, -0.02f);
			rot.setTranslation(translation);
		}
			break;

		case KeyEvent.VK_Z: {
			translation.set(0f, -0.02f, 0f);
			rot.setTranslation(translation);
		}
			break;

		case KeyEvent.VK_S: {
			translation.set(0f, 0.02f, 0f);
			rot.setTranslation(translation);
		}
			break;

		case KeyEvent.VK_W:
			rot.rotX(+0.02);
			break;

		case KeyEvent.VK_X:
			rot.rotX(-0.02);
			break;

		case KeyEvent.VK_C:
			rot.rotY(-0.02);
			break;

		case KeyEvent.VK_V:
			rot.rotY(0.02);
			break;

		case KeyEvent.VK_B:
			rot.rotZ(-0.02);
			break;

		case KeyEvent.VK_N:
			rot.rotZ(0.02);
			break;
		}

		rotation.mul(rot);
		TG.setTransform(rotation);

		this.wakeupOn(keyEvent);

	}
}
