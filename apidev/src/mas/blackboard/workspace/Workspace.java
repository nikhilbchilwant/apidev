package mas.blackboard.workspace;

import java.util.HashMap;
import bdi4jade.belief.Belief;
import mas.blackboard.namezone.NamedZone;
import mas.blackboard.zonespace.ZoneSpace;

public class Workspace implements WorkspaceIFace{

	private static final long serialVersionUID = 1L;
	private String ZSname;
	private HashMap<NamedZone, ZoneSpace> ZSpaces;
	
	public Workspace(String n){
		this.ZSname = n;
		this.ZSpaces = new HashMap<NamedZone,ZoneSpace>();
	}
	
	public static Workspace newInstance(NamedZone name){
		return new Workspace(name.name());
	}
	
	@Override
	public void createZoneSpace(NamedZone name) {
		if(! ZSpaces.containsKey(name)){
			ZoneSpace zs = ZoneSpace.newInstance(name);
//			ZSpaces.put(name, zs);
		}
	}

	@Override
	public void dropZoneSpace(NamedZone title) {
		
	}

	@Override
	public ZoneSpace findZoneSpace(NamedZone title) {
		return ZSpaces.get(title);
	}

	@Override
	public boolean insertItem(NamedZone zSpaceName,NamedZone var, Object obj) {
//		findZoneSpace(zSpaceName).insertItem(var, obj);
		return false;
	}

	@Override
	public void removeItem(Object obj) {
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ZSname == null) ? 0 : ZSname.hashCode());
		result = prime * result + ((ZSpaces == null) ? 0 : ZSpaces.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Workspace other = (Workspace) obj;
		if (ZSname == null) {
			if (other.ZSname != null)
				return false;
		} else if (!ZSname.equals(other.ZSname))
			return false;
		if (ZSpaces == null) {
			if (other.ZSpaces != null)
				return false;
		} else if (!ZSpaces.equals(other.ZSpaces))
			return false;
		return true;
	}

}
