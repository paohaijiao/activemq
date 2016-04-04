package paohaijiao.pockbox.ch01.quen;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;

public class Producer {
    private static String brokerURL = "tcp://localhost:61616";
    private static transient ConnectionFactory factory;
    private transient static Connection connection;
    private transient static Session session;
    private transient MessageProducer producer;
    private static int id=0;

	public static void main(String[] args) throws Exception {
		factory=new ActiveMQConnectionFactory(brokerURL);
		connection=factory.createConnection();
		connection.start();
		session=connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		Destination destination=session.createQueue("jobs.stock");
		MessageProducer producer=session.createProducer(destination);
		//
		ObjectMessage messgae=session.createObjectMessage(id++);
		producer.send(messgae);
		
		
		
		

	}

}
