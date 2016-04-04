package paohaijiao.pockbox.ch03;

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
		MessageConsumer consumer=session.createConsumer(destination);
		consumer.setMessageListener(new Listenner());
		
	
	

	}

}
