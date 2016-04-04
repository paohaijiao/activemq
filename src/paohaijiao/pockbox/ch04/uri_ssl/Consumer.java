package paohaijiao.pockbox.ch04.uri_ssl;

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
    private static String uri="ssl://localhost:61617";

	public static void main(String[] args) throws Exception {
		
//		System.setProperty("javax.net.ssl.keyStore","E:\\activemq\\apache-activemq-5.4.1\\conf\\broker.ks");
//       System.setProperty("javax.net.ssl.keyStorePassword","test123");
//        System.setProperty("javax.net.ssl.trustStore","E:\\activemq\\apache-activemq-5.4.1\\conf\\client.ts");
//        System.setProperty("javax.net.ssl.trustStorePassword","test123");  
		factory=new ActiveMQConnectionFactory(uri);
		connection=factory.createConnection();
		connection.start();
		session=connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		Destination destination=session.createTopic("job.stock");
		MessageConsumer consumer=session.createConsumer(destination);
		consumer.setMessageListener(new Listenner());
		
	
	

	}

}
