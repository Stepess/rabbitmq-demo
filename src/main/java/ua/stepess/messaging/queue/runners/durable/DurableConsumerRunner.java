package ua.stepess.messaging.queue.runners.durable;

import ua.stepess.messaging.queue.consumer.AbstractConsumer;
import ua.stepess.messaging.queue.consumer.ManualAckConsolePrinterConsumer;

import java.io.IOException;

import static ua.stepess.messaging.NetworkConstants.HOST;
import static ua.stepess.messaging.NetworkConstants.PORT;
import static ua.stepess.messaging.queue.Constants.DURABLE_QUEUE;

public class DurableConsumerRunner {

    public static void main(String[] args) throws IOException {
        AbstractConsumer consumer = new ManualAckConsolePrinterConsumer(HOST,
                PORT,
                DURABLE_QUEUE,
                true,
                null,
                1000L);

        consumer.start();
    }
}
