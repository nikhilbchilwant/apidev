package mas.maintenance.plan;

import bdi4jade.plan.PlanBody;
import bdi4jade.plan.PlanInstance;
import bdi4jade.plan.PlanInstance.EndState;
import jade.core.behaviours.Behaviour;

public class machineHealthCheckPlan extends Behaviour implements PlanBody {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void action() {
		
	}

	@Override
	public boolean done() {
		return false;
	}

	@Override
	public EndState getEndState() {
		return null;
	}

	@Override
	public void init(PlanInstance arg0) {
		
	}
}
