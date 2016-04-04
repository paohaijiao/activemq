1.
D:\project\jmsProject\resource\activemq04>keytool -genkey -alias broker -keyalg
RSA -keystore mybroker.ks
Enter keystore password:
Re-enter new password:
What is your first and last name?
  [Unknown]:  paohaijiao
What is the name of your organizational unit?
  [Unknown]:  Chapter 4
What is the name of your organization?
  [Unknown]:  Activemq in Action
What is the name of your City or Locality?
  [Unknown]:  chengdu
What is the name of your State or Province?
  [Unknown]:  sichuan
What is the two-letter country code for this unit?
  [Unknown]:  CA
Is CN=paohaijiao, OU=Chapter 4, O=Activemq in Action, L=chengdu, ST=sichuan, C=
A correct?
  [no]:  yes
Enter key password for <broker>
        (RETURN if same as keystore password):
Re-enter new password:
D:\project\jmsProject\resource\activemq04>

2.

D:\project\jmsProject\resource\activemq04>keytool -export -alias broker -keystor
e mybroker.ks -file mybroker_cert
Enter keystore password:
Certificate stored in file <mybroker_cert>

3.
D:\project\jmsProject\resource\activemq04>keytool -genkey -alias client -keyalg
RSA -keystore myclient.ks
Enter keystore password:
Re-enter new password:
What is your first and last name?
  [Unknown]:  paohaijiao
What is the name of your organizational unit?
  [Unknown]:  Chapter 4
What is the name of your organization?
  [Unknown]:  ActiveMQ in Action
What is the name of your City or Locality?
  [Unknown]:  chengdu
What is the name of your State or Province?
  [Unknown]:  sichuan
What is the two-letter country code for this unit?
  [Unknown]:  CA
Is CN=paohaijiao, OU=Chapter 4, O=ActiveMQ in Action, L=chengdu, ST=sichuan, C=C
A correct?
  [no]:  yes

Enter key password for <client>
        (RETURN if same as keystore password):
Re-enter new password:

4.
D:\project\jmsProject\resource\activemq04>keytool -import -alias broker -keystor
e myclient.ts -file mybroker_cert
Enter keystore password:
Re-enter new password:
Owner: CN=paohaijiao, OU=Chapter 4, O=Activemq in Action, L=chengdu, ST=sichua
 C=CA
Issuer: CN=paohaijiao, OU=Chapter 4, O=Activemq in Action, L=chengdu, ST=sichu
, C=CA
Serial number: 56dbdb0d
Valid from: Sun Mar 06 15:23:57 CST 2016 until: Sat Jun 04 15:23:57 CST 2016
Certificate fingerprints:
         MD5:  EB:02:96:8E:99:E7:93:FC:14:F7:69:26:E5:07:08:F6
         SHA1: 4D:72:01:ED:17:8F:6C:44:30:3C:CA:93:65:D6:98:F3:69:17:6F:59
         Signature algorithm name: SHA1withRSA
         Version: 3
Trust this certificate? [no]:  yes
Certificate was added to keystore


configure activemqssl.xml
<sslContext>   
    <sslContext keyStore="file:D:/project/jmsProject/resource/activemq04/mybroker.ks" keyStorePassword="test123"/>   
</sslContext>
    
# the follow error replesent password incorrect 
#Caused by: org.springframework.beans.factory.BeanCreationException: Error creati
# bean with name 'org.apache.activemq.xbean.XBeanBrokerService#0' defined in UR
#[file:D:/project/jmsProject/resource/activemq04/activemqssl.xml]: Cannot creat
</sslContext>

activemq  xbean:file:D:/project/jmsProject/resource/activemq04/activemqssl.xml
run as consumer
vm parameter
-Djavax.net.ssl.keyStore=D:/project/jmsProject/resource/activemq04/myclient.ks  
-Djavax.net.ssl.keyStorePassword=test123 
-Djavax.net.ssl.trustStore=:D:/project/jmsProject/resource/activemq04/myclient.ts 





run consumer class
run producer class
run consumer class
run producer class

