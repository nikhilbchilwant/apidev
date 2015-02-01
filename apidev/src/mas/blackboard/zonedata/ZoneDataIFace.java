package mas.blackboard.zonedata;

public interface ZoneDataIFace {
	public void addItem( Object obj);
	public boolean updateItem(Object old, Object newObj);
	public void removeItem(Object obj);
	public Object[] getAllItem();
//	public boolean updateItem(Object oldObj, E newObj);
}
