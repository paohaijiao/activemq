package paohaijiao.pockbox.ch07.spring;

import java.util.HashMap;

import javax.jms.Destination;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

public class SpringPublisher {
	   private Destination[] destinations;
	   private JmsTemplate template;
	   private HashMap<Destination,StockMessageCreator> creators = new HashMap<Destination,StockMessageCreator>(); 
	   public void start() {
		   sendMessage();
	    }
	   
	   
	   
	private void sendMessage() {
		  int idx = 0;
	        while (true) {
	            idx = (int)Math.round(destinations.length * Math.random());
	            if (idx < destinations.length) {
	                break;
	            }
	        }
	        Destination destination = destinations[idx];
	        template.send(destination, getStockMessageCreator(destination));
		
		
	}
	private MessageCreator getStockMessageCreator(Destination destination) {
    	if (creators.containsKey(destination)) {
    		return creators.get(destination);
    	} else {
    		StockMessageCreator creator = new StockMessageCreator(destination);
    		creators.put(destination, creator);
    		return creator;
    	}
	}



	public Destination[] getDestinations() {
		return destinations;
	}
	public void setDestinations(Destination[] destinations) {
		this.destinations = destinations;
	}
	public JmsTemplate getTemplate() {
		return template;
	}
	public void setTemplate(JmsTemplate template) {
		this.template = template;
	}

}
