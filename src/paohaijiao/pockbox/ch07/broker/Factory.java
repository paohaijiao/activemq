package paohaijiao.pockbox.ch07.broker;

import java.net.URI;

import org.apache.activemq.broker.BrokerFactory;
import org.apache.activemq.broker.BrokerService;

public class Factory {

	public static void main(String[] args) throws Exception {
		System.setProperty("activemq.base", System.getProperty("user.dir"));
		BrokerService broker = BrokerFactory.createBroker(new URI("xbean:D:/project/jmsProject/resource/activemq07/activemq-simple.xml"));
		broker.start();
	}

}
