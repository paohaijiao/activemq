package paohaijiao.pockbox.ch04.uri_tcp;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.MessageConsumer;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;



public class Consumer {
    private static transient ConnectionFactory factory;
    private transient static Connection connection;
    private transient static Session session;
    private static String uri="nio://localhost:61616";

	public static void main(String[] args) throws Exception {
		factory=new ActiveMQConnectionFactory(uri);
		connection=factory.createConnection();
		connection.start();
		session=connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		Destination destination=session.createTopic("job.stock");
		MessageConsumer consumer=session.createConsumer(destination);
		consumer.setMessageListener(new Listenner());
		
	
	

	}

}
