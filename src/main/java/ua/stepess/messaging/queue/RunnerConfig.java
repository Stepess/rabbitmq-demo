package ua.stepess.messaging.queue;

import java.util.Map;

import static ua.stepess.messaging.queue.Constants.QUEUE_NAME;

public interface RunnerConfig {

    String QUEUE = QUEUE_NAME;
    Map<String, Object> QUEUE_CONFIG = Map.of(
            "x-max-length", 10
    );

}
