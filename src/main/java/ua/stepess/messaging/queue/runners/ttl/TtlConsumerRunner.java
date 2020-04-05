package ua.stepess.messaging.queue.runners.ttl;

import ua.stepess.messaging.queue.consumer.AbstractConsumer;
import ua.stepess.messaging.queue.consumer.ManualAckConsolePrinterConsumer;

import java.io.IOException;

import static ua.stepess.messaging.NetworkConstants.HOST;
import static ua.stepess.messaging.NetworkConstants.PORT;
import static ua.stepess.messaging.queue.Constants.ACK_QUEUE;
import static ua.stepess.messaging.queue.Constants.TTL_QUEUE;

public class TtlConsumerRunner {

    public static void main(String[] args) throws IOException {
        AbstractConsumer consumer = new ManualAckConsolePrinterConsumer(HOST,
                PORT,
                TTL_QUEUE,
                false,
                null,
                1000L);

        consumer.start();
    }
}
