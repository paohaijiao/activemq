KahaDB是基于文件的本地数据库储存形式，虽然没有AMQ的速度快，但是它具有强扩展性，恢复的时间比AMQ短，
从5.4版本之后KahaDB做为默认的持久化方式

AMQ是一种文件存储形式，它具有写入速度快和容易恢复的特点。消息存储在一个个文件中，文件的默认大小为32M，
如果一条消息的大小超过了 32M，那么这个值必须设置大一点。当一个存储文件中的消息已经全部被消费，那么这个
文件将被标识为可删除，在下一个清除阶段，这个文件被删除。AMQ适用于ActiveMQ5.3之前的版本



测试三：

A、   把Sender类中的producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);改为producer.setDeliveryMode(Del
iveryMode.PERSISTENT);
B、   先运行Sender类，待运行完毕后，运行Receiver类
C、   在此过程中activemq数据库的activemq_msgs表中有数据生成，运行完Receiver类后，数据清除

测试四：

A、    把Sender类中的producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
改为producer.setDeliveryMode(DeliveryMode.PERSISTENT);
B、    运行Sender类
C、    重启电脑
D、    运行Receiver类，有消息被消费
结论：   
通过以上测试，可以发现，在P2P类型中当DeliveryMode设置为NON_PERSISTENCE时，消
息被保存在内存中，而当 DeliveryMode设置为PERSISTENCE时，消息保存在broker的相应的文件或者数据库中
。而且P2P中消息一旦被Consumer消 费就从broker中删除。