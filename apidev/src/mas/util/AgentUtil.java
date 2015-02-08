package mas.util;

import java.io.IOException;
import mas.blackboard.MessageIds;
import jade.core.AID;
import jade.core.Agent;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.lang.acl.ACLMessage;

public class AgentUtil {
	public static AID bba;
	
	public static String GetAgentService(AID AgentToFind, Agent CurrentAgent) {
		DFAgentDescription dfd = new DFAgentDescription();
		ServiceDescription sd = new ServiceDescription();
		dfd.addServices(sd);
		try {

			  DFAgentDescription[] result = DFService.search(CurrentAgent,dfd);

			  AID s = null;
			  ServiceDescription sdd;
			      if ((result != null) && (result.length > 0)){
			    	  for(DFAgentDescription d : result){
						  if(d.getName().equals(AgentToFind)){
							  return ((ServiceDescription) d.getAllServices().next()).getType();
							}
			    		  /*System.out.println("#  Found : "+
			    				  d.getAllServices().toString());
			    	  		sdd = (ServiceDescription) d.getAllServices().next();
			    	  		System.out.println("# BlackBoard Found : "
			    	  				+ sdd.getType());*/
			    	  }
			      }
			  } catch (Exception fe) {
			      fe.printStackTrace();
			      System.out.println(fe);
			  }
		return null;
	}
	
	public static void register2BB(Agent a,String[] arr,AID b){
		ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
		msg.setConversationId(MessageIds.RegisterMe);
		try {
			msg.setContentObject(arr);
			msg.addReceiver(b);
			a.send(msg);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void makeZoneBB(Agent sender, String[] zones) {
		 ACLMessage msg=new ACLMessage(ACLMessage.INFORM);
			msg.setConversationId(mas.blackboard.MessageIds.RegisterMe);
			try {
				msg.setContentObject(zones);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			msg.addReceiver(findBlackboardAgent(sender));
			sender.send(msg);
		}

	public static AID findBlackboardAgent(Agent a){
		DFAgentDescription dfd = new DFAgentDescription();
		ServiceDescription sd  = new ServiceDescription();
		sd.setType(ID.Agents.Blackboard);
		dfd.addServices(sd);
	
		DFAgentDescription[] result;
		try {
			result = DFService.search(a, dfd);
			while(result.length == 0){
				//				 System.out.println(result.length + " results" );
				result = DFService.search(a, dfd);
				Thread.sleep(1000);
			} 
			if (result.length > 0) {
				//System.out.println(" " + result[0].getName() );
				return result[0].getName();
			}
			}catch (FIPAException e) {
				e.printStackTrace();
		} catch (InterruptedException e) {
				e.printStackTrace();
			}
		return null;
	}
	
	public static void subscribeToParam(Agent sender, AID bb,
					SubscriptionForm sform){
		ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
		try {
			msg.setContentObject(sform);
			msg.setConversationId(MessageIds.SubscribeParameter);
			msg.addReceiver(bb);
			sender.send(msg);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	}
