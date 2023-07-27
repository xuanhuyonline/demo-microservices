package s3.corp.stockservice.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderResponse {
    private Long id;
    private String name;
    private int qty;
    private double price;
    private UserDto user;
}
