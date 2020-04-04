package ua.stepess.messaging.queue.runners.ack;

import ua.stepess.messaging.queue.consumer.AbstractConsumer;
import ua.stepess.messaging.queue.consumer.ManualAckConsolePrinterConsumer;

import java.io.IOException;

import static ua.stepess.messaging.NetworkConstants.HOST;
import static ua.stepess.messaging.NetworkConstants.PORT;
import static ua.stepess.messaging.queue.Constants.ACK_QUEUE;

public class ConsumerRunner {

    public static void main(String[] args) throws IOException {
        AbstractConsumer consumer = new ManualAckConsolePrinterConsumer(HOST,
                PORT,
                ACK_QUEUE,
                false,
                null);

        consumer.start();
    }
}
