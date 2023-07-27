package s3.corp.orderservice.kafka;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import s3.corp.basedomains.dto.OrderDto;
import s3.corp.basedomains.dto.OrderEvent;

import java.util.UUID;


@Service
@Log4j2
@RequiredArgsConstructor
public class OrderProducer {
    private final NewTopic topic;
    private final KafkaTemplate<String, OrderEvent> kafkaTemplate;

    public void sendMessage(OrderEvent event){
        log.info(String.format("Order event => %s", event.toString()));

        Message<OrderEvent> message = MessageBuilder
                .withPayload(event)
                .setHeader(KafkaHeaders.TOPIC, topic.name())
                .build();
        kafkaTemplate.send(message);
    }

    public String placeOrder(OrderDto orderDto) {
        orderDto.setId(UUID.randomUUID().toString());
        OrderEvent orderEvent = new OrderEvent();
        orderEvent.setStatus("PENDING");
        orderEvent.setMessage("order status is in pending state");
        orderEvent.setOrder(orderDto);

        sendMessage(orderEvent);
        return "Order placed successfully";
    }

}
