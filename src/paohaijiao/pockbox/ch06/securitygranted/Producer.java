package paohaijiao.pockbox.ch06.securitygranted;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.MapMessage;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;

public class Producer {
    private static transient ConnectionFactory factory;
    private transient static Connection connection;
    private transient static Session session;
	private static String brokerURL = "tcp://localhost:61616";
    private static String username = "publisher";
    private static String password = "password";


	public static void main(String[] args) throws Exception {
		factory=new ActiveMQConnectionFactory(brokerURL);
		connection = factory.createConnection(username, password);
		connection.start();
		session=connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		Destination destination=session.createTopic("jobs.queen");
		MessageProducer producer=session.createProducer(destination);
		MapMessage Message=session.createMapMessage();
		Message.setString("name", "hello");
		producer.send(Message);
	}
}
