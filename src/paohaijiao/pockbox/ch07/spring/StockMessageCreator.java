package paohaijiao.pockbox.ch07.spring;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;

import org.springframework.jms.core.MessageCreator;

public class StockMessageCreator implements MessageCreator {

	private Destination destination;

	public StockMessageCreator(Destination destination) {
		this.destination = destination;
	}

	@Override
	public Message createMessage(Session session) throws JMSException {
		MapMessage message=session.createMapMessage();
		message.setString("stock", "jinqiao");
		message.setDouble("price", 12.3);
		message.setDouble("offer", 12);
		message.setBoolean("up",true);
		return message;
	}

}
