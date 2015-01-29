
package utils;

import javax.media.j3d.BranchGroup;


/**
 * 
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class Scene {

	public BranchGroup scene;

	public Scene()
	{
		scene = new BranchGroup();
		scene.setCapability(BranchGroup.ALLOW_CHILDREN_READ);
		scene.setCapability(BranchGroup.ALLOW_CHILDREN_WRITE);
		scene.setCapability(BranchGroup.ALLOW_CHILDREN_EXTEND);
	}
	
	public BranchGroup GetScene()
	{
		return scene;
	}
	
}
