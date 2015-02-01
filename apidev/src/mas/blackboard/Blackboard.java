package mas.blackboard;

import java.util.HashMap;

import mas.blackboard.namezone.NamedZone;
import mas.blackboard.workspace.Workspace;

public class Blackboard extends AbstractBlackboardObject{

	private String bbName;
	private HashMap<NamedZone,Workspace> workspaces;
	
	private Blackboard(String title){
		this.bbName = title;
		this.workspaces = new HashMap<NamedZone, Workspace>();
	}
	
	public static Blackboard newInstance(String blackName){
		return new Blackboard(blackName);
	}
	
	@Override
	public void createWorkspace(NamedZone name) {
		if(! workspaces.containsKey(name)){
			Workspace wk = Workspace.newInstance(name);
			workspaces.put(name, wk);
		}
//		else
//			throw new Exeption()
	}

	@Override
	public void dropWorkspace(NamedZone name) {
		if(workspaces.containsKey(name)){
			workspaces.remove(name);
		}
	}
	
	public boolean addItem(NamedZone wsName,NamedZone ZSName,NamedZone var,Object obj ){
		findWorkSpace(wsName).insertItem(ZSName,var,obj);
		return false;
	}

	@Override
	public void getAllWorkspaces() {
		
	}

	@Override
	public Workspace findWorkSpace(NamedZone s) {
		return workspaces.get(s);
	}
}
