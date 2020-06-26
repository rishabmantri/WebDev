package edu.asupoly.ser422.restexample.api;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import javax.jms.*;


// This is the ActiveMQ version
public class JMSHelperActiveMQ {
    public static String jmsURL = "vm://localhost";

    public static Connection getJMSConnection() throws Exception {
	// Create a ConnectionFactory
	ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_BROKER_URL);
	return connectionFactory.createConnection();
    }

}
