package paohaijiao.pockbox.ch03.queen;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

public class Listenner implements MessageListener {

	@Override
	public void onMessage(Message messgae) {
		ObjectMessage map=(ObjectMessage)messgae;
		try {
			System.out.println("resulut:"+ ((ObjectMessage)messgae).getObject());
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
