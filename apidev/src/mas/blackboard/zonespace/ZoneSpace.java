package mas.blackboard.zonespace;

import java.util.HashMap;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import mas.blackboard.namezone.NamedZone;
import mas.blackboard.zonedata.ZoneData;

/**
 * @author Anand Prajapati
 * @param <V>
 */

public class ZoneSpace implements ZoneSpaceIFace{
	
	private String Zname;
	private HashMap<NamedZone, ZoneData> Zdata;
	
	private ZoneSpace(NamedZone n){
		this.Zname = n.name();
		this.Zdata = new HashMap<NamedZone,ZoneData>();
	}
	
	public static ZoneSpace newInstance(NamedZone name){
		return new ZoneSpace(name);
	}
	@Override
	public void createZone(NamedZone name) {
		if(! Zdata.containsKey(name)){
			ZoneData zd = ZoneData.newInstance(name);
			Zdata.put(name, zd);
		}
	}
	
	public String getName(){
		return this.Zname;
	}
	
	@Override
	public void dropZone() {
		Zdata = null;
	}
	@Override
	public void insertItem(NamedZone zName, Object obj) {
		findZone(zName).addItem(obj);
	}
	@Override
	public void removeItem(Object obj) {
		Zdata.remove(obj);
	}

	@Override
	public ZoneData findZone(NamedZone var) {
		return Zdata.get(var);
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder()
			        .append(Zname)
			        .append(Zdata)
			        .toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		ZoneSpace other = (ZoneSpace) obj;
//		if (Zdata == null) {
//			if (other.Zdata != null)
//				return false;
//		} else if (!Zdata.equals(other.Zdata))
//			return false;
//		if (Zname == null) {
//			if (other.Zname != null)
//				return false;
//		} else if (!Zname.equals(other.Zname))
//			return false;
//		return true;
		if(obj instanceof ZoneSpace){
	        final ZoneSpace other = (ZoneSpace) obj;
	        return new EqualsBuilder()
	            .append(Zname, other.Zname)
	            .append(Zdata, other.Zdata)
	            .isEquals();
	    } else {
	        return false;
	    }
	}
}
