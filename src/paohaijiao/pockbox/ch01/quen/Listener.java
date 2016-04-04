package paohaijiao.pockbox.ch01.quen;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

public class Listener implements MessageListener {
	private String job;
	
	public Listener(String job) {
		this.job = job;
	}

	@Override
	public void onMessage(Message message) {
		//do something here
		try {
			System.out.println(job + " id:" + ((ObjectMessage)message).getObject());
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
