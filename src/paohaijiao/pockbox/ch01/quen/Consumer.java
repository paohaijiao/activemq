package paohaijiao.pockbox.ch01.quen;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.security.MessageAuthorizationPolicy;

public class Consumer {
	private ConnectionFactory factory = null;
	private static Connection connection=null;
	private static String brokerURL = "tcp://localhost:61616";
	private static Session session;

	public static void main(String[] args) throws Exception {
		ActiveMQConnectionFactory factory=new ActiveMQConnectionFactory(brokerURL);
		connection=factory.createConnection();
		connection.start();
		//1.Auto_ACKnowledge:
        //2.Client_AcKnowledge,javax.jms.Message.acknowledge()confirm.
		//3.Dups_OK_ACKnowledg 
		//4 SESSION_TRANSACTEDSESSION_TRANSACTED
		 //false start transaction
		session=connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		Destination destination=session.createQueue("jobs.stock");
		Message message=session.createObjectMessage();
		MessageConsumer consumer=session.createConsumer(destination);
		consumer.setMessageListener(new Listener("stock"));

	}

}
