package s3.corp.emailservice.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Service;

@Service
public class RedisMessageSubscriber implements MessageListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(RedisMessageSubscriber.class);
    @Override
    public void onMessage(Message message, byte[] pattern) {
        String channel = new String(message.getChannel());
        //String msg = new String(message.getBody());
        LOGGER.info(String.format("Received message: " + message.toString() + " from channel: " + channel));
    }
}
