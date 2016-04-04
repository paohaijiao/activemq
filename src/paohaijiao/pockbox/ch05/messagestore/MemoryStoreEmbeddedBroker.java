package paohaijiao.pockbox.ch05.messagestore;

import org.apache.activemq.broker.BrokerService;

public class MemoryStoreEmbeddedBroker {
	
	private void createEmbeddedBroker() throws Exception{
		BrokerService brokerService=new BrokerService();
		brokerService.setPersistent(false);
		brokerService.addConnector("tcp://localhost:61616");
		brokerService.start();
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
