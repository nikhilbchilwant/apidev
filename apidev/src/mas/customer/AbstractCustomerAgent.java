package mas.customer;

import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import bdi4jade.core.BDIAgent;
import bdi4jade.core.Capability;

public abstract class AbstractCustomerAgent extends BDIAgent {
	
	public static String service = "Customer";
	private static final long serialVersionUID = 1L;
	public static String main_container_ipaddress = "127.0.0.1";
	
	public void addCapability(Capability c){
		this.getRootCapability().addChild(c);
	}
	
	public void register2DF(String service){
		DFAgentDescription dfd = new DFAgentDescription();
		dfd.setName(getAID());
		ServiceDescription sd = new ServiceDescription();
		sd.setType(service);
		sd.setName(getLocalName());
		dfd.addServices(sd);
		try {
			DFService.register(this, dfd);
		} catch (FIPAException fe) {
			fe.printStackTrace();
		}
	}
	
	@Override
	protected void init() {
		super.init();
		register2DF(AbstractCustomerAgent.service);
	}
}
