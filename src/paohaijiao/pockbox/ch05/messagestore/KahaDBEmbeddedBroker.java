package paohaijiao.pockbox.ch05.messagestore;

import java.io.File;
import java.io.IOException;

import org.apache.activemq.broker.BrokerService;
import org.apache.activemq.store.kahadb.KahaDBStore;

public class KahaDBEmbeddedBroker {
	private void createEmbeddedBroker() throws Exception{
		BrokerService brokerService=new BrokerService();
		KahaDBStore kahaDbStore=new KahaDBStore();
		kahaDbStore.setDirectory(new File("target/amq-in-action/kahadb"));
		kahaDbStore.setJournalMaxFileLength(1024*1204*100);
	        // small batch means more frequent and smaller writes
		kahaDbStore.setIndexWriteBatchSize(100);
	        // do the index write in a separate thread
		kahaDbStore.setEnableIndexWriteAsync(true);
		brokerService.setPersistenceAdapter(kahaDbStore);
		brokerService.addConnector("tcp://localhost:61616");
		brokerService.start();
	        
		
	}
	public static void main(String[] args) throws Exception {
		new KahaDBEmbeddedBroker().createEmbeddedBroker();
	}

}
