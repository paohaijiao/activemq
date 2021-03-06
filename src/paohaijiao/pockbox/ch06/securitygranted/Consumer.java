package paohaijiao.pockbox.ch06.securitygranted;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.MessageConsumer;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;



public class Consumer {
	private static String brokerURL = "tcp://localhost:61616";
    private static transient ConnectionFactory factory;
    private transient static Connection connection;
    private transient static Session session;
    private static String username = "publisher";
    private static String password = "password";

	public static void main(String[] args) throws Exception {
		factory=new ActiveMQConnectionFactory(brokerURL);
		connection = factory.createConnection(username, password);
		connection.start();
		session=connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		Destination destination=session.createTopic("jobs.queen");
		MessageConsumer consumer=session.createConsumer(destination);
		consumer.setMessageListener(new Listenner());
	}

}
