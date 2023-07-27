package s3.corp.stockservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import s3.corp.stockservice.entity.Order;
import s3.corp.stockservice.exception.ResourceNotFoundException;
import s3.corp.stockservice.repository.OrderRepository;
import s3.corp.stockservice.response.OrderResponse;
import s3.corp.stockservice.response.UserDto;
import s3.corp.stockservice.service.OrderService;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final ModelMapper modelMapper;
    private final RestTemplate restTemplate;

    @Value("${user.url}")
    private String userUrl;

    @Override
    public OrderResponse getOrderById(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order not exist with id :" + id));
        UserDto userDto = restTemplate.getForObject(userUrl + "/users/{id}", UserDto.class,order.getUserId());
        OrderResponse orderResponse = modelMapper.map(order, OrderResponse.class);
        orderResponse.setUser(userDto);
        return orderResponse;
    }
}
