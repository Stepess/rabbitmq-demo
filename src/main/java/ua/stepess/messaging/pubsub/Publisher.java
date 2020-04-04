package ua.stepess.messaging.pubsub;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import static ua.stepess.messaging.Utils.sleep;
import static ua.stepess.messaging.pubsub.Constants.EXCHANGE_NAME;

public class Publisher {

    public static void main(String[] args) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            channel.exchangeDeclare(EXCHANGE_NAME, "fanout");

            for (int i = 0; i < 100; i++) {
                String message = "Message#"+i;
                channel.basicPublish(EXCHANGE_NAME, "", null, message.getBytes());
                System.out.println(" [x] Sent '" + message + "'");
                sleep(1000);
            }
        }
    }

}
