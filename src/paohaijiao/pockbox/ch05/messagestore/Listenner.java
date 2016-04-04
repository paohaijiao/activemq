package paohaijiao.pockbox.ch05.messagestore;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;

public class Listenner implements MessageListener {

	@Override
	public void onMessage(Message message) {
		MapMessage map =(MapMessage)message;
		try {
			boolean up=map.getBoolean("up");
			long price=map.getLong("price");
			String name=map.getString("name");
			System.out.println(name + "\t" + price+ "\t" + (up?"up":"down"));
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
