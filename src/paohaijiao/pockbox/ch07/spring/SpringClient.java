package paohaijiao.pockbox.ch07.spring;

import org.apache.xbean.spring.context.FileSystemXmlApplicationContext;


public class SpringClient {

	public static void main(String[] args) {
		FileSystemXmlApplicationContext context = new FileSystemXmlApplicationContext("src/resource/activemq07/spring-client.xml");
		SpringPublisher publisher = (SpringPublisher)context.getBean("stockPublisher");
		//SpringPublisher invoke destionation jmstemplete jmstemplets could send 
		publisher.start();
	}

}
