package ua.stepess.messaging.queue.runners.reject;

import ua.stepess.messaging.queue.consumer.AbstractConsumer;
import ua.stepess.messaging.queue.consumer.RejectConsolePrinterConsumer;

import java.io.IOException;

import static ua.stepess.messaging.NetworkConstants.HOST;
import static ua.stepess.messaging.NetworkConstants.PORT;
import static ua.stepess.messaging.queue.Constants.REJECT_QUEUE;

public class RejectConsumerRunner {

    public static void main(String[] args) throws IOException {
        AbstractConsumer consumer = new RejectConsolePrinterConsumer(HOST,
                PORT,
                REJECT_QUEUE,
                false,
                null,
                2000L);

        /*AbstractConsumer consumer = new ManualAckConsolePrinterConsumer(HOST,
                PORT,
                REJECT_QUEUE,
                false,
                null);*/

        consumer.start();
    }
}
