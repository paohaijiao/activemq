ActiveMQ提供的四种消息存储方式
ActiveMQ如何为消息消费者缓存消息
ActiveMQ同时支持上面两种方式的消息分发.另外通过配置可以支持消息的恢复–一种缓存在内存中的
中间状态的消息.ActiveMQ支持一种可插拔式的消息存储,并且提供三种方式消息存储:存储到内存,
存储到文件,以及存储到相关的数据库.
对于jdbc存储


<broker xmlns="http://activemq.apache.org/schema/core" brokerName="localhost" dataDirectory="${activemq.base}/data">
  
    <!-- The transport connectors ActiveMQ will listen to -->
    <transportConnectors>
       <transportConnector name="openwire" uri="tcp://localhost:61616" />
    </transportConnectors>
	<persistenceAdapter>
	<jdbcPersistenceAdapter  dataSource="#mysql-ds" />
	</persistenceAdapter>



  </broker>
   <bean id="mysql-ds" class="org.apache.commons.dbcp.BasicDataSource" destroy-method="close">
    <property name="driverClassName" value="com.mysql.jdbc.Driver"/>
    <property name="url" value="jdbc:mysql://localhost:3306/activemq?relaxAutoCommit=true"/>
    <property name="username" value="activemq"/>
    <property name="password" value="activemq"/>
      <!--<property name="poolPreparedStatements" value="true"/> -->
  </bean>
  
加jar
grant all privileges on *.* to 'activemq'@'%' identified by 'activemq'
activemq  xbean:file:D:/project/jmsProject/resource/activemq05/activemqjdbc.xml
mysql> show tables;
+--------------------+
| Tables_in_activemq |
+--------------------+
| activemq_acks      |
| activemq_lock      |
| activemq_msgs      |
+--------------------+
3 rows in set (0.00 sec)

