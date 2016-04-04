package paohaijiao.pockbox.ch04.uri_http;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.MapMessage;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;

public class Producer {
    private static transient ConnectionFactory factory;
    private transient static Connection connection;
    private transient static Session session;
    //private static String uri="ssl://localhost:61617";
    private static String uri="http://localhost:8080";

	public static void main(String[] args) throws Exception {
		factory=new ActiveMQConnectionFactory(uri);
		connection=factory.createConnection();
		connection.start();
		session=connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		Destination destination=session.createTopic("job.stock");
		MessageProducer producer=session.createProducer(destination);
		MapMessage mapMessage=session.createMapMessage();
		mapMessage.setBoolean("up", true);
		mapMessage.setString("name", "wanke");
		producer.send(mapMessage);
	}
}
