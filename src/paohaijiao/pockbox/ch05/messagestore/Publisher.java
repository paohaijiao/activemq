package paohaijiao.pockbox.ch05.messagestore;

import javax.jms.Destination;

import javax.jms.MapMessage;
import javax.jms.MessageProducer;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;

public class Publisher {
	private static Session session;

	public static void main(String[] args) throws Exception {
		ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory();
		javax.jms.Connection connection = factory.createConnection();
		connection.start();
		session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

		Destination destination = session.createTopic("STOCKS.price");
		MapMessage map = session.createMapMessage();
		map.setBoolean("up", false);
		map.setLong("price", 10);
		map.setString("name", "jianshi");
		MessageProducer producer = session.createProducer(destination);
		producer.send(map);

	}

}
