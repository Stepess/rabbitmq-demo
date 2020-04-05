package ua.stepess.messaging.queue.runners.length;

import ua.stepess.messaging.queue.consumer.AbstractConsumer;
import ua.stepess.messaging.queue.consumer.ManualAckConsolePrinterConsumer;

import java.io.IOException;
import java.util.Map;

import static ua.stepess.messaging.NetworkConstants.HOST;
import static ua.stepess.messaging.NetworkConstants.PORT;
import static ua.stepess.messaging.queue.Constants.LENGTH_LIMIT_QUEUE;

public class LengthConsumerRunner {

    public static void main(String[] args) throws IOException {
        Map<String, Object> queueConfig = Map.of(
                "x-max-length", 10
        );

        AbstractConsumer consumer = new ManualAckConsolePrinterConsumer(HOST,
                PORT,
                LENGTH_LIMIT_QUEUE,
                false,
                queueConfig);

        consumer.start();
    }
}
