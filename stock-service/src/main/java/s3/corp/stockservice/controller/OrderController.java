package s3.corp.stockservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import s3.corp.stockservice.response.OrderResponse;
import s3.corp.stockservice.service.OrderService;

@RestController
@RequestMapping("stocks")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;
    @GetMapping("/{id}")
    public OrderResponse getOrderById(@PathVariable("id") Long id) {
        return orderService.getOrderById(id);
    }
}
