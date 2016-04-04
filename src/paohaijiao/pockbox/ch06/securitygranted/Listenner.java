package paohaijiao.pockbox.ch06.securitygranted;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

public class Listenner implements MessageListener {

	@Override
	public void onMessage(Message messgae) {
		MapMessage map=(MapMessage)messgae;
		try {
			System.out.println("resulut:"+ map.getString("name"));
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
