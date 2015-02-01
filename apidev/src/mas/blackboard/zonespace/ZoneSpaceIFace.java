package mas.blackboard.zonespace;

import mas.blackboard.namezone.NamedZone;
import mas.blackboard.zonedata.ZoneData;

public interface ZoneSpaceIFace {
	public void createZone(NamedZone s);
	public void dropZone();
	public void insertItem(NamedZone var, Object obj);
	public void removeItem(Object obj);
	public ZoneData findZone(NamedZone var);
}
