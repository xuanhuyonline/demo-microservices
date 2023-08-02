package s3.corp.orderservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import s3.corp.orderservice.redis.RedisMessagePublisher;

@RestController
@RequiredArgsConstructor
@RequestMapping("/message")
public class RedisMessageController {
    private final RedisMessagePublisher messagePublisher;

    @PostMapping
    public String publishMessage(@RequestBody String message) {
        return messagePublisher.publishMessage(message);
    }
}
