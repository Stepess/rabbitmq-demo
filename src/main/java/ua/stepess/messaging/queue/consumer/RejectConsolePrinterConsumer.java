package ua.stepess.messaging.queue.consumer;

import com.rabbitmq.client.Delivery;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;

import static ua.stepess.messaging.Utils.sleep;

public class RejectConsolePrinterConsumer extends AbstractConsumer {

    public static final boolean REQUEUE = true;

    public RejectConsolePrinterConsumer(String host,
                                        Integer hostPort,
                                        String queueName,
                                        Boolean autoAck,
                                        Boolean durable,
                                        Map<String, Object> queueArgs) {
        super(host, hostPort, queueName, autoAck, durable, queueArgs);
    }

    @Override
    protected void handleMessage(String consumerTag, Delivery rawMessage) throws IOException {
        channel.basicQos(1);

        String message = new String(rawMessage.getBody(), StandardCharsets.UTF_8);
        System.out.println("Received '" + message + "'");
        try {
            sleep(1000);
        } finally {
            System.out.println("Rejecting...");
            channel.basicReject(rawMessage.getEnvelope().getDeliveryTag(), REQUEUE);
        }
    }
}
