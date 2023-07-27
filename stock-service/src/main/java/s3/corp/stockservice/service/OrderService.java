package s3.corp.stockservice.service;

import s3.corp.stockservice.response.OrderResponse;

public interface OrderService {
    OrderResponse getOrderById(Long id);
}
