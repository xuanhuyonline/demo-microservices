package s3.corp.stockservice.kafka;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import s3.corp.basedomains.dto.OrderEvent;
import s3.corp.stockservice.entity.Order;
import s3.corp.stockservice.repository.OrderRepository;

@Service
@RequiredArgsConstructor
public class OrderConsumer {
    private final OrderRepository orderRepository;

    @KafkaListener(
            topics = "${spring.kafka.topic.name}",
            groupId = "${spring.kafka.consumer.group-id}"
    )
    public void consume(OrderEvent event){
        Order order = new Order();
        order.setName(event.getOrder().getName());
        order.setQty(event.getOrder().getQty());
        order.setPrice(event.getOrder().getPrice());
        order.setUserId(event.getOrder().getUserId());
        orderRepository.save(order);
    }
}
