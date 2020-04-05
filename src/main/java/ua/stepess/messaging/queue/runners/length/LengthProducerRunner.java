package ua.stepess.messaging.queue.runners.length;

import com.rabbitmq.client.MessageProperties;
import ua.stepess.messaging.queue.producer.Producer;

import java.io.IOException;
import java.util.Map;

import static ua.stepess.messaging.NetworkConstants.HOST;
import static ua.stepess.messaging.NetworkConstants.PORT;
import static ua.stepess.messaging.queue.Constants.LENGTH_LIMIT_QUEUE;

public class LengthProducerRunner {

    public static void main(String[] args) throws IOException {
        Map<String, Object> queueConfig = Map.of(
                "x-max-length", 10
        );

        Producer producer = new Producer(HOST,
                PORT,
                LENGTH_LIMIT_QUEUE,
                false,
                queueConfig);

        producer.produce(100, null, 10L);
    }

}
