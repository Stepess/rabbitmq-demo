package ua.stepess.messaging.queue;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.MessageProperties;
import ua.stepess.messaging.queue.producer.Producer;

import static ua.stepess.messaging.NetworkConstants.HOST;
import static ua.stepess.messaging.NetworkConstants.PORT;
import static ua.stepess.messaging.queue.Constants.QUEUE_NAME;

public class ProducerRunner {

    AMQP.BasicProperties durable = MessageProperties.PERSISTENT_TEXT_PLAIN;

    public static void main(String[] args) {
        AMQP.BasicProperties properties = new AMQP.BasicProperties.Builder()
                .contentType("text/plain")
                //.expiration("100") // work only for one message at top of queue
                .build();

        Producer producer = new Producer(HOST, PORT, QUEUE_NAME, false, null);
        producer.produce(1000, properties);
    }
}
