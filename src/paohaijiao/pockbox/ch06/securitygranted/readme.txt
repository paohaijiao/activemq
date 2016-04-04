simpleauthor

activemq  xbean:file:D:/project/jmsProject/resource/activemq06/activemq-simple.xml
consumer
provider


jaas part
activemq -Djava.security.auth.login.config=D:/project/jmsProject/resource/activemq06/login.config  xbean:file:D:/project/jmsProject/resource/activemq06/activemq-jaas.xml 
run provider
run consumer

destination part
activemq -Djava.security.auth.login.config=D:/project/jmsProject/resource/activemq06/login.config  xbean:file:D:/project/jmsProject/resource/activemq06/activemq-destination.xml


