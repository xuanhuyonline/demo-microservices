package s3.corp.orderservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import s3.corp.basedomains.dto.OrderDto;
import s3.corp.orderservice.kafka.OrderProducer;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderProducer orderProducer;

    @PostMapping
    public String placeOrder(@RequestBody OrderDto orderDto) {
        return orderProducer.placeOrder(orderDto);
    }
}
