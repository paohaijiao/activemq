package paohaijiao.pockbox.ch04.network.staticn;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;

public class Listenner implements MessageListener {

	@Override
	public void onMessage(Message messgae) {
		MapMessage map=(MapMessage)messgae;
		try {
			String name=map.getString("name");
			boolean  up=map.getBoolean("up");
			System.out.println("stock name:"+name+"up"+(up?"up":"down"));
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
