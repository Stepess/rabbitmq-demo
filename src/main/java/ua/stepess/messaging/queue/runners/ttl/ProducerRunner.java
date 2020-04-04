package ua.stepess.messaging.queue.runners.ttl;

import com.rabbitmq.client.AMQP;
import ua.stepess.messaging.queue.producer.Producer;

import java.io.IOException;

import static ua.stepess.messaging.NetworkConstants.HOST;
import static ua.stepess.messaging.NetworkConstants.PORT;
import static ua.stepess.messaging.queue.Constants.ACK_QUEUE;
import static ua.stepess.messaging.queue.Constants.TTL_QUEUE;

public class ProducerRunner {

    public static void main(String[] args) throws IOException {
        Producer producer = new Producer(HOST,
                PORT,
                TTL_QUEUE,
                false,
                null);

        AMQP.BasicProperties properties = new AMQP.BasicProperties.Builder()
                .contentType("text/plain")
                .expiration("100") // work only for one message at top of queue
                .build();

        producer.produce(100, properties);
    }

}
