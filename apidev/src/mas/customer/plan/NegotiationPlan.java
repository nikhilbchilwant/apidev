package mas.customer.plan;

import jade.core.behaviours.Behaviour;
import jade.lang.acl.ACLMessage;
import bdi4jade.plan.PlanBody;
import bdi4jade.plan.PlanInstance;
import bdi4jade.plan.PlanInstance.EndState;

public class NegotiationPlan extends Behaviour implements PlanBody {
	private static final long serialVersionUID = 1L;

	@Override
	public EndState getEndState() {
		return null;
	}

	@Override
	public void init(PlanInstance pInstance) {
	}

	@Override
	public void action() {
		ACLMessage msg = new ACLMessage(ACLMessage.CFP);
		myAgent.addBehaviour(new NegotiateBehavior());
	}

	@Override
	public boolean done() {
		return false;
	}
}
