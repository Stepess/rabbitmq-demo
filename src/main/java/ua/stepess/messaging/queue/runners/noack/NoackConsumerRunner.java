package ua.stepess.messaging.queue.runners.noack;

import ua.stepess.messaging.queue.consumer.AbstractConsumer;
import ua.stepess.messaging.queue.consumer.AutoAckConsolePrinterConsumer;

import java.io.IOException;

import static ua.stepess.messaging.NetworkConstants.HOST;
import static ua.stepess.messaging.NetworkConstants.PORT;
import static ua.stepess.messaging.queue.Constants.NO_ACK_QUEUE;

public class NoackConsumerRunner {

    public static void main(String[] args) throws IOException {
        AbstractConsumer consumer = new AutoAckConsolePrinterConsumer(HOST,
                PORT,
                NO_ACK_QUEUE,
                false,
                null,
                1000L);

        consumer.start();
    }
}
