package ua.stepess.messaging.queue.runners.noack;

import ua.stepess.messaging.queue.producer.Producer;

import java.io.IOException;

import static ua.stepess.messaging.NetworkConstants.HOST;
import static ua.stepess.messaging.NetworkConstants.PORT;
import static ua.stepess.messaging.queue.Constants.NO_ACK_QUEUE;

public class NoackProducerRunner {

    public static void main(String[] args) throws IOException {
        Producer producer = new Producer(HOST,
                PORT,
                NO_ACK_QUEUE,
                false,
                null);

        producer.produce(10, null, 500L);
    }

}
