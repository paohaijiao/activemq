package paohaijiao.pockbox.ch14.advisory;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.AdvisoryConsumer;
import org.apache.activemq.advisory.AdvisorySupport;
import org.apache.activemq.command.ActiveMQDestination;

public class Advisory {
	protected static String brokerURL = "tcp://localhost:61616";
	protected static transient ConnectionFactory factory;
	protected transient static Connection connection;
	protected transient static Session session;

	public static void main(String[] args) throws Exception {
		ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory(brokerURL);
		connection = factory.createConnection();
		connection.start();
		session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		ActiveMQDestination destination = (ActiveMQDestination) session
				.createTopic("jobs.queen");//############1
		Destination consumerTopic =AdvisorySupport.getConsumerAdvisoryTopic(destination);
		System.out.println("Subscribing to advisory " + consumerTopic);//#####2
		MessageConsumer consumerAdvisory = session.createConsumer(consumerTopic);
		consumerAdvisory.setMessageListener(new ConsumerAdvisoryListener());
		
		
		Destination noConsumerTopic = AdvisorySupport.getNoTopicConsumersAdvisoryTopic(destination);
		System.out.println("Subscribing to advisory " + noConsumerTopic);
		MessageConsumer noConsumerAdvisory = session.createConsumer(noConsumerTopic);
		noConsumerAdvisory.setMessageListener(new NoConsumerAdvisoryListener());
		

	}

}
