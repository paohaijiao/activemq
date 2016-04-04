package paohaijiao.pockbox.ch03;

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

	public static void main(String[] args) throws Exception {
		if (args.length == 0) {
    		System.err.println("Please define connection URI!");
    		return;
    	}
		
		String[] strings=new String[args.length];
		System.arraycopy(args, 1, strings, 0, args.length-1);
		factory=new ActiveMQConnectionFactory(args[0]);
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
