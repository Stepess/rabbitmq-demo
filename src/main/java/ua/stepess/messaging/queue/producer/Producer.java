package ua.stepess.messaging.queue.producer;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeoutException;

import static ua.stepess.messaging.Utils.sleep;

public class Producer {

    private String host;
    private Integer hostPort;
    private Boolean durable;
    private Map<String, Object> queueArgs;
    protected String queueName;

    public Producer(String host, Integer hostPort, String queueName, Boolean durable, Map<String, Object> queueArgs) {
        this.host = host;
        this.hostPort = hostPort;
        this.queueName = queueName;
        this.durable = durable;
        this.queueArgs = queueArgs;
    }

    public void produce(int numberOfMessages, AMQP.BasicProperties properties) {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost(host);
        connectionFactory.setPort(hostPort);

        try(Connection connection = connectionFactory.newConnection();
            Channel channel = connection.createChannel()) {
            channel.queueDeclare(queueName, durable, false, false, queueArgs);

            for (int i = 0; i < numberOfMessages; i++) {
                String message = "Message#" + i;
                channel.basicPublish("", queueName, properties, message.getBytes());
                System.out.println("Sent '" + message + "'");
                sleep(10);
            }
        } catch (TimeoutException | IOException e) {
            e.printStackTrace();
        }
    }
}
