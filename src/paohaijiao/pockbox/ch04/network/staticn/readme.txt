1.broker a
   <transportConnectors>
       <transportConnector name="openwire" uri="tcp://localhost:61616" />
    </transportConnectors>
    
    <networkConnectors>
        <networkConnector uri="static:(tcp://localhost:61617)" />
    </networkConnectors>
    
2.brokerb

<transportConnectors>
       <transportConnector name="openwire" uri="tcp://localhost:61617" />
    </transportConnectors>
    
3.activemq  xbean:file:D:/project/jmsProject/resource/activemq04/brokerB.xml
4.activemq  xbean:file:D:/project/jmsProject/resource/activemq04/brokerA.xml
E:\activemq\apache-activemq-5.4.1\bin>activemq  xbean:file:D:/project/jmsProject
/resource/activemq04/activemq-multicast.xml
run producer with port 616
run consumer with port 617