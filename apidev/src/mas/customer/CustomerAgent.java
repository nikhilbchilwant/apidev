package mas.customer;

import jade.core.AID;
import mas.util.AgentUtil;
import mas.util.ID;
import mas.util.SubscriptionForm;
import bdi4jade.core.Capability;

public class CustomerAgent extends AbstractCustomerAgent {

	private static final long serialVersionUID = 1L;

	@Override
	protected void init() {
		super.init();
		Capability bCap = new basicCapability();
		addCapability(bCap);
		
		AID bba = AgentUtil.findBlackboardAgent(this);
		bCap.getBeliefBase().updateBelief(
					AbstractbasicCapability.blackAgent, bba);
		
		String[] zones = {ID.CustomerZone.acceptedJobs,
						ID.CustomerZone.JobList,
						ID.CustomerZone.Negotiation};
		
		AgentUtil.makeZoneBB(this,zones);
		
		AID target = new AID("", AID.ISLOCALNAME);
		String[] params = {ID.GSAParameters.ConfirmedOrder,
							ID.GSAParameters.Negotiation,
							ID.GSAParameters.WorkOrder};
		
		SubscriptionForm subform = new SubscriptionForm();
		subform.AddSubscriptionReq(target, params);
		
		AgentUtil.subscribeToParam(this, bba, subform);
	}
}
