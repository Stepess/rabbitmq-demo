package ua.stepess.messaging.queue.consumer;

import com.rabbitmq.client.Delivery;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;

import static ua.stepess.messaging.Utils.sleep;

public class ManualAckConsolePrinterConsumer extends AbstractConsumer{

    public ManualAckConsolePrinterConsumer(String host, Integer hostPort, String queueName, Boolean durable, Map<String, Object> queueArgs) {
        super(host, hostPort, queueName, false, durable, queueArgs);
    }

    @Override
    protected void handleMessage(String consumerTag, Delivery rawMessage) throws IOException {
        channel.basicQos(1);
        String message = new String(rawMessage.getBody(), StandardCharsets.UTF_8);
        System.out.println("Received '" + message + "'");
        try {
            sleep(1000);
        }
        finally {
            System.out.println("Done");
            channel.basicAck(rawMessage.getEnvelope().getDeliveryTag(), false);
        }
    }

}
