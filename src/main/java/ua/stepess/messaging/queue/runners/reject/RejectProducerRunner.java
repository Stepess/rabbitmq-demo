package ua.stepess.messaging.queue.runners.reject;

import ua.stepess.messaging.queue.producer.Producer;

import java.io.IOException;

import static ua.stepess.messaging.NetworkConstants.HOST;
import static ua.stepess.messaging.NetworkConstants.PORT;
import static ua.stepess.messaging.queue.Constants.REJECT_QUEUE;

public class RejectProducerRunner {

    public static void main(String[] args) throws IOException {
        Producer producer = new Producer(HOST,
                PORT,
                REJECT_QUEUE,
                false,
                null);

        producer.produce(100, null, 1000L);
    }

}
