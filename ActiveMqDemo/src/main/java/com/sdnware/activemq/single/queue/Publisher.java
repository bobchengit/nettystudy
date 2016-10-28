package com.sdnware.activemq.single.queue;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class Publisher{
	public static void main(String[] args) throws JMSException {
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://192.168.200.48:61616");
		Connection connection = connectionFactory.createConnection();
		connection.start();

		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		Destination destination = session.createQueue("myQueue");
		
		MessageProducer producer = session.createProducer(destination);
		producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);

		while(true) {
			TextMessage message = session.createTextMessage();
			message.setText("message_" + System.currentTimeMillis());
			producer.send(message);
			System.out.println("Sent message: " + message.getText());

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

//		session.close();
//		connection.stop();
//		connection.close();
	}
}
