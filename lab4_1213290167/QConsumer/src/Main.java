import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.naming.Context;
import javax.jms.*;
import java.util.*;
import javax.jms.Queue;
import javax.jms.MessageListener;
import javax.xml.soap.Text;


/**
 This simple consumer consumes a single text message on a Queue. The Queue
 is command-line argument 0. Run the corresponding QProducer to send the message.
 */
public class Main {
    public static String jmsURL = "vm://localhost";

    public static void main(String args[]) throws Exception {

        // Create a ConnectionFactory
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_BROKER_URL);
        Connection connection = connectionFactory.createConnection();
        //connection.start();

        try {
            // Connection connection = JMSHelperActiveMQ.getJMSConnection();
            connection.start();
            //connection.setExceptionListener(this);

            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Destination destination = session.createQueue("lab4log");
            MessageConsumer consumer = session.createConsumer(destination);

            while (true) {
                Message message = consumer.receive(5000);
                if (message instanceof TextMessage) {
                    TextMessage textMessage = (TextMessage) message;
                    String text = textMessage.getText();
                    System.out.println("Received: " + text);
                } else {
//		System.out.println("Received: " + message);
                }
//			TextMessage message1 = (TextMessage) e.nextElement();
//			System.out.println("Recieved [" + message1.getText() + "]");
            }



        } catch (Exception e) {
            System.out.println("Caught: " + e);
            e.printStackTrace();
        }
        connection.close();
    }
}

