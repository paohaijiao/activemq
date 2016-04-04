package paohaijiao.pockbox.ch03.queen;

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

	public static void main(String[] args) throws Exception {
		factory=new ActiveMQConnectionFactory(brokerURL);
		connection=factory.createConnection();
		connection.start();
		session=connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		Destination destination=session.createQueue("jobs.queen");
		MessageProducer producer=session.createProducer(destination);
		ObjectMessage Message=session.createObjectMessage(0);
		producer.send(Message);
		
	
	

	}
}
