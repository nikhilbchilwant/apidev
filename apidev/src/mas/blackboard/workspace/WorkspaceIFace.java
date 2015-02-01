package mas.blackboard.workspace;
import java.io.Serializable;

import mas.blackboard.namezone.NamedZone;
import mas.blackboard.zonespace.ZoneSpace;

/**
 * Identifies a Workspace on a Blackboard
 * @param <E>
 */

public interface WorkspaceIFace<E> extends Serializable
{
//   public static final WorkspaceIFace DEFAULT = new DefaultWorkspace();
	public void createZoneSpace(NamedZone title);
	public void dropZoneSpace(NamedZone title);
	public E findZoneSpace(NamedZone title);
	public boolean insertItem(NamedZone zSpaceName,NamedZone var, Object obj);
	public void removeItem(Object obj);
}
