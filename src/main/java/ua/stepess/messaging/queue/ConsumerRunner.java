package ua.stepess.messaging.queue;

import ua.stepess.messaging.queue.consumer.AbstractConsumer;
import ua.stepess.messaging.queue.consumer.ManualAckConsolePrinterConsumer;

import java.io.IOException;

import static ua.stepess.messaging.NetworkConstants.HOST;
import static ua.stepess.messaging.NetworkConstants.PORT;
import static ua.stepess.messaging.queue.RunnerConfig.QUEUE;
import static ua.stepess.messaging.queue.RunnerConfig.QUEUE_CONFIG;

public class ConsumerRunner {

    public static final boolean DURABLE = false;

    public static void main(String[] args) throws IOException {
        AbstractConsumer consumer = new ManualAckConsolePrinterConsumer(HOST, PORT, QUEUE, DURABLE, QUEUE_CONFIG);
        consumer.start();
    }

}
