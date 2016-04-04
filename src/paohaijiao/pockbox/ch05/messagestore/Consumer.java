package paohaijiao.pockbox.ch05.messagestore;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.Topic;

import org.apache.activemq.ActiveMQConnectionFactory;

public class Consumer {
	private static ActiveMQConnectionFactory factory=null;
	private static String brokeURI="tcp://localhost:61616";
	private static  Session session;
	private static Connection connection=null;
	public static void main(String[] args) throws Exception {
		factory=new ActiveMQConnectionFactory(brokeURI);
		connection = factory.createConnection();
		connection.start();
	    session =connection.createSession(false,Session.AUTO_ACKNOWLEDGE) ;
	    Destination destination=session.createTopic("STOCKS.price");
	    MessageConsumer consumer=session.createConsumer(destination);
	    consumer.setMessageListener(new Listenner());
	}

}
