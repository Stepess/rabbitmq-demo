package ua.stepess.messaging.queue.consumer;

import com.rabbitmq.client.Delivery;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;

import static ua.stepess.messaging.Utils.sleep;

public class AutoAckConsolePrinterConsumer extends AbstractConsumer {

    public AutoAckConsolePrinterConsumer(String host, Integer hostPort, String queueName, Boolean durable, Map<String, Object> queueArgs) {
        super(host, hostPort, queueName, true, durable, queueArgs);
    }

    @Override
    protected void handleMessage(String consumerTag, Delivery delivery) throws IOException {
        String message = new String(delivery.getBody(), StandardCharsets.UTF_8);
        System.out.println("Received '" + message + "'");
        sleep(3000);
        System.out.println("Done");
    }
}
