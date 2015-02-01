package mas.blackboard.zonedata;

import java.util.HashSet;
import java.util.Set;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import mas.blackboard.namezone.NamedZone;

public class ZoneData implements ZoneDataIFace{
	private String name;
	private Set<Object> data;
	
	private ZoneData(String n){
		this.name = n;
		this.data = new HashSet<Object>();
	}
	
	public static ZoneData newInstance(NamedZone title){
		return new ZoneData(title.name());
	}
	
	public String getName(){
		return this.name;
	}
	
	@Override
	public boolean updateItem(Object oldObj, Object newObj){
		if(this.data.contains(oldObj)){
			this.data.remove(oldObj);
			this.data.add(newObj);
		}
		return true;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof ZoneData){
	        final ZoneData other = (ZoneData) obj;
	        return new EqualsBuilder()
	            .append(name, other.name)
	            .append(data, other.data)
	            .isEquals();
	    } else {
	        return false;
	    }
	}
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder()
				.append(name)
				.append(data)
				.toHashCode();
	}
	
	@Override
	public String toString() {
		return new StringBuilder()
				.append(name)
				.append(data.toString())
				.toString();
	}

	@Override
	public void addItem(Object obj) {
		this.data.add(obj);
	}

	@Override
	public void removeItem(Object obj) {
		if(this.data.contains(obj)){
			this.data.remove(obj);
		}
	}

	@Override
	public Object[] getAllItem() {
		return this.data.toArray();
	}
}
