package ua.stepess.messaging.queue.runners.ack;

import ua.stepess.messaging.queue.producer.Producer;

import java.io.IOException;

import static ua.stepess.messaging.NetworkConstants.HOST;
import static ua.stepess.messaging.NetworkConstants.PORT;
import static ua.stepess.messaging.queue.Constants.ACK_QUEUE;

public class ProducerRunner {

    public static void main(String[] args) throws IOException {
        Producer producer = new Producer(HOST,
                PORT,
                ACK_QUEUE,
                false,
                null);

        producer.produce(100, null);
    }

}
