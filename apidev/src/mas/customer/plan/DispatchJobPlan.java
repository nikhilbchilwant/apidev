package mas.customer.plan;

import jade.core.AID;
import jade.core.behaviours.Behaviour;
import jade.lang.acl.ACLMessage;

import java.io.IOException;

import com.sun.xml.internal.bind.v2.model.core.ID;

import mas.blackboard.MessageIds;
import mas.customer.basicCapability;
import mas.job.job;
import bdi4jade.core.BeliefBase;
import bdi4jade.plan.PlanBody;
import bdi4jade.plan.PlanInstance;
import bdi4jade.plan.PlanInstance.EndState;

public class DispatchJobPlan extends Behaviour implements PlanBody{

	private static final long serialVersionUID = 1L;
//	private JobGenerator jGen;
	private BeliefBase bfBase;
	private job jobToDispatch;
	private AID bba;

	public DispatchJobPlan(job j){
		this.jobToDispatch = j;
	}
	
	@Override
	public EndState getEndState() {
		return null;
	}

	@Override
	public void init(PlanInstance pInstance) {
		bfBase = pInstance.getBeliefBase();
		
		jobToDispatch = (job) bfBase
					.getBelief(basicCapability.CURR_JOB)
					.getValue();
		
		this.bba = (AID) bfBase
					.getBelief(basicCapability.blackAgent)
					.getValue();
	}

	/**
	 *  send the generated job to blackboard agent by a FIPA-CFP message
	 */
	@Override
	public void action() {
		
		try {
			ACLMessage msg = new ACLMessage(ACLMessage.CFP);
			msg.setContentObject(jobToDispatch);
			msg.setConversationId(MessageIds.JobFromCustomer);
			msg.addReceiver(this.bba);
			myAgent.send(msg);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean done() {
		return false;
	}
}
