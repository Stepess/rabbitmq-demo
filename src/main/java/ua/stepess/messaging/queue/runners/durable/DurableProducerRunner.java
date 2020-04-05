package ua.stepess.messaging.queue.runners.durable;

import com.rabbitmq.client.MessageProperties;
import ua.stepess.messaging.queue.producer.Producer;

import java.io.IOException;

import static ua.stepess.messaging.NetworkConstants.HOST;
import static ua.stepess.messaging.NetworkConstants.PORT;
import static ua.stepess.messaging.queue.Constants.DURABLE_QUEUE;

public class DurableProducerRunner {

    public static void main(String[] args) throws IOException {
        Producer producer = new Producer(HOST,
                PORT,
                DURABLE_QUEUE,
                true,
                null);

        producer.produce(100, MessageProperties.PERSISTENT_TEXT_PLAIN);
    }

}
