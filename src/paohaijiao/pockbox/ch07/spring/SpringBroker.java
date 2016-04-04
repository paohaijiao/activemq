package paohaijiao.pockbox.ch07.spring;


import org.apache.xbean.spring.context.FileSystemXmlApplicationContext;


public class SpringBroker {

	public static void main(String[] args) throws Exception {
//    	if (args.length == 0) {
//    		System.err.println("Please define a configuration file!");
//    		return;
//    	}
//    	String config = args[0];
    //	System.out.println("Starting broker with the following configuration: " + config);
		System.setProperty("activemq.base", System.getProperty("user.dir"));
		FileSystemXmlApplicationContext context = new FileSystemXmlApplicationContext("src/resource/activemq07/spring-1.0.xml");
		//destine the configuration file
		//then spring's BrokerFactoryBean will invoke the configuration based on activemq-simple.xml
		paohaijiao.pockbox.ch05.messagestore.Publisher publisher = new paohaijiao.pockbox.ch05.messagestore.Publisher();

		
	}

}
